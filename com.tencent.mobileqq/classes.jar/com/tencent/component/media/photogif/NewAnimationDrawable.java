package com.tencent.component.media.photogif;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.component.media.ILog;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.image.BitmapReference;
import com.tencent.component.media.image.IDecoder;
import com.tencent.component.media.image.ImageLoader.Options;
import com.tencent.component.media.image.ImageManager;
import com.tencent.component.media.image.ImageOptionSampleSize;
import com.tencent.component.media.utils.BitmapUtils;
import com.tencent.component.media.utils.LruCache;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class NewAnimationDrawable
  extends Drawable
  implements Animatable
{
  private static final String TAG = "NewAnimationDrawable";
  private static AtomicLong sMaxCacheSizeForAll = new AtomicLong(0L);
  private byte[] inTempStorage = new byte[16384];
  private BitmapReference mCurBitmapRef;
  private int mCurFrameIndex = -1;
  private int mCurPlayCount = 0;
  private Runnable mDecodeTask = new NewAnimationDrawable.DecodeTask(this, null);
  private Drawable mDefaultFrame;
  private long mDelayTime;
  private final Rect mDstRect = new Rect();
  private int mFrameCounts;
  private Handler mInvalidHandler;
  private volatile boolean mIsRunning;
  private LruCache<String, BitmapReference> mLruCache;
  private BitmapReference mNextBitmapRef;
  private ImageLoader.Options mOptions;
  private Map<String, BitmapFactory.Options> mOptionsMap = new HashMap();
  private final Paint mPaint = new Paint();
  private int mRepeatCount = 0;
  private int mReqHeight;
  private int mReqWidth;
  private int mTotalSize;
  private Map<String, WeakReference<NewAnimationDrawable.FrameRef>> mWeakRefCache = new HashMap();
  
  static
  {
    sMaxCacheSizeForAll.set((int)(ImageManager.getInstance().capacity() * ImageManagerEnv.g().getAnimationDrawableCacheRatio()));
    ILog localILog = ImageManagerEnv.getLogger();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cache size:");
    localStringBuilder.append(sMaxCacheSizeForAll.get());
    localILog.w("NewAnimationDrawable", new Object[] { localStringBuilder.toString() });
  }
  
  public NewAnimationDrawable(ImageLoader.Options paramOptions)
  {
    this.mOptions = ImageLoader.Options.copy(paramOptions);
    this.mInvalidHandler = new NewAnimationDrawable.1(this, Looper.getMainLooper());
    setReqWidth(this.mOptions.clipWidth);
    setReqHeight(this.mOptions.clipHeight);
    setDelayTime(this.mOptions.photoDelayTimeInMs);
    setFrameCounts(this.mOptions.photoList.size());
    this.mTotalSize = getByteCount();
    sMaxCacheSizeForAll.addAndGet(-this.mTotalSize);
    this.mLruCache = new NewAnimationDrawable.2(this, getByteCount());
  }
  
  private void clearCache()
  {
    ImageManagerEnv.getLogger().d("NewAnimationDrawable", new Object[] { "try clear cache" });
    this.mLruCache.evictAll();
  }
  
  public static int computeSampleSize(BitmapFactory.Options paramOptions, int paramInt1, int paramInt2)
  {
    ImageLoader.Options localOptions = ImageLoader.Options.obtain();
    localOptions.clipWidth = paramInt1;
    localOptions.clipHeight = paramInt2;
    localOptions.preferQuality = false;
    paramInt1 = ImageOptionSampleSize.computeSampleSize(localOptions, paramOptions.outWidth, paramOptions.outHeight);
    localOptions.recycle();
    return paramInt1;
  }
  
  @TargetApi(11)
  private BitmapReference decodeFrame(String paramString)
  {
    try
    {
      localObject1 = ImageManager.getInstance().getDecoder();
      if (!TextUtils.isEmpty(paramString))
      {
        localObject2 = getBitmapOptions(paramString);
        if (Build.VERSION.SDK_INT >= 11) {
          ((BitmapFactory.Options)localObject2).inBitmap = null;
        }
        localObject2 = ((IDecoder)localObject1).decodeImage(new File(paramString), (BitmapFactory.Options)localObject2);
        localObject1 = localObject2;
        if (localObject2 != null) {
          localObject1 = BitmapUtils.processExif((BitmapReference)localObject2, paramString);
        }
        return localObject1;
      }
    }
    catch (Throwable paramString)
    {
      Object localObject1 = ImageManagerEnv.getLogger();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("catch an exception:");
      ((StringBuilder)localObject2).append(Log.getStackTraceString(paramString));
      ((ILog)localObject1).e("NewAnimationDrawable", new Object[] { ((StringBuilder)localObject2).toString() });
      paramString = ImageManagerEnv.getLogger();
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("get from decoder:deocode failed,index=");
      ((StringBuilder)localObject1).append(this.mCurFrameIndex);
      paramString.e("NewAnimationDrawable", new Object[] { ((StringBuilder)localObject1).toString() });
    }
    return null;
  }
  
  private BitmapFactory.Options getBitmapOptions(String paramString)
  {
    BitmapFactory.Options localOptions2 = (BitmapFactory.Options)this.mOptionsMap.get(paramString);
    BitmapFactory.Options localOptions1 = localOptions2;
    if (localOptions2 == null)
    {
      localOptions1 = new BitmapFactory.Options();
      localOptions1.inJustDecodeBounds = true;
      localOptions1.inTempStorage = this.inTempStorage;
      BitmapFactory.decodeFile(paramString, localOptions1);
      localOptions1.inSampleSize = computeSampleSize(localOptions1, this.mReqWidth, this.mReqHeight);
      this.mOptionsMap.put(paramString, localOptions1);
      localOptions1.inJustDecodeBounds = false;
    }
    return localOptions1;
  }
  
  private static int getBytesPerPixel(Bitmap.Config paramConfig)
  {
    if (paramConfig == Bitmap.Config.ARGB_8888) {
      return 4;
    }
    if (paramConfig == Bitmap.Config.RGB_565) {
      return 2;
    }
    if (paramConfig == Bitmap.Config.ARGB_4444) {
      return 2;
    }
    if (paramConfig == Bitmap.Config.ALPHA_8) {}
    return 1;
  }
  
  private static int getFrameSize(BitmapFactory.Options paramOptions)
  {
    int i;
    if (paramOptions.inSampleSize > 0) {
      i = paramOptions.inSampleSize;
    } else {
      i = 1;
    }
    return paramOptions.outWidth / i * (paramOptions.outHeight / i) * getBytesPerPixel(Bitmap.Config.ARGB_8888);
  }
  
  public static boolean isSuitable(List<String> paramList, int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramList != null)
    {
      bool1 = bool2;
      if (paramList.size() > 0)
      {
        Object localObject = (String)paramList.get(0);
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile((String)localObject, localOptions);
        localOptions.inSampleSize = computeSampleSize(localOptions, paramInt1, paramInt2);
        paramInt1 = getFrameSize(localOptions) * paramList.size();
        paramList = ImageManagerEnv.getLogger();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("estimate totalSize:");
        ((StringBuilder)localObject).append(paramInt1);
        paramList.w("NewAnimationDrawable", new Object[] { ((StringBuilder)localObject).toString() });
        ImageManagerEnv.g().reportAnimationDrawableSize(paramInt1 / 1024);
        bool1 = bool2;
        if (paramInt1 < sMaxCacheSizeForAll.get()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  private void loadNextBitmap()
  {
    try
    {
      if (canAnimate())
      {
        if (this.mCurFrameIndex == this.mFrameCounts - 1) {
          this.mCurPlayCount += 1;
        }
        this.mCurFrameIndex = ((this.mCurFrameIndex + 1) % this.mFrameCounts);
      }
      if ((this.mIsRunning) && ((this.mRepeatCount == 0) || (this.mCurPlayCount < this.mRepeatCount)))
      {
        ILog localILog = ImageManagerEnv.getLogger();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("loadNextBitmap:");
        localStringBuilder.append(this);
        localStringBuilder.append(",delay:");
        localStringBuilder.append(this.mDelayTime);
        localStringBuilder.append(",frameIndex:");
        localStringBuilder.append(this.mCurFrameIndex);
        localILog.d("NewAnimationDrawable", new Object[] { localStringBuilder.toString() });
        ImageManager.post(this.mDecodeTask, true);
      }
      return;
    }
    finally {}
  }
  
  private void rebuildCache()
  {
    ImageManagerEnv.getLogger().d("NewAnimationDrawable", new Object[] { "try rebuild cache from weakRef" });
    int i = 0;
    while (i < this.mFrameCounts)
    {
      String str = (String)this.mOptions.photoList.get(i);
      Object localObject = (WeakReference)this.mWeakRefCache.get(str);
      if (localObject != null)
      {
        localObject = (NewAnimationDrawable.FrameRef)((WeakReference)localObject).get();
        if ((localObject != null) && (((NewAnimationDrawable.FrameRef)localObject).mBmpRef.getBitmap().getGenerationId() == ((NewAnimationDrawable.FrameRef)localObject).mBmpGenerationId))
        {
          this.mLruCache.put(str, ((NewAnimationDrawable.FrameRef)localObject).mBmpRef);
          ImageManagerEnv.getLogger().d("NewAnimationDrawable", new Object[] { "get one from weakRef" });
        }
      }
      i += 1;
    }
  }
  
  private void reset()
  {
    ImageManagerEnv.getLogger().d("NewAnimationDrawable", new Object[] { " reset" });
    this.mIsRunning = false;
    this.mCurPlayCount = 0;
    this.mCurFrameIndex = -1;
    this.mCurBitmapRef = null;
    this.mNextBitmapRef = null;
  }
  
  public boolean canAnimate()
  {
    return ImageManagerEnv.g().shouldPlayPhotoGif();
  }
  
  public void draw(Canvas paramCanvas)
  {
    Object localObject = this.mCurBitmapRef;
    if ((localObject != null) && (!((BitmapReference)localObject).isRecycled()))
    {
      paramCanvas.drawBitmap(this.mCurBitmapRef.getBitmap(), null, getBounds(), this.mPaint);
      paramCanvas = ImageManagerEnv.getLogger();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("animation NewAnimationDrawable draw  currentBitmap != null ,frameIndex:");
      ((StringBuilder)localObject).append(this.mCurFrameIndex);
      paramCanvas.d("NewAnimationDrawable", new Object[] { ((StringBuilder)localObject).toString() });
    }
    else
    {
      localObject = this.mDefaultFrame;
      if (localObject != null)
      {
        ((Drawable)localObject).setBounds(getBounds());
        this.mDefaultFrame.draw(paramCanvas);
        paramCanvas = ImageManagerEnv.getLogger();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("animation NewAnimationDrawable draw  currentBitmap = null ,frameIndex:");
        ((StringBuilder)localObject).append(this.mCurFrameIndex);
        paramCanvas.d("NewAnimationDrawable", new Object[] { ((StringBuilder)localObject).toString() });
      }
      else
      {
        paramCanvas.drawRect(this.mDstRect, this.mPaint);
      }
    }
    if (this.mIsRunning) {
      loadNextBitmap();
    }
  }
  
  protected void finalize()
  {
    super.finalize();
    try
    {
      sMaxCacheSizeForAll.addAndGet(getByteCount());
      return;
    }
    catch (Throwable localThrowable)
    {
      ILog localILog = ImageManagerEnv.getLogger();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("catch an exception:");
      localStringBuilder.append(Log.getStackTraceString(localThrowable));
      localILog.e("NewAnimationDrawable", new Object[] { localStringBuilder.toString() });
    }
  }
  
  public int getByteCount()
  {
    if (this.mTotalSize == 0)
    {
      double d = getFrameSize(getBitmapOptions((String)this.mOptions.photoList.get(0))) * this.mFrameCounts;
      Double.isNaN(d);
      this.mTotalSize = ((int)(d * 1.1D));
    }
    return this.mTotalSize;
  }
  
  public int getIntrinsicHeight()
  {
    Object localObject = this.mCurBitmapRef;
    if (localObject != null) {
      return ((BitmapReference)localObject).getHeight();
    }
    localObject = this.mDefaultFrame;
    if (localObject != null) {
      return ((Drawable)localObject).getIntrinsicHeight();
    }
    return this.mOptions.clipHeight;
  }
  
  public int getIntrinsicWidth()
  {
    Object localObject = this.mCurBitmapRef;
    if (localObject != null) {
      return ((BitmapReference)localObject).getWidth();
    }
    localObject = this.mDefaultFrame;
    if (localObject != null) {
      return ((Drawable)localObject).getIntrinsicWidth();
    }
    return this.mOptions.clipWidth;
  }
  
  public int getOpacity()
  {
    return -2;
  }
  
  public boolean isRunning()
  {
    try
    {
      boolean bool = this.mIsRunning;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    this.mDstRect.set(paramRect);
  }
  
  public void setAlpha(int paramInt)
  {
    this.mPaint.setAlpha(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.mPaint.setColorFilter(paramColorFilter);
  }
  
  public void setDefaultFrame(Drawable paramDrawable)
  {
    this.mDefaultFrame = paramDrawable;
  }
  
  public void setDelayTime(long paramLong)
  {
    this.mDelayTime = paramLong;
  }
  
  public void setFrameCounts(int paramInt)
  {
    this.mFrameCounts = paramInt;
  }
  
  public void setReqHeight(int paramInt)
  {
    this.mReqHeight = paramInt;
  }
  
  public void setReqWidth(int paramInt)
  {
    this.mReqWidth = paramInt;
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = super.setVisible(paramBoolean1, paramBoolean2);
    if (paramBoolean1)
    {
      if (paramBoolean2) {
        reset();
      }
      start();
      return bool;
    }
    if (bool) {
      stop();
    }
    return bool;
  }
  
  public void start()
  {
    try
    {
      if (!this.mIsRunning)
      {
        if (this.mLruCache.size() == 0) {
          rebuildCache();
        }
        if (this.mInvalidHandler.hasMessages(0)) {
          this.mInvalidHandler.removeMessages(0);
        }
        this.mIsRunning = true;
        loadNextBitmap();
        ILog localILog = ImageManagerEnv.getLogger();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("--start:");
        localStringBuilder.append(this.mCurFrameIndex);
        localILog.d("NewAnimationDrawable", new Object[] { localStringBuilder.toString() });
      }
      return;
    }
    finally {}
  }
  
  public void stop()
  {
    try
    {
      this.mIsRunning = false;
      clearCache();
      ILog localILog = ImageManagerEnv.getLogger();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("--stop:");
      localStringBuilder.append(this.mCurFrameIndex);
      localILog.d("NewAnimationDrawable", new Object[] { localStringBuilder.toString() });
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.media.photogif.NewAnimationDrawable
 * JD-Core Version:    0.7.0.1
 */
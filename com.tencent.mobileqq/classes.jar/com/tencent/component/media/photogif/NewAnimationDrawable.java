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
    ImageManagerEnv.getLogger().w("NewAnimationDrawable", new Object[] { "cache size:" + sMaxCacheSizeForAll.get() });
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
      Object localObject1 = ImageManager.getInstance().getDecoder();
      if (!TextUtils.isEmpty(paramString))
      {
        Object localObject2 = getBitmapOptions(paramString);
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
      ImageManagerEnv.getLogger().e("NewAnimationDrawable", new Object[] { "catch an exception:" + Log.getStackTraceString(paramString) });
      ImageManagerEnv.getLogger().e("NewAnimationDrawable", new Object[] { "get from decoder:deocode failed,index=" + this.mCurFrameIndex });
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
    int j = 2;
    int i;
    if (paramConfig == Bitmap.Config.ARGB_8888) {
      i = 4;
    }
    do
    {
      do
      {
        return i;
        i = j;
      } while (paramConfig == Bitmap.Config.RGB_565);
      i = j;
    } while (paramConfig == Bitmap.Config.ARGB_4444);
    if (paramConfig == Bitmap.Config.ALPHA_8) {
      return 1;
    }
    return 1;
  }
  
  private static int getFrameSize(BitmapFactory.Options paramOptions)
  {
    if (paramOptions.inSampleSize > 0) {}
    for (int i = paramOptions.inSampleSize;; i = 1)
    {
      int j = paramOptions.outWidth / i;
      return paramOptions.outHeight / i * j * getBytesPerPixel(Bitmap.Config.ARGB_8888);
    }
  }
  
  public static boolean isSuitable(List<String> paramList, int paramInt1, int paramInt2)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      String str = (String)paramList.get(0);
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(str, localOptions);
      localOptions.inSampleSize = computeSampleSize(localOptions, paramInt1, paramInt2);
      paramInt1 = getFrameSize(localOptions) * paramList.size();
      ImageManagerEnv.getLogger().w("NewAnimationDrawable", new Object[] { "estimate totalSize:" + paramInt1 });
      ImageManagerEnv.g().reportAnimationDrawableSize(paramInt1 / 1024);
      return paramInt1 < sMaxCacheSizeForAll.get();
    }
    return false;
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
        ImageManagerEnv.getLogger().d("NewAnimationDrawable", new Object[] { "loadNextBitmap:" + this + ",delay:" + this.mDelayTime + ",frameIndex:" + this.mCurFrameIndex });
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
    if ((this.mCurBitmapRef != null) && (!this.mCurBitmapRef.isRecycled()))
    {
      paramCanvas.drawBitmap(this.mCurBitmapRef.getBitmap(), null, getBounds(), this.mPaint);
      ImageManagerEnv.getLogger().d("NewAnimationDrawable", new Object[] { "animation NewAnimationDrawable draw  currentBitmap != null ,frameIndex:" + this.mCurFrameIndex });
    }
    for (;;)
    {
      if (this.mIsRunning) {
        loadNextBitmap();
      }
      return;
      if (this.mDefaultFrame != null)
      {
        this.mDefaultFrame.setBounds(getBounds());
        this.mDefaultFrame.draw(paramCanvas);
        ImageManagerEnv.getLogger().d("NewAnimationDrawable", new Object[] { "animation NewAnimationDrawable draw  currentBitmap = null ,frameIndex:" + this.mCurFrameIndex });
      }
      else
      {
        paramCanvas.drawRect(this.mDstRect, this.mPaint);
      }
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
      ImageManagerEnv.getLogger().e("NewAnimationDrawable", new Object[] { "catch an exception:" + Log.getStackTraceString(localThrowable) });
    }
  }
  
  public int getByteCount()
  {
    if (this.mTotalSize == 0) {
      this.mTotalSize = ((int)(getFrameSize(getBitmapOptions((String)this.mOptions.photoList.get(0))) * this.mFrameCounts * 1.1D));
    }
    return this.mTotalSize;
  }
  
  public int getIntrinsicHeight()
  {
    if (this.mCurBitmapRef != null) {
      return this.mCurBitmapRef.getHeight();
    }
    if (this.mDefaultFrame != null) {
      return this.mDefaultFrame.getIntrinsicHeight();
    }
    return this.mOptions.clipHeight;
  }
  
  public int getIntrinsicWidth()
  {
    if (this.mCurBitmapRef != null) {
      return this.mCurBitmapRef.getWidth();
    }
    if (this.mDefaultFrame != null) {
      return this.mDefaultFrame.getIntrinsicWidth();
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
    }
    while (!bool) {
      return bool;
    }
    stop();
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
        ImageManagerEnv.getLogger().d("NewAnimationDrawable", new Object[] { "--start:" + this.mCurFrameIndex });
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
      ImageManagerEnv.getLogger().d("NewAnimationDrawable", new Object[] { "--stop:" + this.mCurFrameIndex });
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.component.media.photogif.NewAnimationDrawable
 * JD-Core Version:    0.7.0.1
 */
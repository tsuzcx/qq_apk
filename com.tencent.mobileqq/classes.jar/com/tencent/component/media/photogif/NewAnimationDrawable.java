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
import piv;
import piw;
import pix;
import piy;

public class NewAnimationDrawable
  extends Drawable
  implements Animatable
{
  private static AtomicLong jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong = new AtomicLong(0L);
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private final Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private BitmapReference jdField_a_of_type_ComTencentComponentMediaImageBitmapReference;
  private ImageLoader.Options jdField_a_of_type_ComTencentComponentMediaImageImageLoader$Options;
  private LruCache jdField_a_of_type_ComTencentComponentMediaUtilsLruCache;
  private Runnable jdField_a_of_type_JavaLangRunnable = new pix(this, null);
  private Map jdField_a_of_type_JavaUtilMap = new HashMap();
  private volatile boolean jdField_a_of_type_Boolean;
  private byte[] jdField_a_of_type_ArrayOfByte = new byte[16384];
  private int jdField_b_of_type_Int = -1;
  private BitmapReference jdField_b_of_type_ComTencentComponentMediaImageBitmapReference;
  private Map jdField_b_of_type_JavaUtilMap = new HashMap();
  private int c = 0;
  private int d = 0;
  private int e;
  private int f;
  private int g;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.set((int)(ImageManager.getInstance().capacity() * ImageManagerEnv.g().getAnimationDrawableCacheRatio()));
    ImageManagerEnv.getLogger().w("NewAnimationDrawable", new Object[] { "cache size:" + jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.get() });
  }
  
  public NewAnimationDrawable(ImageLoader.Options paramOptions)
  {
    this.jdField_a_of_type_ComTencentComponentMediaImageImageLoader$Options = ImageLoader.Options.copy(paramOptions);
    this.jdField_a_of_type_AndroidOsHandler = new piv(this, Looper.getMainLooper());
    setReqWidth(this.jdField_a_of_type_ComTencentComponentMediaImageImageLoader$Options.clipWidth);
    setReqHeight(this.jdField_a_of_type_ComTencentComponentMediaImageImageLoader$Options.clipHeight);
    setDelayTime(this.jdField_a_of_type_ComTencentComponentMediaImageImageLoader$Options.photoDelayTimeInMs);
    setFrameCounts(this.jdField_a_of_type_ComTencentComponentMediaImageImageLoader$Options.photoList.size());
    this.g = getByteCount();
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.addAndGet(-this.g);
    this.jdField_a_of_type_ComTencentComponentMediaUtilsLruCache = new piw(this, getByteCount());
  }
  
  private static int a(Bitmap.Config paramConfig)
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
  
  private static int a(BitmapFactory.Options paramOptions)
  {
    if (paramOptions.inSampleSize > 0) {}
    for (int i = paramOptions.inSampleSize;; i = 1)
    {
      int j = paramOptions.outWidth / i;
      return paramOptions.outHeight / i * j * a(Bitmap.Config.ARGB_8888);
    }
  }
  
  private BitmapFactory.Options a(String paramString)
  {
    BitmapFactory.Options localOptions2 = (BitmapFactory.Options)this.jdField_a_of_type_JavaUtilMap.get(paramString);
    BitmapFactory.Options localOptions1 = localOptions2;
    if (localOptions2 == null)
    {
      localOptions1 = new BitmapFactory.Options();
      localOptions1.inJustDecodeBounds = true;
      localOptions1.inTempStorage = this.jdField_a_of_type_ArrayOfByte;
      BitmapFactory.decodeFile(paramString, localOptions1);
      localOptions1.inSampleSize = computeSampleSize(localOptions1, this.e, this.f);
      this.jdField_a_of_type_JavaUtilMap.put(paramString, localOptions1);
      localOptions1.inJustDecodeBounds = false;
    }
    return localOptions1;
  }
  
  @TargetApi(11)
  private BitmapReference a(String paramString)
  {
    try
    {
      Object localObject1 = ImageManager.getInstance().getDecoder();
      if (!TextUtils.isEmpty(paramString))
      {
        Object localObject2 = a(paramString);
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
      ImageManagerEnv.getLogger().e("NewAnimationDrawable", new Object[] { "get from decoder:deocode failed,index=" + this.jdField_b_of_type_Int });
    }
    return null;
  }
  
  private void a()
  {
    try
    {
      if (canAnimate())
      {
        if (this.jdField_b_of_type_Int == this.jdField_a_of_type_Int - 1) {
          this.d += 1;
        }
        this.jdField_b_of_type_Int = ((this.jdField_b_of_type_Int + 1) % this.jdField_a_of_type_Int);
      }
      if ((this.jdField_a_of_type_Boolean) && ((this.c == 0) || (this.d < this.c)))
      {
        ImageManagerEnv.getLogger().d("NewAnimationDrawable", new Object[] { "loadNextBitmap:" + this + ",delay:" + this.jdField_a_of_type_Long + ",frameIndex:" + this.jdField_b_of_type_Int });
        ImageManager.post(this.jdField_a_of_type_JavaLangRunnable, true);
      }
      return;
    }
    finally {}
  }
  
  private void b()
  {
    ImageManagerEnv.getLogger().d("NewAnimationDrawable", new Object[] { " reset" });
    this.jdField_a_of_type_Boolean = false;
    this.d = 0;
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_ComTencentComponentMediaImageBitmapReference = null;
    this.jdField_b_of_type_ComTencentComponentMediaImageBitmapReference = null;
  }
  
  private void c()
  {
    ImageManagerEnv.getLogger().d("NewAnimationDrawable", new Object[] { "try clear cache" });
    this.jdField_a_of_type_ComTencentComponentMediaUtilsLruCache.evictAll();
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
  
  private void d()
  {
    ImageManagerEnv.getLogger().d("NewAnimationDrawable", new Object[] { "try rebuild cache from weakRef" });
    int i = 0;
    while (i < this.jdField_a_of_type_Int)
    {
      String str = (String)this.jdField_a_of_type_ComTencentComponentMediaImageImageLoader$Options.photoList.get(i);
      Object localObject = (WeakReference)this.jdField_b_of_type_JavaUtilMap.get(str);
      if (localObject != null)
      {
        localObject = (piy)((WeakReference)localObject).get();
        if ((localObject != null) && (((piy)localObject).jdField_a_of_type_ComTencentComponentMediaImageBitmapReference.getBitmap().getGenerationId() == ((piy)localObject).jdField_a_of_type_Int))
        {
          this.jdField_a_of_type_ComTencentComponentMediaUtilsLruCache.put(str, ((piy)localObject).jdField_a_of_type_ComTencentComponentMediaImageBitmapReference);
          ImageManagerEnv.getLogger().d("NewAnimationDrawable", new Object[] { "get one from weakRef" });
        }
      }
      i += 1;
    }
  }
  
  public static boolean isSuitable(List paramList, int paramInt1, int paramInt2)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      String str = (String)paramList.get(0);
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(str, localOptions);
      localOptions.inSampleSize = computeSampleSize(localOptions, paramInt1, paramInt2);
      paramInt1 = a(localOptions) * paramList.size();
      ImageManagerEnv.getLogger().w("NewAnimationDrawable", new Object[] { "estimate totalSize:" + paramInt1 });
      ImageManagerEnv.g().reportAnimationDrawableSize(paramInt1 / 1024);
      return paramInt1 < jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.get();
    }
    return false;
  }
  
  public boolean canAnimate()
  {
    return ImageManagerEnv.g().shouldPlayPhotoGif();
  }
  
  public void draw(Canvas paramCanvas)
  {
    if ((this.jdField_a_of_type_ComTencentComponentMediaImageBitmapReference != null) && (!this.jdField_a_of_type_ComTencentComponentMediaImageBitmapReference.isRecycled()))
    {
      paramCanvas.drawBitmap(this.jdField_a_of_type_ComTencentComponentMediaImageBitmapReference.getBitmap(), null, getBounds(), this.jdField_a_of_type_AndroidGraphicsPaint);
      ImageManagerEnv.getLogger().d("NewAnimationDrawable", new Object[] { "animation NewAnimationDrawable draw  currentBitmap != null ,frameIndex:" + this.jdField_b_of_type_Int });
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Boolean) {
        a();
      }
      return;
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(getBounds());
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
        ImageManagerEnv.getLogger().d("NewAnimationDrawable", new Object[] { "animation NewAnimationDrawable draw  currentBitmap = null ,frameIndex:" + this.jdField_b_of_type_Int });
      }
      else
      {
        paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
    }
  }
  
  protected void finalize()
  {
    super.finalize();
    try
    {
      jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.addAndGet(getByteCount());
      return;
    }
    catch (Throwable localThrowable)
    {
      ImageManagerEnv.getLogger().e("NewAnimationDrawable", new Object[] { "catch an exception:" + Log.getStackTraceString(localThrowable) });
    }
  }
  
  public int getByteCount()
  {
    if (this.g == 0) {
      this.g = ((int)(a(a((String)this.jdField_a_of_type_ComTencentComponentMediaImageImageLoader$Options.photoList.get(0))) * this.jdField_a_of_type_Int * 1.1D));
    }
    return this.g;
  }
  
  public int getIntrinsicHeight()
  {
    if (this.jdField_a_of_type_ComTencentComponentMediaImageBitmapReference != null) {
      return this.jdField_a_of_type_ComTencentComponentMediaImageBitmapReference.getHeight();
    }
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
      return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight();
    }
    return this.jdField_a_of_type_ComTencentComponentMediaImageImageLoader$Options.clipHeight;
  }
  
  public int getIntrinsicWidth()
  {
    if (this.jdField_a_of_type_ComTencentComponentMediaImageBitmapReference != null) {
      return this.jdField_a_of_type_ComTencentComponentMediaImageBitmapReference.getWidth();
    }
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
      return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
    }
    return this.jdField_a_of_type_ComTencentComponentMediaImageImageLoader$Options.clipWidth;
  }
  
  public int getOpacity()
  {
    return -2;
  }
  
  public boolean isRunning()
  {
    try
    {
      boolean bool = this.jdField_a_of_type_Boolean;
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
    this.jdField_a_of_type_AndroidGraphicsRect.set(paramRect);
  }
  
  public void setAlpha(int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColorFilter(paramColorFilter);
  }
  
  public void setDefaultFrame(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
  }
  
  public void setDelayTime(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void setFrameCounts(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setReqHeight(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void setReqWidth(int paramInt)
  {
    this.e = paramInt;
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = super.setVisible(paramBoolean1, paramBoolean2);
    if (paramBoolean1)
    {
      if (paramBoolean2) {
        b();
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
      if (!this.jdField_a_of_type_Boolean)
      {
        if (this.jdField_a_of_type_ComTencentComponentMediaUtilsLruCache.size() == 0) {
          d();
        }
        if (this.jdField_a_of_type_AndroidOsHandler.hasMessages(0)) {
          this.jdField_a_of_type_AndroidOsHandler.removeMessages(0);
        }
        this.jdField_a_of_type_Boolean = true;
        a();
        ImageManagerEnv.getLogger().d("NewAnimationDrawable", new Object[] { "--start:" + this.jdField_b_of_type_Int });
      }
      return;
    }
    finally {}
  }
  
  public void stop()
  {
    try
    {
      this.jdField_a_of_type_Boolean = false;
      c();
      ImageManagerEnv.getLogger().d("NewAnimationDrawable", new Object[] { "--stop:" + this.jdField_b_of_type_Int });
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.photogif.NewAnimationDrawable
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.component.media.photogif;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import com.tencent.component.media.ILog;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.gif.GifRenderingExecutor;
import com.tencent.component.media.gif.InvalidationHandler;
import com.tencent.component.media.image.ImageKey;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.ImageLoader.Options;
import java.util.ArrayList;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import phg;
import phh;

public class QzoneAnimationDrawable
  extends Drawable
  implements Animatable
{
  public static int LOOP_INFINITE = 0;
  private volatile int jdField_a_of_type_Int = 0;
  private final Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private volatile Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private InvalidationHandler jdField_a_of_type_ComTencentComponentMediaGifInvalidationHandler;
  private ImageKey jdField_a_of_type_ComTencentComponentMediaImageImageKey;
  private ImageLoader.Options jdField_a_of_type_ComTencentComponentMediaImageImageLoader$Options;
  private QzoneAnimationDrawable.AnimationListener jdField_a_of_type_ComTencentComponentMediaPhotogifQzoneAnimationDrawable$AnimationListener;
  private ScheduledFuture jdField_a_of_type_JavaUtilConcurrentScheduledFuture;
  private ScheduledThreadPoolExecutor jdField_a_of_type_JavaUtilConcurrentScheduledThreadPoolExecutor;
  private phg jdField_a_of_type_Phg;
  private phh jdField_a_of_type_Phh;
  private volatile boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private volatile Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  private volatile boolean jdField_b_of_type_Boolean = true;
  private int jdField_c_of_type_Int;
  private Drawable jdField_c_of_type_AndroidGraphicsDrawableDrawable;
  
  public QzoneAnimationDrawable(ImageKey paramImageKey)
  {
    this.jdField_a_of_type_ComTencentComponentMediaImageImageKey = ImageKey.copy(paramImageKey);
    a();
  }
  
  public QzoneAnimationDrawable(ImageLoader.Options paramOptions)
  {
    this.jdField_a_of_type_ComTencentComponentMediaImageImageKey = ImageKey.obtain();
    this.jdField_a_of_type_ComTencentComponentMediaImageImageKey.options = ImageLoader.Options.copy(paramOptions);
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentComponentMediaImageImageLoader$Options = ImageLoader.Options.copy(this.jdField_a_of_type_ComTencentComponentMediaImageImageKey.options);
    this.jdField_a_of_type_ComTencentComponentMediaImageImageLoader$Options.needShowPhotoGifAnimation = false;
    this.jdField_a_of_type_ComTencentComponentMediaImageImageLoader$Options.photoList = null;
    this.jdField_a_of_type_JavaUtilConcurrentScheduledThreadPoolExecutor = GifRenderingExecutor.getInstance();
    this.jdField_a_of_type_ComTencentComponentMediaGifInvalidationHandler = new InvalidationHandler(this);
    this.jdField_a_of_type_Phh = new phh(this, null);
    this.jdField_a_of_type_Phg = new phg(this, null);
    this.jdField_a_of_type_AndroidGraphicsPaint.setARGB(255, 240, 240, 240);
  }
  
  private boolean a()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return false;
    }
    if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable != null) {
      if (canAnimate())
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
        this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = null;
        d();
        if (!this.jdField_a_of_type_ComTencentComponentMediaGifInvalidationHandler.hasMessages(0)) {
          this.jdField_a_of_type_ComTencentComponentMediaGifInvalidationHandler.sendEmptyMessageAtTime(0, 0L);
        }
        c();
      }
    }
    for (boolean bool = true;; bool = false)
    {
      if ((this.jdField_a_of_type_JavaUtilConcurrentScheduledFuture != null) && (!this.jdField_a_of_type_JavaUtilConcurrentScheduledFuture.isDone())) {
        this.jdField_a_of_type_JavaUtilConcurrentScheduledFuture.cancel(true);
      }
      if ((this.jdField_b_of_type_Int == LOOP_INFINITE) || (this.jdField_c_of_type_Int < this.jdField_b_of_type_Int))
      {
        this.jdField_a_of_type_JavaUtilConcurrentScheduledFuture = this.jdField_a_of_type_JavaUtilConcurrentScheduledThreadPoolExecutor.schedule(this.jdField_a_of_type_Phg, this.jdField_a_of_type_ComTencentComponentMediaImageImageKey.options.photoDelayTimeInMs, TimeUnit.MILLISECONDS);
        ImageManagerEnv.getLogger().d("QzoneAnimationDrawable", new Object[] { "------next index:" + this.jdField_a_of_type_Int });
      }
      for (;;)
      {
        return bool;
        if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
          break;
        }
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
        d();
        if (this.jdField_a_of_type_ComTencentComponentMediaGifInvalidationHandler.hasMessages(0)) {
          break;
        }
        this.jdField_a_of_type_ComTencentComponentMediaGifInvalidationHandler.sendEmptyMessageAtTime(0, 0L);
        break;
        stop();
        if (this.jdField_a_of_type_ComTencentComponentMediaPhotogifQzoneAnimationDrawable$AnimationListener != null) {
          this.jdField_a_of_type_ComTencentComponentMediaPhotogifQzoneAnimationDrawable$AnimationListener.onAnimationEnd(this);
        }
      }
    }
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_JavaUtilConcurrentScheduledFuture != null) && (!this.jdField_a_of_type_JavaUtilConcurrentScheduledFuture.isDone())) {
      this.jdField_a_of_type_JavaUtilConcurrentScheduledFuture.cancel(true);
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = null;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Int = 0;
    c();
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Int < this.jdField_a_of_type_ComTencentComponentMediaImageImageKey.options.photoList.size())
    {
      String str = (String)this.jdField_a_of_type_ComTencentComponentMediaImageImageKey.options.photoList.get(this.jdField_a_of_type_Int);
      ImageLoader.getInstance().loadImageAsync(str, this.jdField_a_of_type_Phh, this.jdField_a_of_type_ComTencentComponentMediaImageImageLoader$Options);
      ImageManagerEnv.getLogger().d("QzoneAnimationDrawable", new Object[] { "loadNextFrame:" + str + ",frameIndex:" + this.jdField_a_of_type_Int });
      if (this.jdField_a_of_type_Int == getFrameCounts() - 1) {
        this.jdField_c_of_type_Int += 1;
      }
      this.jdField_a_of_type_Int = ((this.jdField_a_of_type_Int + 1) % this.jdField_a_of_type_ComTencentComponentMediaImageImageKey.options.photoList.size());
      return;
    }
    ImageManagerEnv.getLogger().e("QzoneAnimationDrawable", new Object[] { "loadNextFrame: out of index,mNextFrameIndex:" + this.jdField_a_of_type_Int + ",photosize:" + this.jdField_a_of_type_ComTencentComponentMediaImageImageKey.options.photoList.size() });
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_Int - 1 == 0) && (this.jdField_a_of_type_ComTencentComponentMediaPhotogifQzoneAnimationDrawable$AnimationListener != null)) {
      this.jdField_a_of_type_ComTencentComponentMediaPhotogifQzoneAnimationDrawable$AnimationListener.onAnimationStart(this);
    }
    if (this.jdField_a_of_type_ComTencentComponentMediaPhotogifQzoneAnimationDrawable$AnimationListener != null) {
      this.jdField_a_of_type_ComTencentComponentMediaPhotogifQzoneAnimationDrawable$AnimationListener.onAnimationPlay(this, this.jdField_a_of_type_Int - 1);
    }
  }
  
  public boolean canAnimate()
  {
    return true;
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(getBounds());
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      return;
    }
    if (this.jdField_c_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.setBounds(getBounds());
      this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      return;
    }
    paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  public int getFrameCounts()
  {
    return this.jdField_a_of_type_ComTencentComponentMediaImageImageKey.options.photoList.size();
  }
  
  public long getFrameDuration()
  {
    return this.jdField_a_of_type_ComTencentComponentMediaImageImageKey.options.photoDelayTimeInMs;
  }
  
  public int getIntrinsicHeight()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
      return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight();
    }
    if (this.jdField_c_of_type_AndroidGraphicsDrawableDrawable != null) {
      return this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight();
    }
    return this.jdField_a_of_type_ComTencentComponentMediaImageImageLoader$Options.clipHeight;
  }
  
  public int getIntrinsicWidth()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
      return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
    }
    if (this.jdField_c_of_type_AndroidGraphicsDrawableDrawable != null) {
      return this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
    }
    return this.jdField_a_of_type_ComTencentComponentMediaImageImageLoader$Options.clipWidth;
  }
  
  public int getMinimumHeight()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
      return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getMinimumHeight();
    }
    if (this.jdField_c_of_type_AndroidGraphicsDrawableDrawable != null) {
      return this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.getMinimumHeight();
    }
    return this.jdField_a_of_type_ComTencentComponentMediaImageImageLoader$Options.clipHeight;
  }
  
  public int getMinimumWidth()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
      return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getMinimumWidth();
    }
    if (this.jdField_c_of_type_AndroidGraphicsDrawableDrawable != null) {
      return this.jdField_c_of_type_AndroidGraphicsDrawableDrawable.getMinimumWidth();
    }
    return this.jdField_a_of_type_ComTencentComponentMediaImageImageLoader$Options.clipWidth;
  }
  
  public int getOpacity()
  {
    return -2;
  }
  
  public boolean isRunning()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    this.jdField_a_of_type_AndroidGraphicsRect.set(paramRect);
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setAnimationListener(QzoneAnimationDrawable.AnimationListener paramAnimationListener)
  {
    this.jdField_a_of_type_ComTencentComponentMediaPhotogifQzoneAnimationDrawable$AnimationListener = paramAnimationListener;
  }
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
  
  public void setDrawableForDefaultFrame(Drawable paramDrawable)
  {
    this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
  }
  
  public void setRepeatCount(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = super.setVisible(paramBoolean1, paramBoolean2);
    if (paramBoolean1) {
      if (paramBoolean2) {
        b();
      }
    }
    while (!bool)
    {
      return bool;
      start();
      return bool;
    }
    stop();
    return bool;
  }
  
  public void start()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      ImageManagerEnv.getLogger().d("QzoneAnimationDrawable", new Object[] { "start: isRunning = true" });
      return;
    }
    this.jdField_a_of_type_Boolean = true;
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_b_of_type_AndroidGraphicsDrawableDrawable == null) {
      c();
    }
    if ((this.jdField_a_of_type_JavaUtilConcurrentScheduledFuture != null) && (!this.jdField_a_of_type_JavaUtilConcurrentScheduledFuture.isDone())) {
      this.jdField_a_of_type_JavaUtilConcurrentScheduledFuture.cancel(true);
    }
    this.jdField_a_of_type_JavaUtilConcurrentScheduledFuture = this.jdField_a_of_type_JavaUtilConcurrentScheduledThreadPoolExecutor.schedule(this.jdField_a_of_type_Phg, this.jdField_a_of_type_ComTencentComponentMediaImageImageKey.options.photoDelayTimeInMs, TimeUnit.MILLISECONDS);
  }
  
  public void stop()
  {
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.photogif.QzoneAnimationDrawable
 * JD-Core Version:    0.7.0.1
 */
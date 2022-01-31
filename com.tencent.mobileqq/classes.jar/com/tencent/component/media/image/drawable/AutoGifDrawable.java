package com.tencent.component.media.image.drawable;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.gif.NewGifDrawable;
import com.tencent.component.media.gif.NewGifDrawable.GifPlayListener;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.ImageLoader.Options;
import pfz;
import pga;

public class AutoGifDrawable
{
  private static String jdField_a_of_type_JavaLangString = "AutoGifDrawable";
  Context jdField_a_of_type_AndroidContentContext;
  private Drawable.Callback jdField_a_of_type_AndroidGraphicsDrawableDrawable$Callback = new pfz(this);
  public NewGifDrawable a;
  public AutoGifDrawable.AutoGifCallback a;
  public AutoGifDrawable.GifDownloadCallBackListener a;
  pga jdField_a_of_type_Pga = new pga(this, null);
  
  public static AutoGifDrawable newAutoGifDrawable()
  {
    return new AutoGifDrawable();
  }
  
  public boolean draw(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDrawable != null)
    {
      this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDrawable.setCallback(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable$Callback);
      this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDrawable.setBounds(0, 0, paramInt1, paramInt2);
      this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDrawable.draw(paramCanvas);
      bool = true;
    }
    return bool;
  }
  
  public NewGifDrawable.GifPlayListener getGifPlayListener()
  {
    if (this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDrawable != null) {
      return this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDrawable.getGifPlayListener();
    }
    return null;
  }
  
  public int getLoopCount()
  {
    if (this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDrawable != null) {
      this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDrawable.getLoopCount();
    }
    return 0;
  }
  
  public Drawable getRealDrawable()
  {
    if (this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDrawable != null) {
      return this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDrawable;
    }
    return this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDrawable;
  }
  
  public void init(String paramString, ImageLoader.Options paramOptions, Context paramContext, AutoGifDrawable.AutoGifCallback paramAutoGifCallback)
  {
    init(paramString, paramOptions, paramContext, paramAutoGifCallback, null);
  }
  
  public void init(String paramString, ImageLoader.Options paramOptions, Context paramContext, AutoGifDrawable.AutoGifCallback paramAutoGifCallback, AutoGifDrawable.GifDownloadCallBackListener paramGifDownloadCallBackListener)
  {
    if ((paramString == null) || (paramContext == null)) {}
    do
    {
      do
      {
        return;
        ImageLoader.Options localOptions = ImageLoader.Options.copy(paramOptions);
        localOptions.needShowGifAnimation = true;
        localOptions.isGifPlayWhileDownloading = ImageManagerEnv.g().isSupportGifPlaying();
        localOptions.useMainThread = true;
        localOptions.mImageType = 2;
        this.jdField_a_of_type_AndroidContentContext = paramContext;
        this.jdField_a_of_type_ComTencentComponentMediaImageDrawableAutoGifDrawable$AutoGifCallback = paramAutoGifCallback;
        this.jdField_a_of_type_ComTencentComponentMediaImageDrawableAutoGifDrawable$GifDownloadCallBackListener = paramGifDownloadCallBackListener;
        paramContext = ImageLoader.getInstance(paramContext).loadImage(paramString, this.jdField_a_of_type_Pga, localOptions);
      } while (!(paramContext instanceof NewGifDrawable));
      this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDrawable = ((NewGifDrawable)paramContext);
      this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDrawable.setCallback(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable$Callback);
    } while (paramGifDownloadCallBackListener == null);
    paramGifDownloadCallBackListener.onImageLoaded(paramString, this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDrawable, paramOptions);
  }
  
  public boolean isRunning()
  {
    if (this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDrawable != null) {
      return this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDrawable.isRunning();
    }
    return false;
  }
  
  public void recycled()
  {
    if (this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDrawable != null)
    {
      this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDrawable.setGifPlayListener(null);
      this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDrawable.setVisible(false, false);
      this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDrawable.stop();
      this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDrawable = null;
    }
    this.jdField_a_of_type_ComTencentComponentMediaImageDrawableAutoGifDrawable$GifDownloadCallBackListener = null;
    this.jdField_a_of_type_ComTencentComponentMediaImageDrawableAutoGifDrawable$AutoGifCallback = null;
    this.jdField_a_of_type_AndroidContentContext = null;
  }
  
  public void reset()
  {
    if (this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDrawable != null) {
      this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDrawable.reset();
    }
  }
  
  public void restart()
  {
    if (this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDrawable != null) {
      this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDrawable.setVisible(true, true);
    }
  }
  
  public void setGifPlayListener(NewGifDrawable.GifPlayListener paramGifPlayListener)
  {
    if (this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDrawable != null) {
      this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDrawable.setGifPlayListener(paramGifPlayListener);
    }
  }
  
  public void setLoopCount(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDrawable != null) {
      this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDrawable.setLoopCount(paramInt);
    }
  }
  
  public void setLoopModel(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDrawable != null) {
      this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDrawable.setCurrentModel(paramInt);
    }
  }
  
  public void setSpeed(float paramFloat)
  {
    if (this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDrawable != null) {
      this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDrawable.setSpeed(paramFloat);
    }
  }
  
  public void start()
  {
    if (this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDrawable != null) {
      this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDrawable.setVisible(true, false);
    }
  }
  
  public void stop()
  {
    if (this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDrawable != null)
    {
      this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDrawable.setVisible(false, false);
      this.jdField_a_of_type_ComTencentComponentMediaGifNewGifDrawable.stop();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.drawable.AutoGifDrawable
 * JD-Core Version:    0.7.0.1
 */
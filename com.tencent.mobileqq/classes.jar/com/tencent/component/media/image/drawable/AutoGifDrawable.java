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
import com.tencent.component.media.image.ImageUrl;

public class AutoGifDrawable
{
  private static String TAG = "AutoGifDrawable";
  AutoGifDrawable.AutoGifCallback autoGifCallback;
  Context context;
  AutoGifDrawable.GifDownloadCallBackListener gifDownloadCallBackListener;
  AutoGifDrawable.GifDownloadListener gifDownloadListener = new AutoGifDrawable.GifDownloadListener(this, null);
  private Drawable.Callback gifDrawableCallback = new AutoGifDrawable.1(this);
  NewGifDrawable realDrawable;
  
  public static AutoGifDrawable newAutoGifDrawable()
  {
    return new AutoGifDrawable();
  }
  
  public boolean draw(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    NewGifDrawable localNewGifDrawable = this.realDrawable;
    if (localNewGifDrawable != null)
    {
      localNewGifDrawable.setCallback(this.gifDrawableCallback);
      this.realDrawable.setBounds(0, 0, paramInt1, paramInt2);
      this.realDrawable.draw(paramCanvas);
      return true;
    }
    return false;
  }
  
  public NewGifDrawable.GifPlayListener getGifPlayListener()
  {
    NewGifDrawable localNewGifDrawable = this.realDrawable;
    if (localNewGifDrawable != null) {
      return localNewGifDrawable.getGifPlayListener();
    }
    return null;
  }
  
  public int getLoopCount()
  {
    NewGifDrawable localNewGifDrawable = this.realDrawable;
    if (localNewGifDrawable != null) {
      localNewGifDrawable.getLoopCount();
    }
    return 0;
  }
  
  public Drawable getRealDrawable()
  {
    NewGifDrawable localNewGifDrawable = this.realDrawable;
    if (localNewGifDrawable != null) {}
    return localNewGifDrawable;
  }
  
  public void init(ImageUrl paramImageUrl, ImageLoader.Options paramOptions, Context paramContext, AutoGifDrawable.AutoGifCallback paramAutoGifCallback)
  {
    init(paramImageUrl, paramOptions, paramContext, paramAutoGifCallback, null);
  }
  
  public void init(ImageUrl paramImageUrl, ImageLoader.Options paramOptions, Context paramContext, AutoGifDrawable.AutoGifCallback paramAutoGifCallback, AutoGifDrawable.GifDownloadCallBackListener paramGifDownloadCallBackListener)
  {
    if (paramImageUrl != null)
    {
      if (paramContext == null) {
        return;
      }
      ImageLoader.Options localOptions = ImageLoader.Options.copy(paramOptions);
      localOptions.needShowGifAnimation = true;
      localOptions.isGifPlayWhileDownloading = ImageManagerEnv.g().isSupportGifPlaying();
      localOptions.useMainThread = true;
      localOptions.mImageType = 2;
      this.context = paramContext;
      this.autoGifCallback = paramAutoGifCallback;
      this.gifDownloadCallBackListener = paramGifDownloadCallBackListener;
      paramContext = ImageLoader.getInstance(paramContext).loadImage(paramImageUrl, paramImageUrl.url, this.gifDownloadListener, localOptions);
      if ((paramContext instanceof NewGifDrawable))
      {
        this.realDrawable = ((NewGifDrawable)paramContext);
        this.realDrawable.setCallback(this.gifDrawableCallback);
        if (paramGifDownloadCallBackListener != null) {
          paramGifDownloadCallBackListener.onImageLoaded(paramImageUrl.url, this.realDrawable, paramOptions);
        }
      }
    }
  }
  
  public void init(String paramString, ImageLoader.Options paramOptions, Context paramContext, AutoGifDrawable.AutoGifCallback paramAutoGifCallback)
  {
    init(paramString, paramOptions, paramContext, paramAutoGifCallback, null);
  }
  
  public void init(String paramString, ImageLoader.Options paramOptions, Context paramContext, AutoGifDrawable.AutoGifCallback paramAutoGifCallback, AutoGifDrawable.GifDownloadCallBackListener paramGifDownloadCallBackListener)
  {
    if (paramString != null)
    {
      if (paramContext == null) {
        return;
      }
      ImageLoader.Options localOptions = ImageLoader.Options.copy(paramOptions);
      localOptions.needShowGifAnimation = true;
      localOptions.isGifPlayWhileDownloading = ImageManagerEnv.g().isSupportGifPlaying();
      localOptions.useMainThread = true;
      localOptions.mImageType = 2;
      this.context = paramContext;
      this.autoGifCallback = paramAutoGifCallback;
      this.gifDownloadCallBackListener = paramGifDownloadCallBackListener;
      paramContext = ImageLoader.getInstance(paramContext).loadImage(paramString, this.gifDownloadListener, localOptions);
      if ((paramContext instanceof NewGifDrawable))
      {
        this.realDrawable = ((NewGifDrawable)paramContext);
        this.realDrawable.setCallback(this.gifDrawableCallback);
        if (paramGifDownloadCallBackListener != null) {
          paramGifDownloadCallBackListener.onImageLoaded(paramString, this.realDrawable, paramOptions);
        }
      }
    }
  }
  
  public boolean isRunning()
  {
    NewGifDrawable localNewGifDrawable = this.realDrawable;
    if (localNewGifDrawable != null) {
      return localNewGifDrawable.isRunning();
    }
    return false;
  }
  
  public void recycled()
  {
    NewGifDrawable localNewGifDrawable = this.realDrawable;
    if (localNewGifDrawable != null)
    {
      localNewGifDrawable.setGifPlayListener(null);
      this.realDrawable.setVisible(false, false);
      this.realDrawable.stop();
      this.realDrawable = null;
    }
    this.gifDownloadCallBackListener = null;
    this.autoGifCallback = null;
    this.context = null;
  }
  
  public void reset()
  {
    NewGifDrawable localNewGifDrawable = this.realDrawable;
    if (localNewGifDrawable != null) {
      localNewGifDrawable.reset();
    }
  }
  
  public void restart()
  {
    NewGifDrawable localNewGifDrawable = this.realDrawable;
    if (localNewGifDrawable != null) {
      localNewGifDrawable.setVisible(true, true);
    }
  }
  
  public void setGifPlayListener(NewGifDrawable.GifPlayListener paramGifPlayListener)
  {
    NewGifDrawable localNewGifDrawable = this.realDrawable;
    if (localNewGifDrawable != null) {
      localNewGifDrawable.setGifPlayListener(paramGifPlayListener);
    }
  }
  
  public void setLoopCount(int paramInt)
  {
    NewGifDrawable localNewGifDrawable = this.realDrawable;
    if (localNewGifDrawable != null) {
      localNewGifDrawable.setLoopCount(paramInt);
    }
  }
  
  public void setLoopModel(int paramInt)
  {
    NewGifDrawable localNewGifDrawable = this.realDrawable;
    if (localNewGifDrawable != null) {
      localNewGifDrawable.setCurrentModel(paramInt);
    }
  }
  
  public void setSpeed(float paramFloat)
  {
    NewGifDrawable localNewGifDrawable = this.realDrawable;
    if (localNewGifDrawable != null) {
      localNewGifDrawable.setSpeed(paramFloat);
    }
  }
  
  public void start()
  {
    NewGifDrawable localNewGifDrawable = this.realDrawable;
    if (localNewGifDrawable != null) {
      localNewGifDrawable.setVisible(true, false);
    }
  }
  
  public void stop()
  {
    NewGifDrawable localNewGifDrawable = this.realDrawable;
    if (localNewGifDrawable != null)
    {
      localNewGifDrawable.setVisible(false, false);
      this.realDrawable.stop();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.drawable.AutoGifDrawable
 * JD-Core Version:    0.7.0.1
 */
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
    boolean bool = false;
    if (this.realDrawable != null)
    {
      this.realDrawable.setCallback(this.gifDrawableCallback);
      this.realDrawable.setBounds(0, 0, paramInt1, paramInt2);
      this.realDrawable.draw(paramCanvas);
      bool = true;
    }
    return bool;
  }
  
  public NewGifDrawable.GifPlayListener getGifPlayListener()
  {
    if (this.realDrawable != null) {
      return this.realDrawable.getGifPlayListener();
    }
    return null;
  }
  
  public int getLoopCount()
  {
    if (this.realDrawable != null) {
      this.realDrawable.getLoopCount();
    }
    return 0;
  }
  
  public Drawable getRealDrawable()
  {
    if (this.realDrawable != null) {
      return this.realDrawable;
    }
    return this.realDrawable;
  }
  
  public void init(ImageUrl paramImageUrl, ImageLoader.Options paramOptions, Context paramContext, AutoGifDrawable.AutoGifCallback paramAutoGifCallback)
  {
    init(paramImageUrl, paramOptions, paramContext, paramAutoGifCallback, null);
  }
  
  public void init(ImageUrl paramImageUrl, ImageLoader.Options paramOptions, Context paramContext, AutoGifDrawable.AutoGifCallback paramAutoGifCallback, AutoGifDrawable.GifDownloadCallBackListener paramGifDownloadCallBackListener)
  {
    if ((paramImageUrl == null) || (paramContext == null)) {}
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
        this.context = paramContext;
        this.autoGifCallback = paramAutoGifCallback;
        this.gifDownloadCallBackListener = paramGifDownloadCallBackListener;
        paramContext = ImageLoader.getInstance(paramContext).loadImage(paramImageUrl, paramImageUrl.url, this.gifDownloadListener, localOptions);
      } while (!(paramContext instanceof NewGifDrawable));
      this.realDrawable = ((NewGifDrawable)paramContext);
      this.realDrawable.setCallback(this.gifDrawableCallback);
    } while (paramGifDownloadCallBackListener == null);
    paramGifDownloadCallBackListener.onImageLoaded(paramImageUrl.url, this.realDrawable, paramOptions);
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
        this.context = paramContext;
        this.autoGifCallback = paramAutoGifCallback;
        this.gifDownloadCallBackListener = paramGifDownloadCallBackListener;
        paramContext = ImageLoader.getInstance(paramContext).loadImage(paramString, this.gifDownloadListener, localOptions);
      } while (!(paramContext instanceof NewGifDrawable));
      this.realDrawable = ((NewGifDrawable)paramContext);
      this.realDrawable.setCallback(this.gifDrawableCallback);
    } while (paramGifDownloadCallBackListener == null);
    paramGifDownloadCallBackListener.onImageLoaded(paramString, this.realDrawable, paramOptions);
  }
  
  public boolean isRunning()
  {
    if (this.realDrawable != null) {
      return this.realDrawable.isRunning();
    }
    return false;
  }
  
  public void recycled()
  {
    if (this.realDrawable != null)
    {
      this.realDrawable.setGifPlayListener(null);
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
    if (this.realDrawable != null) {
      this.realDrawable.reset();
    }
  }
  
  public void restart()
  {
    if (this.realDrawable != null) {
      this.realDrawable.setVisible(true, true);
    }
  }
  
  public void setGifPlayListener(NewGifDrawable.GifPlayListener paramGifPlayListener)
  {
    if (this.realDrawable != null) {
      this.realDrawable.setGifPlayListener(paramGifPlayListener);
    }
  }
  
  public void setLoopCount(int paramInt)
  {
    if (this.realDrawable != null) {
      this.realDrawable.setLoopCount(paramInt);
    }
  }
  
  public void setLoopModel(int paramInt)
  {
    if (this.realDrawable != null) {
      this.realDrawable.setCurrentModel(paramInt);
    }
  }
  
  public void setSpeed(float paramFloat)
  {
    if (this.realDrawable != null) {
      this.realDrawable.setSpeed(paramFloat);
    }
  }
  
  public void start()
  {
    if (this.realDrawable != null) {
      this.realDrawable.setVisible(true, false);
    }
  }
  
  public void stop()
  {
    if (this.realDrawable != null)
    {
      this.realDrawable.setVisible(false, false);
      this.realDrawable.stop();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.component.media.image.drawable.AutoGifDrawable
 * JD-Core Version:    0.7.0.1
 */
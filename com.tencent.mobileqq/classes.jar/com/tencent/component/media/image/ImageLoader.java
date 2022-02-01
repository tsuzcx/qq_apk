package com.tencent.component.media.image;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.component.media.annotation.Public;
import com.tencent.component.media.utils.BaseHandler;
import java.io.File;

public class ImageLoader
{
  public static final String AVATAR_URL_PREFIX = "avatar://";
  private static ImageLoader sInstance;
  private BaseHandler mMainHandler = new BaseHandler(Looper.getMainLooper());
  
  public ImageLoader()
  {
    ImageManager.getInstance();
  }
  
  @Public
  public static ImageLoader getInstance()
  {
    if (sInstance == null) {
      try
      {
        if (sInstance == null) {
          sInstance = new ImageLoader();
        }
      }
      finally {}
    }
    return sInstance;
  }
  
  @Public
  public static ImageLoader getInstance(Context paramContext)
  {
    if (sInstance == null) {
      try
      {
        if (sInstance == null) {
          sInstance = new ImageLoader();
        }
      }
      finally {}
    }
    return sInstance;
  }
  
  public static void onListViewIdle()
  {
    ImageManager.getInstance().onListViewIdle();
  }
  
  public void cancel() {}
  
  public void cancel(String paramString, ImageLoader.ImageLoadListener paramImageLoadListener, ImageLoader.Options paramOptions)
  {
    ImageManager.getInstance().cancel(paramString, paramImageLoadListener, paramOptions);
  }
  
  public void clear(String paramString)
  {
    ImageManager.getInstance().clear(paramString);
  }
  
  @Public
  public void clear(String paramString, ImageLoader.Options paramOptions)
  {
    ImageManager.getInstance().clear(paramString, paramOptions);
  }
  
  public void clear(boolean paramBoolean)
  {
    ImageManager.getInstance().clear(paramBoolean);
  }
  
  public void downloadImage(ImageUrl paramImageUrl, String paramString, ImageLoader.ImageDownloadListener paramImageDownloadListener, ImageLoader.Options paramOptions)
  {
    if (paramImageUrl != null)
    {
      ImageManager.getInstance().getImage(paramImageUrl, null, paramOptions, (byte)2, paramImageDownloadListener);
      return;
    }
    downloadImage(paramString, paramImageDownloadListener, paramOptions);
  }
  
  public void downloadImage(String paramString, ImageLoader.ImageDownloadListener paramImageDownloadListener, ImageLoader.Options paramOptions)
  {
    ImageManager.getInstance().getImage(paramString, null, paramOptions, (byte)2, paramImageDownloadListener);
  }
  
  public Drawable downloadImageOnly(ImageUrl paramImageUrl, String paramString, ImageLoader.ImageDownloadListener paramImageDownloadListener, ImageLoader.Options paramOptions)
  {
    if (paramImageUrl != null) {
      return ImageManager.getInstance().getImage(paramImageUrl, null, paramOptions, (byte)3, paramImageDownloadListener);
    }
    return downloadImageOnly(paramString, paramImageDownloadListener, paramOptions);
  }
  
  public Drawable downloadImageOnly(String paramString, ImageLoader.ImageDownloadListener paramImageDownloadListener, ImageLoader.Options paramOptions)
  {
    return ImageManager.getInstance().getImage(paramString, null, paramOptions, (byte)3, paramImageDownloadListener);
  }
  
  public Drawable downloadImageOnly(String paramString, ImageLoader.ImageLoadListener paramImageLoadListener, ImageLoader.ImageDownloadListener paramImageDownloadListener, ImageLoader.Options paramOptions)
  {
    return ImageManager.getInstance().getImage(paramString, paramImageLoadListener, paramOptions, (byte)3, paramImageDownloadListener);
  }
  
  public void downloadImageOnly(ImageUrl paramImageUrl, String paramString, ImageLoader.ImageDownloadListener paramImageDownloadListener)
  {
    if (paramImageUrl != null)
    {
      ImageManager.getInstance().getImage(paramImageUrl, null, null, (byte)3, paramImageDownloadListener);
      return;
    }
    downloadImageOnly(paramString, paramImageDownloadListener);
  }
  
  public void downloadImageOnly(String paramString, ImageLoader.ImageDownloadListener paramImageDownloadListener)
  {
    ImageManager.getInstance().getImage(paramString, null, null, (byte)3, paramImageDownloadListener);
  }
  
  @Public
  public File getImageFile(String paramString)
  {
    return getImageFile(paramString, null);
  }
  
  @Public
  public File getImageFile(String paramString, ImageLoader.Options paramOptions)
  {
    return ImageManager.getInstance().getImageFile(paramString, paramOptions);
  }
  
  @Public
  public File getImageFileForSuperResolution(String paramString)
  {
    return ImageManager.getInstance().getImageFileForSuperResolution(paramString);
  }
  
  @Deprecated
  @Public
  public Drawable loadImage(ImageUrl paramImageUrl, String paramString, ImageLoader.ImageLoadListener paramImageLoadListener, ImageLoader.Options paramOptions)
  {
    if (paramImageUrl != null) {
      return ImageManager.getInstance().getImage(paramImageUrl, paramImageLoadListener, paramOptions, (byte)2, null);
    }
    return loadImage(paramString, paramImageLoadListener, paramOptions);
  }
  
  public Drawable loadImage(ImageUrl paramImageUrl, String paramString, ImageLoader.Options paramOptions)
  {
    if (paramImageUrl != null) {
      return ImageManager.getInstance().getImage(paramImageUrl, null, paramOptions, (byte)0, null);
    }
    return loadImage(paramString, paramOptions);
  }
  
  @Deprecated
  @Public
  public Drawable loadImage(String paramString, ImageLoader.ImageLoadListener paramImageLoadListener)
  {
    return loadImage(paramString, paramImageLoadListener, null);
  }
  
  @Deprecated
  @Public
  public Drawable loadImage(String paramString, ImageLoader.ImageLoadListener paramImageLoadListener, ImageLoader.Options paramOptions)
  {
    return ImageManager.getInstance().getImage(paramString, paramImageLoadListener, paramOptions, (byte)2, null);
  }
  
  @Public
  public Drawable loadImage(String paramString, ImageLoader.Options paramOptions)
  {
    return ImageManager.getInstance().getImage(paramString, null, paramOptions, (byte)0, null);
  }
  
  public void loadImageAsync(ImageUrl paramImageUrl, String paramString, ImageLoader.ImageLoadListener paramImageLoadListener, ImageLoader.Options paramOptions)
  {
    Drawable localDrawable;
    if ((paramImageUrl != null) && (!TextUtils.isEmpty(paramImageUrl.url))) {
      localDrawable = ImageManager.getInstance().getImage(paramImageUrl, paramImageLoadListener, paramOptions, (byte)2, null);
    } else {
      localDrawable = ImageManager.getInstance().getImage(paramString, paramImageLoadListener, paramOptions, (byte)2, null);
    }
    if ((localDrawable != null) && (paramImageLoadListener != null))
    {
      if ((paramOptions != null) && (paramOptions.useMainThread))
      {
        this.mMainHandler.post(new ImageLoader.1(this, paramImageUrl, paramImageLoadListener, localDrawable, paramOptions, paramString));
        return;
      }
      if (paramImageUrl != null)
      {
        paramImageLoadListener.onImageLoaded(paramImageUrl.url, localDrawable, paramOptions);
        return;
      }
      paramImageLoadListener.onImageLoaded(paramString, localDrawable, paramOptions);
    }
  }
  
  @Public
  public void loadImageAsync(String paramString, ImageLoader.ImageLoadListener paramImageLoadListener)
  {
    loadImageAsync(paramString, paramImageLoadListener, null);
  }
  
  @Public
  public void loadImageAsync(String paramString, ImageLoader.ImageLoadListener paramImageLoadListener, ImageLoader.Options paramOptions)
  {
    loadImageAsync(null, paramString, paramImageLoadListener, paramOptions);
  }
  
  public Drawable loadImageDownloadOnly(ImageUrl paramImageUrl, String paramString, ImageLoader.ImageLoadListener paramImageLoadListener, ImageLoader.Options paramOptions)
  {
    if (paramImageUrl != null) {
      return ImageManager.getInstance().getImage(paramImageUrl, paramImageLoadListener, paramOptions, (byte)3, null);
    }
    return loadImageDownloadOnly(paramString, paramImageLoadListener, paramOptions);
  }
  
  public Drawable loadImageDownloadOnly(String paramString, ImageLoader.ImageLoadListener paramImageLoadListener, ImageLoader.Options paramOptions)
  {
    return ImageManager.getInstance().getImage(paramString, paramImageLoadListener, paramOptions, (byte)3, null);
  }
  
  public Drawable loadImageSync(ImageUrl paramImageUrl, String paramString, ImageLoader.ImageLoadListener paramImageLoadListener, ImageLoader.Options paramOptions)
  {
    if (paramImageUrl != null) {
      return ImageManager.getInstance().getImage(paramImageUrl, paramImageLoadListener, paramOptions, (byte)1, null);
    }
    return loadImageSync(paramString, paramImageLoadListener, paramOptions);
  }
  
  public Drawable loadImageSync(String paramString)
  {
    return loadImageSync(paramString, null);
  }
  
  public Drawable loadImageSync(String paramString, ImageLoader.ImageLoadListener paramImageLoadListener, ImageLoader.Options paramOptions)
  {
    return ImageManager.getInstance().getImage(paramString, paramImageLoadListener, paramOptions, (byte)1, null);
  }
  
  public Drawable loadImageSync(String paramString, ImageLoader.Options paramOptions)
  {
    return loadImageSync(paramString, null, paramOptions);
  }
  
  public void removeImageFile(String paramString)
  {
    removeImageFile(paramString, null);
  }
  
  public void removeImageFile(String paramString, ImageLoader.Options paramOptions)
  {
    ImageManager.getInstance().removeImageFile(paramString, paramOptions);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.ImageLoader
 * JD-Core Version:    0.7.0.1
 */
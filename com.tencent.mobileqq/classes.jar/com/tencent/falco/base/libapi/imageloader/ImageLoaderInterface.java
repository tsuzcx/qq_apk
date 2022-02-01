package com.tencent.falco.base.libapi.imageloader;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.falco.base.libapi.ServiceBaseInterface;
import java.io.File;

public abstract interface ImageLoaderInterface
  extends ServiceBaseInterface
{
  public abstract void cancel(ImageView paramImageView);
  
  public abstract void clearMemoryCache();
  
  public abstract void displayImage(String paramString, ImageView paramImageView);
  
  public abstract void displayImage(String paramString, ImageView paramImageView, int paramInt1, int paramInt2);
  
  public abstract void displayImage(String paramString, ImageView paramImageView, int paramInt1, int paramInt2, DisplayImageOptions paramDisplayImageOptions, ImageLoadingListener paramImageLoadingListener);
  
  public abstract void displayImage(String paramString, ImageView paramImageView, int paramInt1, int paramInt2, ImageLoadingListener paramImageLoadingListener);
  
  public abstract void displayImage(String paramString, ImageView paramImageView, DisplayImageOptions paramDisplayImageOptions);
  
  public abstract void displayImage(String paramString, ImageView paramImageView, DisplayImageOptions paramDisplayImageOptions, ImageLoadingListener paramImageLoadingListener);
  
  public abstract void displayImage(String paramString, ImageView paramImageView, ImageLoadingListener paramImageLoadingListener);
  
  public abstract File getDiskCache(String paramString);
  
  public abstract Bitmap getMemoryCache(String paramString);
  
  public abstract void init(String paramString, ImageOnLoadingLogListener paramImageOnLoadingLogListener);
  
  public abstract void loadImage(String paramString, int paramInt1, int paramInt2, DisplayImageOptions paramDisplayImageOptions, ImageLoadingListener paramImageLoadingListener);
  
  public abstract void loadImage(String paramString, int paramInt1, int paramInt2, ImageLoadingListener paramImageLoadingListener);
  
  public abstract void loadImage(String paramString, DisplayImageOptions paramDisplayImageOptions, ImageLoadingListener paramImageLoadingListener);
  
  public abstract void loadImage(String paramString, ImageLoadingListener paramImageLoadingListener);
  
  public abstract Bitmap loadImageSync(String paramString, DisplayImageOptions paramDisplayImageOptions);
  
  public abstract void removeDiskCache(String paramString);
  
  public abstract Bitmap removeMemoryCache(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.falco.base.libapi.imageloader.ImageLoaderInterface
 * JD-Core Version:    0.7.0.1
 */
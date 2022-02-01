package com.nostra13.universalimageloader.core.listener;

import android.graphics.Bitmap;
import android.view.View;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;

public class ImageLoadingListenerWrapper
{
  private ImageLoadingListener loadingListener;
  private ImageOnLoadingLogListener mImageOnLoadingLogListener;
  
  public ImageLoadingListenerWrapper(ImageLoadingListener paramImageLoadingListener, ImageOnLoadingLogListener paramImageOnLoadingLogListener)
  {
    this.loadingListener = paramImageLoadingListener;
    this.mImageOnLoadingLogListener = paramImageOnLoadingLogListener;
  }
  
  public void onLoadingCancelled(String paramString, View paramView, LoadedFrom paramLoadedFrom)
  {
    ImageLoadingListener localImageLoadingListener = this.loadingListener;
    if (localImageLoadingListener != null) {
      localImageLoadingListener.onLoadingCancelled(paramString, paramView);
    }
    if ((this.mImageOnLoadingLogListener != null) && (paramLoadedFrom == LoadedFrom.NETWORK)) {
      this.mImageOnLoadingLogListener.onLoadingCancelled(paramString);
    }
  }
  
  public void onLoadingComplete(String paramString, View paramView, Bitmap paramBitmap, LoadedFrom paramLoadedFrom)
  {
    ImageLoadingListener localImageLoadingListener = this.loadingListener;
    if (localImageLoadingListener != null) {
      localImageLoadingListener.onLoadingComplete(paramString, paramView, paramBitmap);
    }
    if ((this.mImageOnLoadingLogListener != null) && (paramLoadedFrom == LoadedFrom.NETWORK)) {
      this.mImageOnLoadingLogListener.onLoadingComplete(paramString);
    }
  }
  
  public void onLoadingFailed(String paramString, View paramView, FailReason paramFailReason, LoadedFrom paramLoadedFrom)
  {
    ImageLoadingListener localImageLoadingListener = this.loadingListener;
    if (localImageLoadingListener != null) {
      localImageLoadingListener.onLoadingFailed(paramString, paramView, paramFailReason);
    }
    if ((this.mImageOnLoadingLogListener != null) && (paramLoadedFrom == LoadedFrom.NETWORK)) {
      this.mImageOnLoadingLogListener.onLoadingFailed(paramString, paramFailReason);
    }
  }
  
  public void onLoadingStarted(String paramString, View paramView)
  {
    ImageLoadingListener localImageLoadingListener = this.loadingListener;
    if (localImageLoadingListener != null) {
      localImageLoadingListener.onLoadingStarted(paramString, paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.listener.ImageLoadingListenerWrapper
 * JD-Core Version:    0.7.0.1
 */
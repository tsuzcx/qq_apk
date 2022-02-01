package com.tencent.falco.base.imageloader;

import android.graphics.Bitmap;
import android.view.View;
import com.nostra13.universalimageloader.core.assist.FailReason;

class ImageLoadingListenerWrapper
  implements com.nostra13.universalimageloader.core.listener.ImageLoadingListener
{
  private com.tencent.falco.base.libapi.imageloader.ImageLoadingListener imageLoadingListener;
  
  public ImageLoadingListenerWrapper(com.tencent.falco.base.libapi.imageloader.ImageLoadingListener paramImageLoadingListener)
  {
    this.imageLoadingListener = paramImageLoadingListener;
  }
  
  public void onLoadingCancelled(String paramString, View paramView)
  {
    com.tencent.falco.base.libapi.imageloader.ImageLoadingListener localImageLoadingListener = this.imageLoadingListener;
    if (localImageLoadingListener != null) {
      localImageLoadingListener.onLoadingCancelled(paramString, paramView);
    }
  }
  
  public void onLoadingComplete(String paramString, View paramView, Bitmap paramBitmap)
  {
    com.tencent.falco.base.libapi.imageloader.ImageLoadingListener localImageLoadingListener = this.imageLoadingListener;
    if (localImageLoadingListener != null) {
      localImageLoadingListener.onLoadingComplete(paramString, paramView, paramBitmap);
    }
  }
  
  public void onLoadingFailed(String paramString, View paramView, FailReason paramFailReason)
  {
    com.tencent.falco.base.libapi.imageloader.ImageLoadingListener localImageLoadingListener = this.imageLoadingListener;
    if (localImageLoadingListener != null) {
      localImageLoadingListener.onLoadingFailed(paramString, paramView, FailReasonUtil.getFailReasonStr(paramFailReason));
    }
  }
  
  public void onLoadingStarted(String paramString, View paramView)
  {
    com.tencent.falco.base.libapi.imageloader.ImageLoadingListener localImageLoadingListener = this.imageLoadingListener;
    if (localImageLoadingListener != null) {
      localImageLoadingListener.onLoadingStarted(paramString, paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.falco.base.imageloader.ImageLoadingListenerWrapper
 * JD-Core Version:    0.7.0.1
 */
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
    if (this.imageLoadingListener != null) {
      this.imageLoadingListener.onLoadingCancelled(paramString, paramView);
    }
  }
  
  public void onLoadingComplete(String paramString, View paramView, Bitmap paramBitmap)
  {
    if (this.imageLoadingListener != null) {
      this.imageLoadingListener.onLoadingComplete(paramString, paramView, paramBitmap);
    }
  }
  
  public void onLoadingFailed(String paramString, View paramView, FailReason paramFailReason)
  {
    if (this.imageLoadingListener != null) {
      this.imageLoadingListener.onLoadingFailed(paramString, paramView, FailReasonUtil.getFailReasonStr(paramFailReason));
    }
  }
  
  public void onLoadingStarted(String paramString, View paramView)
  {
    if (this.imageLoadingListener != null) {
      this.imageLoadingListener.onLoadingStarted(paramString, paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.falco.base.imageloader.ImageLoadingListenerWrapper
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.falco.base.imageloader;

import com.nostra13.universalimageloader.core.assist.FailReason;

class ImageLoaderComponent$4
  implements com.nostra13.universalimageloader.core.listener.ImageOnLoadingLogListener
{
  ImageLoaderComponent$4(ImageLoaderComponent paramImageLoaderComponent) {}
  
  public void onLoadingCancelled(String paramString)
  {
    if (ImageLoaderComponent.access$000(this.this$0) != null) {
      ImageLoaderComponent.access$000(this.this$0).onLoadingCancelled(paramString);
    }
  }
  
  public void onLoadingComplete(String paramString)
  {
    if (ImageLoaderComponent.access$000(this.this$0) != null) {
      ImageLoaderComponent.access$000(this.this$0).onLoadingComplete(paramString);
    }
  }
  
  public void onLoadingFailed(String paramString, FailReason paramFailReason)
  {
    if (ImageLoaderComponent.access$000(this.this$0) != null) {
      ImageLoaderComponent.access$000(this.this$0).onLoadingFailed(paramString, FailReasonUtil.getFailReasonStr(paramFailReason));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.falco.base.imageloader.ImageLoaderComponent.4
 * JD-Core Version:    0.7.0.1
 */
package com.nostra13.universalimageloader.core;

import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.FailReason.FailType;
import com.nostra13.universalimageloader.core.imageaware.ImageAware;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListenerWrapper;

class LoadAndDisplayImageTask$2
  implements Runnable
{
  LoadAndDisplayImageTask$2(LoadAndDisplayImageTask paramLoadAndDisplayImageTask, FailReason.FailType paramFailType, Throwable paramThrowable) {}
  
  public void run()
  {
    if (this.this$0.options.shouldShowImageOnFail()) {
      this.this$0.imageAware.setImageDrawable(this.this$0.options.getImageOnFail(LoadAndDisplayImageTask.access$000(this.this$0).resources));
    }
    this.this$0.listener.onLoadingFailed(this.this$0.uri, this.this$0.imageAware.getWrappedView(), new FailReason(this.val$failType, this.val$failCause), LoadAndDisplayImageTask.access$100(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.LoadAndDisplayImageTask.2
 * JD-Core Version:    0.7.0.1
 */
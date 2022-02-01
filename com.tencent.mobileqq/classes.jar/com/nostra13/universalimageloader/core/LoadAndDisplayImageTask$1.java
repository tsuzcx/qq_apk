package com.nostra13.universalimageloader.core;

import com.nostra13.universalimageloader.core.imageaware.ImageAware;
import com.nostra13.universalimageloader.core.listener.ImageLoadingProgressListener;

class LoadAndDisplayImageTask$1
  implements Runnable
{
  LoadAndDisplayImageTask$1(LoadAndDisplayImageTask paramLoadAndDisplayImageTask, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    this.this$0.progressListener.onProgressUpdate(this.this$0.uri, this.this$0.imageAware.getWrappedView(), this.val$current, this.val$total);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.LoadAndDisplayImageTask.1
 * JD-Core Version:    0.7.0.1
 */
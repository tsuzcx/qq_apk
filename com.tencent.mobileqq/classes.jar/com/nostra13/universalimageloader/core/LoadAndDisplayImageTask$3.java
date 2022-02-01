package com.nostra13.universalimageloader.core;

import com.nostra13.universalimageloader.core.imageaware.ImageAware;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListenerWrapper;

class LoadAndDisplayImageTask$3
  implements Runnable
{
  LoadAndDisplayImageTask$3(LoadAndDisplayImageTask paramLoadAndDisplayImageTask) {}
  
  public void run()
  {
    this.this$0.listener.onLoadingCancelled(this.this$0.uri, this.this$0.imageAware.getWrappedView(), LoadAndDisplayImageTask.access$100(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.nostra13.universalimageloader.core.LoadAndDisplayImageTask.3
 * JD-Core Version:    0.7.0.1
 */
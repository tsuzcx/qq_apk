package com.tencent.component.media.image;

class UICallbackTask$2
  implements Runnable
{
  UICallbackTask$2(UICallbackTask paramUICallbackTask, ImageKey paramImageKey) {}
  
  public void run()
  {
    this.val$imageKey.listener.onImageCanceled(UICallbackTask.access$000(this.this$0, this.val$imageKey), this.val$imageKey.options);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.component.media.image.UICallbackTask.2
 * JD-Core Version:    0.7.0.1
 */
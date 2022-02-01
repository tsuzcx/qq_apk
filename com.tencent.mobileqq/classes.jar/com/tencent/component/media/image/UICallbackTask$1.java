package com.tencent.component.media.image;

class UICallbackTask$1
  implements Runnable
{
  UICallbackTask$1(UICallbackTask paramUICallbackTask, ImageKey paramImageKey) {}
  
  public void run()
  {
    this.val$imageKey.listener.onImageFailed(UICallbackTask.access$000(this.this$0, this.val$imageKey), this.val$imageKey.options);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.UICallbackTask.1
 * JD-Core Version:    0.7.0.1
 */
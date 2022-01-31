package com.tencent.component.media.image;

import android.graphics.drawable.Drawable;

class UICallbackTask$3
  implements Runnable
{
  UICallbackTask$3(UICallbackTask paramUICallbackTask, ImageKey paramImageKey, Drawable paramDrawable) {}
  
  public void run()
  {
    this.val$imageKey.listener.onImageLoaded(UICallbackTask.access$000(this.this$0, this.val$imageKey), this.val$image, this.val$imageKey.options);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.component.media.image.UICallbackTask.3
 * JD-Core Version:    0.7.0.1
 */
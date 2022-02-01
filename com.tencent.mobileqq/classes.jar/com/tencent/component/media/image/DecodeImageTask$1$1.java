package com.tencent.component.media.image;

import android.graphics.drawable.Drawable;

class DecodeImageTask$1$1
  implements Runnable
{
  DecodeImageTask$1$1(DecodeImageTask.1 param1, Drawable paramDrawable) {}
  
  public void run()
  {
    this.this$1.val$key.listener.onImageLoaded(this.this$1.val$key.url, this.val$d, this.this$1.val$key.options);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.component.media.image.DecodeImageTask.1.1
 * JD-Core Version:    0.7.0.1
 */
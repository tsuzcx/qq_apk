package com.tencent.component.media.image.view;

import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.widget.ImageView;

class AsyncImageable$AsyncImageableImpl$3
  implements Runnable
{
  AsyncImageable$AsyncImageableImpl$3(AsyncImageable.AsyncImageableImpl paramAsyncImageableImpl, Drawable paramDrawable, Animation paramAnimation) {}
  
  public void run()
  {
    AsyncImageable.AsyncImageableImpl.access$200(this.this$0).setImageDrawable(this.val$fDrawable);
    AsyncImageable.AsyncImageableImpl.access$300(AsyncImageable.AsyncImageableImpl.access$200(this.this$0), this.val$in, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.component.media.image.view.AsyncImageable.AsyncImageableImpl.3
 * JD-Core Version:    0.7.0.1
 */
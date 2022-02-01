package com.etrump.mixlayout;

import android.os.Handler;

class AnimatedImageSpan$1
  implements Runnable
{
  AnimatedImageSpan$1(AnimatedImageSpan paramAnimatedImageSpan, Handler paramHandler) {}
  
  public void run()
  {
    if ((AnimatedImageSpan.a(this.this$0) != null) && ((AnimatedImageSpan.a(this.this$0) instanceof AnimatedImageDrawable)))
    {
      AnimatedImageDrawable localAnimatedImageDrawable = (AnimatedImageDrawable)AnimatedImageSpan.a(this.this$0);
      localAnimatedImageDrawable.a();
      this.a.postDelayed(this, localAnimatedImageDrawable.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.etrump.mixlayout.AnimatedImageSpan.1
 * JD-Core Version:    0.7.0.1
 */
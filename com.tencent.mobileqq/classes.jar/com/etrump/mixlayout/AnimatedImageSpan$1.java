package com.etrump.mixlayout;

import android.os.Handler;
import fk;

public class AnimatedImageSpan$1
  implements Runnable
{
  public AnimatedImageSpan$1(fk paramfk, Handler paramHandler) {}
  
  public void run()
  {
    if ((fk.a(this.this$0) != null) && ((fk.a(this.this$0) instanceof AnimatedImageDrawable)))
    {
      AnimatedImageDrawable localAnimatedImageDrawable = (AnimatedImageDrawable)fk.a(this.this$0);
      localAnimatedImageDrawable.a();
      this.a.postDelayed(this, localAnimatedImageDrawable.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.etrump.mixlayout.AnimatedImageSpan.1
 * JD-Core Version:    0.7.0.1
 */
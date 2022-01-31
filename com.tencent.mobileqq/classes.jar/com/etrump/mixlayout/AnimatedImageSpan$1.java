package com.etrump.mixlayout;

import android.os.Handler;
import gw;

public class AnimatedImageSpan$1
  implements Runnable
{
  public AnimatedImageSpan$1(gw paramgw, Handler paramHandler) {}
  
  public void run()
  {
    if ((gw.a(this.this$0) != null) && ((gw.a(this.this$0) instanceof AnimatedImageDrawable)))
    {
      AnimatedImageDrawable localAnimatedImageDrawable = (AnimatedImageDrawable)gw.a(this.this$0);
      localAnimatedImageDrawable.a();
      this.a.postDelayed(this, localAnimatedImageDrawable.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.etrump.mixlayout.AnimatedImageSpan.1
 * JD-Core Version:    0.7.0.1
 */
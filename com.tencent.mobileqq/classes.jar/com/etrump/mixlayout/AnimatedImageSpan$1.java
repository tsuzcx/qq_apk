package com.etrump.mixlayout;

import android.os.Handler;
import ff;

public class AnimatedImageSpan$1
  implements Runnable
{
  public AnimatedImageSpan$1(ff paramff, Handler paramHandler) {}
  
  public void run()
  {
    if ((ff.a(this.this$0) != null) && ((ff.a(this.this$0) instanceof AnimatedImageDrawable)))
    {
      AnimatedImageDrawable localAnimatedImageDrawable = (AnimatedImageDrawable)ff.a(this.this$0);
      localAnimatedImageDrawable.a();
      this.a.postDelayed(this, localAnimatedImageDrawable.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.etrump.mixlayout.AnimatedImageSpan.1
 * JD-Core Version:    0.7.0.1
 */
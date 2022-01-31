package com.tencent.map.sdk.a;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.LinearLayout;

final class jr$2
  implements Animation.AnimationListener
{
  jr$2(jr paramjr) {}
  
  public final void onAnimationEnd(Animation paramAnimation)
  {
    if (jr.b(this.a) != null) {
      jr.b(this.a).setVisibility(8);
    }
  }
  
  public final void onAnimationRepeat(Animation paramAnimation) {}
  
  public final void onAnimationStart(Animation paramAnimation)
  {
    if (jr.b(this.a) != null) {
      jr.b(this.a).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.jr.2
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.apollo.debug;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.widget.HorizontalListView;

class CmGameDebugView$2
  implements Animation.AnimationListener
{
  CmGameDebugView$2(CmGameDebugView paramCmGameDebugView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (CmGameDebugView.a(this.a))
    {
      CmGameDebugView.a(this.a).postDelayed(new CmGameDebugView.2.1(this), 0L);
      CmGameDebugView.a(this.a, false);
    }
    if (CmGameDebugView.b(this.a)) {
      CmGameDebugView.b(this.a, 0);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.debug.CmGameDebugView.2
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity;

import android.view.animation.Animation;
import android.widget.TextView;
import com.tencent.util.AnimateUtils.AnimationAdapter;

class VisitorsActivity$8
  extends AnimateUtils.AnimationAdapter
{
  VisitorsActivity$8(VisitorsActivity paramVisitorsActivity) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if ((paramAnimation == this.a.b) && (this.a.d)) {
      this.a.centerView.setText("");
    }
    this.a.centerView.clearAnimation();
  }
  
  public void onAnimationStart(Animation paramAnimation)
  {
    if (paramAnimation == this.a.a) {
      this.a.centerView.setText(2131694400);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VisitorsActivity.8
 * JD-Core Version:    0.7.0.1
 */
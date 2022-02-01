package com.tencent.aelight.camera.ae.flashshow.view;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.aelight.camera.log.AEQLog;

class TabLayout$4
  implements ValueAnimator.AnimatorUpdateListener
{
  TabLayout$4(TabLayout paramTabLayout, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
    paramValueAnimator = this.e;
    int i = this.a;
    TabLayout.a(paramValueAnimator, (int)(i + (this.b - i) * f));
    paramValueAnimator = this.e;
    i = this.c;
    TabLayout.b(paramValueAnimator, (int)(i + (this.d - i) * f));
    paramValueAnimator = new StringBuilder();
    paramValueAnimator.append("animation update, offset: ");
    paramValueAnimator.append(f);
    paramValueAnimator.append(", animateLeft: ");
    paramValueAnimator.append(TabLayout.c(this.e));
    paramValueAnimator.append(", animateTop: ");
    paramValueAnimator.append(TabLayout.d(this.e));
    AEQLog.b("FS_TabLayout", paramValueAnimator.toString());
    TabLayout.b(this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.flashshow.view.TabLayout.4
 * JD-Core Version:    0.7.0.1
 */
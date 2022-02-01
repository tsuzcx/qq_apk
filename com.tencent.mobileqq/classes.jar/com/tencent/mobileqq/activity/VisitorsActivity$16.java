package com.tencent.mobileqq.activity;

import android.view.animation.Transformation;
import android.widget.TextView;
import com.tencent.mobileqq.utils.ValueAnimation;
import com.tencent.mobileqq.utils.ValueAnimation.AnimationUpdateListener;

class VisitorsActivity$16
  implements ValueAnimation.AnimationUpdateListener<Integer>
{
  VisitorsActivity$16(VisitorsActivity paramVisitorsActivity) {}
  
  public void a(ValueAnimation<Integer> paramValueAnimation, float paramFloat, Integer paramInteger, Transformation paramTransformation)
  {
    this.a.c.setText(paramInteger + "");
    if (paramInteger.intValue() > 9999)
    {
      this.a.c.setTextSize(36.0F);
      return;
    }
    this.a.c.setTextSize(44.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VisitorsActivity.16
 * JD-Core Version:    0.7.0.1
 */
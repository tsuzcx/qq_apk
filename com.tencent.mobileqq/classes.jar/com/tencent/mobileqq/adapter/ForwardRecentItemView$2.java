package com.tencent.mobileqq.adapter;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;

class ForwardRecentItemView$2
  implements ValueAnimator.AnimatorUpdateListener
{
  ForwardRecentItemView$2(ForwardRecentItemView paramForwardRecentItemView, RelativeLayout.LayoutParams paramLayoutParams) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.leftMargin = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.b.f.setLayoutParams(this.a);
    this.b.e.setChecked(false);
    this.b.b.setMaxWidth(this.b.j);
    if (AppSetting.e)
    {
      paramValueAnimator = this.b;
      paramValueAnimator.setContentDescription(paramValueAnimator.h);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.ForwardRecentItemView.2
 * JD-Core Version:    0.7.0.1
 */
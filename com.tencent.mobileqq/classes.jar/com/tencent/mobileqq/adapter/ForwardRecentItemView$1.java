package com.tencent.mobileqq.adapter;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.res.Resources;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;

class ForwardRecentItemView$1
  implements ValueAnimator.AnimatorUpdateListener
{
  ForwardRecentItemView$1(ForwardRecentItemView paramForwardRecentItemView, RelativeLayout.LayoutParams paramLayoutParams) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.leftMargin = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    this.b.f.setLayoutParams(this.a);
    this.b.b.setMaxWidth(this.b.j - this.b.i);
    if (AppSetting.e)
    {
      paramValueAnimator = this.b.getResources();
      int i;
      if (this.b.e.isChecked()) {
        i = 2131887795;
      } else {
        i = 2131917725;
      }
      paramValueAnimator = paramValueAnimator.getString(i);
      ForwardRecentItemView localForwardRecentItemView = this.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.b.h);
      localStringBuilder.append(paramValueAnimator);
      localForwardRecentItemView.setContentDescription(localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.ForwardRecentItemView.1
 * JD-Core Version:    0.7.0.1
 */
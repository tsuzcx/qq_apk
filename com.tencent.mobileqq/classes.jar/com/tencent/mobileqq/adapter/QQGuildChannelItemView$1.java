package com.tencent.mobileqq.adapter;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.res.Resources;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.util.QLog;

class QQGuildChannelItemView$1
  implements ValueAnimator.AnimatorUpdateListener
{
  QQGuildChannelItemView$1(QQGuildChannelItemView paramQQGuildChannelItemView, RelativeLayout.LayoutParams paramLayoutParams) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    this.a.leftMargin = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    if (QLog.isColorLevel())
    {
      paramValueAnimator = new StringBuilder();
      paramValueAnimator.append("CheckBoxLayout LeftMargin:");
      paramValueAnimator.append(this.a.leftMargin);
      QLog.i("QQGuildChannelItemView", 2, paramValueAnimator.toString());
    }
    this.b.e.setLayoutParams(this.a);
    if (AppSetting.e)
    {
      paramValueAnimator = this.b.getResources();
      int i;
      if (this.b.d.isChecked()) {
        i = 2131887795;
      } else {
        i = 2131917725;
      }
      paramValueAnimator = paramValueAnimator.getString(i);
      QQGuildChannelItemView localQQGuildChannelItemView = this.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.b.g);
      localStringBuilder.append(paramValueAnimator);
      localQQGuildChannelItemView.setContentDescription(localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.QQGuildChannelItemView.1
 * JD-Core Version:    0.7.0.1
 */
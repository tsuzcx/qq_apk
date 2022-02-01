package com.tencent.mobileqq.adapter;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.util.QLog;

class QQGuildChannelItemView$2
  implements ValueAnimator.AnimatorUpdateListener
{
  QQGuildChannelItemView$2(QQGuildChannelItemView paramQQGuildChannelItemView, RelativeLayout.LayoutParams paramLayoutParams) {}
  
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
    this.b.d.setChecked(false);
    if (AppSetting.e)
    {
      paramValueAnimator = this.b;
      paramValueAnimator.setContentDescription(paramValueAnimator.g);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.QQGuildChannelItemView.2
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity;

import MQQ.PayRuleCfg;
import android.graphics.Color;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.activity.qqsettingme.bean.QQSettingMeSuperMemberPayButtonBean;
import com.tencent.qphone.base.util.QLog;

class QQSettingMe$8
  implements URLDrawable.URLDrawableListener
{
  QQSettingMe$8(QQSettingMe paramQQSettingMe, QQSettingMeSuperMemberPayButtonBean paramQQSettingMeSuperMemberPayButtonBean, TextView paramTextView) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    QLog.e("QQSettingRedesign", 1, "VipInfoHandler updateSuperMemberItemView onLoadFialed: ", paramThrowable);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel())
    {
      paramURLDrawable = new StringBuilder();
      paramURLDrawable.append("VipInfoHandler onLoadSuccessed: ");
      paramURLDrawable.append(this.jdField_a_of_type_ComTencentMobileqqActivityQqsettingmeBeanQQSettingMeSuperMemberPayButtonBean.a.iconUrl);
      QLog.d("QQSettingRedesign", 2, paramURLDrawable.toString());
    }
    try
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqActivityQqsettingmeBeanQQSettingMeSuperMemberPayButtonBean.a.iconText);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor(this.jdField_a_of_type_ComTencentMobileqqActivityQqsettingmeBeanQQSettingMeSuperMemberPayButtonBean.a.iconTextCol));
      return;
    }
    catch (Exception paramURLDrawable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("VipInfoHandler setTextColor: ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityQqsettingmeBeanQQSettingMeSuperMemberPayButtonBean.a.iconTextCol);
      QLog.e("QQSettingRedesign", 1, localStringBuilder.toString(), paramURLDrawable);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-16777216);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingMe.8
 * JD-Core Version:    0.7.0.1
 */
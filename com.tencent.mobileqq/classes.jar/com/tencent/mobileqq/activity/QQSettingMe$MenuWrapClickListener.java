package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.qqsettingme.IQQSettingMeProcessor;
import com.tencent.mobileqq.activity.qqsettingme.QQSettingMeConstant;
import com.tencent.mobileqq.activity.qqsettingme.QQSettingMeViewModel;
import com.tencent.mobileqq.activity.qqsettingme.config.QQSettingMeBizBean;
import com.tencent.mobileqq.activity.qqsettingme.config.QQSettingMeBizBean.Action;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

class QQSettingMe$MenuWrapClickListener
  implements View.OnClickListener
{
  private final QQSettingMeBizBean.Action jdField_a_of_type_ComTencentMobileqqActivityQqsettingmeConfigQQSettingMeBizBean$Action;
  private final String jdField_a_of_type_JavaLangString;
  private final WeakReference<QQSettingMe> jdField_a_of_type_JavaLangRefWeakReference;
  
  private QQSettingMe$MenuWrapClickListener(String paramString, QQSettingMeBizBean.Action paramAction, QQSettingMe paramQQSettingMe)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqActivityQqsettingmeConfigQQSettingMeBizBean$Action = paramAction;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramQQSettingMe);
  }
  
  public void onClick(View paramView)
  {
    QQSettingMe localQQSettingMe = (QQSettingMe)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localQQSettingMe != null) && (paramView != null) && (localQQSettingMe.a))
    {
      Object localObject = QQSettingMe.a(this.jdField_a_of_type_JavaLangString);
      int i;
      if ((localObject != null) && (((RedTouch)localObject).c())) {
        i = 1;
      } else {
        i = 0;
      }
      localQQSettingMe.a().a(this.jdField_a_of_type_JavaLangString).onClick(paramView);
      if (QQSettingMeConstant.a(this.jdField_a_of_type_JavaLangString))
      {
        localObject = QQSettingMe.a(this.jdField_a_of_type_JavaLangString);
        if ((localObject != null) && (!TextUtils.isEmpty(((QQSettingMeBizBean)localObject).b())))
        {
          VideoReport.setElementParam(paramView, "is_red_tips_em", Integer.valueOf(i));
          VideoReport.reportEvent("clck", paramView, null);
        }
      }
      if ((this.jdField_a_of_type_JavaLangString.equals("d_document")) && (QQSettingMe.a(localQQSettingMe) != null) && (QQSettingMe.a(localQQSettingMe).getVisibility() == 0)) {
        QQSettingMe.a(localQQSettingMe).setVisibility(8);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingMe.MenuWrapClickListener
 * JD-Core Version:    0.7.0.1
 */
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
  private final WeakReference<QQSettingMe> a;
  private final String b;
  private final QQSettingMeBizBean.Action c;
  
  private QQSettingMe$MenuWrapClickListener(String paramString, QQSettingMeBizBean.Action paramAction, QQSettingMe paramQQSettingMe)
  {
    this.b = paramString;
    this.c = paramAction;
    this.a = new WeakReference(paramQQSettingMe);
  }
  
  public void onClick(View paramView)
  {
    QQSettingMe localQQSettingMe = (QQSettingMe)this.a.get();
    if ((localQQSettingMe != null) && (paramView != null) && (localQQSettingMe.b))
    {
      Object localObject = QQSettingMe.c(this.b);
      int i;
      if ((localObject != null) && (((RedTouch)localObject).h())) {
        i = 1;
      } else {
        i = 0;
      }
      localQQSettingMe.a().a(this.b).onClick(paramView);
      if (QQSettingMeConstant.a(this.b))
      {
        localObject = QQSettingMe.a(this.b);
        if ((localObject != null) && (!TextUtils.isEmpty(((QQSettingMeBizBean)localObject).c())))
        {
          VideoReport.setElementParam(paramView, "is_red_tips_em", Integer.valueOf(i));
          VideoReport.reportEvent("clck", paramView, null);
        }
      }
      if ((this.b.equals("d_document")) && (QQSettingMe.c(localQQSettingMe) != null) && (QQSettingMe.c(localQQSettingMe).getVisibility() == 0)) {
        QQSettingMe.c(localQQSettingMe).setVisibility(8);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQSettingMe.MenuWrapClickListener
 * JD-Core Version:    0.7.0.1
 */
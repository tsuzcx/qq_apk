package com.tencent.mobileqq.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qqsec.api.ISecControllerInterface;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class NotificationActivity$33
  implements View.OnClickListener
{
  NotificationActivity$33(NotificationActivity paramNotificationActivity) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.a;
    localObject = DialogUtil.a((Context)localObject, ((NotificationActivity)localObject).getResources().getDrawable(2130849933), 2131692071);
    ((ProgressDialog)localObject).setOnDismissListener(new NotificationActivity.33.1(this));
    NotificationActivity.access$100().a((BaseQQAppInterface)this.a.getAppRuntime(), (ProgressDialog)localObject);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotificationActivity.33
 * JD-Core Version:    0.7.0.1
 */
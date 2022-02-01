package com.tencent.mobileqq.activity;

import android.app.ProgressDialog;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.log.ReportLog;
import com.tencent.mobileqq.transfile.HttpCommunicator;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppRuntime;
import mqq.manager.ServerConfigManager.ConfigType;
import mqq.manager.TicketManager;

class NotificationActivity$33
  implements View.OnClickListener
{
  NotificationActivity$33(NotificationActivity paramNotificationActivity) {}
  
  public void onClick(View paramView)
  {
    ProgressDialog localProgressDialog = DialogUtil.a(this.a, this.a.getResources().getDrawable(2130850006), 2131692152);
    localProgressDialog.setOnDismissListener(new NotificationActivity.33.1(this));
    ReportLog.a(this.a.app.getAccount());
    this.a.app.getServerConfigValue(ServerConfigManager.ConfigType.app, "log_upload");
    Object localObject = BaseApplicationImpl.sApplication.getRuntime();
    if (localObject != null)
    {
      TicketManager localTicketManager = (TicketManager)((AppRuntime)localObject).getManager(2);
      String str = ((AppRuntime)localObject).getAccount();
      localObject = "";
      if (localTicketManager != null) {
        localObject = localTicketManager.getSkey(str);
      }
      if (QLog.isColorLevel()) {
        QLog.d("NotificationActivity", 2, new Object[] { " NotificationActivity crash uin=", str, ",skey=", localObject });
      }
      ReportLog.a((HttpCommunicator)((IHttpEngineService)this.a.app.getRuntimeService(IHttpEngineService.class, "all")).getCommunicator(), this.a.app.getApp(), localProgressDialog, str, (String)localObject);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotificationActivity.33
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.app.msgnotify;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.JumpToNotificationSettingUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MsgNotifyPushForSpecialCareDialog$2
  implements View.OnClickListener
{
  MsgNotifyPushForSpecialCareDialog$2(MsgNotifyPushForSpecialCareDialog paramMsgNotifyPushForSpecialCareDialog) {}
  
  public void onClick(View paramView)
  {
    try
    {
      ReportController.b(null, "dc00898", "", "", "0X8009ACC", "0X8009ACC", 0, 0, "", "", "", "");
      if (MsgNotifyPushDialog.a != null)
      {
        MsgNotifyPushForSpecialCareDialog.a(this.a).startActivity(MsgNotifyPushDialog.a);
      }
      else if (MsgNotifyPushForSpecialCareDialog.a(this.a) != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d(MsgNotifyPushForSpecialCareDialog.a(), 2, "init MsgNotifyPushDialog.initPushOpeNotifyConfig");
        }
        MsgNotifyPushDialog.a(MsgNotifyPushForSpecialCareDialog.a(this.a));
        MsgNotifyPushForSpecialCareDialog.a(this.a).startActivity(MsgNotifyPushDialog.a);
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.d(MsgNotifyPushForSpecialCareDialog.a(), 2, "mAppInterface=null, use default intent");
        }
        MsgNotifyPushForSpecialCareDialog.a(this.a).startActivity(JumpToNotificationSettingUtil.a(MsgNotifyPushForSpecialCareDialog.a(this.a)));
      }
    }
    catch (Exception localException)
    {
      label135:
      break label135;
    }
    if (QLog.isColorLevel())
    {
      QLog.d(MsgNotifyPushForSpecialCareDialog.a(), 2, "Start Activity Failed");
      MsgNotifyPushForSpecialCareDialog.a(this.a).startActivity(JumpToNotificationSettingUtil.c(MsgNotifyPushForSpecialCareDialog.a(this.a)));
    }
    this.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.msgnotify.MsgNotifyPushForSpecialCareDialog.2
 * JD-Core Version:    0.7.0.1
 */
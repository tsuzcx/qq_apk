package com.tencent.mobileqq.app.msgnotify;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MsgNotifyPushDialog$1
  implements View.OnClickListener
{
  MsgNotifyPushDialog$1(MsgNotifyPushDialog paramMsgNotifyPushDialog) {}
  
  public void onClick(View paramView)
  {
    if (MsgNotifyPushDialog.a != null) {
      MsgNotifyPushDialog.a(this.a).startActivity(MsgNotifyPushDialog.a);
    }
    ReportController.b(null, "CliOper", "", "", "0X8006B15", "0X8006B15", 0, 0, "", "", "", "");
    ReportController.b(null, "dc00898", "", "", "0X8009AC8", "0X8009AC8", 0, 0, "", "", "", "");
    Object localObject = PreferenceManager.getDefaultSharedPreferences(MsgNotifyPushDialog.a(this.a));
    int i = ((SharedPreferences)localObject).getInt("push_msg_notify_open", 0);
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putInt("push_msg_notify_open", i + 1);
    ((SharedPreferences.Editor)localObject).commit();
    this.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.msgnotify.MsgNotifyPushDialog.1
 * JD-Core Version:    0.7.0.1
 */
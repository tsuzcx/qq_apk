package com.tencent.mobileqq.activity.home;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

class Conversation$ShowRealNameDialog$1
  implements DialogInterface.OnClickListener
{
  Conversation$ShowRealNameDialog$1(Conversation.ShowRealNameDialog paramShowRealNameDialog) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt == 1)
      {
        if (Conversation.ShowRealNameDialog.a(this.a).startsWith("http"))
        {
          try
          {
            Intent localIntent = new Intent(this.a.a.P(), QQBrowserActivity.class);
            localIntent.putExtra("url", Conversation.ShowRealNameDialog.a(this.a));
            this.a.a.P().startActivity(localIntent);
          }
          catch (Exception localException)
          {
            if (!QLog.isDevelopLevel()) {
              break label141;
            }
          }
          localException.printStackTrace();
        }
        else if (Conversation.ShowRealNameDialog.a(this.a).startsWith("mqqapi:"))
        {
          JumpParser.a(this.a.a.s(), this.a.a.P(), Conversation.ShowRealNameDialog.a(this.a)).a();
        }
        label141:
        ReportController.b(this.a.a.aF, "dc00898", "", "", "0X8008273", "0X8008273", 0, 0, "", "", "", "");
      }
    }
    else
    {
      if (SettingCloneUtil.readValue(this.a.a.aF.getApplication(), this.a.a.aF.getAccount(), null, "pcactive_config", false)) {
        this.a.a.aF.startPCActivePolling(this.a.a.aF.getAccount(), "logout");
      }
      this.a.a.a(this.a.a.P(), this.a.a.s());
    }
    try
    {
      paramDialogInterface.dismiss();
      this.a.a.z = null;
      return;
    }
    catch (Exception paramDialogInterface) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.ShowRealNameDialog.1
 * JD-Core Version:    0.7.0.1
 */
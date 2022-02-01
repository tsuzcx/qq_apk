package com.tencent.av.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.smallscreen.SmallScreenActivityPlugin;
import com.tencent.mobileqq.statistics.ReportController;

class AVActivity$MyBroadCastReceiver
  extends BroadcastReceiver
{
  AVActivity$MyBroadCastReceiver(AVActivity paramAVActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction().equals("android.intent.action.CLOSE_SYSTEM_DIALOGS"))
    {
      paramContext = paramIntent.getStringExtra("reason");
      if ((paramContext != null) && (this.a.a != null) && (paramContext.equals("homekey")))
      {
        if (this.a.a.a().d == 4) {
          if (this.a.d == 3000)
          {
            if (this.a.a.a().jdField_j_of_type_Boolean) {
              ReportController.b(null, "CliOper", "", "", "0X80041BB", "0X80041BB", 0, 0, "", "", "", "");
            } else {
              ReportController.b(null, "CliOper", "", "", "0X80041BE", "0X80041BE", 0, 0, "", "", "", "");
            }
          }
          else if (this.a.d == 1) {
            if (this.a.a.a().jdField_j_of_type_Boolean)
            {
              if (this.a.a.a().jdField_j_of_type_Int == 10) {
                ReportController.b(null, "CliOper", "", "", "0X800593E", "0X800593E", 0, 0, "", "", "", "");
              } else {
                ReportController.b(null, "CliOper", "", "", "0X80046E8", "0X80046E8", 0, 0, "", "", "", "");
              }
            }
            else if (this.a.a.a().k) {
              if (this.a.a.a().jdField_j_of_type_Int == 10) {
                ReportController.b(null, "CliOper", "", "", "0X8005941", "0X8005941", 0, 0, "", "", "", "");
              } else {
                ReportController.b(null, "CliOper", "", "", "0X80046EB", "0X80046EB", 0, 0, "", "", "", "");
              }
            }
          }
        }
        if (this.a.g) {
          if (this.a.a.a().jdField_j_of_type_Boolean) {
            ReportController.b(null, "CliOper", "", "", "0X8005216", "0X8005216", 0, 0, "", "", "", "");
          } else {
            ReportController.b(null, "CliOper", "", "", "0X8005219", "0X8005219", 0, 0, "", "", "", "");
          }
        }
        if (AVActivity.a(this.a) != null) {
          AVActivity.a(this.a).a(this.a.isResume());
        }
        this.a.a.a("backgroundReason", "1");
        com.tencent.av.VideoConstants.ProcessInfo.a = "1";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.MyBroadCastReceiver
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.app.qqdaily;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class FrontBackReportManager$2
  extends BroadcastReceiver
{
  FrontBackReportManager$2(FrontBackReportManager paramFrontBackReportManager) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      paramContext = paramIntent.getAction();
      if (paramContext != null) {
        if ((!paramContext.equals("com.tencent.mobileqq.intent.logout")) && (!paramContext.equals("mqq.intent.action.ACCOUNT_KICKED")) && (!paramContext.equals("mqq.intent.action.FORCE_LOGOUT")) && (!paramContext.equals("mqq.intent.action.LOGOUT")))
        {
          if ((paramContext.equals("mqq.intent.action.LOGIN")) || (paramContext.equals("mqq.intent.action.ACCOUNT_CHANGED"))) {
            FrontBackReportManager.c(this.a);
          }
        }
        else {
          FrontBackReportManager.b(this.a);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.qqdaily.FrontBackReportManager.2
 * JD-Core Version:    0.7.0.1
 */
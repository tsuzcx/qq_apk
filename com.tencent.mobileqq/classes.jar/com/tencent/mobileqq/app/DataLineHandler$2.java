package com.tencent.mobileqq.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.BaseApplication;

class DataLineHandler$2
  extends BroadcastReceiver
{
  DataLineHandler$2(DataLineHandler paramDataLineHandler, QQAppInterface paramQQAppInterface) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      paramContext = paramIntent.getAction();
      if (paramContext != null) {
        if ((!paramContext.equals("com.tencent.mobileqq.intent.logout")) && (!paramContext.equals("mqq.intent.action.ACCOUNT_CHANGED")) && (!paramContext.equals("mqq.intent.action.ACCOUNT_KICKED")) && (!paramContext.equals("mqq.intent.action.FORCE_LOGOUT")))
        {
          paramIntent = new StringBuilder();
          paramIntent.append("mqq.intent.action.EXIT_");
          paramIntent.append(this.a.getApp().getPackageName());
          if ((!paramContext.equals(paramIntent.toString())) && (!paramContext.equals("mqq.intent.action.LOGOUT"))) {}
        }
        else
        {
          this.b.b();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.DataLineHandler.2
 * JD-Core Version:    0.7.0.1
 */
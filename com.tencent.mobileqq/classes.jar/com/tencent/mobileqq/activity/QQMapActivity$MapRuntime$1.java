package com.tencent.mobileqq.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import com.tencent.mobileqq.util.CommonUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

class QQMapActivity$MapRuntime$1
  extends BroadcastReceiver
{
  QQMapActivity$MapRuntime$1(QQMapActivity.MapRuntime paramMapRuntime) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    int j = 1;
    paramContext = paramIntent.getAction();
    if (paramContext == null) {}
    for (;;)
    {
      return;
      int i;
      if (paramContext.equals("com.tencent.process.exit"))
      {
        if (QLog.isColorLevel()) {
          QLog.d("mqq", 2, "receive kill map process broadcast");
        }
        paramContext = paramIntent.getExtras().getStringArrayList("procNameList");
        if ((!QQMapActivity.a(paramIntent.getExtras().getString("verify"), paramContext)) || (!CommonUtil.a(paramContext, MobileQQ.getContext()))) {
          break label144;
        }
        i = j;
      }
      while (i != 0)
      {
        Process.killProcess(Process.myPid());
        return;
        i = j;
        if (!paramContext.equals("mqq.intent.action.ACCOUNT_CHANGED"))
        {
          i = j;
          if (!paramContext.equals("mqq.intent.action.LOGOUT"))
          {
            i = j;
            if (!paramContext.equals("mqq.intent.action.EXIT_" + MobileQQ.getMobileQQ().getPackageName())) {
              label144:
              i = 0;
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQMapActivity.MapRuntime.1
 * JD-Core Version:    0.7.0.1
 */
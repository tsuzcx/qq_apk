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
    paramContext = paramIntent.getAction();
    if (paramContext == null) {
      return;
    }
    int j = 0;
    if (paramContext.equals("com.tencent.process.exit"))
    {
      if (QLog.isColorLevel()) {
        QLog.d("mqq", 2, "receive kill map process broadcast");
      }
      paramContext = paramIntent.getExtras().getStringArrayList("procNameList");
      i = j;
      if (!QQMapActivity.isLegalBroadcast(paramIntent.getExtras().getString("verify"), paramContext)) {
        break label141;
      }
      i = j;
      if (!CommonUtil.a(paramContext, MobileQQ.getContext())) {
        break label141;
      }
    }
    else if ((!paramContext.equals("mqq.intent.action.ACCOUNT_CHANGED")) && (!paramContext.equals("mqq.intent.action.LOGOUT")))
    {
      paramIntent = new StringBuilder();
      paramIntent.append("mqq.intent.action.EXIT_");
      paramIntent.append(MobileQQ.getMobileQQ().getPackageName());
      i = j;
      if (!paramContext.equals(paramIntent.toString())) {
        break label141;
      }
    }
    int i = 1;
    label141:
    if (i != 0) {
      Process.killProcess(Process.myPid());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQMapActivity.MapRuntime.1
 * JD-Core Version:    0.7.0.1
 */
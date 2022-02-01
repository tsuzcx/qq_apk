package com.tencent.mobileqq.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.jsp.IdentificationApiPlugin;
import com.tencent.qphone.base.util.QLog;

class QQIdentiferActivity$7
  extends BroadcastReceiver
{
  QQIdentiferActivity$7(QQIdentiferActivity paramQQIdentiferActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if (("tencent.av.v2q.StartVideoChat".equals(paramContext)) || ("tencent.av.v2q.AvSwitch".equals(paramContext)))
    {
      i = paramIntent.getIntExtra("sessionType", 0);
      QLog.d("qq_Identification.act", 1, "received video chat broadcast: " + i);
      if ((i == 2) || (i == 4))
      {
        QQIdentiferActivity.a(this.a, 204, IdentificationApiPlugin.a);
        QQIdentiferActivity.a(this.a, 204, IdentificationApiPlugin.a);
        this.a.finish();
      }
    }
    while (!"mqq.intent.action.ACCOUNT_KICKED".equals(paramContext))
    {
      int i;
      return;
    }
    QLog.d("qq_Identification.act", 1, "received kicked broadcast");
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQIdentiferActivity.7
 * JD-Core Version:    0.7.0.1
 */
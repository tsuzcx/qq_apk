package com.tencent.mobileqq.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.identification.IdentificationConstant;
import com.tencent.qphone.base.util.QLog;

class QQIdentiferActivity$7
  extends BroadcastReceiver
{
  QQIdentiferActivity$7(QQIdentiferActivity paramQQIdentiferActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    paramContext = paramIntent.getAction();
    if ((!"tencent.av.v2q.StartVideoChat".equals(paramContext)) && (!"tencent.av.v2q.AvSwitch".equals(paramContext)))
    {
      if ("mqq.intent.action.ACCOUNT_KICKED".equals(paramContext))
      {
        QLog.d("qq_Identification.act", 1, "received kicked broadcast");
        this.a.finish();
      }
    }
    else
    {
      int i = paramIntent.getIntExtra("sessionType", 0);
      paramContext = new StringBuilder();
      paramContext.append("received video chat broadcast: ");
      paramContext.append(i);
      QLog.d("qq_Identification.act", 1, paramContext.toString());
      if ((i == 2) || (i == 4))
      {
        QQIdentiferActivity.access$000(this.a, 204, IdentificationConstant.a);
        QQIdentiferActivity.access$000(this.a, 204, IdentificationConstant.a);
        this.a.finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQIdentiferActivity.7
 * JD-Core Version:    0.7.0.1
 */
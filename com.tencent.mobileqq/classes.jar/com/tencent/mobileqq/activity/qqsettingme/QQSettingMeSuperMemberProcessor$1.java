package com.tencent.mobileqq.activity.qqsettingme;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.qphone.base.util.QLog;

class QQSettingMeSuperMemberProcessor$1
  extends BroadcastReceiver
{
  QQSettingMeSuperMemberProcessor$1(QQSettingMeSuperMemberProcessor paramQQSettingMeSuperMemberProcessor) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("UpdateVipInfoReceiver: intent=");
      paramContext.append(paramIntent.toString());
      QLog.d("QQSettingRedesign", 2, paramContext.toString());
    }
    if ((paramIntent != null) && (paramIntent.getBooleanExtra("key_pay_action_result", false)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "UpdateVipInfoReceiver: need update ");
      }
      QQSettingMeSuperMemberProcessor.a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.QQSettingMeSuperMemberProcessor.1
 * JD-Core Version:    0.7.0.1
 */
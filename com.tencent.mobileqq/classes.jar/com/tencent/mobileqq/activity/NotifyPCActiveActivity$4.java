package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.qphone.base.util.QLog;

class NotifyPCActiveActivity$4
  extends CardObserver
{
  NotifyPCActiveActivity$4(NotifyPCActiveActivity paramNotifyPCActiveActivity) {}
  
  protected void onSetPCActiveState(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
  {
    if (paramBoolean1)
    {
      SettingCloneUtil.writeValue(this.a.app.getApp(), paramString2, null, "qqsetting_pcactive_key", true);
      paramString1 = new StringBuilder();
      paramString1.append("Set the PC Active State ");
      paramString1.append(paramBoolean1);
      QLog.i("CardObserver_onSetPCActiveState", 1, paramString1.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotifyPCActiveActivity.4
 * JD-Core Version:    0.7.0.1
 */
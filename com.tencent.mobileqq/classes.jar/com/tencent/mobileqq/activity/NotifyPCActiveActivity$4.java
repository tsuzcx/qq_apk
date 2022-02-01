package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.qphone.base.util.QLog;

class NotifyPCActiveActivity$4
  extends CardObserver
{
  NotifyPCActiveActivity$4(NotifyPCActiveActivity paramNotifyPCActiveActivity) {}
  
  public void onSetPCActiveState(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
  {
    if (paramBoolean1)
    {
      SettingCloneUtil.writeValue(this.a.app.getApp(), paramString2, null, "qqsetting_pcactive_key", true);
      QLog.i("CardObserver_onSetPCActiveState", 1, "Set the PC Active State " + paramBoolean1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotifyPCActiveActivity.4
 * JD-Core Version:    0.7.0.1
 */
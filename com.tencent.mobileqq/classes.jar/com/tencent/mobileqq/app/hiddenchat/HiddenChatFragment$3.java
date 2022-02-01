package com.tencent.mobileqq.app.hiddenchat;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.troop.troopsetting.api.TroopSettingObserver;
import com.tencent.qphone.base.util.QLog;

class HiddenChatFragment$3
  extends TroopSettingObserver
{
  HiddenChatFragment$3(HiddenChatFragment paramHiddenChatFragment) {}
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if ((paramInt2 == 512) && (paramBoolean))
    {
      paramString2 = ((TroopManager)HiddenChatFragment.a(this.a).getManager(QQManagerFactory.TROOP_MANAGER)).b(paramString1);
      TroopStatusUtil.a(HiddenChatFragment.a(this.a), paramString2);
      this.a.a();
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("onSetHiddenChatSwitch troopUin=");
        paramString2.append(paramString1);
        QLog.d("tag_hidden_chat", 2, paramString2.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.hiddenchat.HiddenChatFragment.3
 * JD-Core Version:    0.7.0.1
 */
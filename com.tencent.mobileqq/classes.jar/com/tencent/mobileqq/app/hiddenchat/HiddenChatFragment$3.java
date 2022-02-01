package com.tencent.mobileqq.app.hiddenchat;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.qphone.base.util.QLog;

class HiddenChatFragment$3
  extends TroopBusinessObserver
{
  HiddenChatFragment$3(HiddenChatFragment paramHiddenChatFragment) {}
  
  public void onOIDB0XA80_0_Ret(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if ((paramInt2 == 512) && (paramBoolean))
    {
      paramString2 = ((TroopManager)HiddenChatFragment.a(this.a).getManager(QQManagerFactory.TROOP_MANAGER)).b(paramString1);
      TroopStatusUtil.a(HiddenChatFragment.a(this.a), paramString2);
      this.a.a();
      if (QLog.isColorLevel()) {
        QLog.d("tag_hidden_chat", 2, "onSetHiddenChatSwitch troopUin=" + paramString1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.hiddenchat.HiddenChatFragment.3
 * JD-Core Version:    0.7.0.1
 */
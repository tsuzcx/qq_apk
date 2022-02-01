package com.tencent.mobileqq.activity.home;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.troop.api.observer.TroopMngObserver;
import com.tencent.qphone.base.util.QLog;

class Conversation$35
  extends TroopMngObserver
{
  Conversation$35(Conversation paramConversation) {}
  
  protected void a(int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt1 == 6)
    {
      if (paramInt2 == 0)
      {
        TroopAssistantManager.a().c(this.a.a());
        this.a.a(8, paramString, 1);
        this.a.a(8, AppConstants.TROOP_ASSISTANT_UIN, 5000);
        this.a.a(8, AppConstants.HOTCHAT_CENTER_UIN, 5001);
      }
    }
    else if ((paramInt1 == 2) && (paramInt2 == 0))
    {
      TroopAssistantManager.a().b(paramString, this.a.a());
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "refresh recent, from_ontroopmanagersuccess");
      }
      this.a.a(8, paramString, 1);
      this.a.a(8, AppConstants.TROOP_ASSISTANT_UIN, 5000);
      this.a.a(8, AppConstants.HOTCHAT_CENTER_UIN, 5001);
    }
  }
  
  protected void a(boolean paramBoolean1, byte paramByte, TroopInfo paramTroopInfo, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      this.a.a(8, AppConstants.TROOP_ASSISTANT_UIN, 5000);
      this.a.a(8, AppConstants.HOTCHAT_CENTER_UIN, 5001);
      if (paramTroopInfo != null) {
        this.a.a(8, paramTroopInfo.troopuin, 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.35
 * JD-Core Version:    0.7.0.1
 */
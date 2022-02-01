package com.tencent.mobileqq.activity.home;

import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopBusinessObserver;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.qphone.base.util.QLog;

class Conversation$34
  extends TroopBusinessObserver
{
  Conversation$34(Conversation paramConversation) {}
  
  public void onGenNewTroopName(String paramString1, String paramString2)
  {
    this.a.a(8, paramString1, 1);
  }
  
  public void onTroopBlockStatusChanged(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "refresh recent, from_ontroopblockstatuschanged");
    }
    this.a.a(0L);
  }
  
  public void onTroopHonorUpdate(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (paramString2.equals(this.a.a().getCurrentAccountUin()))) {
      this.a.a(8, paramString1, 1);
    }
  }
  
  public void onTroopManagerSuccess(int paramInt1, int paramInt2, String paramString)
  {
    if (paramInt1 == 6) {
      if (paramInt2 == 0)
      {
        TroopAssistantManager.a().c(this.a.a());
        this.a.a(8, paramString, 1);
        this.a.a(8, AppConstants.TROOP_ASSISTANT_UIN, 5000);
        this.a.a(8, AppConstants.HOTCHAT_CENTER_UIN, 5001);
      }
    }
    while ((paramInt1 != 2) || (paramInt2 != 0)) {
      return;
    }
    TroopAssistantManager.a().b(paramString, this.a.a());
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "refresh recent, from_ontroopmanagersuccess");
    }
    this.a.a(8, paramString, 1);
    this.a.a(8, AppConstants.TROOP_ASSISTANT_UIN, 5000);
    this.a.a(8, AppConstants.HOTCHAT_CENTER_UIN, 5001);
  }
  
  public void onTroopSearch(boolean paramBoolean1, byte paramByte, TroopInfo paramTroopInfo, boolean paramBoolean2)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.34
 * JD-Core Version:    0.7.0.1
 */
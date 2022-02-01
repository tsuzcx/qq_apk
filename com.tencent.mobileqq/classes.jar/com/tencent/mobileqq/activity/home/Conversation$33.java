package com.tencent.mobileqq.activity.home;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.troop.TroopMemberCardInfo;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class Conversation$33
  extends TroopObserver
{
  Conversation$33(Conversation paramConversation) {}
  
  protected void onGenNewTroopName(String paramString1, String paramString2)
  {
    this.a.a(8, paramString1, 1);
  }
  
  protected void onGetTroopInfoResult(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      this.a.a(8, paramString, 1);
      this.a.a(8, AppConstants.TROOP_ASSISTANT_UIN, 5000);
      this.a.a(8, AppConstants.HOTCHAT_CENTER_UIN, 5001);
    }
  }
  
  protected void onGetTroopMemberCard(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Conversation.onGetTroopMemberCard isSuccess=");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" data=");
      localStringBuilder.append(paramObject);
      QLog.d("Q.recent", 2, localStringBuilder.toString());
    }
    if ((paramBoolean) && (paramObject != null))
    {
      long l = ((Long)((Object[])(Object[])paramObject)[0]).longValue();
      this.a.a(8, String.valueOf(l), 1);
    }
  }
  
  protected void onGetTroopMemberCardInfoResult(boolean paramBoolean1, ArrayList<TroopMemberCardInfo> paramArrayList, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (paramBoolean2) && (paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramArrayList = (TroopMemberCardInfo)paramArrayList.get(0);
      if (paramArrayList != null)
      {
        this.a.a(8, paramArrayList.troopuin, 1);
        this.a.a(8, paramArrayList.memberuin, -2147483648);
        this.a.a(8, AppConstants.TROOP_ASSISTANT_UIN, 5000);
        this.a.a(8, AppConstants.HOTCHAT_CENTER_UIN, 5001);
      }
    }
  }
  
  protected void onUpdateRecentList()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.recent", 2, "refresh recent, from_onupdaterecentlist");
    }
    this.a.a(0L);
  }
  
  protected void onUpdateTroopList(boolean paramBoolean)
  {
    TroopAssistantManager.a().c(this.a.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.33
 * JD-Core Version:    0.7.0.1
 */
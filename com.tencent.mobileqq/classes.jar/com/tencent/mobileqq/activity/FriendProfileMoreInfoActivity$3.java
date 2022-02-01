package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.businessCard.BusinessCardManager;
import com.tencent.mobileqq.businessCard.BusinessCardObserver;

class FriendProfileMoreInfoActivity$3
  extends BusinessCardObserver
{
  FriendProfileMoreInfoActivity$3(FriendProfileMoreInfoActivity paramFriendProfileMoreInfoActivity) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if (paramBoolean)
    {
      BusinessCardManager localBusinessCardManager = (BusinessCardManager)this.a.app.getManager(QQManagerFactory.BUSINESS_CARD_MANAGER);
      this.a.k = localBusinessCardManager.a(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity.3
 * JD-Core Version:    0.7.0.1
 */
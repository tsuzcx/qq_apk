package com.tencent.mobileqq.activity.home;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.mobileqq.util.Utils;

class Conversation$42
  extends ProfileCardObserver
{
  Conversation$42(Conversation paramConversation) {}
  
  protected void onGetProfileCard(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject instanceof Card)) {
      paramObject = (Card)paramObject;
    } else {
      paramObject = null;
    }
    if ((paramBoolean) && (paramObject != null))
    {
      if (!Utils.a(paramObject.uin, this.a.a().getCurrentAccountUin()))
      {
        this.a.a(8, paramObject.uin, -2147483648);
        return;
      }
      Conversation.c(this.a, "onCardDownload");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.42
 * JD-Core Version:    0.7.0.1
 */
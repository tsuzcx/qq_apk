package com.tencent.mobileqq.activity.home;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.mobileqq.util.Utils;

class Conversation$43
  extends ProfileCardObserver
{
  Conversation$43(Conversation paramConversation) {}
  
  protected void onGetProfileCard(boolean paramBoolean, Object paramObject)
  {
    if ((paramObject instanceof Card)) {
      paramObject = (Card)paramObject;
    } else {
      paramObject = null;
    }
    if ((paramBoolean) && (paramObject != null))
    {
      if (!Utils.a(paramObject.uin, this.a.s().getCurrentAccountUin()))
      {
        this.a.a(8, paramObject.uin, -2147483648);
        return;
      }
      Conversation.d(this.a, "onCardDownload");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.43
 * JD-Core Version:    0.7.0.1
 */
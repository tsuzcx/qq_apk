package com.tencent.mobileqq.app;

import com.tencent.mobileqq.data.Card;

class CardHandler$1
  implements Runnable
{
  CardHandler$1(CardHandler paramCardHandler, int paramInt) {}
  
  public void run()
  {
    Object localObject = CardHandler.a(this.this$0).getCurrentAccountUin();
    FriendsManager localFriendsManager = (FriendsManager)CardHandler.a(this.this$0).getManager(QQManagerFactory.FRIENDS_MANAGER);
    localObject = localFriendsManager.a((String)localObject);
    if (localObject != null)
    {
      ((Card)localObject).iVoteIncrement = this.a;
      localFriendsManager.a((Card)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.CardHandler.1
 * JD-Core Version:    0.7.0.1
 */
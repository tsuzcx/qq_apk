package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Card;

class AddRequestActivity$9$1
  implements Runnable
{
  AddRequestActivity$9$1(AddRequestActivity.9 param9) {}
  
  public void run()
  {
    Card localCard = ((FriendsManager)this.a.a.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).f(this.a.a.a);
    if (localCard != null) {
      this.a.a.runOnUiThread(new AddRequestActivity.9.1.1(this, localCard));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddRequestActivity.9.1
 * JD-Core Version:    0.7.0.1
 */
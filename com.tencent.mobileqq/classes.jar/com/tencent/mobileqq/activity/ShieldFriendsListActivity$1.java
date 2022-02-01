package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import java.util.ArrayList;

class ShieldFriendsListActivity$1
  implements Runnable
{
  ShieldFriendsListActivity$1(ShieldFriendsListActivity paramShieldFriendsListActivity) {}
  
  public void run()
  {
    ArrayList localArrayList = ((FriendsManager)this.this$0.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).a();
    this.this$0.runOnUiThread(new ShieldFriendsListActivity.1.1(this, localArrayList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ShieldFriendsListActivity.1
 * JD-Core Version:    0.7.0.1
 */
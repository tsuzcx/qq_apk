package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import mqq.os.MqqHandler;

class TroopRequestActivity$2
  implements Runnable
{
  TroopRequestActivity$2(TroopRequestActivity paramTroopRequestActivity, FriendsManager paramFriendsManager) {}
  
  public void run()
  {
    Card localCard = this.a.a(this.this$0.b);
    ThreadManager.getUIHandler().post(new TroopRequestActivity.2.1(this, localCard));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopRequestActivity.2
 * JD-Core Version:    0.7.0.1
 */
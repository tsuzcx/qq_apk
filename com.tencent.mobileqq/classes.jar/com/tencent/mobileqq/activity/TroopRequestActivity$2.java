package com.tencent.mobileqq.activity;

import anvk;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import mqq.os.MqqHandler;

class TroopRequestActivity$2
  implements Runnable
{
  TroopRequestActivity$2(TroopRequestActivity paramTroopRequestActivity, anvk paramanvk) {}
  
  public void run()
  {
    Card localCard = this.a.b(this.this$0.b);
    ThreadManager.getUIHandler().post(new TroopRequestActivity.2.1(this, localCard));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopRequestActivity.2
 * JD-Core Version:    0.7.0.1
 */
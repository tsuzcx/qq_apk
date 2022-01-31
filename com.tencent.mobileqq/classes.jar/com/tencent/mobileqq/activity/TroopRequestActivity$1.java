package com.tencent.mobileqq.activity;

import ajxn;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import mqq.os.MqqHandler;

class TroopRequestActivity$1
  implements Runnable
{
  TroopRequestActivity$1(TroopRequestActivity paramTroopRequestActivity, ajxn paramajxn) {}
  
  public void run()
  {
    Card localCard = this.a.b(this.this$0.b);
    ThreadManager.getUIHandler().post(new TroopRequestActivity.1.1(this, localCard));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopRequestActivity.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;

class TroopInfoActivity$6
  implements Runnable
{
  TroopInfoActivity$6(TroopInfoActivity paramTroopInfoActivity) {}
  
  public void run()
  {
    if (this.this$0.app != null) {
      ((TroopManager)this.this$0.app.getManager(52)).b(this.this$0.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopInfoActivity.6
 * JD-Core Version:    0.7.0.1
 */
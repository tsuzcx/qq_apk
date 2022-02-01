package com.tencent.mobileqq.activity.selectmember;

import alun;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;

public class TroopListBaseAdapter$1
  implements Runnable
{
  public TroopListBaseAdapter$1(alun paramalun) {}
  
  public void run()
  {
    ((TroopManager)this.this$0.a.getManager(52)).a();
    this.this$0.a.runOnUiThread(new TroopListBaseAdapter.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.TroopListBaseAdapter.1
 * JD-Core Version:    0.7.0.1
 */
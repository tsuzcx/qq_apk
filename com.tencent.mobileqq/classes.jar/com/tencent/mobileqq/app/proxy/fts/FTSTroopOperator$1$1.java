package com.tencent.mobileqq.app.proxy.fts;

import aonn;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.qphone.base.util.QLog;

class FTSTroopOperator$1$1
  implements Runnable
{
  FTSTroopOperator$1$1(FTSTroopOperator.1 param1) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.fts.troop.operator", 2, "getTroopsMemberList after 24 h");
    }
    aonn.a(this.a.this$0).f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.fts.FTSTroopOperator.1.1
 * JD-Core Version:    0.7.0.1
 */
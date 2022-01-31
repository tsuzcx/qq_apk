package com.tencent.mobileqq.app;

import allj;
import com.tencent.qphone.base.util.QLog;

public class ConditionSearchManager$4
  implements Runnable
{
  public ConditionSearchManager$4(allj paramallj) {}
  
  public void run()
  {
    int i = -1;
    int j = this.this$0.a();
    if (j != 0) {
      i = this.this$0.a(j);
    }
    if (QLog.isColorLevel()) {
      QLog.d("ConditionSearch.Manager", 2, "pendCardParseRequest | check reuslt = " + j + " | update result = " + i);
    }
    if (j == 0) {
      ThreadManagerV2.excute(new ConditionSearchManager.4.1(this), 128, null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ConditionSearchManager.4
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.app;

import com.tencent.qphone.base.util.QLog;

class ConditionSearchManager$4
  implements Runnable
{
  ConditionSearchManager$4(ConditionSearchManager paramConditionSearchManager) {}
  
  public void run()
  {
    int j = this.this$0.d();
    int i;
    if (j != 0) {
      i = this.this$0.a(j);
    } else {
      i = -1;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pendCardParseRequest | check reuslt = ");
      localStringBuilder.append(j);
      localStringBuilder.append(" | update result = ");
      localStringBuilder.append(i);
      QLog.d("ConditionSearch.Manager", 2, localStringBuilder.toString());
    }
    if (j == 0) {
      ThreadManagerV2.excute(new ConditionSearchManager.4.1(this), 128, null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.ConditionSearchManager.4
 * JD-Core Version:    0.7.0.1
 */
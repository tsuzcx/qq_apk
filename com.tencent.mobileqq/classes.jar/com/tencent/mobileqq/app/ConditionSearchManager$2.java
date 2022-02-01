package com.tencent.mobileqq.app;

import com.tencent.mobileqq.conditionsearch.data.AddressHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class ConditionSearchManager$2
  implements Runnable
{
  ConditionSearchManager$2(ConditionSearchManager paramConditionSearchManager, File paramFile) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    try
    {
      ConditionSearchManager.a(this.this$0, AddressHelper.a(ConditionSearchManager.a(this.this$0), this.a));
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("updateLocal | doParse cost ");
        localStringBuilder.append((float)(System.currentTimeMillis() - l) / 1000.0F);
        localStringBuilder.append(" seconds");
        QLog.d("ConditionSearch.Manager", 2, localStringBuilder.toString());
      }
      ConditionSearchManager.a(this.this$0).runOnUiThread(new ConditionSearchManager.2.1(this));
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ConditionSearch.Manager", 2, "", localOutOfMemoryError);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.ConditionSearchManager.2
 * JD-Core Version:    0.7.0.1
 */
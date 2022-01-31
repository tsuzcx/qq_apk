package com.tencent.mobileqq.app;

import ajtw;
import ammy;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ConditionSearchManager$2
  implements Runnable
{
  public ConditionSearchManager$2(ajtw paramajtw, File paramFile) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    try
    {
      ajtw.a(this.this$0, ammy.a(ajtw.a(this.this$0), this.a));
      if (QLog.isColorLevel()) {
        QLog.d("ConditionSearch.Manager", 2, "updateLocal | doParse cost " + (float)(System.currentTimeMillis() - l) / 1000.0F + " seconds");
      }
      ajtw.a(this.this$0).runOnUiThread(new ConditionSearchManager.2.1(this));
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ConditionSearch.Manager", 2, "", localOutOfMemoryError);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ConditionSearchManager.2
 * JD-Core Version:    0.7.0.1
 */
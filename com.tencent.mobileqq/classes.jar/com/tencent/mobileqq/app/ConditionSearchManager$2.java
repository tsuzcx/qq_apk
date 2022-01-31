package com.tencent.mobileqq.app;

import alpy;
import aoif;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ConditionSearchManager$2
  implements Runnable
{
  public ConditionSearchManager$2(alpy paramalpy, File paramFile) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    try
    {
      alpy.a(this.this$0, aoif.a(alpy.a(this.this$0), this.a));
      if (QLog.isColorLevel()) {
        QLog.d("ConditionSearch.Manager", 2, "updateLocal | doParse cost " + (float)(System.currentTimeMillis() - l) / 1000.0F + " seconds");
      }
      alpy.a(this.this$0).runOnUiThread(new ConditionSearchManager.2.1(this));
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
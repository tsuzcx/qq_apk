package com.tencent.mobileqq.app;

import alqo;
import alyw;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

public class PrinterHandler$1
  extends TimerTask
{
  public PrinterHandler$1(alyw paramalyw, alqo paramalqo, Timer paramTimer) {}
  
  public void run()
  {
    if (this.this$0.a.size() > 0)
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("dataline.Printer", 4, " pc下线了");
      }
      while (this.this$0.a.size() > 0)
      {
        Iterator localIterator = this.this$0.a.keySet().iterator();
        if (localIterator.hasNext())
        {
          long l = ((Long)localIterator.next()).longValue();
          this.jdField_a_of_type_Alqo.a(0, l, true);
          this.this$0.a(Long.valueOf(l), false);
        }
      }
    }
    this.jdField_a_of_type_JavaUtilTimer.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.PrinterHandler.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.apollo.script;

import aisa;
import aisd;
import aisj;
import aisk;
import aisl;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.BlockingDeque;

public class SpriteTaskHandler$1
  implements Runnable
{
  public SpriteTaskHandler$1(aisj paramaisj) {}
  
  public void run()
  {
    aisk localaisk = (aisk)aisj.a(this.this$0).pollLast();
    aisa localaisa = aisl.a(aisj.a(this.this$0).a());
    if ((localaisa != null) && (localaisk != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("cmshow_scripted_SpriteTaskHandler", 2, new Object[] { "[addTask] not play current task, actionId:", Integer.valueOf(localaisk.f), ",but delay play" });
      }
      localaisa.a(localaisk);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteTaskHandler.1
 * JD-Core Version:    0.7.0.1
 */
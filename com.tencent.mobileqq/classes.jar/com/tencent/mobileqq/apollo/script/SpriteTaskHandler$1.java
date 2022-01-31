package com.tencent.mobileqq.apollo.script;

import ajew;
import ajez;
import ajff;
import ajfh;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.BlockingDeque;

public class SpriteTaskHandler$1
  implements Runnable
{
  public SpriteTaskHandler$1(ajff paramajff) {}
  
  public void run()
  {
    SpriteTaskParam localSpriteTaskParam = (SpriteTaskParam)ajff.a(this.this$0).pollLast();
    ajew localajew = ajfh.a(ajff.a(this.this$0).a());
    if ((localajew != null) && (localSpriteTaskParam != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("cmshow_scripted_SpriteTaskHandler", 2, new Object[] { "[addTask] not play current task, actionId:", Integer.valueOf(localSpriteTaskParam.f), ",but delay play" });
      }
      localajew.a(localSpriteTaskParam);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteTaskHandler.1
 * JD-Core Version:    0.7.0.1
 */
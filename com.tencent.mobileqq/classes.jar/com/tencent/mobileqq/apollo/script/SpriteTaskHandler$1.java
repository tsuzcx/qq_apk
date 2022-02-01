package com.tencent.mobileqq.apollo.script;

import anfx;
import anga;
import angg;
import angi;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.BlockingDeque;

public class SpriteTaskHandler$1
  implements Runnable
{
  public SpriteTaskHandler$1(angg paramangg) {}
  
  public void run()
  {
    SpriteTaskParam localSpriteTaskParam = (SpriteTaskParam)angg.a(this.this$0).pollLast();
    anfx localanfx = angi.a(angg.a(this.this$0).a());
    if ((localanfx != null) && (localSpriteTaskParam != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("cmshow_scripted_SpriteTaskHandler", 2, new Object[] { "[addTask] not play current task, actionId:", Integer.valueOf(localSpriteTaskParam.f), ",but delay play" });
      }
      localanfx.a(localSpriteTaskParam);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteTaskHandler.1
 * JD-Core Version:    0.7.0.1
 */
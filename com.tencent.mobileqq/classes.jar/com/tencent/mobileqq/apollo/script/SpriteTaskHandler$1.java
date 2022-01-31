package com.tencent.mobileqq.apollo.script;

import akwi;
import akwl;
import akwr;
import akwt;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.BlockingDeque;

public class SpriteTaskHandler$1
  implements Runnable
{
  public SpriteTaskHandler$1(akwr paramakwr) {}
  
  public void run()
  {
    SpriteTaskParam localSpriteTaskParam = (SpriteTaskParam)akwr.a(this.this$0).pollLast();
    akwi localakwi = akwt.a(akwr.a(this.this$0).a());
    if ((localakwi != null) && (localSpriteTaskParam != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("cmshow_scripted_SpriteTaskHandler", 2, new Object[] { "[addTask] not play current task, actionId:", Integer.valueOf(localSpriteTaskParam.f), ",but delay play" });
      }
      localakwi.a(localSpriteTaskParam);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteTaskHandler.1
 * JD-Core Version:    0.7.0.1
 */
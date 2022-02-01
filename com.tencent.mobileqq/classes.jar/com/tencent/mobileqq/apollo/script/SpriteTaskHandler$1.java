package com.tencent.mobileqq.apollo.script;

import com.tencent.mobileqq.apollo.api.script.ISpriteBridge;
import com.tencent.mobileqq.apollo.api.script.SpriteTaskParam;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.BlockingDeque;

class SpriteTaskHandler$1
  implements Runnable
{
  SpriteTaskHandler$1(SpriteTaskHandler paramSpriteTaskHandler) {}
  
  public void run()
  {
    SpriteTaskParam localSpriteTaskParam = (SpriteTaskParam)SpriteTaskHandler.a(this.this$0).pollLast();
    ISpriteBridge localISpriteBridge = SpriteUtil.a(SpriteTaskHandler.a(this.this$0).a());
    if ((localISpriteBridge != null) && (localSpriteTaskParam != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("cmshow_scripted_SpriteTaskHandler", 2, new Object[] { "[addTask] not play current task, actionId:", Integer.valueOf(localSpriteTaskParam.f), ",but delay play" });
      }
      localISpriteBridge.b(localSpriteTaskParam);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.script.SpriteTaskHandler.1
 * JD-Core Version:    0.7.0.1
 */
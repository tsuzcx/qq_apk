package com.tencent.mobileqq.activity.main;

import com.tencent.mobileqq.observer.GameCenterObserver;
import com.tencent.qphone.base.util.QLog;

class MainAssistObserver$8
  extends GameCenterObserver
{
  MainAssistObserver$8(MainAssistObserver paramMainAssistObserver) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    if ((paramBoolean1) && (paramBoolean2) && (paramInt != 2))
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("inform onGameCenterMsgReceive.type=");
        localStringBuilder.append(paramInt);
        QLog.d("MainActivity", 2, localStringBuilder.toString());
      }
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt != 4)
          {
            if ((paramInt != 5) && (paramInt != 6)) {
              return;
            }
            this.a.h();
            this.a.f();
            this.a.g();
            return;
          }
          this.a.h();
          return;
        }
        this.a.h();
        return;
      }
      this.a.h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.main.MainAssistObserver.8
 * JD-Core Version:    0.7.0.1
 */
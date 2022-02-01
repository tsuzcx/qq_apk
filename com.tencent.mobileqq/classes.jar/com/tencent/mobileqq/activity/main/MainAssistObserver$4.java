package com.tencent.mobileqq.activity.main;

import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.observer.QZoneObserver;
import com.tencent.qphone.base.util.QLog;

class MainAssistObserver$4
  extends QZoneObserver
{
  MainAssistObserver$4(MainAssistObserver paramMainAssistObserver) {}
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    if ((paramBoolean1) && (paramBoolean2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("MainActivity", 2, "inform onGetQZoneFeedCountFin");
      }
      if (this.a.a != null)
      {
        if (this.a.a.app == null) {
          return;
        }
        QQAppInterface localQQAppInterface = this.a.a.app;
        if ((GuardManager.a != null) && (!GuardManager.a.b())) {
          ThreadManager.post(new MainAssistObserver.4.1(this, localQQAppInterface), 8, null, false);
        }
        this.a.g();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.main.MainAssistObserver.4
 * JD-Core Version:    0.7.0.1
 */
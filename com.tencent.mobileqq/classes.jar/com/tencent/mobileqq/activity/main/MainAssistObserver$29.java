package com.tencent.mobileqq.activity.main;

import com.tencent.mobileqq.tianshu.observer.RedpointObserver;
import com.tencent.qphone.base.util.QLog;

class MainAssistObserver$29
  extends RedpointObserver
{
  MainAssistObserver$29(MainAssistObserver paramMainAssistObserver) {}
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MainAssistObserver", 2, "RedpointObserver, onUpdateSettingMe");
    }
    this.a.f();
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MainAssistObserver", 2, "RedpointObserver, onNotifyLebaRedTouch");
    }
    this.a.h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.main.MainAssistObserver.29
 * JD-Core Version:    0.7.0.1
 */
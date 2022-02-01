package com.tencent.mobileqq.activity.main;

import com.tencent.mobileqq.tianshu.observer.RedpointObserver;
import com.tencent.qphone.base.util.QLog;

class MainAssistObserver$25
  extends RedpointObserver
{
  MainAssistObserver$25(MainAssistObserver paramMainAssistObserver) {}
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MainAssistObserver", 2, "RedpointObserver, onUpdateSettingMe");
    }
    this.a.e();
  }
  
  public void b(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MainAssistObserver", 2, "RedpointObserver, onNotifyLebaRedTouch");
    }
    this.a.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.main.MainAssistObserver.25
 * JD-Core Version:    0.7.0.1
 */
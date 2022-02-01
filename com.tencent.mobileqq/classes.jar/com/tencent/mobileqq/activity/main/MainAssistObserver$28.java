package com.tencent.mobileqq.activity.main;

import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;

class MainAssistObserver$28
  implements Runnable
{
  MainAssistObserver$28(MainAssistObserver paramMainAssistObserver) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MainAssistObserver", 2, "-->onGetOpenId timeout.");
    }
    if (this.this$0.a.isFinishing()) {
      return;
    }
    MainAssistObserver localMainAssistObserver = this.this$0;
    localMainAssistObserver.s = true;
    localMainAssistObserver.q.hide();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.main.MainAssistObserver.28
 * JD-Core Version:    0.7.0.1
 */
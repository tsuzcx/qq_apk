package com.tencent.mobileqq.activity.main;

import com.tencent.mobileqq.app.QQAppInterface;
import cooperation.qzone.QZoneHelper;

class MainAssistObserver$5$1
  implements Runnable
{
  MainAssistObserver$5$1(MainAssistObserver.5 param5, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    QZoneHelper.preloadQzone(this.a, "MainAssistObserver");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.main.MainAssistObserver.5.1
 * JD-Core Version:    0.7.0.1
 */
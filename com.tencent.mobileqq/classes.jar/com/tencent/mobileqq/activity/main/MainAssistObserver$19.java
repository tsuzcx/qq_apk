package com.tencent.mobileqq.activity.main;

import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.NearbyProxy;
import com.tencent.mobileqq.observer.GetRedPointExObserver;

class MainAssistObserver$19
  extends GetRedPointExObserver
{
  MainAssistObserver$19(MainAssistObserver paramMainAssistObserver) {}
  
  public void a(Object paramObject)
  {
    this.a.g();
    if ((this.a.a != null) && (this.a.a.app != null) && (this.a.a.app.getNearbyProxy() != null)) {
      this.a.a.app.getNearbyProxy().e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.main.MainAssistObserver.19
 * JD-Core Version:    0.7.0.1
 */
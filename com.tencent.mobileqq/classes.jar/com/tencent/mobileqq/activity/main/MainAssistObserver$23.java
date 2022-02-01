package com.tencent.mobileqq.activity.main;

import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.nearby.NearbyManagerHelper;
import com.tencent.mobileqq.nearby.api.INearbyProxy;
import com.tencent.mobileqq.observer.GetRedPointExObserver;

class MainAssistObserver$23
  extends GetRedPointExObserver
{
  MainAssistObserver$23(MainAssistObserver paramMainAssistObserver) {}
  
  protected void a(Object paramObject)
  {
    this.a.h();
    if ((this.a.a != null) && (this.a.a.app != null) && (NearbyManagerHelper.a(this.a.a.app) != null)) {
      NearbyManagerHelper.a(this.a.a.app).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.main.MainAssistObserver.23
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask;

import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.QLog;

class RIJUgcVideoPublishManager$1
  implements INetInfoHandler
{
  RIJUgcVideoPublishManager$1(RIJUgcVideoPublishManager paramRIJUgcVideoPublishManager) {}
  
  public void onNetMobile2None()
  {
    RIJUgcVideoPublishManager.c(this.a);
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    RIJUgcVideoPublishManager.c(this.a);
    RIJUgcVideoPublishManager.b(this.a);
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    QLog.i("RIJUGC.RIJUgcVideoPublishManager", 1, "onNetNone2Mobile");
    RIJUgcVideoPublishManager.a(this.a);
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    RIJUgcVideoPublishManager.b(this.a);
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    QLog.i("RIJUGC.RIJUgcVideoPublishManager", 1, "onNetWifi2Mobile");
    RIJUgcVideoPublishManager.a(this.a);
  }
  
  public void onNetWifi2None() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask.RIJUgcVideoPublishManager.1
 * JD-Core Version:    0.7.0.1
 */
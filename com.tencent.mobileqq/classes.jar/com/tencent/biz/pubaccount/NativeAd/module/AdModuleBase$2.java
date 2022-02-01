package com.tencent.biz.pubaccount.NativeAd.module;

import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.QLog;

class AdModuleBase$2
  implements INetInfoHandler
{
  AdModuleBase$2(AdModuleBase paramAdModuleBase) {}
  
  public void onNetMobile2None()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdModuleBase", 2, "onNetMobile2None");
    }
    AdModuleBase.b(this.a);
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdModuleBase", 2, "onNetMobile2Wifi");
    }
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdModuleBase", 2, "onNetNone2Mobile");
    }
    AdModuleBase.b(this.a);
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdModuleBase", 2, "onNetNone2Wifi");
    }
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdModuleBase", 2, "onNetWifi2Mobile");
    }
    AdModuleBase.b(this.a);
  }
  
  public void onNetWifi2None()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AdModuleBase", 2, "onNetWifi2None");
    }
    AdModuleBase.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.module.AdModuleBase.2
 * JD-Core Version:    0.7.0.1
 */
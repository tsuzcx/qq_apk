package com.tencent.mobileqq.ark.base;

import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;

class ArkAppCenter$5
  implements INetInfoHandler
{
  ArkAppCenter$5(ArkAppCenter paramArkAppCenter) {}
  
  public void onNetMobile2None()
  {
    ArkAppCenter.a(this.a, 1, 0);
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    ArkAppCenter.a(this.a, 1, 2);
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    ArkAppCenter.a(this.a, 0, 1);
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    ArkAppCenter.a(this.a, 0, 2);
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    ArkAppCenter.a(this.a, 2, 1);
  }
  
  public void onNetWifi2None()
  {
    ArkAppCenter.a(this.a, 2, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.base.ArkAppCenter.5
 * JD-Core Version:    0.7.0.1
 */
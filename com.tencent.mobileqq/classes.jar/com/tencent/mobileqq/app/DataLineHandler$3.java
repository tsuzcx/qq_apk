package com.tencent.mobileqq.app;

import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;

class DataLineHandler$3
  implements INetInfoHandler
{
  DataLineHandler$3(DataLineHandler paramDataLineHandler) {}
  
  public void onNetMobile2None() {}
  
  public void onNetMobile2Wifi(String paramString)
  {
    this.a.b();
  }
  
  public void onNetNone2Mobile(String paramString) {}
  
  public void onNetNone2Wifi(String paramString)
  {
    this.a.b();
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    this.a.c();
  }
  
  public void onNetWifi2None()
  {
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.DataLineHandler.3
 * JD-Core Version:    0.7.0.1
 */
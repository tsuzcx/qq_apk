package com.tencent.biz.pubaccount.readinjoy.activity;

import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.QLog;

class ReadInJoyBaseDeliverActivity$NetInfoHandler
  implements INetInfoHandler
{
  private ReadInJoyBaseDeliverActivity$NetInfoHandler(ReadInJoyBaseDeliverActivity paramReadInJoyBaseDeliverActivity) {}
  
  public void onNetMobile2None()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyBaseDeliverActivity", 2, "onNetMobile2None");
    }
    this.a.b(false);
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyBaseDeliverActivity", 2, "onNetMobile2Wifi");
    }
    this.a.d(true);
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyBaseDeliverActivity", 2, "onNetNone2Mobile");
    }
    this.a.c(false);
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyBaseDeliverActivity", 2, "onNetNone2Wifi");
    }
    this.a.d(false);
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyBaseDeliverActivity", 2, "onNetWifi2Mobile");
    }
    this.a.c(true);
  }
  
  public void onNetWifi2None()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyBaseDeliverActivity", 2, "onNetWifi2None");
    }
    this.a.b(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyBaseDeliverActivity.NetInfoHandler
 * JD-Core Version:    0.7.0.1
 */
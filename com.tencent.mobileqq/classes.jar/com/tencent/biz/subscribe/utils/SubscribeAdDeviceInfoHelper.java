package com.tencent.biz.subscribe.utils;

import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;

public class SubscribeAdDeviceInfoHelper
{
  private static SubscribeAdDeviceInfoHelper a;
  private qq_ad_get.QQAdGet.DeviceInfo b;
  
  public static SubscribeAdDeviceInfoHelper a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new SubscribeAdDeviceInfoHelper();
        }
      }
      finally {}
    }
    return a;
  }
  
  public void b()
  {
    ThreadManager.getFileThreadHandler().post(new SubscribeAdDeviceInfoHelper.1(this));
  }
  
  public qq_ad_get.QQAdGet.DeviceInfo c()
  {
    b();
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.utils.SubscribeAdDeviceInfoHelper
 * JD-Core Version:    0.7.0.1
 */
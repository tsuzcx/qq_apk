package com.tencent.biz.subscribe.utils;

import com.tencent.qphone.base.util.BaseApplication;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;
import wsx;
import yys;
import yyt;
import yyu;

public class SubscribeAdDeviceInfoHelper$1
  implements Runnable
{
  public SubscribeAdDeviceInfoHelper$1(wsx paramwsx) {}
  
  public void run()
  {
    Object localObject = new yyt();
    ((yyt)localObject).a = "1b0ad2";
    localObject = yys.a(BaseApplication.getContext(), (yyt)localObject);
    wsx localwsx = this.this$0;
    if (localObject != null) {}
    for (localObject = ((yyu)localObject).a;; localObject = null)
    {
      wsx.a(localwsx, (qq_ad_get.QQAdGet.DeviceInfo)localObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.utils.SubscribeAdDeviceInfoHelper.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz.subscribe.utils;

import com.tencent.qphone.base.util.BaseApplication;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;
import weg;
import yoy;
import yoz;
import ypa;

public class SubscribeAdDeviceInfoHelper$1
  implements Runnable
{
  public SubscribeAdDeviceInfoHelper$1(weg paramweg) {}
  
  public void run()
  {
    Object localObject = new yoz();
    ((yoz)localObject).a = "1b0ad2";
    localObject = yoy.a(BaseApplication.getContext(), (yoz)localObject);
    weg localweg = this.this$0;
    if (localObject != null) {}
    for (localObject = ((ypa)localObject).a;; localObject = null)
    {
      weg.a(localweg, (qq_ad_get.QQAdGet.DeviceInfo)localObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.utils.SubscribeAdDeviceInfoHelper.1
 * JD-Core Version:    0.7.0.1
 */
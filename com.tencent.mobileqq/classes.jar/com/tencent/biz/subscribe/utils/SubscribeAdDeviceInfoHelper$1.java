package com.tencent.biz.subscribe.utils;

import aand;
import acwb;
import acwc;
import acwd;
import com.tencent.qphone.base.util.BaseApplication;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;

public class SubscribeAdDeviceInfoHelper$1
  implements Runnable
{
  public SubscribeAdDeviceInfoHelper$1(aand paramaand) {}
  
  public void run()
  {
    Object localObject = new acwc();
    ((acwc)localObject).a = "1b0ad2";
    localObject = acwb.a(BaseApplication.getContext(), (acwc)localObject);
    aand localaand = this.this$0;
    if (localObject != null) {}
    for (localObject = ((acwd)localObject).a;; localObject = null)
    {
      aand.a(localaand, (qq_ad_get.QQAdGet.DeviceInfo)localObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.utils.SubscribeAdDeviceInfoHelper.1
 * JD-Core Version:    0.7.0.1
 */
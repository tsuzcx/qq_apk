package com.tencent.biz.subscribe.utils;

import com.tencent.gdtad.util.GdtDeviceInfoHelper;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Params;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Result;
import com.tencent.qphone.base.util.BaseApplication;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;

class SubscribeAdDeviceInfoHelper$1
  implements Runnable
{
  SubscribeAdDeviceInfoHelper$1(SubscribeAdDeviceInfoHelper paramSubscribeAdDeviceInfoHelper) {}
  
  public void run()
  {
    Object localObject = new GdtDeviceInfoHelper.Params();
    ((GdtDeviceInfoHelper.Params)localObject).a = "1b0ad2";
    localObject = GdtDeviceInfoHelper.a(BaseApplication.getContext(), (GdtDeviceInfoHelper.Params)localObject);
    SubscribeAdDeviceInfoHelper localSubscribeAdDeviceInfoHelper = this.this$0;
    if (localObject != null) {}
    for (localObject = ((GdtDeviceInfoHelper.Result)localObject).a;; localObject = null)
    {
      SubscribeAdDeviceInfoHelper.a(localSubscribeAdDeviceInfoHelper, (qq_ad_get.QQAdGet.DeviceInfo)localObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.utils.SubscribeAdDeviceInfoHelper.1
 * JD-Core Version:    0.7.0.1
 */
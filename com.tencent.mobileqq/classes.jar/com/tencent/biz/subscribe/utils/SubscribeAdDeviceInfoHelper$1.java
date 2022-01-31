package com.tencent.biz.subscribe.utils;

import aatd;
import aate;
import aatf;
import com.tencent.qphone.base.util.BaseApplication;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;
import ylz;

public class SubscribeAdDeviceInfoHelper$1
  implements Runnable
{
  public SubscribeAdDeviceInfoHelper$1(ylz paramylz) {}
  
  public void run()
  {
    Object localObject = new aate();
    ((aate)localObject).a = "1b0ad2";
    localObject = aatd.a(BaseApplication.getContext(), (aate)localObject);
    ylz localylz = this.this$0;
    if (localObject != null) {}
    for (localObject = ((aatf)localObject).a;; localObject = null)
    {
      ylz.a(localylz, (qq_ad_get.QQAdGet.DeviceInfo)localObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.subscribe.utils.SubscribeAdDeviceInfoHelper.1
 * JD-Core Version:    0.7.0.1
 */
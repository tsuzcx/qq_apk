package com.tencent.biz.subscribe.utils;

import aaoo;
import aaop;
import aaoq;
import com.tencent.qphone.base.util.BaseApplication;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;
import yhm;

public class SubscribeAdDeviceInfoHelper$1
  implements Runnable
{
  public SubscribeAdDeviceInfoHelper$1(yhm paramyhm) {}
  
  public void run()
  {
    Object localObject = new aaop();
    ((aaop)localObject).a = "1b0ad2";
    localObject = aaoo.a(BaseApplication.getContext(), (aaop)localObject);
    yhm localyhm = this.this$0;
    if (localObject != null) {}
    for (localObject = ((aaoq)localObject).a;; localObject = null)
    {
      yhm.a(localyhm, (qq_ad_get.QQAdGet.DeviceInfo)localObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.subscribe.utils.SubscribeAdDeviceInfoHelper.1
 * JD-Core Version:    0.7.0.1
 */
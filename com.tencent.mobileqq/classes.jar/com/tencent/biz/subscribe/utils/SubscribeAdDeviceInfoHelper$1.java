package com.tencent.biz.subscribe.utils;

import com.tencent.qphone.base.util.BaseApplication;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;
import wsu;
import yyp;
import yyq;
import yyr;

public class SubscribeAdDeviceInfoHelper$1
  implements Runnable
{
  public SubscribeAdDeviceInfoHelper$1(wsu paramwsu) {}
  
  public void run()
  {
    Object localObject = new yyq();
    ((yyq)localObject).a = "1b0ad2";
    localObject = yyp.a(BaseApplication.getContext(), (yyq)localObject);
    wsu localwsu = this.this$0;
    if (localObject != null) {}
    for (localObject = ((yyr)localObject).a;; localObject = null)
    {
      wsu.a(localwsu, (qq_ad_get.QQAdGet.DeviceInfo)localObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.utils.SubscribeAdDeviceInfoHelper.1
 * JD-Core Version:    0.7.0.1
 */
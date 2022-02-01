package com.tencent.mobileqq.app.soso;

import com.tencent.gdtad.util.GdtDeviceInfoHelper;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Params;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Result;
import com.tencent.gdtad.util.GdtManager;
import com.tencent.gdtad.util.GdtManager.Params;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.soso.location.inject.ILbsGdtUtilsProcessor;
import com.tencent.qphone.base.util.BaseApplication;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;

public class LbsGdtProcessorProxy
  implements ILbsGdtUtilsProcessor
{
  public String getOaid()
  {
    String str = "";
    GdtManager.a().a(BaseApplication.getContext(), new GdtManager.Params());
    Object localObject = new GdtDeviceInfoHelper.Params();
    ((GdtDeviceInfoHelper.Params)localObject).a = "8b5c3a";
    localObject = GdtDeviceInfoHelper.a(BaseApplication.getContext(), (GdtDeviceInfoHelper.Params)localObject);
    if (localObject != null) {}
    for (localObject = ((GdtDeviceInfoHelper.Result)localObject).a;; localObject = null)
    {
      if (localObject != null) {
        str = ((qq_ad_get.QQAdGet.DeviceInfo)localObject).aid_ticket.get();
      }
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.soso.LbsGdtProcessorProxy
 * JD-Core Version:    0.7.0.1
 */
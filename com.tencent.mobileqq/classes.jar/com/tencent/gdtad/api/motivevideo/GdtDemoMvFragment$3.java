package com.tencent.gdtad.api.motivevideo;

import android.app.Activity;
import com.tencent.gdtad.util.GdtDeviceInfoHelper;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Params;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Result;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;

class GdtDemoMvFragment$3
  implements Runnable
{
  GdtDemoMvFragment$3(GdtDemoMvFragment paramGdtDemoMvFragment, Activity paramActivity) {}
  
  public void run()
  {
    Object localObject = new GdtDeviceInfoHelper.Params();
    ((GdtDeviceInfoHelper.Params)localObject).a = "d61533";
    localObject = GdtDeviceInfoHelper.a(this.a, (GdtDeviceInfoHelper.Params)localObject);
    if ((localObject != null) && (((GdtDeviceInfoHelper.Result)localObject).jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo != null) && (((GdtDeviceInfoHelper.Result)localObject).jdField_a_of_type_JavaUtilList != null))
    {
      StringBuffer localStringBuffer = new StringBuffer("getDeviceInfo success");
      localStringBuffer.append("\n aid_ticket = ");
      localStringBuffer.append(((GdtDeviceInfoHelper.Result)localObject).jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.aid_ticket.get());
      localStringBuffer.append("\n taid_ticket = ");
      localStringBuffer.append(((GdtDeviceInfoHelper.Result)localObject).jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.taid_ticket.get());
      localStringBuffer.append("\n os_type = ");
      localStringBuffer.append(((GdtDeviceInfoHelper.Result)localObject).jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.os_type.get());
      localStringBuffer.append("\n md5_android_id = ");
      localStringBuffer.append(((GdtDeviceInfoHelper.Result)localObject).jdField_a_of_type_TencentGdtQq_ad_get$QQAdGet$DeviceInfo.md5_android_id.get());
      QLog.i("GdtDemoMvFragment", 1, localStringBuffer.toString());
      this.this$0.a("getDeviceInfo success");
      return;
    }
    QLog.i("GdtDemoMvFragment", 1, "deviceInfoResult.deviceInfo == null");
    this.this$0.a("getDeviceInfo failed");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.api.motivevideo.GdtDemoMvFragment.3
 * JD-Core Version:    0.7.0.1
 */
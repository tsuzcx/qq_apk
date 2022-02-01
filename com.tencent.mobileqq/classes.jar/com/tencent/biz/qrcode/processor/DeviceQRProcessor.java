package com.tencent.biz.qrcode.processor;

import android.app.Activity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.DeviceScanner;
import com.tencent.device.utils.SmartDeviceReport;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.qrscan.OnQRHandleResultCallback;
import com.tencent.mobileqq.qrscan.ScannerParams;
import mqq.app.AppRuntime;

@KeepClassConstructor
public class DeviceQRProcessor
  extends BaseQRScanResultProcessor
{
  public DeviceQRProcessor(AppRuntime paramAppRuntime, OnQRHandleResultCallback paramOnQRHandleResultCallback)
  {
    super(paramAppRuntime, paramOnQRHandleResultCallback);
  }
  
  public String a()
  {
    return "DeviceQRProcessor";
  }
  
  public boolean a(int paramInt, String paramString1, String paramString2, ScannerParams paramScannerParams)
  {
    paramString1 = paramString1.toLowerCase();
    return (a(paramInt)) && ((paramString1.startsWith("http://iot.qq.com/add")) || (("ScanSmartDevice".equals(paramScannerParams.b)) && (!paramString1.startsWith("http://qqapp.eprintsw.com"))));
  }
  
  public boolean a(String paramString1, String paramString2, ScannerParams paramScannerParams)
  {
    paramString2 = (Activity)this.b.d();
    String str = paramString1.toLowerCase();
    if ((!str.startsWith("http://iot.qq.com/add")) && ((!"ScanSmartDevice".equals(paramScannerParams.b)) || (str.startsWith("http://qqapp.eprintsw.com")))) {
      return false;
    }
    SmartDeviceReport.a().a(1);
    SmartDeviceReport.a().b = "";
    SmartDeviceReport.a().c = 0;
    SmartDeviceReport.a().a(BaseApplicationImpl.getApplication().getRuntime(), "Usr_Entrance", 1);
    if (DeviceScanner.openDeviceQCodeUrl(paramString2, this.b, paramString1)) {
      this.b.b();
    }
    return true;
  }
  
  public boolean b()
  {
    return super.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.processor.DeviceQRProcessor
 * JD-Core Version:    0.7.0.1
 */
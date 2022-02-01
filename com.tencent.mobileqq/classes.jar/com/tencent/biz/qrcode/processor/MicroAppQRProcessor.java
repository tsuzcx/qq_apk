package com.tencent.biz.qrcode.processor;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.qrscan.OnQRHandleResultCallback;
import com.tencent.mobileqq.qrscan.ScannerParams;
import mqq.app.AppRuntime;

@KeepClassConstructor
public class MicroAppQRProcessor
  extends BaseQRScanResultProcessor
{
  public MicroAppQRProcessor(AppRuntime paramAppRuntime, OnQRHandleResultCallback paramOnQRHandleResultCallback)
  {
    super(paramAppRuntime, paramOnQRHandleResultCallback);
  }
  
  public String a()
  {
    return "MicroAppQRProcessor";
  }
  
  public boolean a(int paramInt, String paramString1, String paramString2, ScannerParams paramScannerParams)
  {
    return (a(paramInt)) && ("micro_app".equals(paramScannerParams.b));
  }
  
  public boolean a(String paramString1, String paramString2, ScannerParams paramScannerParams)
  {
    paramScannerParams = new Intent("com.tencent.mobileqq.microapp.out.plugins.scanResultAction");
    if (paramString2 != null) {
      if (paramString2.equalsIgnoreCase("QR_CODE")) {
        paramScannerParams.putExtra("com.tencent.mobileqq.microapp.out.plugins.scanResultType", 2);
      } else {
        paramScannerParams.putExtra("com.tencent.mobileqq.microapp.out.plugins.scanResultType", 1);
      }
    }
    paramScannerParams.putExtra("com.tencent.mobileqq.microapp.out.plugins.scanResultData", paramString1);
    this.b.d().sendBroadcast(paramScannerParams, "com.tencent.msg.permission.pushnotify");
    this.b.b();
    return true;
  }
  
  public boolean b()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.processor.MicroAppQRProcessor
 * JD-Core Version:    0.7.0.1
 */
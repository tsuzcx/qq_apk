package com.tencent.biz.qrcode.processor;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.qrscan.OnQRHandleResultCallback;
import com.tencent.mobileqq.qrscan.ScannerParams;
import mqq.app.AppRuntime;

@KeepClassConstructor
public class ArkQRProcessor
  extends BaseQRScanResultProcessor
{
  public ArkQRProcessor(AppRuntime paramAppRuntime, OnQRHandleResultCallback paramOnQRHandleResultCallback)
  {
    super(paramAppRuntime, paramOnQRHandleResultCallback);
  }
  
  public String a()
  {
    return "ArkQRProcessor";
  }
  
  public boolean a(int paramInt, String paramString1, String paramString2, ScannerParams paramScannerParams)
  {
    paramString1.toLowerCase();
    return (a(paramInt)) && ("com.tencent.ark.scan".equals(paramScannerParams.b));
  }
  
  public boolean a(String paramString1, String paramString2, ScannerParams paramScannerParams)
  {
    paramScannerParams = new Intent("com.tencent.mobileqq.ark.api.scanResultAction");
    paramScannerParams.putExtra("com.tencent.ark.scanResultData", paramString1);
    paramScannerParams.putExtra("com.tencent.ark.scanResultType", paramString2);
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
 * Qualified Name:     com.tencent.biz.qrcode.processor.ArkQRProcessor
 * JD-Core Version:    0.7.0.1
 */
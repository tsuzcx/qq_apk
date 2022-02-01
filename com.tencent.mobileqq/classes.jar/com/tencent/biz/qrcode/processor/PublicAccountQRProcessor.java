package com.tencent.biz.qrcode.processor;

import android.content.Context;
import android.content.Intent;
import com.tencent.biz.pubaccount.api.IPublicAccountManager;
import com.tencent.biz.pubaccount.api.IPublicAccountProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.qrscan.OnQRHandleResultCallback;
import com.tencent.mobileqq.qrscan.ScannerParams;
import mqq.app.AppRuntime;

@KeepClassConstructor
public class PublicAccountQRProcessor
  extends BaseQRScanResultProcessor
{
  public PublicAccountQRProcessor(AppRuntime paramAppRuntime, OnQRHandleResultCallback paramOnQRHandleResultCallback)
  {
    super(paramAppRuntime, paramOnQRHandleResultCallback);
  }
  
  public String a()
  {
    return "PublicAccountQRProcessor";
  }
  
  public boolean a()
  {
    return true;
  }
  
  public boolean a(int paramInt, String paramString1, String paramString2, ScannerParams paramScannerParams)
  {
    return (a(paramInt)) && (((IPublicAccountProxy)QRoute.api(IPublicAccountProxy.class)).getImplName(IPublicAccountManager.class).equals(paramScannerParams.a));
  }
  
  public boolean a(String paramString1, String paramString2, ScannerParams paramScannerParams)
  {
    paramScannerParams = new Intent("com.tencent.biz.pubaccount.scanResultAction");
    if (paramString2 != null) {
      if (paramString2.equalsIgnoreCase("QR_CODE")) {
        paramScannerParams.putExtra("com.tencent.biz.pubaccount.scanResultType", 2);
      } else {
        paramScannerParams.putExtra("com.tencent.biz.pubaccount.scanResultType", 1);
      }
    }
    paramScannerParams.putExtra("com.tencent.biz.pubaccount.scanResultData", paramString1);
    this.a.a().sendBroadcast(paramScannerParams, "com.tencent.msg.permission.pushnotify");
    this.a.b();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.processor.PublicAccountQRProcessor
 * JD-Core Version:    0.7.0.1
 */
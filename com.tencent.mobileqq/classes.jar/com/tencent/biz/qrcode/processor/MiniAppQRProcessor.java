package com.tencent.biz.qrcode.processor;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.microapp.sdk.MiniAppLauncher;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.qrscan.OnQRHandleResultCallback;
import com.tencent.mobileqq.qrscan.ScannerParams;
import mqq.app.AppRuntime;

@KeepClassConstructor
public class MiniAppQRProcessor
  extends BaseQRScanResultProcessor
{
  public MiniAppQRProcessor(AppRuntime paramAppRuntime, OnQRHandleResultCallback paramOnQRHandleResultCallback)
  {
    super(paramAppRuntime, paramOnQRHandleResultCallback);
  }
  
  public String a()
  {
    return "MiniAppQRProcessor";
  }
  
  public boolean a()
  {
    return super.a();
  }
  
  public boolean a(int paramInt, String paramString1, String paramString2, ScannerParams paramScannerParams)
  {
    paramString1 = paramString1.toLowerCase();
    return (a(paramInt)) && (("mini_app".equals(paramScannerParams.a)) || (MiniAppLauncher.isMiniAppUrl(paramString1)) || (((IMiniAppService)QRoute.api(IMiniAppService.class)).isMiniAppUrl(paramString1)));
  }
  
  public boolean a(String paramString1, String paramString2, ScannerParams paramScannerParams)
  {
    String str = paramString1.toLowerCase();
    Activity localActivity = (Activity)this.a.a();
    if ("mini_app".equals(paramScannerParams.a))
    {
      paramScannerParams = new Intent("com.tencent.mobileqq.mini.out.plugins.scanResultAction");
      paramScannerParams.putExtra("com.tencent.mobileqq.mini.out.plugins.scanResultType", paramString2);
      paramScannerParams.putExtra("com.tencent.mobileqq.mini.out.plugins.scanResultData", paramString1);
      this.a.a().sendBroadcast(paramScannerParams, "com.tencent.msg.permission.pushnotify");
      this.a.b();
      return true;
    }
    if (MiniAppLauncher.isMiniAppUrl(str))
    {
      MiniAppLauncher.launchMiniAppByScanCode(localActivity, paramString1);
      this.a.b();
      return true;
    }
    if (((IMiniAppService)QRoute.api(IMiniAppService.class)).isMiniAppUrl(str))
    {
      int i;
      if (paramScannerParams.b) {
        i = 1012;
      } else {
        i = 1011;
      }
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(localActivity, paramString1, i, null);
      this.a.b();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.processor.MiniAppQRProcessor
 * JD-Core Version:    0.7.0.1
 */
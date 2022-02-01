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
import com.tencent.mobileqq.wxmini.api.IWxMiniManager;
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
  
  public boolean a(int paramInt, String paramString1, String paramString2, ScannerParams paramScannerParams)
  {
    paramString1 = paramString1.toLowerCase();
    return ((a(paramInt)) && (("mini_app".equals(paramScannerParams.b)) || (MiniAppLauncher.isMiniAppUrl(paramString1)) || (((IMiniAppService)QRoute.api(IMiniAppService.class)).isMiniAppUrl(paramString1)))) || (((IWxMiniManager)QRoute.api(IWxMiniManager.class)).isWxMiniApp(paramString1));
  }
  
  public boolean a(String paramString1, String paramString2, ScannerParams paramScannerParams)
  {
    String str = paramString1.toLowerCase();
    Activity localActivity = (Activity)this.b.d();
    if ("mini_app".equals(paramScannerParams.b))
    {
      paramScannerParams = new Intent("com.tencent.mobileqq.mini.out.plugins.scanResultAction");
      paramScannerParams.putExtra("com.tencent.mobileqq.mini.out.plugins.scanResultType", paramString2);
      paramScannerParams.putExtra("com.tencent.mobileqq.mini.out.plugins.scanResultData", paramString1);
      this.b.d().sendBroadcast(paramScannerParams, "com.tencent.msg.permission.pushnotify");
      this.b.b();
      return true;
    }
    boolean bool = ((IWxMiniManager)QRoute.api(IWxMiniManager.class)).isWxMiniApp(paramString1);
    int i = 1012;
    if (bool)
    {
      if (!paramScannerParams.e) {
        i = 1011;
      }
      ((IWxMiniManager)QRoute.api(IWxMiniManager.class)).startWxMiniApp(localActivity, paramString1, 1, i);
      this.b.b();
      return true;
    }
    if (MiniAppLauncher.isMiniAppUrl(str))
    {
      MiniAppLauncher.launchMiniAppByScanCode(localActivity, paramString1);
      this.b.b();
      return true;
    }
    if (((IMiniAppService)QRoute.api(IMiniAppService.class)).isMiniAppUrl(str))
    {
      if (!paramScannerParams.e) {
        i = 1011;
      }
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(localActivity, paramString1, i, null);
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
 * Qualified Name:     com.tencent.biz.qrcode.processor.MiniAppQRProcessor
 * JD-Core Version:    0.7.0.1
 */
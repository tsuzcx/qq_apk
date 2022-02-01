package com.tencent.biz.qrcode.processor;

import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.qrscan.OnQRHandleResultCallback;
import com.tencent.mobileqq.qrscan.ScannerParams;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

@KeepClassConstructor
public class MiniCodeQRProcessor
  extends BaseQRScanResultProcessor
{
  public MiniCodeQRProcessor(AppRuntime paramAppRuntime, OnQRHandleResultCallback paramOnQRHandleResultCallback)
  {
    super(paramAppRuntime, paramOnQRHandleResultCallback);
  }
  
  public String a()
  {
    return "MiniCodeQRProcessor";
  }
  
  public boolean a()
  {
    return true;
  }
  
  public boolean a(int paramInt, String paramString1, String paramString2, ScannerParams paramScannerParams)
  {
    paramString1.toLowerCase();
    return b(paramInt);
  }
  
  public boolean a(String paramString1, String paramString2, ScannerParams paramScannerParams)
  {
    if (QLog.isColorLevel()) {
      QLog.i("BaseQRScanResultProcessor.MiniCodeProcessor", 2, String.format("jumpMiniCode result=%s", new Object[] { paramString1 }));
    }
    ((IMiniAppService)QRoute.api(IMiniAppService.class)).launchAppByMiniCode(this.a.a(), paramString1, 1048, null);
    this.a.b();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.processor.MiniCodeQRProcessor
 * JD-Core Version:    0.7.0.1
 */
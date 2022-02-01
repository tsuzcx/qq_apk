package com.tencent.biz.qrcode.processor;

import android.app.Activity;
import com.tencent.hippy.qq.utils.HippyCommonUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.qrscan.OnQRHandleResultCallback;
import com.tencent.mobileqq.qrscan.ScannerParams;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;

@KeepClassConstructor
public class HippyQRProcessor
  extends BaseQRScanResultProcessor
{
  public HippyQRProcessor(AppRuntime paramAppRuntime, OnQRHandleResultCallback paramOnQRHandleResultCallback)
  {
    super(paramAppRuntime, paramOnQRHandleResultCallback);
  }
  
  public String a()
  {
    return "HippyQRProcessor";
  }
  
  public boolean a(int paramInt, String paramString1, String paramString2, ScannerParams paramScannerParams)
  {
    return (a(paramInt)) && (HippyCommonUtils.checkHippyQRCode(paramString1));
  }
  
  public boolean a(String paramString1, String paramString2, ScannerParams paramScannerParams)
  {
    if (!(this.a instanceof QQAppInterface)) {
      return false;
    }
    paramString2 = (QQAppInterface)this.a;
    paramScannerParams = (Activity)this.b.d();
    if (HippyCommonUtils.checkHippyQRCode(paramString1))
    {
      HippyCommonUtils.checkDebugHippyUpdate(paramString2, (AppActivity)paramScannerParams, paramString1);
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
 * Qualified Name:     com.tencent.biz.qrcode.processor.HippyQRProcessor
 * JD-Core Version:    0.7.0.1
 */
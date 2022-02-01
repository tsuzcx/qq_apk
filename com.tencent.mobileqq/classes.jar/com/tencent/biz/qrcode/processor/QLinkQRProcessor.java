package com.tencent.biz.qrcode.processor;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.qrscan.OnQRHandleResultCallback;
import com.tencent.mobileqq.qrscan.ScannerParams;
import com.tencent.mobileqq.utils.AudioUtil;
import cooperation.qlink.QQProxyForQlink;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;

@KeepClassConstructor
public class QLinkQRProcessor
  extends BaseQRScanResultProcessor
{
  public QLinkQRProcessor(AppRuntime paramAppRuntime, OnQRHandleResultCallback paramOnQRHandleResultCallback)
  {
    super(paramAppRuntime, paramOnQRHandleResultCallback);
  }
  
  public String a()
  {
    return "QLinkQRProcessor";
  }
  
  public boolean a(int paramInt, String paramString1, String paramString2, ScannerParams paramScannerParams)
  {
    paramString1 = paramString1.toLowerCase();
    return (a(paramInt)) && ((paramString1.startsWith("qqf2f://qf/")) || ("qlink".equalsIgnoreCase(paramScannerParams.b)));
  }
  
  public boolean a(String paramString1, String paramString2, ScannerParams paramScannerParams)
  {
    if (!(this.a instanceof QQAppInterface)) {
      return false;
    }
    paramString2 = (QQAppInterface)this.a;
    AppActivity localAppActivity = (AppActivity)this.b.d();
    if (paramString1.toLowerCase().startsWith("qqf2f://qf/"))
    {
      if ((!paramString2.isRingerVibrate()) && (!paramString2.isRingerSilent()) && (!paramString2.isRingEqualsZero())) {
        AudioUtil.b(2131230835, false);
      }
      paramString2.getQQProxyForQlink().a(localAppActivity, paramString1, this.b);
      return true;
    }
    if ("qlink".equalsIgnoreCase(paramScannerParams.b))
    {
      paramString2.getQQProxyForQlink().a(localAppActivity, this.b);
      return true;
    }
    return false;
  }
  
  public boolean b()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.processor.QLinkQRProcessor
 * JD-Core Version:    0.7.0.1
 */
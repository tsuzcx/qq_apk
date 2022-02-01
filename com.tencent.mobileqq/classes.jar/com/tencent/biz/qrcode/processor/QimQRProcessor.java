package com.tencent.biz.qrcode.processor;

import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.qrscan.OnQRHandleResultCallback;
import com.tencent.mobileqq.qrscan.ScannerParams;
import com.tencent.mobileqq.qrscan.utils.QRUtils;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;

@KeepClassConstructor
public class QimQRProcessor
  extends BaseQRScanResultProcessor
{
  public QimQRProcessor(AppRuntime paramAppRuntime, OnQRHandleResultCallback paramOnQRHandleResultCallback)
  {
    super(paramAppRuntime, paramOnQRHandleResultCallback);
  }
  
  public static void a(String paramString, AppActivity paramAppActivity)
  {
    paramAppActivity = new Intent(paramAppActivity, QQBrowserActivity.class);
    paramAppActivity.putExtra("key_isReadModeEnabled", true);
    paramAppActivity.putExtra("fromQrcode", true);
    paramAppActivity.putExtra("url", paramString);
  }
  
  public String a()
  {
    return "QimQRProcessor";
  }
  
  public boolean a()
  {
    return super.a();
  }
  
  public boolean a(int paramInt, String paramString1, String paramString2, ScannerParams paramScannerParams)
  {
    boolean bool;
    if ((a(paramInt)) && (QRUtils.a(paramString1))) {
      bool = true;
    } else {
      bool = false;
    }
    QLog.d("IQRScanConst_BaseQRScanResultProcessor", 1, String.format("intercept proc=[%s] intercept=%b result=%s", new Object[] { a(), Boolean.valueOf(bool), paramString1 }));
    return bool;
  }
  
  public boolean a(String paramString1, String paramString2, ScannerParams paramScannerParams)
  {
    paramString2 = (AppActivity)this.a.a();
    if (QRUtils.a(paramString1))
    {
      a(paramString1, paramString2);
      this.a.b();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.processor.QimQRProcessor
 * JD-Core Version:    0.7.0.1
 */
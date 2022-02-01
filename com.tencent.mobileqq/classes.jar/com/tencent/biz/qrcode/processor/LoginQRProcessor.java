package com.tencent.biz.qrcode.processor;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.qrcode.activity.QRLoginAuthActivity;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.qrscan.OnQRHandleResultCallback;
import com.tencent.mobileqq.qrscan.ScannerParams;
import com.tencent.open.agent.QrAgentLoginManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

@KeepClassConstructor
public class LoginQRProcessor
  extends BaseQRScanResultProcessor
{
  public LoginQRProcessor(AppRuntime paramAppRuntime, OnQRHandleResultCallback paramOnQRHandleResultCallback)
  {
    super(paramAppRuntime, paramOnQRHandleResultCallback);
  }
  
  public String a()
  {
    return "LoginQRProcessor";
  }
  
  public boolean a(int paramInt, String paramString1, String paramString2, ScannerParams paramScannerParams)
  {
    paramString2 = paramString1.toLowerCase();
    boolean bool;
    if ((a(paramInt)) && (QRUtils.j(paramString2)) && (!QRUtils.a(paramString2))) {
      bool = true;
    } else {
      bool = false;
    }
    QLog.d("IQRScanConst_BaseQRScanResultProcessor", 1, String.format("intercept proc=[%s] intercept=%b result=%s", new Object[] { a(), Boolean.valueOf(bool), paramString1 }));
    return bool;
  }
  
  public boolean a(String paramString1, String paramString2, ScannerParams paramScannerParams)
  {
    if (!(this.a instanceof QQAppInterface)) {
      return false;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)this.a;
    paramString2 = (Activity)this.b.d();
    String str = paramString1.toLowerCase();
    if ((QRUtils.j(str)) && (!QRUtils.a(str)))
    {
      if (QrAgentLoginManager.a)
      {
        this.b.a(true);
        QrAgentLoginManager.a().a(localQQAppInterface, paramString1, this.b, TextUtils.isEmpty(paramScannerParams.d) ^ true);
        return true;
      }
      this.b.a(true);
      paramScannerParams = new Intent(this.b.d(), QRLoginAuthActivity.class);
      paramScannerParams.putExtra("QR_CODE_STRING", paramString1);
      paramString2.startActivity(paramScannerParams);
      this.b.b();
      return true;
    }
    return false;
  }
  
  public boolean b()
  {
    return super.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.processor.LoginQRProcessor
 * JD-Core Version:    0.7.0.1
 */
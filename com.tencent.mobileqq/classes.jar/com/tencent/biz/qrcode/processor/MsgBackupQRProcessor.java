package com.tencent.biz.qrcode.processor;

import android.content.Intent;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.msgbackup.fragment.MsgBackupTransportFragment;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.qrscan.OnQRHandleResultCallback;
import com.tencent.mobileqq.qrscan.ScannerParams;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;

@KeepClassConstructor
public class MsgBackupQRProcessor
  extends BaseQRScanResultProcessor
{
  public MsgBackupQRProcessor(AppRuntime paramAppRuntime, OnQRHandleResultCallback paramOnQRHandleResultCallback)
  {
    super(paramAppRuntime, paramOnQRHandleResultCallback);
  }
  
  public static void a(String paramString, AppActivity paramAppActivity)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("msgbackup_qr_sig", paramString);
    localIntent.putExtra("param_start", 4);
    QPublicFragmentActivity.start(paramAppActivity, localIntent, MsgBackupTransportFragment.class);
  }
  
  public String a()
  {
    return "MsgBackupQRProcessor";
  }
  
  public boolean a()
  {
    return super.a();
  }
  
  public boolean a(int paramInt, String paramString1, String paramString2, ScannerParams paramScannerParams)
  {
    return (a(paramInt)) && (paramString1.startsWith("https://qzs.qzone.qq.com/qzone/qzact/act/external/qzone-platform/qq-web/low_app_version_chat_recored.html?flag=chatmigrate"));
  }
  
  public boolean a(String paramString1, String paramString2, ScannerParams paramScannerParams)
  {
    if (paramString1.startsWith("https://qzs.qzone.qq.com/qzone/qzact/act/external/qzone-platform/qq-web/low_app_version_chat_recored.html?flag=chatmigrate"))
    {
      a(paramString1, (AppActivity)this.a.a());
      this.a.b();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.processor.MsgBackupQRProcessor
 * JD-Core Version:    0.7.0.1
 */
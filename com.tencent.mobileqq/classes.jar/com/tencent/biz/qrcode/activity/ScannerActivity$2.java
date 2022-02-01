package com.tencent.biz.qrcode.activity;

import com.tencent.biz.qrcode.ipc.QrHandleResultCallBack;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class ScannerActivity$2
  implements QrHandleResultCallBack
{
  ScannerActivity$2(ScannerActivity paramScannerActivity) {}
  
  public JSONObject a()
  {
    try
    {
      JSONObject localJSONObject = ScannerActivity.a(this.a);
      return localJSONObject;
    }
    catch (Throwable localThrowable)
    {
      QLog.i("ScannerActivity", 1, "getQRReportParams error: " + localThrowable.getMessage());
    }
    return null;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScannerActivity", 2, "restartDecodeFrame");
    }
    this.a.finish();
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScannerActivity", 2, "cameraOn");
    }
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.ScannerActivity.2
 * JD-Core Version:    0.7.0.1
 */
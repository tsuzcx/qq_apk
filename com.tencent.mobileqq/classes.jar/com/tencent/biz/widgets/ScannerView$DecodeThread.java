package com.tencent.biz.widgets;

import android.os.HandlerThread;
import android.os.Process;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.QBarConstants;
import com.tencent.mobileqq.qrscan.api.IQRCodeApi;
import com.tencent.qphone.base.util.QLog;

class ScannerView$DecodeThread
  extends HandlerThread
{
  public boolean a = false;
  
  public ScannerView$DecodeThread(ScannerView paramScannerView, String paramString)
  {
    super(paramString);
  }
  
  public boolean quit()
  {
    this.a = true;
    if (QLog.isColorLevel()) {
      QLog.d("ScannerView", 2, "decode thread quit");
    }
    try
    {
      ((IQRCodeApi)QRoute.api(IQRCodeApi.class)).releaseForCamera();
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      if (QLog.isColorLevel()) {
        QLog.w("ScannerView", 2, localUnsatisfiedLinkError.toString());
      }
    }
    return super.quit();
  }
  
  public void run()
  {
    Process.setThreadPriority(-20);
    try
    {
      int i = ((IQRCodeApi)QRoute.api(IQRCodeApi.class)).initForCamera(0, "ANY", "UTF-8");
      int j = ((IQRCodeApi)QRoute.api(IQRCodeApi.class)).setReadersForCamera(QBarConstants.c);
      String str = ((IQRCodeApi)QRoute.api(IQRCodeApi.class)).getVersion();
      if (QLog.isDevelopLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("init for camera init_result1:");
        localStringBuilder.append(i);
        localStringBuilder.append(",init_result2:");
        localStringBuilder.append(j);
        QLog.d("ScannerView", 4, localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("version:");
        localStringBuilder.append(str);
        QLog.d("ScannerView", 4, localStringBuilder.toString());
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      if (QLog.isColorLevel()) {
        QLog.w("ScannerView", 2, localUnsatisfiedLinkError.toString());
      }
    }
    super.run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.widgets.ScannerView.DecodeThread
 * JD-Core Version:    0.7.0.1
 */
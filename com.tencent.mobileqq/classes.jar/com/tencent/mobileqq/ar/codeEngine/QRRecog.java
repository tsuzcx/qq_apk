package com.tencent.mobileqq.ar.codeEngine;

import android.os.Handler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.QBarConstants;
import com.tencent.mobileqq.qrscan.ScannerResult;
import com.tencent.mobileqq.qrscan.api.IQRCodeApi;
import com.tencent.qphone.base.util.QLog;

public class QRRecog
{
  boolean a = false;
  Handler b;
  
  public QRRecog(Handler paramHandler)
  {
    this.b = paramHandler;
  }
  
  public int a()
  {
    try
    {
      long l = System.currentTimeMillis();
      int i = ((IQRCodeApi)QRoute.api(IQRCodeApi.class)).initForCamera(1, "ANY", "UTF-8");
      int j = ((IQRCodeApi)QRoute.api(IQRCodeApi.class)).setReadersForCamera(QBarConstants.c);
      String str = ((IQRCodeApi)QRoute.api(IQRCodeApi.class)).getVersion();
      if (QLog.isColorLevel()) {
        QLog.d("QRSession.QRRecog", 2, String.format("initQbar time cost:%sms, initResult=%s readerResult=%s version=%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(i), Integer.valueOf(j), str }));
      }
      this.a = true;
      return 0;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QRSession.QRRecog", 2, "initQbar fail!", localException);
      }
    }
    return -1;
  }
  
  public boolean a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, ScannerResult paramScannerResult)
  {
    long l = System.currentTimeMillis();
    if (((IQRCodeApi)QRoute.api(IQRCodeApi.class)).scanImageForCamera(paramArrayOfByte, paramInt1, paramInt2) == 1)
    {
      paramArrayOfByte = ((IQRCodeApi)QRoute.api(IQRCodeApi.class)).getResultForCamera();
      paramScannerResult.a = paramArrayOfByte;
    }
    else
    {
      paramArrayOfByte = null;
    }
    if (QLog.isColorLevel()) {
      if (paramScannerResult.h()) {
        QLog.d("QRSession.QRRecog", 2, String.format("------> recognize QR suc. results=%s qrRecog minicode_timecost=%d", new Object[] { paramArrayOfByte, Long.valueOf(System.currentTimeMillis() - l) }));
      } else {
        QLog.d("QRSession.QRRecog", 2, String.format("------> recognize QR failed. hasQR=%s qrAreaRatio=%s qrRecog minicode_timecost=%d", new Object[] { Boolean.valueOf(false), Float.valueOf(0.0F), Long.valueOf(System.currentTimeMillis() - l) }));
      }
    }
    return paramScannerResult.h();
  }
  
  public void b()
  {
    try
    {
      if (this.a)
      {
        ((IQRCodeApi)QRoute.api(IQRCodeApi.class)).releaseForCamera();
        this.a = false;
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QRSession.QRRecog", 2, "unInitQbar fail!", localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.codeEngine.QRRecog
 * JD-Core Version:    0.7.0.1
 */
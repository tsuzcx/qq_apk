package com.tencent.mobileqq.ar.codeEngine;

import android.os.Handler;
import com.tencent.biz.qrcode.activity.ScannerResult;
import com.tencent.qbar.QbarNativeImpl;
import com.tencent.qphone.base.util.QLog;

public class QRRecog
{
  Handler jdField_a_of_type_AndroidOsHandler;
  boolean jdField_a_of_type_Boolean = false;
  
  public QRRecog(Handler paramHandler)
  {
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
  }
  
  public int a()
  {
    try
    {
      long l = System.currentTimeMillis();
      Object localObject = new int[2];
      localObject[0] = 2;
      localObject[1] = 1;
      int i = QbarNativeImpl.b(1, "ANY", "UTF-8");
      int j = QbarNativeImpl.b((int[])localObject, localObject.length);
      localObject = QbarNativeImpl.a();
      if (QLog.isColorLevel()) {
        QLog.d("QRSession.QRRecog", 2, String.format("initQbar time cost:%sms, initResult=%s readerResult=%s version=%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(i), Integer.valueOf(j), localObject }));
      }
      this.jdField_a_of_type_Boolean = true;
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
  
  public void a()
  {
    try
    {
      if (this.jdField_a_of_type_Boolean)
      {
        QbarNativeImpl.b();
        this.jdField_a_of_type_Boolean = false;
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("QRSession.QRRecog", 2, "unInitQbar fail!", localException);
    }
  }
  
  public boolean a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, ScannerResult paramScannerResult)
  {
    long l = System.currentTimeMillis();
    paramInt1 = QbarNativeImpl.b(paramArrayOfByte, paramInt1, paramInt2, 0);
    paramArrayOfByte = null;
    if (paramInt1 == 1)
    {
      paramArrayOfByte = QbarNativeImpl.b();
      paramScannerResult.a = paramArrayOfByte;
    }
    if (QLog.isColorLevel())
    {
      if (!paramScannerResult.d()) {
        break label81;
      }
      QLog.d("QRSession.QRRecog", 2, String.format("------> recognize QR suc. results=%s qrRecog minicode_timecost=%d", new Object[] { paramArrayOfByte, Long.valueOf(System.currentTimeMillis() - l) }));
    }
    for (;;)
    {
      return paramScannerResult.d();
      label81:
      QLog.d("QRSession.QRRecog", 2, String.format("------> recognize QR failed. hasQR=%s qrAreaRatio=%s qrRecog minicode_timecost=%d", new Object[] { Boolean.valueOf(false), Float.valueOf(0.0F), Long.valueOf(System.currentTimeMillis() - l) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.codeEngine.QRRecog
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.ar.arengine;

import aapm;
import android.graphics.Rect;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.imageboost.ImgProcessScan;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ScanEntranceDPC;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.qbar.QbarNative.QbarPossibleInfo;
import com.tencent.qbar.QbarNativeImpl;
import com.tencent.qphone.base.util.QLog;

public class QRRecognizerController
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = 500L;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private QRRecognizerListener jdField_a_of_type_ComTencentMobileqqArArengineQRRecognizerListener;
  private boolean jdField_a_of_type_Boolean;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private Rect jdField_b_of_type_AndroidGraphicsRect;
  private boolean jdField_b_of_type_Boolean;
  private byte[] jdField_b_of_type_ArrayOfByte;
  private long c;
  
  public QRRecognizerController(Rect paramRect)
  {
    this.jdField_a_of_type_AndroidGraphicsRect = paramRect;
  }
  
  private int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int n = -1;
    int k = n;
    if (paramArrayOfByte.length > paramInt1 * paramInt2)
    {
      k = 0;
      int i = 0;
      int j = 0;
      while (k < paramInt2)
      {
        int m = i;
        int i1 = 0;
        i = j;
        j = m;
        m = i1;
        while (m < paramInt1)
        {
          i += (paramArrayOfByte[(k * paramInt2 + m)] & 0xFF);
          j += 1;
          m += 3;
        }
        m = k + 3;
        k = i;
        i = j;
        j = k;
        k = m;
      }
      k = n;
      if (i > 0) {
        k = j / i;
      }
    }
    return k;
  }
  
  private boolean a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return (paramArrayOfByte != null) && (paramArrayOfByte.length > 0) && (paramArrayOfByte.length == paramInt1 * paramInt2 * 3 / 2);
  }
  
  private void c()
  {
    if (this.jdField_b_of_type_AndroidGraphicsRect == null)
    {
      float f = this.jdField_b_of_type_Int / ScreenUtil.jdField_a_of_type_Int;
      this.jdField_a_of_type_AndroidGraphicsRect = new Rect((int)(this.jdField_a_of_type_AndroidGraphicsRect.left * f), (int)(this.jdField_a_of_type_AndroidGraphicsRect.top * f), (int)(this.jdField_a_of_type_AndroidGraphicsRect.right * f), (int)(f * this.jdField_a_of_type_AndroidGraphicsRect.bottom));
      this.jdField_b_of_type_AndroidGraphicsRect = new Rect(this.jdField_a_of_type_AndroidGraphicsRect);
      if (QLog.isColorLevel()) {
        QLog.d("QRRecognizerController", 2, String.format("initScanRect mScanRect=%s mQRRecognizeRect=%s", new Object[] { this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_b_of_type_AndroidGraphicsRect }));
      }
    }
  }
  
  private void d()
  {
    try
    {
      long l = System.currentTimeMillis();
      Object localObject = new int[2];
      localObject[0] = 2;
      localObject[1] = 0;
      int i = QbarNativeImpl.b(2, 0, "ANY", "UTF-8");
      int j = QbarNativeImpl.b((int[])localObject, localObject.length);
      localObject = QbarNativeImpl.a();
      if (QLog.isColorLevel()) {
        QLog.d("QRRecognizerController", 2, String.format("initQbar time cost:%sms, initResult=%s readerResult=%s version=%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(i), Integer.valueOf(j), localObject }));
      }
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("QRRecognizerController", 2, "initQbar fail!", localException);
    }
  }
  
  private void e()
  {
    try
    {
      if (this.jdField_a_of_type_Boolean)
      {
        QbarNativeImpl.b();
        this.jdField_a_of_type_Boolean = false;
        return;
      }
      if (this.jdField_a_of_type_AndroidOsHandler != null)
      {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(100);
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QRRecognizerController", 2, "unInitQbar fail!", localException);
      }
    }
  }
  
  private void f()
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    float f = 0.0F;
    long l1 = System.currentTimeMillis();
    int i;
    int j;
    boolean bool;
    if (a(this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int))
    {
      if (this.jdField_b_of_type_AndroidGraphicsRect == null) {
        c();
      }
      i = this.jdField_b_of_type_AndroidGraphicsRect.top;
      j = this.jdField_b_of_type_AndroidGraphicsRect.left;
      int k = this.jdField_b_of_type_AndroidGraphicsRect.height();
      int m = this.jdField_b_of_type_AndroidGraphicsRect.width();
      if ((this.jdField_b_of_type_ArrayOfByte == null) || (this.jdField_b_of_type_ArrayOfByte.length != k * m * 3 / 2)) {
        this.jdField_b_of_type_ArrayOfByte = new byte[k * m * 3 / 2];
      }
      int[] arrayOfInt = new int[2];
      if (ImgProcessScan.a(this.jdField_b_of_type_ArrayOfByte, arrayOfInt, this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, i, j, k, m, 90, 0) == 1) {
        if (QbarNativeImpl.b(this.jdField_b_of_type_ArrayOfByte, arrayOfInt[0], arrayOfInt[1], 0) == 1)
        {
          QbarNativeImpl.b(localStringBuilder1, localStringBuilder2);
          bool = false;
          i = 1;
          f = 0.0F;
          long l2 = System.currentTimeMillis();
          if ((!this.jdField_b_of_type_Boolean) || (l2 - this.c <= 1000L)) {
            break label498;
          }
          long l3 = System.currentTimeMillis();
          j = a(this.jdField_b_of_type_ArrayOfByte, arrayOfInt[0], arrayOfInt[1]);
          if (QLog.isColorLevel()) {
            QLog.d("QRRecognizerController", 2, String.format("doRecognizeInternal avgLuminance=%s get avg luminance time cost:%sms", new Object[] { Integer.valueOf(j), Long.valueOf(System.currentTimeMillis() - l3) }));
          }
          this.c = l2;
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QRRecognizerController", 2, String.format("doRecognizeInternal recognize preview time cost:%sms", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) }));
      }
      if (this.jdField_a_of_type_ComTencentMobileqqArArengineQRRecognizerListener != null)
      {
        if (i == 0) {
          break label452;
        }
        this.jdField_a_of_type_ComTencentMobileqqArArengineQRRecognizerListener.a(localStringBuilder1.toString(), localStringBuilder2.toString());
      }
      for (;;)
      {
        if (j >= 0) {
          this.jdField_a_of_type_ComTencentMobileqqArArengineQRRecognizerListener.a(j);
        }
        if (QLog.isColorLevel())
        {
          if (i == 0) {
            break label467;
          }
          QLog.d("QRRecognizerController", 2, String.format("doRecognizeInternal recognize QR code. type=%s data=%s", new Object[] { localStringBuilder1, localStringBuilder2 }));
        }
        return;
        if (QbarNativeImpl.c() != 1) {
          break label510;
        }
        if (QbarNativeImpl.a.hasQrcode == 1) {}
        for (bool = true;; bool = false)
        {
          if (!bool) {
            break label503;
          }
          f = QbarNativeImpl.a.qrcodeAreaRatio;
          i = 0;
          break;
        }
        label452:
        this.jdField_a_of_type_ComTencentMobileqqArArengineQRRecognizerListener.a(bool, f);
      }
      label467:
      QLog.d("QRRecognizerController", 2, String.format("doRecognizeInternal not recognize QR code. hasQR=%s qrAreaRatio=%s", new Object[] { Boolean.valueOf(bool), Float.valueOf(f) }));
      return;
      label498:
      j = -1;
      continue;
      label503:
      f = 0.0F;
      i = 0;
      break;
      label510:
      f = 0.0F;
      bool = false;
      i = 0;
      break;
      j = -1;
      bool = false;
      i = 0;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidOsHandlerThread = ThreadManager.newFreeHandlerThread("QRRecognizerController", 0);
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new aapm(this, this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(100);
    this.jdField_a_of_type_Long = 500L;
    if (ScanEntranceDPC.a().jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Long = 300L;
    }
    QLog.i("QRRecognizerController", 1, String.format("init mQRRecognizeInterval=%s", new Object[] { Long.valueOf(this.jdField_a_of_type_Long) }));
  }
  
  public void a(QRRecognizerListener paramQRRecognizerListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqArArengineQRRecognizerListener = paramQRRecognizerListener;
  }
  
  public void a(boolean paramBoolean, long paramLong)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (this.jdField_b_of_type_Boolean) {
      this.c = (System.currentTimeMillis() + paramLong);
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    long l;
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidOsHandler != null) && ((paramBoolean) || (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(101))))
    {
      l = System.currentTimeMillis();
      if ((paramBoolean) || (l - this.jdField_b_of_type_Long >= this.jdField_a_of_type_Long)) {}
    }
    else
    {
      return;
    }
    if (a(paramArrayOfByte, paramInt1, paramInt2))
    {
      if ((this.jdField_a_of_type_ArrayOfByte == null) || (this.jdField_a_of_type_ArrayOfByte.length != paramArrayOfByte.length)) {
        this.jdField_a_of_type_ArrayOfByte = new byte[paramArrayOfByte.length];
      }
      System.arraycopy(paramArrayOfByte, 0, this.jdField_a_of_type_ArrayOfByte, 0, paramArrayOfByte.length);
      this.jdField_a_of_type_Int = paramInt1;
      this.jdField_b_of_type_Int = paramInt2;
    }
    for (this.jdField_b_of_type_Long = l;; this.jdField_b_of_type_Long = 0L)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(101);
      return;
      this.jdField_a_of_type_Int = 0;
      this.jdField_b_of_type_Int = 0;
    }
  }
  
  public void b()
  {
    e();
    this.jdField_a_of_type_AndroidOsHandlerThread.quit();
    this.jdField_a_of_type_AndroidOsHandlerThread = null;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.QRRecognizerController
 * JD-Core Version:    0.7.0.1
 */
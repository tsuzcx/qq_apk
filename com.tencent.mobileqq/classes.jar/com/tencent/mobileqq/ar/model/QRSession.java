package com.tencent.mobileqq.ar.model;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ScanEntranceDPC;
import com.tencent.mobileqq.ar.arengine.ARCamera.AutoFocusListener;
import com.tencent.mobileqq.ar.arengine.MiniSaveImgListener;
import com.tencent.mobileqq.ar.arengine.QRRecognizerListener;
import com.tencent.mobileqq.ar.codeEngine.MiniRecog;
import com.tencent.mobileqq.ar.codeEngine.QRRecog;
import com.tencent.mobileqq.ar.utils.QRScreenUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qrscan.AIRect;
import com.tencent.mobileqq.qrscan.ScannerResult;
import com.tencent.mobileqq.qrscan.api.IImgProcessApi;
import com.tencent.mobileqq.qrscan.api.IQRScanReportApi;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class QRSession
  extends AbstractSession
  implements ARCamera.AutoFocusListener, MiniSaveImgListener
{
  private long jdField_a_of_type_Long = 500L;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private MiniSaveImgListener jdField_a_of_type_ComTencentMobileqqArArengineMiniSaveImgListener;
  private QRRecognizerListener jdField_a_of_type_ComTencentMobileqqArArengineQRRecognizerListener;
  private MiniRecog jdField_a_of_type_ComTencentMobileqqArCodeEngineMiniRecog;
  private QRRecog jdField_a_of_type_ComTencentMobileqqArCodeEngineQRRecog;
  AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private boolean jdField_a_of_type_Boolean;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private long jdField_b_of_type_Long;
  private Rect jdField_b_of_type_AndroidGraphicsRect;
  private boolean jdField_b_of_type_Boolean;
  private byte[] jdField_b_of_type_ArrayOfByte;
  private long jdField_c_of_type_Long;
  private Rect jdField_c_of_type_AndroidGraphicsRect;
  private boolean jdField_c_of_type_Boolean;
  private long jdField_d_of_type_Long = 0L;
  private Rect jdField_d_of_type_AndroidGraphicsRect;
  private boolean jdField_d_of_type_Boolean = false;
  private int jdField_e_of_type_Int;
  private boolean jdField_e_of_type_Boolean = true;
  private int jdField_f_of_type_Int;
  private boolean jdField_f_of_type_Boolean = false;
  private int jdField_g_of_type_Int;
  private boolean jdField_g_of_type_Boolean = false;
  private int jdField_h_of_type_Int = 0;
  private boolean jdField_h_of_type_Boolean = false;
  
  public QRSession()
  {
    this.jdField_b_of_type_Int = 0;
    CameraProxy.a().b(this);
    CameraProxy.a().a(this);
  }
  
  private static float a(Rect paramRect1, Rect paramRect2, Point paramPoint)
  {
    int i2 = paramPoint.x;
    int i3 = paramRect2.left;
    int i4 = paramRect2.right;
    int i5 = paramPoint.x;
    int k = paramPoint.y;
    int m = paramRect2.top;
    int n = paramRect2.bottom;
    int i1 = paramPoint.y;
    int i;
    if (paramRect1.left < paramPoint.x) {
      i = paramPoint.x - paramRect1.left;
    } else {
      i = 0;
    }
    int j;
    if (paramRect1.right > paramPoint.x) {
      j = paramRect1.right - paramPoint.x;
    } else {
      j = 0;
    }
    float f4 = 2.147484E+009F;
    float f1;
    if (i > 0) {
      f1 = (i2 - i3) / i;
    } else {
      f1 = 2.147484E+009F;
    }
    float f2;
    if (j > 0) {
      f2 = (i4 - i5) / j;
    } else {
      f2 = 2.147484E+009F;
    }
    float f5 = Math.min(f1, f2);
    if (paramRect1.top < paramPoint.y) {
      i = paramPoint.y - paramRect1.top;
    } else {
      i = 0;
    }
    if (paramRect1.bottom > paramPoint.y) {
      j = paramRect1.bottom - paramPoint.y;
    } else {
      j = 0;
    }
    float f3;
    if (i > 0) {
      f3 = (k - m) / i;
    } else {
      f3 = 2.147484E+009F;
    }
    if (j > 0) {
      f4 = (n - i1) / j;
    }
    f5 = Math.min(f5, Math.min(f3, f4));
    float f6 = paramRect2.width() / paramRect1.width();
    float f7 = paramRect2.height() / paramRect1.height();
    float f8 = Math.min(f6, f7);
    if (QLog.isColorLevel()) {
      QLog.i("QRSession", 2, String.format("calcZoomFactor_ori [codeRect,scanRect,prevCenter]=[%s|%s|%s]", new Object[] { paramRect1.toShortString(), paramRect2.toShortString(), paramPoint.toString() }));
    }
    if (QLog.isColorLevel()) {
      QLog.i("QRSession", 2, String.format("calcZoomFactor_calc [ratioLeft,ratioRight]=[%.2f,%.2f], [ratioTop,ratioBot]=[%.2f,%.2f] [wFactor,hFactor]=[%.2f,%.2f]", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f6), Float.valueOf(f7) }));
    }
    if ((f5 >= 0.0F) && (f8 > f5)) {
      return f5;
    }
    return f8;
  }
  
  private int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte.length > paramInt1 * paramInt2)
    {
      int j = 0;
      int i = 0;
      int k = 0;
      while (j < paramInt2)
      {
        int m = 0;
        while (m < paramInt1)
        {
          k += (paramArrayOfByte[(j * paramInt1 + m)] & 0xFF);
          i += 1;
          m += 3;
        }
        j += 3;
      }
      if (i > 0) {
        return k / i;
      }
    }
    return -1;
  }
  
  private void a()
  {
    if (this.jdField_f_of_type_Int > 0)
    {
      int i = this.jdField_g_of_type_Int;
      if (i <= 0) {
        return;
      }
      float f1 = i / QRScreenUtil.jdField_a_of_type_Int;
      float f2 = this.jdField_f_of_type_Int / QRScreenUtil.jdField_b_of_type_Int;
      Rect localRect1 = new Rect((int)(this.jdField_a_of_type_AndroidGraphicsRect.left * f1), (int)(this.jdField_a_of_type_AndroidGraphicsRect.top * f2), (int)(this.jdField_a_of_type_AndroidGraphicsRect.right * f1), (int)(this.jdField_a_of_type_AndroidGraphicsRect.bottom * f2));
      Rect localRect2 = new Rect(0, 0, (int)(localRect1.width() * 1.5F), (int)(localRect1.height() * 1.5F));
      localRect2.offset(localRect1.centerX() - localRect2.centerX(), localRect1.centerY() - localRect2.centerY());
      localRect2.intersect(0, 0, this.jdField_g_of_type_Int, this.jdField_f_of_type_Int);
      Rect localRect3 = new Rect(0, 0, localRect1.height(), localRect1.width());
      localRect3.offset(localRect1.top, localRect1.left);
      Rect localRect4 = new Rect(0, 0, (int)(localRect3.width() * 1.3F), (int)(localRect3.height() * 1.2F));
      localRect4.offset(localRect3.centerX() - localRect4.centerX(), localRect3.centerY() - localRect4.centerY());
      localRect4.intersect(0, 0, this.jdField_f_of_type_Int, this.jdField_g_of_type_Int);
      localRect1.set(0, 0, QRScreenUtil.jdField_a_of_type_Int, QRScreenUtil.jdField_b_of_type_Int);
      localRect2.set(0, 0, this.jdField_g_of_type_Int, this.jdField_f_of_type_Int);
      localRect4.set(0, 0, this.jdField_f_of_type_Int, this.jdField_g_of_type_Int);
      if (QLog.isColorLevel()) {
        QLog.d("QRSession", 2, String.format("initScanRect [mScanRect,qRRecogRect,qRRecogRectExt,rotateQRRecogRectExt]=[%s, %s, %s, %s] [w,h]=[%d,%d]", new Object[] { this.jdField_a_of_type_AndroidGraphicsRect.toShortString(), localRect1.toShortString(), localRect2.toShortString(), localRect4.toShortString(), Integer.valueOf(QRScreenUtil.jdField_a_of_type_Int), Integer.valueOf(QRScreenUtil.jdField_b_of_type_Int) }));
      }
      this.jdField_b_of_type_AndroidGraphicsRect = localRect1;
      this.jdField_d_of_type_AndroidGraphicsRect = localRect2;
      this.jdField_c_of_type_AndroidGraphicsRect = localRect4;
    }
  }
  
  private void a(Rect paramRect1, Rect paramRect2, boolean paramBoolean)
  {
    Rect localRect = new Rect();
    if ((paramRect1 != null) && (paramRect1.width() > 0) && (paramRect1.height() > 0))
    {
      localRect.set(0, 0, paramRect1.height(), paramRect1.width());
      localRect.offset(this.jdField_g_of_type_Int - paramRect1.top - paramRect1.height(), paramRect1.left);
    }
    if ((localRect.width() > 0) && (localRect.height() > 0))
    {
      paramRect2.set(localRect);
      float f1 = QRScreenUtil.jdField_a_of_type_Int / this.jdField_g_of_type_Int;
      float f2 = QRScreenUtil.jdField_b_of_type_Int / this.jdField_f_of_type_Int;
      if (QLog.isColorLevel()) {
        QLog.i("QRSession", 2, String.format("getScreenRect [%.2f,%.2f, %d,%d,%d,%d]", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(QRScreenUtil.jdField_a_of_type_Int), Integer.valueOf(QRScreenUtil.jdField_b_of_type_Int), Integer.valueOf(this.jdField_g_of_type_Int), Integer.valueOf(this.jdField_f_of_type_Int) }));
      }
      paramRect2.left = ((int)(paramRect2.left * f1));
      paramRect2.top = ((int)(paramRect2.top * f2));
      paramRect2.right = ((int)(paramRect2.right * f1));
      paramRect2.bottom = ((int)(paramRect2.bottom * f2));
    }
    if (QLog.isColorLevel()) {
      QLog.i("QRSession", 2, String.format("[------ detect_point 2 rect=%s previewRect=%s screenRect=%s isQr=%b ------]", new Object[] { paramRect1, localRect, paramRect2, Boolean.valueOf(paramBoolean) }));
    }
  }
  
  private void a(ScannerResult paramScannerResult, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqArArengineQRRecognizerListener != null) && (this.jdField_a_of_type_Int == 2) && (!this.jdField_f_of_type_Boolean)) {
      if (((paramScannerResult.a()) || (paramScannerResult.jdField_b_of_type_Boolean)) && (a(paramArrayOfByte, paramInt1, paramInt2)))
      {
        byte[] arrayOfByte = new byte[paramArrayOfByte.length];
        System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
        this.jdField_a_of_type_ComTencentMobileqqArArengineQRRecognizerListener.a(paramScannerResult, arrayOfByte, paramInt1, paramInt2);
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqArArengineQRRecognizerListener.a(paramScannerResult, null, 0, 0);
      }
    }
    if (paramScannerResult.d())
    {
      if (this.jdField_g_of_type_Boolean) {
        paramInt1 = 6;
      } else {
        paramInt1 = 1;
      }
      ((IQRScanReportApi)QRoute.api(IQRScanReportApi.class)).markScanEnd(paramInt1);
    }
    if (paramScannerResult.c())
    {
      if (this.jdField_g_of_type_Boolean) {
        paramInt1 = 5;
      } else {
        paramInt1 = 3;
      }
      ((IQRScanReportApi)QRoute.api(IQRScanReportApi.class)).markScanEnd(paramInt1);
    }
  }
  
  private void a(List<AIRect> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      AIRect localAIRect = new AIRect();
      localAIRect.jdField_a_of_type_Int = ((AIRect)paramList.get(i)).jdField_a_of_type_Int;
      localAIRect.jdField_a_of_type_Float = ((AIRect)paramList.get(i)).jdField_a_of_type_Float;
      Rect localRect = ((AIRect)paramList.get(i)).jdField_a_of_type_AndroidGraphicsRect;
      if ((localRect.width() > 0) && (localRect.height() > 0)) {
        a(localRect, localAIRect.jdField_a_of_type_AndroidGraphicsRect, true);
      }
      localArrayList.add(localAIRect);
      i += 1;
    }
    paramList = this.jdField_a_of_type_ComTencentMobileqqArArengineQRRecognizerListener;
    if (paramList != null) {
      paramList.a(localArrayList);
    }
  }
  
  private void a(boolean paramBoolean, float paramFloat)
  {
    MiniRecog localMiniRecog = this.jdField_a_of_type_ComTencentMobileqqArCodeEngineMiniRecog;
    int i;
    if ((localMiniRecog != null) && (localMiniRecog.a())) {
      i = 1;
    } else {
      i = 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QRSession", 2, String.format("onQRRecognizeFail hasQR=%s qrAreaRatio=%s isMiniRecgReady =%d", new Object[] { Boolean.valueOf(paramBoolean), Float.valueOf(paramFloat), Integer.valueOf(i) }));
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqArArengineQRRecognizerListener != null) && (this.jdField_a_of_type_Int == 2))
    {
      if ((paramBoolean) && (paramFloat > 0.003F) && (i == 0))
      {
        float f2 = (float)(Math.sqrt(paramFloat) * 100.0D) * 0.75F;
        float f1 = f2;
        if (f2 >= 1.2F)
        {
          f1 = f2;
          if (f2 > 25.0F) {
            f1 = 25.0F;
          }
          CameraProxy.a().a(f1, false);
        }
        if (QLog.isColorLevel()) {
          QLog.i("QRSession", 2, String.format("onRecognizeFail onGetDetectRect ratio=%.2f", new Object[] { Float.valueOf(f1) }));
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqArArengineQRRecognizerListener.a(paramBoolean, paramFloat);
    }
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    long l1 = System.currentTimeMillis();
    boolean bool;
    if ((this.jdField_c_of_type_Boolean) && (l1 - this.jdField_c_of_type_Long > 1000L))
    {
      long l2 = System.currentTimeMillis();
      paramInt1 = a(this.jdField_b_of_type_ArrayOfByte, paramInt1, paramInt2);
      if (paramInt1 < this.jdField_e_of_type_Int) {
        bool = true;
      } else {
        bool = false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QRSession", 2, String.format("checkAvgLuminance avgLuminance=%s get avg luminance time cost:%sms", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(System.currentTimeMillis() - l2) }));
      }
      this.jdField_c_of_type_Long = l1;
    }
    else
    {
      paramInt1 = -1;
      bool = false;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqArArengineQRRecognizerListener != null) && (this.jdField_a_of_type_Int == 2) && (paramInt1 >= 0)) {
      this.jdField_a_of_type_ComTencentMobileqqArArengineQRRecognizerListener.a(paramInt1);
    }
    return bool;
  }
  
  private boolean a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return (paramArrayOfByte != null) && (paramArrayOfByte.length > 0) && (paramArrayOfByte.length == paramInt1 * paramInt2 * 3 / 2);
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqArCodeEngineQRRecog.a();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqArCodeEngineMiniRecog.a();
    this.jdField_b_of_type_Boolean = true;
  }
  
  private void b(List<AIRect> paramList)
  {
    if (paramList.size() <= 0) {
      return;
    }
    for (;;)
    {
      float f3;
      try
      {
        bool = ((AIRect)paramList.get(0)).jdField_a_of_type_AndroidGraphicsRect.isEmpty();
        f2 = 0.0F;
        if ((bool) || ((this.jdField_d_of_type_Long != 0L) && (SystemClock.uptimeMillis() - this.jdField_d_of_type_Long <= 500L))) {
          break label395;
        }
        f2 = ((AIRect)paramList.get(0)).jdField_a_of_type_AndroidGraphicsRect.width() / this.jdField_c_of_type_AndroidGraphicsRect.width();
        f3 = ((AIRect)paramList.get(0)).jdField_a_of_type_AndroidGraphicsRect.height() / this.jdField_c_of_type_AndroidGraphicsRect.height();
        if ((f2 >= 0.7F) || (f3 >= 0.7F)) {
          break label371;
        }
        bool = true;
        if (QLog.isColorLevel()) {
          QLog.i("QRSession", 2, String.format("[wRatio,hRatio,need]=[%.2f %.2f %b]", new Object[] { Float.valueOf(f2), Float.valueOf(f3), Boolean.valueOf(bool) }));
        }
        if (!bool) {
          break label386;
        }
        paramList = new Rect(((AIRect)paramList.get(0)).jdField_a_of_type_AndroidGraphicsRect);
        Point localPoint = new Point(this.jdField_f_of_type_Int / 2, this.jdField_g_of_type_Int / 2);
        float f4 = a(paramList, this.jdField_c_of_type_AndroidGraphicsRect, localPoint);
        if (f4 < 1.2F) {
          break label386;
        }
        f1 = f4;
        if (f4 > 25.0F) {
          f1 = 25.0F;
        }
        bool = CameraProxy.a().a(f1, false);
        this.jdField_g_of_type_Boolean |= bool;
        if (!bool) {
          break label377;
        }
        this.jdField_d_of_type_Long = SystemClock.uptimeMillis();
        CameraProxy.a().c();
      }
      catch (Throwable paramList)
      {
        float f2;
        if (!QLog.isColorLevel()) {
          break label370;
        }
        QLog.i("QRSession", 2, paramList.getMessage(), paramList);
      }
      if (QLog.isColorLevel())
      {
        QLog.i("QRSession", 2, String.format("onGetDetectRect zoom=%b [%.2f,%.2f]", new Object[] { Boolean.valueOf(bool), Float.valueOf(f2), Float.valueOf(f1) }));
        return;
      }
      label370:
      return;
      label371:
      boolean bool = false;
      continue;
      label377:
      bool = true;
      float f1 = f3;
      continue;
      label386:
      bool = false;
      f1 = f3;
      continue;
      label395:
      bool = false;
      f1 = 0.0F;
    }
  }
  
  private void c()
  {
    try
    {
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqArCodeEngineQRRecog.a();
        this.jdField_a_of_type_Boolean = false;
      }
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqArCodeEngineMiniRecog.a();
        this.jdField_b_of_type_Boolean = false;
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
        QLog.d("QRSession", 2, "unInitQbar fail!", localException);
      }
    }
  }
  
  private void d()
  {
    long l1 = System.currentTimeMillis();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel()) {
      localStringBuilder = new StringBuilder("doRecognizeInternal ");
    } else {
      localStringBuilder = null;
    }
    if (a(this.jdField_a_of_type_ArrayOfByte, this.jdField_f_of_type_Int, this.jdField_g_of_type_Int))
    {
      if ((this.jdField_b_of_type_AndroidGraphicsRect == null) || (this.jdField_d_of_type_AndroidGraphicsRect == null)) {
        a();
      }
      if (this.jdField_b_of_type_AndroidGraphicsRect != null)
      {
        Object localObject = this.jdField_d_of_type_AndroidGraphicsRect;
        if (localObject == null) {
          return;
        }
        this.jdField_h_of_type_Boolean = true;
        int i = ((Rect)localObject).top;
        int j = this.jdField_d_of_type_AndroidGraphicsRect.left;
        int k = this.jdField_d_of_type_AndroidGraphicsRect.height();
        int m = this.jdField_d_of_type_AndroidGraphicsRect.width();
        localObject = this.jdField_b_of_type_ArrayOfByte;
        if ((localObject == null) || (localObject.length != k * m * 3 / 2)) {
          this.jdField_b_of_type_ArrayOfByte = new byte[k * m * 3 / 2];
        }
        localObject = new int[2];
        if (((IImgProcessApi)QRoute.api(IImgProcessApi.class)).gray_rotate_crop_sub(this.jdField_b_of_type_ArrayOfByte, (int[])localObject, this.jdField_a_of_type_ArrayOfByte, this.jdField_f_of_type_Int, this.jdField_g_of_type_Int, i, j, k, m, 90, 0) == 0)
        {
          i = localObject[0];
          j = localObject[1];
          localObject = new ScannerResult();
          ArrayList localArrayList = new ArrayList();
          long l2 = System.currentTimeMillis();
          boolean bool2 = this.jdField_a_of_type_ComTencentMobileqqArCodeEngineQRRecog.a(this.jdField_b_of_type_ArrayOfByte, i, j, (ScannerResult)localObject);
          long l3 = System.currentTimeMillis();
          boolean bool3 = this.jdField_a_of_type_ComTencentMobileqqArCodeEngineMiniRecog.a(this.jdField_a_of_type_ArrayOfByte, this.jdField_f_of_type_Int, this.jdField_g_of_type_Int, this.jdField_d_of_type_AndroidGraphicsRect, this.jdField_b_of_type_ArrayOfByte, i, j, (ScannerResult)localObject, localArrayList, this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger);
          long l4 = System.currentTimeMillis();
          if ((localArrayList.size() > 1) && (((ScannerResult)localObject).b()) && (!((ScannerResult)localObject).a())) {
            ((ScannerResult)localObject).jdField_b_of_type_Boolean = true;
          }
          boolean bool1;
          if ((!bool2) && (!bool3) && (a(i, j))) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          if ((!bool1) && (!bool2) && (!bool3)) {
            this.jdField_h_of_type_Int += 1;
          }
          a(localArrayList);
          if (((ScannerResult)localObject).b())
          {
            a((ScannerResult)localObject, this.jdField_a_of_type_ArrayOfByte, this.jdField_f_of_type_Int, this.jdField_g_of_type_Int);
            this.jdField_h_of_type_Int = 0;
          }
          else
          {
            a(false, 0.0F);
            if (!localArrayList.isEmpty()) {
              b(localArrayList);
            }
          }
          ((IQRScanReportApi)QRoute.api(IQRScanReportApi.class)).markScanConsume((int)(l3 - l2), 0);
          ((IQRScanReportApi)QRoute.api(IQRScanReportApi.class)).markScanConsume((int)(l4 - l3), 1);
          if (localStringBuilder != null) {
            localStringBuilder.append(String.format("...1 decode qrSuc=%b miniSuc=%b isDark=%b failCnt=%d \nscannerResult=%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool1), Integer.valueOf(this.jdField_h_of_type_Int), localObject }));
          }
        }
      }
      else
      {
        return;
      }
    }
    this.jdField_h_of_type_Boolean = false;
    if ((QLog.isColorLevel()) && (localStringBuilder != null))
    {
      QLog.i("QRSession", 2, localStringBuilder.toString());
      QLog.d("QRSession", 2, String.format("doRecognizeInternal ...end  minicode_timecost=%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) }));
    }
  }
  
  public void a(long paramLong)
  {
    MiniSaveImgListener localMiniSaveImgListener = this.jdField_a_of_type_ComTencentMobileqqArArengineMiniSaveImgListener;
    if (localMiniSaveImgListener != null) {
      localMiniSaveImgListener.a(paramLong);
    }
  }
  
  public void a(Context paramContext, AppInterface paramAppInterface)
  {
    super.a(paramContext, paramAppInterface);
    this.jdField_a_of_type_AndroidOsHandlerThread = ThreadManager.newFreeHandlerThread("QRRecognizerController", 0);
    this.jdField_a_of_type_AndroidOsHandlerThread.start();
    this.jdField_a_of_type_AndroidOsHandler = new QRSession.CustomHandler(this, this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
    this.jdField_a_of_type_ComTencentMobileqqArCodeEngineQRRecog = new QRRecog(this.jdField_a_of_type_AndroidOsHandler);
    this.jdField_a_of_type_ComTencentMobileqqArCodeEngineMiniRecog = new MiniRecog(this.jdField_a_of_type_AndroidOsHandler, paramContext);
    this.jdField_a_of_type_ComTencentMobileqqArCodeEngineMiniRecog.a(this);
    this.jdField_a_of_type_Long = 250L;
    if (ScanEntranceDPC.a().jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_Long = 120L;
    }
    this.jdField_e_of_type_Int = ScanEntranceDPC.a().c;
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(100);
    QLog.i("QRSession", 1, String.format("init mQRRecognizeInterval=%s", new Object[] { Long.valueOf(this.jdField_a_of_type_Long) }));
  }
  
  public void a(Rect paramRect)
  {
    if ((paramRect != null) && (!paramRect.equals(this.jdField_a_of_type_AndroidGraphicsRect)))
    {
      this.jdField_a_of_type_AndroidGraphicsRect = paramRect;
      a();
    }
  }
  
  public void a(QRRecognizerListener paramQRRecognizerListener, MiniSaveImgListener paramMiniSaveImgListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqArArengineQRRecognizerListener = paramQRRecognizerListener;
    this.jdField_a_of_type_ComTencentMobileqqArArengineMiniSaveImgListener = paramMiniSaveImgListener;
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Int == 2) {
      this.jdField_d_of_type_Boolean = true;
    }
  }
  
  public void a(boolean paramBoolean, long paramLong)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    if (this.jdField_c_of_type_Boolean) {
      this.jdField_c_of_type_Long = (System.currentTimeMillis() + paramLong);
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Boolean))
    {
      Object localObject = this.jdField_a_of_type_AndroidOsHandler;
      if ((localObject != null) && (!this.jdField_f_of_type_Boolean) && ((paramBoolean) || (!((Handler)localObject).hasMessages(101))) && (!this.jdField_h_of_type_Boolean))
      {
        long l = System.currentTimeMillis();
        if ((!paramBoolean) && (l - this.jdField_b_of_type_Long < this.jdField_a_of_type_Long)) {
          return;
        }
        if (a(paramArrayOfByte, paramInt1, paramInt2))
        {
          localObject = this.jdField_a_of_type_ArrayOfByte;
          if ((localObject == null) || (localObject.length != paramArrayOfByte.length)) {
            this.jdField_a_of_type_ArrayOfByte = new byte[paramArrayOfByte.length];
          }
          System.arraycopy(paramArrayOfByte, 0, this.jdField_a_of_type_ArrayOfByte, 0, paramArrayOfByte.length);
          this.jdField_f_of_type_Int = paramInt1;
          this.jdField_g_of_type_Int = paramInt2;
          this.jdField_b_of_type_Long = l;
        }
        else
        {
          this.jdField_f_of_type_Int = 0;
          this.jdField_g_of_type_Int = 0;
          this.jdField_b_of_type_Long = 0L;
        }
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(101);
      }
    }
  }
  
  public boolean a(byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_Int == 2)
    {
      a(paramArrayOfByte, CameraProxy.a().a(), CameraProxy.a().b(), this.jdField_d_of_type_Boolean);
      if (((IQRScanReportApi)QRoute.api(IQRScanReportApi.class)).isBaseTestSwitchOn()) {
        ((IQRScanReportApi)QRoute.api(IQRScanReportApi.class)).doFrame();
      }
    }
    this.jdField_d_of_type_Boolean = false;
    return false;
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean != this.jdField_f_of_type_Boolean)
    {
      this.jdField_f_of_type_Boolean = paramBoolean;
      if (paramBoolean) {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
      }
    }
  }
  
  public void g()
  {
    super.g();
    if (this.jdField_g_of_type_Boolean) {
      this.jdField_g_of_type_Boolean = false;
    }
  }
  
  public void h()
  {
    super.h();
    if (this.jdField_g_of_type_Boolean) {
      CameraProxy.a().d();
    }
    if (((IQRScanReportApi)QRoute.api(IQRScanReportApi.class)).isBaseTestSwitchOn()) {
      ((IQRScanReportApi)QRoute.api(IQRScanReportApi.class)).stopFrame();
    }
  }
  
  public void j()
  {
    super.j();
    c();
    this.jdField_a_of_type_AndroidOsHandlerThread.quit();
    this.jdField_a_of_type_AndroidOsHandlerThread = null;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    this.jdField_a_of_type_AndroidOsHandler = null;
    CameraProxy.a().c(this);
    CameraProxy.a().b(this);
    ((IQRScanReportApi)QRoute.api(IQRScanReportApi.class)).markScanEnd(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.QRSession
 * JD-Core Version:    0.7.0.1
 */
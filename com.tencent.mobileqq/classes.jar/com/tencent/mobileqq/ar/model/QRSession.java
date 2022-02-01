package com.tencent.mobileqq.ar.model;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import com.tencent.biz.qrcode.activity.ScannerResult;
import com.tencent.common.app.AppInterface;
import com.tencent.imageboost.ImgProcessScan;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.ar.ScanEntranceDPC;
import com.tencent.mobileqq.ar.arengine.ARCamera.AutoFocusListener;
import com.tencent.mobileqq.ar.arengine.QRRecognizerListener;
import com.tencent.mobileqq.ar.codeEngine.AIRect;
import com.tencent.mobileqq.ar.codeEngine.MiniRecog;
import com.tencent.mobileqq.ar.codeEngine.MiniRecogListener;
import com.tencent.mobileqq.ar.codeEngine.MiniScanReport;
import com.tencent.mobileqq.ar.codeEngine.QRRecog;
import com.tencent.mobileqq.ar.utils.QRScreenUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class QRSession
  extends AbstractSession
  implements ARCamera.AutoFocusListener, MiniRecogListener
{
  private long jdField_a_of_type_Long = 500L;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread;
  private QRRecognizerListener jdField_a_of_type_ComTencentMobileqqArArengineQRRecognizerListener;
  private MiniRecog jdField_a_of_type_ComTencentMobileqqArCodeEngineMiniRecog;
  private MiniRecogListener jdField_a_of_type_ComTencentMobileqqArCodeEngineMiniRecogListener;
  private QRRecog jdField_a_of_type_ComTencentMobileqqArCodeEngineQRRecog;
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
    int j;
    label92:
    float f1;
    label108:
    float f2;
    label125:
    float f5;
    label155:
    label177:
    float f3;
    if (paramRect1.left < paramPoint.x)
    {
      i = paramPoint.x - paramRect1.left;
      if (paramRect1.right <= paramPoint.x) {
        break label395;
      }
      j = paramRect1.right - paramPoint.x;
      if (i <= 0) {
        break label401;
      }
      f1 = (i2 - i3) / i;
      if (j <= 0) {
        break label407;
      }
      f2 = (i4 - i5) / j;
      f5 = Math.min(f1, f2);
      if (paramRect1.top >= paramPoint.y) {
        break label414;
      }
      i = paramPoint.y - paramRect1.top;
      if (paramRect1.bottom <= paramPoint.y) {
        break label420;
      }
      j = paramRect1.bottom - paramPoint.y;
      if (i <= 0) {
        break label426;
      }
      f3 = (k - m) / i;
      label194:
      if (j <= 0) {
        break label433;
      }
    }
    float f8;
    label395:
    label401:
    label407:
    label414:
    label420:
    label426:
    label433:
    for (float f4 = (n - i1) / j;; f4 = 2.147484E+009F)
    {
      f5 = Math.min(f5, Math.min(f3, f4));
      float f6 = paramRect2.width() / paramRect1.width();
      float f7 = paramRect2.height() / paramRect1.height();
      f8 = Math.min(f6, f7);
      if (QLog.isColorLevel()) {
        QLog.i("QRSession", 2, String.format("calcZoomFactor_ori [codeRect,scanRect,prevCenter]=[%s|%s|%s]", new Object[] { paramRect1.toShortString(), paramRect2.toShortString(), paramPoint.toString() }));
      }
      if (QLog.isColorLevel()) {
        QLog.i("QRSession", 2, String.format("calcZoomFactor_calc [ratioLeft,ratioRight]=[%.2f,%.2f], [ratioTop,ratioBot]=[%.2f,%.2f] [wFactor,hFactor]=[%.2f,%.2f]", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f6), Float.valueOf(f7) }));
      }
      if ((f5 < 0.0F) || (f8 <= f5)) {
        break label440;
      }
      return f5;
      i = 0;
      break;
      j = 0;
      break label92;
      f1 = 2.147484E+009F;
      break label108;
      f2 = 2.147484E+009F;
      break label125;
      i = 0;
      break label155;
      j = 0;
      break label177;
      f3 = 2.147484E+009F;
      break label194;
    }
    label440:
    return f8;
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
          i += (paramArrayOfByte[(k * paramInt1 + m)] & 0xFF);
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
  
  private void a()
  {
    if ((this.jdField_f_of_type_Int <= 0) || (this.jdField_g_of_type_Int <= 0)) {
      return;
    }
    float f1 = this.jdField_g_of_type_Int / QRScreenUtil.jdField_a_of_type_Int;
    float f2 = this.jdField_f_of_type_Int / QRScreenUtil.jdField_b_of_type_Int;
    Rect localRect1 = new Rect((int)(this.jdField_a_of_type_AndroidGraphicsRect.left * f1), (int)(this.jdField_a_of_type_AndroidGraphicsRect.top * f2), (int)(f1 * this.jdField_a_of_type_AndroidGraphicsRect.right), (int)(f2 * this.jdField_a_of_type_AndroidGraphicsRect.bottom));
    Rect localRect2 = new Rect(0, 0, (int)(localRect1.width() * 1.5F), (int)(localRect1.height() * 1.5F));
    localRect2.offset(localRect1.centerX() - localRect2.centerX(), localRect1.centerY() - localRect2.centerY());
    localRect2.intersect(0, 0, this.jdField_g_of_type_Int, this.jdField_f_of_type_Int);
    Rect localRect3 = new Rect(0, 0, localRect1.height(), localRect1.width());
    localRect3.offset(localRect1.top, localRect1.left);
    Rect localRect4 = new Rect(0, 0, (int)(1.3F * localRect3.width()), (int)(1.2F * localRect3.height()));
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
      paramRect2.right = ((int)(f1 * paramRect2.right));
      paramRect2.bottom = ((int)(paramRect2.bottom * f2));
    }
    if (QLog.isColorLevel()) {
      QLog.i("QRSession", 2, String.format("[------ detect_point 2 rect=%s previewRect=%s screenRect=%s isQr=%b ------]", new Object[] { paramRect1, localRect, paramRect2, Boolean.valueOf(paramBoolean) }));
    }
  }
  
  private void a(ScannerResult paramScannerResult, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqArArengineQRRecognizerListener != null) && (this.jdField_a_of_type_Int == 2) && (!this.jdField_f_of_type_Boolean))
    {
      if (((paramScannerResult.a()) || (paramScannerResult.jdField_b_of_type_Boolean)) && (a(paramArrayOfByte, paramInt1, paramInt2)))
      {
        byte[] arrayOfByte = new byte[paramArrayOfByte.length];
        System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
        this.jdField_a_of_type_ComTencentMobileqqArArengineQRRecognizerListener.a(paramScannerResult, arrayOfByte, paramInt1, paramInt2);
      }
    }
    else
    {
      if (paramScannerResult.d())
      {
        if (!this.jdField_g_of_type_Boolean) {
          break label136;
        }
        paramInt1 = 6;
        label95:
        MiniScanReport.a(paramInt1);
      }
      if (paramScannerResult.c()) {
        if (!this.jdField_g_of_type_Boolean) {
          break label141;
        }
      }
    }
    label136:
    label141:
    for (paramInt1 = 5;; paramInt1 = 3)
    {
      MiniScanReport.a(paramInt1);
      return;
      this.jdField_a_of_type_ComTencentMobileqqArArengineQRRecognizerListener.a(paramScannerResult, null, 0, 0);
      break;
      paramInt1 = 1;
      break label95;
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
    if (this.jdField_a_of_type_ComTencentMobileqqArArengineQRRecognizerListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqArArengineQRRecognizerListener.a(localArrayList);
    }
  }
  
  private void a(boolean paramBoolean, float paramFloat)
  {
    int i;
    if ((this.jdField_a_of_type_ComTencentMobileqqArCodeEngineMiniRecog != null) && (this.jdField_a_of_type_ComTencentMobileqqArCodeEngineMiniRecog.a()))
    {
      i = 1;
      if (QLog.isColorLevel()) {
        if (i == 0) {
          break label203;
        }
      }
    }
    label203:
    for (int j = 1;; j = 0)
    {
      QLog.d("QRSession", 2, String.format("onQRRecognizeFail hasQR=%s qrAreaRatio=%s isMiniRecgReady =%d", new Object[] { Boolean.valueOf(paramBoolean), Float.valueOf(paramFloat), Integer.valueOf(j) }));
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
      return;
      i = 0;
      break;
    }
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    int j = -1;
    long l1 = System.currentTimeMillis();
    boolean bool2 = false;
    boolean bool1 = bool2;
    int i = j;
    long l2;
    if (this.jdField_c_of_type_Boolean)
    {
      bool1 = bool2;
      i = j;
      if (l1 - this.jdField_c_of_type_Long > 1000L)
      {
        l2 = System.currentTimeMillis();
        i = a(this.jdField_b_of_type_ArrayOfByte, paramInt1, paramInt2);
        if (i >= this.jdField_e_of_type_Int) {
          break label152;
        }
      }
    }
    label152:
    for (bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QRSession", 2, String.format("checkAvgLuminance avgLuminance=%s get avg luminance time cost:%sms", new Object[] { Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l2) }));
      }
      this.jdField_c_of_type_Long = l1;
      if ((this.jdField_a_of_type_ComTencentMobileqqArArengineQRRecognizerListener != null) && (this.jdField_a_of_type_Int == 2) && (i >= 0)) {
        this.jdField_a_of_type_ComTencentMobileqqArArengineQRRecognizerListener.a(i);
      }
      return bool1;
    }
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
    float f2 = 0.0F;
    if (paramList.size() <= 0) {
      return;
    }
    for (;;)
    {
      try
      {
        if ((((AIRect)paramList.get(0)).jdField_a_of_type_AndroidGraphicsRect.isEmpty()) || ((this.jdField_d_of_type_Long != 0L) && (SystemClock.uptimeMillis() - this.jdField_d_of_type_Long <= 500L))) {
          break label384;
        }
        f1 = ((AIRect)paramList.get(0)).jdField_a_of_type_AndroidGraphicsRect.width() / this.jdField_c_of_type_AndroidGraphicsRect.width();
        f2 = ((AIRect)paramList.get(0)).jdField_a_of_type_AndroidGraphicsRect.height() / this.jdField_c_of_type_AndroidGraphicsRect.height();
        if ((f1 >= 0.7F) || (f2 >= 0.7F)) {
          break label364;
        }
        bool = true;
        if (QLog.isColorLevel()) {
          QLog.i("QRSession", 2, String.format("[wRatio,hRatio,need]=[%.2f %.2f %b]", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Boolean.valueOf(bool) }));
        }
        if (!bool) {
          break label370;
        }
        paramList = new Rect(((AIRect)paramList.get(0)).jdField_a_of_type_AndroidGraphicsRect);
        Point localPoint = new Point(this.jdField_f_of_type_Int / 2, this.jdField_g_of_type_Int / 2);
        float f4 = a(paramList, this.jdField_c_of_type_AndroidGraphicsRect, localPoint);
        if (f4 < 1.2F) {
          break label370;
        }
        f3 = f4;
        if (f4 > 25.0F) {
          f3 = 25.0F;
        }
        bool = CameraProxy.a().a(f3, false);
        this.jdField_g_of_type_Boolean |= bool;
        if (!bool) {
          break label392;
        }
        this.jdField_d_of_type_Long = SystemClock.uptimeMillis();
        CameraProxy.a().c();
      }
      catch (Throwable paramList) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("QRSession", 2, String.format("onGetDetectRect zoom=%b [%.2f,%.2f]", new Object[] { Boolean.valueOf(bool), Float.valueOf(f2), Float.valueOf(f1) }));
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("QRSession", 2, paramList.getMessage(), paramList);
      return;
      label364:
      boolean bool = false;
      continue;
      label370:
      float f3 = f1;
      bool = false;
      float f1 = f2;
      f2 = f3;
      continue;
      label384:
      f1 = 0.0F;
      bool = false;
      continue;
      label392:
      f3 = f1;
      bool = true;
      f1 = f2;
      f2 = f3;
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
        this.jdField_a_of_type_ComTencentMobileqqArCodeEngineMiniRecog.b();
        this.jdField_b_of_type_Boolean = false;
      }
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.removeMessages(100);
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("QRSession", 2, "unInitQbar fail!", localException);
    }
  }
  
  private void d()
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {}
    for (StringBuilder localStringBuilder = new StringBuilder("doRecognizeInternal ");; localStringBuilder = null)
    {
      Object localObject;
      ArrayList localArrayList;
      long l2;
      boolean bool2;
      long l3;
      boolean bool3;
      long l4;
      boolean bool1;
      if (a(this.jdField_a_of_type_ArrayOfByte, this.jdField_f_of_type_Int, this.jdField_g_of_type_Int))
      {
        if ((this.jdField_b_of_type_AndroidGraphicsRect == null) || (this.jdField_d_of_type_AndroidGraphicsRect == null)) {
          a();
        }
        if ((this.jdField_b_of_type_AndroidGraphicsRect == null) || (this.jdField_d_of_type_AndroidGraphicsRect == null)) {
          return;
        }
        this.jdField_h_of_type_Boolean = true;
        int i = this.jdField_d_of_type_AndroidGraphicsRect.top;
        int j = this.jdField_d_of_type_AndroidGraphicsRect.left;
        int k = this.jdField_d_of_type_AndroidGraphicsRect.height();
        int m = this.jdField_d_of_type_AndroidGraphicsRect.width();
        if ((this.jdField_b_of_type_ArrayOfByte == null) || (this.jdField_b_of_type_ArrayOfByte.length != k * m * 3 / 2)) {
          this.jdField_b_of_type_ArrayOfByte = new byte[k * m * 3 / 2];
        }
        localObject = new int[2];
        if (ImgProcessScan.gray_rotate_crop_sub(this.jdField_b_of_type_ArrayOfByte, (int[])localObject, this.jdField_a_of_type_ArrayOfByte, this.jdField_f_of_type_Int, this.jdField_g_of_type_Int, i, j, k, m, 90, 0) == 0)
        {
          i = localObject[0];
          j = localObject[1];
          localObject = new ScannerResult();
          localArrayList = new ArrayList();
          l2 = System.currentTimeMillis();
          bool2 = this.jdField_a_of_type_ComTencentMobileqqArCodeEngineQRRecog.a(this.jdField_b_of_type_ArrayOfByte, i, j, (ScannerResult)localObject);
          l3 = System.currentTimeMillis();
          bool3 = this.jdField_a_of_type_ComTencentMobileqqArCodeEngineMiniRecog.a(this.jdField_a_of_type_ArrayOfByte, this.jdField_f_of_type_Int, this.jdField_g_of_type_Int, this.jdField_d_of_type_AndroidGraphicsRect, this.jdField_b_of_type_ArrayOfByte, i, j, (ScannerResult)localObject, localArrayList);
          l4 = System.currentTimeMillis();
          if ((localArrayList.size() > 1) && (((ScannerResult)localObject).b()) && (!((ScannerResult)localObject).a())) {
            ((ScannerResult)localObject).jdField_b_of_type_Boolean = true;
          }
          if ((bool2) || (bool3) || (!a(i, j))) {
            break label533;
          }
          bool1 = true;
          label335:
          if ((!bool1) && (!bool2) && (!bool3)) {
            this.jdField_h_of_type_Int += 1;
          }
          a(localArrayList);
          if (!((ScannerResult)localObject).b()) {
            break label539;
          }
          a((ScannerResult)localObject, this.jdField_a_of_type_ArrayOfByte, this.jdField_f_of_type_Int, this.jdField_g_of_type_Int);
          this.jdField_h_of_type_Int = 0;
        }
      }
      for (;;)
      {
        MiniScanReport.a((int)(l3 - l2), 0);
        MiniScanReport.a((int)(l4 - l3), 1);
        if (localStringBuilder != null) {
          localStringBuilder.append(String.format("...1 decode qrSuc=%b miniSuc=%b isDark=%b failCnt=%d \nscannerResult=%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool1), Integer.valueOf(this.jdField_h_of_type_Int), localObject }));
        }
        this.jdField_h_of_type_Boolean = false;
        if ((!QLog.isColorLevel()) || (localStringBuilder == null)) {
          break;
        }
        QLog.i("QRSession", 2, localStringBuilder.toString());
        QLog.d("QRSession", 2, String.format("doRecognizeInternal ...end  minicode_timecost=%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) }));
        return;
        label533:
        bool1 = false;
        break label335;
        label539:
        a(false, 0.0F);
        if (!localArrayList.isEmpty()) {
          b(localArrayList);
        }
      }
    }
  }
  
  public void a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArCodeEngineMiniRecogListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqArCodeEngineMiniRecogListener.a(paramLong);
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
  
  public void a(QRRecognizerListener paramQRRecognizerListener, MiniRecogListener paramMiniRecogListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqArArengineQRRecognizerListener = paramQRRecognizerListener;
    this.jdField_a_of_type_ComTencentMobileqqArCodeEngineMiniRecogListener = paramMiniRecogListener;
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
    long l;
    if (((this.jdField_a_of_type_Boolean) || (this.jdField_b_of_type_Boolean)) && (this.jdField_a_of_type_AndroidOsHandler != null) && (!this.jdField_f_of_type_Boolean) && ((paramBoolean) || (!this.jdField_a_of_type_AndroidOsHandler.hasMessages(101))) && (!this.jdField_h_of_type_Boolean))
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
      this.jdField_f_of_type_Int = paramInt1;
      this.jdField_g_of_type_Int = paramInt2;
    }
    for (this.jdField_b_of_type_Long = l;; this.jdField_b_of_type_Long = 0L)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeMessages(101);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(101);
      return;
      this.jdField_f_of_type_Int = 0;
      this.jdField_g_of_type_Int = 0;
    }
  }
  
  public boolean a(byte[] paramArrayOfByte)
  {
    if (this.jdField_a_of_type_Int == 2)
    {
      a(paramArrayOfByte, CameraProxy.a().a(), CameraProxy.a().b(), this.jdField_d_of_type_Boolean);
      if (MiniScanReport.a()) {
        MiniScanReport.b();
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
    if (MiniScanReport.a()) {
      MiniScanReport.c();
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
    MiniScanReport.a(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.QRSession
 * JD-Core Version:    0.7.0.1
 */
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
  private QRRecog A;
  private MiniRecog B;
  private boolean C = false;
  private int D = 0;
  private boolean E = true;
  private boolean F = false;
  private boolean G = false;
  private boolean H = false;
  private long I = 0L;
  AtomicInteger g = new AtomicInteger(0);
  private HandlerThread h;
  private Handler i;
  private QRRecognizerListener j;
  private MiniSaveImgListener k;
  private boolean l;
  private boolean m;
  private long n = 500L;
  private int o;
  private byte[] p;
  private int q;
  private int r;
  private long s;
  private Rect t;
  private Rect u;
  private Rect v;
  private Rect w;
  private byte[] x;
  private boolean y;
  private long z;
  
  public QRSession()
  {
    this.b = 0;
    CameraProxy.a().b(this);
    CameraProxy.a().a(this);
  }
  
  private static float a(Rect paramRect1, Rect paramRect2, Point paramPoint)
  {
    int i7 = paramPoint.x;
    int i8 = paramRect2.left;
    int i9 = paramRect2.right;
    int i10 = paramPoint.x;
    int i3 = paramPoint.y;
    int i4 = paramRect2.top;
    int i5 = paramRect2.bottom;
    int i6 = paramPoint.y;
    int i1;
    if (paramRect1.left < paramPoint.x) {
      i1 = paramPoint.x - paramRect1.left;
    } else {
      i1 = 0;
    }
    int i2;
    if (paramRect1.right > paramPoint.x) {
      i2 = paramRect1.right - paramPoint.x;
    } else {
      i2 = 0;
    }
    float f4 = 2.147484E+009F;
    float f1;
    if (i1 > 0) {
      f1 = (i7 - i8) / i1;
    } else {
      f1 = 2.147484E+009F;
    }
    float f2;
    if (i2 > 0) {
      f2 = (i9 - i10) / i2;
    } else {
      f2 = 2.147484E+009F;
    }
    float f5 = Math.min(f1, f2);
    if (paramRect1.top < paramPoint.y) {
      i1 = paramPoint.y - paramRect1.top;
    } else {
      i1 = 0;
    }
    if (paramRect1.bottom > paramPoint.y) {
      i2 = paramRect1.bottom - paramPoint.y;
    } else {
      i2 = 0;
    }
    float f3;
    if (i1 > 0) {
      f3 = (i3 - i4) / i1;
    } else {
      f3 = 2.147484E+009F;
    }
    if (i2 > 0) {
      f4 = (i5 - i6) / i2;
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
  
  private void a()
  {
    if (this.q > 0)
    {
      int i1 = this.r;
      if (i1 <= 0) {
        return;
      }
      float f1 = i1 / QRScreenUtil.a;
      float f2 = this.q / QRScreenUtil.b;
      Rect localRect1 = new Rect((int)(this.t.left * f1), (int)(this.t.top * f2), (int)(this.t.right * f1), (int)(this.t.bottom * f2));
      Rect localRect2 = new Rect(0, 0, (int)(localRect1.width() * 1.5F), (int)(localRect1.height() * 1.5F));
      localRect2.offset(localRect1.centerX() - localRect2.centerX(), localRect1.centerY() - localRect2.centerY());
      localRect2.intersect(0, 0, this.r, this.q);
      Rect localRect3 = new Rect(0, 0, localRect1.height(), localRect1.width());
      localRect3.offset(localRect1.top, localRect1.left);
      Rect localRect4 = new Rect(0, 0, (int)(localRect3.width() * 1.3F), (int)(localRect3.height() * 1.2F));
      localRect4.offset(localRect3.centerX() - localRect4.centerX(), localRect3.centerY() - localRect4.centerY());
      localRect4.intersect(0, 0, this.q, this.r);
      localRect1.set(0, 0, QRScreenUtil.a, QRScreenUtil.b);
      localRect2.set(0, 0, this.r, this.q);
      localRect4.set(0, 0, this.q, this.r);
      if (QLog.isColorLevel()) {
        QLog.d("QRSession", 2, String.format("initScanRect [mScanRect,qRRecogRect,qRRecogRectExt,rotateQRRecogRectExt]=[%s, %s, %s, %s] [w,h]=[%d,%d]", new Object[] { this.t.toShortString(), localRect1.toShortString(), localRect2.toShortString(), localRect4.toShortString(), Integer.valueOf(QRScreenUtil.a), Integer.valueOf(QRScreenUtil.b) }));
      }
      this.u = localRect1;
      this.w = localRect2;
      this.v = localRect4;
    }
  }
  
  private void a(Rect paramRect1, Rect paramRect2, boolean paramBoolean)
  {
    Rect localRect = new Rect();
    if ((paramRect1 != null) && (paramRect1.width() > 0) && (paramRect1.height() > 0))
    {
      localRect.set(0, 0, paramRect1.height(), paramRect1.width());
      localRect.offset(this.r - paramRect1.top - paramRect1.height(), paramRect1.left);
    }
    if ((localRect.width() > 0) && (localRect.height() > 0))
    {
      paramRect2.set(localRect);
      float f1 = QRScreenUtil.a / this.r;
      float f2 = QRScreenUtil.b / this.q;
      if (QLog.isColorLevel()) {
        QLog.i("QRSession", 2, String.format("getScreenRect [%.2f,%.2f, %d,%d,%d,%d]", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(QRScreenUtil.a), Integer.valueOf(QRScreenUtil.b), Integer.valueOf(this.r), Integer.valueOf(this.q) }));
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
    if ((this.j != null) && (this.a == 2) && (!this.F)) {
      if (((paramScannerResult.a()) || (paramScannerResult.d)) && (a(paramArrayOfByte, paramInt1, paramInt2)))
      {
        byte[] arrayOfByte = new byte[paramArrayOfByte.length];
        System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
        this.j.a(paramScannerResult, arrayOfByte, paramInt1, paramInt2);
      }
      else
      {
        this.j.a(paramScannerResult, null, 0, 0);
      }
    }
    if (paramScannerResult.h())
    {
      if (this.G) {
        paramInt1 = 6;
      } else {
        paramInt1 = 1;
      }
      ((IQRScanReportApi)QRoute.api(IQRScanReportApi.class)).markScanEnd(paramInt1);
    }
    if (paramScannerResult.g())
    {
      if (this.G) {
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
    int i1 = 0;
    while (i1 < paramList.size())
    {
      AIRect localAIRect = new AIRect();
      localAIRect.a = ((AIRect)paramList.get(i1)).a;
      localAIRect.c = ((AIRect)paramList.get(i1)).c;
      Rect localRect = ((AIRect)paramList.get(i1)).b;
      if ((localRect.width() > 0) && (localRect.height() > 0)) {
        a(localRect, localAIRect.b, true);
      }
      localArrayList.add(localAIRect);
      i1 += 1;
    }
    paramList = this.j;
    if (paramList != null) {
      paramList.a(localArrayList);
    }
  }
  
  private void a(boolean paramBoolean, float paramFloat)
  {
    MiniRecog localMiniRecog = this.B;
    int i1;
    if ((localMiniRecog != null) && (localMiniRecog.b())) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QRSession", 2, String.format("onQRRecognizeFail hasQR=%s qrAreaRatio=%s isMiniRecgReady =%d", new Object[] { Boolean.valueOf(paramBoolean), Float.valueOf(paramFloat), Integer.valueOf(i1) }));
    }
    if ((this.j != null) && (this.a == 2))
    {
      if ((paramBoolean) && (paramFloat > 0.003F) && (i1 == 0))
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
      this.j.a(paramBoolean, paramFloat);
    }
  }
  
  private boolean a(int paramInt1, int paramInt2)
  {
    long l1 = System.currentTimeMillis();
    boolean bool;
    if ((this.y) && (l1 - this.z > 1000L))
    {
      long l2 = System.currentTimeMillis();
      paramInt1 = b(this.x, paramInt1, paramInt2);
      if (paramInt1 < this.o) {
        bool = true;
      } else {
        bool = false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QRSession", 2, String.format("checkAvgLuminance avgLuminance=%s get avg luminance time cost:%sms", new Object[] { Integer.valueOf(paramInt1), Long.valueOf(System.currentTimeMillis() - l2) }));
      }
      this.z = l1;
    }
    else
    {
      paramInt1 = -1;
      bool = false;
    }
    if ((this.j != null) && (this.a == 2) && (paramInt1 >= 0)) {
      this.j.a(paramInt1);
    }
    return bool;
  }
  
  private boolean a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return (paramArrayOfByte != null) && (paramArrayOfByte.length > 0) && (paramArrayOfByte.length == paramInt1 * paramInt2 * 3 / 2);
  }
  
  private int b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramArrayOfByte.length > paramInt1 * paramInt2)
    {
      int i2 = 0;
      int i1 = 0;
      int i3 = 0;
      while (i2 < paramInt2)
      {
        int i4 = 0;
        while (i4 < paramInt1)
        {
          i3 += (paramArrayOfByte[(i2 * paramInt1 + i4)] & 0xFF);
          i1 += 1;
          i4 += 3;
        }
        i2 += 3;
      }
      if (i1 > 0) {
        return i3 / i1;
      }
    }
    return -1;
  }
  
  private void b()
  {
    this.A.a();
    this.l = true;
    this.B.a();
    this.m = true;
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
        bool = ((AIRect)paramList.get(0)).b.isEmpty();
        f2 = 0.0F;
        if ((bool) || ((this.I != 0L) && (SystemClock.uptimeMillis() - this.I <= 500L))) {
          break label395;
        }
        f2 = ((AIRect)paramList.get(0)).b.width() / this.v.width();
        f3 = ((AIRect)paramList.get(0)).b.height() / this.v.height();
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
        paramList = new Rect(((AIRect)paramList.get(0)).b);
        Point localPoint = new Point(this.q / 2, this.r / 2);
        float f4 = a(paramList, this.v, localPoint);
        if (f4 < 1.2F) {
          break label386;
        }
        f1 = f4;
        if (f4 > 25.0F) {
          f1 = 25.0F;
        }
        bool = CameraProxy.a().a(f1, false);
        this.G |= bool;
        if (!bool) {
          break label377;
        }
        this.I = SystemClock.uptimeMillis();
        CameraProxy.a().d();
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
      if (this.l)
      {
        this.A.b();
        this.l = false;
      }
      if (this.m)
      {
        this.B.c();
        this.m = false;
      }
      if (this.i != null)
      {
        this.i.removeMessages(100);
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
    if (a(this.p, this.q, this.r))
    {
      if ((this.u == null) || (this.w == null)) {
        a();
      }
      if (this.u != null)
      {
        Object localObject = this.w;
        if (localObject == null) {
          return;
        }
        this.H = true;
        int i1 = ((Rect)localObject).top;
        int i2 = this.w.left;
        int i3 = this.w.height();
        int i4 = this.w.width();
        localObject = this.x;
        if ((localObject == null) || (localObject.length != i3 * i4 * 3 / 2)) {
          this.x = new byte[i3 * i4 * 3 / 2];
        }
        localObject = new int[2];
        if (((IImgProcessApi)QRoute.api(IImgProcessApi.class)).gray_rotate_crop_sub(this.x, (int[])localObject, this.p, this.q, this.r, i1, i2, i3, i4, 90, 0) == 0)
        {
          i1 = localObject[0];
          i2 = localObject[1];
          localObject = new ScannerResult();
          ArrayList localArrayList = new ArrayList();
          long l2 = System.currentTimeMillis();
          boolean bool2 = this.A.a(this.x, i1, i2, (ScannerResult)localObject);
          long l3 = System.currentTimeMillis();
          boolean bool3 = this.B.a(this.p, this.q, this.r, this.w, this.x, i1, i2, (ScannerResult)localObject, localArrayList, this.g);
          long l4 = System.currentTimeMillis();
          if ((localArrayList.size() > 1) && (((ScannerResult)localObject).f()) && (!((ScannerResult)localObject).a())) {
            ((ScannerResult)localObject).d = true;
          }
          boolean bool1;
          if ((!bool2) && (!bool3) && (a(i1, i2))) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          if ((!bool1) && (!bool2) && (!bool3)) {
            this.D += 1;
          }
          a(localArrayList);
          if (((ScannerResult)localObject).f())
          {
            a((ScannerResult)localObject, this.p, this.q, this.r);
            this.D = 0;
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
            localStringBuilder.append(String.format("...1 decode qrSuc=%b miniSuc=%b isDark=%b failCnt=%d \nscannerResult=%s", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3), Boolean.valueOf(bool1), Integer.valueOf(this.D), localObject }));
          }
        }
      }
      else
      {
        return;
      }
    }
    this.H = false;
    if ((QLog.isColorLevel()) && (localStringBuilder != null))
    {
      QLog.i("QRSession", 2, localStringBuilder.toString());
      QLog.d("QRSession", 2, String.format("doRecognizeInternal ...end  minicode_timecost=%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) }));
    }
  }
  
  public void a(long paramLong)
  {
    MiniSaveImgListener localMiniSaveImgListener = this.k;
    if (localMiniSaveImgListener != null) {
      localMiniSaveImgListener.a(paramLong);
    }
  }
  
  public void a(Context paramContext, AppInterface paramAppInterface)
  {
    super.a(paramContext, paramAppInterface);
    this.h = ThreadManager.newFreeHandlerThread("QRRecognizerController", 0);
    this.h.start();
    this.i = new QRSession.CustomHandler(this, this.h.getLooper());
    this.A = new QRRecog(this.i);
    this.B = new MiniRecog(this.i, paramContext);
    this.B.a(this);
    this.n = 250L;
    if (ScanEntranceDPC.a().a) {
      this.n = 120L;
    }
    this.o = ScanEntranceDPC.a().h;
    this.i.sendEmptyMessage(100);
    QLog.i("QRSession", 1, String.format("init mQRRecognizeInterval=%s", new Object[] { Long.valueOf(this.n) }));
  }
  
  public void a(Rect paramRect)
  {
    if ((paramRect != null) && (!paramRect.equals(this.t)))
    {
      this.t = paramRect;
      a();
    }
  }
  
  public void a(QRRecognizerListener paramQRRecognizerListener, MiniSaveImgListener paramMiniSaveImgListener)
  {
    this.j = paramQRRecognizerListener;
    this.k = paramMiniSaveImgListener;
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.a == 2) {
      this.C = true;
    }
  }
  
  public void a(boolean paramBoolean, long paramLong)
  {
    this.y = paramBoolean;
    if (this.y) {
      this.z = (System.currentTimeMillis() + paramLong);
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((this.l) || (this.m))
    {
      Object localObject = this.i;
      if ((localObject != null) && (!this.F) && ((paramBoolean) || (!((Handler)localObject).hasMessages(101))) && (!this.H))
      {
        long l1 = System.currentTimeMillis();
        if ((!paramBoolean) && (l1 - this.s < this.n)) {
          return;
        }
        if (a(paramArrayOfByte, paramInt1, paramInt2))
        {
          localObject = this.p;
          if ((localObject == null) || (localObject.length != paramArrayOfByte.length)) {
            this.p = new byte[paramArrayOfByte.length];
          }
          System.arraycopy(paramArrayOfByte, 0, this.p, 0, paramArrayOfByte.length);
          this.q = paramInt1;
          this.r = paramInt2;
          this.s = l1;
        }
        else
        {
          this.q = 0;
          this.r = 0;
          this.s = 0L;
        }
        this.i.removeMessages(101);
        this.i.sendEmptyMessage(101);
      }
    }
  }
  
  public boolean a(byte[] paramArrayOfByte)
  {
    if (this.a == 2)
    {
      a(paramArrayOfByte, CameraProxy.a().h(), CameraProxy.a().i(), this.C);
      if (((IQRScanReportApi)QRoute.api(IQRScanReportApi.class)).isBaseTestSwitchOn()) {
        ((IQRScanReportApi)QRoute.api(IQRScanReportApi.class)).doFrame();
      }
    }
    this.C = false;
    return false;
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean != this.F)
    {
      this.F = paramBoolean;
      if (paramBoolean) {
        this.i.removeMessages(101);
      }
    }
  }
  
  public void k()
  {
    super.k();
    if (this.G) {
      this.G = false;
    }
  }
  
  public void m()
  {
    super.m();
    if (this.G) {
      CameraProxy.a().e();
    }
    if (((IQRScanReportApi)QRoute.api(IQRScanReportApi.class)).isBaseTestSwitchOn()) {
      ((IQRScanReportApi)QRoute.api(IQRScanReportApi.class)).stopFrame();
    }
  }
  
  public void o()
  {
    super.o();
    c();
    this.h.quit();
    this.h = null;
    this.i.removeCallbacksAndMessages(null);
    this.i = null;
    CameraProxy.a().c(this);
    CameraProxy.a().b(this);
    ((IQRScanReportApi)QRoute.api(IQRScanReportApi.class)).markScanEnd(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.QRSession
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.luggage.scanner.scanner.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Looper;
import android.view.TextureView;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.luggage.scanner.camera.b.b.a;
import com.tencent.luggage.scanner.qbar.LuggageScanDecodeQueue;
import com.tencent.luggage.scanner.qbar.LuggageScanDecodeQueue.ScanDecodeCallBack;
import com.tencent.luggage.scanner.scanner.ui.widget.ScannerFlashSwitcher;
import com.tencent.luggage.scanner.scanner.util.ScanCameraLightDetector;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.t;

public class a
  extends b
{
  private boolean A = false;
  private boolean B = false;
  private Runnable C = new a.1(this);
  private int D = 0;
  private int E = 0;
  private LuggageScanDecodeQueue.ScanDecodeCallBack F = new a.2(this);
  private com.tencent.luggage.wxa.qy.c<com.tencent.luggage.wxa.dk.b> G = new a.3(this);
  private long H;
  private a.b I = new a.b(this, Looper.getMainLooper());
  private com.tencent.luggage.wxa.dl.d f;
  private com.tencent.luggage.scanner.scanner.ui.widget.b g;
  private com.tencent.luggage.wxa.dl.a h;
  private ScannerFlashSwitcher i;
  private int j = 1;
  private boolean k = true;
  private long l;
  private a.a m;
  private Activity n;
  private int o = 0;
  private Point p = null;
  private boolean q = true;
  private boolean r = false;
  private boolean s = false;
  private boolean t = true;
  private com.tencent.luggage.scanner.scanner.util.b u = new com.tencent.luggage.scanner.scanner.util.b();
  private int v = 0;
  private long w = 0L;
  private long x = this.u.e();
  private boolean y = false;
  private boolean z = true;
  
  public a(Context paramContext)
  {
    super(paramContext);
  }
  
  private void A()
  {
    com.tencent.luggage.wxa.dl.a locala = this.h;
    if (locala != null) {
      locala.a(new a.11(this, locala));
    }
  }
  
  private void B()
  {
    o.d("Luggage.ScanUIRectView", "alvinluo updateScanCodeRect visibleResolution: %s", new Object[] { this.p });
    Point localPoint = this.p;
    if ((localPoint != null) && (localPoint.x > 0) && (this.p.y > 0)) {
      this.f.setDecorRect(new Rect(0, (int)(this.p.y * 1.0F / 19.0F), this.p.x, (int)(this.p.y * 17.0F / 19.0F)));
    }
  }
  
  private void C()
  {
    setOnTouchListener(new a.4(this));
  }
  
  private void D()
  {
    Runnable localRunnable = this.C;
    if (localRunnable != null) {
      removeCallbacks(localRunnable);
    }
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    if ((this.b.a()) && (((com.tencent.luggage.scanner.camera.f)this.b).n())) {
      ScanCameraLightDetector.a.a(paramArrayOfByte, ((com.tencent.luggage.scanner.camera.f)this.b).g().x, ((com.tencent.luggage.scanner.camera.f)this.b).g().y);
    }
    int i1 = this.j;
    if ((i1 != 1) && (i1 != 4) && (i1 != 8))
    {
      o.d("Luggage.ScanUIRectView", "unknown scan mode %d", new Object[] { Integer.valueOf(i1) });
      return;
    }
    b(paramArrayOfByte);
  }
  
  private void b(byte[] paramArrayOfByte)
  {
    if ((this.l != 0L) && (this.b.a()))
    {
      Object localObject2 = this.b.g();
      if (localObject2 != null)
      {
        Object localObject1 = getScanCodeRect();
        boolean bool = this.B;
        if (bool)
        {
          int i1 = this.v;
          if (i1 != 1)
          {
            if ((!bool) || (i1 != 2)) {
              break label255;
            }
            localObject2 = new Rect(0, 0, this.D, this.E);
            localObject3 = this.h;
            if (localObject3 != null)
            {
              ((com.tencent.luggage.wxa.dl.a)localObject3).setPreviewRect((Rect)localObject2);
              this.h.setScanRect((Rect)localObject1);
              localObject1 = this.h;
              if ((localObject1 instanceof com.tencent.luggage.scanner.scanner.ui.widget.a)) {
                ((com.tencent.luggage.scanner.scanner.ui.widget.a)localObject1).setNeedRotate(false);
              }
            }
            LuggageScanDecodeQueue.getInstance().addDecodeTask(paramArrayOfByte, new Point(this.D, this.E), 0, (Rect)localObject2);
            break label255;
          }
        }
        Object localObject3 = ((com.tencent.luggage.scanner.camera.f)this.b).a((Rect)localObject1);
        com.tencent.luggage.wxa.dl.a locala = this.h;
        if (locala != null)
        {
          locala.setPreviewRect((Rect)localObject3);
          this.h.setScanRect((Rect)localObject1);
          localObject1 = this.h;
          if ((localObject1 instanceof com.tencent.luggage.scanner.scanner.ui.widget.a)) {
            ((com.tencent.luggage.scanner.scanner.ui.widget.a)localObject1).setNeedRotate(true);
          }
        }
        LuggageScanDecodeQueue.getInstance().addDecodeTask(paramArrayOfByte, (Point)localObject2, this.b.f(), (Rect)localObject3);
      }
      label255:
      if ((!((com.tencent.luggage.scanner.camera.a)this.b).j()) && (LuggageScanDecodeQueue.getInstance().getScanFrameCount() > 50))
      {
        o.d("Luggage.ScanUIRectView", "change to FOCUS_MODE_AUTO");
        this.b.a("auto");
        b(100L);
      }
    }
  }
  
  private void c(long paramLong)
  {
    long l1 = System.currentTimeMillis() - this.H;
    if (l1 > d)
    {
      this.I.removeMessages(0);
      this.I.sendEmptyMessageDelayed(0, paramLong);
      return;
    }
    long l2 = d;
    this.I.removeMessages(0);
    this.I.sendEmptyMessageDelayed(0, paramLong + (l2 - l1));
  }
  
  private void c(boolean paramBoolean)
  {
    Object localObject = this.h;
    if (localObject != null) {
      ((com.tencent.luggage.wxa.dl.a)localObject).a(paramBoolean);
    }
    localObject = this.g;
    if (localObject != null) {
      ((com.tencent.luggage.scanner.scanner.ui.widget.b)localObject).a(paramBoolean);
    }
  }
  
  private Rect getScanCodeRect()
  {
    return getDecorRect();
  }
  
  private String getScanTips()
  {
    if (!this.k) {
      return "";
    }
    int i1 = this.j;
    if (i1 != 1)
    {
      if (i1 != 4)
      {
        if (i1 != 8) {
          return "";
        }
        return getResources().getString(2131895618);
      }
      return getResources().getString(2131895619);
    }
    return getResources().getString(2131915912);
  }
  
  private boolean q()
  {
    return com.tencent.luggage.scanner.scanner.util.d.a(this.j);
  }
  
  private void r()
  {
    o.d("Luggage.ScanUIRectView", "alvinluo onCameraOpened");
    ((com.tencent.luggage.scanner.camera.f)this.b).a(false);
    a(new a.7(this));
  }
  
  private void s()
  {
    com.tencent.luggage.scanner.scanner.util.b localb = this.u;
    if (localb != null)
    {
      int i1 = localb.g();
      o.d("Luggage.ScanUIRectView", "alvinluo checkAndRetry retryType: %d, canRetry: %b", new Object[] { Integer.valueOf(i1), Boolean.valueOf(this.u.b(i1)) });
      if (this.u.b(i1))
      {
        if (i1 == 1)
        {
          this.u.a(true);
          t();
          return;
        }
        if (i1 == 2)
        {
          this.u.a(true);
          this.B = true;
          this.v = i1;
          c(0L);
        }
      }
    }
  }
  
  private void t()
  {
    try
    {
      o.d("Luggage.ScanUIRectView", "alvinluo checkAndReopenCamera");
      a(new a.9(this));
      return;
    }
    catch (Exception localException)
    {
      o.a("Luggage.ScanUIRectView", localException, "alvinluo checkAnReopenCamera exception", new Object[0]);
    }
  }
  
  private void u()
  {
    com.tencent.luggage.wxa.rz.f.a.a(new a.10(this), "takeOneShotByTextureLoopTag");
  }
  
  private byte[] v()
  {
    int i3;
    int i2;
    int i1;
    try
    {
      l1 = System.currentTimeMillis();
      i3 = this.a.getWidth();
      int i4 = this.a.getHeight();
      i2 = i3;
      i1 = i4;
      if (this.u == null) {
        break label276;
      }
      i2 = i3;
      i1 = i4;
      if (this.u.h() == 0.0F) {
        break label276;
      }
      i2 = (int)(this.a.getWidth() * this.u.h());
      i1 = (int)(this.a.getHeight() * this.u.h());
    }
    catch (Exception localException)
    {
      long l1;
      Object localObject;
      long l2;
      o.a("Luggage.ScanUIRectView", localException, "alvinluo generateFrameByTextureView exception", new Object[0]);
    }
    localObject = this.a.getBitmap(i3, i2);
    o.e("Luggage.ScanUIRectView", "alvinluo generateFrameByTextureView getBitmap cost: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
    if ((localObject != null) && (!((Bitmap)localObject).isRecycled()))
    {
      this.D = ((Bitmap)localObject).getWidth();
      this.E = ((Bitmap)localObject).getHeight();
      o.e("Luggage.ScanUIRectView", "alvinluo generateFrameByTextureView bitmap width: %d, height: %d", new Object[] { Integer.valueOf(this.D), Integer.valueOf(this.E) });
      l1 = System.currentTimeMillis();
      localObject = com.tencent.luggage.scanner.scanner.util.c.a(this.D, this.E, (Bitmap)localObject);
      l2 = System.currentTimeMillis();
      if (localObject == null) {
        break label303;
      }
      i1 = localObject.length;
    }
    for (;;)
    {
      o.e("Luggage.ScanUIRectView", "alvinluo generateFrameByTextureView yuvData: %d, getNV21 cost: %d", new Object[] { Integer.valueOf(i1), Long.valueOf(l2 - l1) });
      return localObject;
      return null;
      label276:
      i3 = i2;
      if (i2 % 2 != 0) {
        i3 = i2 - 1;
      }
      i2 = i1;
      if (i1 % 2 == 0) {
        break;
      }
      i2 = i1 - 1;
      break;
      label303:
      i1 = -1;
    }
  }
  
  private void w()
  {
    this.g = new com.tencent.luggage.scanner.scanner.ui.widget.b(getContext());
    this.i = this.g.getFlashSwitcherView();
    addView(this.g, new FrameLayout.LayoutParams(-1, -1));
  }
  
  private void x()
  {
    o.e("Luggage.ScanUIRectView", "alvinluo createScanMaskView mode: %d, bottomHeight: %d", new Object[] { Integer.valueOf(this.j), Integer.valueOf(this.o) });
    int i1 = this.j;
    if ((i1 != 1) && (i1 != 4) && (i1 != 8))
    {
      o.d("Luggage.ScanUIRectView", "unknown scan mode %d", new Object[] { Integer.valueOf(i1) });
    }
    else
    {
      B();
      this.h = new com.tencent.luggage.scanner.scanner.ui.widget.a(getContext());
      addView(this.h);
    }
    Object localObject = this.h;
    if ((localObject != null) && (this.g != null))
    {
      ((com.tencent.luggage.wxa.dl.a)localObject).setBottomExtraHeight(this.o);
      this.h.a(this.n);
      this.h.a(this.i);
      if ((this.b instanceof com.tencent.luggage.scanner.camera.f)) {
        this.h.a((com.tencent.luggage.scanner.camera.f)this.b);
      }
      this.h.a(this.g.getScanTipsView());
      this.h.c(this.g.getGalleryButton());
      localObject = this.i;
      if (localObject != null) {
        setFlashStatus(((ScannerFlashSwitcher)localObject).c());
      }
      if (this.t)
      {
        this.g.setShowTitle(false);
        this.t = false;
      }
      else
      {
        this.g.setShowTitle(true);
      }
      this.h.e();
      this.g.a();
    }
  }
  
  private void y()
  {
    String str = getScanTips();
    this.g.setScanTips(str);
    int i1 = this.j;
    if ((i1 != 1) && (i1 != 4) && (i1 != 8))
    {
      o.b("Luggage.ScanUIRectView", "alvinluo refreshSharedMaskView unknown scan mode %d", new Object[] { Integer.valueOf(i1) });
      return;
    }
    this.g.setScanTitle(getResources().getString(2131915903));
  }
  
  private void z()
  {
    o.e("Luggage.ScanUIRectView", "alvinluo releaseView");
    Object localObject = this.h;
    if (localObject != null) {
      ((com.tencent.luggage.wxa.dl.a)localObject).g();
    }
    localObject = this.g;
    if (localObject != null) {
      ((com.tencent.luggage.scanner.scanner.ui.widget.b)localObject).c();
    }
  }
  
  protected void a()
  {
    this.b = new com.tencent.luggage.scanner.camera.f();
  }
  
  public void a(long paramLong)
  {
    o.e("Luggage.ScanUIRectView", "alvinluo takeOneShot timeout: %d, isRetry: %b, onPreviewFrameCalled: %b, canReportOnPreviewFrame: %b, hasReport: %b", new Object[] { Long.valueOf(this.x), Boolean.valueOf(this.B), Boolean.valueOf(this.A), Boolean.valueOf(this.z), Boolean.valueOf(this.y) });
    if (!this.B)
    {
      super.a(paramLong);
      this.w = System.currentTimeMillis();
      if ((!this.A) && (this.z) && (q()))
      {
        removeCallbacks(this.C);
        postDelayed(this.C, this.x);
      }
    }
    else
    {
      com.tencent.luggage.scanner.scanner.util.b localb = this.u;
      if ((localb != null) && (localb.b(this.v)))
      {
        int i1 = this.v;
        if (i1 == 1)
        {
          super.a(paramLong);
          this.w = System.currentTimeMillis();
          return;
        }
        if (i1 == 2) {
          c(paramLong);
        }
      }
    }
  }
  
  public void a(b.b.a parama)
  {
    super.a(new a.8(this, parama));
  }
  
  public void a(Object paramObject, com.tencent.luggage.wxa.dl.e parame)
  {
    o.d("Luggage.ScanUIRectView", "alvinluo onScanSuccess");
    D();
    e();
    h();
    com.tencent.luggage.wxa.dl.a locala = this.h;
    if (locala != null)
    {
      locala.a(paramObject, parame);
      this.h.b(this.a);
    }
    paramObject = this.g;
    if (paramObject != null) {
      paramObject.b();
    }
    if (q())
    {
      paramObject = this.u;
      if (paramObject != null) {
        paramObject.d();
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    o.f("Luggage.ScanUIRectView", "alvinluo onShowNoDataView show: %b", new Object[] { Boolean.valueOf(paramBoolean) });
    Object localObject = this.g;
    if (localObject != null) {
      ((com.tencent.luggage.scanner.scanner.ui.widget.b)localObject).c(paramBoolean ^ true);
    }
    localObject = this.h;
    if (localObject != null) {
      ((com.tencent.luggage.wxa.dl.a)localObject).b(paramBoolean ^ true);
    }
  }
  
  public void b()
  {
    super.b();
    if (q()) {
      LuggageScanDecodeQueue.getInstance().init(getContext());
    }
    C();
    com.tencent.luggage.wxa.qy.a.a.b(this.G);
    com.tencent.luggage.scanner.scanner.util.b localb = this.u;
    if (localb != null) {
      localb.a();
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      c(paramBoolean);
      return;
    }
    t.a(new a.12(this, paramBoolean));
  }
  
  public void c()
  {
    super.c();
    if (!this.b.c())
    {
      o.d("Luggage.ScanUIRectView", "alvinluo onResume openCamera");
      a(null);
    }
    else if (!this.b.a())
    {
      o.d("Luggage.ScanUIRectView", "alvinluo onResume startPreview");
      ((com.tencent.luggage.scanner.camera.f)this.b).a(false);
      a(new a.5(this));
      o.d("Luggage.ScanUIRectView", "focus mode %s", new Object[] { this.b.k() });
    }
    else
    {
      o.d("Luggage.ScanUIRectView", "alvinluo onResume camera is previewing");
      o.d("Luggage.ScanUIRectView", "focus mode %s", new Object[] { this.b.k() });
      a(0L);
    }
    o.d("Luggage.ScanUIRectView", "onResume %s", new Object[] { af.c() });
    this.l = System.currentTimeMillis();
    if (q()) {
      LuggageScanDecodeQueue.getInstance().startSession(this.l, this.F);
    }
    com.tencent.luggage.wxa.dl.a locala = this.h;
    if (locala != null) {
      locala.c();
    }
    t.a(new a.6(this), 300L);
    this.s = true;
  }
  
  public void d()
  {
    o.d("Luggage.ScanUIRectView", "alvinluo stopCurrentSession %d", new Object[] { Long.valueOf(this.l) });
    LuggageScanDecodeQueue.getInstance().stopSession(this.l);
    this.l = 0L;
  }
  
  public void e()
  {
    super.e();
    o.d("Luggage.ScanUIRectView", "alvinluo onPuase");
    D();
    com.tencent.luggage.wxa.dl.a locala = this.h;
    if (locala != null) {
      locala.d();
    }
    d();
  }
  
  public void f()
  {
    super.f();
    p();
    ScanCameraLightDetector.a.a();
  }
  
  public void g()
  {
    super.g();
    z();
    LuggageScanDecodeQueue.getInstance().release();
    com.tencent.luggage.wxa.qy.a.a.c(this.G);
    removeCallbacks(this.C);
    this.C = null;
    com.tencent.luggage.scanner.scanner.util.b localb = this.u;
    if (localb != null) {
      localb.b();
    }
  }
  
  public Rect getDecorRect()
  {
    return this.f.getDecorRect();
  }
  
  public com.tencent.luggage.scanner.camera.g getScanCamera()
  {
    return this.b;
  }
  
  public com.tencent.luggage.scanner.scanner.ui.widget.b getSharedMaskView()
  {
    return this.g;
  }
  
  public void h()
  {
    super.h();
    m();
  }
  
  protected void i()
  {
    super.i();
    this.f = new com.tencent.luggage.wxa.dl.d(getContext());
    addView(this.f, new FrameLayout.LayoutParams(-1, -1));
    w();
    y();
  }
  
  public void j()
  {
    this.f.setVisibility(8);
    y();
    A();
    x();
  }
  
  public void k()
  {
    if ((this.g != null) && (!this.i.c())) {
      this.g.b(true);
    }
  }
  
  public void l()
  {
    if ((this.g != null) && (this.i.c())) {
      this.g.b(false);
    }
  }
  
  public void m()
  {
    this.r = true;
    this.s = false;
  }
  
  public boolean n()
  {
    if (q())
    {
      com.tencent.luggage.wxa.dl.a locala = this.h;
      if ((locala != null) && ((locala instanceof com.tencent.luggage.scanner.scanner.ui.widget.a))) {
        return locala.f();
      }
    }
    return false;
  }
  
  public void o()
  {
    com.tencent.luggage.wxa.dl.a locala = this.h;
    if ((locala != null) && ((locala instanceof com.tencent.luggage.scanner.scanner.ui.widget.a))) {
      ((com.tencent.luggage.scanner.scanner.ui.widget.a)locala).b();
    }
  }
  
  public void onAutoFocus(boolean paramBoolean, Camera paramCamera)
  {
    o.d("Luggage.ScanUIRectView", "onAutoFocus %s", new Object[] { Boolean.valueOf(paramBoolean) });
    if (paramBoolean)
    {
      this.z = false;
      a(0L);
    }
    b(e);
  }
  
  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    super.onPreviewFrame(paramArrayOfByte, paramCamera);
    this.A = true;
    boolean bool;
    if (paramArrayOfByte == null) {
      bool = true;
    } else {
      bool = false;
    }
    o.e("Luggage.ScanUIRectView", "onPreviewFrame null data: %b, isPreviewPaused: %b, canResumePreview: %b", new Object[] { Boolean.valueOf(bool), Boolean.valueOf(this.r), Boolean.valueOf(this.s) });
    int i1 = this.v;
    if (i1 == 2)
    {
      paramCamera = this.u;
      if (paramCamera != null) {
        paramCamera.a(i1);
      }
      this.B = false;
    }
    removeCallbacks(this.C);
    paramCamera = this.u;
    if (paramCamera != null)
    {
      paramCamera.a(System.currentTimeMillis() - this.w);
      this.u.c();
    }
    if ((this.r) && (this.s))
    {
      this.r = false;
      this.s = false;
      b(false);
      a(100L);
      return;
    }
    if (paramArrayOfByte == null)
    {
      o.c("Luggage.ScanUIRectView", "alvinluo onPreviewFrame data is null");
      a(0L);
      return;
    }
    a(paramArrayOfByte);
  }
  
  public void onSurfaceTextureAvailable(SurfaceTexture paramSurfaceTexture, int paramInt1, int paramInt2)
  {
    super.onSurfaceTextureAvailable(paramSurfaceTexture, paramInt1, paramInt2);
    paramSurfaceTexture = this.p;
    if ((paramSurfaceTexture == null) || (paramInt1 != paramSurfaceTexture.x) || (paramInt2 != this.p.y))
    {
      if (this.p == null) {
        this.p = new Point(paramInt1, paramInt2);
      }
      if (q()) {
        B();
      }
    }
  }
  
  public void setActivity(Activity paramActivity)
  {
    this.n = paramActivity;
  }
  
  public void setBottomExtraHeight(int paramInt)
  {
    this.o = paramInt;
  }
  
  public void setDecodeSuccessFrameData(com.tencent.luggage.scanner.qbar.e parame)
  {
    com.tencent.luggage.wxa.dl.a locala = this.h;
    if (locala != null) {
      locala.setDecodeSuccessFrameData(parame);
    }
  }
  
  public void setDecorRect(Rect paramRect)
  {
    this.f.setDecorRect(paramRect);
  }
  
  public void setFlashStatus(boolean paramBoolean)
  {
    com.tencent.luggage.scanner.scanner.ui.widget.b localb = this.g;
    if (localb != null) {
      localb.setFlashStatus(paramBoolean);
    }
  }
  
  public void setScanCallback(a.a parama)
  {
    this.m = parama;
  }
  
  public void setScanCodeReaders(int[] paramArrayOfInt)
  {
    LuggageScanDecodeQueue.getInstance().setReaders(paramArrayOfInt);
  }
  
  public void setScanMode(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void setShowScanTips(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }
  
  public void setSuccessMarkClickListener(com.tencent.luggage.scanner.scanner.ui.widget.c paramc)
  {
    com.tencent.luggage.wxa.dl.a locala = this.h;
    if ((locala instanceof com.tencent.luggage.scanner.scanner.ui.widget.a)) {
      ((com.tencent.luggage.scanner.scanner.ui.widget.a)locala).setSuccessMarkClickListener(paramc);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.scanner.scanner.ui.a
 * JD-Core Version:    0.7.0.1
 */
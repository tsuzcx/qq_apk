package com.tencent.luggage.wxa.be;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.media.ThumbnailUtils;
import android.provider.Settings.System;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.UiThread;
import com.tencent.luggage.wxa.jx.ah;
import com.tencent.luggage.wxa.jx.f.b;
import com.tencent.luggage.wxa.jx.f.c;
import com.tencent.luggage.wxa.jx.f.d;
import com.tencent.luggage.wxa.kp.i;
import com.tencent.luggage.wxa.kp.k;
import com.tencent.luggage.wxa.pd.t.a;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public class a
  extends RelativeLayout
  implements f.b, f.c, f.d, com.tencent.luggage.wxa.kp.e
{
  private com.tencent.luggage.wxa.kp.b A;
  private ImageView B;
  private d C;
  private String D;
  private String E;
  private String F;
  private int G = -1;
  private boolean H = false;
  private long I = -1L;
  private long J = -1L;
  private WindowManager K = (WindowManager)r.a().getSystemService("window");
  private float L;
  private long M;
  private boolean N;
  private t.a O = t.a.c;
  private AtomicBoolean P = new AtomicBoolean(false);
  private List<Runnable> Q;
  private com.tencent.luggage.wxa.pd.t R = new com.tencent.luggage.wxa.pd.t(r.a(), new a.1(this));
  protected c a_;
  protected boolean b;
  private Context d;
  private com.tencent.luggage.wxa.jx.c e;
  private String f = "scanCode";
  private int g;
  private a.a h;
  private String i;
  private int j;
  private String k = "back";
  private String l = "auto";
  private String m = "high";
  private String n;
  private boolean o = false;
  private boolean p = false;
  private boolean q;
  private boolean r = false;
  private int s = 1080;
  private int t = 1920;
  private int u = 1080;
  private int v = 1920;
  private Rect w;
  private int x;
  private boolean y;
  private com.tencent.luggage.wxa.kp.c z;
  
  public a(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  private Bitmap a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (af.c(paramString)) {
      return null;
    }
    Bitmap localBitmap = ThumbnailUtils.createVideoThumbnail(paramString, 1);
    if (localBitmap == null)
    {
      o.b("MicroMsg.AppBrandCameraView", "create remux thumb bmp error, target path %s", new Object[] { paramString });
      return localBitmap;
    }
    return com.tencent.luggage.wxa.qz.b.a(localBitmap, paramInt2, paramInt1, true, true);
  }
  
  private void a(int paramInt, String paramString1, String paramString2)
  {
    o.d("MicroMsg.AppBrandCameraView", "onTakePhoto.ret:%d, path:%s, errMsg:%s", new Object[] { Integer.valueOf(paramInt), paramString1, paramString2 });
    com.tencent.luggage.wxa.kp.c localc = this.z;
    if (localc != null) {
      localc.a(paramInt, paramString1, paramString2, this.u, this.v);
    }
    this.H = false;
    q();
    i();
  }
  
  private void a(Context paramContext)
  {
    this.d = paramContext;
    this.P.set(false);
    LayoutInflater.from(paramContext).inflate(2131625210, this);
  }
  
  private void o()
  {
    Object localObject = new HashMap();
    ((Map)localObject).put("cameraId", Integer.valueOf(getCameraId()));
    localObject = new JSONObject((Map)localObject).toString();
    new i().b(this.e).b((String)localObject).a();
  }
  
  private void p()
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void q()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(com.tencent.luggage.wxa.rc.b.a());
    localStringBuilder.append(String.format("%s%d.%s", new Object[] { "capture", Long.valueOf(System.currentTimeMillis()), "jpg" }));
    this.F = localStringBuilder.toString();
  }
  
  private void r()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Wxa_");
    ((StringBuilder)localObject).append(System.currentTimeMillis());
    localObject = ((StringBuilder)localObject).toString();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(com.tencent.luggage.wxa.hz.a.f());
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(".mp4");
    this.D = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(com.tencent.luggage.wxa.hz.a.f());
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(".jpeg");
    this.E = localStringBuilder.toString();
    localObject = this.C;
    if (localObject != null) {
      ((d)localObject).a(this.D);
    }
  }
  
  private void s()
  {
    if (this.C != null)
    {
      String str = this.l;
      if (str == null) {
        return;
      }
      if (str.equals("auto"))
      {
        this.C.c(3);
        return;
      }
      if (this.l.equals("torch"))
      {
        this.C.c(4);
        return;
      }
      if (this.l.equals("on"))
      {
        int i1 = this.G;
        if ((i1 != 2) && (i1 != 4) && (this.l.equals("on")))
        {
          this.C.c(2);
          return;
        }
        this.C.c(1);
        return;
      }
      this.C.c(2);
    }
  }
  
  private void t()
  {
    o.d("MicroMsg.AppBrandCameraView", "setCameraMode mode:%s", new Object[] { this.f });
    u();
    this.h = a(this.f);
    this.h.d();
  }
  
  private void u()
  {
    a.a locala = this.h;
    if (locala != null)
    {
      locala.e();
      this.h = null;
    }
  }
  
  private boolean v()
  {
    return this.y;
  }
  
  private boolean w()
  {
    ContentResolver localContentResolver = getContext().getContentResolver();
    boolean bool = false;
    if (Settings.System.getInt(localContentResolver, "accelerometer_rotation", 0) == 0) {
      bool = true;
    }
    return bool;
  }
  
  private boolean x()
  {
    Object localObject = this.d;
    boolean bool2 = localObject instanceof Activity;
    boolean bool1 = true;
    if (!bool2) {
      return true;
    }
    localObject = (Activity)localObject;
    if (((Activity)localObject).getRequestedOrientation() != 0)
    {
      if (((Activity)localObject).getRequestedOrientation() == 1) {
        return true;
      }
      bool1 = false;
    }
    return bool1;
  }
  
  @UiThread
  private void y()
  {
    if (this.N)
    {
      o.d("MicroMsg.AppBrandCameraView", "camera already in pre rotate mode");
      return;
    }
    this.N = true;
    t.a locala = this.O;
    o.d("MicroMsg.AppBrandCameraView", "wait for another release called");
    com.tencent.luggage.wxa.qz.t.a(new a.6(this, locala), 750L);
  }
  
  private void z()
  {
    boolean bool = af.c(this.n);
    int i2 = 720;
    int i1 = i2;
    if (!bool)
    {
      String str = this.n;
      i1 = -1;
      i3 = str.hashCode();
      if (i3 != -1078030475)
      {
        if (i3 != 107348)
        {
          if ((i3 == 3202466) && (str.equals("high"))) {
            i1 = 0;
          }
        }
        else if (str.equals("low")) {
          i1 = 1;
        }
      }
      else if (str.equals("medium")) {
        i1 = 2;
      }
      if (i1 != 0)
      {
        if (i1 != 1) {
          i1 = i2;
        } else {
          i1 = 480;
        }
      }
      else {
        i1 = 1080;
      }
    }
    int i3 = this.g;
    i2 = i1;
    if (i3 > i1)
    {
      o.d("MicroMsg.AppBrandCameraView", "framesize is : %d, large than preview size: %d", new Object[] { Integer.valueOf(i3), Integer.valueOf(i1) });
      i2 = this.g;
    }
    this.C.b(i2);
  }
  
  public float a(float paramFloat)
  {
    if (this.C != null)
    {
      if (paramFloat < 1.0F) {
        return paramFloat;
      }
      float f2 = this.L;
      float f1 = paramFloat;
      if (paramFloat > f2) {}
      for (f1 = f2; (!this.C.b(f1)) && (f1 > 0.0F); f1 -= 0.1F) {}
      return f1;
    }
    return 0.0F;
  }
  
  protected a.a a(String paramString)
  {
    return new a.b(this, null);
  }
  
  protected d a(Context paramContext, int paramInt1, int paramInt2)
  {
    return null;
  }
  
  public void a()
  {
    o.d("MicroMsg.AppBrandCameraView", "initView");
    if (!com.tencent.luggage.wxa.kp.a.a().c()) {
      return;
    }
    r();
    q();
    p();
    j();
    this.P.compareAndSet(false, true);
    if (v())
    {
      this.R.a(60);
      this.R.enable();
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    o.d("MicroMsg.AppBrandCameraView", "x:%d, y:%d, w:%d, h:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) });
    if (paramInt3 > 0)
    {
      if (paramInt4 <= 0) {
        return;
      }
      this.w = new Rect(paramInt1, paramInt2, paramInt3 + paramInt1, paramInt4 + paramInt2);
    }
  }
  
  public void a(com.tencent.luggage.wxa.jx.c paramc, String paramString)
  {
    o.d("MicroMsg.AppBrandCameraView", "listenFrameChange");
    if (this.z == null) {
      return;
    }
    if (this.C == null)
    {
      o.c("MicroMsg.AppBrandCameraView", "listenFrameChange recordView null");
      this.z.a("camera illegal state", -1, -1, -1);
      return;
    }
    if (this.a_ == null) {
      this.a_ = new c(paramc);
    }
    paramc = new a.5(this);
    if (!this.b)
    {
      if (this.Q == null) {
        this.Q = new ArrayList();
      }
      this.Q.add(paramc);
      return;
    }
    paramc.run();
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (af.b(this.k, paramString)) {
      return;
    }
    if (af.b(this.f, "scanCode")) {
      return;
    }
    this.k = paramString;
    if (!paramBoolean)
    {
      paramString = this.C;
      if (paramString != null) {
        paramString.h();
      }
    }
  }
  
  public boolean a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((this.s == paramInt1) && (this.t == paramInt2)) {
      return false;
    }
    o.d("MicroMsg.AppBrandCameraView", "setViewSize");
    this.s = paramInt1;
    this.t = paramInt2;
    return true;
  }
  
  public void b()
  {
    f();
    o();
  }
  
  public void c()
  {
    e();
  }
  
  public void d()
  {
    c localc = this.a_;
    if (localc != null) {
      localc.a(this.C);
    }
    g();
    this.P.compareAndSet(true, false);
  }
  
  public void e()
  {
    o.d("MicroMsg.AppBrandCameraView", "onUIResume");
    try
    {
      if (v())
      {
        this.R.a(60);
        this.R.enable();
      }
      if (!this.P.get())
      {
        o.c("MicroMsg.AppBrandCameraView", "no execute initView");
        return;
      }
      p();
      t();
      s();
      if (this.a_ != null) {
        this.a_.c(this.C);
      }
      return;
    }
    finally {}
  }
  
  public void f()
  {
    o.d("MicroMsg.AppBrandCameraView", "onUIPause");
    if (v()) {
      this.R.disable();
    }
    if (this.G == 2)
    {
      o.e("MicroMsg.AppBrandCameraView", "onStopRecord fromOnPause");
      localObject = new HashMap();
      ((Map)localObject).put("cameraId", Integer.valueOf(this.j));
      ((Map)localObject).put("errMsg", "stop on record");
      localObject = new JSONObject((Map)localObject).toString();
      new k().b(this.e).b((String)localObject).a();
    }
    Object localObject = this.C;
    if (localObject != null)
    {
      localObject = ((d)localObject).k();
      if (localObject != null) {
        this.B.setImageBitmap((Bitmap)localObject);
      }
    }
    localObject = this.a_;
    if (localObject != null) {
      ((c)localObject).b(this.C);
    }
    g();
  }
  
  public void g()
  {
    o.d("MicroMsg.AppBrandCameraView", "release");
    try
    {
      this.M = af.b();
      if (v()) {
        this.R.disable();
      }
      if (this.C != null)
      {
        this.C.l();
        removeView(this.C.a());
        this.G = -1;
        this.C.a(null);
        this.C.a(null);
        this.C.a(null);
        this.C = null;
      }
      if (this.B != null) {
        this.B.setImageBitmap(null);
      }
      if (this.Q != null) {
        this.Q.clear();
      }
      this.L = 0.0F;
      u();
      return;
    }
    finally {}
  }
  
  public int getCameraId()
  {
    return this.j;
  }
  
  public com.tencent.luggage.wxa.kp.c getOperateCallBack()
  {
    return this.z;
  }
  
  protected d getRecordView()
  {
    return this.C;
  }
  
  public View getView()
  {
    return this;
  }
  
  public void h()
  {
    a.a locala = this.h;
    if (locala != null) {
      locala.a();
    }
  }
  
  public void i()
  {
    this.G = 1;
  }
  
  public void j()
  {
    if (this.C == null)
    {
      o.d("MicroMsg.AppBrandCameraView", "recordView is null");
      return;
    }
    t();
    s();
  }
  
  public void k()
  {
    if (this.z == null) {
      return;
    }
    c localc = this.a_;
    if (localc == null) {
      return;
    }
    localc.a(this.C);
    this.a_ = null;
  }
  
  protected void l() {}
  
  public void m()
  {
    a.a locala = this.h;
    if (locala != null) {
      locala.b();
    }
  }
  
  public void n()
  {
    a.a locala = this.h;
    if (locala != null) {
      locala.c();
    }
  }
  
  public void setAppId(String paramString)
  {
    this.i = paramString;
  }
  
  public void setCameraId(int paramInt)
  {
    this.j = paramInt;
  }
  
  public void setCompressRecord(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }
  
  public void setDisplayScreenSize(Size paramSize) {}
  
  public void setFlash(String paramString)
  {
    if (af.b(this.l, paramString)) {
      return;
    }
    this.l = paramString;
  }
  
  public void setFrameLimitSize(int paramInt)
  {
    o.d("MicroMsg.AppBrandCameraView", "setFrameLimitSize:%d", new Object[] { Integer.valueOf(paramInt) });
    this.g = paramInt;
  }
  
  public void setMode(String paramString)
  {
    this.f = paramString;
  }
  
  public void setNeedOutput(boolean paramBoolean)
  {
    this.q = paramBoolean;
  }
  
  public void setOperateCallBack(com.tencent.luggage.wxa.kp.c paramc)
  {
    this.z = paramc;
  }
  
  public void setOutPutCallBack(com.tencent.luggage.wxa.kp.b paramb)
  {
    this.A = paramb;
  }
  
  public void setPage(com.tencent.luggage.wxa.jx.e parame)
  {
    this.e = parame;
  }
  
  public void setPageOrientation(boolean paramBoolean)
  {
    this.y = paramBoolean;
    o.d("MicroMsg.AppBrandCameraView", "setPageOrientation: %b", new Object[] { Boolean.valueOf(paramBoolean) });
  }
  
  public void setPreviewCenterCrop(boolean paramBoolean)
  {
    this.o = paramBoolean;
  }
  
  public void setQuality(String paramString)
  {
    if (af.b(this.m, paramString)) {
      return;
    }
    this.m = paramString;
  }
  
  public void setResolution(String paramString)
  {
    if (af.b(this.n, paramString)) {
      return;
    }
    o.d("MicroMsg.AppBrandCameraView", "setPreviewResolution: %s", new Object[] { paramString });
    this.n = paramString;
  }
  
  public void setScanFreq(int paramInt)
  {
    o.d("MicroMsg.AppBrandCameraView", "scanFreq:%d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt <= 0)
    {
      o.b("MicroMsg.AppBrandCameraView", "scanFreq is err");
      return;
    }
    this.x = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.be.a
 * JD-Core Version:    0.7.0.1
 */
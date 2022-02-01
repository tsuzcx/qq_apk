package com.tencent.map.sdk.a;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.Display;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.view.accessibility.AccessibilityManager;
import com.tencent.map.sdk.basemap.interfaces.IMapRenderView;
import com.tencent.map.sdk.engine.jni.JNI;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.opengles.GL10;
import org.json.JSONArray;

public abstract class pt
  implements mk, pu
{
  private if a;
  public lw aA;
  public float aB = 0.5F;
  public Handler aC = new Handler();
  public int aD = 0;
  protected IMapRenderView aE = null;
  public jg aF;
  public TencentMapOptions aG;
  public volatile boolean aH;
  public Context ay;
  public pm az;
  private lx b;
  
  public pt(IMapRenderView paramIMapRenderView, Context paramContext, TencentMapOptions paramTencentMapOptions)
  {
    this.aE = paramIMapRenderView;
    this.ay = paramContext;
    this.aG = paramTencentMapOptions;
    if (this.ay != null)
    {
      paramIMapRenderView = jh.a(this);
      if (paramIMapRenderView.a == 0) {
        paramIMapRenderView.a();
      }
      paramIMapRenderView.a += 1;
      this.aF = new jg();
      this.aF.a = System.currentTimeMillis();
      this.a = new if(this);
      if (this.aA == null) {
        this.aA = new lw(this.ay, this);
      }
      this.az = new pm(this.aA);
      paramIMapRenderView = this.a;
      paramContext = this.aA;
      paramIMapRenderView.b = paramContext;
      paramContext.E = this.aF;
      paramIMapRenderView = (WindowManager)this.ay.getSystemService("window");
      int i = paramIMapRenderView.getDefaultDisplay().getWidth();
      int j = paramIMapRenderView.getDefaultDisplay().getHeight();
      paramIMapRenderView = this.aA;
      if (paramIMapRenderView.i != null) {
        paramIMapRenderView.i.set(0, 0, i, j);
      }
      this.b = new lx(this.aA);
      this.b.start();
      paramIMapRenderView = this.az;
      if (paramIMapRenderView.b != null) {
        paramIMapRenderView.b.C = this;
      }
      this.aH = true;
    }
  }
  
  public static float b(float paramFloat)
  {
    int i = (int)paramFloat;
    paramFloat = (float)Math.pow(2.0D, paramFloat - i);
    return (1 << i - 3) * 3.051758E-005F * paramFloat;
  }
  
  public final void a(gr paramgr)
  {
    this.a.a(paramgr);
  }
  
  public void a(GL10 paramGL10, int paramInt1, int paramInt2)
  {
    paramGL10 = this.aA;
    if (paramGL10.a != null)
    {
      paramGL10.q = true;
      paramGL10.i.set(0, 0, paramInt1, paramInt2);
      paramGL10.a(0, 0, paramInt1, paramInt2, false);
      paramGL10 = paramGL10.c;
      Object localObject = paramGL10.k;
      if ((paramGL10.j != null) && (localObject != null))
      {
        paramGL10.k = ((Rect)localObject);
        if ((paramGL10.h instanceof lw))
        {
          lw locallw = (lw)paramGL10.h;
          if ((locallw.i != null) && (localObject != null))
          {
            locallw.A = ((Rect)localObject);
            paramInt1 = locallw.i.width();
            paramInt2 = locallw.i.height();
            locallw.a(((Rect)localObject).left, ((Rect)localObject).bottom, paramInt1 - ((Rect)localObject).right - ((Rect)localObject).left, paramInt2 - ((Rect)localObject).bottom - ((Rect)localObject).top, true);
          }
        }
        paramGL10.d();
      }
      paramGL10 = paramGL10.c.iterator();
      while (paramGL10.hasNext())
      {
        localObject = (mm)paramGL10.next();
        if (localObject != null) {
          try
          {
            ((mm)localObject).a();
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
        }
      }
    }
  }
  
  public void a(GL10 paramGL10, EGLConfig paramEGLConfig)
  {
    paramGL10 = this.aA;
    if ((paramGL10.a != null) && (paramGL10.b != null)) {
      paramGL10.b.a();
    }
  }
  
  public final void a(byte[] paramArrayOfByte)
  {
    lx locallx = this.b;
    if (locallx != null)
    {
      locallx.a();
      this.b.a(paramArrayOfByte);
    }
  }
  
  public boolean a(GL10 paramGL10)
  {
    return this.aA.a(paramGL10);
  }
  
  public final Context b()
  {
    return this.ay;
  }
  
  public final void b(gr paramgr)
  {
    if localif = this.a;
    synchronized (localif.a)
    {
      localif.a.b(paramgr);
      return;
    }
  }
  
  public final jg c()
  {
    return this.aF;
  }
  
  public final TencentMapOptions d()
  {
    return this.aG;
  }
  
  public final void e()
  {
    if (this.aH)
    {
      long l = System.currentTimeMillis();
      jg localjg = this.aF;
      if (localjg != null)
      {
        localjg.a(true);
        if (localjg.c.c > 0L) {
          localjg.c.b = (l - localjg.a);
        } else {
          localjg.c.c = (l - localjg.a);
        }
      }
      this.aH = false;
    }
  }
  
  public int getEGLContextHash()
  {
    Object localObject = (EGL10)EGLContext.getEGL();
    if (localObject != null)
    {
      localObject = ((EGL10)localObject).eglGetCurrentContext();
      if (localObject != null) {
        return localObject.hashCode();
      }
    }
    return 0;
  }
  
  public int getHeight()
  {
    IMapRenderView localIMapRenderView = this.aE;
    if (localIMapRenderView != null) {
      return localIMapRenderView.getHeight();
    }
    return 2147483647;
  }
  
  public lf getVectorMapDelegate()
  {
    return this;
  }
  
  public int getWidth()
  {
    IMapRenderView localIMapRenderView = this.aE;
    if (localIMapRenderView != null) {
      return localIMapRenderView.getWidth();
    }
    return 2147483647;
  }
  
  public void onDestroy()
  {
    oi.a();
    this.aF.b = (System.currentTimeMillis() - this.aF.a);
    jh localjh = jh.a(this);
    jg localjg = this.aF;
    localjh.a -= 1;
    if (localjg != null) {
      try
      {
        localjh.b.add(localjg);
      }
      finally {}
    }
    if (localjh.a == 0)
    {
      String str = localjh.a(localjh.b).toString();
      localjh.c.execute(new jh.2(localjh, str));
      try
      {
        localjh.b.clear();
        return;
      }
      finally {}
    }
  }
  
  public void onPause()
  {
    Object localObject1 = this.b;
    if (localObject1 != null) {
      ((lx)localObject1).a = true;
    }
    localObject1 = this.aA;
    if (((lw)localObject1).a != null)
    {
      ((lw)localObject1).q = false;
      ((lw)localObject1).x = false;
      if (((lw)localObject1).v != null) {
        ((lw)localObject1).v.d();
      }
      Object localObject5 = ((lw)localObject1).c;
      if (((kl)localObject5).a != null)
      {
        localObject5 = ((kl)localObject5).a;
        if (((kf)localObject5).a != null) {
          ((kf)localObject5).a.a();
        }
        ((kf)localObject5).c();
      }
      localObject5 = ((lw)localObject1).a;
      try
      {
        ((pf)localObject5).y();
        if (((pf)localObject5).b != 0L) {
          try
          {
            ((pf)localObject5).a.nativeHideStreetRoad(((pf)localObject5).b);
          }
          finally {}
        }
        ((pf)localObject5).z();
        if ((localObject2.k) && (localObject2.d != null))
        {
          Object localObject3 = localObject2.d;
          if (((jq)localObject3).b != null)
          {
            localObject3 = ((jq)localObject3).b;
            ((jp)localObject3).a = true;
            try {}finally {}
          }
        }
        return;
      }
      finally
      {
        localObject6.z();
      }
    }
  }
  
  public void onRedraw()
  {
    IMapRenderView localIMapRenderView = this.aE;
    if (localIMapRenderView != null) {
      localIMapRenderView.onRedraw();
    }
  }
  
  public void onResume()
  {
    Object localObject1 = this.b;
    if (localObject1 != null) {
      ((lx)localObject1).a();
    }
    localObject1 = this.aA;
    if (((lw)localObject1).a != null)
    {
      ((lw)localObject1).q = true;
      ((lw)localObject1).x = true;
      Object localObject3;
      if (((lw)localObject1).r)
      {
        localObject3 = ((lw)localObject1).c.a;
        if (((kf)localObject3).a != null) {
          ((kf)localObject3).a.destroy();
        }
        ((kf)localObject3).a = new kf.a((kf)localObject3, (byte)0);
        ((kf)localObject3).a.start();
        ((lw)localObject1).r = false;
      }
      else
      {
        localObject3 = ((lw)localObject1).c;
        if (((kl)localObject3).a != null)
        {
          localObject3 = ((kl)localObject3).a;
          if (((kf)localObject3).a != null) {
            ((kf)localObject3).a.b();
          }
        }
      }
      if ((((lw)localObject1).g != null) && (((lw)localObject1).g.get() != null)) {
        ((lf)((lw)localObject1).g.get()).onRedraw();
      }
      if (((lw)localObject1).j)
      {
        localObject3 = ((lw)localObject1).a;
        try
        {
          ((pf)localObject3).y();
          long l = ((pf)localObject3).b;
          if (l == 0L) {}
          for (;;)
          {
            ((pf)localObject3).z();
            break;
            ((pf)localObject3).f.a(new pf.13((pf)localObject3));
          }
          if (!localObject2.k) {
            break label254;
          }
        }
        finally
        {
          ((pf)localObject3).z();
        }
      }
      else if (localObject2.d != null)
      {
        localObject2.d.b();
      }
      label254:
      if (localObject2.v != null) {
        localObject2.v.c();
      }
    }
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void onSurfaceChanged(Object paramObject, int paramInt1, int paramInt2) {}
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if localif = this.a;
    if (localif != null) {
      return localif.onTouch(null, paramMotionEvent);
    }
    return false;
  }
  
  public final void r()
  {
    if (this.aA != null)
    {
      getEGLContextHash();
      this.aA.j();
    }
  }
  
  public final void s()
  {
    IMapRenderView localIMapRenderView = this.aE;
    if (localIMapRenderView != null) {
      localIMapRenderView.onRedraw();
    }
  }
  
  public void setZOrderMediaOverlay(boolean paramBoolean)
  {
    IMapRenderView localIMapRenderView = this.aE;
    if (localIMapRenderView != null) {
      localIMapRenderView.setZOrderMediaOverlay(paramBoolean);
    }
  }
  
  public final void t()
  {
    lw locallw = this.aA;
    if (locallw != null) {
      locallw.q = true;
    }
  }
  
  public final boolean u()
  {
    Object localObject = this.ay;
    if (localObject == null) {
      return false;
    }
    localObject = (AccessibilityManager)((Context)localObject).getSystemService("accessibility");
    boolean bool1 = ((AccessibilityManager)localObject).isEnabled();
    if (Build.VERSION.SDK_INT < 14) {
      return bool1;
    }
    boolean bool2 = ((AccessibilityManager)localObject).isTouchExplorationEnabled();
    return (bool1) && (bool2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.pt
 * JD-Core Version:    0.7.0.1
 */
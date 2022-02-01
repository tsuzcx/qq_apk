package com.tencent.luggage.wxa.bs;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.bm.e.b;
import com.tencent.luggage.wxa.jj.a.a;
import com.tencent.luggage.wxa.jx.m;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.magicbrush.MBRuntime;
import com.tencent.magicbrush.ui.i.h;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import com.tencent.mm.plugin.appbrand.page.ab;
import com.tencent.mm.plugin.appbrand.page.aj;
import com.tencent.mm.plugin.appbrand.page.am;
import com.tencent.mm.plugin.appbrand.page.aq;
import com.tencent.mm.plugin.appbrand.page.capsulebar.AppBrandCapsuleBarPlaceHolderView;
import com.tencent.mm.plugin.appbrand.page.u;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class h<PAGE extends com.tencent.luggage.wxa.dq.c>
  extends com.tencent.luggage.wxa.ds.a<PAGE>
  implements a.b, c, com.tencent.luggage.wxa.oi.h
{
  protected f a;
  protected a b;
  private com.tencent.magicbrush.ui.i c;
  private ab d;
  private Bitmap e;
  private Bitmap f;
  private ImageView g;
  private final aj h = new aj();
  private double i = 60.0D;
  private AtomicBoolean j = new AtomicBoolean(false);
  private final View.OnAttachStateChangeListener k = new h.1(this);
  
  public h(@NonNull PAGE paramPAGE)
  {
    super(paramPAGE);
    b();
    a(paramPAGE.i().a());
  }
  
  private Bitmap a(int paramInt)
  {
    com.tencent.magicbrush.ui.i locali = this.c;
    if (locali == null)
    {
      o.b("Luggage.Game.WAGamePageViewRenderer", "captureCanvas with [%d], view == null", new Object[] { Integer.valueOf(paramInt) });
      return null;
    }
    return locali.getMagicBrush().u().a(this.c.getVirtualElementId(), paramInt, false);
  }
  
  @SuppressLint({"ResourceType"})
  private void q()
  {
    boolean bool1 = ((com.tencent.luggage.wxa.dq.c)y()).f().i().b;
    boolean bool2 = ((com.tencent.luggage.wxa.dq.c)y()).f().i().b;
    if ((bool1) || (bool2))
    {
      com.tencent.luggage.wxa.bp.b localb = (com.tencent.luggage.wxa.bp.b)((com.tencent.luggage.wxa.dq.c)y()).i().d(com.tencent.luggage.wxa.bp.b.class);
      if (localb != null)
      {
        localb.a().a(new e.b().a((com.tencent.luggage.wxa.jx.h)y()).a(localb.r()).a(this.a).a(bool1).b(bool2).a(new h.5(this, localb)));
        return;
      }
      o.a("Luggage.Game.WAGamePageViewRenderer", new com.tencent.luggage.wxa.bp.c(), "hy: you're not on game service!", new Object[0]);
    }
  }
  
  private void r()
  {
    if ((y() != null) && (((com.tencent.luggage.wxa.dq.c)y()).i() != null) && (((com.tencent.luggage.wxa.dq.c)y()).i().d(com.tencent.luggage.wxa.bp.b.class) != null)) {
      ((com.tencent.luggage.wxa.bp.b)((com.tencent.luggage.wxa.dq.c)y()).i().d(com.tencent.luggage.wxa.bp.b.class)).a().a();
    }
  }
  
  private void s()
  {
    Object localObject = this.g;
    if (localObject != null)
    {
      if ((((ImageView)localObject).getDrawable() instanceof BitmapDrawable))
      {
        localObject = (BitmapDrawable)this.g.getDrawable();
        this.g.setImageDrawable(null);
        try
        {
          ((BitmapDrawable)localObject).getBitmap().recycle();
        }
        catch (Exception localException1)
        {
          o.a("Luggage.Game.WAGamePageViewRenderer", localException1, "hy: cleanupCoverScreenshot error!", new Object[0]);
        }
      }
      this.g.setVisibility(8);
    }
    Bitmap localBitmap = this.e;
    if (localBitmap != null)
    {
      try
      {
        localBitmap.recycle();
      }
      catch (Exception localException2)
      {
        o.a("Luggage.Game.WAGamePageViewRenderer", localException2, "hy: cleanupCoverScreenshot error!", new Object[0]);
      }
      this.e = null;
    }
  }
  
  private void t()
  {
    if (this.f != null)
    {
      try
      {
        o.d("Luggage.Game.WAGamePageViewRenderer", "hy: cleanupCanvasSecurityGuard");
        this.f.recycle();
      }
      catch (Exception localException)
      {
        o.a("Luggage.Game.WAGamePageViewRenderer", localException, "hy: cleanupCanvasSecurityGuard error!", new Object[0]);
      }
      this.f = null;
    }
  }
  
  public Bitmap a(int paramInt, boolean paramBoolean)
  {
    o.d("Luggage.Game.WAGamePageViewRenderer", "got message doGetCanvasBitmap");
    if (paramInt == -1)
    {
      o.b("Luggage.Game.WAGamePageViewRenderer", "got message doGetCanvasBitmap canvasId is illegal");
      return null;
    }
    o.d("Luggage.Game.WAGamePageViewRenderer", "got message doGetCanvasBitmap canvasId:%d,sync:%b", new Object[] { Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) });
    Bitmap localBitmap = a(paramInt);
    o.d("Luggage.Game.WAGamePageViewRenderer", "got message doGetCanvasBitmap end");
    return localBitmap;
  }
  
  @Nullable
  public View a(@NonNull LayoutInflater paramLayoutInflater)
  {
    paramLayoutInflater = new f(paramLayoutInflater.getContext());
    this.a = paramLayoutInflater;
    return paramLayoutInflater;
  }
  
  public RelativeLayout.LayoutParams a(@NonNull View paramView1, @Nullable View paramView2)
  {
    return new RelativeLayout.LayoutParams(-1, -1);
  }
  
  public com.tencent.magicbrush.ui.i a()
  {
    return this.c;
  }
  
  protected com.tencent.magicbrush.ui.i a(@NonNull Context paramContext)
  {
    return new com.tencent.magicbrush.ui.i(paramContext, i.h.a);
  }
  
  public <T> T a(Class<T> paramClass)
  {
    if (n.class.equals(paramClass)) {
      return paramClass.cast(((com.tencent.luggage.wxa.dq.c)y()).A());
    }
    if (paramClass.isInstance(this)) {
      return paramClass.cast(this);
    }
    return super.a(paramClass);
  }
  
  public void a(View paramView)
  {
    if (paramView.getVisibility() != 0) {
      return;
    }
    if (this.j.compareAndSet(false, true)) {
      ((com.tencent.luggage.wxa.dq.c)y()).f("onNativeWidgetViewAdded");
    }
  }
  
  protected void a(MBRuntime paramMBRuntime, List<com.tencent.luggage.wxa.bm.f> paramList)
  {
    if (paramMBRuntime == null)
    {
      o.b("Luggage.Game.WAGamePageViewRenderer", "hy: can not retrieve runtime!");
      return;
    }
    paramMBRuntime = paramMBRuntime.m();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(Math.round(this.i));
    paramList.add(new com.tencent.luggage.wxa.bm.f("MinFPS", localStringBuilder.toString()));
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(Math.round(paramMBRuntime.a));
    paramList.add(new com.tencent.luggage.wxa.bm.f("RT-FPS", localStringBuilder.toString()));
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(Math.round(paramMBRuntime.b));
    paramList.add(new com.tencent.luggage.wxa.bm.f("EX-FPS", localStringBuilder.toString()));
  }
  
  public void a(@NonNull com.tencent.mm.plugin.appbrand.widget.actionbar.b paramb)
  {
    paramb.setFullscreenMode(true);
    AppBrandCapsuleBarPlaceHolderView localAppBrandCapsuleBarPlaceHolderView = paramb.getCapsuleView();
    if ((localAppBrandCapsuleBarPlaceHolderView != null) && ((localAppBrandCapsuleBarPlaceHolderView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)))
    {
      ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)localAppBrandCapsuleBarPlaceHolderView.getLayoutParams();
      localMarginLayoutParams.rightMargin += paramb.getContext().getResources().getDimensionPixelSize(2131296771);
      localMarginLayoutParams.topMargin += paramb.getContext().getResources().getDimensionPixelSize(2131296772);
      localAppBrandCapsuleBarPlaceHolderView.requestLayout();
    }
  }
  
  public boolean a(String paramString)
  {
    return true;
  }
  
  public boolean a(String paramString1, String paramString2, int paramInt)
  {
    ((com.tencent.luggage.wxa.dq.c)y()).i().a(paramString1, paramString2, paramInt);
    return true;
  }
  
  public boolean a(String paramString1, String paramString2, int[] paramArrayOfInt)
  {
    if (paramString1.startsWith("onAppRoute")) {
      return true;
    }
    ((com.tencent.luggage.wxa.dq.c)y()).i().a(paramString1, paramString2);
    return true;
  }
  
  public am b(Context paramContext)
  {
    return this.h;
  }
  
  protected void b()
  {
    a(c.class, this);
  }
  
  public void b(@NonNull View paramView)
  {
    paramView = (com.tencent.luggage.wxa.bp.b)a(com.tencent.luggage.wxa.bp.b.class);
    if (paramView == null)
    {
      o.a("Luggage.Game.WAGamePageViewRenderer", new com.tencent.luggage.wxa.bp.c(), "hy: not on game service!", new Object[0]);
      return;
    }
    this.c = a(p());
    this.c.setId(2131428533);
    paramView = paramView.r();
    this.c.setMagicBrush(paramView);
    paramView.s().a(new h.2(this));
    this.a.addView(this.c, 0, new FrameLayout.LayoutParams(-1, -1));
    this.b = new a(p());
    this.b.setNativeWidgetAddedCallback(this);
    this.a.addView(this.b, -1, new ViewGroup.LayoutParams(-1, -1));
    this.d = new b(this.b);
    this.d.a(((com.tencent.luggage.wxa.dq.c)y()).af());
    this.d.a(new h.3(this));
    this.d.a(new h.4(this));
    q();
    this.g = new ImageView(p());
    this.g.setVisibility(8);
    this.a.addView(this.g, new FrameLayout.LayoutParams(-1, -1));
    this.a.addOnAttachStateChangeListener(this.k);
  }
  
  @NonNull
  public aq c()
  {
    return this.b;
  }
  
  @NonNull
  public ab d()
  {
    return this.d;
  }
  
  public void e()
  {
    super.e();
    super.a(com.tencent.luggage.wxa.oi.i.class, new com.tencent.luggage.wxa.bt.b((u)y()));
    super.a(com.tencent.luggage.wxa.oi.d.class, new g((u)y(), n().aj().f().a));
  }
  
  public void f()
  {
    super.f();
    s();
    t();
    this.c.getMagicBrush().b();
  }
  
  public void g()
  {
    super.g();
    this.c.getMagicBrush().c();
  }
  
  public void h()
  {
    super.h();
    s();
    t();
    r();
  }
  
  public boolean i()
  {
    return false;
  }
  
  public Map<String, m> j()
  {
    return Collections.emptyMap();
  }
  
  public void k() {}
  
  public void l() {}
  
  public com.tencent.luggage.wxa.ro.d<Bitmap> m()
  {
    return com.tencent.luggage.wxa.ro.h.a().a(new h.6(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bs.h
 * JD-Core Version:    0.7.0.1
 */
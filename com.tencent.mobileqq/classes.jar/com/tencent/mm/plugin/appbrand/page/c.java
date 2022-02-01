package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import com.tencent.luggage.wxa.iu.b;
import com.tencent.luggage.wxa.jx.f;
import com.tencent.luggage.wxa.jx.f.a;
import com.tencent.luggage.wxa.jx.f.b;
import com.tencent.luggage.wxa.jx.f.c;
import com.tencent.luggage.wxa.jx.f.d;
import com.tencent.luggage.wxa.jx.f.e;
import com.tencent.luggage.wxa.jx.f.g;
import com.tencent.luggage.wxa.jx.g;
import com.tencent.luggage.wxa.qz.t;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/page/AppBrandComponentViewWxa;", "Lcom/tencent/mm/plugin/appbrand/AppBrandComponentWxaShared;", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore;", "()V", "addOnBackPressedListener", "", "p0", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnBackPressedListener;", "kotlin.jvm.PlatformType", "addOnBackgroundListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnBackgroundListener;", "addOnDestroyListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnDestroyListener;", "addOnForegroundListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnForegroundListener;", "addOnInteractiveListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnInteractiveListener;", "addOnNonInteractiveListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnNonInteractiveListener;", "addOnReadyListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnReadyListener;", "addOnWillDisappearListener", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponentViewLifecycleStore$OnWillDisappearListener;", "callInteractiveStateChanged", "", "callOnBackPressed", "callOnViewWillDisappear", "callPageOnBackground", "callPageOnDestroy", "callPageOnForeground", "callPageOnReady", "getContentView", "Landroid/view/View;", "hide", "post", "block", "Lkotlin/Function0;", "runnable", "Ljava/lang/Runnable;", "postDelayed", "delayMillis", "", "removeAllLifecycleListeners", "removeCallbacks", "removeOnBackPressedListener", "removeOnBackgroundListener", "removeOnDestroyListener", "removeOnForegroundListener", "removeOnInteractiveListener", "removeOnNonInteractiveListener", "removeOnReadyListener", "removeOnWillDisappearListener", "runOnUiThread", "show", "luggage-wxa-app_release"}, k=1, mv={1, 1, 16})
public abstract class c
  extends b
  implements f
{
  public boolean B()
  {
    return this.b.e();
  }
  
  public void F()
  {
    this.b.a();
  }
  
  public void G()
  {
    this.b.f();
  }
  
  public void I()
  {
    this.b.c();
  }
  
  public void J()
  {
    this.b.d();
  }
  
  public void P()
  {
    this.b.b();
  }
  
  public void Q()
  {
    this.b.g();
  }
  
  public void a(f.a parama)
  {
    this.b.a(parama);
  }
  
  public void a(f.b paramb)
  {
    this.b.a(paramb);
  }
  
  public void a(f.c paramc)
  {
    this.b.a(paramc);
  }
  
  public void a(f.d paramd)
  {
    this.b.a(paramd);
  }
  
  public void a(f.e parame)
  {
    this.b.a(parame);
  }
  
  public void a(f.g paramg)
  {
    this.b.a(paramg);
  }
  
  public void a(@Nullable Runnable paramRunnable, long paramLong)
  {
    if (paramRunnable != null)
    {
      View localView = getContentView();
      if (localView != null) {
        localView.postDelayed(paramRunnable, paramLong);
      }
    }
  }
  
  public void b(f.b paramb)
  {
    this.b.b(paramb);
  }
  
  public void b(f.c paramc)
  {
    this.b.b(paramc);
  }
  
  public void b(f.d paramd)
  {
    this.b.b(paramd);
  }
  
  public void b(f.e parame)
  {
    this.b.b(parame);
  }
  
  public void b(f.g paramg)
  {
    this.b.b(paramg);
  }
  
  public void b(@Nullable Runnable paramRunnable)
  {
    if (paramRunnable != null)
    {
      View localView = getContentView();
      if (localView != null) {
        localView.post(paramRunnable);
      }
    }
  }
  
  public void c(@Nullable Runnable paramRunnable)
  {
    if (paramRunnable != null)
    {
      View localView = getContentView();
      if (localView != null) {
        localView.removeCallbacks(paramRunnable);
      }
    }
  }
  
  public final void d(@Nullable Runnable paramRunnable)
  {
    if (paramRunnable != null)
    {
      if (t.a())
      {
        paramRunnable.run();
        return;
      }
      b(paramRunnable);
    }
  }
  
  public void d(boolean paramBoolean)
  {
    this.b.a(paramBoolean);
  }
  
  @Nullable
  public abstract View getContentView();
  
  protected final void w()
  {
    View localView = getContentView();
    if (localView != null) {
      localView.setVisibility(0);
    }
  }
  
  protected final void x()
  {
    View localView = getContentView();
    if (localView != null) {
      localView.setVisibility(4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.c
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.luggage.wxa.or;

import android.app.Activity;
import android.app.PictureInPictureParams.Builder;
import android.content.res.Configuration;
import android.os.Build.VERSION;
import android.util.Rational;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.luggage.wxa.oq.e.a;
import com.tencent.luggage.wxa.oq.e.b;
import com.tencent.luggage.wxa.qz.o;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/platform/window/activity/ActivityWindowOrientationHandlerProxyImpl;", "Lcom/tencent/mm/plugin/appbrand/platform/window/activity/ActivityWindowOrientationHandler;", "windowActivity", "Lcom/tencent/mm/plugin/appbrand/platform/window/activity/WindowAndroidActivityImpl;", "(Lcom/tencent/mm/plugin/appbrand/platform/window/activity/WindowAndroidActivityImpl;)V", "activity", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", "handler", "getHandler", "()Lcom/tencent/mm/plugin/appbrand/platform/window/activity/ActivityWindowOrientationHandler;", "handler$delegate", "Lkotlin/Lazy;", "getCurrentOrientation", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler$Orientation;", "hasExecutingOrPendingRequests", "", "onConfigurationChanged", "", "newConfig", "Landroid/content/res/Configuration;", "onPause", "onResume", "release", "requestDeviceOrientation", "reqOrientation", "listener", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler$OnOrientationChangedListener;", "Companion", "luggage-wxa-app_release"}, k=1, mv={1, 1, 16})
public final class c
  implements b
{
  @Deprecated
  public static final c.a a = new c.a(null);
  private final Lazy b;
  @Nullable
  private final Activity c;
  private final n d;
  
  public c(@NotNull n paramn)
  {
    this.d = paramn;
    this.b = LazyKt.lazy((Function0)new c.b(this));
    this.c = this.d.u();
  }
  
  private final b g()
  {
    return (b)this.b.getValue();
  }
  
  @Nullable
  public e.b a()
  {
    if (this.c != null) {
      return g().a();
    }
    Object localObject = this.d.t();
    e.b localb = null;
    if (localObject != null)
    {
      localObject = ((WindowManager)localObject).getDefaultDisplay();
      if (localObject != null)
      {
        localObject = Integer.valueOf(((Display)localObject).getRotation());
        break label55;
      }
    }
    localObject = null;
    label55:
    if (((localObject != null) && (((Integer)localObject).intValue() == 0)) || ((localObject != null) && (((Integer)localObject).intValue() == 2))) {
      return e.b.a;
    }
    if ((localObject != null) && (((Integer)localObject).intValue() == 1)) {
      return e.b.e;
    }
    if (localObject == null) {
      return null;
    }
    if (((Integer)localObject).intValue() == 3) {
      localb = e.b.f;
    }
    return localb;
  }
  
  public void a(@Nullable Configuration paramConfiguration)
  {
    g().a(paramConfiguration);
  }
  
  public void a(@Nullable e.b paramb, @Nullable e.a parama)
  {
    Object localObject1 = this.c;
    if (localObject1 == null)
    {
      ((Function0)new c.c(this, parama)).invoke();
      return;
    }
    if ((!((Activity)localObject1).isFinishing()) && (!this.c.isDestroyed()))
    {
      int i = Build.VERSION.SDK_INT;
      Object localObject2 = null;
      localObject1 = null;
      if ((i >= 26) && (this.c.isInPictureInPictureMode()))
      {
        localObject2 = this.d;
        if (paramb != null) {
          localObject1 = paramb.name();
        }
        ((n)localObject2).setSoftOrientation((String)localObject1);
        if (paramb == null)
        {
          if (parama != null) {
            parama.a(g().a(), false);
          }
        }
        else if (d.a[paramb.ordinal()] != 1)
        {
          this.c.enterPictureInPictureMode(new PictureInPictureParams.Builder().setAspectRatio(new Rational(16, 9)).build());
          if (parama != null) {
            parama.a(paramb, true);
          }
        }
        else
        {
          this.c.enterPictureInPictureMode(new PictureInPictureParams.Builder().setAspectRatio(new Rational(9, 16)).build());
          if (parama != null) {
            parama.a(paramb, true);
          }
        }
        return;
      }
      localObject1 = this.c.getWindow();
      if (localObject1 != null) {
        localObject1 = ((Window)localObject1).getDecorView();
      } else {
        localObject1 = null;
      }
      if (localObject1 != null)
      {
        Object localObject3 = ((View)localObject1).getViewTreeObserver();
        if ((localObject3 != null) && (((ViewTreeObserver)localObject3).isAlive() == true))
        {
          localObject3 = new AtomicBoolean(true);
          n localn = this.d;
          if (paramb != null) {
            localObject2 = paramb.name();
          }
          localn.setSoftOrientation((String)localObject2);
          g().a(paramb, (e.a)new c.d(this, parama, (AtomicBoolean)localObject3, (View)localObject1));
          ((AtomicBoolean)localObject3).set(false);
          return;
        }
      }
      g().a(paramb, parama);
      return;
    }
    paramb = new StringBuilder();
    paramb.append("requestDeviceOrientation but activity(");
    paramb.append(this.c);
    paramb.append(") destroyed");
    o.b("Luggage.WXA.ActivityWindowOrientationHandlerProxyImpl", paramb.toString());
    if (parama != null) {
      parama.a(g().a(), false);
    }
  }
  
  public void b()
  {
    g().b();
  }
  
  public void c()
  {
    g().c();
  }
  
  public void d()
  {
    Activity localActivity = this.c;
    if ((localActivity == null) || (localActivity.isDestroyed()) || (this.c.isFinishing())) {
      g().d();
    }
    if (Intrinsics.areEqual(this.d.a, (c)this)) {
      this.d.a = ((b)null);
    }
  }
  
  @Nullable
  public final Activity e()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.or.c
 * JD-Core Version:    0.7.0.1
 */
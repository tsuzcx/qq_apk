package com.tencent.luggage.wxa.os;

import android.content.res.Configuration;
import android.util.DisplayMetrics;
import com.tencent.luggage.wxa.oq.c;
import com.tencent.luggage.wxa.oq.e.a;
import com.tencent.luggage.wxa.oq.e.b;
import com.tencent.luggage.wxa.or.b;
import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/platform/window/view/center_inside/CenterInsideWindowOrientationHandler;", "Lcom/tencent/mm/plugin/appbrand/platform/window/activity/ActivityWindowOrientationHandler;", "window", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;", "(Lcom/tencent/mm/plugin/appbrand/platform/window/WindowAndroid;)V", "getCurrentOrientation", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler$Orientation;", "hasExecutingOrPendingRequests", "", "onConfigurationChanged", "", "newConfig", "Landroid/content/res/Configuration;", "onPause", "onResume", "release", "requestDeviceOrientation", "reqOrientation", "listener", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler$OnOrientationChangedListener;", "Companion", "luggage-wxa-app_release"}, k=1, mv={1, 1, 16})
public final class a
  implements b
{
  @Deprecated
  public static final a.a a = new a.a(null);
  private static final e.b[] c = e.b.h;
  private final c b;
  
  public a(@NotNull c paramc)
  {
    this.b = paramc;
  }
  
  @NotNull
  public e.b a()
  {
    DisplayMetrics localDisplayMetrics = this.b.getVDisplayMetrics();
    if (localDisplayMetrics.heightPixels >= localDisplayMetrics.widthPixels)
    {
      o.d("MicroMsg.CenterInsideWindowOrientationHandler", "getCurrentOrientation: portrait");
      return e.b.a;
    }
    o.d("MicroMsg.CenterInsideWindowOrientationHandler", "getCurrentOrientation: landscape");
    return e.b.c;
  }
  
  public void a(@Nullable Configuration paramConfiguration) {}
  
  public void a(@Nullable e.b paramb, @Nullable e.a parama)
  {
    if (paramb != null)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("requestDeviceOrientation: ");
      ((StringBuilder)localObject).append(paramb.g);
      ((StringBuilder)localObject).append(',');
      ((StringBuilder)localObject).append(paramb.name());
      o.d("MicroMsg.CenterInsideWindowOrientationHandler", ((StringBuilder)localObject).toString());
      localObject = e.b.a;
      boolean bool2 = false;
      boolean bool1 = false;
      if (paramb == localObject)
      {
        this.b.setSoftOrientation("portrait");
        if (parama != null)
        {
          localObject = a();
          if (a() == paramb) {
            bool1 = true;
          }
          parama.a((e.b)localObject, bool1);
        }
      }
      else
      {
        localObject = c;
        Intrinsics.checkExpressionValueIsNotNull(localObject, "LANDSCAPE_ENUMS");
        if (ArraysKt.contains((Object[])localObject, paramb))
        {
          this.b.setSoftOrientation("landscape");
          if (parama != null)
          {
            paramb = a();
            localObject = c;
            Intrinsics.checkExpressionValueIsNotNull(localObject, "LANDSCAPE_ENUMS");
            parama.a(paramb, ArraysKt.contains((Object[])localObject, a()));
          }
        }
        else if (paramb == e.b.b)
        {
          this.b.setSoftOrientation("auto");
          if (parama != null) {
            parama.a(a(), true);
          }
        }
        else
        {
          this.b.setSoftOrientation("portrait");
          if (parama != null)
          {
            localObject = a();
            bool1 = bool2;
            if (a() == paramb) {
              bool1 = true;
            }
            parama.a((e.b)localObject, bool1);
          }
        }
      }
      return;
    }
    ((Function0)new a.b(parama)).invoke();
  }
  
  public void b() {}
  
  public void c() {}
  
  public void d() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.os.a
 * JD-Core Version:    0.7.0.1
 */
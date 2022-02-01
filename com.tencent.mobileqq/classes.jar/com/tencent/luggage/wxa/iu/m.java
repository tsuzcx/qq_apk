package com.tencent.luggage.wxa.iu;

import android.view.View;
import com.tencent.luggage.wxa.oq.e;
import com.tencent.luggage.wxa.oq.e.a;
import com.tencent.luggage.wxa.oq.e.b;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/DefaultWindowOrientationHandlerViewImpl;", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler;", "mView", "Landroid/view/View;", "(Landroid/view/View;)V", "LANDSCAPE_ENUMS", "", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler$Orientation;", "[Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler$Orientation;", "getCurrentOrientation", "hasExecutingOrPendingRequests", "", "requestDeviceOrientation", "", "reqOrientation", "listener", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler$OnOrientationChangedListener;", "luggage-wxa-app_release"}, k=1, mv={1, 1, 16})
public class m
  implements e
{
  private final e.b[] a;
  private final View b;
  
  public m(@NotNull View paramView)
  {
    this.b = paramView;
    this.a = new e.b[] { e.b.c, e.b.d, e.b.e, e.b.f };
  }
  
  @NotNull
  public e.b a()
  {
    if (this.b.getHeight() >= this.b.getWidth()) {
      return e.b.a;
    }
    return e.b.d;
  }
  
  public void a(@Nullable e.b paramb, @Nullable e.a parama)
  {
    if (paramb != null)
    {
      if (paramb == e.b.a)
      {
        if (parama != null)
        {
          e.b localb = a();
          boolean bool;
          if (a() == paramb) {
            bool = true;
          } else {
            bool = false;
          }
          parama.a(localb, bool);
        }
      }
      else if ((ArraysKt.contains(this.a, paramb)) && (parama != null)) {
        parama.a(a(), ArraysKt.contains(this.a, a()));
      }
      return;
    }
    ((Function0)new m.a(parama)).invoke();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.iu.m
 * JD-Core Version:    0.7.0.1
 */
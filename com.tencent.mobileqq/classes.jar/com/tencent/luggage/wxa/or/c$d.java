package com.tencent.luggage.wxa.or;

import android.view.View;
import com.tencent.luggage.wxa.oq.e.a;
import com.tencent.luggage.wxa.oq.e.b;
import com.tencent.luggage.wxa.qz.o;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "orientation", "Lcom/tencent/mm/plugin/appbrand/platform/window/WindowOrientationHandler$Orientation;", "success", "", "onOrientationChanged"}, k=3, mv={1, 1, 16})
final class c$d
  implements e.a
{
  c$d(c paramc, e.a parama, AtomicBoolean paramAtomicBoolean, View paramView) {}
  
  public final void a(@Nullable e.b paramb, boolean paramBoolean)
  {
    c.f();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("requestDeviceOrientation, callback from AppBrandDeviceOrientationHandler, orientation:");
    localStringBuilder.append(paramb);
    localStringBuilder.append(", success:");
    localStringBuilder.append(paramBoolean);
    o.d("Luggage.WXA.ActivityWindowOrientationHandlerProxyImpl", localStringBuilder.toString());
    paramb = new c.d.a(this, paramb, paramBoolean);
    if ((paramBoolean) && (!this.c.get()))
    {
      e.a(this.d, 2, (Function0)new c.d.1(paramb));
      this.d.postDelayed((Runnable)new c.d.2(paramb), 100L);
      return;
    }
    paramb.a("syncReturn");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.or.c.d
 * JD-Core Version:    0.7.0.1
 */
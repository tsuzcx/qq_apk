package com.tencent.luggage.wxa.ng;

import android.view.KeyEvent;
import com.tencent.luggage.wxa.iu.p;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/SelectDevicesBottomSheet$backKeyEventObserver$1", "Lcom/tencent/mm/plugin/appbrand/KeyEventObserver;", "onChange", "", "event", "Landroid/view/KeyEvent;", "luggage-xweb-ext_release"}, k=1, mv={1, 1, 16})
public final class g$c
  extends p
{
  public boolean a(@NotNull KeyEvent paramKeyEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramKeyEvent, "event");
    if (1 == paramKeyEvent.getAction()) {
      return false;
    }
    paramKeyEvent = g.c(this.a);
    if (paramKeyEvent != null) {
      paramKeyEvent = (Unit)paramKeyEvent.invoke(null, Integer.valueOf(0));
    }
    this.a.f();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ng.g.c
 * JD-Core Version:    0.7.0.1
 */
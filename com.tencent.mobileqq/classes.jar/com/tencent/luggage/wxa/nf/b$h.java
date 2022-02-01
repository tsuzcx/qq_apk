package com.tencent.luggage.wxa.nf;

import android.view.KeyEvent;
import com.tencent.luggage.wxa.iu.p;
import com.tencent.luggage.wxa.ng.h;
import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/AppBrandVideoCastHandler$volumeDownKeyObserver$1", "Lcom/tencent/mm/plugin/appbrand/KeyEventObserver;", "onChange", "", "event", "Landroid/view/KeyEvent;", "luggage-xweb-ext_release"}, k=1, mv={1, 1, 16})
public final class b$h
  extends p
{
  public boolean a(@NotNull KeyEvent paramKeyEvent)
  {
    Intrinsics.checkParameterIsNotNull(paramKeyEvent, "event");
    o.d("MicroMsg.VideoCast.AppBrandVideoCastHandler", "volume down");
    b.a(this.a).c((Function1)new b.h.a(this));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nf.b.h
 * JD-Core Version:    0.7.0.1
 */
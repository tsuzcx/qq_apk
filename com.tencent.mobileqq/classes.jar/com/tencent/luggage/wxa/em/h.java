package com.tencent.luggage.wxa.em;

import com.tencent.luggage.wxa.eo.a;
import com.tencent.luggage.wxa.ot.g;
import com.tencent.xweb.WebView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/standalone_ext/XWebHitReporter;", "", "()V", "reportHit", "", "rt", "Lcom/tencent/luggage/standalone_ext/Runtime;", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class h
{
  public static final h a = new h();
  
  public final void a(@NotNull d paramd)
  {
    Intrinsics.checkParameterIsNotNull(paramd, "rt");
    g localg = g.a;
    int i = 2;
    paramd = paramd.G();
    Intrinsics.checkExpressionValueIsNotNull(paramd, "rt.initConfig");
    paramd = paramd.i();
    if (!WebView.isSys()) {
      if (WebView.isXWalk()) {
        i = 1;
      } else {
        i = 0;
      }
    }
    localg.a(10083, new Object[] { paramd, Integer.valueOf(i) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.em.h
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.luggage.wxa.standalone_open_runtime.ui.menu.devtools;

import android.content.Context;
import android.webkit.ValueCallback;
import com.tencent.luggage.wxa.hz.a;
import com.tencent.luggage.wxa.qz.t;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "s", "", "kotlin.jvm.PlatformType", "onReceiveValue"}, k=3, mv={1, 1, 16})
final class SecondaryMenuDelegate_GameCpuProfiler$c<T>
  implements ValueCallback<String>
{
  SecondaryMenuDelegate_GameCpuProfiler$c(SecondaryMenuDelegate_GameCpuProfiler paramSecondaryMenuDelegate_GameCpuProfiler, String paramString, Context paramContext) {}
  
  public final void a(String paramString)
  {
    SecondaryMenuDelegate_GameCpuProfiler localSecondaryMenuDelegate_GameCpuProfiler = this.a;
    String str = this.b;
    Intrinsics.checkExpressionValueIsNotNull(paramString, "s");
    if (SecondaryMenuDelegate_GameCpuProfiler.a(localSecondaryMenuDelegate_GameCpuProfiler, str, paramString))
    {
      paramString = new StringBuilder();
      paramString.append(a.d());
      paramString.append("appbrand/trace/");
      paramString.append(this.b);
      t.a((Runnable)new SecondaryMenuDelegate_GameCpuProfiler.c.1(this, paramString.toString()));
      SecondaryMenuDelegate_GameCpuProfiler.a(this.a, false);
      return;
    }
    t.a((Runnable)new SecondaryMenuDelegate_GameCpuProfiler.c.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.standalone_open_runtime.ui.menu.devtools.SecondaryMenuDelegate_GameCpuProfiler.c
 * JD-Core Version:    0.7.0.1
 */
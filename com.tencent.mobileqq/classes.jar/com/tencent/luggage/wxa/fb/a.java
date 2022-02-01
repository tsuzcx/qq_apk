package com.tencent.luggage.wxa.fb;

import com.tencent.luggage.wxa.nk.b;
import com.tencent.luggage.wxa.nk.d;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.w;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxa/launch/WxaKeyStepLogger;", "Lcom/tencent/mm/plugin/appbrand/keylogger/base/IKeyStepListener;", "()V", "RUNNING_INSTANCE", "Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;", "kotlin.jvm.PlatformType", "TAG", "", "hasBootingInstance", "", "sessionId", "onProcessEnd", "", "onProcessStart", "onStepFail", "step", "Lcom/tencent/mm/plugin/appbrand/keylogger/base/IKeyStep;", "cost", "", "onStepOK", "onStepStart", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class a
  implements d
{
  public static final a a = new a();
  private static final w b = w.a("WxaKeyStepLogger.RUNNING_INSTANCE");
  
  public void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "sessionId");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onProcessStart id:");
    localStringBuilder.append(paramString);
    o.d("WxaKeyStepLogger", localStringBuilder.toString());
    b.putLong(paramString, af.b());
  }
  
  public void a(@NotNull String paramString, @Nullable b paramb)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "sessionId");
    if (b.e(paramString))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onStepStart id:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", step:");
      if (paramb != null) {
        paramString = paramb.b();
      } else {
        paramString = null;
      }
      localStringBuilder.append(paramString);
      o.d("WxaKeyStepLogger", localStringBuilder.toString());
    }
  }
  
  public void a(@NotNull String paramString, @Nullable b paramb, long paramLong)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "sessionId");
    if (b.e(paramString))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onStepOK id:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" step:");
      if (paramb != null) {
        paramString = paramb.b();
      } else {
        paramString = null;
      }
      localStringBuilder.append(paramString);
      localStringBuilder.append(" cost:");
      localStringBuilder.append(paramLong);
      o.d("WxaKeyStepLogger", localStringBuilder.toString());
    }
  }
  
  public void b(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "sessionId");
    long l = b.a(paramString, 9223372036854775807L);
    b.f(paramString);
    if (l < 9223372036854775807L)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onProcessEnd id:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", cost:");
      localStringBuilder.append(af.b() - l);
      o.d("WxaKeyStepLogger", localStringBuilder.toString());
    }
  }
  
  public final boolean c(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "sessionId");
    return b.e(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fb.a
 * JD-Core Version:    0.7.0.1
 */
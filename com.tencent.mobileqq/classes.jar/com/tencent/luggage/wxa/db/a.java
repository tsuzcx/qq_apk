package com.tencent.luggage.wxa.db;

import com.tencent.luggage.wxa.ew.b;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/launch/utils/WxaLaunchParameters;", "", "()V", "toLaunchParcel", "Lcom/tencent/mm/plugin/appbrand/launching/params/LaunchParcel;", "Lcom/tencent/luggage/struct/LaunchContainerAction;", "luggage-standalone-mode-ext_release"}, k=1, mv={1, 1, 16})
public final class a
{
  public static final a a = new a();
  
  @JvmStatic
  @NotNull
  public static final com.tencent.luggage.wxa.nn.a a(@NotNull b paramb)
  {
    Intrinsics.checkParameterIsNotNull(paramb, "$this$toLaunchParcel");
    com.tencent.luggage.wxa.nn.a locala = new com.tencent.luggage.wxa.nn.a();
    locala.b = paramb.a;
    locala.e = paramb.d;
    if (paramb.j <= 0L)
    {
      locala.i = System.currentTimeMillis();
      locala.j = System.nanoTime();
    }
    else
    {
      locala.i = TimeUnit.NANOSECONDS.toMillis(paramb.j);
      locala.j = paramb.j;
    }
    locala.d = paramb.e;
    locala.k = paramb.o;
    return locala;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.db.a
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.luggage.wxa.ng;

import com.tencent.luggage.wxa.jm.b;
import com.tencent.luggage.wxa.qz.o;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mm/plugin/appbrand/jsapi/xwebplugin/video/cast/VideoCastDeviceManager$tryInit$1", "Lcom/tencent/mm/plugin/appbrand/dlna/IDlnaLogger;", "e", "", "tag", "", "msg", "i", "printErrStackTrace", "tr", "", "format", "luggage-xweb-ext_release"}, k=1, mv={1, 1, 16})
public final class j$h
  implements b
{
  public void a(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "tag");
    Intrinsics.checkParameterIsNotNull(paramString2, "msg");
    o.d(paramString1, paramString2);
  }
  
  public void a(@NotNull String paramString1, @NotNull Throwable paramThrowable, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "tag");
    Intrinsics.checkParameterIsNotNull(paramThrowable, "tr");
    Intrinsics.checkParameterIsNotNull(paramString2, "format");
    o.a(paramString1, paramThrowable, paramString2, new Object[0]);
  }
  
  public void b(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "tag");
    Intrinsics.checkParameterIsNotNull(paramString2, "msg");
    o.b(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ng.j.h
 * JD-Core Version:    0.7.0.1
 */
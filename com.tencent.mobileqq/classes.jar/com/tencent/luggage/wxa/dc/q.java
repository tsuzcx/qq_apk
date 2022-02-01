package com.tencent.luggage.wxa.dc;

import com.tencent.luggage.wxa.ob.c;
import com.tencent.luggage.wxa.ob.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/login/WxaRuntimeCgiInterceptors;", "", "()V", "interceptors", "", "Lcom/tencent/mm/plugin/appbrand/networking/ICgiServiceInterceptor;", "collectInterceptors", "installInterceptor", "", "interceptor", "setAppAuthorizeInfo", "appId", "", "appName", "appIconUrl", "luggage-standalone-addon-loginsession_release"}, k=1, mv={1, 1, 16})
public final class q
{
  public static final q a = new q();
  private static final List<c> b = (List)new ArrayList();
  
  @JvmStatic
  @NotNull
  public static final List<c> a()
  {
    synchronized (b)
    {
      List localList2 = b;
      return localList2;
    }
  }
  
  @JvmStatic
  public static final void a(@NotNull String paramString1, @Nullable String paramString2, @Nullable String paramString3)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "appId");
    synchronized (b)
    {
      Iterator localIterator = b.iterator();
      while (localIterator.hasNext())
      {
        c localc = (c)localIterator.next();
        Object localObject = localc;
        if (!(localc instanceof d)) {
          localObject = null;
        }
        localObject = (d)localObject;
        if (localObject != null) {
          ((d)localObject).a(paramString1, paramString2, paramString3);
        }
      }
      paramString1 = Unit.INSTANCE;
      return;
    }
    for (;;)
    {
      throw paramString1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.dc.q
 * JD-Core Version:    0.7.0.1
 */
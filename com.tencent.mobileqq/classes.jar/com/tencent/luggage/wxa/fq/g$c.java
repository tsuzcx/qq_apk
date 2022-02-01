package com.tencent.luggage.wxa.fq;

import com.tencent.ilink.tdi.b.z;
import com.tencent.ilinkservice.aq;
import com.tencent.luggage.wxa.dc.m;
import com.tencent.luggage.wxa.dc.m.a;
import com.tencent.luggage.wxa.fv.a;
import com.tencent.luggage.wxa.fv.e;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxaapi/internal/WxaApiImpl$Global;", "", "()V", "SDK_VERSION_INT", "", "SDK_VERSION_STR", "", "getSDK_VERSION_STR", "()Ljava/lang/String;", "value", "hostAppID", "getHostAppID", "setHostAppID", "(Ljava/lang/String;)V", "", "iLinkUIN", "getILinkUIN", "()J", "setILinkUIN", "(J)V", "wxaAPI", "Lcom/tencent/luggage/wxaapi/internal/WxaApiImpl;", "getWxaAPI", "()Lcom/tencent/luggage/wxaapi/internal/WxaApiImpl;", "setWxaAPI", "(Lcom/tencent/luggage/wxaapi/internal/WxaApiImpl;)V", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class g$c
{
  public static final c a = new c();
  @NotNull
  private static String b = "";
  private static long c;
  @Nullable
  private static g d;
  
  static
  {
    com.tencent.luggage.wxa.qz.c.e = 553976065;
    com.tencent.luggage.wxa.qz.c.f = 3;
    com.tencent.luggage.wxa.qz.c.g = true;
    com.tencent.luggage.wxa.qz.c.h = false;
  }
  
  @NotNull
  public final String a()
  {
    return b;
  }
  
  public final void a(long paramLong)
  {
    c = paramLong;
    if (r.h())
    {
      g.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setILinkUIN by setter, uin=");
      localStringBuilder.append(m.a.b(paramLong));
      o.d("Luggage.WxaApiImpl", localStringBuilder.toString());
      e.a.a(paramLong);
    }
  }
  
  public final void a(@Nullable g paramg)
  {
    d = paramg;
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "value");
    g.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("set hostAppID ");
    localStringBuilder.append(b);
    localStringBuilder.append(" -> ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(']');
    o.d("Luggage.WxaApiImpl", localStringBuilder.toString());
    b = paramString;
  }
  
  public final long b()
  {
    if (c == 0L)
    {
      Object localObject;
      if (r.h())
      {
        try
        {
          aq localaq = a.c.f();
        }
        catch (Exception localException)
        {
          g.a();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getILinkUIN, get tdiSession, exception=");
          localStringBuilder.append(localException);
          o.b("Luggage.WxaApiImpl", localStringBuilder.toString());
          localObject = null;
        }
        if (localObject != null)
        {
          localObject = ((aq)localObject).b();
          Intrinsics.checkExpressionValueIsNotNull(localObject, "tdiSession.userInfo");
          c = ((b.z)localObject).g();
          if (0L == c)
          {
            c = e.a.a();
            g.a();
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("getILinkUIN by mmkv, uin=");
            ((StringBuilder)localObject).append(m.a.b(c));
            o.d("Luggage.WxaApiImpl", ((StringBuilder)localObject).toString());
          }
          else
          {
            g.a();
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("getILinkUIN by active tdiSession, uin=");
            ((StringBuilder)localObject).append(m.a.b(c));
            o.d("Luggage.WxaApiImpl", ((StringBuilder)localObject).toString());
            e.a.a(c);
          }
        }
      }
      else
      {
        c = e.a.a();
        g.a();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getILinkUIN by mmkv, uin=");
        ((StringBuilder)localObject).append(m.a.b(c));
        o.d("Luggage.WxaApiImpl", ((StringBuilder)localObject).toString());
      }
    }
    return c;
  }
  
  @NotNull
  public final String c()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("1.5.1");
    String str;
    if (f.a()) {
      str = " #1221";
    } else {
      str = "";
    }
    localStringBuilder.append(str);
    return localStringBuilder.toString();
  }
  
  @Nullable
  public final g d()
  {
    return d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fq.g.c
 * JD-Core Version:    0.7.0.1
 */
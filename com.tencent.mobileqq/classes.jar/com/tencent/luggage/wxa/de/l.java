package com.tencent.luggage.wxa.de;

import com.tencent.ilink.tdi.b.y;
import com.tencent.luggage.wxa.dc.v;
import com.tencent.luggage.wxa.dd.i;
import com.tencent.luggage.wxa.qu.a;
import com.tencent.luggage.wxa.qw.gu;
import com.tencent.luggage.wxa.qz.r;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/login/account/tdi/TdiCgiServiceManager;", "Lcom/tencent/luggage/login/account/tdi/ITdiCgiService;", "Lcom/tencent/mm/plugin/appbrand/networking/ICgiService;", "Lcom/tencent/mm/kernel/service/IServiceLifeCycle;", "()V", "TAG", "", "sClientCgiService", "Lcom/tencent/luggage/login/account/tdi/TdiCgiServiceClient;", "getSClientCgiService", "()Lcom/tencent/luggage/login/account/tdi/TdiCgiServiceClient;", "sClientNonLoginCgiService", "getSClientNonLoginCgiService", "()Lcom/tencent/luggage/login/account/tdi/ITdiCgiService;", "sServerNonLoginCgiService", "getSServerNonLoginCgiService", "sServerTdiCgiService", "getSServerTdiCgiService", "sSkipCgi", "Ljava/util/LinkedList;", "installNoLoginTdiCgi", "", "tdiCgi", "Lcom/tencent/luggage/login/account/tdi/ITdiCgi;", "installTdiCgi", "onRegister", "onUnregister", "sync", "RESP", "Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "cmdId", "", "url", "networkType", "Lcom/tencent/ilink/tdi/TdiApiProto$TdiNetType;", "req", "Lcom/tencent/mm/protobuf/BaseProtoBuf;", "respClazz", "Ljava/lang/Class;", "(ILjava/lang/String;Lcom/tencent/ilink/tdi/TdiApiProto$TdiNetType;Lcom/tencent/mm/protobuf/BaseProtoBuf;Ljava/lang/Class;)Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "Resp", "appId", "(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mm/protobuf/BaseProtoBuf;Ljava/lang/Class;)Lcom/tencent/mm/protocal/protobuf/ResponseProtoBuf;", "syncPipeline", "Lcom/tencent/mm/vending/pipeline/Pipeable;", "uninstall", "useTdiCgiService", "", "luggage-standalone-addon-loginsession_release"}, k=1, mv={1, 1, 16})
public final class l
  implements d, com.tencent.luggage.wxa.hw.b, com.tencent.luggage.wxa.ob.b
{
  public static final l a = new l();
  @NotNull
  private static final d b = (d)new p();
  @NotNull
  private static final k c = new k();
  @NotNull
  private static final d d = (d)new o();
  @NotNull
  private static final d e = (d)new n();
  private static final LinkedList<String> f = new LinkedList();
  
  static
  {
    f.add("/cgi-bin/mmoc-bin/hardware/getwerunuserstate");
  }
  
  private final boolean a(String paramString)
  {
    return !f.contains(paramString);
  }
  
  @Nullable
  public <RESP extends gu> RESP a(int paramInt, @NotNull String paramString, @NotNull b.y paramy, @Nullable a parama, @NotNull Class<RESP> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    Intrinsics.checkParameterIsNotNull(paramy, "networkType");
    Intrinsics.checkParameterIsNotNull(paramClass, "respClazz");
    boolean bool = r.h();
    gu localgu = null;
    Object localObject;
    if (bool)
    {
      if (b == null) {
        com.tencent.luggage.wxa.qz.o.b("ILink.TdiCgiServiceManager", "sServerTdiCgiService is null");
      }
      localObject = b;
      if (localObject != null) {
        return ((d)localObject).a(paramInt, paramString, paramy, parama, paramClass);
      }
    }
    else
    {
      if (c == null) {
        com.tencent.luggage.wxa.qz.o.b("ILink.TdiCgiServiceManager", "sClientCgiService is null");
      }
      localObject = c;
      if (localObject != null) {
        localgu = ((k)localObject).a(paramInt, paramString, paramy, parama, paramClass);
      }
    }
    return localgu;
  }
  
  @Nullable
  public <Resp extends gu> Resp a(@NotNull String paramString1, @Nullable String paramString2, @NotNull a parama, @NotNull Class<Resp> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "url");
    Intrinsics.checkParameterIsNotNull(parama, "req");
    Intrinsics.checkParameterIsNotNull(paramClass, "respClazz");
    if (a(paramString1))
    {
      boolean bool = i.a.g();
      gu localgu = null;
      Object localObject;
      if (bool)
      {
        if (r.h())
        {
          if (b == null) {
            com.tencent.luggage.wxa.qz.o.b("ILink.TdiCgiServiceManager", "sServerTdiCgiService is null");
          }
          localObject = b;
          if (localObject != null) {
            return ((d)localObject).a(paramString1, paramString2, parama, paramClass);
          }
        }
        else
        {
          if (c == null) {
            com.tencent.luggage.wxa.qz.o.b("ILink.TdiCgiServiceManager", "sClientCgiService is null");
          }
          localObject = c;
          if (localObject != null) {
            return ((k)localObject).a(paramString1, paramString2, parama, paramClass);
          }
        }
      }
      else if (r.h())
      {
        if (d == null) {
          com.tencent.luggage.wxa.qz.o.b("ILink.TdiCgiServiceManager", "sServerTdiCgiService is null");
        }
        localObject = d;
        if (localObject != null) {
          return ((d)localObject).a(paramString1, paramString2, parama, paramClass);
        }
      }
      else
      {
        if (e == null) {
          com.tencent.luggage.wxa.qz.o.b("ILink.TdiCgiServiceManager", "sClientCgiService is null");
        }
        localObject = e;
        if (localObject != null) {
          localgu = ((d)localObject).a(paramString1, paramString2, parama, paramClass);
        }
      }
      return localgu;
    }
    return v.a.a(paramString1, paramString2, parama, paramClass);
  }
  
  public void a()
  {
    Object localObject = b;
    if (localObject != null) {
      ((d)localObject).a();
    }
    localObject = c;
    if (localObject != null) {
      ((k)localObject).a();
    }
  }
  
  public void a(@NotNull b paramb)
  {
    Intrinsics.checkParameterIsNotNull(paramb, "tdiCgi");
    com.tencent.luggage.wxa.qz.o.d("ILink.TdiCgiServiceManager", "installTdiCgi");
    if (r.h())
    {
      d locald = b;
      if (locald != null) {
        locald.a(paramb);
      }
    }
  }
  
  @NotNull
  public final d b()
  {
    return b;
  }
  
  @NotNull
  public <RESP extends gu> com.tencent.luggage.wxa.ro.d<RESP> b(int paramInt, @NotNull String paramString, @NotNull b.y paramy, @Nullable a parama, @NotNull Class<RESP> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    Intrinsics.checkParameterIsNotNull(paramy, "networkType");
    Intrinsics.checkParameterIsNotNull(paramClass, "respClazz");
    if (r.h())
    {
      if (b == null) {
        com.tencent.luggage.wxa.qz.o.b("ILink.TdiCgiServiceManager", "sServerTdiCgiService is null");
      }
      localObject = b;
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      return ((d)localObject).b(paramInt, paramString, paramy, parama, paramClass);
    }
    if (c == null) {
      com.tencent.luggage.wxa.qz.o.b("ILink.TdiCgiServiceManager", "sClientCgiService is null");
    }
    Object localObject = c;
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    return ((k)localObject).b(paramInt, paramString, paramy, parama, paramClass);
  }
  
  @NotNull
  public <Resp extends gu> com.tencent.luggage.wxa.ro.d<Resp> b(@NotNull String paramString1, @Nullable String paramString2, @Nullable a parama, @NotNull Class<Resp> paramClass)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "url");
    Intrinsics.checkParameterIsNotNull(paramClass, "respClazz");
    if (a(paramString1))
    {
      if (i.a.g())
      {
        if (r.h())
        {
          if (b == null) {
            com.tencent.luggage.wxa.qz.o.b("ILink.TdiCgiServiceManager", "sServerTdiCgiService is null");
          }
          localObject = b;
          if (localObject == null) {
            Intrinsics.throwNpe();
          }
          paramString1 = ((d)localObject).b(paramString1, paramString2, parama, paramClass);
          Intrinsics.checkExpressionValueIsNotNull(paramString1, "sServerTdiCgiService!!.s…l, appId, req, respClazz)");
          return paramString1;
        }
        if (c == null) {
          com.tencent.luggage.wxa.qz.o.b("ILink.TdiCgiServiceManager", "sClientCgiService is null");
        }
        localObject = c;
        if (localObject == null) {
          Intrinsics.throwNpe();
        }
        return ((k)localObject).b(paramString1, paramString2, parama, paramClass);
      }
      if (r.h())
      {
        if (d == null) {
          com.tencent.luggage.wxa.qz.o.b("ILink.TdiCgiServiceManager", "sServerTdiCgiService is null");
        }
        localObject = d;
        if (localObject == null) {
          Intrinsics.throwNpe();
        }
        paramString1 = ((d)localObject).b(paramString1, paramString2, parama, paramClass);
        Intrinsics.checkExpressionValueIsNotNull(paramString1, "sServerNonLoginCgiServic…l, appId, req, respClazz)");
        return paramString1;
      }
      if (e == null) {
        com.tencent.luggage.wxa.qz.o.b("ILink.TdiCgiServiceManager", "sClientCgiService is null");
      }
      Object localObject = e;
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      paramString1 = ((d)localObject).b(paramString1, paramString2, parama, paramClass);
      Intrinsics.checkExpressionValueIsNotNull(paramString1, "sClientNonLoginCgiServic…l, appId, req, respClazz)");
      return paramString1;
    }
    paramString1 = v.a.b(paramString1, paramString2, parama, paramClass);
    Intrinsics.checkExpressionValueIsNotNull(paramString1, "WxaSessionKeyCgiService.…l, appId, req, respClazz)");
    return paramString1;
  }
  
  public void c()
  {
    d[] arrayOfd = new d[4];
    Object localObject = b;
    int i = 0;
    arrayOfd[0] = localObject;
    arrayOfd[1] = ((d)c);
    arrayOfd[2] = d;
    arrayOfd[3] = e;
    int j = arrayOfd.length;
    while (i < j)
    {
      d locald = arrayOfd[i];
      localObject = locald;
      if (!(locald instanceof com.tencent.luggage.wxa.hw.b)) {
        localObject = null;
      }
      localObject = (com.tencent.luggage.wxa.hw.b)localObject;
      if (localObject != null) {
        ((com.tencent.luggage.wxa.hw.b)localObject).c();
      }
      i += 1;
    }
  }
  
  public void d()
  {
    d[] arrayOfd = new d[4];
    Object localObject = b;
    int i = 0;
    arrayOfd[0] = localObject;
    arrayOfd[1] = ((d)c);
    arrayOfd[2] = d;
    arrayOfd[3] = e;
    int j = arrayOfd.length;
    while (i < j)
    {
      d locald = arrayOfd[i];
      localObject = locald;
      if (!(locald instanceof com.tencent.luggage.wxa.hw.b)) {
        localObject = null;
      }
      localObject = (com.tencent.luggage.wxa.hw.b)localObject;
      if (localObject != null) {
        ((com.tencent.luggage.wxa.hw.b)localObject).d();
      }
      i += 1;
    }
  }
  
  @NotNull
  public final d e()
  {
    return d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.de.l
 * JD-Core Version:    0.7.0.1
 */
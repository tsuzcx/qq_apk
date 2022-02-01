package com.tencent.luggage.wxa.kg;

import com.tencent.luggage.wxa.iu.c.c;
import com.tencent.luggage.wxa.kn.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServerManager;", "", "()V", "MAX_PERIPHERAL_BLE_SERVER_COUNT", "", "TAG", "", "bleServers", "", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PeripheralBleServer;", "isDestroying", "", "listener", "Lcom/tencent/mm/plugin/appbrand/AppBrandLifeCycle$Listener;", "clear", "", "closeServerById", "serverId", "genServerId", "newPeripheralServer", "component", "Lcom/tencent/mm/plugin/appbrand/jsapi/AppBrandComponent;", "retrieveServer", "willOutOfBound", "luggage-commons-jsapi-connectivity-ext_release"}, k=1, mv={1, 1, 16})
public final class o
{
  public static final o a = new o();
  private static final Map<Integer, n> b = (Map)new ConcurrentHashMap();
  private static c.c c;
  private static volatile boolean d;
  
  private final int c()
  {
    int i;
    do
    {
      i = b.b();
    } while (b.containsKey(Integer.valueOf(i)));
    return i;
  }
  
  public final int a(@NotNull com.tencent.luggage.wxa.jx.c paramc)
  {
    Intrinsics.checkParameterIsNotNull(paramc, "component");
    try
    {
      if (c == null)
      {
        c = (c.c)new o.a();
        com.tencent.luggage.wxa.iu.c.a(paramc.getAppId(), c);
      }
      boolean bool = d;
      if (bool) {
        return -1;
      }
      Object localObject = Unit.INSTANCE;
      int i = c();
      localObject = new n();
      ((n)localObject).a(paramc, i);
      b.put(Integer.valueOf(i), localObject);
      return i;
    }
    finally {}
  }
  
  public final boolean a()
  {
    return b.size() + 1 > 10;
  }
  
  public final boolean a(int paramInt)
  {
    boolean bool1 = d;
    boolean bool2 = false;
    if (bool1) {
      return false;
    }
    n localn = (n)b.get(Integer.valueOf(paramInt));
    bool1 = bool2;
    if (localn != null)
    {
      localn.e();
      bool1 = bool2;
      if (b.remove(Integer.valueOf(paramInt)) != null) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  @Nullable
  public final n b(int paramInt)
  {
    if (d) {
      return null;
    }
    return (n)b.get(Integer.valueOf(paramInt));
  }
  
  public final void b()
  {
    try
    {
      Object localObject3 = b;
      Object localObject1 = (Collection)new ArrayList(((Map)localObject3).size());
      localObject3 = ((Map)localObject3).entrySet().iterator();
      while (((Iterator)localObject3).hasNext()) {
        ((Collection)localObject1).add((n)((Map.Entry)((Iterator)localObject3).next()).getValue());
      }
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (n)((Iterator)localObject1).next();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("destroy server #");
        localStringBuilder.append(((n)localObject3).d());
        com.tencent.luggage.wxa.qz.o.d("MicroMsg.BLE.PeripheralBleServerManager", localStringBuilder.toString());
        ((n)localObject3).e();
      }
      b.clear();
      localObject1 = Unit.INSTANCE;
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kg.o
 * JD-Core Version:    0.7.0.1
 */
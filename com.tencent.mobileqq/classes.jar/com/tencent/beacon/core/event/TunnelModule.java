package com.tencent.beacon.core.event;

import android.content.Context;
import com.tencent.beacon.core.d.k;
import com.tencent.beacon.core.e.j;
import com.tencent.beacon.core.strategy.StrategyQueryModule;
import com.tencent.beacon.event.a;
import com.tencent.beacon.upload.TunnelInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TunnelModule
  extends com.tencent.beacon.core.c
{
  private static volatile TunnelModule INSTANCE;
  private static List<a<Map<String, String>>> cacheAdditionInfo = Collections.synchronizedList(new ArrayList(5));
  private static List<f> cacheEvents;
  private static List<TunnelInfo> cacheTunnel = Collections.synchronizedList(new ArrayList(5));
  private static List<a<String>> cacheUserId = Collections.synchronizedList(new ArrayList(5));
  public static TunnelModule.b netConsumeUtil;
  private h appDefaultEventTunnel;
  private Context context;
  protected Runnable doUploadTask = new z(this);
  public boolean isEnable;
  private Map<String, h> tunnelMap;
  
  static
  {
    cacheEvents = Collections.synchronizedList(new ArrayList(5));
  }
  
  public TunnelModule(Context paramContext)
  {
    super(paramContext);
    this.context = paramContext;
    this.appDefaultEventTunnel = new h(paramContext, com.tencent.beacon.core.info.b.b(paramContext).a());
    this.tunnelMap = new ConcurrentHashMap();
    dealCacheTunnel();
    dealCacheAdditionalInfo();
    dealCacheUserId();
  }
  
  private void addTunnel(TunnelInfo paramTunnelInfo)
  {
    for (;;)
    {
      try
      {
        if (paramTunnelInfo.appKey.equals(this.appDefaultEventTunnel.b()))
        {
          com.tencent.beacon.core.e.d.b("[event] can not register app default appkey: %s", new Object[] { paramTunnelInfo.appKey });
          return;
        }
        if ((h)this.tunnelMap.get(paramTunnelInfo.appKey) != null)
        {
          com.tencent.beacon.core.e.d.b("[event] registerTunnel failed. EventTunnel already exists :%s", new Object[] { paramTunnelInfo.appKey });
          continue;
        }
        localh = createTunnel(this.context, paramTunnelInfo);
      }
      finally {}
      h localh;
      this.tunnelMap.put(paramTunnelInfo.appKey, localh);
    }
  }
  
  private void allTunnel(TunnelModule.a parama)
  {
    if (parama == null) {}
    for (;;)
    {
      return;
      Object localObject = this.appDefaultEventTunnel;
      if (localObject != null) {
        parama.a((h)localObject);
      }
      localObject = this.tunnelMap.values().iterator();
      while (((Iterator)localObject).hasNext()) {
        parama.a((h)((Iterator)localObject).next());
      }
    }
  }
  
  private h createTunnel(Context paramContext, TunnelInfo paramTunnelInfo)
  {
    paramTunnelInfo.channel = com.tencent.beacon.core.e.c.a(paramTunnelInfo.channel);
    h localh = new h(paramContext, paramTunnelInfo.appKey);
    localh.a(true);
    com.tencent.beacon.core.info.g.b(paramContext).a(paramTunnelInfo.appKey, paramTunnelInfo);
    return localh;
  }
  
  private void dealCacheAdditionalInfo()
  {
    Iterator localIterator = cacheAdditionInfo.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      setAdditionalInfoInstance(locala.a, (Map)locala.b);
    }
    cacheAdditionInfo.clear();
  }
  
  private void dealCacheTunnel()
  {
    Iterator localIterator = cacheTunnel.iterator();
    while (localIterator.hasNext())
    {
      TunnelInfo localTunnelInfo = (TunnelInfo)localIterator.next();
      h localh = createTunnel(this.context, localTunnelInfo);
      this.tunnelMap.put(localTunnelInfo.appKey, localh);
    }
    cacheTunnel.clear();
  }
  
  private void dealCacheUserId()
  {
    Iterator localIterator = cacheUserId.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      setUserIdInstance(locala.a, (String)locala.b);
    }
    cacheUserId.clear();
  }
  
  public static void doUploadAllEventsData()
  {
    TunnelModule localTunnelModule = getInstance();
    if ((localTunnelModule != null) && (isModuleAble())) {
      localTunnelModule.allTunnel(new B());
    }
  }
  
  public static void doUploadRecentCommonData(boolean paramBoolean)
  {
    TunnelModule localTunnelModule = getInstance();
    if ((localTunnelModule == null) || (!isModuleAble())) {
      return;
    }
    localTunnelModule.allTunnel(new A(paramBoolean));
  }
  
  public static void flushObjectsToDB(boolean paramBoolean)
  {
    TunnelModule localTunnelModule = getInstance();
    if (localTunnelModule != null) {
      localTunnelModule.allTunnel(new C(paramBoolean));
    }
  }
  
  public static Map<String, String> getAdditionalInfo(String paramString)
  {
    Object localObject = getInstance();
    if (localObject == null)
    {
      com.tencent.beacon.core.e.d.b("getAdditionalInfo failed, sdk is not ready", new Object[0]);
      return null;
    }
    localObject = ((TunnelModule)localObject).getTunnelByAppKey(paramString);
    if (localObject == null)
    {
      com.tencent.beacon.core.e.d.b("getAdditionalInfo failed, tunnel of %s not found", new Object[] { paramString });
      return null;
    }
    return ((h)localObject).a();
  }
  
  public static TunnelModule getInstance()
  {
    return INSTANCE;
  }
  
  public static TunnelModule getInstance(Context paramContext)
  {
    if (INSTANCE == null) {}
    try
    {
      if (INSTANCE == null) {
        INSTANCE = new TunnelModule(paramContext);
      }
      return INSTANCE;
    }
    finally {}
  }
  
  private h getTunnelByAppKey(String paramString)
  {
    if ((j.c(paramString)) || (paramString.equals(this.appDefaultEventTunnel.b()))) {
      return this.appDefaultEventTunnel;
    }
    return (h)this.tunnelMap.get(paramString);
  }
  
  public static String getUserId(String paramString)
  {
    Object localObject = getInstance();
    if (localObject == null)
    {
      com.tencent.beacon.core.e.d.b("getUserId failed, sdk is not ready", new Object[0]);
      return null;
    }
    localObject = ((TunnelModule)localObject).getTunnelByAppKey(paramString);
    if (localObject == null)
    {
      com.tencent.beacon.core.e.d.b("getUserId failed, tunnel of %s not found", new Object[] { paramString });
      return null;
    }
    return ((h)localObject).f();
  }
  
  public static boolean isModuleAble()
  {
    Object localObject = getInstance();
    if (localObject == null)
    {
      com.tencent.beacon.core.e.d.b("[module] this module not ready!", new Object[0]);
      return false;
    }
    boolean bool2 = ((TunnelModule)localObject).isEnable;
    boolean bool1 = bool2;
    if (bool2) {
      bool1 = StrategyQueryModule.getInstance(((TunnelModule)localObject).context).isAtLeastAComQueryEnd();
    }
    if (bool1)
    {
      localObject = EventStrategyBean.getInstance();
      if (localObject != null)
      {
        TunnelModule.b localb = netConsumeUtil;
        if ((localb != null) && (localb.a() >= ((EventStrategyBean)localObject).getDailyConsumeLimit()))
        {
          com.tencent.beacon.core.e.d.i("[strategy] reach daily consume limited! %d ", new Object[] { Integer.valueOf(((EventStrategyBean)localObject).getDailyConsumeLimit()) });
          return false;
        }
      }
    }
    return bool1;
  }
  
  public static boolean onUserAction(String paramString1, String paramString2, boolean paramBoolean1, long paramLong1, long paramLong2, Map<String, String> paramMap, boolean paramBoolean2)
  {
    return onUserAction(paramString1, paramString2, paramBoolean1, paramLong1, paramLong2, paramMap, paramBoolean2, false);
  }
  
  public static boolean onUserAction(String paramString1, String paramString2, boolean paramBoolean1, long paramLong1, long paramLong2, Map<String, String> paramMap, boolean paramBoolean2, boolean paramBoolean3)
  {
    Object localObject = StrategyQueryModule.getInstance();
    if ((localObject == null) || (!((StrategyQueryModule)localObject).isAtLeastAComQueryEnd()))
    {
      com.tencent.beacon.core.e.d.d("[event] [%s] add to cache events list.", new Object[] { paramString2 });
      localObject = cacheEvents;
      if (localObject != null) {
        ((List)localObject).add(new f(paramString1, paramString2, paramBoolean1, paramLong1, paramLong2, paramMap, paramBoolean2));
      }
      return true;
    }
    if (!isModuleAble())
    {
      com.tencent.beacon.core.e.d.b("[event] UserEventModule is disable (false).", new Object[0]);
      return false;
    }
    localObject = getInstance();
    if (localObject != null)
    {
      localObject = ((TunnelModule)localObject).getTunnelByAppKey(paramString1);
      if (localObject != null) {
        return ((h)localObject).a(paramString2, paramBoolean1, paramLong1, paramLong2, paramMap, paramBoolean2, paramBoolean3);
      }
      com.tencent.beacon.core.e.d.b("onUserAction failed, tunnel of %s not found", new Object[] { paramString1 });
    }
    return false;
  }
  
  public static void registerTunnel(TunnelInfo paramTunnelInfo)
  {
    if (j.c(paramTunnelInfo.appKey))
    {
      com.tencent.beacon.core.e.d.b("[event] registerTunnel failed. appKey is empty", new Object[0]);
      return;
    }
    TunnelModule localTunnelModule = getInstance();
    if (localTunnelModule == null)
    {
      cacheTunnel.add(paramTunnelInfo);
      return;
    }
    localTunnelModule.addTunnel(paramTunnelInfo);
  }
  
  public static void setAdditionalInfo(String paramString, Map<String, String> paramMap)
  {
    TunnelModule localTunnelModule = getInstance();
    if (localTunnelModule == null)
    {
      cacheAdditionInfo.add(new a(paramString, paramMap));
      return;
    }
    localTunnelModule.setAdditionalInfoInstance(paramString, paramMap);
  }
  
  private void setAdditionalInfoInstance(String paramString, Map<String, String> paramMap)
  {
    h localh = getTunnelByAppKey(paramString);
    if (localh == null)
    {
      com.tencent.beacon.core.e.d.b("setAdditionalInfo failed, tunnel of %s not found", new Object[] { paramString });
      return;
    }
    localh.a(paramMap);
  }
  
  public static void setNetConsumeProtocol(TunnelModule.b paramb)
  {
    netConsumeUtil = paramb;
  }
  
  public static void setUserId(String paramString1, String paramString2)
  {
    TunnelModule localTunnelModule = getInstance();
    if (localTunnelModule == null)
    {
      cacheUserId.add(new a(paramString1, paramString2));
      return;
    }
    String str = paramString2;
    if (j.c(paramString2)) {
      str = "10000";
    }
    localTunnelModule.setUserIdInstance(paramString1, com.tencent.beacon.core.e.c.d(str));
  }
  
  private void setUserIdInstance(String paramString1, String paramString2)
  {
    h localh = getTunnelByAppKey(paramString1);
    if (localh == null)
    {
      com.tencent.beacon.core.e.d.b("setUserId failed, tunnel of %s not found", new Object[] { paramString1 });
      return;
    }
    localh.b(paramString2);
  }
  
  public void dealCacheEvent()
  {
    try
    {
      Object localObject1 = cacheEvents;
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        localObject1 = cacheEvents.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          f localf = (f)((Iterator)localObject1).next();
          onUserAction(localf.g, localf.a, localf.b, localf.c, localf.d, localf.e, localf.f);
        }
        cacheEvents.clear();
      }
    }
    finally {}
  }
  
  public void onAppFirstRun()
  {
    com.tencent.beacon.core.e.d.e("[event] ua first clean :%d", new Object[] { Integer.valueOf(t.a(this.mContext, this.appDefaultEventTunnel.b(), null, -1L, 9223372036854775807L)) });
    com.tencent.beacon.core.e.d.e("[event] ua remove strategy :%d", new Object[] { Integer.valueOf(com.tencent.beacon.core.strategy.d.a(this.mContext, 101)) });
  }
  
  public void onModuleStrategyUpdated(int paramInt, Map<String, String> paramMap)
  {
    super.onModuleStrategyUpdated(paramInt, paramMap);
    if ((paramInt == 1) && (paramMap != null) && (paramMap.size() > 0) && (EventStrategyBean.getInstance() != null)) {
      EventStrategyBean.getInstance().updateConfig(paramMap);
    }
  }
  
  public void onSDKInit(Context paramContext)
  {
    super.onSDKInit(paramContext);
    setModuleUserEnable(true);
    com.tencent.beacon.core.a.g.a().a(paramContext, new y(this));
  }
  
  public void onStrategyQueryFinished()
  {
    super.onStrategyQueryFinished();
    allTunnel(new w(this));
    dealCacheEvent();
  }
  
  public void onStrategyUpdated(com.tencent.beacon.core.strategy.c paramc)
  {
    super.onStrategyUpdated(paramc);
    if (paramc != null)
    {
      paramc = paramc.b(1);
      if (paramc != null)
      {
        boolean bool = paramc.f();
        com.tencent.beacon.core.e.d.f("[strategy] setEnable: %b", new Object[] { Boolean.valueOf(bool) });
        setEnable(bool);
      }
    }
  }
  
  public void setAppKey(String paramString)
  {
    h localh = this.appDefaultEventTunnel;
    if (localh != null) {
      localh.a(paramString);
    }
  }
  
  public void setEnable(boolean paramBoolean)
  {
    try
    {
      this.isEnable = paramBoolean;
      allTunnel(new x(this, paramBoolean));
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setModuleUserEnable(boolean paramBoolean)
  {
    Object localObject = StrategyQueryModule.getInstance(this.mContext);
    if (localObject != null)
    {
      localObject = ((StrategyQueryModule)localObject).getStrategy().b(1);
      if ((localObject != null) && (((com.tencent.beacon.core.strategy.b)localObject).f() != paramBoolean))
      {
        ((com.tencent.beacon.core.strategy.b)localObject).a(paramBoolean);
        setEnable(paramBoolean);
      }
    }
  }
  
  public void setUploadMode(boolean paramBoolean)
  {
    if ((k.a(this.mContext) != null) && (paramBoolean != k.a(this.mContext).e()))
    {
      if (paramBoolean) {
        k.a(this.mContext).a(true);
      }
    }
    else {
      return;
    }
    k.a(this.mContext).a(false);
  }
  
  public void updateSchedule()
  {
    allTunnel(new D(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.event.TunnelModule
 * JD-Core Version:    0.7.0.1
 */
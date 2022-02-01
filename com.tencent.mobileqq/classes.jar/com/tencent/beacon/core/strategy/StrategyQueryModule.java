package com.tencent.beacon.core.strategy;

import android.content.Context;
import com.tencent.beacon.core.d.k;
import com.tencent.beacon.event.UserAction;
import com.tencent.beacon.upload.InitHandleListener;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class StrategyQueryModule
  extends com.tencent.beacon.core.c
{
  public static final int CheckApp = 1;
  public static final int EndQuery = 3;
  public static final String LAST_SUCCESS_STRATEGY_QUERY_TIME = "last_success_strategy_query_time";
  public static final int Launch = 0;
  private static final Object QUERY_STATE_LOCK = new Object();
  public static final int StartQuery = 2;
  public static final String TODAY_SUCCESS_STRATEGY_QUERY_TIMES = "today_success_strategy_query_times";
  public static final int WaitNextQuery = 4;
  private static volatile StrategyQueryModule mInstance;
  private boolean atLeastAComQueryEnd = false;
  private boolean atLeastAComQuerySuccess = false;
  private int commonQueryTime = 0;
  protected int currentQueryStep = 0;
  protected boolean isAppFirstRun = false;
  private InitHandleListener mInitHandleListener;
  protected c strategy = null;
  private com.tencent.beacon.core.d.g strategyHandler = null;
  private i strategyQueryRunner = null;
  protected com.tencent.beacon.core.d.j uploadHandler = null;
  
  private StrategyQueryModule(Context paramContext)
  {
    super(paramContext);
    this.uploadHandler = k.a(paramContext);
    this.strategy = c.g();
    g.b(paramContext).a(this.strategy);
    this.strategyHandler = new j(paramContext);
    this.uploadHandler.a(101, getStrategyHandler());
    this.strategyQueryRunner = new i(paramContext);
  }
  
  public static StrategyQueryModule getInstance()
  {
    try
    {
      StrategyQueryModule localStrategyQueryModule = mInstance;
      return localStrategyQueryModule;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static StrategyQueryModule getInstance(Context paramContext)
  {
    try
    {
      if ((mInstance == null) && (paramContext != null)) {
        mInstance = new StrategyQueryModule(paramContext);
      }
      paramContext = mInstance;
      return paramContext;
    }
    finally {}
  }
  
  /* Error */
  public static com.tencent.beacon.core.d.j getMyUpload()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 113	com/tencent/beacon/core/strategy/StrategyQueryModule:mInstance	Lcom/tencent/beacon/core/strategy/StrategyQueryModule;
    //   6: ifnull +15 -> 21
    //   9: getstatic 113	com/tencent/beacon/core/strategy/StrategyQueryModule:mInstance	Lcom/tencent/beacon/core/strategy/StrategyQueryModule;
    //   12: invokespecial 120	com/tencent/beacon/core/strategy/StrategyQueryModule:getStrategyUploadHandler	()Lcom/tencent/beacon/core/d/j;
    //   15: astore_0
    //   16: ldc 2
    //   18: monitorexit
    //   19: aload_0
    //   20: areturn
    //   21: aconst_null
    //   22: astore_0
    //   23: goto -7 -> 16
    //   26: astore_0
    //   27: ldc 2
    //   29: monitorexit
    //   30: aload_0
    //   31: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   15	8	0	localj	com.tencent.beacon.core.d.j
    //   26	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	16	26	finally
  }
  
  private com.tencent.beacon.core.d.j getStrategyUploadHandler()
  {
    try
    {
      com.tencent.beacon.core.d.j localj = this.uploadHandler;
      return localj;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int getCommonQueryTime()
  {
    synchronized (QUERY_STATE_LOCK)
    {
      int i = this.commonQueryTime;
      return i;
    }
  }
  
  public int getCurrentQueryStep()
  {
    synchronized (QUERY_STATE_LOCK)
    {
      int i = this.currentQueryStep;
      return i;
    }
  }
  
  public c getStrategy()
  {
    try
    {
      c localc = this.strategy;
      return localc;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public com.tencent.beacon.core.d.g getStrategyHandler()
  {
    try
    {
      com.tencent.beacon.core.d.g localg = this.strategyHandler;
      return localg;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean isAppFirstRun()
  {
    try
    {
      boolean bool = this.isAppFirstRun;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean isAtLeastAComQueryEnd()
  {
    synchronized (QUERY_STATE_LOCK)
    {
      boolean bool = this.atLeastAComQueryEnd;
      return bool;
    }
  }
  
  public boolean isAtLeastAComQuerySuccess()
  {
    synchronized (QUERY_STATE_LOCK)
    {
      boolean bool = this.atLeastAComQuerySuccess;
      return bool;
    }
  }
  
  public void notifyModuleDetailChanged(int paramInt, Map<String, String> paramMap)
  {
    Iterator localIterator = UserAction.beaconModules.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.beacon.core.c)localIterator.next()).onModuleStrategyUpdated(paramInt, paramMap);
    }
  }
  
  public void notifyStrategyChanged(c paramc)
  {
    Iterator localIterator = UserAction.beaconModules.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.beacon.core.c localc = (com.tencent.beacon.core.c)localIterator.next();
      try
      {
        localc.onStrategyUpdated(paramc);
      }
      catch (Throwable localThrowable)
      {
        com.tencent.beacon.core.e.d.a(localThrowable);
        com.tencent.beacon.core.e.d.b("[strategy] error %s", new Object[] { localThrowable.toString() });
      }
    }
  }
  
  public void onFirstStrategyQueryFinished()
  {
    super.onFirstStrategyQueryFinished();
    InitHandleListener localInitHandleListener = this.mInitHandleListener;
    if (localInitHandleListener != null) {
      localInitHandleListener.onInitEnd();
    }
  }
  
  public void onSDKInit(Context paramContext)
  {
    super.onSDKInit(paramContext);
    com.tencent.beacon.core.e.d.a("[module] strategy module > TRUE", new Object[0]);
    startQuery();
    com.tencent.beacon.core.a.g.a().a(paramContext, new h(this, paramContext));
  }
  
  public void onStrategyQueryFinished()
  {
    super.onStrategyQueryFinished();
    InitHandleListener localInitHandleListener = this.mInitHandleListener;
    if (localInitHandleListener != null) {
      localInitHandleListener.onStrategyQuerySuccess();
    }
  }
  
  public void onStrategyUpdated(c paramc)
  {
    try
    {
      super.onStrategyUpdated(paramc);
      this.strategy.l();
      return;
    }
    finally
    {
      paramc = finally;
      throw paramc;
    }
  }
  
  public void setAppFirstRun(boolean paramBoolean)
  {
    try
    {
      this.isAppFirstRun = paramBoolean;
      com.tencent.beacon.core.e.d.f("[strategy] set isFirst: %b", new Object[] { Boolean.valueOf(paramBoolean) });
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setAtLeastAComQueryEnd(boolean paramBoolean)
  {
    synchronized (QUERY_STATE_LOCK)
    {
      this.atLeastAComQueryEnd = paramBoolean;
      return;
    }
  }
  
  public void setAtLeastAComQuerySuccess(boolean paramBoolean)
  {
    synchronized (QUERY_STATE_LOCK)
    {
      this.atLeastAComQuerySuccess = paramBoolean;
      return;
    }
  }
  
  public void setCommonQueryTime(int paramInt)
  {
    synchronized (QUERY_STATE_LOCK)
    {
      this.commonQueryTime = paramInt;
      return;
    }
  }
  
  public void setCommonStrategy(c paramc)
  {
    try
    {
      this.strategy = paramc;
      return;
    }
    finally
    {
      paramc = finally;
      throw paramc;
    }
  }
  
  public void setCurrentQueryStep(int paramInt)
  {
    synchronized (QUERY_STATE_LOCK)
    {
      this.currentQueryStep = paramInt;
      com.tencent.beacon.core.e.d.f("[strategy] current query step:%d", new Object[] { Integer.valueOf(paramInt) });
      if (paramInt == 3) {
        setAtLeastAComQueryEnd(true);
      }
      return;
    }
  }
  
  public void setInitHandleListener(InitHandleListener paramInitHandleListener)
  {
    this.mInitHandleListener = paramInitHandleListener;
  }
  
  public void startQuery()
  {
    try
    {
      i locali = this.strategyQueryRunner;
      if (!locali.c)
      {
        locali.d();
        com.tencent.beacon.core.a.d.a().a(this.strategyQueryRunner);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.strategy.StrategyQueryModule
 * JD-Core Version:    0.7.0.1
 */
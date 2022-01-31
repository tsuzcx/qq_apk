package com.tencent.beacon.core.strategy;

import android.content.Context;
import com.tencent.beacon.core.c.g;
import com.tencent.beacon.core.c.h;
import com.tencent.beacon.core.c.i;
import com.tencent.beacon.event.UserAction;
import com.tencent.beacon.upload.InitHandleListener;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class StrategyQueryModule
  extends com.tencent.beacon.core.b
{
  public static final int CheckApp = 1;
  public static final int EndQuery = 3;
  public static final String LAST_SUCCESS_STRATEGY_QUERY_TIME = "last_success_strategy_query_time";
  public static final int Launch = 0;
  public static final int StartQuery = 2;
  public static final String TODAY_SUCCESS_STRATEGY_QUERY_TIMES = "today_success_strategy_query_times";
  public static final int WaitNextQuery = 4;
  private static StrategyQueryModule mInstance = null;
  private boolean atLeastAComQueryEnd = false;
  private boolean atLeastAComQuerySuccess = false;
  private int commonQueryTime = 0;
  protected int currentQueryStep = 0;
  private Runnable getInitConfigTask = new StrategyQueryModule.1(this);
  protected boolean isAppFirstRun = false;
  private InitHandleListener mInitHandleListener;
  private Object queryStateLock = new Object();
  protected a strategy = null;
  private g strategyHandler = null;
  private c strategyQueryRunner = null;
  protected h uploadHandler = null;
  
  private StrategyQueryModule(Context paramContext)
  {
    super(paramContext);
    this.uploadHandler = i.a(paramContext);
    this.strategy = a.a();
    com.tencent.beacon.core.a.b.b().a(this.getInitConfigTask);
    this.strategyHandler = new d(paramContext);
    this.uploadHandler.a(101, getStrategyHandler());
    this.strategyQueryRunner = new c(paramContext);
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
  public static h getMyUpload()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 48	com/tencent/beacon/core/strategy/StrategyQueryModule:mInstance	Lcom/tencent/beacon/core/strategy/StrategyQueryModule;
    //   6: ifnull +15 -> 21
    //   9: getstatic 48	com/tencent/beacon/core/strategy/StrategyQueryModule:mInstance	Lcom/tencent/beacon/core/strategy/StrategyQueryModule;
    //   12: invokespecial 135	com/tencent/beacon/core/strategy/StrategyQueryModule:getStrategyUploadHandler	()Lcom/tencent/beacon/core/c/h;
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
    //   15	8	0	localh	h
    //   26	5	0	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	16	26	finally
  }
  
  private h getStrategyUploadHandler()
  {
    try
    {
      h localh = this.uploadHandler;
      return localh;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int getCommonQueryTime()
  {
    synchronized (this.queryStateLock)
    {
      int i = this.commonQueryTime;
      return i;
    }
  }
  
  public int getCurrentQueryStep()
  {
    synchronized (this.queryStateLock)
    {
      int i = this.currentQueryStep;
      return i;
    }
  }
  
  public a getStrategy()
  {
    try
    {
      a locala = this.strategy;
      return locala;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public g getStrategyHandler()
  {
    try
    {
      g localg = this.strategyHandler;
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
    synchronized (this.queryStateLock)
    {
      boolean bool = this.atLeastAComQueryEnd;
      return bool;
    }
  }
  
  public boolean isAtLeastAComQuerySuccess()
  {
    synchronized (this.queryStateLock)
    {
      boolean bool = this.atLeastAComQuerySuccess;
      return bool;
    }
  }
  
  public void notifyModuleDetailChanged(int paramInt, Map<String, String> paramMap)
  {
    Iterator localIterator = UserAction.beaconModules.iterator();
    while (localIterator.hasNext()) {
      ((com.tencent.beacon.core.b)localIterator.next()).onModuleStrategyUpdated(paramInt, paramMap);
    }
  }
  
  public void notifyStrategyChanged(a parama)
  {
    Iterator localIterator = UserAction.beaconModules.iterator();
    while (localIterator.hasNext())
    {
      com.tencent.beacon.core.b localb = (com.tencent.beacon.core.b)localIterator.next();
      try
      {
        localb.onStrategyUpdated(parama);
      }
      catch (Throwable localThrowable)
      {
        com.tencent.beacon.core.d.b.a(localThrowable);
        com.tencent.beacon.core.d.b.d("[strategy] error %s", new Object[] { localThrowable.toString() });
      }
    }
  }
  
  public void onFirstStrategyQueryFinished()
  {
    super.onFirstStrategyQueryFinished();
    if (this.mInitHandleListener != null) {
      this.mInitHandleListener.onInitEnd();
    }
  }
  
  public void onSDKInit(Context paramContext)
  {
    super.onSDKInit(paramContext);
    com.tencent.beacon.core.d.b.b("[module] strategy module > TRUE", new Object[0]);
    startQuery();
  }
  
  public void onStrategyQueryFinished()
  {
    super.onStrategyQueryFinished();
    if (this.mInitHandleListener != null) {
      this.mInitHandleListener.onStrategyQuerySuccess();
    }
  }
  
  public void onStrategyUpdated(a parama)
  {
    super.onStrategyUpdated(parama);
    this.strategy.j();
  }
  
  public void setAppFirstRun(boolean paramBoolean)
  {
    try
    {
      this.isAppFirstRun = paramBoolean;
      com.tencent.beacon.core.d.b.f("[strategy] set isFirst: %b", new Object[] { Boolean.valueOf(paramBoolean) });
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
    synchronized (this.queryStateLock)
    {
      this.atLeastAComQueryEnd = paramBoolean;
      return;
    }
  }
  
  public void setAtLeastAComQuerySuccess(boolean paramBoolean)
  {
    synchronized (this.queryStateLock)
    {
      this.atLeastAComQuerySuccess = paramBoolean;
      return;
    }
  }
  
  public void setCommonQueryTime(int paramInt)
  {
    synchronized (this.queryStateLock)
    {
      this.commonQueryTime = paramInt;
      return;
    }
  }
  
  public void setCommonStrategy(a parama)
  {
    try
    {
      this.strategy = parama;
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public void setCurrentQueryStep(int paramInt)
  {
    synchronized (this.queryStateLock)
    {
      this.currentQueryStep = paramInt;
      com.tencent.beacon.core.d.b.f("[strategy] current query step:%d", new Object[] { Integer.valueOf(paramInt) });
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
      if (!this.strategyQueryRunner.a) {
        com.tencent.beacon.core.a.b.b().a(this.strategyQueryRunner);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.beacon.core.strategy.StrategyQueryModule
 * JD-Core Version:    0.7.0.1
 */
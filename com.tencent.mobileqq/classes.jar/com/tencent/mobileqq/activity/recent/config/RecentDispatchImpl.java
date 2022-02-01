package com.tencent.mobileqq.activity.recent.config;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.imcore.proxy.IMCoreAppRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

public class RecentDispatchImpl<T extends IRecentProcessor>
  implements IRecentDispatch<IRecentProcessor>
{
  private static final String TAG = "RecentDispatchImpl";
  protected ArrayList<Class<? extends IRecentProcessor>> classes = new ArrayList();
  protected ArrayList<T> iRecentProcessors = new ArrayList(8);
  private AtomicBoolean sPrepared = new AtomicBoolean(false);
  
  /* Error */
  public void prepare()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +46 -> 51
    //   8: ldc 11
    //   10: iconst_2
    //   11: iconst_4
    //   12: anewarray 5	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: ldc 53
    //   19: aastore
    //   20: dup
    //   21: iconst_1
    //   22: aload_0
    //   23: getfield 39	com/tencent/mobileqq/activity/recent/config/RecentDispatchImpl:sPrepared	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   26: invokevirtual 56	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   29: invokestatic 62	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   32: aastore
    //   33: dup
    //   34: iconst_2
    //   35: ldc 64
    //   37: aastore
    //   38: dup
    //   39: iconst_3
    //   40: aload_0
    //   41: invokevirtual 68	java/lang/Object:getClass	()Ljava/lang/Class;
    //   44: invokevirtual 74	java/lang/Class:getName	()Ljava/lang/String;
    //   47: aastore
    //   48: invokestatic 78	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   51: aload_0
    //   52: getfield 39	com/tencent/mobileqq/activity/recent/config/RecentDispatchImpl:sPrepared	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   55: invokevirtual 56	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   58: istore_1
    //   59: iload_1
    //   60: ifeq +6 -> 66
    //   63: aload_0
    //   64: monitorexit
    //   65: return
    //   66: aload_0
    //   67: invokevirtual 81	com/tencent/mobileqq/activity/recent/config/RecentDispatchImpl:registerCoreProcessor	()V
    //   70: aload_0
    //   71: getfield 32	com/tencent/mobileqq/activity/recent/config/RecentDispatchImpl:classes	Ljava/util/ArrayList;
    //   74: invokevirtual 85	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   77: astore_2
    //   78: aload_2
    //   79: invokeinterface 90 1 0
    //   84: ifeq +70 -> 154
    //   87: aload_2
    //   88: invokeinterface 94 1 0
    //   93: checkcast 70	java/lang/Class
    //   96: astore_3
    //   97: aload_0
    //   98: aload_3
    //   99: invokevirtual 97	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   102: checkcast 99	com/tencent/mobileqq/activity/recent/config/IRecentProcessor
    //   105: invokevirtual 103	com/tencent/mobileqq/activity/recent/config/RecentDispatchImpl:registerBusiness	(Lcom/tencent/mobileqq/activity/recent/config/IRecentProcessor;)V
    //   108: goto -30 -> 78
    //   111: astore_3
    //   112: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   115: ifeq -37 -> 78
    //   118: ldc 11
    //   120: iconst_2
    //   121: ldc 105
    //   123: aload_3
    //   124: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   127: goto -49 -> 78
    //   130: astore_2
    //   131: aload_0
    //   132: monitorexit
    //   133: aload_2
    //   134: athrow
    //   135: astore_3
    //   136: invokestatic 51	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   139: ifeq -61 -> 78
    //   142: ldc 11
    //   144: iconst_2
    //   145: ldc 110
    //   147: aload_3
    //   148: invokestatic 108	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   151: goto -73 -> 78
    //   154: aload_0
    //   155: getfield 39	com/tencent/mobileqq/activity/recent/config/RecentDispatchImpl:sPrepared	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   158: iconst_1
    //   159: invokevirtual 113	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   162: goto -99 -> 63
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	165	0	this	RecentDispatchImpl
    //   58	2	1	bool	boolean
    //   77	11	2	localIterator	Iterator
    //   130	4	2	localObject	Object
    //   96	3	3	localClass	Class
    //   111	13	3	localIllegalAccessException	java.lang.IllegalAccessException
    //   135	13	3	localInstantiationException	java.lang.InstantiationException
    // Exception table:
    //   from	to	target	type
    //   97	108	111	java/lang/IllegalAccessException
    //   2	51	130	finally
    //   51	59	130	finally
    //   66	78	130	finally
    //   78	97	130	finally
    //   97	108	130	finally
    //   112	127	130	finally
    //   136	151	130	finally
    //   154	162	130	finally
    //   97	108	135	java/lang/InstantiationException
  }
  
  public void processor(IMCoreAppRuntime paramIMCoreAppRuntime, RecentBaseData paramRecentBaseData)
  {
    prepare();
    Iterator localIterator = this.iRecentProcessors.iterator();
    while ((localIterator.hasNext()) && (!((IRecentProcessor)localIterator.next()).handleBusiness(paramIMCoreAppRuntime, paramRecentBaseData))) {}
  }
  
  /* Error */
  public void register(Class<? extends IRecentProcessor> paramClass)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 32	com/tencent/mobileqq/activity/recent/config/RecentDispatchImpl:classes	Ljava/util/ArrayList;
    //   6: aload_1
    //   7: invokevirtual 127	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   10: ifeq +51 -> 61
    //   13: getstatic 133	com/tencent/mobileqq/imcore/constants/AppSetting:isDebugVersion	Z
    //   16: ifeq +42 -> 58
    //   19: ldc 11
    //   21: iconst_1
    //   22: new 135	java/lang/RuntimeException
    //   25: dup
    //   26: new 137	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   33: ldc 140
    //   35: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: aload_1
    //   39: invokevirtual 74	java/lang/Class:getName	()Ljava/lang/String;
    //   42: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokespecial 150	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
    //   51: iconst_0
    //   52: anewarray 5	java/lang/Object
    //   55: invokestatic 153	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   58: aload_0
    //   59: monitorexit
    //   60: return
    //   61: aload_0
    //   62: getfield 32	com/tencent/mobileqq/activity/recent/config/RecentDispatchImpl:classes	Ljava/util/ArrayList;
    //   65: aload_1
    //   66: invokevirtual 156	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   69: pop
    //   70: goto -12 -> 58
    //   73: astore_1
    //   74: aload_0
    //   75: monitorexit
    //   76: aload_1
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	RecentDispatchImpl
    //   0	78	1	paramClass	Class<? extends IRecentProcessor>
    // Exception table:
    //   from	to	target	type
    //   2	58	73	finally
    //   61	70	73	finally
  }
  
  protected void registerBusiness(@NonNull T paramT)
  {
    try
    {
      this.iRecentProcessors.add(paramT);
      Collections.sort(this.iRecentProcessors);
      return;
    }
    finally
    {
      paramT = finally;
      throw paramT;
    }
  }
  
  public void registerCoreProcessor() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.RecentDispatchImpl
 * JD-Core Version:    0.7.0.1
 */
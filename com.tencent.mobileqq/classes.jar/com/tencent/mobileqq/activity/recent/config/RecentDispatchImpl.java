package com.tencent.mobileqq.activity.recent.config;

import android.support.annotation.NonNull;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

public class RecentDispatchImpl<T extends IRecentBaseDataProcessor>
  implements IRecentDispatch<IRecentBaseDataProcessor>
{
  protected ArrayList<T> a;
  private AtomicBoolean a;
  protected ArrayList<Class<? extends IRecentBaseDataProcessor>> b = new ArrayList();
  
  public RecentDispatchImpl()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(8);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  }
  
  public void a() {}
  
  public void a(BaseQQAppInterface paramBaseQQAppInterface, RecentBaseData paramRecentBaseData)
  {
    b();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while ((localIterator.hasNext()) && (!((IRecentBaseDataProcessor)localIterator.next()).a(paramBaseQQAppInterface, paramRecentBaseData))) {}
  }
  
  protected void a(@NonNull T paramT)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramT);
      Collections.sort(this.jdField_a_of_type_JavaUtilArrayList);
      return;
    }
    finally
    {
      paramT = finally;
      throw paramT;
    }
  }
  
  /* Error */
  public void a(Class<? extends IRecentBaseDataProcessor> paramClass)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 27	com/tencent/mobileqq/activity/recent/config/RecentDispatchImpl:b	Ljava/util/ArrayList;
    //   6: aload_1
    //   7: invokevirtual 76	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   10: istore_2
    //   11: iload_2
    //   12: ifeq +6 -> 18
    //   15: aload_0
    //   16: monitorexit
    //   17: return
    //   18: aload_0
    //   19: getfield 27	com/tencent/mobileqq/activity/recent/config/RecentDispatchImpl:b	Ljava/util/ArrayList;
    //   22: aload_1
    //   23: invokevirtual 63	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   26: pop
    //   27: goto -12 -> 15
    //   30: astore_1
    //   31: aload_0
    //   32: monitorexit
    //   33: aload_1
    //   34: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	35	0	this	RecentDispatchImpl
    //   0	35	1	paramClass	Class<? extends IRecentBaseDataProcessor>
    //   10	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	11	30	finally
    //   18	27	30	finally
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +46 -> 51
    //   8: ldc 88
    //   10: iconst_2
    //   11: iconst_4
    //   12: anewarray 5	java/lang/Object
    //   15: dup
    //   16: iconst_0
    //   17: ldc 90
    //   19: aastore
    //   20: dup
    //   21: iconst_1
    //   22: aload_0
    //   23: getfield 34	com/tencent/mobileqq/activity/recent/config/RecentDispatchImpl:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   26: invokevirtual 93	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   29: invokestatic 99	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   32: aastore
    //   33: dup
    //   34: iconst_2
    //   35: ldc 101
    //   37: aastore
    //   38: dup
    //   39: iconst_3
    //   40: aload_0
    //   41: invokevirtual 105	java/lang/Object:getClass	()Ljava/lang/Class;
    //   44: invokevirtual 111	java/lang/Class:getName	()Ljava/lang/String;
    //   47: aastore
    //   48: invokestatic 115	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   51: aload_0
    //   52: getfield 34	com/tencent/mobileqq/activity/recent/config/RecentDispatchImpl:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   55: invokevirtual 93	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   58: istore_1
    //   59: iload_1
    //   60: ifeq +6 -> 66
    //   63: aload_0
    //   64: monitorexit
    //   65: return
    //   66: aload_0
    //   67: invokevirtual 117	com/tencent/mobileqq/activity/recent/config/RecentDispatchImpl:a	()V
    //   70: aload_0
    //   71: getfield 27	com/tencent/mobileqq/activity/recent/config/RecentDispatchImpl:b	Ljava/util/ArrayList;
    //   74: invokevirtual 42	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   77: astore_2
    //   78: aload_2
    //   79: invokeinterface 48 1 0
    //   84: ifeq +70 -> 154
    //   87: aload_2
    //   88: invokeinterface 52 1 0
    //   93: checkcast 107	java/lang/Class
    //   96: astore_3
    //   97: aload_0
    //   98: aload_3
    //   99: invokevirtual 120	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   102: checkcast 54	com/tencent/mobileqq/activity/recent/config/IRecentBaseDataProcessor
    //   105: invokevirtual 122	com/tencent/mobileqq/activity/recent/config/RecentDispatchImpl:a	(Lcom/tencent/mobileqq/activity/recent/config/IRecentBaseDataProcessor;)V
    //   108: goto -30 -> 78
    //   111: astore_3
    //   112: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   115: ifeq -37 -> 78
    //   118: ldc 88
    //   120: iconst_2
    //   121: ldc 124
    //   123: aload_3
    //   124: invokestatic 127	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   127: goto -49 -> 78
    //   130: astore_2
    //   131: aload_0
    //   132: monitorexit
    //   133: aload_2
    //   134: athrow
    //   135: astore_3
    //   136: invokestatic 86	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   139: ifeq -61 -> 78
    //   142: ldc 88
    //   144: iconst_2
    //   145: ldc 129
    //   147: aload_3
    //   148: invokestatic 127	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   151: goto -73 -> 78
    //   154: aload_0
    //   155: getfield 34	com/tencent/mobileqq/activity/recent/config/RecentDispatchImpl:jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   158: iconst_1
    //   159: invokevirtual 132	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.config.RecentDispatchImpl
 * JD-Core Version:    0.7.0.1
 */
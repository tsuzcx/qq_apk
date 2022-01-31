package com.tencent.luan.ioc;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

abstract class LuanInjector$ObjectCreator<I, K>
{
  private final ReadWriteLock LOCK = new ReentrantReadWriteLock();
  private final Map<K, Object> SINGLETON_CACHE = new HashMap();
  
  private Object createNormal(LuanInjector paramLuanInjector, I paramI)
  {
    paramI = createByInput(paramLuanInjector, paramI);
    LuanInjector.access$400(paramLuanInjector, paramI);
    return paramI;
  }
  
  /* Error */
  private Object createSingleton(LuanInjector paramLuanInjector, I paramI)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_2
    //   2: invokevirtual 45	com/tencent/luan/ioc/LuanInjector$ObjectCreator:getKey	(Ljava/lang/Object;)Ljava/lang/Object;
    //   5: astore_3
    //   6: aload_0
    //   7: getfield 19	com/tencent/luan/ioc/LuanInjector$ObjectCreator:LOCK	Ljava/util/concurrent/locks/ReadWriteLock;
    //   10: invokeinterface 51 1 0
    //   15: invokeinterface 56 1 0
    //   20: aload_0
    //   21: getfield 24	com/tencent/luan/ioc/LuanInjector$ObjectCreator:SINGLETON_CACHE	Ljava/util/Map;
    //   24: aload_3
    //   25: invokeinterface 61 2 0
    //   30: astore 4
    //   32: aload 4
    //   34: ifnull +20 -> 54
    //   37: aload_0
    //   38: getfield 19	com/tencent/luan/ioc/LuanInjector$ObjectCreator:LOCK	Ljava/util/concurrent/locks/ReadWriteLock;
    //   41: invokeinterface 51 1 0
    //   46: invokeinterface 64 1 0
    //   51: aload 4
    //   53: areturn
    //   54: aload_0
    //   55: getfield 19	com/tencent/luan/ioc/LuanInjector$ObjectCreator:LOCK	Ljava/util/concurrent/locks/ReadWriteLock;
    //   58: invokeinterface 51 1 0
    //   63: invokeinterface 64 1 0
    //   68: aload_0
    //   69: getfield 19	com/tencent/luan/ioc/LuanInjector$ObjectCreator:LOCK	Ljava/util/concurrent/locks/ReadWriteLock;
    //   72: invokeinterface 67 1 0
    //   77: invokeinterface 56 1 0
    //   82: aload_0
    //   83: getfield 24	com/tencent/luan/ioc/LuanInjector$ObjectCreator:SINGLETON_CACHE	Ljava/util/Map;
    //   86: aload_3
    //   87: invokeinterface 61 2 0
    //   92: astore 4
    //   94: aload 4
    //   96: ifnull +37 -> 133
    //   99: aload_0
    //   100: getfield 19	com/tencent/luan/ioc/LuanInjector$ObjectCreator:LOCK	Ljava/util/concurrent/locks/ReadWriteLock;
    //   103: invokeinterface 67 1 0
    //   108: invokeinterface 64 1 0
    //   113: aload 4
    //   115: areturn
    //   116: astore_1
    //   117: aload_0
    //   118: getfield 19	com/tencent/luan/ioc/LuanInjector$ObjectCreator:LOCK	Ljava/util/concurrent/locks/ReadWriteLock;
    //   121: invokeinterface 51 1 0
    //   126: invokeinterface 64 1 0
    //   131: aload_1
    //   132: athrow
    //   133: aload_0
    //   134: aload_1
    //   135: aload_2
    //   136: invokespecial 69	com/tencent/luan/ioc/LuanInjector$ObjectCreator:createNormal	(Lcom/tencent/luan/ioc/LuanInjector;Ljava/lang/Object;)Ljava/lang/Object;
    //   139: astore_1
    //   140: aload_0
    //   141: getfield 24	com/tencent/luan/ioc/LuanInjector$ObjectCreator:SINGLETON_CACHE	Ljava/util/Map;
    //   144: aload_3
    //   145: aload_1
    //   146: invokeinterface 73 3 0
    //   151: pop
    //   152: aload_0
    //   153: getfield 19	com/tencent/luan/ioc/LuanInjector$ObjectCreator:LOCK	Ljava/util/concurrent/locks/ReadWriteLock;
    //   156: invokeinterface 67 1 0
    //   161: invokeinterface 64 1 0
    //   166: aload_1
    //   167: areturn
    //   168: astore_1
    //   169: aload_0
    //   170: getfield 19	com/tencent/luan/ioc/LuanInjector$ObjectCreator:LOCK	Ljava/util/concurrent/locks/ReadWriteLock;
    //   173: invokeinterface 67 1 0
    //   178: invokeinterface 64 1 0
    //   183: aload_1
    //   184: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	185	0	this	ObjectCreator
    //   0	185	1	paramLuanInjector	LuanInjector
    //   0	185	2	paramI	I
    //   5	140	3	localObject1	Object
    //   30	84	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   20	32	116	finally
    //   82	94	168	finally
    //   133	152	168	finally
  }
  
  final Object create(LuanInjector paramLuanInjector, I paramI, boolean paramBoolean)
  {
    if (paramBoolean) {
      return createSingleton(paramLuanInjector, paramI);
    }
    return createNormal(paramLuanInjector, paramI);
  }
  
  abstract Object createByInput(LuanInjector paramLuanInjector, I paramI);
  
  abstract K getKey(I paramI);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.luan.ioc.LuanInjector.ObjectCreator
 * JD-Core Version:    0.7.0.1
 */
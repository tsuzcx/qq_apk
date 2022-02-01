package com.tencent.luan.ioc.wrapper;

import com.tencent.luan.ioc.InjectConstructor;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class GlobalSingletonObjectWrapper<T>
  extends SingletonObjectWrapper<T>
{
  private static final ReadWriteLock LOCK = new ReentrantReadWriteLock();
  private static final Map<String, GlobalSingletonObjectWrapper<?>> SINGLETON_WRAPPER_MAP = new HashMap();
  
  private GlobalSingletonObjectWrapper(InjectConstructor<T> paramInjectConstructor)
  {
    super(paramInjectConstructor);
  }
  
  /* Error */
  public static <T> GlobalSingletonObjectWrapper<T> getInstanceByConstructor(InjectConstructor<T> paramInjectConstructor)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokeinterface 38 1 0
    //   6: astore_1
    //   7: getstatic 19	com/tencent/luan/ioc/wrapper/GlobalSingletonObjectWrapper:LOCK	Ljava/util/concurrent/locks/ReadWriteLock;
    //   10: invokeinterface 44 1 0
    //   15: invokeinterface 49 1 0
    //   20: getstatic 24	com/tencent/luan/ioc/wrapper/GlobalSingletonObjectWrapper:SINGLETON_WRAPPER_MAP	Ljava/util/Map;
    //   23: aload_1
    //   24: invokeinterface 55 2 0
    //   29: checkcast 2	com/tencent/luan/ioc/wrapper/GlobalSingletonObjectWrapper
    //   32: astore_2
    //   33: aload_2
    //   34: ifnull +18 -> 52
    //   37: getstatic 19	com/tencent/luan/ioc/wrapper/GlobalSingletonObjectWrapper:LOCK	Ljava/util/concurrent/locks/ReadWriteLock;
    //   40: invokeinterface 44 1 0
    //   45: invokeinterface 58 1 0
    //   50: aload_2
    //   51: areturn
    //   52: getstatic 19	com/tencent/luan/ioc/wrapper/GlobalSingletonObjectWrapper:LOCK	Ljava/util/concurrent/locks/ReadWriteLock;
    //   55: invokeinterface 44 1 0
    //   60: invokeinterface 58 1 0
    //   65: getstatic 19	com/tencent/luan/ioc/wrapper/GlobalSingletonObjectWrapper:LOCK	Ljava/util/concurrent/locks/ReadWriteLock;
    //   68: invokeinterface 61 1 0
    //   73: invokeinterface 49 1 0
    //   78: getstatic 24	com/tencent/luan/ioc/wrapper/GlobalSingletonObjectWrapper:SINGLETON_WRAPPER_MAP	Ljava/util/Map;
    //   81: aload_1
    //   82: invokeinterface 55 2 0
    //   87: checkcast 2	com/tencent/luan/ioc/wrapper/GlobalSingletonObjectWrapper
    //   90: astore_2
    //   91: aload_2
    //   92: ifnull +18 -> 110
    //   95: getstatic 19	com/tencent/luan/ioc/wrapper/GlobalSingletonObjectWrapper:LOCK	Ljava/util/concurrent/locks/ReadWriteLock;
    //   98: invokeinterface 61 1 0
    //   103: invokeinterface 58 1 0
    //   108: aload_2
    //   109: areturn
    //   110: new 2	com/tencent/luan/ioc/wrapper/GlobalSingletonObjectWrapper
    //   113: dup
    //   114: aload_0
    //   115: invokespecial 62	com/tencent/luan/ioc/wrapper/GlobalSingletonObjectWrapper:<init>	(Lcom/tencent/luan/ioc/InjectConstructor;)V
    //   118: astore_0
    //   119: getstatic 24	com/tencent/luan/ioc/wrapper/GlobalSingletonObjectWrapper:SINGLETON_WRAPPER_MAP	Ljava/util/Map;
    //   122: aload_1
    //   123: aload_0
    //   124: invokeinterface 66 3 0
    //   129: pop
    //   130: getstatic 19	com/tencent/luan/ioc/wrapper/GlobalSingletonObjectWrapper:LOCK	Ljava/util/concurrent/locks/ReadWriteLock;
    //   133: invokeinterface 61 1 0
    //   138: invokeinterface 58 1 0
    //   143: aload_0
    //   144: areturn
    //   145: astore_0
    //   146: getstatic 19	com/tencent/luan/ioc/wrapper/GlobalSingletonObjectWrapper:LOCK	Ljava/util/concurrent/locks/ReadWriteLock;
    //   149: invokeinterface 61 1 0
    //   154: invokeinterface 58 1 0
    //   159: aload_0
    //   160: athrow
    //   161: astore_0
    //   162: getstatic 19	com/tencent/luan/ioc/wrapper/GlobalSingletonObjectWrapper:LOCK	Ljava/util/concurrent/locks/ReadWriteLock;
    //   165: invokeinterface 44 1 0
    //   170: invokeinterface 58 1 0
    //   175: aload_0
    //   176: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	177	0	paramInjectConstructor	InjectConstructor<T>
    //   6	117	1	str	String
    //   32	77	2	localGlobalSingletonObjectWrapper	GlobalSingletonObjectWrapper
    // Exception table:
    //   from	to	target	type
    //   78	91	145	finally
    //   110	130	145	finally
    //   20	33	161	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.luan.ioc.wrapper.GlobalSingletonObjectWrapper
 * JD-Core Version:    0.7.0.1
 */
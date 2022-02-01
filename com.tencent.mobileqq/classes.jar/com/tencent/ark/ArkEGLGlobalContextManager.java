package com.tencent.ark;

final class ArkEGLGlobalContextManager
  extends ArkEGLApplicationContextManagerBase
  implements IArkEGLContextManager
{
  EGLContextHolder _globalContext;
  
  /* Error */
  public EGLContextHolder createContext(String paramString)
  {
    // Byte code:
    //   0: getstatic 19	com/tencent/ark/ArkEGLGlobalContextManager:ENV	Lcom/tencent/ark/ArkEnvironmentManager;
    //   3: ldc 21
    //   5: ldc 23
    //   7: iconst_1
    //   8: anewarray 25	java/lang/Object
    //   11: dup
    //   12: iconst_0
    //   13: aload_1
    //   14: aastore
    //   15: invokestatic 31	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   18: invokevirtual 37	com/tencent/ark/ArkEnvironmentManager:logI	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: aload_0
    //   22: monitorenter
    //   23: aload_0
    //   24: getfield 39	com/tencent/ark/ArkEGLGlobalContextManager:_globalContext	Lcom/tencent/ark/EGLContextHolder;
    //   27: ifnonnull +27 -> 54
    //   30: aload_0
    //   31: invokestatic 43	com/tencent/ark/ArkEGLGlobalContextManager:createOffscreenContext	()Lcom/tencent/ark/EGLContextHolder;
    //   34: putfield 39	com/tencent/ark/ArkEGLGlobalContextManager:_globalContext	Lcom/tencent/ark/EGLContextHolder;
    //   37: aload_0
    //   38: getfield 39	com/tencent/ark/ArkEGLGlobalContextManager:_globalContext	Lcom/tencent/ark/EGLContextHolder;
    //   41: ifnonnull +22 -> 63
    //   44: invokestatic 47	com/tencent/ark/ArkEnvironmentManager:getInstance	()Lcom/tencent/ark/ArkEnvironmentManager;
    //   47: ldc 21
    //   49: ldc 49
    //   51: invokevirtual 52	com/tencent/ark/ArkEnvironmentManager:logE	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: aload_0
    //   55: getfield 39	com/tencent/ark/ArkEGLGlobalContextManager:_globalContext	Lcom/tencent/ark/EGLContextHolder;
    //   58: astore_1
    //   59: aload_0
    //   60: monitorexit
    //   61: aload_1
    //   62: areturn
    //   63: aload_0
    //   64: getfield 39	com/tencent/ark/ArkEGLGlobalContextManager:_globalContext	Lcom/tencent/ark/EGLContextHolder;
    //   67: invokestatic 58	com/tencent/ark/EGLContextHolder:setOffscreenContext	(Lcom/tencent/ark/EGLContextHolder;)V
    //   70: invokestatic 47	com/tencent/ark/ArkEnvironmentManager:getInstance	()Lcom/tencent/ark/ArkEnvironmentManager;
    //   73: ldc 21
    //   75: ldc 60
    //   77: invokevirtual 37	com/tencent/ark/ArkEnvironmentManager:logI	(Ljava/lang/String;Ljava/lang/String;)V
    //   80: goto -26 -> 54
    //   83: astore_1
    //   84: aload_0
    //   85: monitorexit
    //   86: aload_1
    //   87: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	88	0	this	ArkEGLGlobalContextManager
    //   0	88	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   23	54	83	finally
    //   54	61	83	finally
    //   63	80	83	finally
    //   84	86	83	finally
  }
  
  public EGLContextHolder getContext(String paramString)
  {
    try
    {
      paramString = this._globalContext;
      return paramString;
    }
    finally {}
  }
  
  public boolean releaseContext(String paramString)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ark.ArkEGLGlobalContextManager
 * JD-Core Version:    0.7.0.1
 */
package com.eclipsesource.mmv8.utils;

import com.eclipsesource.mmv8.V8;

public class V8Thread
  extends Thread
{
  private V8 runtime;
  private final V8Runnable target;
  
  public V8Thread(V8Runnable paramV8Runnable)
  {
    this.target = paramV8Runnable;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 23	com/eclipsesource/mmv8/V8:createV8Runtime	()Lcom/eclipsesource/mmv8/V8;
    //   4: putfield 25	com/eclipsesource/mmv8/utils/V8Thread:runtime	Lcom/eclipsesource/mmv8/V8;
    //   7: aload_0
    //   8: getfield 15	com/eclipsesource/mmv8/utils/V8Thread:target	Lcom/eclipsesource/mmv8/utils/V8Runnable;
    //   11: aload_0
    //   12: getfield 25	com/eclipsesource/mmv8/utils/V8Thread:runtime	Lcom/eclipsesource/mmv8/V8;
    //   15: invokeinterface 30 2 0
    //   20: aload_0
    //   21: monitorenter
    //   22: aload_0
    //   23: getfield 25	com/eclipsesource/mmv8/utils/V8Thread:runtime	Lcom/eclipsesource/mmv8/V8;
    //   26: invokevirtual 34	com/eclipsesource/mmv8/V8:getLocker	()Lcom/eclipsesource/mmv8/V8Locker;
    //   29: invokevirtual 40	com/eclipsesource/mmv8/V8Locker:hasLock	()Z
    //   32: ifeq +15 -> 47
    //   35: aload_0
    //   36: getfield 25	com/eclipsesource/mmv8/utils/V8Thread:runtime	Lcom/eclipsesource/mmv8/V8;
    //   39: invokevirtual 43	com/eclipsesource/mmv8/V8:release	()V
    //   42: aload_0
    //   43: aconst_null
    //   44: putfield 25	com/eclipsesource/mmv8/utils/V8Thread:runtime	Lcom/eclipsesource/mmv8/V8;
    //   47: aload_0
    //   48: monitorexit
    //   49: return
    //   50: astore_1
    //   51: aload_0
    //   52: monitorexit
    //   53: aload_1
    //   54: athrow
    //   55: astore_1
    //   56: aload_0
    //   57: monitorenter
    //   58: aload_0
    //   59: getfield 25	com/eclipsesource/mmv8/utils/V8Thread:runtime	Lcom/eclipsesource/mmv8/V8;
    //   62: invokevirtual 34	com/eclipsesource/mmv8/V8:getLocker	()Lcom/eclipsesource/mmv8/V8Locker;
    //   65: invokevirtual 40	com/eclipsesource/mmv8/V8Locker:hasLock	()Z
    //   68: ifeq +15 -> 83
    //   71: aload_0
    //   72: getfield 25	com/eclipsesource/mmv8/utils/V8Thread:runtime	Lcom/eclipsesource/mmv8/V8;
    //   75: invokevirtual 43	com/eclipsesource/mmv8/V8:release	()V
    //   78: aload_0
    //   79: aconst_null
    //   80: putfield 25	com/eclipsesource/mmv8/utils/V8Thread:runtime	Lcom/eclipsesource/mmv8/V8;
    //   83: aload_0
    //   84: monitorexit
    //   85: aload_1
    //   86: athrow
    //   87: astore_1
    //   88: aload_0
    //   89: monitorexit
    //   90: aload_1
    //   91: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	92	0	this	V8Thread
    //   50	4	1	localObject1	java.lang.Object
    //   55	31	1	localObject2	java.lang.Object
    //   87	4	1	localObject3	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   22	47	50	finally
    //   47	49	50	finally
    //   51	53	50	finally
    //   7	20	55	finally
    //   58	83	87	finally
    //   83	85	87	finally
    //   88	90	87	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.eclipsesource.mmv8.utils.V8Thread
 * JD-Core Version:    0.7.0.1
 */
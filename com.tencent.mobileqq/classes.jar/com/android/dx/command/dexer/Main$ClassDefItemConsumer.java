package com.android.dx.command.dexer;

import com.android.dx.dex.file.ClassDefItem;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

class Main$ClassDefItemConsumer
  implements Callable<Boolean>
{
  Future<ClassDefItem> futureClazz;
  int maxFieldIdsInClass;
  int maxMethodIdsInClass;
  String name;
  
  private Main$ClassDefItemConsumer(String paramString, Future<ClassDefItem> paramFuture, int paramInt1, int paramInt2)
  {
    this.name = paramString;
    this.futureClazz = paramFuture;
    this.maxMethodIdsInClass = paramInt1;
    this.maxFieldIdsInClass = paramInt2;
  }
  
  /* Error */
  public Boolean call()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 24	com/android/dx/command/dexer/Main$ClassDefItemConsumer:futureClazz	Ljava/util/concurrent/Future;
    //   4: invokeinterface 44 1 0
    //   9: checkcast 46	com/android/dx/dex/file/ClassDefItem
    //   12: astore_1
    //   13: aload_1
    //   14: ifnull +12 -> 26
    //   17: aload_1
    //   18: invokestatic 52	com/android/dx/command/dexer/Main:access$2800	(Lcom/android/dx/dex/file/ClassDefItem;)Z
    //   21: pop
    //   22: iconst_1
    //   23: invokestatic 56	com/android/dx/command/dexer/Main:access$2900	(Z)V
    //   26: iconst_1
    //   27: invokestatic 62	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   30: astore_2
    //   31: invokestatic 66	com/android/dx/command/dexer/Main:access$1300	()Lcom/android/dx/command/dexer/Main$Arguments;
    //   34: getfield 72	com/android/dx/command/dexer/Main$Arguments:multiDex	Z
    //   37: ifeq +126 -> 163
    //   40: invokestatic 75	com/android/dx/command/dexer/Main:access$1600	()Ljava/lang/Object;
    //   43: astore_1
    //   44: aload_1
    //   45: monitorenter
    //   46: invokestatic 79	com/android/dx/command/dexer/Main:access$1800	()I
    //   49: aload_0
    //   50: getfield 26	com/android/dx/command/dexer/Main$ClassDefItemConsumer:maxMethodIdsInClass	I
    //   53: isub
    //   54: invokestatic 83	com/android/dx/command/dexer/Main:access$1802	(I)I
    //   57: pop
    //   58: invokestatic 86	com/android/dx/command/dexer/Main:access$2000	()I
    //   61: aload_0
    //   62: getfield 28	com/android/dx/command/dexer/Main$ClassDefItemConsumer:maxFieldIdsInClass	I
    //   65: isub
    //   66: invokestatic 89	com/android/dx/command/dexer/Main:access$2002	(I)I
    //   69: pop
    //   70: invokestatic 75	com/android/dx/command/dexer/Main:access$1600	()Ljava/lang/Object;
    //   73: invokevirtual 92	java/lang/Object:notifyAll	()V
    //   76: aload_1
    //   77: monitorexit
    //   78: aload_2
    //   79: areturn
    //   80: astore_2
    //   81: aload_1
    //   82: monitorexit
    //   83: aload_2
    //   84: athrow
    //   85: astore_1
    //   86: aload_1
    //   87: invokevirtual 96	java/util/concurrent/ExecutionException:getCause	()Ljava/lang/Throwable;
    //   90: astore_2
    //   91: aload_2
    //   92: instanceof 98
    //   95: ifeq +60 -> 155
    //   98: aload_2
    //   99: checkcast 98	java/lang/Exception
    //   102: astore_1
    //   103: aload_1
    //   104: athrow
    //   105: astore_2
    //   106: invokestatic 66	com/android/dx/command/dexer/Main:access$1300	()Lcom/android/dx/command/dexer/Main$Arguments;
    //   109: getfield 72	com/android/dx/command/dexer/Main$Arguments:multiDex	Z
    //   112: ifeq +41 -> 153
    //   115: invokestatic 75	com/android/dx/command/dexer/Main:access$1600	()Ljava/lang/Object;
    //   118: astore_1
    //   119: aload_1
    //   120: monitorenter
    //   121: invokestatic 79	com/android/dx/command/dexer/Main:access$1800	()I
    //   124: aload_0
    //   125: getfield 26	com/android/dx/command/dexer/Main$ClassDefItemConsumer:maxMethodIdsInClass	I
    //   128: isub
    //   129: invokestatic 83	com/android/dx/command/dexer/Main:access$1802	(I)I
    //   132: pop
    //   133: invokestatic 86	com/android/dx/command/dexer/Main:access$2000	()I
    //   136: aload_0
    //   137: getfield 28	com/android/dx/command/dexer/Main$ClassDefItemConsumer:maxFieldIdsInClass	I
    //   140: isub
    //   141: invokestatic 89	com/android/dx/command/dexer/Main:access$2002	(I)I
    //   144: pop
    //   145: invokestatic 75	com/android/dx/command/dexer/Main:access$1600	()Ljava/lang/Object;
    //   148: invokevirtual 92	java/lang/Object:notifyAll	()V
    //   151: aload_1
    //   152: monitorexit
    //   153: aload_2
    //   154: athrow
    //   155: goto -52 -> 103
    //   158: astore_2
    //   159: aload_1
    //   160: monitorexit
    //   161: aload_2
    //   162: athrow
    //   163: aload_2
    //   164: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	165	0	this	ClassDefItemConsumer
    //   12	70	1	localObject1	Object
    //   85	2	1	localExecutionException	java.util.concurrent.ExecutionException
    //   102	58	1	localObject2	Object
    //   30	49	2	localBoolean1	Boolean
    //   80	4	2	localObject3	Object
    //   90	9	2	localThrowable	java.lang.Throwable
    //   105	49	2	localObject4	Object
    //   158	6	2	localBoolean2	Boolean
    // Exception table:
    //   from	to	target	type
    //   46	78	80	finally
    //   81	83	80	finally
    //   0	13	85	java/util/concurrent/ExecutionException
    //   17	26	85	java/util/concurrent/ExecutionException
    //   26	31	85	java/util/concurrent/ExecutionException
    //   0	13	105	finally
    //   17	26	105	finally
    //   26	31	105	finally
    //   86	103	105	finally
    //   103	105	105	finally
    //   121	153	158	finally
    //   159	161	158	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.command.dexer.Main.ClassDefItemConsumer
 * JD-Core Version:    0.7.0.1
 */
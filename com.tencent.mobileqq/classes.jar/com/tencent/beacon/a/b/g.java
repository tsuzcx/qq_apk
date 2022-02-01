package com.tencent.beacon.a.b;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public final class g
  implements ThreadFactory
{
  private final AtomicInteger a = new AtomicInteger(1);
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("beacon-thread-");
    localStringBuilder.append(this.a.getAndIncrement());
    return localStringBuilder.toString();
  }
  
  /* Error */
  public java.lang.Thread newThread(@android.support.annotation.NonNull java.lang.Runnable paramRunnable)
  {
    // Byte code:
    //   0: new 49	java/lang/Thread
    //   3: dup
    //   4: aload_1
    //   5: aload_0
    //   6: invokevirtual 51	com/tencent/beacon/a/b/g:a	()Ljava/lang/String;
    //   9: invokespecial 54	java/lang/Thread:<init>	(Ljava/lang/Runnable;Ljava/lang/String;)V
    //   12: astore_1
    //   13: aload_1
    //   14: areturn
    //   15: ldc 56
    //   17: iconst_0
    //   18: anewarray 4	java/lang/Object
    //   21: invokestatic 62	com/tencent/beacon/base/util/c:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   24: goto +8 -> 32
    //   27: astore_1
    //   28: aload_1
    //   29: invokestatic 65	com/tencent/beacon/base/util/c:a	(Ljava/lang/Throwable;)V
    //   32: aconst_null
    //   33: areturn
    //   34: astore_1
    //   35: goto -20 -> 15
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	38	0	this	g
    //   0	38	1	paramRunnable	java.lang.Runnable
    // Exception table:
    //   from	to	target	type
    //   0	13	27	java/lang/Exception
    //   0	13	34	java/lang/OutOfMemoryError
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.a.b.g
 * JD-Core Version:    0.7.0.1
 */
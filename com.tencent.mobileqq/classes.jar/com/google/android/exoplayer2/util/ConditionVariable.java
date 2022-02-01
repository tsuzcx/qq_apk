package com.google.android.exoplayer2.util;

import android.os.SystemClock;

public final class ConditionVariable
{
  private boolean isOpen;
  
  public void block()
  {
    try
    {
      if (!this.isOpen) {
        wait();
      }
      return;
    }
    finally {}
  }
  
  public boolean block(long paramLong)
  {
    try
    {
      long l1 = SystemClock.elapsedRealtime();
      long l2 = l1 + paramLong;
      for (paramLong = l1; (!this.isOpen) && (paramLong < l2); paramLong = SystemClock.elapsedRealtime()) {
        wait(l2 - paramLong);
      }
      boolean bool = this.isOpen;
      return bool;
    }
    finally {}
  }
  
  public boolean close()
  {
    try
    {
      boolean bool = this.isOpen;
      this.isOpen = false;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public boolean open()
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 14	com/google/android/exoplayer2/util/ConditionVariable:isOpen	Z
    //   8: istore_2
    //   9: iload_2
    //   10: ifeq +9 -> 19
    //   13: iconst_0
    //   14: istore_1
    //   15: aload_0
    //   16: monitorexit
    //   17: iload_1
    //   18: ireturn
    //   19: aload_0
    //   20: iconst_1
    //   21: putfield 14	com/google/android/exoplayer2/util/ConditionVariable:isOpen	Z
    //   24: aload_0
    //   25: invokevirtual 33	java/lang/Object:notifyAll	()V
    //   28: goto -13 -> 15
    //   31: astore_3
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_3
    //   35: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	36	0	this	ConditionVariable
    //   1	17	1	bool1	boolean
    //   8	2	2	bool2	boolean
    //   31	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   4	9	31	finally
    //   19	28	31	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.util.ConditionVariable
 * JD-Core Version:    0.7.0.1
 */
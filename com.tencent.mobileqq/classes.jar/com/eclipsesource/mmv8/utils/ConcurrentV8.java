package com.eclipsesource.mmv8.utils;

import com.eclipsesource.mmv8.V8;
import com.eclipsesource.mmv8.V8Locker;

public final class ConcurrentV8
{
  private V8 v8 = null;
  
  public ConcurrentV8()
  {
    this.v8.getLocker().release();
  }
  
  public V8 getV8()
  {
    return this.v8;
  }
  
  public void release()
  {
    V8 localV8 = this.v8;
    if ((localV8 != null) && (!localV8.isReleased())) {
      run(new ConcurrentV8.1(this));
    }
  }
  
  /* Error */
  public void run(V8Runnable paramV8Runnable)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 12	com/eclipsesource/mmv8/utils/ConcurrentV8:v8	Lcom/eclipsesource/mmv8/V8;
    //   6: invokevirtual 22	com/eclipsesource/mmv8/V8:getLocker	()Lcom/eclipsesource/mmv8/V8Locker;
    //   9: invokevirtual 45	com/eclipsesource/mmv8/V8Locker:acquire	()V
    //   12: aload_1
    //   13: aload_0
    //   14: getfield 12	com/eclipsesource/mmv8/utils/ConcurrentV8:v8	Lcom/eclipsesource/mmv8/V8;
    //   17: invokeinterface 50 2 0
    //   22: aload_0
    //   23: getfield 12	com/eclipsesource/mmv8/utils/ConcurrentV8:v8	Lcom/eclipsesource/mmv8/V8;
    //   26: ifnull +36 -> 62
    //   29: aload_0
    //   30: getfield 12	com/eclipsesource/mmv8/utils/ConcurrentV8:v8	Lcom/eclipsesource/mmv8/V8;
    //   33: invokevirtual 22	com/eclipsesource/mmv8/V8:getLocker	()Lcom/eclipsesource/mmv8/V8Locker;
    //   36: ifnull +26 -> 62
    //   39: aload_0
    //   40: getfield 12	com/eclipsesource/mmv8/utils/ConcurrentV8:v8	Lcom/eclipsesource/mmv8/V8;
    //   43: invokevirtual 22	com/eclipsesource/mmv8/V8:getLocker	()Lcom/eclipsesource/mmv8/V8Locker;
    //   46: invokevirtual 53	com/eclipsesource/mmv8/V8Locker:hasLock	()Z
    //   49: ifeq +13 -> 62
    //   52: aload_0
    //   53: getfield 12	com/eclipsesource/mmv8/utils/ConcurrentV8:v8	Lcom/eclipsesource/mmv8/V8;
    //   56: invokevirtual 22	com/eclipsesource/mmv8/V8:getLocker	()Lcom/eclipsesource/mmv8/V8Locker;
    //   59: invokevirtual 27	com/eclipsesource/mmv8/V8Locker:release	()V
    //   62: aload_0
    //   63: monitorexit
    //   64: return
    //   65: astore_1
    //   66: aload_0
    //   67: getfield 12	com/eclipsesource/mmv8/utils/ConcurrentV8:v8	Lcom/eclipsesource/mmv8/V8;
    //   70: ifnull +36 -> 106
    //   73: aload_0
    //   74: getfield 12	com/eclipsesource/mmv8/utils/ConcurrentV8:v8	Lcom/eclipsesource/mmv8/V8;
    //   77: invokevirtual 22	com/eclipsesource/mmv8/V8:getLocker	()Lcom/eclipsesource/mmv8/V8Locker;
    //   80: ifnull +26 -> 106
    //   83: aload_0
    //   84: getfield 12	com/eclipsesource/mmv8/utils/ConcurrentV8:v8	Lcom/eclipsesource/mmv8/V8;
    //   87: invokevirtual 22	com/eclipsesource/mmv8/V8:getLocker	()Lcom/eclipsesource/mmv8/V8Locker;
    //   90: invokevirtual 53	com/eclipsesource/mmv8/V8Locker:hasLock	()Z
    //   93: ifeq +13 -> 106
    //   96: aload_0
    //   97: getfield 12	com/eclipsesource/mmv8/utils/ConcurrentV8:v8	Lcom/eclipsesource/mmv8/V8;
    //   100: invokevirtual 22	com/eclipsesource/mmv8/V8:getLocker	()Lcom/eclipsesource/mmv8/V8Locker;
    //   103: invokevirtual 27	com/eclipsesource/mmv8/V8Locker:release	()V
    //   106: aload_1
    //   107: athrow
    //   108: astore_1
    //   109: aload_0
    //   110: monitorexit
    //   111: aload_1
    //   112: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	113	0	this	ConcurrentV8
    //   0	113	1	paramV8Runnable	V8Runnable
    // Exception table:
    //   from	to	target	type
    //   2	22	65	finally
    //   22	62	108	finally
    //   66	106	108	finally
    //   106	108	108	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.eclipsesource.mmv8.utils.ConcurrentV8
 * JD-Core Version:    0.7.0.1
 */
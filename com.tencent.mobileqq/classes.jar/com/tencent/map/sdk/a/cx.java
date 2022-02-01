package com.tencent.map.sdk.a;

public final class cx
  implements cb, cv
{
  private static cx a = new cx();
  private cv b;
  private cb c;
  private boolean d = false;
  
  public static cx e()
  {
    return a;
  }
  
  public final void a()
  {
    this.b.a();
  }
  
  public final void a(int paramInt)
  {
    this.b.a(paramInt);
  }
  
  public final void a(cb paramcb)
  {
    this.c = paramcb;
  }
  
  public final void a(String paramString1, String paramString2)
  {
    this.c.a(paramString1, paramString2);
  }
  
  public final void a(String paramString1, byte[] paramArrayOfByte, String paramString2)
  {
    this.c.a(paramString1, paramArrayOfByte, paramString2);
  }
  
  public final void b()
  {
    this.b.b();
  }
  
  public final void c()
  {
    this.c.c();
  }
  
  /* Error */
  public final void d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 27	com/tencent/map/sdk/a/cx:d	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: invokestatic 54	com/tencent/map/sdk/a/cn:c	()Lcom/tencent/map/sdk/a/cn;
    //   18: putfield 31	com/tencent/map/sdk/a/cx:b	Lcom/tencent/map/sdk/a/cv;
    //   21: aload_0
    //   22: getfield 31	com/tencent/map/sdk/a/cx:b	Lcom/tencent/map/sdk/a/cv;
    //   25: ifnull +22 -> 47
    //   28: aload_0
    //   29: getfield 31	com/tencent/map/sdk/a/cx:b	Lcom/tencent/map/sdk/a/cv;
    //   32: aload_0
    //   33: invokeinterface 56 2 0
    //   38: aload_0
    //   39: getfield 31	com/tencent/map/sdk/a/cx:b	Lcom/tencent/map/sdk/a/cv;
    //   42: invokeinterface 58 1 0
    //   47: aload_0
    //   48: iconst_1
    //   49: putfield 27	com/tencent/map/sdk/a/cx:d	Z
    //   52: goto -41 -> 11
    //   55: astore_2
    //   56: aload_0
    //   57: monitorexit
    //   58: aload_2
    //   59: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	60	0	this	cx
    //   6	2	1	bool	boolean
    //   55	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	55	finally
    //   14	47	55	finally
    //   47	52	55	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.map.sdk.a.cx
 * JD-Core Version:    0.7.0.1
 */
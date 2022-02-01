package com.tencent.beacon.core.info;

import android.content.Context;
import com.tencent.beacon.core.e.d;
import com.tencent.beacon.upload.TunnelInfo;
import java.util.HashMap;
import java.util.Map;

public class g
  extends b
{
  private static volatile g q;
  private Context r;
  private Map<String, TunnelInfo> s = new HashMap();
  private String t = "";
  
  public g(Context paramContext)
  {
    super(paramContext);
    this.r = paramContext;
  }
  
  public static g b(Context paramContext)
  {
    if (q == null) {}
    try
    {
      if (q == null) {
        q = new g(paramContext);
      }
      return q;
    }
    finally {}
  }
  
  /* Error */
  public String a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 44	com/tencent/beacon/core/e/j:c	(Ljava/lang/String;)Z
    //   6: ifne +40 -> 46
    //   9: aload_0
    //   10: getfield 24	com/tencent/beacon/core/info/g:s	Ljava/util/Map;
    //   13: aload_1
    //   14: invokeinterface 50 2 0
    //   19: checkcast 52	com/tencent/beacon/upload/TunnelInfo
    //   22: astore_2
    //   23: aload_2
    //   24: ifnull +22 -> 46
    //   27: aload_2
    //   28: getfield 55	com/tencent/beacon/upload/TunnelInfo:version	Ljava/lang/String;
    //   31: invokestatic 44	com/tencent/beacon/core/e/j:c	(Ljava/lang/String;)Z
    //   34: ifne +12 -> 46
    //   37: aload_2
    //   38: getfield 55	com/tencent/beacon/upload/TunnelInfo:version	Ljava/lang/String;
    //   41: astore_1
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_1
    //   45: areturn
    //   46: aload_0
    //   47: getfield 30	com/tencent/beacon/core/info/g:r	Landroid/content/Context;
    //   50: invokestatic 58	com/tencent/beacon/core/info/b:b	(Landroid/content/Context;)Lcom/tencent/beacon/core/info/b;
    //   53: aload_1
    //   54: invokevirtual 60	com/tencent/beacon/core/info/b:a	(Ljava/lang/String;)Ljava/lang/String;
    //   57: astore_1
    //   58: goto -16 -> 42
    //   61: astore_1
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_1
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	g
    //   0	66	1	paramString	String
    //   22	16	2	localTunnelInfo	TunnelInfo
    // Exception table:
    //   from	to	target	type
    //   2	23	61	finally
    //   27	42	61	finally
    //   46	58	61	finally
  }
  
  public void a(String paramString, TunnelInfo paramTunnelInfo)
  {
    try
    {
      this.s.put(paramString, paramTunnelInfo);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  public String b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 44	com/tencent/beacon/core/e/j:c	(Ljava/lang/String;)Z
    //   6: ifne +40 -> 46
    //   9: aload_0
    //   10: getfield 24	com/tencent/beacon/core/info/g:s	Ljava/util/Map;
    //   13: aload_1
    //   14: invokeinterface 50 2 0
    //   19: checkcast 52	com/tencent/beacon/upload/TunnelInfo
    //   22: astore_2
    //   23: aload_2
    //   24: ifnull +22 -> 46
    //   27: aload_2
    //   28: getfield 68	com/tencent/beacon/upload/TunnelInfo:channel	Ljava/lang/String;
    //   31: invokestatic 44	com/tencent/beacon/core/e/j:c	(Ljava/lang/String;)Z
    //   34: ifne +12 -> 46
    //   37: aload_2
    //   38: getfield 68	com/tencent/beacon/upload/TunnelInfo:channel	Ljava/lang/String;
    //   41: astore_1
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_1
    //   45: areturn
    //   46: aload_0
    //   47: getfield 30	com/tencent/beacon/core/info/g:r	Landroid/content/Context;
    //   50: invokestatic 58	com/tencent/beacon/core/info/b:b	(Landroid/content/Context;)Lcom/tencent/beacon/core/info/b;
    //   53: aload_1
    //   54: invokevirtual 70	com/tencent/beacon/core/info/b:b	(Ljava/lang/String;)Ljava/lang/String;
    //   57: astore_1
    //   58: goto -16 -> 42
    //   61: astore_1
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_1
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	g
    //   0	66	1	paramString	String
    //   22	16	2	localTunnelInfo	TunnelInfo
    // Exception table:
    //   from	to	target	type
    //   2	23	61	finally
    //   27	42	61	finally
    //   46	58	61	finally
  }
  
  public String d()
  {
    try
    {
      String str = b.b(this.r).d();
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void d(String paramString)
  {
    if (paramString != null)
    {
      this.t = paramString;
      d.a("[core] -> JavaScript clientID:" + this.t, new Object[0]);
    }
  }
  
  public long j()
  {
    try
    {
      long l = b.b(this.r).j();
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String l()
  {
    try
    {
      String str = this.t;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.info.g
 * JD-Core Version:    0.7.0.1
 */
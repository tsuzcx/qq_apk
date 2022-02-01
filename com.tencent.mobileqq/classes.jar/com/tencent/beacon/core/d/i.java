package com.tencent.beacon.core.d;

import android.content.Context;
import com.tencent.beacon.core.b.a;
import com.tencent.beacon.core.e.d;
import com.tencent.beacon.core.e.j;
import com.tencent.beacon.upload.UploadStrategy;
import java.util.LinkedHashMap;
import java.util.Map;

public class i
{
  private static volatile i a;
  private static final Map<String, String> b = new LinkedHashMap();
  private final Context c;
  private boolean d = false;
  private boolean e = false;
  private boolean f = UploadStrategy.defaultUploadErrorEnable;
  
  private i(Context paramContext)
  {
    this.c = paramContext;
  }
  
  public static i a()
  {
    try
    {
      i locali = a;
      return locali;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static i a(Context paramContext)
  {
    try
    {
      if (a == null) {
        a = new i(paramContext);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  private void b()
  {
    for (;;)
    {
      try
      {
        boolean bool = this.d;
        if (bool) {
          return;
        }
        if (j.c((String)b.get("uin")))
        {
          com.tencent.beacon.core.a.f localf = com.tencent.beacon.core.a.f.a(this.c);
          String str2 = localf.a("QIMEI_DENGTA", "");
          String str1 = str2;
          if (str2.isEmpty()) {
            str1 = localf.a("qimei_v2", "");
          }
          b.put("uin", str1);
        }
        else
        {
          this.d = true;
        }
      }
      finally {}
    }
  }
  
  /* Error */
  private void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 31	com/tencent/beacon/core/d/i:e	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: getstatic 24	com/tencent/beacon/core/d/i:b	Ljava/util/Map;
    //   17: ldc 85
    //   19: ldc 87
    //   21: invokeinterface 83 3 0
    //   26: pop
    //   27: getstatic 24	com/tencent/beacon/core/d/i:b	Ljava/util/Map;
    //   30: ldc 89
    //   32: ldc 91
    //   34: invokeinterface 83 3 0
    //   39: pop
    //   40: getstatic 24	com/tencent/beacon/core/d/i:b	Ljava/util/Map;
    //   43: ldc 93
    //   45: ldc 70
    //   47: invokeinterface 83 3 0
    //   52: pop
    //   53: getstatic 24	com/tencent/beacon/core/d/i:b	Ljava/util/Map;
    //   56: ldc 95
    //   58: ldc 97
    //   60: invokeinterface 83 3 0
    //   65: pop
    //   66: getstatic 24	com/tencent/beacon/core/d/i:b	Ljava/util/Map;
    //   69: ldc 48
    //   71: aload_0
    //   72: getfield 40	com/tencent/beacon/core/d/i:c	Landroid/content/Context;
    //   75: invokestatic 66	com/tencent/beacon/core/a/f:a	(Landroid/content/Context;)Lcom/tencent/beacon/core/a/f;
    //   78: ldc 68
    //   80: ldc 70
    //   82: invokevirtual 73	com/tencent/beacon/core/a/f:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   85: invokeinterface 83 3 0
    //   90: pop
    //   91: getstatic 24	com/tencent/beacon/core/d/i:b	Ljava/util/Map;
    //   94: ldc 99
    //   96: new 101	java/lang/StringBuilder
    //   99: dup
    //   100: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   103: aload_0
    //   104: getfield 40	com/tencent/beacon/core/d/i:c	Landroid/content/Context;
    //   107: invokestatic 107	com/tencent/beacon/core/info/e:d	(Landroid/content/Context;)Lcom/tencent/beacon/core/info/e;
    //   110: invokevirtual 110	com/tencent/beacon/core/info/e:d	()Ljava/lang/String;
    //   113: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: ldc 116
    //   118: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: aload_0
    //   122: getfield 40	com/tencent/beacon/core/d/i:c	Landroid/content/Context;
    //   125: invokestatic 107	com/tencent/beacon/core/info/e:d	(Landroid/content/Context;)Lcom/tencent/beacon/core/info/e;
    //   128: invokevirtual 119	com/tencent/beacon/core/info/e:h	()Ljava/lang/String;
    //   131: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: invokeinterface 83 3 0
    //   142: pop
    //   143: getstatic 24	com/tencent/beacon/core/d/i:b	Ljava/util/Map;
    //   146: ldc 124
    //   148: aload_0
    //   149: getfield 40	com/tencent/beacon/core/d/i:c	Landroid/content/Context;
    //   152: invokestatic 107	com/tencent/beacon/core/info/e:d	(Landroid/content/Context;)Lcom/tencent/beacon/core/info/e;
    //   155: invokevirtual 127	com/tencent/beacon/core/info/e:n	()Ljava/lang/String;
    //   158: invokeinterface 83 3 0
    //   163: pop
    //   164: getstatic 24	com/tencent/beacon/core/d/i:b	Ljava/util/Map;
    //   167: ldc 129
    //   169: ldc 70
    //   171: invokeinterface 83 3 0
    //   176: pop
    //   177: getstatic 24	com/tencent/beacon/core/d/i:b	Ljava/util/Map;
    //   180: ldc 131
    //   182: ldc 70
    //   184: invokeinterface 83 3 0
    //   189: pop
    //   190: getstatic 24	com/tencent/beacon/core/d/i:b	Ljava/util/Map;
    //   193: ldc 133
    //   195: aload_0
    //   196: getfield 40	com/tencent/beacon/core/d/i:c	Landroid/content/Context;
    //   199: invokestatic 138	com/tencent/beacon/core/info/a:a	(Landroid/content/Context;)Ljava/lang/String;
    //   202: invokeinterface 83 3 0
    //   207: pop
    //   208: getstatic 24	com/tencent/beacon/core/d/i:b	Ljava/util/Map;
    //   211: astore_2
    //   212: aload_0
    //   213: getfield 40	com/tencent/beacon/core/d/i:c	Landroid/content/Context;
    //   216: invokestatic 143	com/tencent/beacon/core/info/b:b	(Landroid/content/Context;)Lcom/tencent/beacon/core/info/b;
    //   219: pop
    //   220: aload_2
    //   221: ldc 145
    //   223: invokestatic 148	com/tencent/beacon/core/info/b:i	()Ljava/lang/String;
    //   226: invokeinterface 83 3 0
    //   231: pop
    //   232: getstatic 24	com/tencent/beacon/core/d/i:b	Ljava/util/Map;
    //   235: ldc 150
    //   237: aload_0
    //   238: getfield 40	com/tencent/beacon/core/d/i:c	Landroid/content/Context;
    //   241: invokestatic 143	com/tencent/beacon/core/info/b:b	(Landroid/content/Context;)Lcom/tencent/beacon/core/info/b;
    //   244: invokevirtual 152	com/tencent/beacon/core/info/b:a	()Ljava/lang/String;
    //   247: invokeinterface 83 3 0
    //   252: pop
    //   253: getstatic 24	com/tencent/beacon/core/d/i:b	Ljava/util/Map;
    //   256: ldc 154
    //   258: ldc 70
    //   260: invokeinterface 83 3 0
    //   265: pop
    //   266: aload_0
    //   267: iconst_1
    //   268: putfield 31	com/tencent/beacon/core/d/i:e	Z
    //   271: goto -260 -> 11
    //   274: astore_2
    //   275: aload_0
    //   276: monitorexit
    //   277: aload_2
    //   278: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	279	0	this	i
    //   6	2	1	bool	boolean
    //   211	10	2	localMap	Map
    //   274	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	274	finally
    //   14	271	274	finally
  }
  
  /* Error */
  public void a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 159	com/tencent/beacon/core/e/d:a	()Z
    //   5: ifeq +11 -> 16
    //   8: aload_0
    //   9: iconst_0
    //   10: putfield 38	com/tencent/beacon/core/d/i:f	Z
    //   13: aload_0
    //   14: monitorexit
    //   15: return
    //   16: iconst_1
    //   17: iload_1
    //   18: invokestatic 164	com/tencent/beacon/core/e/b:a	(II)Z
    //   21: ifeq +8 -> 29
    //   24: aload_0
    //   25: iconst_1
    //   26: putfield 38	com/tencent/beacon/core/d/i:f	Z
    //   29: aload_0
    //   30: getfield 38	com/tencent/beacon/core/d/i:f	Z
    //   33: ifeq -20 -> 13
    //   36: aload_0
    //   37: invokespecial 166	com/tencent/beacon/core/d/i:c	()V
    //   40: goto -27 -> 13
    //   43: astore_2
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_2
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	i
    //   0	48	1	paramInt	int
    //   43	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	13	43	finally
    //   16	29	43	finally
    //   29	40	43	finally
  }
  
  public void a(String paramString1, String paramString2)
  {
    try
    {
      a(paramString1, paramString2, null);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    try
    {
      a(paramString1, paramString2, paramThrowable, new h(this));
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public void a(String paramString1, String paramString2, Throwable paramThrowable, com.tencent.beacon.core.b.b<String> paramb)
  {
    for (;;)
    {
      try
      {
        boolean bool = this.f;
        if (!bool) {
          return;
        }
        if (!this.e) {
          c();
        }
        if (j.c(paramString1))
        {
          d.b("[upload error] errorCode isn't valid value!", new Object[0]);
          continue;
        }
        b();
      }
      finally {}
      LinkedHashMap localLinkedHashMap = new LinkedHashMap(b);
      localLinkedHashMap.put("error_code", paramString1);
      localLinkedHashMap.put("error_msg", paramString2);
      localLinkedHashMap.put("error_stack", com.tencent.beacon.core.e.b.a(paramThrowable));
      localLinkedHashMap.put("_dc", String.valueOf(Math.random()));
      com.tencent.beacon.core.b.f.a().a("https://h.trace.qq.com/kv", localLinkedHashMap, paramb);
      d.d("[upload error] upload a new error, errorCode: %s, message: %s, stack: %s", new Object[] { paramString1, paramString2, com.tencent.beacon.core.e.b.a(paramThrowable) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.d.i
 * JD-Core Version:    0.7.0.1
 */
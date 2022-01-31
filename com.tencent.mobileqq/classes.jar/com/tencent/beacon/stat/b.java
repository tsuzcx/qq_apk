package com.tencent.beacon.stat;

import android.content.Context;
import com.tencent.beacon.core.a.c;
import com.tencent.beacon.core.d.i;
import java.util.concurrent.atomic.AtomicLong;

public final class b
  implements Runnable
{
  private static b a;
  private final Context b;
  private String c;
  private boolean d = false;
  private String e;
  private AtomicLong f = new AtomicLong(0L);
  private AtomicLong g = new AtomicLong(0L);
  private AtomicLong h = new AtomicLong(0L);
  private String i;
  private boolean j = false;
  
  private b(Context paramContext)
  {
    this.b = paramContext;
  }
  
  public static b a(Context paramContext)
  {
    try
    {
      if (a == null) {
        a = new b(paramContext);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  private void a()
  {
    try
    {
      if (!this.d)
      {
        this.i = ModuleImpl.getInstance(this.b).specifiedSerialEventName;
        c localc = c.a(this.b);
        this.e = localc.a("on_ua_date", "");
        this.f.set(localc.b("on_normal_ua_times"));
        this.g.set(localc.b("on_sdk_ua_times"));
        this.h.set(localc.b("on_specified_ua_times"));
        com.tencent.beacon.core.d.b.b("[stat] load serial from sp, normalesn: %d, sdkesn: %d, spesn: %d", new Object[] { Long.valueOf(this.f.get()), Long.valueOf(this.g.get()), Long.valueOf(this.h.get()) });
        c();
        this.d = true;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void b()
  {
    try
    {
      if (!i.a().equals(this.e))
      {
        this.f.set(0L);
        this.g.set(0L);
        this.h.set(0L);
        this.e = i.a();
        c();
        if (!this.j)
        {
          this.j = true;
          com.tencent.beacon.core.a.b.b().a(this);
        }
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  private void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 43	com/tencent/beacon/stat/b:b	Landroid/content/Context;
    //   6: invokestatic 129	com/tencent/beacon/core/b/b:a	(Landroid/content/Context;)Lcom/tencent/beacon/core/b/b;
    //   9: astore_1
    //   10: aload_0
    //   11: getfield 43	com/tencent/beacon/stat/b:b	Landroid/content/Context;
    //   14: invokestatic 134	com/tencent/beacon/core/b/d:a	(Landroid/content/Context;)Lcom/tencent/beacon/core/b/d;
    //   17: astore_3
    //   18: aload_0
    //   19: getfield 43	com/tencent/beacon/stat/b:b	Landroid/content/Context;
    //   22: invokestatic 139	com/tencent/beacon/core/b/c:a	(Landroid/content/Context;)Lcom/tencent/beacon/core/b/c;
    //   25: astore_2
    //   26: aload_1
    //   27: ifnull +115 -> 142
    //   30: aload_3
    //   31: ifnull +111 -> 142
    //   34: new 141	java/lang/StringBuilder
    //   37: dup
    //   38: invokespecial 142	java/lang/StringBuilder:<init>	()V
    //   41: astore_3
    //   42: aload_3
    //   43: aload_1
    //   44: invokevirtual 144	com/tencent/beacon/core/b/b:b	()Ljava/lang/String;
    //   47: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload_3
    //   52: ldc 150
    //   54: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: aload_3
    //   59: aload_2
    //   60: invokevirtual 151	com/tencent/beacon/core/b/c:a	()Ljava/lang/String;
    //   63: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: aload_3
    //   68: ldc 150
    //   70: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: aload_3
    //   75: aload_0
    //   76: getfield 43	com/tencent/beacon/stat/b:b	Landroid/content/Context;
    //   79: invokestatic 154	com/tencent/beacon/core/b/d:e	(Landroid/content/Context;)Ljava/lang/String;
    //   82: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: pop
    //   86: new 141	java/lang/StringBuilder
    //   89: dup
    //   90: aload_3
    //   91: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   94: invokestatic 160	com/tencent/beacon/core/d/i:c	(Ljava/lang/String;)Ljava/lang/String;
    //   97: invokespecial 163	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   100: astore_1
    //   101: aload_1
    //   102: ldc 150
    //   104: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: aload_1
    //   109: aload_0
    //   110: getfield 74	com/tencent/beacon/stat/b:e	Ljava/lang/String;
    //   113: ldc 165
    //   115: ldc 69
    //   117: invokevirtual 169	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   120: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: pop
    //   124: aload_1
    //   125: ldc 150
    //   127: invokevirtual 148	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: pop
    //   131: aload_0
    //   132: aload_1
    //   133: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   136: putfield 171	com/tencent/beacon/stat/b:c	Ljava/lang/String;
    //   139: aload_0
    //   140: monitorexit
    //   141: return
    //   142: aload_0
    //   143: ldc 173
    //   145: putfield 171	com/tencent/beacon/stat/b:c	Ljava/lang/String;
    //   148: goto -9 -> 139
    //   151: astore_1
    //   152: aload_0
    //   153: monitorexit
    //   154: aload_1
    //   155: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	156	0	this	b
    //   9	124	1	localObject1	Object
    //   151	4	1	localObject2	Object
    //   25	35	2	localc	com.tencent.beacon.core.b.c
    //   17	74	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	151	finally
    //   34	139	151	finally
    //   142	148	151	finally
  }
  
  public final String a(String paramString)
  {
    for (;;)
    {
      StringBuilder localStringBuilder;
      try
      {
        a();
        b();
        localStringBuilder = new StringBuilder(this.c);
        if (paramString.startsWith("rqd_"))
        {
          localStringBuilder.append("Y_");
          if (paramString.equals(this.i))
          {
            localStringBuilder.append(this.h.addAndGet(1L));
            if (!this.j)
            {
              this.j = true;
              com.tencent.beacon.core.a.b.b().a(this);
            }
            com.tencent.beacon.core.d.b.b("[stat] get event sn for [%s] : %s.", new Object[] { paramString, localStringBuilder.toString() });
            paramString = localStringBuilder.toString();
            return paramString;
          }
        }
        else
        {
          localStringBuilder.append("N_");
          continue;
        }
        if (!paramString.startsWith("rqd_")) {
          break label150;
        }
      }
      finally {}
      localStringBuilder.append(this.g.addAndGet(1L));
      continue;
      label150:
      localStringBuilder.append(this.f.addAndGet(1L));
    }
  }
  
  public final void run()
  {
    if (this.j)
    {
      c.a(this.b).a().a("on_ua_date", this.e).a("on_normal_ua_times", Long.valueOf(this.f.get())).a("on_sdk_ua_times", Long.valueOf(this.g.get())).a("on_specified_ua_times", Long.valueOf(this.h.get())).b();
      this.j = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.stat.b
 * JD-Core Version:    0.7.0.1
 */
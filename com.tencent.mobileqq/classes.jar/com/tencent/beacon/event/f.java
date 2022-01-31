package com.tencent.beacon.event;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import com.tencent.beacon.a.b;
import com.tencent.beacon.a.c;
import com.tencent.beacon.d.a;
import java.util.concurrent.atomic.AtomicLong;

public final class f
  implements Runnable
{
  private static f a;
  private final Context b;
  private String c;
  private boolean d = false;
  private String e;
  private AtomicLong f = new AtomicLong(0L);
  private AtomicLong g = new AtomicLong(0L);
  private AtomicLong h = new AtomicLong(0L);
  private String i;
  private boolean j = false;
  
  private f(Context paramContext)
  {
    this.b = paramContext;
  }
  
  public static f a(Context paramContext)
  {
    try
    {
      if (a == null) {
        a = new f(paramContext);
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
        o localo = o.d();
        if (localo.a != null) {
          this.i = localo.a.v();
        }
        this.e = b.b(this.b, "on_ua_date", "");
        this.f.set(b.b(this.b, "on_normal_ua_times"));
        this.g.set(b.b(this.b, "on_sdk_ua_times"));
        this.h.set(b.b(this.b, "on_specified_ua_times"));
        a.a("load serial from sp, normalesn: %d, sdkesn: %d, spesn: %d", new Object[] { Long.valueOf(this.f.get()), Long.valueOf(this.g.get()), Long.valueOf(this.h.get()) });
        c();
        this.d = true;
      }
      return;
    }
    finally {}
  }
  
  private void b()
  {
    try
    {
      if (!com.tencent.beacon.a.f.n().equals(this.e))
      {
        this.f.set(0L);
        this.g.set(0L);
        this.h.set(0L);
        this.e = com.tencent.beacon.a.f.n();
        c();
        if (!this.j)
        {
          this.j = true;
          c.a().a(this);
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
    //   2: invokestatic 132	com/tencent/beacon/a/d:m	()Lcom/tencent/beacon/a/d;
    //   5: astore_1
    //   6: aload_0
    //   7: getfield 43	com/tencent/beacon/event/f:b	Landroid/content/Context;
    //   10: invokestatic 135	com/tencent/beacon/a/f:a	(Landroid/content/Context;)Lcom/tencent/beacon/a/f;
    //   13: astore_2
    //   14: aload_1
    //   15: ifnull +115 -> 130
    //   18: aload_2
    //   19: ifnull +111 -> 130
    //   22: new 137	java/lang/StringBuilder
    //   25: dup
    //   26: invokespecial 138	java/lang/StringBuilder:<init>	()V
    //   29: astore_2
    //   30: aload_2
    //   31: aload_1
    //   32: invokevirtual 140	com/tencent/beacon/a/d:j	()Ljava/lang/String;
    //   35: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: pop
    //   39: aload_2
    //   40: ldc 146
    //   42: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload_2
    //   47: aload_1
    //   48: invokevirtual 148	com/tencent/beacon/a/d:i	()Ljava/lang/String;
    //   51: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: aload_2
    //   56: ldc 146
    //   58: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: aload_2
    //   63: aload_0
    //   64: getfield 43	com/tencent/beacon/event/f:b	Landroid/content/Context;
    //   67: invokestatic 151	com/tencent/beacon/a/f:e	(Landroid/content/Context;)Ljava/lang/String;
    //   70: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: new 137	java/lang/StringBuilder
    //   77: dup
    //   78: aload_2
    //   79: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: invokestatic 157	com/tencent/beacon/a/f:g	(Ljava/lang/String;)Ljava/lang/String;
    //   85: invokespecial 160	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   88: astore_1
    //   89: aload_1
    //   90: ldc 146
    //   92: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: pop
    //   96: aload_1
    //   97: aload_0
    //   98: getfield 76	com/tencent/beacon/event/f:e	Ljava/lang/String;
    //   101: ldc 162
    //   103: ldc 69
    //   105: invokevirtual 166	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   108: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: pop
    //   112: aload_1
    //   113: ldc 146
    //   115: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: pop
    //   119: aload_0
    //   120: aload_1
    //   121: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: putfield 168	com/tencent/beacon/event/f:c	Ljava/lang/String;
    //   127: aload_0
    //   128: monitorexit
    //   129: return
    //   130: aload_0
    //   131: ldc 170
    //   133: putfield 168	com/tencent/beacon/event/f:c	Ljava/lang/String;
    //   136: goto -9 -> 127
    //   139: astore_1
    //   140: aload_0
    //   141: monitorexit
    //   142: aload_1
    //   143: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	144	0	this	f
    //   5	116	1	localObject1	Object
    //   139	4	1	localObject2	Object
    //   13	66	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	139	finally
    //   22	127	139	finally
    //   130	136	139	finally
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
              c.a().a(this);
            }
            a.b("get event sn for [%s] : %s.", new Object[] { paramString, localStringBuilder.toString() });
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
      SharedPreferences.Editor localEditor = b.k(this.b);
      localEditor.putString("on_ua_date", this.e);
      localEditor.putLong("on_normal_ua_times", this.f.get());
      localEditor.putLong("on_sdk_ua_times", this.g.get());
      localEditor.putLong("on_specified_ua_times", this.h.get());
      localEditor.commit();
      this.j = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.event.f
 * JD-Core Version:    0.7.0.1
 */
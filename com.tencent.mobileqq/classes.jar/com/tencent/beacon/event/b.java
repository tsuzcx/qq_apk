package com.tencent.beacon.event;

import android.content.Context;
import com.tencent.beacon.a.c;
import com.tencent.beacon.upload.i;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class b
  implements j
{
  private Context a;
  private boolean b = false;
  private Object c = new Object();
  private Object d = new Object();
  private Object e = new Object();
  private List<k> f;
  private long g = 60000L;
  private Runnable h = new Runnable()
  {
    public final void run()
    {
      b.this.a();
    }
  };
  private Runnable i = new Runnable()
  {
    public final void run()
    {
      b.a(b.this);
    }
  };
  private Runnable j = new Runnable()
  {
    public final void run()
    {
      com.tencent.beacon.d.a.f(" db events to up", new Object[0]);
      try
      {
        o.d(false);
        return;
      }
      catch (Throwable localThrowable)
      {
        com.tencent.beacon.d.a.a(localThrowable);
      }
    }
  };
  
  public b(Context paramContext)
  {
    this.a = paramContext;
    this.f = new ArrayList(25);
  }
  
  public static k a(Context paramContext, String paramString, Map<String, String> paramMap)
  {
    return a(paramContext, paramString, true, 0L, 0L, paramMap, true, false);
  }
  
  public static k a(Context paramContext, String paramString, boolean paramBoolean1, long paramLong1, long paramLong2, Map<String, String> paramMap, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramString == null) {
      return null;
    }
    com.tencent.beacon.a.d locald = com.tencent.beacon.a.d.m();
    if (locald == null)
    {
      com.tencent.beacon.d.a.d("  CommonInfo or DeviceInfo have not been Created return null!", new Object[0]);
      return null;
    }
    String str1 = UserAction.getUserID();
    long l1 = locald.h();
    long l2 = new Date().getTime();
    String str2 = locald.g();
    Object localObject2 = com.tencent.beacon.a.f.u(paramContext);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "null";
    }
    localObject2 = new HashMap();
    if (UserAction.a != null) {
      ((Map)localObject2).putAll(UserAction.a);
    }
    if (paramMap != null) {
      ((Map)localObject2).putAll(paramMap);
    }
    ((Map)localObject2).put("A1", str1);
    ((Map)localObject2).put("QQ", UserAction.getQQ());
    ((Map)localObject2).put("A19", localObject1);
    ((Map)localObject2).put("A28", str2);
    ((Map)localObject2).put("A25", String.valueOf(paramBoolean1));
    ((Map)localObject2).put("A26", String.valueOf(paramLong1));
    ((Map)localObject2).put("A27", String.valueOf(paramLong2));
    ((Map)localObject2).put("A2", locald.i());
    paramMap = d.a(paramContext);
    ((Map)localObject2).put("A4", paramMap.d());
    ((Map)localObject2).put("A6", paramMap.c());
    ((Map)localObject2).put("A7", paramMap.e());
    ((Map)localObject2).put("A3", com.tencent.beacon.a.j.a(paramContext).a());
    ((Map)localObject2).put("A23", locald.k());
    ((Map)localObject2).put("A31", paramMap.a());
    ((Map)localObject2).put("A67", com.tencent.beacon.a.b.j(paramContext));
    ((Map)localObject2).put("A76", com.tencent.beacon.a.b.a());
    if (paramBoolean2) {}
    for (paramMap = "Y";; paramMap = "N")
    {
      ((Map)localObject2).put("A99", paramMap);
      if (o.d().a.u()) {
        ((Map)localObject2).put("A100", f.a(paramContext).a(paramString));
      }
      paramContext = new k();
      paramContext.b(paramString);
      paramContext.b(l1 + l2);
      paramContext.a("UA");
      paramContext.a((Map)localObject2);
      paramContext.g();
      paramContext.b(paramBoolean3);
      int k = 0;
      if (paramLong1 >= 1200000L) {
        k = 1;
      }
      int m = k;
      if (paramLong2 >= 50000000L) {
        m = k + 1;
      }
      if (m <= 0) {
        break;
      }
      paramContext.c(m);
      paramContext.a(true);
      return paramContext;
    }
    paramContext.c(0L);
    paramContext.a(false);
    return paramContext;
  }
  
  public static com.tencent.beacon.b.d.b b(k paramk)
  {
    if ((paramk == null) || (!"IP".equals(paramk.b()))) {
      return null;
    }
    Map localMap = paramk.e();
    if (localMap == null) {
      return null;
    }
    try
    {
      com.tencent.beacon.b.d.b localb = new com.tencent.beacon.b.d.b();
      localb.a = ((String)localMap.get("A19"));
      String str = (String)localMap.get("A26");
      Object localObject = str;
      if (str == null) {
        localObject = "-1";
      }
      localb.e = Long.parseLong((String)localObject);
      localObject = paramk.d().split(":");
      localb.c = localObject[0];
      localb.d = Integer.parseInt(localObject[1]);
      localb.b = ((String)localMap.get("A28"));
      localb.f = paramk.c();
      paramk = new HashMap();
      paramk.put("A33", localMap.get("A33"));
      paramk.put("A3", localMap.get("A3"));
      paramk.put("A20", localMap.get("A20"));
      paramk.put("A74", localMap.get("A74"));
      if (localMap.get("test") != null) {
        paramk.put("test", "Y");
      }
      localb.g = com.tencent.beacon.a.f.a(paramk);
      return localb;
    }
    catch (Throwable paramk)
    {
      com.tencent.beacon.d.a.a(paramk);
      com.tencent.beacon.d.a.d(paramk.getMessage(), new Object[0]);
    }
    return null;
  }
  
  /* Error */
  private List<k> b()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 66	com/tencent/beacon/event/b:f	Ljava/util/List;
    //   6: ifnull +24 -> 30
    //   9: aload_0
    //   10: getfield 66	com/tencent/beacon/event/b:f	Ljava/util/List;
    //   13: invokeinterface 354 1 0
    //   18: ifle +12 -> 30
    //   21: aload_0
    //   22: invokespecial 356	com/tencent/beacon/event/b:d	()Z
    //   25: istore_1
    //   26: iload_1
    //   27: ifne +9 -> 36
    //   30: aconst_null
    //   31: astore_2
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_2
    //   35: areturn
    //   36: new 61	java/util/ArrayList
    //   39: dup
    //   40: invokespecial 357	java/util/ArrayList:<init>	()V
    //   43: astore_2
    //   44: aload_2
    //   45: aload_0
    //   46: getfield 66	com/tencent/beacon/event/b:f	Ljava/util/List;
    //   49: invokeinterface 361 2 0
    //   54: pop
    //   55: aload_0
    //   56: getfield 66	com/tencent/beacon/event/b:f	Ljava/util/List;
    //   59: invokeinterface 364 1 0
    //   64: new 133	java/lang/StringBuilder
    //   67: dup
    //   68: ldc_w 366
    //   71: invokespecial 368	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   74: aload_2
    //   75: invokeinterface 354 1 0
    //   80: invokevirtual 371	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   83: invokevirtual 144	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: iconst_0
    //   87: anewarray 4	java/lang/Object
    //   90: invokestatic 373	com/tencent/beacon/d/a:b	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   93: goto -61 -> 32
    //   96: astore_2
    //   97: aload_0
    //   98: monitorexit
    //   99: aload_2
    //   100: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	this	b
    //   25	2	1	bool	boolean
    //   31	44	2	localObject1	Object
    //   96	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	96	finally
    //   36	93	96	finally
  }
  
  public static com.tencent.beacon.b.d.a c(k paramk)
  {
    if ((paramk == null) || (!"DN".equals(paramk.b()))) {
      return null;
    }
    Map localMap = paramk.e();
    if (localMap == null) {
      return null;
    }
    try
    {
      com.tencent.beacon.b.d.a locala = new com.tencent.beacon.b.d.a();
      locala.a = ((String)localMap.get("A19"));
      locala.c = paramk.d();
      locala.j = ((String)localMap.get("A34"));
      locala.d = Long.parseLong((String)localMap.get("A35"));
      locala.f = Long.parseLong((String)localMap.get("A36"));
      locala.g = Long.parseLong((String)localMap.get("A37"));
      locala.h = Long.parseLong((String)localMap.get("A38"));
      locala.b = ((String)localMap.get("A28"));
      locala.i = ((String)localMap.get("A39"));
      locala.e = Long.parseLong((String)localMap.get("A40"));
      locala.k = paramk.c();
      paramk = new HashMap();
      paramk.put("A33", localMap.get("A33"));
      paramk.put("A3", localMap.get("A3"));
      paramk.put("A20", localMap.get("A20"));
      paramk.put("A74", localMap.get("A74"));
      if (localMap.get("test") != null) {
        paramk.put("test", "Y");
      }
      locala.l = com.tencent.beacon.a.f.a(paramk);
      return locala;
    }
    catch (Throwable paramk)
    {
      com.tencent.beacon.d.a.a(paramk);
      com.tencent.beacon.d.a.d(paramk.getMessage(), new Object[0]);
    }
    return null;
  }
  
  private void c()
  {
    synchronized (this.e)
    {
      if (!d())
      {
        com.tencent.beacon.d.a.c(" err su 1R", new Object[0]);
        return;
      }
      Object localObject2 = b();
      if ((localObject2 != null) && (((List)localObject2).size() > 0))
      {
        localObject2 = com.tencent.beacon.a.f.a(this.a, (List)localObject2);
        if (localObject2 != null) {
          o.d().d.a(localObject2.length);
        }
      }
      return;
    }
  }
  
  public static com.tencent.beacon.b.d.d d(k paramk)
  {
    if ((paramk == null) || (!"HO".equals(paramk.b()))) {
      return null;
    }
    Map localMap = paramk.e();
    if (localMap == null) {
      return null;
    }
    try
    {
      com.tencent.beacon.b.d.d locald = new com.tencent.beacon.b.d.d();
      locald.a = ((String)localMap.get("A19"));
      String[] arrayOfString = ((String)localMap.get("hostip")).split(":");
      locald.m = Integer.parseInt(arrayOfString[1]);
      locald.b = ((String)localMap.get("A28"));
      locald.c = ((String)localMap.get("A34"));
      locald.k = arrayOfString[0];
      locald.l = paramk.d();
      locald.d = Long.parseLong((String)localMap.get("A35"));
      locald.e = Long.parseLong((String)localMap.get("A40"));
      locald.f = Long.parseLong((String)localMap.get("A36"));
      locald.g = Long.parseLong((String)localMap.get("A37"));
      locald.h = Long.parseLong((String)localMap.get("A38"));
      locald.j = paramk.c();
      locald.i = ((String)localMap.get("A39"));
      paramk = new HashMap();
      paramk.put("A33", localMap.get("A33"));
      paramk.put("A3", localMap.get("A3"));
      paramk.put("A20", localMap.get("A20"));
      paramk.put("A74", localMap.get("A74"));
      locald.n = com.tencent.beacon.a.f.a(paramk);
      return locald;
    }
    catch (Throwable paramk)
    {
      com.tencent.beacon.d.a.a(paramk);
      com.tencent.beacon.d.a.d(paramk.getMessage(), new Object[0]);
    }
    return null;
  }
  
  private boolean d()
  {
    try
    {
      boolean bool = this.b;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static com.tencent.beacon.b.b.a e(k paramk)
  {
    if ((paramk == null) || (!"UA".equals(paramk.b()))) {
      return null;
    }
    Map localMap = paramk.e();
    if (localMap == null) {
      return null;
    }
    try
    {
      com.tencent.beacon.b.b.a locala = new com.tencent.beacon.b.b.a();
      locala.a = ((String)localMap.get("A19"));
      locala.c = paramk.d();
      locala.h = paramk.c();
      locala.b = ((String)localMap.get("A28"));
      locala.f = Long.parseLong((String)localMap.get("A26"));
      locala.d = Boolean.parseBoolean((String)localMap.get("A25"));
      locala.e = Long.parseLong((String)localMap.get("A27"));
      if (paramk.h()) {
        localMap.put("C9", paramk.i());
      }
      paramk.f();
      locala.g = com.tencent.beacon.a.f.a(localMap);
      paramk.f();
      locala.i = 0;
      return locala;
    }
    catch (Throwable paramk)
    {
      com.tencent.beacon.d.a.a(paramk);
      com.tencent.beacon.d.a.d(paramk.getMessage(), new Object[0]);
    }
    return null;
  }
  
  protected final void a()
  {
    boolean bool = false;
    int k = 0;
    synchronized (this.d)
    {
      if (!d())
      {
        com.tencent.beacon.d.a.c(" err su 1R", new Object[0]);
        return;
      }
      Object localObject2 = b();
      if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
        break label273;
      }
      localObject2 = com.tencent.beacon.a.f.a(this.a, (List)localObject2);
      if (localObject2 != null) {
        o.d().d.a(localObject2.length);
      }
      i locali = i.a(this.a);
      if (localObject2 == null) {
        break label269;
      }
      long l2 = o.d().i().e();
      long l1 = l2;
      if (com.tencent.beacon.a.f.s(this.a))
      {
        com.tencent.beacon.d.a.e(" onwifi, so half mSZ " + l2, new Object[0]);
        l1 = l2 / 2L;
      }
      int m = com.tencent.beacon.a.f.q(this.a);
      com.tencent.beacon.d.a.b("countCommomRecordNum: " + m, new Object[0]);
      if (m >= l1) {
        k = 1;
      }
      if ((k == 0) || (!locali.a()) || (!locali.b())) {
        break label269;
      }
      if (!o.d().i().l())
      {
        com.tencent.beacon.d.a.e(" common max, not up by zeroPeak!", new Object[0]);
        return;
      }
    }
    this.j.run();
    com.tencent.beacon.d.a.e(" common max up ", new Object[0]);
    for (;;)
    {
      label269:
      return;
      label273:
      g localg = o.d().i();
      if (localg != null) {
        bool = localg.t();
      }
      if (bool)
      {
        this.j.run();
        com.tencent.beacon.d.a.e(" common polling up", new Object[0]);
      }
    }
  }
  
  /* Error */
  public final void a(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 36	com/tencent/beacon/event/b:b	Z
    //   6: iload_1
    //   7: if_icmpeq +50 -> 57
    //   10: iload_1
    //   11: ifeq +49 -> 60
    //   14: aload_0
    //   15: iload_1
    //   16: putfield 36	com/tencent/beacon/event/b:b	Z
    //   19: aload_0
    //   20: invokestatic 219	com/tencent/beacon/event/o:d	()Lcom/tencent/beacon/event/o;
    //   23: invokevirtual 496	com/tencent/beacon/event/o:i	()Lcom/tencent/beacon/event/g;
    //   26: invokevirtual 536	com/tencent/beacon/event/g:d	()I
    //   29: sipush 1000
    //   32: imul
    //   33: i2l
    //   34: putfield 46	com/tencent/beacon/event/b:g	J
    //   37: invokestatic 541	com/tencent/beacon/a/c:a	()Lcom/tencent/beacon/a/c;
    //   40: bipush 102
    //   42: aload_0
    //   43: getfield 51	com/tencent/beacon/event/b:h	Ljava/lang/Runnable;
    //   46: aload_0
    //   47: getfield 46	com/tencent/beacon/event/b:g	J
    //   50: aload_0
    //   51: getfield 46	com/tencent/beacon/event/b:g	J
    //   54: invokevirtual 544	com/tencent/beacon/a/c:a	(ILjava/lang/Runnable;JJ)V
    //   57: aload_0
    //   58: monitorexit
    //   59: return
    //   60: invokestatic 541	com/tencent/beacon/a/c:a	()Lcom/tencent/beacon/a/c;
    //   63: bipush 102
    //   65: invokevirtual 545	com/tencent/beacon/a/c:a	(I)V
    //   68: invokestatic 541	com/tencent/beacon/a/c:a	()Lcom/tencent/beacon/a/c;
    //   71: bipush 112
    //   73: invokevirtual 545	com/tencent/beacon/a/c:a	(I)V
    //   76: aload_0
    //   77: iconst_1
    //   78: invokevirtual 546	com/tencent/beacon/event/b:b	(Z)V
    //   81: aload_0
    //   82: iload_1
    //   83: putfield 36	com/tencent/beacon/event/b:b	Z
    //   86: goto -29 -> 57
    //   89: astore_2
    //   90: aload_0
    //   91: monitorexit
    //   92: aload_2
    //   93: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	b
    //   0	94	1	paramBoolean	boolean
    //   89	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	10	89	finally
    //   14	57	89	finally
    //   60	86	89	finally
  }
  
  public final boolean a(k paramk)
  {
    Object localObject2 = this.c;
    if (paramk == null) {
      localObject1 = "null";
    }
    for (;;)
    {
      boolean bool;
      if (paramk == null) {
        bool = false;
      }
      try
      {
        for (;;)
        {
          com.tencent.beacon.d.a.f(" BF eN:%s   isRT:%b  isCR:%b", new Object[] { localObject1, Boolean.valueOf(false), Boolean.valueOf(bool) });
          if ((this.a != null) && (paramk != null) && (this.b)) {
            break label105;
          }
          com.tencent.beacon.d.a.d(" err BF 1R", new Object[0]);
          return false;
          localObject1 = paramk.d();
          break;
          bool = paramk.f();
        }
        label105:
        if (!d())
        {
          com.tencent.beacon.d.a.d(" CommonProcess processUA return false, isEnable is false !", new Object[0]);
          return false;
        }
      }
      finally {}
    }
    Object localObject1 = o.d().i();
    int k = ((g)localObject1).c();
    this.g = (((g)localObject1).d() * 1000);
    int m = this.f.size();
    if (m >= k)
    {
      com.tencent.beacon.d.a.f(" BF mN!", new Object[0]);
      c.a().a(this.h);
      c.a().a(102, this.h, this.g, this.g);
    }
    this.f.add(paramk);
    if (this.f.size() >= k) {
      com.tencent.beacon.d.a.c(" err BF 3R! list size:" + m, new Object[0]);
    }
    o.d().d.a();
    com.tencent.beacon.d.a.a("CommonprocessUA:true!", new Object[0]);
    return true;
  }
  
  /* Error */
  public final void b(boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 578
    //   5: iconst_0
    //   6: anewarray 4	java/lang/Object
    //   9: invokestatic 506	com/tencent/beacon/d/a:e	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   12: iload_1
    //   13: ifeq +10 -> 23
    //   16: aload_0
    //   17: invokespecial 270	com/tencent/beacon/event/b:c	()V
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: invokestatic 541	com/tencent/beacon/a/c:a	()Lcom/tencent/beacon/a/c;
    //   26: aload_0
    //   27: getfield 54	com/tencent/beacon/event/b:i	Ljava/lang/Runnable;
    //   30: invokevirtual 565	com/tencent/beacon/a/c:a	(Ljava/lang/Runnable;)V
    //   33: goto -13 -> 20
    //   36: astore_2
    //   37: aload_0
    //   38: monitorexit
    //   39: aload_2
    //   40: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	41	0	this	b
    //   0	41	1	paramBoolean	boolean
    //   36	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	12	36	finally
    //   16	20	36	finally
    //   23	33	36	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.event.b
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.beacon.e;

import android.content.Context;
import android.util.Base64;
import com.tencent.beacon.a.c.f;
import com.tencent.beacon.a.d.a.a;
import com.tencent.beacon.base.net.RequestType;
import com.tencent.beacon.base.net.a.i;
import com.tencent.beacon.base.net.a.k;
import com.tencent.beacon.base.net.a.k.a;
import com.tencent.beacon.base.net.e;
import com.tencent.beacon.module.StrategyModule;
import com.tencent.beacon.pack.CommonStrategy;
import com.tencent.beacon.pack.ModuleStrategy;
import com.tencent.beacon.qimei.Qimei;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class h
  implements com.tencent.beacon.base.net.a.b<byte[]>, Runnable
{
  private final Context a;
  private final StrategyModule b;
  private volatile boolean c = false;
  private boolean d;
  
  public h(StrategyModule paramStrategyModule)
  {
    this.b = paramStrategyModule;
    this.a = com.tencent.beacon.a.c.c.d().c();
  }
  
  private void a(d paramd, b paramb, ModuleStrategy paramModuleStrategy)
  {
    if (paramModuleStrategy.detail != null)
    {
      com.tencent.beacon.base.util.c.a("[strategy] mid: %d , detail changed...", new Object[] { Byte.valueOf(paramModuleStrategy.mId) });
      paramd.a(paramModuleStrategy.detail);
      paramb.a(paramModuleStrategy.detail);
      this.d = true;
    }
  }
  
  private void a(d paramd, ModuleStrategy paramModuleStrategy)
  {
    boolean bool;
    if (paramModuleStrategy.onOff == 1) {
      bool = true;
    } else {
      bool = false;
    }
    if (paramd.c() != bool)
    {
      com.tencent.beacon.base.util.c.a("[strategy] mid: %d , isUsable changed: %b ", new Object[] { Byte.valueOf(paramModuleStrategy.mId), Boolean.valueOf(bool) });
      paramd.a(bool);
      this.d = true;
    }
  }
  
  private void a(ModuleStrategy paramModuleStrategy)
  {
    String str = com.tencent.beacon.base.net.c.b.a(paramModuleStrategy.url);
    if (!com.tencent.beacon.base.net.c.b.a(true).equals(str))
    {
      com.tencent.beacon.base.util.c.a("[strategy] mid: %d , url changed: %s", new Object[] { Byte.valueOf(paramModuleStrategy.mId), paramModuleStrategy.url });
      com.tencent.beacon.base.net.c.b.b(str);
      this.d = true;
    }
  }
  
  private boolean a(Map<String, String> paramMap, a parama)
  {
    boolean bool = false;
    if (parama == null) {
      return false;
    }
    if (paramMap != null)
    {
      parama.a(paramMap);
      bool = true;
    }
    return bool;
  }
  
  private void b(d paramd, b paramb, ModuleStrategy paramModuleStrategy)
  {
    ArrayList localArrayList = paramModuleStrategy.preventEventCode;
    if ((localArrayList != null) && (!localArrayList.isEmpty()))
    {
      com.tencent.beacon.base.util.c.a("[strategy] mid: %d , PreventEventCode changed...", new Object[] { Byte.valueOf(paramModuleStrategy.mId) });
      this.d = true;
      paramd.a(com.tencent.beacon.base.util.b.a(paramModuleStrategy.preventEventCode));
      paramb.a(com.tencent.beacon.base.util.b.a(paramModuleStrategy.preventEventCode));
    }
  }
  
  private void c()
  {
    f();
    this.c = false;
  }
  
  private void c(d paramd, b paramb, ModuleStrategy paramModuleStrategy)
  {
    ArrayList localArrayList = paramModuleStrategy.sampleEvent;
    if ((localArrayList != null) && (!localArrayList.isEmpty()))
    {
      com.tencent.beacon.base.util.c.a("[strategy] mid: %d , SampleEventSet changed...", new Object[] { Byte.valueOf(paramModuleStrategy.mId) });
      this.d = true;
      paramd.b(com.tencent.beacon.base.util.b.a(paramModuleStrategy.sampleEvent));
      paramb.b(com.tencent.beacon.base.util.b.a(paramModuleStrategy.sampleEvent));
    }
  }
  
  private void d()
  {
    Object localObject = new HashMap();
    ((Map)localObject).put("s_e_e", Boolean.valueOf(false));
    localObject = new com.tencent.beacon.a.a.c(7, (Map)localObject);
    com.tencent.beacon.a.a.b.a().a((com.tencent.beacon.a.a.c)localObject);
  }
  
  private void e()
  {
    com.tencent.beacon.base.util.c.a("local strategyQuery finish!", new Object[0]);
    com.tencent.beacon.a.a.b.a().a(new com.tencent.beacon.a.a.c(10));
  }
  
  private void f()
  {
    long l = this.b.a().b() * 60000L;
    com.tencent.beacon.a.b.a.a().a(l, this);
    com.tencent.beacon.base.util.c.a("[strategy] next time: %d", new Object[] { Long.valueOf(l) });
  }
  
  private void g()
  {
    if ((!j.b()) && (!j.c()))
    {
      Object localObject = f.p();
      k.a locala = k.a().a(RequestType.STRATEGY).a(100).b(101).a(com.tencent.beacon.a.c.c.d().f()).b(com.tencent.beacon.base.net.c.b.b(false)).a(com.tencent.beacon.base.net.c.b.b(true), 8081).b("A1", com.tencent.beacon.a.c.c.d().k()).b("A2", ((f)localObject).m()).b("A4", ((f)localObject).o()).b("A6", ((f)localObject).s()).b("A7", ((f)localObject).e()).b("A23", com.tencent.beacon.a.c.c.d().a()).b("A31", ((f)localObject).v()).b("A19", ((f)localObject).w());
      if (com.tencent.beacon.a.c.b.e(this.a)) {
        localObject = "F";
      } else {
        localObject = "B";
      }
      locala = locala.b("A66", (String)localObject).b("A67", com.tencent.beacon.a.c.b.c(this.a)).b("A68", String.valueOf(com.tencent.beacon.a.c.b.b(this.a)));
      if (com.tencent.beacon.a.c.b.d) {
        localObject = "Y";
      } else {
        localObject = "N";
      }
      localObject = locala.b("A85", (String)localObject).a(com.tencent.beacon.qimei.a.a().b().getQimeiMap()).a();
      com.tencent.beacon.base.net.d.c().a((k)localObject).b(this);
      return;
    }
    com.tencent.beacon.base.util.c.e("[strategy] query times or query success times arrive max, return!", new Object[0]);
    this.b.a(true);
  }
  
  public void a(e parame)
  {
    c();
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    a(paramArrayOfByte, true);
    this.b.a(true);
    c();
  }
  
  public void a(byte[] paramArrayOfByte, boolean paramBoolean)
  {
    try
    {
      Object localObject = new CommonStrategy();
      ((CommonStrategy)localObject).readFrom(new com.tencent.beacon.pack.a(paramArrayOfByte));
      com.tencent.beacon.base.util.c.a("[strategy] -> common strategy: %s", new Object[] { localObject });
      if ((a((CommonStrategy)localObject, a.a())) && (paramBoolean))
      {
        localObject = com.tencent.beacon.a.d.a.a().edit();
        ((a.a)localObject).putString("strategy_data", Base64.encodeToString(paramArrayOfByte, 0));
      }
      if (paramBoolean)
      {
        j.d();
        return;
      }
    }
    catch (Throwable paramArrayOfByte)
    {
      com.tencent.beacon.base.util.c.a(paramArrayOfByte);
      com.tencent.beacon.base.util.c.b("[strategy] error to common strategy!", new Object[0]);
    }
  }
  
  public boolean a()
  {
    return this.c;
  }
  
  protected boolean a(CommonStrategy paramCommonStrategy, a parama)
  {
    if (paramCommonStrategy != null)
    {
      if (parama == null) {
        return false;
      }
      String str = com.tencent.beacon.base.net.c.b.a(paramCommonStrategy.url);
      if (!str.equals(com.tencent.beacon.base.net.c.b.b(true)))
      {
        com.tencent.beacon.base.util.c.a("[strategy] url changed to: %s", new Object[] { paramCommonStrategy.url });
        this.d = true;
        com.tencent.beacon.base.net.c.b.d(str);
      }
      if (paramCommonStrategy.queryInterval != parama.b())
      {
        com.tencent.beacon.base.util.c.a("[strategy] QueryPeriod changed to: %d", new Object[] { Integer.valueOf(paramCommonStrategy.queryInterval) });
        this.d = true;
        parama.a(paramCommonStrategy.queryInterval);
      }
      if (a(paramCommonStrategy.moduleList)) {
        this.d = true;
      }
      if (a(paramCommonStrategy.cloudParas, parama)) {
        this.d = true;
      }
      return this.d;
    }
    return false;
  }
  
  boolean a(ArrayList<ModuleStrategy> paramArrayList)
  {
    d locald = this.b.a().d();
    if (paramArrayList == null)
    {
      locald.a(false);
      d();
      return false;
    }
    b localb = this.b.b();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      ModuleStrategy localModuleStrategy = (ModuleStrategy)paramArrayList.next();
      if (localModuleStrategy.mId == locald.b())
      {
        a(locald, localModuleStrategy);
        a(localModuleStrategy);
        a(locald, localb, localModuleStrategy);
        b(locald, localb, localModuleStrategy);
        c(locald, localb, localModuleStrategy);
      }
    }
    return this.d;
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: invokestatic 394	com/tencent/beacon/a/d/a:a	()Lcom/tencent/beacon/a/d/a;
    //   3: astore_1
    //   4: aload_1
    //   5: ldc_w 400
    //   8: ldc_w 486
    //   11: invokevirtual 490	com/tencent/beacon/a/d/a:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   14: astore_1
    //   15: aload_1
    //   16: invokestatic 495	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   19: ifne +12 -> 31
    //   22: aload_1
    //   23: iconst_0
    //   24: invokestatic 499	android/util/Base64:decode	(Ljava/lang/String;I)[B
    //   27: astore_1
    //   28: goto +25 -> 53
    //   31: aload_0
    //   32: getfield 35	com/tencent/beacon/e/h:a	Landroid/content/Context;
    //   35: bipush 101
    //   37: invokestatic 502	com/tencent/beacon/e/j:a	(Landroid/content/Context;I)Lcom/tencent/beacon/e/i;
    //   40: astore_1
    //   41: aload_1
    //   42: ifnull +57 -> 99
    //   45: aload_1
    //   46: getfield 506	com/tencent/beacon/e/i:c	[B
    //   49: astore_1
    //   50: goto +3 -> 53
    //   53: aload_1
    //   54: ifnull +12 -> 66
    //   57: aload_0
    //   58: aload_1
    //   59: iconst_0
    //   60: invokevirtual 370	com/tencent/beacon/e/h:a	([BZ)V
    //   63: goto +25 -> 88
    //   66: ldc_w 508
    //   69: iconst_0
    //   70: anewarray 5	java/lang/Object
    //   73: invokestatic 60	com/tencent/beacon/base/util/c:a	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   76: goto +12 -> 88
    //   79: astore_1
    //   80: goto +13 -> 93
    //   83: astore_1
    //   84: aload_1
    //   85: invokestatic 417	com/tencent/beacon/base/util/c:a	(Ljava/lang/Throwable;)V
    //   88: aload_0
    //   89: invokespecial 510	com/tencent/beacon/e/h:e	()V
    //   92: return
    //   93: aload_0
    //   94: invokespecial 510	com/tencent/beacon/e/h:e	()V
    //   97: aload_1
    //   98: athrow
    //   99: aconst_null
    //   100: astore_1
    //   101: goto -48 -> 53
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	this	h
    //   3	56	1	localObject1	Object
    //   79	1	1	localObject2	Object
    //   83	15	1	localException	java.lang.Exception
    //   100	1	1	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   0	4	79	finally
    //   4	28	79	finally
    //   31	41	79	finally
    //   45	50	79	finally
    //   57	63	79	finally
    //   66	76	79	finally
    //   84	88	79	finally
    //   0	4	83	java/lang/Exception
    //   4	28	83	java/lang/Exception
    //   31	41	83	java/lang/Exception
    //   45	50	83	java/lang/Exception
    //   57	63	83	java/lang/Exception
    //   66	76	83	java/lang/Exception
  }
  
  public void run()
  {
    this.c = true;
    if (!this.b.a().e()) {
      g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.beacon.e.h
 * JD-Core Version:    0.7.0.1
 */
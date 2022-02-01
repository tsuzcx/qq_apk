package com.tencent.luggage.wxa.gs;

import com.tencent.luggage.wxa.gq.c;
import com.tencent.luggage.wxa.rz.g;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class d
{
  private Runnable A = new d.1(this);
  protected AtomicBoolean a = new AtomicBoolean(false);
  protected AtomicBoolean b = new AtomicBoolean(false);
  protected AtomicBoolean c = new AtomicBoolean(false);
  protected volatile HashMap<String, Boolean> d = new HashMap();
  protected Object e = new Object();
  private h f;
  private com.tencent.luggage.wxa.gt.d g;
  private volatile LinkedList<String> h = new LinkedList();
  private volatile HashMap<String, Object> i = new HashMap();
  private volatile HashMap<String, List<com.tencent.luggage.wxa.gm.e>> j = new HashMap();
  private volatile HashMap<String, Boolean> k = new HashMap();
  private volatile HashMap<String, WeakReference<c>> l = new HashMap();
  private Object m = new Object();
  private List<com.tencent.luggage.wxa.gm.e> n = new ArrayList();
  private volatile HashMap<String, Boolean> o = new HashMap();
  private volatile HashMap<String, Boolean> p = new HashMap();
  private volatile HashMap<String, Integer> q = new HashMap();
  private volatile HashMap<String, Long> r = new HashMap();
  private volatile LinkedList<String> s = new LinkedList();
  private long t = 0L;
  private boolean u = false;
  private com.tencent.luggage.wxa.sj.d v;
  private int w = 0;
  private long x = 0L;
  private long y = 0L;
  private long z = 0L;
  
  public d(com.tencent.luggage.wxa.gt.d paramd)
  {
    this.g = paramd;
  }
  
  private void a(com.tencent.luggage.wxa.gm.b paramb)
  {
    paramb.e.addAll(this.s);
    this.s.clear();
    this.g.b(paramb);
  }
  
  private void a(List<com.tencent.luggage.wxa.gm.e> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      com.tencent.luggage.wxa.gm.e locale = (com.tencent.luggage.wxa.gm.e)paramList.next();
      if ((locale != null) && (locale.b())) {
        com.tencent.luggage.wxa.gn.d.a().a(locale);
      }
    }
  }
  
  private void b(String paramString, boolean paramBoolean)
  {
    synchronized (this.m)
    {
      if (this.k.containsKey(paramString)) {
        this.k.put(paramString, Boolean.valueOf(paramBoolean));
      } else {
        com.tencent.luggage.wxa.gw.b.a("MicroMsg.Mix.AudioMixController", "The audio of the id is remove");
      }
      return;
    }
  }
  
  private boolean l(String paramString)
  {
    synchronized (this.m)
    {
      return (this.o.containsKey(paramString)) && (((Boolean)this.o.get(paramString)).booleanValue());
    }
  }
  
  private void m()
  {
    int i1 = 0;
    while (i1 < this.h.size())
    {
      ((List)this.j.get(this.h.get(i1))).clear();
      i1 += 1;
    }
  }
  
  private void m(String paramString)
  {
    this.g.a(5, paramString);
    g(paramString);
  }
  
  private void n()
  {
    if (this.v == null) {
      this.v = com.tencent.luggage.wxa.rz.f.a.f(this.A);
    }
  }
  
  /* Error */
  public int a(String paramString, com.tencent.luggage.wxa.gm.e arg2, c paramc)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +375 -> 376
    //   4: aload_1
    //   5: invokestatic 252	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   8: ifne +368 -> 376
    //   11: aload_2
    //   12: getfield 255	com/tencent/luggage/wxa/gm/e:f	[B
    //   15: ifnonnull +6 -> 21
    //   18: goto +358 -> 376
    //   21: aconst_null
    //   22: astore 5
    //   24: aconst_null
    //   25: astore 4
    //   27: aload_0
    //   28: getfield 83	com/tencent/luggage/wxa/gs/d:j	Ljava/util/HashMap;
    //   31: aload_1
    //   32: invokevirtual 189	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   35: ifne +111 -> 146
    //   38: ldc 201
    //   40: ldc_w 257
    //   43: iconst_1
    //   44: anewarray 4	java/lang/Object
    //   47: dup
    //   48: iconst_0
    //   49: aload_1
    //   50: aastore
    //   51: invokestatic 260	com/tencent/luggage/wxa/gw/b:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   54: aload_0
    //   55: getfield 89	com/tencent/luggage/wxa/gs/d:m	Ljava/lang/Object;
    //   58: astore 6
    //   60: aload 6
    //   62: monitorenter
    //   63: aload_0
    //   64: getfield 83	com/tencent/luggage/wxa/gs/d:j	Ljava/util/HashMap;
    //   67: aload_1
    //   68: new 91	java/util/ArrayList
    //   71: dup
    //   72: invokespecial 92	java/util/ArrayList:<init>	()V
    //   75: invokevirtual 199	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   78: pop
    //   79: aload_0
    //   80: getfield 79	com/tencent/luggage/wxa/gs/d:h	Ljava/util/LinkedList;
    //   83: aload_1
    //   84: invokevirtual 263	java/util/LinkedList:contains	(Ljava/lang/Object;)Z
    //   87: ifne +12 -> 99
    //   90: aload_0
    //   91: getfield 79	com/tencent/luggage/wxa/gs/d:h	Ljava/util/LinkedList;
    //   94: aload_1
    //   95: invokevirtual 266	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   98: pop
    //   99: aload 4
    //   101: astore 5
    //   103: aload_0
    //   104: getfield 81	com/tencent/luggage/wxa/gs/d:i	Ljava/util/HashMap;
    //   107: aload_1
    //   108: invokevirtual 189	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   111: ifne +23 -> 134
    //   114: new 4	java/lang/Object
    //   117: dup
    //   118: invokespecial 56	java/lang/Object:<init>	()V
    //   121: astore 5
    //   123: aload_0
    //   124: getfield 81	com/tencent/luggage/wxa/gs/d:i	Ljava/util/HashMap;
    //   127: aload_1
    //   128: aload 5
    //   130: invokevirtual 199	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   133: pop
    //   134: aload 6
    //   136: monitorexit
    //   137: goto +9 -> 146
    //   140: astore_1
    //   141: aload 6
    //   143: monitorexit
    //   144: aload_1
    //   145: athrow
    //   146: aload 5
    //   148: astore 4
    //   150: aload 5
    //   152: ifnonnull +89 -> 241
    //   155: aload_0
    //   156: getfield 81	com/tencent/luggage/wxa/gs/d:i	Ljava/util/HashMap;
    //   159: aload_1
    //   160: invokevirtual 189	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   163: ifne +68 -> 231
    //   166: aload_0
    //   167: getfield 89	com/tencent/luggage/wxa/gs/d:m	Ljava/lang/Object;
    //   170: astore 5
    //   172: aload 5
    //   174: monitorenter
    //   175: aload_0
    //   176: getfield 81	com/tencent/luggage/wxa/gs/d:i	Ljava/util/HashMap;
    //   179: aload_1
    //   180: invokevirtual 189	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   183: ifne +26 -> 209
    //   186: new 4	java/lang/Object
    //   189: dup
    //   190: invokespecial 56	java/lang/Object:<init>	()V
    //   193: astore 4
    //   195: aload_0
    //   196: getfield 81	com/tencent/luggage/wxa/gs/d:i	Ljava/util/HashMap;
    //   199: aload_1
    //   200: aload 4
    //   202: invokevirtual 199	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   205: pop
    //   206: goto +13 -> 219
    //   209: aload_0
    //   210: getfield 81	com/tencent/luggage/wxa/gs/d:i	Ljava/util/HashMap;
    //   213: aload_1
    //   214: invokevirtual 214	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   217: astore 4
    //   219: aload 5
    //   221: monitorexit
    //   222: goto +19 -> 241
    //   225: astore_1
    //   226: aload 5
    //   228: monitorexit
    //   229: aload_1
    //   230: athrow
    //   231: aload_0
    //   232: getfield 81	com/tencent/luggage/wxa/gs/d:i	Ljava/util/HashMap;
    //   235: aload_1
    //   236: invokevirtual 214	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   239: astore 4
    //   241: aload 4
    //   243: astore 5
    //   245: aload 4
    //   247: ifnonnull +12 -> 259
    //   250: new 4	java/lang/Object
    //   253: dup
    //   254: invokespecial 56	java/lang/Object:<init>	()V
    //   257: astore 5
    //   259: aload_0
    //   260: getfield 87	com/tencent/luggage/wxa/gs/d:l	Ljava/util/HashMap;
    //   263: aload_1
    //   264: invokevirtual 189	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   267: ifne +20 -> 287
    //   270: aload_0
    //   271: getfield 87	com/tencent/luggage/wxa/gs/d:l	Ljava/util/HashMap;
    //   274: aload_1
    //   275: new 268	java/lang/ref/WeakReference
    //   278: dup
    //   279: aload_3
    //   280: invokespecial 271	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   283: invokevirtual 199	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   286: pop
    //   287: aload_0
    //   288: getfield 83	com/tencent/luggage/wxa/gs/d:j	Ljava/util/HashMap;
    //   291: aload_1
    //   292: invokevirtual 214	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   295: checkcast 155	java/util/List
    //   298: astore_1
    //   299: aload 5
    //   301: monitorenter
    //   302: aload_1
    //   303: ifnonnull +8 -> 311
    //   306: aload 5
    //   308: monitorexit
    //   309: iconst_0
    //   310: ireturn
    //   311: aload_1
    //   312: iconst_0
    //   313: aload_2
    //   314: invokeinterface 274 3 0
    //   319: aload 5
    //   321: monitorexit
    //   322: aload_0
    //   323: getfield 89	com/tencent/luggage/wxa/gs/d:m	Ljava/lang/Object;
    //   326: astore_2
    //   327: aload_2
    //   328: monitorenter
    //   329: aload_0
    //   330: getfield 89	com/tencent/luggage/wxa/gs/d:m	Ljava/lang/Object;
    //   333: invokevirtual 277	java/lang/Object:notifyAll	()V
    //   336: goto +21 -> 357
    //   339: astore_1
    //   340: goto +26 -> 366
    //   343: astore_3
    //   344: ldc 201
    //   346: aload_3
    //   347: ldc_w 279
    //   350: iconst_0
    //   351: anewarray 4	java/lang/Object
    //   354: invokestatic 282	com/tencent/luggage/wxa/gw/b:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   357: aload_2
    //   358: monitorexit
    //   359: aload_1
    //   360: invokeinterface 283 1 0
    //   365: ireturn
    //   366: aload_2
    //   367: monitorexit
    //   368: aload_1
    //   369: athrow
    //   370: astore_1
    //   371: aload 5
    //   373: monitorexit
    //   374: aload_1
    //   375: athrow
    //   376: ldc 201
    //   378: ldc_w 285
    //   381: invokestatic 208	com/tencent/luggage/wxa/gw/b:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   384: iconst_0
    //   385: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	386	0	this	d
    //   0	386	1	paramString	String
    //   0	386	3	paramc	c
    //   25	221	4	localObject1	Object
    //   22	350	5	localObject2	Object
    //   58	84	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   63	99	140	finally
    //   103	134	140	finally
    //   134	137	140	finally
    //   141	144	140	finally
    //   175	206	225	finally
    //   209	219	225	finally
    //   219	222	225	finally
    //   226	229	225	finally
    //   329	336	339	finally
    //   344	357	339	finally
    //   357	359	339	finally
    //   366	368	339	finally
    //   329	336	343	java/lang/Exception
    //   306	309	370	finally
    //   311	322	370	finally
    //   371	374	370	finally
  }
  
  public void a()
  {
    com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioMixController", "onInit");
    n();
    this.j.clear();
    this.f = new e();
    this.f.a();
  }
  
  public void a(String paramString)
  {
    d(paramString);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    synchronized (this.m)
    {
      this.o.put(paramString, Boolean.valueOf(paramBoolean));
      return;
    }
  }
  
  public boolean a(String arg1, int paramInt)
  {
    if (!this.h.contains(???)) {
      return false;
    }
    if (paramInt < 0)
    {
      this.q.remove(???);
      return false;
    }
    long l1 = System.currentTimeMillis();
    if (paramInt == 0) {
      this.q.remove(???);
    } else {
      this.q.put(???, Integer.valueOf(paramInt));
    }
    List localList = (List)this.j.get(???);
    Object localObject1;
    boolean bool;
    com.tencent.luggage.wxa.gm.d locald;
    int i2;
    if ((localList != null) && (localList.size() != 0))
    {
      localObject1 = this.g.a(???);
      if (localObject1 == null)
      {
        this.q.remove(???);
        return false;
      }
      com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioMixController", "seekTo begin");
      bool = f(???);
      if (!bool) {
        b(???);
      }
      int i1 = localList.size();
      locald = com.tencent.luggage.wxa.gn.f.c().a(((com.tencent.luggage.wxa.if.b)localObject1).c);
      int i3 = locald.c();
      i2 = paramInt / 20;
      paramInt = (int)(h(???) / 20L);
      localObject1 = this.i.get(???);
      if (localObject1 == null)
      {
        this.q.remove(???);
        return false;
      }
      if ((i2 > paramInt) && (i2 <= i3))
      {
        com.tencent.luggage.wxa.gw.b.a("MicroMsg.Mix.AudioMixController", "seekTo seekToPos > currentPos");
        i2 -= paramInt;
        paramInt = 0;
        for (;;)
        {
          if ((paramInt < i2) && (i2 <= i1)) {}
          try
          {
            localList.remove(localList.size() - 1);
            paramInt += 1;
          }
          finally {}
        }
      }
      else if ((i2 < paramInt) && (paramInt <= i3))
      {
        com.tencent.luggage.wxa.gw.b.a("MicroMsg.Mix.AudioMixController", "seekTo seekToPos < currentPos");
      }
    }
    for (;;)
    {
      if (paramInt > i2) {}
      try
      {
        com.tencent.luggage.wxa.gm.e locale = locald.a(paramInt);
        if (locale == null) {
          break label439;
        }
        localList.add(localList.size(), locale);
      }
      finally {}
      if (!bool)
      {
        b(???, false);
        synchronized (this.m)
        {
          f();
        }
      }
      com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioMixController", "seekTo end, time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l1) });
      return true;
      this.q.remove(???);
      return false;
      label439:
      paramInt -= 1;
    }
  }
  
  public void b()
  {
    com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioMixController", "prepareMix");
    this.a.set(false);
    this.b.set(false);
    n();
    d();
  }
  
  public void b(String paramString)
  {
    e(paramString);
  }
  
  public void c()
  {
    com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioMixController", "pauseMix");
    this.b.set(true);
    int i1 = this.w;
    if (i1 > 0)
    {
      this.t = (this.x / i1);
      com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioMixController", "mixAverageTime:%d", new Object[] { Long.valueOf(this.t) });
    }
    this.y = 0L;
    this.w = 0;
    this.x = 0L;
    this.z = 0L;
  }
  
  public void c(String paramString)
  {
    this.d.put(paramString, Boolean.valueOf(true));
    g(paramString);
    if (this.h.isEmpty())
    {
      com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioMixController", "stopMix isMute");
      this.c.set(true);
      this.g.a(0.0F, 0.0F);
      return;
    }
    this.c.set(false);
  }
  
  protected void d()
  {
    try
    {
      synchronized (this.e)
      {
        this.e.notify();
      }
    }
    catch (Exception localException)
    {
      com.tencent.luggage.wxa.gw.b.a("MicroMsg.Mix.AudioMixController", localException, "notifyMix", new Object[0]);
      return;
    }
  }
  
  public void d(String paramString)
  {
    if (this.t > 0L) {
      this.t = 0L;
    }
    synchronized (this.m)
    {
      this.c.set(false);
      this.d.put(paramString, Boolean.valueOf(false));
      if (!this.h.contains(paramString))
      {
        this.h.add(paramString);
        this.j.put(paramString, new ArrayList());
        this.i.put(paramString, new Object());
        this.o.put(paramString, Boolean.valueOf(false));
      }
      else
      {
        com.tencent.luggage.wxa.gw.b.a("MicroMsg.Mix.AudioMixController", "The audio of the Id is mixing");
      }
      this.k.put(paramString, Boolean.valueOf(false));
      this.p.put(paramString, Boolean.valueOf(false));
      if (this.b.get()) {
        this.b.set(false);
      } else {
        this.n.size();
      }
      d();
      f();
      return;
    }
  }
  
  public void e()
  {
    synchronized (this.e)
    {
      while (!i())
      {
        boolean bool = h();
        if (!bool) {
          break;
        }
        try
        {
          com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioMixController", "waitMix");
          this.e.wait();
        }
        catch (Exception localException)
        {
          com.tencent.luggage.wxa.gw.b.a("MicroMsg.Mix.AudioMixController", localException, "waitMix", new Object[0]);
        }
      }
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void e(String paramString)
  {
    synchronized (this.m)
    {
      if (this.k.containsKey(paramString)) {
        this.k.put(paramString, Boolean.valueOf(true));
      } else {
        com.tencent.luggage.wxa.gw.b.a("MicroMsg.Mix.AudioMixController", "The audio of the id is remove");
      }
      return;
    }
  }
  
  protected void f()
  {
    try
    {
      this.m.notifyAll();
      return;
    }
    catch (Exception localException)
    {
      com.tencent.luggage.wxa.gw.b.a("MicroMsg.Mix.AudioMixController", localException, "notifySyncPcmData", new Object[0]);
    }
  }
  
  public boolean f(String paramString)
  {
    synchronized (this.m)
    {
      if (this.k.containsKey(paramString))
      {
        boolean bool = ((Boolean)this.k.get(paramString)).booleanValue();
        return bool;
      }
      return false;
    }
  }
  
  public void g(String paramString)
  {
    synchronized (this.m)
    {
      if (this.h.contains(paramString))
      {
        this.h.remove(paramString);
        Object localObject2 = this.i.get(paramString);
        List localList = (List)this.j.remove(paramString);
        if (localObject2 != null)
        {
          try
          {
            a(localList);
            localList.clear();
          }
          finally {}
        }
        else
        {
          a(localList);
          localList.clear();
        }
        this.i.remove(paramString);
        this.k.remove(paramString);
        this.o.remove(paramString);
        this.p.remove(paramString);
        if (h()) {
          f();
        }
        this.q.remove(paramString);
        this.r.remove(paramString);
      }
      else
      {
        com.tencent.luggage.wxa.gw.b.a("MicroMsg.Mix.AudioMixController", "The audio of the id is remove");
      }
      return;
    }
  }
  
  public boolean g()
  {
    return this.c.get();
  }
  
  public long h(String paramString)
  {
    synchronized (this.m)
    {
      if (this.r.containsKey(paramString))
      {
        paramString = (Long)this.r.get(paramString);
        if (paramString == null) {
          return -1L;
        }
        long l1 = paramString.longValue();
        return l1;
      }
      return -1L;
    }
  }
  
  public boolean h()
  {
    return this.b.get();
  }
  
  public void i(String paramString)
  {
    if (this.l.containsKey(paramString))
    {
      paramString = (WeakReference)this.l.remove(paramString);
      if ((paramString != null) && (paramString.get() != null)) {
        paramString.clear();
      }
    }
  }
  
  public boolean i()
  {
    return this.a.get();
  }
  
  protected List<com.tencent.luggage.wxa.gm.e> j()
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (this.m)
    {
      localArrayList.addAll(this.h);
      int i1 = 0;
      while (i1 < localArrayList.size())
      {
        ??? = (String)localArrayList.get(i1);
        synchronized (this.m)
        {
          if ((!this.k.containsKey(???)) || (!((Boolean)this.k.get(???)).booleanValue()))
          {
            ??? = (List)this.j.get(???);
            if ((??? != null) && (((List)???).size() != 0))
            {
              if (this.l.containsKey(???))
              {
                localObject8 = (WeakReference)this.l.get(???);
                if ((localObject8 != null) && (((WeakReference)localObject8).get() != null))
                {
                  localObject8 = (c)((WeakReference)localObject8).get();
                  if (localObject8 != null) {
                    ((c)localObject8).c(((List)???).size());
                  }
                }
              }
              Object localObject8 = this.i.get(???);
              if (localObject8 != null) {
                try
                {
                  int i2 = ((List)???).size();
                  if (i2 <= 0) {
                    break label373;
                  }
                  ??? = (com.tencent.luggage.wxa.gm.e)((List)???).remove(i2 - 1);
                  if ((this.q.containsKey(???)) && (((Integer)this.q.get(???)).intValue() > ((com.tencent.luggage.wxa.gm.e)???).e)) {
                    break label373;
                  }
                  this.r.put(???, Long.valueOf(((com.tencent.luggage.wxa.gm.e)???).e));
                  this.n.add(???);
                  this.s.add(???);
                }
                finally {}
              }
            }
            else if (l((String)???))
            {
              a((String)???, false);
              m((String)???);
            }
          }
          label373:
          i1 += 1;
        }
      }
      synchronized (this.m)
      {
        if (this.n.size() == 0)
        {
          boolean bool = i();
          if (!bool) {
            try
            {
              com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioMixController", "wait read data");
              this.m.wait();
            }
            catch (Exception localException)
            {
              com.tencent.luggage.wxa.gw.b.a("MicroMsg.Mix.AudioMixController", localException, "readMixDataFromPcmTrack", new Object[0]);
            }
          }
        }
        return this.n;
      }
    }
    for (;;)
    {
      throw localObject4;
    }
  }
  
  public boolean j(String paramString)
  {
    if (!this.h.contains(paramString)) {
      return true;
    }
    paramString = (List)this.j.get(paramString);
    if ((paramString != null) && (paramString.size() != 0)) {
      return false;
    }
    com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioMixController", "queue size is 0");
    return true;
  }
  
  public String k(String paramString)
  {
    paramString = (WeakReference)this.l.get(paramString);
    if ((paramString != null) && (paramString.get() != null))
    {
      paramString = (c)paramString.get();
      if (paramString != null) {
        return paramString.y();
      }
    }
    return "";
  }
  
  public void k()
  {
    com.tencent.luggage.wxa.gw.b.b("MicroMsg.Mix.AudioMixController", "clearCache");
    synchronized (this.m)
    {
      m();
      this.i.clear();
      return;
    }
  }
  
  public long l()
  {
    return this.t;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gs.d
 * JD-Core Version:    0.7.0.1
 */
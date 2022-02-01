package com.tencent.luggage.wxa.hj;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.hs.b;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

class d
{
  private static volatile d a;
  private Map<String, Class<?>> b = new HashMap();
  private Handler c = l.a();
  private final Map<String, d.a> d = new ConcurrentHashMap();
  private volatile boolean e;
  private final Map<String, Set<n>> f = new HashMap();
  private final Map<String, Set<o>> g = new HashMap();
  private final Map<String, Set<m>> h = new HashMap();
  
  public static d a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new d();
        }
      }
      finally {}
    }
    return a;
  }
  
  private Class<?> a(String paramString1, String paramString2)
  {
    Map localMap = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append('/');
    localStringBuilder.append(paramString2);
    return (Class)localMap.get(localStringBuilder.toString());
  }
  
  private static long b()
  {
    if (Looper.myLooper() == Looper.getMainLooper()) {
      return 3000L;
    }
    return 10000L;
  }
  
  private void c(String paramString)
  {
    synchronized (this.h)
    {
      paramString = (Set)this.h.get(paramString);
      if (paramString != null)
      {
        paramString = paramString.iterator();
        while (paramString.hasNext()) {
          ((m)paramString.next()).a();
        }
      }
      return;
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  private void d(String paramString)
  {
    synchronized (this.g)
    {
      paramString = (Set)this.g.get(paramString);
      if (paramString != null)
      {
        paramString = paramString.iterator();
        while (paramString.hasNext()) {
          ((o)paramString.next()).a();
        }
      }
      return;
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  private void e(String paramString)
  {
    synchronized (this.f)
    {
      paramString = (Set)this.f.get(paramString);
      if (paramString != null)
      {
        paramString = paramString.iterator();
        while (paramString.hasNext()) {
          ((n)paramString.next()).a();
        }
      }
      return;
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  /* Error */
  @androidx.annotation.WorkerThread
  public com.tencent.luggage.wxa.hl.a a(@NonNull String paramString)
  {
    // Byte code:
    //   0: invokestatic 140	android/os/SystemClock:elapsedRealtimeNanos	()J
    //   3: lstore_3
    //   4: ldc 142
    //   6: ldc 144
    //   8: iconst_2
    //   9: anewarray 4	java/lang/Object
    //   12: dup
    //   13: iconst_0
    //   14: lload_3
    //   15: invokestatic 150	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   18: aastore
    //   19: dup
    //   20: iconst_1
    //   21: aload_1
    //   22: aastore
    //   23: invokestatic 155	com/tencent/luggage/wxa/hs/b:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   26: aload_0
    //   27: getfield 35	com/tencent/luggage/wxa/hj/d:d	Ljava/util/Map;
    //   30: aload_1
    //   31: invokeinterface 74 2 0
    //   36: checkcast 157	com/tencent/luggage/wxa/hj/d$a
    //   39: astore 10
    //   41: aload 10
    //   43: ifnonnull +554 -> 597
    //   46: ldc 142
    //   48: ldc 159
    //   50: iconst_4
    //   51: anewarray 4	java/lang/Object
    //   54: dup
    //   55: iconst_0
    //   56: invokestatic 163	com/tencent/luggage/wxa/hj/g:b	()Ljava/lang/String;
    //   59: aastore
    //   60: dup
    //   61: iconst_1
    //   62: aload_1
    //   63: aastore
    //   64: dup
    //   65: iconst_2
    //   66: lload_3
    //   67: invokestatic 150	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   70: aastore
    //   71: dup
    //   72: iconst_3
    //   73: aload_1
    //   74: aastore
    //   75: invokestatic 155	com/tencent/luggage/wxa/hs/b:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   78: aload_0
    //   79: getfield 165	com/tencent/luggage/wxa/hj/d:e	Z
    //   82: ifeq +27 -> 109
    //   85: ldc 142
    //   87: ldc 167
    //   89: iconst_2
    //   90: anewarray 4	java/lang/Object
    //   93: dup
    //   94: iconst_0
    //   95: aload_1
    //   96: aastore
    //   97: dup
    //   98: iconst_1
    //   99: lload_3
    //   100: invokestatic 150	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   103: aastore
    //   104: invokestatic 155	com/tencent/luggage/wxa/hs/b:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   107: aconst_null
    //   108: areturn
    //   109: invokestatic 93	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   112: invokestatic 90	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   115: if_acmpne +36 -> 151
    //   118: ldc 142
    //   120: ldc 169
    //   122: iconst_1
    //   123: anewarray 4	java/lang/Object
    //   126: dup
    //   127: iconst_0
    //   128: lload_3
    //   129: invokestatic 150	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   132: aastore
    //   133: invokestatic 171	com/tencent/luggage/wxa/hs/b:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   136: new 173	com/tencent/luggage/wxa/hj/d$1
    //   139: dup
    //   140: aload_0
    //   141: aload_1
    //   142: invokespecial 175	com/tencent/luggage/wxa/hj/d$1:<init>	(Lcom/tencent/luggage/wxa/hj/d;Ljava/lang/String;)V
    //   145: invokestatic 178	com/tencent/luggage/wxa/hj/l:a	(Ljava/lang/Runnable;)Z
    //   148: pop
    //   149: aconst_null
    //   150: areturn
    //   151: aload_1
    //   152: invokestatic 181	com/tencent/luggage/wxa/hj/g:a	()Landroid/content/Context;
    //   155: invokevirtual 186	android/content/Context:getPackageName	()Ljava/lang/String;
    //   158: invokestatic 191	com/tencent/luggage/wxa/hs/c:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   161: astore 12
    //   163: aload_0
    //   164: aload 12
    //   166: aload_1
    //   167: invokespecial 193	com/tencent/luggage/wxa/hj/d:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Class;
    //   170: astore 13
    //   172: aload 13
    //   174: ifnonnull +27 -> 201
    //   177: ldc 142
    //   179: ldc 195
    //   181: iconst_2
    //   182: anewarray 4	java/lang/Object
    //   185: dup
    //   186: iconst_0
    //   187: aload_1
    //   188: aastore
    //   189: dup
    //   190: iconst_1
    //   191: lload_3
    //   192: invokestatic 150	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   195: aastore
    //   196: invokestatic 171	com/tencent/luggage/wxa/hs/b:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   199: aconst_null
    //   200: areturn
    //   201: new 157	com/tencent/luggage/wxa/hj/d$a
    //   204: dup
    //   205: aconst_null
    //   206: invokespecial 198	com/tencent/luggage/wxa/hj/d$a:<init>	(Lcom/tencent/luggage/wxa/hj/d$1;)V
    //   209: astore 11
    //   211: aload_0
    //   212: getfield 35	com/tencent/luggage/wxa/hj/d:d	Ljava/util/Map;
    //   215: astore 10
    //   217: aload 10
    //   219: monitorenter
    //   220: aload_0
    //   221: getfield 35	com/tencent/luggage/wxa/hj/d:d	Ljava/util/Map;
    //   224: aload_1
    //   225: aload 11
    //   227: invokeinterface 202 3 0
    //   232: pop
    //   233: aload 10
    //   235: monitorexit
    //   236: aload 11
    //   238: monitorenter
    //   239: aload 11
    //   241: iconst_1
    //   242: putfield 204	com/tencent/luggage/wxa/hj/d$a:c	Z
    //   245: aload 11
    //   247: monitorexit
    //   248: invokestatic 181	com/tencent/luggage/wxa/hj/g:a	()Landroid/content/Context;
    //   251: astore 14
    //   253: aload 11
    //   255: astore 10
    //   257: aload 10
    //   259: new 206	com/tencent/luggage/wxa/hj/d$2
    //   262: dup
    //   263: aload_0
    //   264: aload_1
    //   265: aload 11
    //   267: lload_3
    //   268: aload 14
    //   270: invokespecial 209	com/tencent/luggage/wxa/hj/d$2:<init>	(Lcom/tencent/luggage/wxa/hj/d;Ljava/lang/String;Lcom/tencent/luggage/wxa/hj/d$a;JLandroid/content/Context;)V
    //   273: putfield 212	com/tencent/luggage/wxa/hj/d$a:b	Landroid/content/ServiceConnection;
    //   276: new 214	android/content/Intent
    //   279: dup
    //   280: invokespecial 215	android/content/Intent:<init>	()V
    //   283: aload 12
    //   285: aload 13
    //   287: invokevirtual 218	java/lang/Class:getCanonicalName	()Ljava/lang/String;
    //   290: invokevirtual 222	android/content/Intent:setClassName	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   293: astore 11
    //   295: aload 11
    //   297: ldc 224
    //   299: lload_3
    //   300: invokevirtual 228	android/content/Intent:putExtra	(Ljava/lang/String;J)Landroid/content/Intent;
    //   303: pop
    //   304: aload 11
    //   306: ldc 230
    //   308: invokestatic 163	com/tencent/luggage/wxa/hj/g:b	()Ljava/lang/String;
    //   311: invokevirtual 232	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   314: pop
    //   315: aload 10
    //   317: invokevirtual 236	java/lang/Object:hashCode	()I
    //   320: istore_2
    //   321: invokestatic 242	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   324: invokevirtual 245	java/lang/Thread:getId	()J
    //   327: lstore 5
    //   329: ldc 142
    //   331: ldc 247
    //   333: iconst_4
    //   334: anewarray 4	java/lang/Object
    //   337: dup
    //   338: iconst_0
    //   339: iload_2
    //   340: invokestatic 252	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   343: aastore
    //   344: dup
    //   345: iconst_1
    //   346: lload_3
    //   347: invokestatic 150	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   350: aastore
    //   351: dup
    //   352: iconst_2
    //   353: lload 5
    //   355: invokestatic 150	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   358: aastore
    //   359: dup
    //   360: iconst_3
    //   361: aload 11
    //   363: aastore
    //   364: invokestatic 155	com/tencent/luggage/wxa/hs/b:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   367: aload 14
    //   369: aload 11
    //   371: aload 10
    //   373: getfield 212	com/tencent/luggage/wxa/hj/d$a:b	Landroid/content/ServiceConnection;
    //   376: bipush 33
    //   378: invokevirtual 256	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   381: pop
    //   382: aload 10
    //   384: new 258	com/tencent/luggage/wxa/hj/d$3
    //   387: dup
    //   388: aload_0
    //   389: aload 10
    //   391: lload_3
    //   392: aload_1
    //   393: invokespecial 261	com/tencent/luggage/wxa/hj/d$3:<init>	(Lcom/tencent/luggage/wxa/hj/d;Lcom/tencent/luggage/wxa/hj/d$a;JLjava/lang/String;)V
    //   396: putfield 264	com/tencent/luggage/wxa/hj/d$a:d	Ljava/lang/Runnable;
    //   399: aload_0
    //   400: getfield 42	com/tencent/luggage/wxa/hj/d:c	Landroid/os/Handler;
    //   403: aload 10
    //   405: getfield 264	com/tencent/luggage/wxa/hj/d$a:d	Ljava/lang/Runnable;
    //   408: invokestatic 266	com/tencent/luggage/wxa/hj/d:b	()J
    //   411: invokevirtual 272	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   414: pop
    //   415: aload 10
    //   417: monitorenter
    //   418: aload 10
    //   420: getfield 204	com/tencent/luggage/wxa/hj/d$a:c	Z
    //   423: ifeq +8 -> 431
    //   426: aload 10
    //   428: invokevirtual 275	java/lang/Object:wait	()V
    //   431: aload 10
    //   433: monitorexit
    //   434: aload 10
    //   436: monitorenter
    //   437: aload 10
    //   439: iconst_0
    //   440: putfield 204	com/tencent/luggage/wxa/hj/d$a:c	Z
    //   443: aload 10
    //   445: monitorexit
    //   446: goto +396 -> 842
    //   449: astore_1
    //   450: aload 10
    //   452: monitorexit
    //   453: aload_1
    //   454: athrow
    //   455: astore 11
    //   457: aload 10
    //   459: monitorexit
    //   460: aload 11
    //   462: athrow
    //   463: astore 11
    //   465: goto +9 -> 474
    //   468: astore_1
    //   469: goto +92 -> 561
    //   472: astore 11
    //   474: ldc 142
    //   476: ldc_w 277
    //   479: iconst_3
    //   480: anewarray 4	java/lang/Object
    //   483: dup
    //   484: iconst_0
    //   485: aload 10
    //   487: invokevirtual 236	java/lang/Object:hashCode	()I
    //   490: invokestatic 252	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   493: aastore
    //   494: dup
    //   495: iconst_1
    //   496: lload_3
    //   497: invokestatic 150	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   500: aastore
    //   501: dup
    //   502: iconst_2
    //   503: aload 11
    //   505: invokestatic 283	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   508: aastore
    //   509: invokestatic 285	com/tencent/luggage/wxa/hs/b:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   512: aload_0
    //   513: getfield 35	com/tencent/luggage/wxa/hj/d:d	Ljava/util/Map;
    //   516: astore 11
    //   518: aload 11
    //   520: monitorenter
    //   521: aload_0
    //   522: getfield 35	com/tencent/luggage/wxa/hj/d:d	Ljava/util/Map;
    //   525: aload_1
    //   526: invokeinterface 288 2 0
    //   531: pop
    //   532: aload 11
    //   534: monitorexit
    //   535: aload 10
    //   537: monitorenter
    //   538: aload 10
    //   540: iconst_0
    //   541: putfield 204	com/tencent/luggage/wxa/hj/d$a:c	Z
    //   544: aload 10
    //   546: monitorexit
    //   547: aconst_null
    //   548: areturn
    //   549: astore_1
    //   550: aload 10
    //   552: monitorexit
    //   553: aload_1
    //   554: athrow
    //   555: astore_1
    //   556: aload 11
    //   558: monitorexit
    //   559: aload_1
    //   560: athrow
    //   561: aload 10
    //   563: monitorenter
    //   564: aload 10
    //   566: iconst_0
    //   567: putfield 204	com/tencent/luggage/wxa/hj/d$a:c	Z
    //   570: aload 10
    //   572: monitorexit
    //   573: aload_1
    //   574: athrow
    //   575: astore_1
    //   576: aload 10
    //   578: monitorexit
    //   579: aload_1
    //   580: athrow
    //   581: astore_1
    //   582: aload 11
    //   584: monitorexit
    //   585: aload_1
    //   586: athrow
    //   587: astore_1
    //   588: goto -6 -> 582
    //   591: astore_1
    //   592: aload 10
    //   594: monitorexit
    //   595: aload_1
    //   596: athrow
    //   597: aload 10
    //   599: getfield 204	com/tencent/luggage/wxa/hj/d$a:c	Z
    //   602: ifeq +240 -> 842
    //   605: invokestatic 291	android/os/SystemClock:elapsedRealtime	()J
    //   608: lstore 5
    //   610: aload 10
    //   612: monitorenter
    //   613: aload 10
    //   615: getfield 204	com/tencent/luggage/wxa/hj/d$a:c	Z
    //   618: ifeq +8 -> 626
    //   621: aload 10
    //   623: invokevirtual 275	java/lang/Object:wait	()V
    //   626: aload 10
    //   628: monitorexit
    //   629: invokestatic 291	android/os/SystemClock:elapsedRealtime	()J
    //   632: lstore 7
    //   634: ldc 142
    //   636: ldc_w 293
    //   639: iconst_4
    //   640: anewarray 4	java/lang/Object
    //   643: dup
    //   644: iconst_0
    //   645: aload 10
    //   647: invokevirtual 236	java/lang/Object:hashCode	()I
    //   650: invokestatic 252	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   653: aastore
    //   654: dup
    //   655: iconst_1
    //   656: lload_3
    //   657: invokestatic 150	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   660: aastore
    //   661: dup
    //   662: iconst_2
    //   663: aload_1
    //   664: aastore
    //   665: dup
    //   666: iconst_3
    //   667: lload 7
    //   669: lload 5
    //   671: lsub
    //   672: invokestatic 150	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   675: aastore
    //   676: invokestatic 155	com/tencent/luggage/wxa/hs/b:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   679: goto +163 -> 842
    //   682: astore 11
    //   684: aload 10
    //   686: monitorexit
    //   687: aload 11
    //   689: athrow
    //   690: astore 11
    //   692: goto +97 -> 789
    //   695: astore 11
    //   697: ldc 142
    //   699: ldc_w 295
    //   702: iconst_4
    //   703: anewarray 4	java/lang/Object
    //   706: dup
    //   707: iconst_0
    //   708: aload 10
    //   710: invokevirtual 236	java/lang/Object:hashCode	()I
    //   713: invokestatic 252	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   716: aastore
    //   717: dup
    //   718: iconst_1
    //   719: lload_3
    //   720: invokestatic 150	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   723: aastore
    //   724: dup
    //   725: iconst_2
    //   726: aload_1
    //   727: aastore
    //   728: dup
    //   729: iconst_3
    //   730: aload 11
    //   732: aastore
    //   733: invokestatic 285	com/tencent/luggage/wxa/hs/b:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   736: invokestatic 291	android/os/SystemClock:elapsedRealtime	()J
    //   739: lstore 7
    //   741: ldc 142
    //   743: ldc_w 293
    //   746: iconst_4
    //   747: anewarray 4	java/lang/Object
    //   750: dup
    //   751: iconst_0
    //   752: aload 10
    //   754: invokevirtual 236	java/lang/Object:hashCode	()I
    //   757: invokestatic 252	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   760: aastore
    //   761: dup
    //   762: iconst_1
    //   763: lload_3
    //   764: invokestatic 150	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   767: aastore
    //   768: dup
    //   769: iconst_2
    //   770: aload_1
    //   771: aastore
    //   772: dup
    //   773: iconst_3
    //   774: lload 7
    //   776: lload 5
    //   778: lsub
    //   779: invokestatic 150	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   782: aastore
    //   783: invokestatic 155	com/tencent/luggage/wxa/hs/b:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   786: goto +56 -> 842
    //   789: invokestatic 291	android/os/SystemClock:elapsedRealtime	()J
    //   792: lstore 7
    //   794: ldc 142
    //   796: ldc_w 293
    //   799: iconst_4
    //   800: anewarray 4	java/lang/Object
    //   803: dup
    //   804: iconst_0
    //   805: aload 10
    //   807: invokevirtual 236	java/lang/Object:hashCode	()I
    //   810: invokestatic 252	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   813: aastore
    //   814: dup
    //   815: iconst_1
    //   816: lload_3
    //   817: invokestatic 150	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   820: aastore
    //   821: dup
    //   822: iconst_2
    //   823: aload_1
    //   824: aastore
    //   825: dup
    //   826: iconst_3
    //   827: lload 7
    //   829: lload 5
    //   831: lsub
    //   832: invokestatic 150	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   835: aastore
    //   836: invokestatic 155	com/tencent/luggage/wxa/hs/b:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   839: aload 11
    //   841: athrow
    //   842: aload 10
    //   844: getfield 298	com/tencent/luggage/wxa/hj/d$a:a	Lcom/tencent/luggage/wxa/hl/a;
    //   847: ifnull +62 -> 909
    //   850: aload 10
    //   852: getfield 298	com/tencent/luggage/wxa/hj/d$a:a	Lcom/tencent/luggage/wxa/hl/a;
    //   855: invokeinterface 304 1 0
    //   860: invokeinterface 309 1 0
    //   865: istore 9
    //   867: ldc 142
    //   869: ldc_w 311
    //   872: iconst_4
    //   873: anewarray 4	java/lang/Object
    //   876: dup
    //   877: iconst_0
    //   878: aload 10
    //   880: invokevirtual 236	java/lang/Object:hashCode	()I
    //   883: invokestatic 252	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   886: aastore
    //   887: dup
    //   888: iconst_1
    //   889: lload_3
    //   890: invokestatic 150	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   893: aastore
    //   894: dup
    //   895: iconst_2
    //   896: aload_1
    //   897: aastore
    //   898: dup
    //   899: iconst_3
    //   900: iload 9
    //   902: invokestatic 316	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   905: aastore
    //   906: invokestatic 155	com/tencent/luggage/wxa/hs/b:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   909: aload 10
    //   911: getfield 298	com/tencent/luggage/wxa/hj/d$a:a	Lcom/tencent/luggage/wxa/hl/a;
    //   914: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	915	0	this	d
    //   0	915	1	paramString	String
    //   320	20	2	i	int
    //   3	887	3	l1	long
    //   327	503	5	l2	long
    //   632	196	7	l3	long
    //   865	36	9	bool	boolean
    //   39	871	10	localObject1	Object
    //   209	161	11	localObject2	Object
    //   455	6	11	localObject3	Object
    //   463	1	11	localException1	Exception
    //   472	32	11	localException2	Exception
    //   516	67	11	localMap	Map
    //   682	6	11	localObject4	Object
    //   690	1	11	localObject5	Object
    //   695	145	11	localInterruptedException	java.lang.InterruptedException
    //   161	123	12	str	String
    //   170	116	13	localClass	Class
    //   251	117	14	localContext	Context
    // Exception table:
    //   from	to	target	type
    //   437	446	449	finally
    //   450	453	449	finally
    //   418	431	455	finally
    //   431	434	455	finally
    //   457	460	455	finally
    //   329	418	463	java/lang/Exception
    //   460	463	463	java/lang/Exception
    //   276	329	468	finally
    //   329	418	468	finally
    //   460	463	468	finally
    //   474	521	468	finally
    //   559	561	468	finally
    //   276	329	472	java/lang/Exception
    //   538	547	549	finally
    //   550	553	549	finally
    //   521	535	555	finally
    //   556	559	555	finally
    //   564	573	575	finally
    //   576	579	575	finally
    //   239	248	581	finally
    //   582	585	587	finally
    //   220	236	591	finally
    //   592	595	591	finally
    //   613	626	682	finally
    //   626	629	682	finally
    //   684	687	682	finally
    //   610	613	690	finally
    //   687	690	690	finally
    //   697	736	690	finally
    //   610	613	695	java/lang/InterruptedException
    //   687	690	695	java/lang/InterruptedException
  }
  
  public void a(String paramString, m paramm)
  {
    if (paramm == null) {
      return;
    }
    synchronized (this.h)
    {
      Set localSet = (Set)this.h.get(paramString);
      Object localObject = localSet;
      if (localSet == null) {
        localObject = new HashSet();
      }
      ((Set)localObject).add(paramm);
      this.h.put(paramString, localObject);
      return;
    }
  }
  
  public <T extends a> void a(String paramString1, String paramString2, Class<T> paramClass)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("/");
    localStringBuilder.append(paramString2);
    paramString1 = localStringBuilder.toString();
    paramString2 = (Class)this.b.get(paramString1);
    if ((paramString2 != null) && (paramString2 != paramClass)) {
      b.c("IPC.IPCBridgeManager", "warning: override ipc service: %s -> %s, stack:%s", new Object[] { paramString1, paramString2, Log.getStackTraceString(new Throwable()) });
    }
    this.b.put(paramString1, paramClass);
  }
  
  public void b(@NonNull String paramString)
  {
    if (g.a(paramString))
    {
      b.a("IPC.IPCBridgeManager", "the same process(%s), do not need to release IPCBridge.", new Object[] { paramString });
      return;
    }
    synchronized (this.d)
    {
      d.a locala = (d.a)this.d.get(paramString);
      if (locala == null)
      {
        b.a("IPC.IPCBridgeManager", "releaseIPCBridge(%s) failed, IPCBridgeWrapper is null.", new Object[] { paramString });
        return;
      }
      if (locala.c) {
        try
        {
          locala.c = false;
          locala.notifyAll();
        }
        finally {}
      }
      if (locala.b == null)
      {
        b.a("IPC.IPCBridgeManager", "releaseIPCBridge(%s) failed, ServiceConnection is null.", new Object[] { paramString });
        return;
      }
      ??? = locala.b;
      try
      {
        g.a().unbindService((ServiceConnection)???);
      }
      catch (Exception localException)
      {
        b.b("IPC.IPCBridgeManager", "unbindService(%s) error, %s", new Object[] { paramString, Log.getStackTraceString(localException) });
      }
      synchronized (this.d)
      {
        this.d.remove(paramString);
        try
        {
          locala.a = null;
          locala.c = false;
          locala.b = null;
          return;
        }
        finally {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hj.d
 * JD-Core Version:    0.7.0.1
 */
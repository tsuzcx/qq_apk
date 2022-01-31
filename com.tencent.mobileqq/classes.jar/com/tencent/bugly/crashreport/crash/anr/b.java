package com.tencent.bugly.crashreport.crash.anr;

import android.content.Context;
import android.os.FileObserver;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.c;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.y;
import com.tencent.bugly.proguard.z;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public final class b
{
  private AtomicInteger a = new AtomicInteger(0);
  private long b = -1L;
  private final Context c;
  private final com.tencent.bugly.crashreport.common.info.a d;
  private final w e;
  private final com.tencent.bugly.crashreport.common.strategy.a f;
  private final String g;
  private final com.tencent.bugly.crashreport.crash.b h;
  private FileObserver i;
  private boolean j = true;
  
  public b(Context paramContext, com.tencent.bugly.crashreport.common.strategy.a parama, com.tencent.bugly.crashreport.common.info.a parama1, w paramw, com.tencent.bugly.crashreport.crash.b paramb)
  {
    this.c = z.a(paramContext);
    this.g = paramContext.getDir("bugly", 0).getAbsolutePath();
    this.d = parama1;
    this.e = paramw;
    this.f = parama;
    this.h = paramb;
  }
  
  private CrashDetailBean a(a parama)
  {
    localCrashDetailBean = new CrashDetailBean();
    try
    {
      localCrashDetailBean.C = com.tencent.bugly.crashreport.common.info.b.h();
      localCrashDetailBean.D = com.tencent.bugly.crashreport.common.info.b.f();
      localCrashDetailBean.E = com.tencent.bugly.crashreport.common.info.b.j();
      localCrashDetailBean.F = this.d.o();
      localCrashDetailBean.G = this.d.n();
      localCrashDetailBean.H = this.d.p();
      localCrashDetailBean.w = z.a(this.c, c.e, c.h);
      localCrashDetailBean.b = 3;
      localCrashDetailBean.e = this.d.g();
      localCrashDetailBean.f = this.d.l;
      localCrashDetailBean.g = this.d.v();
      localCrashDetailBean.m = this.d.f();
      localCrashDetailBean.n = "ANR_EXCEPTION";
      localCrashDetailBean.o = parama.f;
      localCrashDetailBean.q = parama.g;
      localCrashDetailBean.O = new HashMap();
      localCrashDetailBean.O.put("BUGLY_CR_01", parama.e);
      int k = -1;
      if (localCrashDetailBean.q != null) {
        k = localCrashDetailBean.q.indexOf("\n");
      }
      if (k > 0) {}
      for (String str = localCrashDetailBean.q.substring(0, k);; str = "GET_FAIL")
      {
        localCrashDetailBean.p = str;
        localCrashDetailBean.r = parama.c;
        if (localCrashDetailBean.q != null) {
          localCrashDetailBean.u = z.b(localCrashDetailBean.q.getBytes());
        }
        localCrashDetailBean.z = parama.b;
        localCrashDetailBean.A = parama.a;
        localCrashDetailBean.B = "main(1)";
        localCrashDetailBean.I = this.d.x();
        localCrashDetailBean.h = this.d.u();
        localCrashDetailBean.i = this.d.I();
        localCrashDetailBean.v = parama.d;
        localCrashDetailBean.L = this.d.p;
        localCrashDetailBean.M = this.d.a;
        localCrashDetailBean.N = this.d.a();
        localCrashDetailBean.P = this.d.G();
        localCrashDetailBean.Q = this.d.H();
        localCrashDetailBean.R = this.d.A();
        localCrashDetailBean.S = this.d.F();
        this.h.c(localCrashDetailBean);
        localCrashDetailBean.y = y.a();
        return localCrashDetailBean;
      }
      return localCrashDetailBean;
    }
    catch (Throwable parama)
    {
      if (!x.a(parama)) {
        parama.printStackTrace();
      }
    }
  }
  
  /* Error */
  private static boolean a(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aload_2
    //   1: aload_0
    //   2: iconst_1
    //   3: invokestatic 316	com/tencent/bugly/crashreport/crash/anr/TraceFileHelper:readTargetDumpInfo	(Ljava/lang/String;Ljava/lang/String;Z)Lcom/tencent/bugly/crashreport/crash/anr/TraceFileHelper$a;
    //   6: astore_3
    //   7: aload_3
    //   8: ifnull +22 -> 30
    //   11: aload_3
    //   12: getfield 320	com/tencent/bugly/crashreport/crash/anr/TraceFileHelper$a:d	Ljava/util/Map;
    //   15: ifnull +15 -> 30
    //   18: aload_3
    //   19: getfield 320	com/tencent/bugly/crashreport/crash/anr/TraceFileHelper$a:d	Ljava/util/Map;
    //   22: invokeinterface 323 1 0
    //   27: ifgt +20 -> 47
    //   30: ldc_w 325
    //   33: iconst_1
    //   34: anewarray 4	java/lang/Object
    //   37: dup
    //   38: iconst_0
    //   39: aload_2
    //   40: aastore
    //   41: invokestatic 328	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   44: pop
    //   45: iconst_0
    //   46: ireturn
    //   47: new 63	java/io/File
    //   50: dup
    //   51: aload_1
    //   52: invokespecial 331	java/io/File:<init>	(Ljava/lang/String;)V
    //   55: astore_2
    //   56: aload_2
    //   57: invokevirtual 334	java/io/File:exists	()Z
    //   60: ifne +26 -> 86
    //   63: aload_2
    //   64: invokevirtual 338	java/io/File:getParentFile	()Ljava/io/File;
    //   67: invokevirtual 334	java/io/File:exists	()Z
    //   70: ifne +11 -> 81
    //   73: aload_2
    //   74: invokevirtual 338	java/io/File:getParentFile	()Ljava/io/File;
    //   77: invokevirtual 341	java/io/File:mkdirs	()Z
    //   80: pop
    //   81: aload_2
    //   82: invokevirtual 344	java/io/File:createNewFile	()Z
    //   85: pop
    //   86: aload_2
    //   87: invokevirtual 334	java/io/File:exists	()Z
    //   90: ifeq +10 -> 100
    //   93: aload_2
    //   94: invokevirtual 347	java/io/File:canWrite	()Z
    //   97: ifne +85 -> 182
    //   100: ldc_w 349
    //   103: iconst_1
    //   104: anewarray 4	java/lang/Object
    //   107: dup
    //   108: iconst_0
    //   109: aload_1
    //   110: aastore
    //   111: invokestatic 328	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   114: pop
    //   115: iconst_0
    //   116: ireturn
    //   117: astore_0
    //   118: aload_0
    //   119: invokestatic 302	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   122: ifne +7 -> 129
    //   125: aload_0
    //   126: invokevirtual 350	java/lang/Exception:printStackTrace	()V
    //   129: ldc_w 352
    //   132: iconst_2
    //   133: anewarray 4	java/lang/Object
    //   136: dup
    //   137: iconst_0
    //   138: new 354	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 355	java/lang/StringBuilder:<init>	()V
    //   145: aload_0
    //   146: invokevirtual 359	java/lang/Object:getClass	()Ljava/lang/Class;
    //   149: invokevirtual 364	java/lang/Class:getName	()Ljava/lang/String;
    //   152: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: ldc_w 370
    //   158: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: aload_0
    //   162: invokevirtual 373	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   165: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: invokevirtual 376	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: aastore
    //   172: dup
    //   173: iconst_1
    //   174: aload_1
    //   175: aastore
    //   176: invokestatic 328	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   179: pop
    //   180: iconst_0
    //   181: ireturn
    //   182: aconst_null
    //   183: astore_0
    //   184: new 378	java/io/BufferedWriter
    //   187: dup
    //   188: new 380	java/io/FileWriter
    //   191: dup
    //   192: aload_2
    //   193: iconst_0
    //   194: invokespecial 383	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   197: invokespecial 386	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   200: astore_1
    //   201: aload_3
    //   202: getfield 320	com/tencent/bugly/crashreport/crash/anr/TraceFileHelper$a:d	Ljava/util/Map;
    //   205: ldc_w 388
    //   208: invokeinterface 392 2 0
    //   213: checkcast 394	[Ljava/lang/String;
    //   216: astore 4
    //   218: aload 4
    //   220: ifnull +77 -> 297
    //   223: aload 4
    //   225: arraylength
    //   226: iconst_3
    //   227: if_icmplt +70 -> 297
    //   230: aload 4
    //   232: iconst_0
    //   233: aaload
    //   234: astore_0
    //   235: aload 4
    //   237: iconst_1
    //   238: aaload
    //   239: astore_2
    //   240: aload 4
    //   242: iconst_2
    //   243: aaload
    //   244: astore 4
    //   246: aload_1
    //   247: new 354	java/lang/StringBuilder
    //   250: dup
    //   251: ldc_w 396
    //   254: invokespecial 397	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   257: aload 4
    //   259: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: ldc_w 399
    //   265: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: aload_0
    //   269: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: ldc 186
    //   274: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: aload_2
    //   278: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: ldc_w 401
    //   284: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: invokevirtual 376	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   290: invokevirtual 404	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   293: aload_1
    //   294: invokevirtual 407	java/io/BufferedWriter:flush	()V
    //   297: aload_3
    //   298: getfield 320	com/tencent/bugly/crashreport/crash/anr/TraceFileHelper$a:d	Ljava/util/Map;
    //   301: invokeinterface 411 1 0
    //   306: invokeinterface 417 1 0
    //   311: astore_0
    //   312: aload_0
    //   313: invokeinterface 422 1 0
    //   318: ifeq +238 -> 556
    //   321: aload_0
    //   322: invokeinterface 426 1 0
    //   327: checkcast 428	java/util/Map$Entry
    //   330: astore_2
    //   331: aload_2
    //   332: invokeinterface 431 1 0
    //   337: checkcast 188	java/lang/String
    //   340: ldc_w 388
    //   343: invokevirtual 435	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   346: ifne -34 -> 312
    //   349: aload_2
    //   350: invokeinterface 438 1 0
    //   355: ifnull -43 -> 312
    //   358: aload_2
    //   359: invokeinterface 438 1 0
    //   364: checkcast 394	[Ljava/lang/String;
    //   367: arraylength
    //   368: iconst_3
    //   369: if_icmplt -57 -> 312
    //   372: aload_2
    //   373: invokeinterface 438 1 0
    //   378: checkcast 394	[Ljava/lang/String;
    //   381: iconst_0
    //   382: aaload
    //   383: astore_3
    //   384: aload_2
    //   385: invokeinterface 438 1 0
    //   390: checkcast 394	[Ljava/lang/String;
    //   393: iconst_1
    //   394: aaload
    //   395: astore 4
    //   397: aload_2
    //   398: invokeinterface 438 1 0
    //   403: checkcast 394	[Ljava/lang/String;
    //   406: iconst_2
    //   407: aaload
    //   408: astore 5
    //   410: aload_1
    //   411: new 354	java/lang/StringBuilder
    //   414: dup
    //   415: ldc_w 440
    //   418: invokespecial 397	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   421: aload_2
    //   422: invokeinterface 431 1 0
    //   427: checkcast 188	java/lang/String
    //   430: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   433: ldc_w 442
    //   436: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: aload 5
    //   441: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: ldc_w 399
    //   447: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: aload_3
    //   451: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   454: ldc 186
    //   456: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: aload 4
    //   461: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: ldc_w 401
    //   467: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   470: invokevirtual 376	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   473: invokevirtual 404	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   476: aload_1
    //   477: invokevirtual 407	java/io/BufferedWriter:flush	()V
    //   480: goto -168 -> 312
    //   483: astore_2
    //   484: aload_1
    //   485: astore_0
    //   486: aload_2
    //   487: astore_1
    //   488: aload_1
    //   489: invokestatic 302	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   492: ifne +7 -> 499
    //   495: aload_1
    //   496: invokevirtual 443	java/io/IOException:printStackTrace	()V
    //   499: ldc_w 445
    //   502: iconst_1
    //   503: anewarray 4	java/lang/Object
    //   506: dup
    //   507: iconst_0
    //   508: new 354	java/lang/StringBuilder
    //   511: dup
    //   512: invokespecial 355	java/lang/StringBuilder:<init>	()V
    //   515: aload_1
    //   516: invokevirtual 359	java/lang/Object:getClass	()Ljava/lang/Class;
    //   519: invokevirtual 364	java/lang/Class:getName	()Ljava/lang/String;
    //   522: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   525: ldc_w 370
    //   528: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   531: aload_1
    //   532: invokevirtual 446	java/io/IOException:getMessage	()Ljava/lang/String;
    //   535: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   538: invokevirtual 376	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   541: aastore
    //   542: invokestatic 328	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   545: pop
    //   546: aload_0
    //   547: ifnull +7 -> 554
    //   550: aload_0
    //   551: invokevirtual 449	java/io/BufferedWriter:close	()V
    //   554: iconst_0
    //   555: ireturn
    //   556: aload_1
    //   557: invokevirtual 449	java/io/BufferedWriter:close	()V
    //   560: iconst_1
    //   561: ireturn
    //   562: astore_0
    //   563: aload_0
    //   564: invokestatic 302	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   567: ifne -7 -> 560
    //   570: aload_0
    //   571: invokevirtual 443	java/io/IOException:printStackTrace	()V
    //   574: goto -14 -> 560
    //   577: astore_0
    //   578: aload_0
    //   579: invokestatic 302	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   582: ifne -28 -> 554
    //   585: aload_0
    //   586: invokevirtual 443	java/io/IOException:printStackTrace	()V
    //   589: goto -35 -> 554
    //   592: astore_0
    //   593: aconst_null
    //   594: astore_1
    //   595: aload_1
    //   596: ifnull +7 -> 603
    //   599: aload_1
    //   600: invokevirtual 449	java/io/BufferedWriter:close	()V
    //   603: aload_0
    //   604: athrow
    //   605: astore_1
    //   606: aload_1
    //   607: invokestatic 302	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   610: ifne -7 -> 603
    //   613: aload_1
    //   614: invokevirtual 443	java/io/IOException:printStackTrace	()V
    //   617: goto -14 -> 603
    //   620: astore_0
    //   621: goto -26 -> 595
    //   624: astore_2
    //   625: aload_0
    //   626: astore_1
    //   627: aload_2
    //   628: astore_0
    //   629: goto -34 -> 595
    //   632: astore_1
    //   633: goto -145 -> 488
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	636	0	paramString1	String
    //   0	636	1	paramString2	String
    //   0	636	2	paramString3	String
    //   6	445	3	localObject1	Object
    //   216	244	4	localObject2	Object
    //   408	32	5	str	String
    // Exception table:
    //   from	to	target	type
    //   56	81	117	java/lang/Exception
    //   81	86	117	java/lang/Exception
    //   201	218	483	java/io/IOException
    //   223	230	483	java/io/IOException
    //   246	297	483	java/io/IOException
    //   297	312	483	java/io/IOException
    //   312	480	483	java/io/IOException
    //   556	560	562	java/io/IOException
    //   550	554	577	java/io/IOException
    //   184	201	592	finally
    //   599	603	605	java/io/IOException
    //   201	218	620	finally
    //   223	230	620	finally
    //   246	297	620	finally
    //   297	312	620	finally
    //   312	480	620	finally
    //   488	499	624	finally
    //   499	546	624	finally
    //   184	201	632	java/io/IOException
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (;;)
    {
      try
      {
        c();
        return;
      }
      finally {}
      d();
    }
  }
  
  /* Error */
  private void c()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 456	com/tencent/bugly/crashreport/crash/anr/b:e	()Z
    //   6: ifeq +17 -> 23
    //   9: ldc_w 458
    //   12: iconst_0
    //   13: anewarray 4	java/lang/Object
    //   16: invokestatic 460	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   19: pop
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: aload_0
    //   24: new 6	com/tencent/bugly/crashreport/crash/anr/b$1
    //   27: dup
    //   28: aload_0
    //   29: ldc_w 462
    //   32: bipush 8
    //   34: invokespecial 465	com/tencent/bugly/crashreport/crash/anr/b$1:<init>	(Lcom/tencent/bugly/crashreport/crash/anr/b;Ljava/lang/String;I)V
    //   37: putfield 467	com/tencent/bugly/crashreport/crash/anr/b:i	Landroid/os/FileObserver;
    //   40: aload_0
    //   41: getfield 467	com/tencent/bugly/crashreport/crash/anr/b:i	Landroid/os/FileObserver;
    //   44: invokevirtual 472	android/os/FileObserver:startWatching	()V
    //   47: ldc_w 474
    //   50: iconst_0
    //   51: anewarray 4	java/lang/Object
    //   54: invokestatic 476	com/tencent/bugly/proguard/x:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   57: pop
    //   58: aload_0
    //   59: getfield 73	com/tencent/bugly/crashreport/crash/anr/b:e	Lcom/tencent/bugly/proguard/w;
    //   62: new 8	com/tencent/bugly/crashreport/crash/anr/b$2
    //   65: dup
    //   66: aload_0
    //   67: invokespecial 479	com/tencent/bugly/crashreport/crash/anr/b$2:<init>	(Lcom/tencent/bugly/crashreport/crash/anr/b;)V
    //   70: invokevirtual 484	com/tencent/bugly/proguard/w:a	(Ljava/lang/Runnable;)Z
    //   73: pop
    //   74: goto -54 -> 20
    //   77: astore_1
    //   78: aload_0
    //   79: aconst_null
    //   80: putfield 467	com/tencent/bugly/crashreport/crash/anr/b:i	Landroid/os/FileObserver;
    //   83: ldc_w 486
    //   86: iconst_0
    //   87: anewarray 4	java/lang/Object
    //   90: invokestatic 460	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   93: pop
    //   94: aload_1
    //   95: invokestatic 302	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   98: ifne -78 -> 20
    //   101: aload_1
    //   102: invokevirtual 305	java/lang/Throwable:printStackTrace	()V
    //   105: goto -85 -> 20
    //   108: astore_1
    //   109: aload_0
    //   110: monitorexit
    //   111: aload_1
    //   112: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	113	0	this	b
    //   77	25	1	localThrowable	Throwable
    //   108	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   40	74	77	java/lang/Throwable
    //   2	20	108	finally
    //   23	40	108	finally
    //   40	74	108	finally
    //   78	105	108	finally
  }
  
  private void c(boolean paramBoolean)
  {
    try
    {
      if (this.j != paramBoolean)
      {
        x.a("user change anr %b", new Object[] { Boolean.valueOf(paramBoolean) });
        this.j = paramBoolean;
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
  private void d()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 456	com/tencent/bugly/crashreport/crash/anr/b:e	()Z
    //   6: ifne +17 -> 23
    //   9: ldc_w 496
    //   12: iconst_0
    //   13: anewarray 4	java/lang/Object
    //   16: invokestatic 460	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   19: pop
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: aload_0
    //   24: getfield 467	com/tencent/bugly/crashreport/crash/anr/b:i	Landroid/os/FileObserver;
    //   27: invokevirtual 499	android/os/FileObserver:stopWatching	()V
    //   30: aload_0
    //   31: aconst_null
    //   32: putfield 467	com/tencent/bugly/crashreport/crash/anr/b:i	Landroid/os/FileObserver;
    //   35: ldc_w 501
    //   38: iconst_0
    //   39: anewarray 4	java/lang/Object
    //   42: invokestatic 460	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   45: pop
    //   46: goto -26 -> 20
    //   49: astore_1
    //   50: ldc_w 503
    //   53: iconst_0
    //   54: anewarray 4	java/lang/Object
    //   57: invokestatic 460	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   60: pop
    //   61: aload_1
    //   62: invokestatic 302	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   65: ifne -45 -> 20
    //   68: aload_1
    //   69: invokevirtual 305	java/lang/Throwable:printStackTrace	()V
    //   72: goto -52 -> 20
    //   75: astore_1
    //   76: aload_0
    //   77: monitorexit
    //   78: aload_1
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	b
    //   49	20	1	localThrowable	Throwable
    //   75	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   23	46	49	java/lang/Throwable
    //   2	20	75	finally
    //   23	46	75	finally
    //   50	72	75	finally
  }
  
  /* Error */
  private boolean e()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 467	com/tencent/bugly/crashreport/crash/anr/b:i	Landroid/os/FileObserver;
    //   6: astore_2
    //   7: aload_2
    //   8: ifnull +9 -> 17
    //   11: iconst_1
    //   12: istore_1
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_1
    //   16: ireturn
    //   17: iconst_0
    //   18: istore_1
    //   19: goto -6 -> 13
    //   22: astore_2
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_2
    //   26: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	27	0	this	b
    //   12	7	1	bool	boolean
    //   6	2	2	localFileObserver	FileObserver
    //   22	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	22	finally
  }
  
  private boolean f()
  {
    try
    {
      boolean bool = this.j;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void a(StrategyBean paramStrategyBean)
  {
    boolean bool = true;
    if (paramStrategyBean == null) {
      return;
    }
    for (;;)
    {
      try
      {
        if (paramStrategyBean.j != e()) {
          x.d("server anr changed to %b", new Object[] { Boolean.valueOf(paramStrategyBean.j) });
        }
        if ((paramStrategyBean.j) && (f()))
        {
          if (bool == e()) {
            break;
          }
          x.a("anr changed to %b", new Object[] { Boolean.valueOf(bool) });
          b(bool);
          break;
        }
      }
      finally {}
      bool = false;
    }
  }
  
  /* Error */
  public final void a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 40	com/tencent/bugly/crashreport/crash/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   6: invokevirtual 517	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   9: ifeq +17 -> 26
    //   12: ldc_w 519
    //   15: iconst_0
    //   16: anewarray 4	java/lang/Object
    //   19: invokestatic 521	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   22: pop
    //   23: aload_0
    //   24: monitorexit
    //   25: return
    //   26: aload_0
    //   27: getfield 40	com/tencent/bugly/crashreport/crash/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   30: iconst_1
    //   31: invokevirtual 524	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   34: aload_0
    //   35: monitorexit
    //   36: ldc_w 526
    //   39: iconst_0
    //   40: anewarray 4	java/lang/Object
    //   43: invokestatic 521	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   46: pop
    //   47: ldc2_w 41
    //   50: lstore_3
    //   51: aload_1
    //   52: iconst_0
    //   53: invokestatic 530	com/tencent/bugly/crashreport/crash/anr/TraceFileHelper:readFirstDumpInfo	(Ljava/lang/String;Z)Lcom/tencent/bugly/crashreport/crash/anr/TraceFileHelper$a;
    //   56: astore 7
    //   58: aload 7
    //   60: ifnull +9 -> 69
    //   63: aload 7
    //   65: getfield 531	com/tencent/bugly/crashreport/crash/anr/TraceFileHelper$a:c	J
    //   68: lstore_3
    //   69: lload_3
    //   70: ldc2_w 41
    //   73: lcmp
    //   74: ifne +1003 -> 1077
    //   77: ldc_w 533
    //   80: iconst_0
    //   81: anewarray 4	java/lang/Object
    //   84: invokestatic 460	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   87: pop
    //   88: invokestatic 538	java/lang/System:currentTimeMillis	()J
    //   91: lstore_3
    //   92: lload_3
    //   93: aload_0
    //   94: getfield 44	com/tencent/bugly/crashreport/crash/anr/b:b	J
    //   97: lsub
    //   98: invokestatic 544	java/lang/Math:abs	(J)J
    //   101: ldc2_w 545
    //   104: lcmp
    //   105: ifge +37 -> 142
    //   108: ldc_w 548
    //   111: iconst_1
    //   112: anewarray 4	java/lang/Object
    //   115: dup
    //   116: iconst_0
    //   117: sipush 10000
    //   120: invokestatic 553	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   123: aastore
    //   124: invokestatic 460	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   127: pop
    //   128: aload_0
    //   129: getfield 40	com/tencent/bugly/crashreport/crash/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   132: iconst_0
    //   133: invokevirtual 524	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   136: return
    //   137: astore_1
    //   138: aload_0
    //   139: monitorexit
    //   140: aload_1
    //   141: athrow
    //   142: aload_0
    //   143: lload_3
    //   144: putfield 44	com/tencent/bugly/crashreport/crash/anr/b:b	J
    //   147: aload_0
    //   148: getfield 40	com/tencent/bugly/crashreport/crash/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   151: iconst_1
    //   152: invokevirtual 524	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   155: getstatic 555	com/tencent/bugly/crashreport/crash/c:f	I
    //   158: iconst_0
    //   159: invokestatic 558	com/tencent/bugly/proguard/z:a	(IZ)Ljava/util/Map;
    //   162: astore 8
    //   164: aload 8
    //   166: ifnull +13 -> 179
    //   169: aload 8
    //   171: invokeinterface 323 1 0
    //   176: ifgt +49 -> 225
    //   179: ldc_w 560
    //   182: iconst_0
    //   183: anewarray 4	java/lang/Object
    //   186: invokestatic 460	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   189: pop
    //   190: aload_0
    //   191: getfield 40	com/tencent/bugly/crashreport/crash/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   194: iconst_0
    //   195: invokevirtual 524	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   198: return
    //   199: astore_1
    //   200: aload_1
    //   201: invokestatic 302	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   204: pop
    //   205: ldc_w 562
    //   208: iconst_0
    //   209: anewarray 4	java/lang/Object
    //   212: invokestatic 328	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   215: pop
    //   216: aload_0
    //   217: getfield 40	com/tencent/bugly/crashreport/crash/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   220: iconst_0
    //   221: invokevirtual 524	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   224: return
    //   225: aload_0
    //   226: getfield 53	com/tencent/bugly/crashreport/crash/anr/b:c	Landroid/content/Context;
    //   229: astore 7
    //   231: ldc2_w 545
    //   234: lconst_0
    //   235: lcmp
    //   236: ifge +139 -> 375
    //   239: lconst_0
    //   240: lstore 5
    //   242: ldc_w 564
    //   245: iconst_0
    //   246: anewarray 4	java/lang/Object
    //   249: invokestatic 521	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   252: pop
    //   253: aload 7
    //   255: ldc_w 566
    //   258: invokevirtual 570	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   261: checkcast 572	android/app/ActivityManager
    //   264: astore 9
    //   266: lload 5
    //   268: ldc2_w 573
    //   271: ldiv
    //   272: lstore 5
    //   274: iconst_0
    //   275: istore_2
    //   276: ldc_w 576
    //   279: iconst_0
    //   280: anewarray 4	java/lang/Object
    //   283: invokestatic 521	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   286: pop
    //   287: aload 9
    //   289: invokevirtual 580	android/app/ActivityManager:getProcessesInErrorState	()Ljava/util/List;
    //   292: astore 7
    //   294: aload 7
    //   296: ifnull +87 -> 383
    //   299: aload 7
    //   301: invokeinterface 583 1 0
    //   306: astore 10
    //   308: aload 10
    //   310: invokeinterface 422 1 0
    //   315: ifeq +68 -> 383
    //   318: aload 10
    //   320: invokeinterface 426 1 0
    //   325: checkcast 585	android/app/ActivityManager$ProcessErrorStateInfo
    //   328: astore 7
    //   330: aload 7
    //   332: getfield 588	android/app/ActivityManager$ProcessErrorStateInfo:condition	I
    //   335: iconst_2
    //   336: if_icmpne -28 -> 308
    //   339: ldc_w 590
    //   342: iconst_0
    //   343: anewarray 4	java/lang/Object
    //   346: invokestatic 521	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   349: pop
    //   350: aload 7
    //   352: ifnonnull +62 -> 414
    //   355: ldc_w 592
    //   358: iconst_0
    //   359: anewarray 4	java/lang/Object
    //   362: invokestatic 521	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   365: pop
    //   366: aload_0
    //   367: getfield 40	com/tencent/bugly/crashreport/crash/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   370: iconst_0
    //   371: invokevirtual 524	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   374: return
    //   375: ldc2_w 545
    //   378: lstore 5
    //   380: goto -138 -> 242
    //   383: ldc2_w 573
    //   386: invokestatic 595	com/tencent/bugly/proguard/z:b	(J)V
    //   389: iload_2
    //   390: i2l
    //   391: lload 5
    //   393: lcmp
    //   394: iflt +676 -> 1070
    //   397: ldc_w 597
    //   400: iconst_0
    //   401: anewarray 4	java/lang/Object
    //   404: invokestatic 521	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   407: pop
    //   408: aconst_null
    //   409: astore 7
    //   411: goto -61 -> 350
    //   414: aload 7
    //   416: getfield 600	android/app/ActivityManager$ProcessErrorStateInfo:pid	I
    //   419: invokestatic 605	android/os/Process:myPid	()I
    //   422: if_icmpeq +31 -> 453
    //   425: ldc_w 607
    //   428: iconst_1
    //   429: anewarray 4	java/lang/Object
    //   432: dup
    //   433: iconst_0
    //   434: aload 7
    //   436: getfield 610	android/app/ActivityManager$ProcessErrorStateInfo:processName	Ljava/lang/String;
    //   439: aastore
    //   440: invokestatic 521	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   443: pop
    //   444: aload_0
    //   445: getfield 40	com/tencent/bugly/crashreport/crash/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   448: iconst_0
    //   449: invokevirtual 524	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   452: return
    //   453: ldc_w 612
    //   456: iconst_0
    //   457: anewarray 4	java/lang/Object
    //   460: invokestatic 476	com/tencent/bugly/proguard/x:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   463: pop
    //   464: new 63	java/io/File
    //   467: dup
    //   468: aload_0
    //   469: getfield 53	com/tencent/bugly/crashreport/crash/anr/b:c	Landroid/content/Context;
    //   472: invokevirtual 615	android/content/Context:getFilesDir	()Ljava/io/File;
    //   475: new 354	java/lang/StringBuilder
    //   478: dup
    //   479: ldc_w 617
    //   482: invokespecial 397	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   485: lload_3
    //   486: invokevirtual 620	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   489: ldc_w 622
    //   492: invokevirtual 368	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: invokevirtual 376	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   498: invokespecial 625	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   501: astore 10
    //   503: new 161	com/tencent/bugly/crashreport/crash/anr/a
    //   506: dup
    //   507: invokespecial 626	com/tencent/bugly/crashreport/crash/anr/a:<init>	()V
    //   510: astore 9
    //   512: aload 9
    //   514: lload_3
    //   515: putfield 200	com/tencent/bugly/crashreport/crash/anr/a:c	J
    //   518: aload 9
    //   520: aload 10
    //   522: invokevirtual 67	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   525: putfield 244	com/tencent/bugly/crashreport/crash/anr/a:d	Ljava/lang/String;
    //   528: aload 9
    //   530: aload 7
    //   532: getfield 610	android/app/ActivityManager$ProcessErrorStateInfo:processName	Ljava/lang/String;
    //   535: putfield 220	com/tencent/bugly/crashreport/crash/anr/a:a	Ljava/lang/String;
    //   538: aload 9
    //   540: aload 7
    //   542: getfield 629	android/app/ActivityManager$ProcessErrorStateInfo:shortMsg	Ljava/lang/String;
    //   545: putfield 162	com/tencent/bugly/crashreport/crash/anr/a:f	Ljava/lang/String;
    //   548: aload 9
    //   550: aload 7
    //   552: getfield 632	android/app/ActivityManager$ProcessErrorStateInfo:longMsg	Ljava/lang/String;
    //   555: putfield 178	com/tencent/bugly/crashreport/crash/anr/a:e	Ljava/lang/String;
    //   558: aload 9
    //   560: aload 8
    //   562: putfield 215	com/tencent/bugly/crashreport/crash/anr/a:b	Ljava/util/Map;
    //   565: aload 8
    //   567: ifnull +112 -> 679
    //   570: aload 8
    //   572: invokeinterface 635 1 0
    //   577: invokeinterface 417 1 0
    //   582: astore 7
    //   584: aload 7
    //   586: invokeinterface 422 1 0
    //   591: ifeq +88 -> 679
    //   594: aload 7
    //   596: invokeinterface 426 1 0
    //   601: checkcast 188	java/lang/String
    //   604: astore 10
    //   606: aload 10
    //   608: ldc_w 637
    //   611: invokevirtual 641	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   614: ifeq -30 -> 584
    //   617: aload 9
    //   619: aload 8
    //   621: aload 10
    //   623: invokeinterface 392 2 0
    //   628: checkcast 188	java/lang/String
    //   631: putfield 165	com/tencent/bugly/crashreport/crash/anr/a:g	Ljava/lang/String;
    //   634: goto -50 -> 584
    //   637: astore_1
    //   638: aload_1
    //   639: invokestatic 302	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   642: ifne +7 -> 649
    //   645: aload_1
    //   646: invokevirtual 305	java/lang/Throwable:printStackTrace	()V
    //   649: ldc_w 643
    //   652: iconst_1
    //   653: anewarray 4	java/lang/Object
    //   656: dup
    //   657: iconst_0
    //   658: aload_1
    //   659: invokevirtual 359	java/lang/Object:getClass	()Ljava/lang/Class;
    //   662: invokevirtual 644	java/lang/Class:toString	()Ljava/lang/String;
    //   665: aastore
    //   666: invokestatic 328	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   669: pop
    //   670: aload_0
    //   671: getfield 40	com/tencent/bugly/crashreport/crash/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   674: iconst_0
    //   675: invokevirtual 524	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   678: return
    //   679: aload 9
    //   681: getfield 200	com/tencent/bugly/crashreport/crash/anr/a:c	J
    //   684: lstore_3
    //   685: aload 9
    //   687: getfield 244	com/tencent/bugly/crashreport/crash/anr/a:d	Ljava/lang/String;
    //   690: astore 7
    //   692: aload 9
    //   694: getfield 220	com/tencent/bugly/crashreport/crash/anr/a:a	Ljava/lang/String;
    //   697: astore 8
    //   699: aload 9
    //   701: getfield 162	com/tencent/bugly/crashreport/crash/anr/a:f	Ljava/lang/String;
    //   704: astore 10
    //   706: aload 9
    //   708: getfield 178	com/tencent/bugly/crashreport/crash/anr/a:e	Ljava/lang/String;
    //   711: astore 11
    //   713: aload 9
    //   715: getfield 215	com/tencent/bugly/crashreport/crash/anr/a:b	Ljava/util/Map;
    //   718: ifnonnull +104 -> 822
    //   721: iconst_0
    //   722: istore_2
    //   723: ldc_w 646
    //   726: bipush 6
    //   728: anewarray 4	java/lang/Object
    //   731: dup
    //   732: iconst_0
    //   733: lload_3
    //   734: invokestatic 651	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   737: aastore
    //   738: dup
    //   739: iconst_1
    //   740: aload 7
    //   742: aastore
    //   743: dup
    //   744: iconst_2
    //   745: aload 8
    //   747: aastore
    //   748: dup
    //   749: iconst_3
    //   750: aload 10
    //   752: aastore
    //   753: dup
    //   754: iconst_4
    //   755: aload 11
    //   757: aastore
    //   758: dup
    //   759: iconst_5
    //   760: iload_2
    //   761: invokestatic 553	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   764: aastore
    //   765: invokestatic 521	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   768: pop
    //   769: aload_0
    //   770: getfield 75	com/tencent/bugly/crashreport/crash/anr/b:f	Lcom/tencent/bugly/crashreport/common/strategy/a;
    //   773: invokevirtual 655	com/tencent/bugly/crashreport/common/strategy/a:b	()Z
    //   776: ifne +60 -> 836
    //   779: ldc_w 657
    //   782: iconst_0
    //   783: anewarray 4	java/lang/Object
    //   786: invokestatic 328	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   789: pop
    //   790: ldc_w 659
    //   793: invokestatic 661	com/tencent/bugly/proguard/z:a	()Ljava/lang/String;
    //   796: aload 9
    //   798: getfield 220	com/tencent/bugly/crashreport/crash/anr/a:a	Ljava/lang/String;
    //   801: ldc_w 388
    //   804: aload 9
    //   806: getfield 178	com/tencent/bugly/crashreport/crash/anr/a:e	Ljava/lang/String;
    //   809: aconst_null
    //   810: invokestatic 664	com/tencent/bugly/crashreport/crash/b:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/bugly/crashreport/crash/CrashDetailBean;)V
    //   813: aload_0
    //   814: getfield 40	com/tencent/bugly/crashreport/crash/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   817: iconst_0
    //   818: invokevirtual 524	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   821: return
    //   822: aload 9
    //   824: getfield 215	com/tencent/bugly/crashreport/crash/anr/a:b	Ljava/util/Map;
    //   827: invokeinterface 323 1 0
    //   832: istore_2
    //   833: goto -110 -> 723
    //   836: aload_0
    //   837: getfield 75	com/tencent/bugly/crashreport/crash/anr/b:f	Lcom/tencent/bugly/crashreport/common/strategy/a;
    //   840: invokevirtual 667	com/tencent/bugly/crashreport/common/strategy/a:c	()Lcom/tencent/bugly/crashreport/common/strategy/StrategyBean;
    //   843: getfield 507	com/tencent/bugly/crashreport/common/strategy/StrategyBean:j	Z
    //   846: ifne +28 -> 874
    //   849: ldc_w 669
    //   852: iconst_0
    //   853: anewarray 4	java/lang/Object
    //   856: invokestatic 460	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   859: pop
    //   860: goto -47 -> 813
    //   863: astore_1
    //   864: aload_0
    //   865: getfield 40	com/tencent/bugly/crashreport/crash/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   868: iconst_0
    //   869: invokevirtual 524	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   872: aload_1
    //   873: athrow
    //   874: ldc_w 671
    //   877: iconst_0
    //   878: anewarray 4	java/lang/Object
    //   881: invokestatic 476	com/tencent/bugly/proguard/x:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   884: pop
    //   885: aload_0
    //   886: aload 9
    //   888: invokespecial 673	com/tencent/bugly/crashreport/crash/anr/b:a	(Lcom/tencent/bugly/crashreport/crash/anr/a;)Lcom/tencent/bugly/crashreport/crash/CrashDetailBean;
    //   891: astore 7
    //   893: aload 7
    //   895: ifnonnull +17 -> 912
    //   898: ldc_w 675
    //   901: iconst_0
    //   902: anewarray 4	java/lang/Object
    //   905: invokestatic 328	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   908: pop
    //   909: goto -96 -> 813
    //   912: invokestatic 678	com/tencent/bugly/crashreport/crash/c:a	()Lcom/tencent/bugly/crashreport/crash/c;
    //   915: aload 7
    //   917: invokevirtual 680	com/tencent/bugly/crashreport/crash/c:a	(Lcom/tencent/bugly/crashreport/crash/CrashDetailBean;)V
    //   920: aload 7
    //   922: getfield 681	com/tencent/bugly/crashreport/crash/CrashDetailBean:a	J
    //   925: lconst_0
    //   926: lcmp
    //   927: iflt +129 -> 1056
    //   930: ldc_w 683
    //   933: iconst_0
    //   934: anewarray 4	java/lang/Object
    //   937: invokestatic 476	com/tencent/bugly/proguard/x:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   940: pop
    //   941: aload_1
    //   942: ifnull +53 -> 995
    //   945: new 63	java/io/File
    //   948: dup
    //   949: aload_1
    //   950: invokespecial 331	java/io/File:<init>	(Ljava/lang/String;)V
    //   953: invokevirtual 334	java/io/File:exists	()Z
    //   956: ifeq +39 -> 995
    //   959: aload_0
    //   960: getfield 40	com/tencent/bugly/crashreport/crash/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   963: iconst_3
    //   964: invokevirtual 524	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   967: aload_1
    //   968: aload 9
    //   970: getfield 244	com/tencent/bugly/crashreport/crash/anr/a:d	Ljava/lang/String;
    //   973: aload 9
    //   975: getfield 220	com/tencent/bugly/crashreport/crash/anr/a:a	Ljava/lang/String;
    //   978: invokestatic 685	com/tencent/bugly/crashreport/crash/anr/b:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   981: ifeq +14 -> 995
    //   984: ldc_w 687
    //   987: iconst_0
    //   988: anewarray 4	java/lang/Object
    //   991: invokestatic 476	com/tencent/bugly/proguard/x:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   994: pop
    //   995: ldc_w 659
    //   998: invokestatic 661	com/tencent/bugly/proguard/z:a	()Ljava/lang/String;
    //   1001: aload 9
    //   1003: getfield 220	com/tencent/bugly/crashreport/crash/anr/a:a	Ljava/lang/String;
    //   1006: ldc_w 388
    //   1009: aload 9
    //   1011: getfield 178	com/tencent/bugly/crashreport/crash/anr/a:e	Ljava/lang/String;
    //   1014: aload 7
    //   1016: invokestatic 664	com/tencent/bugly/crashreport/crash/b:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/bugly/crashreport/crash/CrashDetailBean;)V
    //   1019: aload_0
    //   1020: getfield 77	com/tencent/bugly/crashreport/crash/anr/b:h	Lcom/tencent/bugly/crashreport/crash/b;
    //   1023: aload 7
    //   1025: invokevirtual 690	com/tencent/bugly/crashreport/crash/b:a	(Lcom/tencent/bugly/crashreport/crash/CrashDetailBean;)Z
    //   1028: ifne +16 -> 1044
    //   1031: aload_0
    //   1032: getfield 77	com/tencent/bugly/crashreport/crash/anr/b:h	Lcom/tencent/bugly/crashreport/crash/b;
    //   1035: aload 7
    //   1037: ldc2_w 691
    //   1040: iconst_1
    //   1041: invokevirtual 695	com/tencent/bugly/crashreport/crash/b:a	(Lcom/tencent/bugly/crashreport/crash/CrashDetailBean;JZ)V
    //   1044: aload_0
    //   1045: getfield 77	com/tencent/bugly/crashreport/crash/anr/b:h	Lcom/tencent/bugly/crashreport/crash/b;
    //   1048: aload 7
    //   1050: invokevirtual 697	com/tencent/bugly/crashreport/crash/b:b	(Lcom/tencent/bugly/crashreport/crash/CrashDetailBean;)V
    //   1053: goto -240 -> 813
    //   1056: ldc_w 699
    //   1059: iconst_0
    //   1060: anewarray 4	java/lang/Object
    //   1063: invokestatic 460	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   1066: pop
    //   1067: goto -126 -> 941
    //   1070: iload_2
    //   1071: iconst_1
    //   1072: iadd
    //   1073: istore_2
    //   1074: goto -798 -> 276
    //   1077: goto -985 -> 92
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1080	0	this	b
    //   0	1080	1	paramString	String
    //   275	799	2	k	int
    //   50	684	3	l1	long
    //   240	152	5	l2	long
    //   56	993	7	localObject1	Object
    //   162	584	8	localObject2	Object
    //   264	746	9	localObject3	Object
    //   306	445	10	localObject4	Object
    //   711	45	11	str	String
    // Exception table:
    //   from	to	target	type
    //   2	25	137	finally
    //   26	36	137	finally
    //   155	164	199	java/lang/Throwable
    //   36	47	637	java/lang/Throwable
    //   51	58	637	java/lang/Throwable
    //   63	69	637	java/lang/Throwable
    //   77	92	637	java/lang/Throwable
    //   92	128	637	java/lang/Throwable
    //   142	155	637	java/lang/Throwable
    //   169	179	637	java/lang/Throwable
    //   179	190	637	java/lang/Throwable
    //   200	216	637	java/lang/Throwable
    //   225	231	637	java/lang/Throwable
    //   242	274	637	java/lang/Throwable
    //   276	294	637	java/lang/Throwable
    //   299	308	637	java/lang/Throwable
    //   308	350	637	java/lang/Throwable
    //   355	366	637	java/lang/Throwable
    //   383	389	637	java/lang/Throwable
    //   397	408	637	java/lang/Throwable
    //   414	444	637	java/lang/Throwable
    //   453	565	637	java/lang/Throwable
    //   570	584	637	java/lang/Throwable
    //   584	634	637	java/lang/Throwable
    //   679	721	637	java/lang/Throwable
    //   723	813	637	java/lang/Throwable
    //   822	833	637	java/lang/Throwable
    //   836	860	637	java/lang/Throwable
    //   874	893	637	java/lang/Throwable
    //   898	909	637	java/lang/Throwable
    //   912	941	637	java/lang/Throwable
    //   945	995	637	java/lang/Throwable
    //   995	1044	637	java/lang/Throwable
    //   1044	1053	637	java/lang/Throwable
    //   1056	1067	637	java/lang/Throwable
    //   36	47	863	finally
    //   51	58	863	finally
    //   63	69	863	finally
    //   77	92	863	finally
    //   92	128	863	finally
    //   142	155	863	finally
    //   155	164	863	finally
    //   169	179	863	finally
    //   179	190	863	finally
    //   200	216	863	finally
    //   225	231	863	finally
    //   242	274	863	finally
    //   276	294	863	finally
    //   299	308	863	finally
    //   308	350	863	finally
    //   355	366	863	finally
    //   383	389	863	finally
    //   397	408	863	finally
    //   414	444	863	finally
    //   453	565	863	finally
    //   570	584	863	finally
    //   584	634	863	finally
    //   638	649	863	finally
    //   649	670	863	finally
    //   679	721	863	finally
    //   723	813	863	finally
    //   822	833	863	finally
    //   836	860	863	finally
    //   874	893	863	finally
    //   898	909	863	finally
    //   912	941	863	finally
    //   945	995	863	finally
    //   995	1044	863	finally
    //   1044	1053	863	finally
    //   1056	1067	863	finally
  }
  
  public final void a(boolean paramBoolean)
  {
    c(paramBoolean);
    boolean bool = f();
    com.tencent.bugly.crashreport.common.strategy.a locala = com.tencent.bugly.crashreport.common.strategy.a.a();
    paramBoolean = bool;
    if (locala != null) {
      if ((!bool) || (!locala.c().g)) {
        break label68;
      }
    }
    label68:
    for (paramBoolean = true;; paramBoolean = false)
    {
      if (paramBoolean != e())
      {
        x.a("anr changed to %b", new Object[] { Boolean.valueOf(paramBoolean) });
        b(paramBoolean);
      }
      return;
    }
  }
  
  public final boolean a()
  {
    return this.a.get() != 0;
  }
  
  protected final void b()
  {
    long l1 = z.b();
    long l2 = c.g;
    Object localObject1 = new File(this.g);
    if ((((File)localObject1).exists()) && (((File)localObject1).isDirectory()))
    {
      localObject1 = ((File)localObject1).listFiles();
      if ((localObject1 != null) && (localObject1.length != 0)) {}
    }
    else
    {
      return;
    }
    int i1 = "bugly_trace_".length();
    int i2 = localObject1.length;
    int k = 0;
    Object localObject2;
    String str;
    int n;
    for (int m = 0;; m = n)
    {
      if (k >= i2) {
        break label190;
      }
      localObject2 = localObject1[k];
      str = localObject2.getName();
      n = m;
      if (str.startsWith("bugly_trace_")) {}
      try
      {
        n = str.indexOf(".txt");
        if (n <= 0) {
          break;
        }
        long l3 = Long.parseLong(str.substring(i1, n));
        if (l3 < l1 - l2) {
          break;
        }
        n = m;
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          x.e("tomb format error delete %s", new Object[] { str });
          n = m;
          if (localObject2.delete()) {
            n = m + 1;
          }
        }
      }
      k += 1;
    }
    label190:
    x.c("clean tombs %d", new Object[] { Integer.valueOf(m) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.bugly.crashreport.crash.anr.b
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.bugly.crashreport.crash.anr;

import android.app.ActivityManager;
import android.app.ActivityManager.ProcessErrorStateInfo;
import android.content.Context;
import android.os.FileObserver;
import android.os.Process;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.c;
import com.tencent.bugly.proguard.ab;
import com.tencent.bugly.proguard.ac;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.y;
import com.tencent.bugly.proguard.z;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public final class b
  implements ac
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
  private ab k;
  private int l;
  
  public b(Context paramContext, com.tencent.bugly.crashreport.common.strategy.a parama, com.tencent.bugly.crashreport.common.info.a parama1, w paramw, com.tencent.bugly.crashreport.crash.b paramb)
  {
    this.c = z.a(paramContext);
    this.g = paramContext.getDir("bugly", 0).getAbsolutePath();
    this.d = parama1;
    this.e = paramw;
    this.f = parama;
    this.h = paramb;
  }
  
  private static ActivityManager.ProcessErrorStateInfo a(Context paramContext, long paramLong)
  {
    paramLong = 0L;
    if (10000L < 0L) {}
    for (;;)
    {
      try
      {
        x.c("to find!", new Object[0]);
        paramContext = (ActivityManager)paramContext.getSystemService("activity");
        paramLong /= 500L;
        m = 0;
      }
      catch (Exception paramContext)
      {
        int m;
        Object localObject;
        ActivityManager.ProcessErrorStateInfo localProcessErrorStateInfo;
        x.b(paramContext);
        continue;
        m += 1;
        continue;
      }
      x.c("waiting!", new Object[0]);
      localObject = paramContext.getProcessesInErrorState();
      if (localObject != null)
      {
        localObject = ((List)localObject).iterator();
        if (((Iterator)localObject).hasNext())
        {
          localProcessErrorStateInfo = (ActivityManager.ProcessErrorStateInfo)((Iterator)localObject).next();
          if (localProcessErrorStateInfo.condition != 2) {
            continue;
          }
          x.c("found!", new Object[0]);
          return localProcessErrorStateInfo;
        }
      }
      z.b(500L);
      if (m >= paramLong)
      {
        x.c("end!", new Object[0]);
        return null;
      }
      paramLong = 10000L;
    }
  }
  
  private CrashDetailBean a(a parama)
  {
    localCrashDetailBean = new CrashDetailBean();
    try
    {
      localCrashDetailBean.C = com.tencent.bugly.crashreport.common.info.b.k();
      localCrashDetailBean.D = com.tencent.bugly.crashreport.common.info.b.i();
      localCrashDetailBean.E = com.tencent.bugly.crashreport.common.info.b.m();
      localCrashDetailBean.F = this.d.o();
      localCrashDetailBean.G = this.d.n();
      localCrashDetailBean.H = this.d.p();
      localCrashDetailBean.w = z.a(this.c, c.e, c.h);
      localCrashDetailBean.b = 3;
      localCrashDetailBean.e = this.d.g();
      localCrashDetailBean.f = this.d.m;
      localCrashDetailBean.g = this.d.v();
      localCrashDetailBean.m = this.d.f();
      localCrashDetailBean.n = "ANR_EXCEPTION";
      localCrashDetailBean.o = parama.f;
      localCrashDetailBean.q = parama.g;
      localCrashDetailBean.O = new HashMap();
      localCrashDetailBean.O.put("BUGLY_CR_01", parama.e);
      int m = -1;
      if (localCrashDetailBean.q != null) {
        m = localCrashDetailBean.q.indexOf("\n");
      }
      if (m > 0) {}
      for (String str = localCrashDetailBean.q.substring(0, m);; str = "GET_FAIL")
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
        localCrashDetailBean.L = this.d.q;
        localCrashDetailBean.M = this.d.a;
        localCrashDetailBean.N = this.d.a();
        localCrashDetailBean.P = this.d.G();
        localCrashDetailBean.Q = this.d.H();
        localCrashDetailBean.R = this.d.A();
        localCrashDetailBean.S = this.d.F();
        this.h.d(localCrashDetailBean);
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
  
  private boolean a(Context paramContext, String paramString, ActivityManager.ProcessErrorStateInfo paramProcessErrorStateInfo, long paramLong, Map<String, String> paramMap)
  {
    paramContext = new File(paramContext.getFilesDir(), "bugly/bugly_trace_" + paramLong + ".txt");
    a locala = new a();
    locala.c = paramLong;
    locala.d = paramContext.getAbsolutePath();
    if (paramProcessErrorStateInfo != null)
    {
      paramContext = paramProcessErrorStateInfo.processName;
      locala.a = paramContext;
      if (paramProcessErrorStateInfo == null) {
        break label186;
      }
      paramContext = paramProcessErrorStateInfo.shortMsg;
      label85:
      locala.f = paramContext;
      if (paramProcessErrorStateInfo == null) {
        break label193;
      }
    }
    label186:
    label193:
    for (paramContext = paramProcessErrorStateInfo.longMsg;; paramContext = "")
    {
      locala.e = paramContext;
      locala.b = paramMap;
      if (paramMap == null) {
        break label200;
      }
      paramContext = paramMap.keySet().iterator();
      while (paramContext.hasNext())
      {
        paramProcessErrorStateInfo = (String)paramContext.next();
        if (paramProcessErrorStateInfo.startsWith("main(")) {
          locala.g = ((String)paramMap.get(paramProcessErrorStateInfo));
        }
      }
      paramContext = "";
      break;
      paramContext = "";
      break label85;
    }
    label200:
    paramLong = locala.c;
    paramContext = locala.d;
    paramProcessErrorStateInfo = locala.a;
    paramMap = locala.f;
    String str = locala.e;
    if (locala.b == null) {}
    for (int m = 0;; m = locala.b.size())
    {
      x.c("anr tm:%d\ntr:%s\nproc:%s\nsMsg:%s\n lMsg:%s\n threads:%d", new Object[] { Long.valueOf(paramLong), paramContext, paramProcessErrorStateInfo, paramMap, str, Integer.valueOf(m) });
      if (this.f.b()) {
        break;
      }
      x.e("crash report sync remote fail, will not upload to Bugly , print local for helpful!", new Object[0]);
      com.tencent.bugly.crashreport.crash.b.a("ANR", z.a(), locala.a, "main", locala.e, null);
      return false;
    }
    if (!this.f.c().j)
    {
      x.d("ANR Report is closed!", new Object[0]);
      return false;
    }
    x.a("found visiable anr , start to upload!", new Object[0]);
    paramContext = a(locala);
    if (paramContext == null)
    {
      x.e("pack anr fail!", new Object[0]);
      return false;
    }
    c.a().a(paramContext);
    if (paramContext.a >= 0L) {
      x.a("backup anr record success!", new Object[0]);
    }
    for (;;)
    {
      if ((paramString != null) && (new File(paramString).exists()))
      {
        this.a.set(3);
        if (a(paramString, locala.d, locala.a)) {
          x.a("backup trace success", new Object[0]);
        }
      }
      com.tencent.bugly.crashreport.crash.b.a("ANR", z.a(), locala.a, "main", locala.e, paramContext);
      if (!this.h.a(paramContext)) {
        this.h.a(paramContext, 3000L, true);
      }
      this.h.c(paramContext);
      return true;
      x.d("backup anr record fail!", new Object[0]);
    }
  }
  
  /* Error */
  private static boolean a(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aload_2
    //   1: aload_0
    //   2: iconst_1
    //   3: invokestatic 508	com/tencent/bugly/crashreport/crash/anr/TraceFileHelper:readTargetDumpInfo	(Ljava/lang/String;Ljava/lang/String;Z)Lcom/tencent/bugly/crashreport/crash/anr/TraceFileHelper$a;
    //   6: astore_3
    //   7: aload_3
    //   8: ifnull +22 -> 30
    //   11: aload_3
    //   12: getfield 512	com/tencent/bugly/crashreport/crash/anr/TraceFileHelper$a:d	Ljava/util/Map;
    //   15: ifnull +15 -> 30
    //   18: aload_3
    //   19: getfield 512	com/tencent/bugly/crashreport/crash/anr/TraceFileHelper$a:d	Ljava/util/Map;
    //   22: invokeinterface 448 1 0
    //   27: ifgt +20 -> 47
    //   30: ldc_w 514
    //   33: iconst_1
    //   34: anewarray 4	java/lang/Object
    //   37: dup
    //   38: iconst_0
    //   39: aload_2
    //   40: aastore
    //   41: invokestatic 436	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   44: pop
    //   45: iconst_0
    //   46: ireturn
    //   47: new 65	java/io/File
    //   50: dup
    //   51: aload_1
    //   52: invokespecial 475	java/io/File:<init>	(Ljava/lang/String;)V
    //   55: astore_2
    //   56: aload_2
    //   57: invokevirtual 478	java/io/File:exists	()Z
    //   60: ifne +26 -> 86
    //   63: aload_2
    //   64: invokevirtual 517	java/io/File:getParentFile	()Ljava/io/File;
    //   67: invokevirtual 478	java/io/File:exists	()Z
    //   70: ifne +11 -> 81
    //   73: aload_2
    //   74: invokevirtual 517	java/io/File:getParentFile	()Ljava/io/File;
    //   77: invokevirtual 520	java/io/File:mkdirs	()Z
    //   80: pop
    //   81: aload_2
    //   82: invokevirtual 523	java/io/File:createNewFile	()Z
    //   85: pop
    //   86: aload_2
    //   87: invokevirtual 478	java/io/File:exists	()Z
    //   90: ifeq +10 -> 100
    //   93: aload_2
    //   94: invokevirtual 526	java/io/File:canWrite	()Z
    //   97: ifne +85 -> 182
    //   100: ldc_w 528
    //   103: iconst_1
    //   104: anewarray 4	java/lang/Object
    //   107: dup
    //   108: iconst_0
    //   109: aload_1
    //   110: aastore
    //   111: invokestatic 436	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   114: pop
    //   115: iconst_0
    //   116: ireturn
    //   117: astore_0
    //   118: aload_0
    //   119: invokestatic 356	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   122: ifne +7 -> 129
    //   125: aload_0
    //   126: invokevirtual 529	java/lang/Exception:printStackTrace	()V
    //   129: ldc_w 531
    //   132: iconst_2
    //   133: anewarray 4	java/lang/Object
    //   136: dup
    //   137: iconst_0
    //   138: new 366	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 532	java/lang/StringBuilder:<init>	()V
    //   145: aload_0
    //   146: invokevirtual 536	java/lang/Object:getClass	()Ljava/lang/Class;
    //   149: invokevirtual 541	java/lang/Class:getName	()Ljava/lang/String;
    //   152: invokevirtual 380	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: ldc_w 543
    //   158: invokevirtual 380	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: aload_0
    //   162: invokevirtual 546	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   165: invokevirtual 380	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: invokevirtual 383	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: aastore
    //   172: dup
    //   173: iconst_1
    //   174: aload_1
    //   175: aastore
    //   176: invokestatic 436	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   179: pop
    //   180: iconst_0
    //   181: ireturn
    //   182: aconst_null
    //   183: astore_0
    //   184: new 548	java/io/BufferedWriter
    //   187: dup
    //   188: new 550	java/io/FileWriter
    //   191: dup
    //   192: aload_2
    //   193: iconst_0
    //   194: invokespecial 553	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   197: invokespecial 556	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   200: astore_1
    //   201: aload_3
    //   202: getfield 512	com/tencent/bugly/crashreport/crash/anr/TraceFileHelper$a:d	Ljava/util/Map;
    //   205: ldc_w 442
    //   208: invokeinterface 413 2 0
    //   213: checkcast 558	[Ljava/lang/String;
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
    //   247: new 366	java/lang/StringBuilder
    //   250: dup
    //   251: ldc_w 560
    //   254: invokespecial 371	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   257: aload 4
    //   259: invokevirtual 380	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: ldc_w 562
    //   265: invokevirtual 380	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: aload_0
    //   269: invokevirtual 380	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: ldc 244
    //   274: invokevirtual 380	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   277: aload_2
    //   278: invokevirtual 380	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: ldc_w 564
    //   284: invokevirtual 380	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   287: invokevirtual 383	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   290: invokevirtual 567	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   293: aload_1
    //   294: invokevirtual 570	java/io/BufferedWriter:flush	()V
    //   297: aload_3
    //   298: getfield 512	com/tencent/bugly/crashreport/crash/anr/TraceFileHelper$a:d	Ljava/util/Map;
    //   301: invokeinterface 573 1 0
    //   306: invokeinterface 403 1 0
    //   311: astore_0
    //   312: aload_0
    //   313: invokeinterface 120 1 0
    //   318: ifeq +238 -> 556
    //   321: aload_0
    //   322: invokeinterface 124 1 0
    //   327: checkcast 575	java/util/Map$Entry
    //   330: astore_2
    //   331: aload_2
    //   332: invokeinterface 578 1 0
    //   337: checkcast 246	java/lang/String
    //   340: ldc_w 442
    //   343: invokevirtual 582	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   346: ifne -34 -> 312
    //   349: aload_2
    //   350: invokeinterface 585 1 0
    //   355: ifnull -43 -> 312
    //   358: aload_2
    //   359: invokeinterface 585 1 0
    //   364: checkcast 558	[Ljava/lang/String;
    //   367: arraylength
    //   368: iconst_3
    //   369: if_icmplt -57 -> 312
    //   372: aload_2
    //   373: invokeinterface 585 1 0
    //   378: checkcast 558	[Ljava/lang/String;
    //   381: iconst_0
    //   382: aaload
    //   383: astore_3
    //   384: aload_2
    //   385: invokeinterface 585 1 0
    //   390: checkcast 558	[Ljava/lang/String;
    //   393: iconst_1
    //   394: aaload
    //   395: astore 4
    //   397: aload_2
    //   398: invokeinterface 585 1 0
    //   403: checkcast 558	[Ljava/lang/String;
    //   406: iconst_2
    //   407: aaload
    //   408: astore 5
    //   410: aload_1
    //   411: new 366	java/lang/StringBuilder
    //   414: dup
    //   415: ldc_w 587
    //   418: invokespecial 371	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   421: aload_2
    //   422: invokeinterface 578 1 0
    //   427: checkcast 246	java/lang/String
    //   430: invokevirtual 380	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   433: ldc_w 589
    //   436: invokevirtual 380	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: aload 5
    //   441: invokevirtual 380	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: ldc_w 562
    //   447: invokevirtual 380	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   450: aload_3
    //   451: invokevirtual 380	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   454: ldc 244
    //   456: invokevirtual 380	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: aload 4
    //   461: invokevirtual 380	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: ldc_w 564
    //   467: invokevirtual 380	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   470: invokevirtual 383	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   473: invokevirtual 567	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   476: aload_1
    //   477: invokevirtual 570	java/io/BufferedWriter:flush	()V
    //   480: goto -168 -> 312
    //   483: astore_2
    //   484: aload_1
    //   485: astore_0
    //   486: aload_2
    //   487: astore_1
    //   488: aload_1
    //   489: invokestatic 356	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   492: ifne +7 -> 499
    //   495: aload_1
    //   496: invokevirtual 590	java/io/IOException:printStackTrace	()V
    //   499: ldc_w 592
    //   502: iconst_1
    //   503: anewarray 4	java/lang/Object
    //   506: dup
    //   507: iconst_0
    //   508: new 366	java/lang/StringBuilder
    //   511: dup
    //   512: invokespecial 532	java/lang/StringBuilder:<init>	()V
    //   515: aload_1
    //   516: invokevirtual 536	java/lang/Object:getClass	()Ljava/lang/Class;
    //   519: invokevirtual 541	java/lang/Class:getName	()Ljava/lang/String;
    //   522: invokevirtual 380	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   525: ldc_w 543
    //   528: invokevirtual 380	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   531: aload_1
    //   532: invokevirtual 593	java/io/IOException:getMessage	()Ljava/lang/String;
    //   535: invokevirtual 380	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   538: invokevirtual 383	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   541: aastore
    //   542: invokestatic 436	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   545: pop
    //   546: aload_0
    //   547: ifnull +7 -> 554
    //   550: aload_0
    //   551: invokevirtual 596	java/io/BufferedWriter:close	()V
    //   554: iconst_0
    //   555: ireturn
    //   556: aload_1
    //   557: invokevirtual 596	java/io/BufferedWriter:close	()V
    //   560: iconst_1
    //   561: ireturn
    //   562: astore_0
    //   563: aload_0
    //   564: invokestatic 356	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   567: ifne -7 -> 560
    //   570: aload_0
    //   571: invokevirtual 590	java/io/IOException:printStackTrace	()V
    //   574: goto -14 -> 560
    //   577: astore_0
    //   578: aload_0
    //   579: invokestatic 356	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   582: ifne -28 -> 554
    //   585: aload_0
    //   586: invokevirtual 590	java/io/IOException:printStackTrace	()V
    //   589: goto -35 -> 554
    //   592: astore_0
    //   593: aconst_null
    //   594: astore_1
    //   595: aload_1
    //   596: ifnull +7 -> 603
    //   599: aload_1
    //   600: invokevirtual 596	java/io/BufferedWriter:close	()V
    //   603: aload_0
    //   604: athrow
    //   605: astore_1
    //   606: aload_1
    //   607: invokestatic 356	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   610: ifne -7 -> 603
    //   613: aload_1
    //   614: invokevirtual 590	java/io/IOException:printStackTrace	()V
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
        f();
        return;
      }
      finally {}
      g();
    }
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
  private void f()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 610	com/tencent/bugly/crashreport/crash/anr/b:h	()Z
    //   6: ifeq +17 -> 23
    //   9: ldc_w 612
    //   12: iconst_0
    //   13: anewarray 4	java/lang/Object
    //   16: invokestatic 458	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   19: pop
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: aload_0
    //   24: new 614	com/tencent/bugly/crashreport/crash/anr/b$1
    //   27: dup
    //   28: aload_0
    //   29: ldc_w 616
    //   32: bipush 8
    //   34: invokespecial 619	com/tencent/bugly/crashreport/crash/anr/b$1:<init>	(Lcom/tencent/bugly/crashreport/crash/anr/b;Ljava/lang/String;I)V
    //   37: putfield 621	com/tencent/bugly/crashreport/crash/anr/b:i	Landroid/os/FileObserver;
    //   40: aload_0
    //   41: getfield 621	com/tencent/bugly/crashreport/crash/anr/b:i	Landroid/os/FileObserver;
    //   44: invokevirtual 626	android/os/FileObserver:startWatching	()V
    //   47: ldc_w 628
    //   50: iconst_0
    //   51: anewarray 4	java/lang/Object
    //   54: invokestatic 462	com/tencent/bugly/proguard/x:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   57: pop
    //   58: aload_0
    //   59: getfield 75	com/tencent/bugly/crashreport/crash/anr/b:e	Lcom/tencent/bugly/proguard/w;
    //   62: new 630	com/tencent/bugly/crashreport/crash/anr/b$2
    //   65: dup
    //   66: aload_0
    //   67: invokespecial 633	com/tencent/bugly/crashreport/crash/anr/b$2:<init>	(Lcom/tencent/bugly/crashreport/crash/anr/b;)V
    //   70: invokevirtual 638	com/tencent/bugly/proguard/w:a	(Ljava/lang/Runnable;)Z
    //   73: pop
    //   74: goto -54 -> 20
    //   77: astore_1
    //   78: aload_0
    //   79: aconst_null
    //   80: putfield 621	com/tencent/bugly/crashreport/crash/anr/b:i	Landroid/os/FileObserver;
    //   83: ldc_w 640
    //   86: iconst_0
    //   87: anewarray 4	java/lang/Object
    //   90: invokestatic 458	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   93: pop
    //   94: aload_1
    //   95: invokestatic 356	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   98: ifne -78 -> 20
    //   101: aload_1
    //   102: invokevirtual 359	java/lang/Throwable:printStackTrace	()V
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
  
  /* Error */
  private void g()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 610	com/tencent/bugly/crashreport/crash/anr/b:h	()Z
    //   6: ifne +17 -> 23
    //   9: ldc_w 642
    //   12: iconst_0
    //   13: anewarray 4	java/lang/Object
    //   16: invokestatic 458	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   19: pop
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: aload_0
    //   24: getfield 621	com/tencent/bugly/crashreport/crash/anr/b:i	Landroid/os/FileObserver;
    //   27: invokevirtual 645	android/os/FileObserver:stopWatching	()V
    //   30: aload_0
    //   31: aconst_null
    //   32: putfield 621	com/tencent/bugly/crashreport/crash/anr/b:i	Landroid/os/FileObserver;
    //   35: ldc_w 647
    //   38: iconst_0
    //   39: anewarray 4	java/lang/Object
    //   42: invokestatic 458	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   45: pop
    //   46: goto -26 -> 20
    //   49: astore_1
    //   50: ldc_w 649
    //   53: iconst_0
    //   54: anewarray 4	java/lang/Object
    //   57: invokestatic 458	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   60: pop
    //   61: aload_1
    //   62: invokestatic 356	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   65: ifne -45 -> 20
    //   68: aload_1
    //   69: invokevirtual 359	java/lang/Throwable:printStackTrace	()V
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
  private boolean h()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 621	com/tencent/bugly/crashreport/crash/anr/b:i	Landroid/os/FileObserver;
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
  
  private boolean i()
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
  
  /* Error */
  public final void a(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 42	com/tencent/bugly/crashreport/crash/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   6: invokevirtual 651	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   9: ifeq +17 -> 26
    //   12: ldc_w 653
    //   15: iconst_0
    //   16: anewarray 4	java/lang/Object
    //   19: invokestatic 92	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   22: pop
    //   23: aload_0
    //   24: monitorexit
    //   25: return
    //   26: aload_0
    //   27: getfield 42	com/tencent/bugly/crashreport/crash/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   30: iconst_1
    //   31: invokevirtual 481	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   34: aload_0
    //   35: monitorexit
    //   36: ldc_w 655
    //   39: iconst_0
    //   40: anewarray 4	java/lang/Object
    //   43: invokestatic 92	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   46: pop
    //   47: aload_1
    //   48: iconst_0
    //   49: invokestatic 659	com/tencent/bugly/crashreport/crash/anr/TraceFileHelper:readFirstDumpInfo	(Ljava/lang/String;Z)Lcom/tencent/bugly/crashreport/crash/anr/TraceFileHelper$a;
    //   52: astore 6
    //   54: aload 6
    //   56: ifnull +336 -> 392
    //   59: aload 6
    //   61: getfield 660	com/tencent/bugly/crashreport/crash/anr/TraceFileHelper$a:c	J
    //   64: lstore_2
    //   65: lload_2
    //   66: lstore 4
    //   68: lload_2
    //   69: ldc2_w 43
    //   72: lcmp
    //   73: ifne +19 -> 92
    //   76: ldc_w 662
    //   79: iconst_0
    //   80: anewarray 4	java/lang/Object
    //   83: invokestatic 458	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   86: pop
    //   87: invokestatic 667	java/lang/System:currentTimeMillis	()J
    //   90: lstore 4
    //   92: lload 4
    //   94: aload_0
    //   95: getfield 46	com/tencent/bugly/crashreport/crash/anr/b:b	J
    //   98: lsub
    //   99: invokestatic 673	java/lang/Math:abs	(J)J
    //   102: ldc2_w 84
    //   105: lcmp
    //   106: ifge +37 -> 143
    //   109: ldc_w 675
    //   112: iconst_1
    //   113: anewarray 4	java/lang/Object
    //   116: dup
    //   117: iconst_0
    //   118: sipush 10000
    //   121: invokestatic 428	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   124: aastore
    //   125: invokestatic 458	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   128: pop
    //   129: aload_0
    //   130: getfield 42	com/tencent/bugly/crashreport/crash/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   133: iconst_0
    //   134: invokevirtual 481	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   137: return
    //   138: astore_1
    //   139: aload_0
    //   140: monitorexit
    //   141: aload_1
    //   142: athrow
    //   143: aload_0
    //   144: lload 4
    //   146: putfield 46	com/tencent/bugly/crashreport/crash/anr/b:b	J
    //   149: aload_0
    //   150: getfield 42	com/tencent/bugly/crashreport/crash/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   153: iconst_1
    //   154: invokevirtual 481	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   157: getstatic 677	com/tencent/bugly/crashreport/crash/c:f	I
    //   160: iconst_0
    //   161: invokestatic 680	com/tencent/bugly/proguard/z:a	(IZ)Ljava/util/Map;
    //   164: astore 6
    //   166: aload 6
    //   168: ifnull +13 -> 181
    //   171: aload 6
    //   173: invokeinterface 448 1 0
    //   178: ifgt +49 -> 227
    //   181: ldc_w 682
    //   184: iconst_0
    //   185: anewarray 4	java/lang/Object
    //   188: invokestatic 458	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   191: pop
    //   192: aload_0
    //   193: getfield 42	com/tencent/bugly/crashreport/crash/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   196: iconst_0
    //   197: invokevirtual 481	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   200: return
    //   201: astore_1
    //   202: aload_1
    //   203: invokestatic 356	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   206: pop
    //   207: ldc_w 684
    //   210: iconst_0
    //   211: anewarray 4	java/lang/Object
    //   214: invokestatic 436	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   217: pop
    //   218: aload_0
    //   219: getfield 42	com/tencent/bugly/crashreport/crash/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   222: iconst_0
    //   223: invokevirtual 481	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   226: return
    //   227: aload_0
    //   228: getfield 55	com/tencent/bugly/crashreport/crash/anr/b:c	Landroid/content/Context;
    //   231: ldc2_w 84
    //   234: invokestatic 686	com/tencent/bugly/crashreport/crash/anr/b:a	(Landroid/content/Context;J)Landroid/app/ActivityManager$ProcessErrorStateInfo;
    //   237: astore 7
    //   239: aload 7
    //   241: ifnonnull +23 -> 264
    //   244: ldc_w 688
    //   247: iconst_0
    //   248: anewarray 4	java/lang/Object
    //   251: invokestatic 92	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   254: pop
    //   255: aload_0
    //   256: getfield 42	com/tencent/bugly/crashreport/crash/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   259: iconst_0
    //   260: invokevirtual 481	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   263: return
    //   264: aload 7
    //   266: getfield 691	android/app/ActivityManager$ProcessErrorStateInfo:pid	I
    //   269: invokestatic 696	android/os/Process:myPid	()I
    //   272: if_icmpeq +31 -> 303
    //   275: ldc_w 698
    //   278: iconst_1
    //   279: anewarray 4	java/lang/Object
    //   282: dup
    //   283: iconst_0
    //   284: aload 7
    //   286: getfield 390	android/app/ActivityManager$ProcessErrorStateInfo:processName	Ljava/lang/String;
    //   289: aastore
    //   290: invokestatic 92	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   293: pop
    //   294: aload_0
    //   295: getfield 42	com/tencent/bugly/crashreport/crash/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   298: iconst_0
    //   299: invokevirtual 481	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   302: return
    //   303: ldc_w 700
    //   306: iconst_0
    //   307: anewarray 4	java/lang/Object
    //   310: invokestatic 462	com/tencent/bugly/proguard/x:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   313: pop
    //   314: aload_0
    //   315: aload_0
    //   316: getfield 55	com/tencent/bugly/crashreport/crash/anr/b:c	Landroid/content/Context;
    //   319: aload_1
    //   320: aload 7
    //   322: lload 4
    //   324: aload 6
    //   326: invokespecial 702	com/tencent/bugly/crashreport/crash/anr/b:a	(Landroid/content/Context;Ljava/lang/String;Landroid/app/ActivityManager$ProcessErrorStateInfo;JLjava/util/Map;)Z
    //   329: pop
    //   330: aload_0
    //   331: getfield 42	com/tencent/bugly/crashreport/crash/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   334: iconst_0
    //   335: invokevirtual 481	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   338: return
    //   339: astore_1
    //   340: aload_1
    //   341: invokestatic 356	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   344: ifne +7 -> 351
    //   347: aload_1
    //   348: invokevirtual 359	java/lang/Throwable:printStackTrace	()V
    //   351: ldc_w 704
    //   354: iconst_1
    //   355: anewarray 4	java/lang/Object
    //   358: dup
    //   359: iconst_0
    //   360: aload_1
    //   361: invokevirtual 536	java/lang/Object:getClass	()Ljava/lang/Class;
    //   364: invokevirtual 705	java/lang/Class:toString	()Ljava/lang/String;
    //   367: aastore
    //   368: invokestatic 436	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   371: pop
    //   372: aload_0
    //   373: getfield 42	com/tencent/bugly/crashreport/crash/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   376: iconst_0
    //   377: invokevirtual 481	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   380: return
    //   381: astore_1
    //   382: aload_0
    //   383: getfield 42	com/tencent/bugly/crashreport/crash/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   386: iconst_0
    //   387: invokevirtual 481	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   390: aload_1
    //   391: athrow
    //   392: ldc2_w 43
    //   395: lstore_2
    //   396: goto -331 -> 65
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	399	0	this	b
    //   0	399	1	paramString	String
    //   64	332	2	l1	long
    //   66	257	4	l2	long
    //   52	273	6	localObject	Object
    //   237	84	7	localProcessErrorStateInfo	ActivityManager.ProcessErrorStateInfo
    // Exception table:
    //   from	to	target	type
    //   2	25	138	finally
    //   26	36	138	finally
    //   157	166	201	java/lang/Throwable
    //   36	54	339	java/lang/Throwable
    //   59	65	339	java/lang/Throwable
    //   76	92	339	java/lang/Throwable
    //   92	129	339	java/lang/Throwable
    //   143	157	339	java/lang/Throwable
    //   171	181	339	java/lang/Throwable
    //   181	192	339	java/lang/Throwable
    //   202	218	339	java/lang/Throwable
    //   227	239	339	java/lang/Throwable
    //   244	255	339	java/lang/Throwable
    //   264	294	339	java/lang/Throwable
    //   303	330	339	java/lang/Throwable
    //   36	54	381	finally
    //   59	65	381	finally
    //   76	92	381	finally
    //   92	129	381	finally
    //   143	157	381	finally
    //   157	166	381	finally
    //   171	181	381	finally
    //   181	192	381	finally
    //   202	218	381	finally
    //   227	239	381	finally
    //   244	255	381	finally
    //   264	294	381	finally
    //   303	330	381	finally
    //   340	351	381	finally
    //   351	372	381	finally
  }
  
  public final void a(boolean paramBoolean)
  {
    c(paramBoolean);
    boolean bool = i();
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
      if (paramBoolean != h())
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
  
  public final boolean a(Thread paramThread)
  {
    new HashMap();
    if (paramThread.getName().contains("main")) {}
    for (int m = 1;; m = 0)
    {
      if (m != 0)
      {
        paramThread = a(this.c, 10000L);
        if (paramThread == null)
        {
          x.c("anr handler onThreadBlock proc state is unvisiable!", new Object[0]);
          return false;
        }
        if (paramThread.pid != Process.myPid())
        {
          x.c("onThreadBlock not mind proc!", new Object[] { paramThread.processName });
          return false;
        }
      }
      for (;;)
      {
        try
        {
          Map localMap = z.a(200000, false);
          x.a("onThreadBlock found visiable anr , start to process!", new Object[0]);
          a(this.c, "", paramThread, System.currentTimeMillis(), localMap);
          return true;
        }
        catch (Throwable paramThread)
        {
          return false;
        }
        x.c("anr handler onThreadBlock only care main thread", new Object[0]);
      }
    }
  }
  
  protected final void b()
  {
    int n = 0;
    long l1 = z.b();
    long l2 = c.g;
    Object localObject1 = new File(this.g);
    if ((((File)localObject1).exists()) && (((File)localObject1).isDirectory())) {
      try
      {
        localObject1 = ((File)localObject1).listFiles();
        if (localObject1 != null)
        {
          if (localObject1.length == 0) {
            return;
          }
          int i2 = "bugly_trace_".length();
          int i3 = localObject1.length;
          int m = 0;
          Object localObject2;
          String str;
          int i1;
          for (;;)
          {
            if (m >= i3) {
              break label204;
            }
            localObject2 = localObject1[m];
            str = localObject2.getName();
            boolean bool = str.startsWith("bugly_trace_");
            i1 = n;
            if (bool) {}
            try
            {
              i1 = str.indexOf(".txt");
              if (i1 <= 0) {
                break;
              }
              long l3 = Long.parseLong(str.substring(i2, i1));
              if (l3 < l1 - l2) {
                break;
              }
              i1 = n;
            }
            catch (Throwable localThrowable2)
            {
              for (;;)
              {
                x.c("Trace file that has invalid format: " + str, new Object[0]);
                i1 = n;
                if (localObject2.delete()) {
                  i1 = n + 1;
                }
              }
            }
            m += 1;
            n = i1;
          }
          label204:
          x.c("Number of overdue trace files that has deleted: " + n, new Object[0]);
          return;
        }
      }
      catch (Throwable localThrowable1)
      {
        x.a(localThrowable1);
      }
    }
  }
  
  public final void c()
  {
    try
    {
      x.d("customer decides whether to open or close.", new Object[0]);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final boolean d()
  {
    if ((this.k != null) && (this.k.isAlive())) {
      return false;
    }
    this.k = new ab();
    ab localab = this.k;
    StringBuilder localStringBuilder = new StringBuilder("Bugly-ThreadMonitor");
    int m = this.l;
    this.l = (m + 1);
    localab.setName(m);
    this.k.a();
    this.k.a(this);
    return this.k.d();
  }
  
  public final boolean e()
  {
    boolean bool = false;
    if (this.k != null)
    {
      bool = this.k.c();
      this.k.b();
      this.k.b(this);
      this.k = null;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.bugly.crashreport.crash.anr.b
 * JD-Core Version:    0.7.0.1
 */
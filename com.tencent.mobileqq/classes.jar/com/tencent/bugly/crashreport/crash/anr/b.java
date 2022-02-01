package com.tencent.bugly.crashreport.crash.anr;

import android.app.ActivityManager;
import android.app.ActivityManager.ProcessErrorStateInfo;
import android.content.Context;
import android.os.FileObserver;
import android.os.Looper;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.crashreport.crash.c;
import com.tencent.bugly.proguard.aa;
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
  private ActivityManager.ProcessErrorStateInfo m;
  
  public b(Context paramContext, com.tencent.bugly.crashreport.common.strategy.a parama, com.tencent.bugly.crashreport.common.info.a parama1, w paramw, com.tencent.bugly.crashreport.crash.b paramb)
  {
    this.c = z.a(paramContext);
    this.g = paramContext.getDir("bugly", 0).getAbsolutePath();
    this.d = parama1;
    this.e = paramw;
    this.f = parama;
    this.h = paramb;
    this.m = new ActivityManager.ProcessErrorStateInfo();
  }
  
  private ActivityManager.ProcessErrorStateInfo a(Context paramContext, long paramLong)
  {
    try
    {
      x.c("to find!", new Object[0]);
      paramContext = (ActivityManager)paramContext.getSystemService("activity");
      int n = 0;
      Object localObject1;
      Object localObject2;
      for (;;)
      {
        x.c("waiting!", new Object[0]);
        localObject1 = paramContext.getProcessesInErrorState();
        if (localObject1 != null)
        {
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (ActivityManager.ProcessErrorStateInfo)((Iterator)localObject1).next();
            if (((ActivityManager.ProcessErrorStateInfo)localObject2).condition == 2)
            {
              x.c("found!", new Object[0]);
              return localObject2;
            }
          }
        }
        z.b(500L);
        if (n >= 20L)
        {
          x.c("end!", new Object[0]);
          break;
        }
        n += 1;
      }
      return null;
    }
    catch (OutOfMemoryError paramContext)
    {
      this.m.pid = Process.myPid();
      localObject1 = this.m;
      localObject2 = new StringBuilder("bugly sdk waitForAnrProcessStateChanged encount error:");
      ((StringBuilder)localObject2).append(paramContext.getMessage());
      ((ActivityManager.ProcessErrorStateInfo)localObject1).shortMsg = ((StringBuilder)localObject2).toString();
      return this.m;
    }
    catch (Exception paramContext)
    {
      x.b(paramContext);
    }
  }
  
  private CrashDetailBean a(a parama)
  {
    CrashDetailBean localCrashDetailBean = new CrashDetailBean();
    for (;;)
    {
      try
      {
        localCrashDetailBean.C = com.tencent.bugly.crashreport.common.info.b.k();
        localCrashDetailBean.D = com.tencent.bugly.crashreport.common.info.b.i();
        localCrashDetailBean.E = com.tencent.bugly.crashreport.common.info.b.m();
        localCrashDetailBean.F = this.d.n();
        localCrashDetailBean.G = this.d.m();
        localCrashDetailBean.H = this.d.o();
        localObject = this.c;
        if (!com.tencent.bugly.crashreport.common.info.b.t()) {
          localCrashDetailBean.w = z.a(this.c, c.e, c.h);
        }
        localCrashDetailBean.b = 3;
        localCrashDetailBean.e = this.d.g();
        localCrashDetailBean.f = this.d.m;
        localCrashDetailBean.g = this.d.u();
        localCrashDetailBean.m = this.d.f();
        localCrashDetailBean.n = "ANR_EXCEPTION";
        localCrashDetailBean.o = parama.f;
        localCrashDetailBean.q = parama.g;
        localCrashDetailBean.P = new HashMap();
        localCrashDetailBean.P.put("BUGLY_CR_01", parama.e);
        int n = -1;
        if (localCrashDetailBean.q != null) {
          n = localCrashDetailBean.q.indexOf("\n");
        }
        if (n > 0)
        {
          localObject = localCrashDetailBean.q.substring(0, n);
          localCrashDetailBean.p = ((String)localObject);
          localCrashDetailBean.r = parama.c;
          if (localCrashDetailBean.q != null) {
            localCrashDetailBean.u = z.b(localCrashDetailBean.q.getBytes());
          }
          localCrashDetailBean.z = parama.b;
          localCrashDetailBean.A = parama.a;
          localCrashDetailBean.B = "main(1)";
          localCrashDetailBean.I = this.d.w();
          localCrashDetailBean.h = this.d.t();
          localCrashDetailBean.i = this.d.H();
          localCrashDetailBean.v = parama.d;
          localCrashDetailBean.L = this.d.q;
          localCrashDetailBean.M = this.d.a;
          localCrashDetailBean.N = this.d.a();
          parama = this.c;
          if (!com.tencent.bugly.crashreport.common.info.b.t()) {
            this.h.d(localCrashDetailBean);
          }
          localCrashDetailBean.Q = this.d.F();
          localCrashDetailBean.R = this.d.G();
          localCrashDetailBean.S = this.d.z();
          localCrashDetailBean.T = this.d.E();
          localCrashDetailBean.y = y.a();
          return localCrashDetailBean;
        }
      }
      catch (Throwable parama)
      {
        if (!x.a(parama)) {
          parama.printStackTrace();
        }
        return localCrashDetailBean;
      }
      Object localObject = "GET_FAIL";
    }
  }
  
  private boolean a(Context paramContext, String paramString, ActivityManager.ProcessErrorStateInfo paramProcessErrorStateInfo, long paramLong, Map<String, String> paramMap)
  {
    paramContext = paramContext.getFilesDir();
    Object localObject = new StringBuilder("bugly/bugly_trace_");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append(".txt");
    paramContext = new File(paramContext, ((StringBuilder)localObject).toString());
    a locala = new a();
    locala.c = paramLong;
    locala.d = paramContext.getAbsolutePath();
    localObject = "";
    if (paramProcessErrorStateInfo != null) {
      paramContext = paramProcessErrorStateInfo.processName;
    } else {
      paramContext = "";
    }
    locala.a = paramContext;
    if (paramProcessErrorStateInfo != null) {
      paramContext = paramProcessErrorStateInfo.shortMsg;
    } else {
      paramContext = "";
    }
    locala.f = paramContext;
    paramContext = (Context)localObject;
    if (paramProcessErrorStateInfo != null) {
      paramContext = paramProcessErrorStateInfo.longMsg;
    }
    locala.e = paramContext;
    locala.b = paramMap;
    paramContext = Looper.getMainLooper().getThread();
    if (paramMap != null)
    {
      paramProcessErrorStateInfo = paramMap.keySet().iterator();
      while (paramProcessErrorStateInfo.hasNext())
      {
        localObject = (String)paramProcessErrorStateInfo.next();
        if (((String)localObject).startsWith(paramContext.getName())) {
          locala.g = ((String)paramMap.get(localObject));
        }
      }
    }
    if (TextUtils.isEmpty(locala.g)) {
      locala.g = "main stack is null , some error may be encountered.";
    }
    paramLong = locala.c;
    paramContext = locala.d;
    paramProcessErrorStateInfo = locala.a;
    paramMap = locala.g;
    localObject = locala.f;
    String str = locala.e;
    int n;
    if (locala.b == null) {
      n = 0;
    } else {
      n = locala.b.size();
    }
    x.c("anr tm:%d\ntr:%s\nproc:%s\nmain stack:%s\nsMsg:%s\n lMsg:%s\n threads:%d", new Object[] { Long.valueOf(paramLong), paramContext, paramProcessErrorStateInfo, paramMap, localObject, str, Integer.valueOf(n) });
    if (!this.f.c().i)
    {
      x.d("ANR Report is closed! print local for helpful!", new Object[0]);
      com.tencent.bugly.crashreport.crash.b.a("ANR", z.a(), locala.a, "main", locala.g, null);
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
    } else {
      x.d("backup anr record fail!", new Object[0]);
    }
    if ((paramString != null) && (new File(paramString).exists()))
    {
      this.a.set(3);
      if (a(paramString, locala.d, locala.a)) {
        x.a("backup trace success", new Object[0]);
      }
    }
    com.tencent.bugly.crashreport.crash.b.a("ANR", z.a(), locala.a, "main", locala.g, paramContext);
    if (!this.h.a(paramContext)) {
      this.h.a(paramContext, 3000L, true);
    }
    this.h.c(paramContext);
    return true;
  }
  
  /* Error */
  private static boolean a(String paramString1, String paramString2, String paramString3)
  {
    // Byte code:
    //   0: aload_2
    //   1: aload_0
    //   2: iconst_1
    //   3: invokestatic 546	com/tencent/bugly/crashreport/crash/anr/TraceFileHelper:readTargetDumpInfo	(Ljava/lang/String;Ljava/lang/String;Z)Lcom/tencent/bugly/crashreport/crash/anr/TraceFileHelper$a;
    //   6: astore_3
    //   7: aload_3
    //   8: ifnull +704 -> 712
    //   11: aload_3
    //   12: getfield 550	com/tencent/bugly/crashreport/crash/anr/TraceFileHelper$a:d	Ljava/util/Map;
    //   15: ifnull +697 -> 712
    //   18: aload_3
    //   19: getfield 550	com/tencent/bugly/crashreport/crash/anr/TraceFileHelper$a:d	Ljava/util/Map;
    //   22: invokeinterface 459 1 0
    //   27: ifgt +6 -> 33
    //   30: goto +682 -> 712
    //   33: new 67	java/io/File
    //   36: dup
    //   37: aload_1
    //   38: invokespecial 515	java/io/File:<init>	(Ljava/lang/String;)V
    //   41: astore 4
    //   43: aload 4
    //   45: invokevirtual 518	java/io/File:exists	()Z
    //   48: ifne +29 -> 77
    //   51: aload 4
    //   53: invokevirtual 553	java/io/File:getParentFile	()Ljava/io/File;
    //   56: invokevirtual 518	java/io/File:exists	()Z
    //   59: ifne +12 -> 71
    //   62: aload 4
    //   64: invokevirtual 553	java/io/File:getParentFile	()Ljava/io/File;
    //   67: invokevirtual 556	java/io/File:mkdirs	()Z
    //   70: pop
    //   71: aload 4
    //   73: invokevirtual 559	java/io/File:createNewFile	()Z
    //   76: pop
    //   77: aload 4
    //   79: invokevirtual 518	java/io/File:exists	()Z
    //   82: ifeq +540 -> 622
    //   85: aload 4
    //   87: invokevirtual 562	java/io/File:canWrite	()Z
    //   90: ifne +6 -> 96
    //   93: goto +529 -> 622
    //   96: aconst_null
    //   97: astore_2
    //   98: aconst_null
    //   99: astore_0
    //   100: new 564	java/io/BufferedWriter
    //   103: dup
    //   104: new 566	java/io/FileWriter
    //   107: dup
    //   108: aload 4
    //   110: iconst_0
    //   111: invokespecial 569	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   114: invokespecial 572	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   117: astore_1
    //   118: aload_3
    //   119: getfield 550	com/tencent/bugly/crashreport/crash/anr/TraceFileHelper$a:d	Ljava/util/Map;
    //   122: ldc_w 491
    //   125: invokeinterface 448 2 0
    //   130: checkcast 574	[Ljava/lang/String;
    //   133: astore 4
    //   135: aload 4
    //   137: ifnull +100 -> 237
    //   140: aload 4
    //   142: arraylength
    //   143: iconst_3
    //   144: if_icmplt +93 -> 237
    //   147: aload 4
    //   149: iconst_0
    //   150: aaload
    //   151: astore_0
    //   152: aload 4
    //   154: iconst_1
    //   155: aaload
    //   156: astore_2
    //   157: aload 4
    //   159: iconst_2
    //   160: aaload
    //   161: astore 4
    //   163: new 154	java/lang/StringBuilder
    //   166: dup
    //   167: ldc_w 576
    //   170: invokespecial 159	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   173: astore 5
    //   175: aload 5
    //   177: aload 4
    //   179: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: pop
    //   183: aload 5
    //   185: ldc_w 578
    //   188: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: pop
    //   192: aload 5
    //   194: aload_0
    //   195: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: pop
    //   199: aload 5
    //   201: ldc_w 280
    //   204: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: pop
    //   208: aload 5
    //   210: aload_2
    //   211: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: pop
    //   215: aload 5
    //   217: ldc_w 580
    //   220: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: aload_1
    //   225: aload 5
    //   227: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   230: invokevirtual 583	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   233: aload_1
    //   234: invokevirtual 586	java/io/BufferedWriter:flush	()V
    //   237: aload_3
    //   238: getfield 550	com/tencent/bugly/crashreport/crash/anr/TraceFileHelper$a:d	Ljava/util/Map;
    //   241: invokeinterface 589 1 0
    //   246: invokeinterface 435 1 0
    //   251: astore_0
    //   252: aload_0
    //   253: invokeinterface 125 1 0
    //   258: ifeq +194 -> 452
    //   261: aload_0
    //   262: invokeinterface 129 1 0
    //   267: checkcast 591	java/util/Map$Entry
    //   270: astore_2
    //   271: aload_2
    //   272: invokeinterface 594 1 0
    //   277: checkcast 282	java/lang/String
    //   280: ldc_w 491
    //   283: invokevirtual 598	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   286: ifne -34 -> 252
    //   289: aload_2
    //   290: invokeinterface 601 1 0
    //   295: ifnull +154 -> 449
    //   298: aload_2
    //   299: invokeinterface 601 1 0
    //   304: checkcast 574	[Ljava/lang/String;
    //   307: arraylength
    //   308: iconst_3
    //   309: if_icmplt +140 -> 449
    //   312: aload_2
    //   313: invokeinterface 601 1 0
    //   318: checkcast 574	[Ljava/lang/String;
    //   321: iconst_0
    //   322: aaload
    //   323: astore_3
    //   324: aload_2
    //   325: invokeinterface 601 1 0
    //   330: checkcast 574	[Ljava/lang/String;
    //   333: iconst_1
    //   334: aaload
    //   335: astore 4
    //   337: aload_2
    //   338: invokeinterface 601 1 0
    //   343: checkcast 574	[Ljava/lang/String;
    //   346: iconst_2
    //   347: aaload
    //   348: astore 5
    //   350: new 154	java/lang/StringBuilder
    //   353: dup
    //   354: ldc_w 603
    //   357: invokespecial 159	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   360: astore 6
    //   362: aload 6
    //   364: aload_2
    //   365: invokeinterface 594 1 0
    //   370: checkcast 282	java/lang/String
    //   373: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: pop
    //   377: aload 6
    //   379: ldc_w 605
    //   382: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: pop
    //   386: aload 6
    //   388: aload 5
    //   390: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: pop
    //   394: aload 6
    //   396: ldc_w 578
    //   399: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: pop
    //   403: aload 6
    //   405: aload_3
    //   406: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: pop
    //   410: aload 6
    //   412: ldc_w 280
    //   415: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: pop
    //   419: aload 6
    //   421: aload 4
    //   423: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   426: pop
    //   427: aload 6
    //   429: ldc_w 580
    //   432: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   435: pop
    //   436: aload_1
    //   437: aload 6
    //   439: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   442: invokevirtual 583	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   445: aload_1
    //   446: invokevirtual 586	java/io/BufferedWriter:flush	()V
    //   449: goto -197 -> 252
    //   452: aload_1
    //   453: invokevirtual 608	java/io/BufferedWriter:close	()V
    //   456: iconst_1
    //   457: ireturn
    //   458: astore_0
    //   459: aload_0
    //   460: invokestatic 389	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   463: ifne +7 -> 470
    //   466: aload_0
    //   467: invokevirtual 609	java/io/IOException:printStackTrace	()V
    //   470: iconst_1
    //   471: ireturn
    //   472: astore_0
    //   473: goto +12 -> 485
    //   476: astore_2
    //   477: goto +16 -> 493
    //   480: astore_2
    //   481: aload_0
    //   482: astore_1
    //   483: aload_2
    //   484: astore_0
    //   485: goto +112 -> 597
    //   488: astore_0
    //   489: aload_2
    //   490: astore_1
    //   491: aload_0
    //   492: astore_2
    //   493: aload_1
    //   494: astore_0
    //   495: aload_2
    //   496: invokestatic 389	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   499: ifne +9 -> 508
    //   502: aload_1
    //   503: astore_0
    //   504: aload_2
    //   505: invokevirtual 609	java/io/IOException:printStackTrace	()V
    //   508: aload_1
    //   509: astore_0
    //   510: new 154	java/lang/StringBuilder
    //   513: dup
    //   514: invokespecial 610	java/lang/StringBuilder:<init>	()V
    //   517: astore_3
    //   518: aload_1
    //   519: astore_0
    //   520: aload_3
    //   521: aload_2
    //   522: invokevirtual 614	java/lang/Object:getClass	()Ljava/lang/Class;
    //   525: invokevirtual 617	java/lang/Class:getName	()Ljava/lang/String;
    //   528: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   531: pop
    //   532: aload_1
    //   533: astore_0
    //   534: aload_3
    //   535: ldc_w 619
    //   538: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   541: pop
    //   542: aload_1
    //   543: astore_0
    //   544: aload_3
    //   545: aload_2
    //   546: invokevirtual 620	java/io/IOException:getMessage	()Ljava/lang/String;
    //   549: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   552: pop
    //   553: aload_1
    //   554: astore_0
    //   555: ldc_w 622
    //   558: iconst_1
    //   559: anewarray 4	java/lang/Object
    //   562: dup
    //   563: iconst_0
    //   564: aload_3
    //   565: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   568: aastore
    //   569: invokestatic 504	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   572: pop
    //   573: aload_1
    //   574: ifnull +21 -> 595
    //   577: aload_1
    //   578: invokevirtual 608	java/io/BufferedWriter:close	()V
    //   581: iconst_0
    //   582: ireturn
    //   583: astore_0
    //   584: aload_0
    //   585: invokestatic 389	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   588: ifne +7 -> 595
    //   591: aload_0
    //   592: invokevirtual 609	java/io/IOException:printStackTrace	()V
    //   595: iconst_0
    //   596: ireturn
    //   597: aload_1
    //   598: ifnull +22 -> 620
    //   601: aload_1
    //   602: invokevirtual 608	java/io/BufferedWriter:close	()V
    //   605: goto +15 -> 620
    //   608: astore_1
    //   609: aload_1
    //   610: invokestatic 389	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   613: ifne +7 -> 620
    //   616: aload_1
    //   617: invokevirtual 609	java/io/IOException:printStackTrace	()V
    //   620: aload_0
    //   621: athrow
    //   622: ldc_w 624
    //   625: iconst_1
    //   626: anewarray 4	java/lang/Object
    //   629: dup
    //   630: iconst_0
    //   631: aload_1
    //   632: aastore
    //   633: invokestatic 504	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   636: pop
    //   637: iconst_0
    //   638: ireturn
    //   639: astore_0
    //   640: aload_0
    //   641: invokestatic 389	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   644: ifne +7 -> 651
    //   647: aload_0
    //   648: invokevirtual 625	java/lang/Exception:printStackTrace	()V
    //   651: new 154	java/lang/StringBuilder
    //   654: dup
    //   655: invokespecial 610	java/lang/StringBuilder:<init>	()V
    //   658: astore_2
    //   659: aload_2
    //   660: aload_0
    //   661: invokevirtual 614	java/lang/Object:getClass	()Ljava/lang/Class;
    //   664: invokevirtual 617	java/lang/Class:getName	()Ljava/lang/String;
    //   667: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   670: pop
    //   671: aload_2
    //   672: ldc_w 619
    //   675: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   678: pop
    //   679: aload_2
    //   680: aload_0
    //   681: invokevirtual 626	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   684: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   687: pop
    //   688: ldc_w 628
    //   691: iconst_2
    //   692: anewarray 4	java/lang/Object
    //   695: dup
    //   696: iconst_0
    //   697: aload_2
    //   698: invokevirtual 169	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   701: aastore
    //   702: dup
    //   703: iconst_1
    //   704: aload_1
    //   705: aastore
    //   706: invokestatic 504	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   709: pop
    //   710: iconst_0
    //   711: ireturn
    //   712: ldc_w 630
    //   715: iconst_1
    //   716: anewarray 4	java/lang/Object
    //   719: dup
    //   720: iconst_0
    //   721: aload_2
    //   722: aastore
    //   723: invokestatic 504	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   726: pop
    //   727: iconst_0
    //   728: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	729	0	paramString1	String
    //   0	729	1	paramString2	String
    //   0	729	2	paramString3	String
    //   6	559	3	localObject1	Object
    //   41	381	4	localObject2	Object
    //   173	216	5	localObject3	Object
    //   360	78	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   452	456	458	java/io/IOException
    //   118	135	472	finally
    //   140	147	472	finally
    //   163	237	472	finally
    //   237	252	472	finally
    //   252	449	472	finally
    //   118	135	476	java/io/IOException
    //   140	147	476	java/io/IOException
    //   163	237	476	java/io/IOException
    //   237	252	476	java/io/IOException
    //   252	449	476	java/io/IOException
    //   100	118	480	finally
    //   495	502	480	finally
    //   504	508	480	finally
    //   510	518	480	finally
    //   520	532	480	finally
    //   534	542	480	finally
    //   544	553	480	finally
    //   555	573	480	finally
    //   100	118	488	java/io/IOException
    //   577	581	583	java/io/IOException
    //   601	605	608	java/io/IOException
    //   43	71	639	java/lang/Exception
    //   71	77	639	java/lang/Exception
  }
  
  private void b(boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      f();
      return;
    }
    finally {}
    g();
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
    //   3: invokespecial 644	com/tencent/bugly/crashreport/crash/anr/b:h	()Z
    //   6: ifeq +17 -> 23
    //   9: ldc_w 646
    //   12: iconst_0
    //   13: anewarray 4	java/lang/Object
    //   16: invokestatic 485	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   19: pop
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: aload_0
    //   24: new 648	com/tencent/bugly/crashreport/crash/anr/b$1
    //   27: dup
    //   28: aload_0
    //   29: ldc_w 650
    //   32: bipush 8
    //   34: invokespecial 653	com/tencent/bugly/crashreport/crash/anr/b$1:<init>	(Lcom/tencent/bugly/crashreport/crash/anr/b;Ljava/lang/String;I)V
    //   37: putfield 655	com/tencent/bugly/crashreport/crash/anr/b:i	Landroid/os/FileObserver;
    //   40: aload_0
    //   41: getfield 655	com/tencent/bugly/crashreport/crash/anr/b:i	Landroid/os/FileObserver;
    //   44: invokevirtual 660	android/os/FileObserver:startWatching	()V
    //   47: ldc_w 662
    //   50: iconst_0
    //   51: anewarray 4	java/lang/Object
    //   54: invokestatic 498	com/tencent/bugly/proguard/x:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   57: pop
    //   58: aload_0
    //   59: getfield 77	com/tencent/bugly/crashreport/crash/anr/b:e	Lcom/tencent/bugly/proguard/w;
    //   62: new 664	com/tencent/bugly/crashreport/crash/anr/b$2
    //   65: dup
    //   66: aload_0
    //   67: invokespecial 667	com/tencent/bugly/crashreport/crash/anr/b$2:<init>	(Lcom/tencent/bugly/crashreport/crash/anr/b;)V
    //   70: invokevirtual 672	com/tencent/bugly/proguard/w:a	(Ljava/lang/Runnable;)Z
    //   73: pop
    //   74: aload_0
    //   75: monitorexit
    //   76: return
    //   77: astore_1
    //   78: aload_0
    //   79: aconst_null
    //   80: putfield 655	com/tencent/bugly/crashreport/crash/anr/b:i	Landroid/os/FileObserver;
    //   83: ldc_w 674
    //   86: iconst_0
    //   87: anewarray 4	java/lang/Object
    //   90: invokestatic 485	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   93: pop
    //   94: aload_1
    //   95: invokestatic 389	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   98: ifne +7 -> 105
    //   101: aload_1
    //   102: invokevirtual 392	java/lang/Throwable:printStackTrace	()V
    //   105: aload_0
    //   106: monitorexit
    //   107: return
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
    //   3: invokespecial 644	com/tencent/bugly/crashreport/crash/anr/b:h	()Z
    //   6: ifne +17 -> 23
    //   9: ldc_w 676
    //   12: iconst_0
    //   13: anewarray 4	java/lang/Object
    //   16: invokestatic 485	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   19: pop
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: aload_0
    //   24: getfield 655	com/tencent/bugly/crashreport/crash/anr/b:i	Landroid/os/FileObserver;
    //   27: invokevirtual 679	android/os/FileObserver:stopWatching	()V
    //   30: aload_0
    //   31: aconst_null
    //   32: putfield 655	com/tencent/bugly/crashreport/crash/anr/b:i	Landroid/os/FileObserver;
    //   35: ldc_w 681
    //   38: iconst_0
    //   39: anewarray 4	java/lang/Object
    //   42: invokestatic 485	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   45: pop
    //   46: aload_0
    //   47: monitorexit
    //   48: return
    //   49: astore_1
    //   50: ldc_w 683
    //   53: iconst_0
    //   54: anewarray 4	java/lang/Object
    //   57: invokestatic 485	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   60: pop
    //   61: aload_1
    //   62: invokestatic 389	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   65: ifne +7 -> 72
    //   68: aload_1
    //   69: invokevirtual 392	java/lang/Throwable:printStackTrace	()V
    //   72: aload_0
    //   73: monitorexit
    //   74: return
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
    //   3: getfield 655	com/tencent/bugly/crashreport/crash/anr/b:i	Landroid/os/FileObserver;
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
    //   25: goto +5 -> 30
    //   28: aload_2
    //   29: athrow
    //   30: goto -2 -> 28
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	33	0	this	b
    //   12	7	1	bool	boolean
    //   6	2	2	localFileObserver	FileObserver
    //   22	7	2	localObject	Object
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
    //   3: getfield 44	com/tencent/bugly/crashreport/crash/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   6: invokevirtual 685	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   9: ifeq +17 -> 26
    //   12: ldc_w 687
    //   15: iconst_0
    //   16: anewarray 4	java/lang/Object
    //   19: invokestatic 99	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   22: pop
    //   23: aload_0
    //   24: monitorexit
    //   25: return
    //   26: aload_0
    //   27: getfield 44	com/tencent/bugly/crashreport/crash/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   30: iconst_1
    //   31: invokevirtual 521	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   34: aload_0
    //   35: monitorexit
    //   36: ldc_w 689
    //   39: iconst_0
    //   40: anewarray 4	java/lang/Object
    //   43: invokestatic 99	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   46: pop
    //   47: aload_1
    //   48: iconst_0
    //   49: invokestatic 693	com/tencent/bugly/crashreport/crash/anr/TraceFileHelper:readFirstDumpInfo	(Ljava/lang/String;Z)Lcom/tencent/bugly/crashreport/crash/anr/TraceFileHelper$a;
    //   52: astore 6
    //   54: aload 6
    //   56: ifnull +326 -> 382
    //   59: aload 6
    //   61: getfield 694	com/tencent/bugly/crashreport/crash/anr/TraceFileHelper$a:c	J
    //   64: lstore_2
    //   65: goto +3 -> 68
    //   68: lload_2
    //   69: lstore 4
    //   71: lload_2
    //   72: ldc2_w 45
    //   75: lcmp
    //   76: ifne +19 -> 95
    //   79: ldc_w 696
    //   82: iconst_0
    //   83: anewarray 4	java/lang/Object
    //   86: invokestatic 485	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   89: pop
    //   90: invokestatic 701	java/lang/System:currentTimeMillis	()J
    //   93: lstore 4
    //   95: lload 4
    //   97: aload_0
    //   98: getfield 48	com/tencent/bugly/crashreport/crash/anr/b:b	J
    //   101: lsub
    //   102: invokestatic 707	java/lang/Math:abs	(J)J
    //   105: ldc2_w 708
    //   108: lcmp
    //   109: ifge +32 -> 141
    //   112: ldc_w 711
    //   115: iconst_1
    //   116: anewarray 4	java/lang/Object
    //   119: dup
    //   120: iconst_0
    //   121: sipush 10000
    //   124: invokestatic 472	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   127: aastore
    //   128: invokestatic 485	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   131: pop
    //   132: aload_0
    //   133: getfield 44	com/tencent/bugly/crashreport/crash/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   136: iconst_0
    //   137: invokevirtual 521	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   140: return
    //   141: aload_0
    //   142: lload 4
    //   144: putfield 48	com/tencent/bugly/crashreport/crash/anr/b:b	J
    //   147: aload_0
    //   148: getfield 44	com/tencent/bugly/crashreport/crash/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   151: iconst_1
    //   152: invokevirtual 521	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   155: getstatic 713	com/tencent/bugly/crashreport/crash/c:f	I
    //   158: iconst_0
    //   159: invokestatic 716	com/tencent/bugly/proguard/z:a	(IZ)Ljava/util/Map;
    //   162: astore 6
    //   164: aload 6
    //   166: ifnull +121 -> 287
    //   169: aload 6
    //   171: invokeinterface 459 1 0
    //   176: ifgt +6 -> 182
    //   179: goto +108 -> 287
    //   182: aload_0
    //   183: aload_0
    //   184: aload_0
    //   185: getfield 57	com/tencent/bugly/crashreport/crash/anr/b:c	Landroid/content/Context;
    //   188: ldc2_w 708
    //   191: invokespecial 718	com/tencent/bugly/crashreport/crash/anr/b:a	(Landroid/content/Context;J)Landroid/app/ActivityManager$ProcessErrorStateInfo;
    //   194: putfield 86	com/tencent/bugly/crashreport/crash/anr/b:m	Landroid/app/ActivityManager$ProcessErrorStateInfo;
    //   197: aload_0
    //   198: getfield 86	com/tencent/bugly/crashreport/crash/anr/b:m	Landroid/app/ActivityManager$ProcessErrorStateInfo;
    //   201: ifnonnull +17 -> 218
    //   204: ldc_w 720
    //   207: iconst_0
    //   208: anewarray 4	java/lang/Object
    //   211: invokestatic 99	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   214: pop
    //   215: goto -83 -> 132
    //   218: aload_0
    //   219: getfield 86	com/tencent/bugly/crashreport/crash/anr/b:m	Landroid/app/ActivityManager$ProcessErrorStateInfo;
    //   222: getfield 152	android/app/ActivityManager$ProcessErrorStateInfo:pid	I
    //   225: invokestatic 149	android/os/Process:myPid	()I
    //   228: if_icmpeq +27 -> 255
    //   231: ldc_w 722
    //   234: iconst_1
    //   235: anewarray 4	java/lang/Object
    //   238: dup
    //   239: iconst_0
    //   240: aload_0
    //   241: getfield 86	com/tencent/bugly/crashreport/crash/anr/b:m	Landroid/app/ActivityManager$ProcessErrorStateInfo;
    //   244: getfield 415	android/app/ActivityManager$ProcessErrorStateInfo:processName	Ljava/lang/String;
    //   247: aastore
    //   248: invokestatic 99	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   251: pop
    //   252: goto -120 -> 132
    //   255: ldc_w 724
    //   258: iconst_0
    //   259: anewarray 4	java/lang/Object
    //   262: invokestatic 498	com/tencent/bugly/proguard/x:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   265: pop
    //   266: aload_0
    //   267: aload_0
    //   268: getfield 57	com/tencent/bugly/crashreport/crash/anr/b:c	Landroid/content/Context;
    //   271: aload_1
    //   272: aload_0
    //   273: getfield 86	com/tencent/bugly/crashreport/crash/anr/b:m	Landroid/app/ActivityManager$ProcessErrorStateInfo;
    //   276: lload 4
    //   278: aload 6
    //   280: invokespecial 726	com/tencent/bugly/crashreport/crash/anr/b:a	(Landroid/content/Context;Ljava/lang/String;Landroid/app/ActivityManager$ProcessErrorStateInfo;JLjava/util/Map;)Z
    //   283: pop
    //   284: goto -152 -> 132
    //   287: ldc_w 728
    //   290: iconst_0
    //   291: anewarray 4	java/lang/Object
    //   294: invokestatic 485	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   297: pop
    //   298: goto -166 -> 132
    //   301: astore_1
    //   302: aload_1
    //   303: invokestatic 389	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   306: pop
    //   307: ldc_w 730
    //   310: iconst_0
    //   311: anewarray 4	java/lang/Object
    //   314: invokestatic 504	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   317: pop
    //   318: goto -186 -> 132
    //   321: astore_1
    //   322: goto +39 -> 361
    //   325: astore_1
    //   326: aload_1
    //   327: invokestatic 389	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   330: ifne +7 -> 337
    //   333: aload_1
    //   334: invokevirtual 392	java/lang/Throwable:printStackTrace	()V
    //   337: ldc_w 732
    //   340: iconst_1
    //   341: anewarray 4	java/lang/Object
    //   344: dup
    //   345: iconst_0
    //   346: aload_1
    //   347: invokevirtual 614	java/lang/Object:getClass	()Ljava/lang/Class;
    //   350: invokevirtual 733	java/lang/Class:toString	()Ljava/lang/String;
    //   353: aastore
    //   354: invokestatic 504	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   357: pop
    //   358: goto -226 -> 132
    //   361: aload_0
    //   362: getfield 44	com/tencent/bugly/crashreport/crash/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   365: iconst_0
    //   366: invokevirtual 521	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   369: aload_1
    //   370: athrow
    //   371: astore_1
    //   372: aload_0
    //   373: monitorexit
    //   374: goto +5 -> 379
    //   377: aload_1
    //   378: athrow
    //   379: goto -2 -> 377
    //   382: ldc2_w 45
    //   385: lstore_2
    //   386: goto -318 -> 68
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	389	0	this	b
    //   0	389	1	paramString	String
    //   64	322	2	l1	long
    //   69	208	4	l2	long
    //   52	227	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   155	164	301	java/lang/Throwable
    //   36	54	321	finally
    //   59	65	321	finally
    //   79	95	321	finally
    //   95	132	321	finally
    //   141	155	321	finally
    //   155	164	321	finally
    //   169	179	321	finally
    //   182	215	321	finally
    //   218	252	321	finally
    //   255	284	321	finally
    //   287	298	321	finally
    //   302	318	321	finally
    //   326	337	321	finally
    //   337	358	321	finally
    //   36	54	325	java/lang/Throwable
    //   59	65	325	java/lang/Throwable
    //   79	95	325	java/lang/Throwable
    //   95	132	325	java/lang/Throwable
    //   141	155	325	java/lang/Throwable
    //   169	179	325	java/lang/Throwable
    //   182	215	325	java/lang/Throwable
    //   218	252	325	java/lang/Throwable
    //   255	284	325	java/lang/Throwable
    //   287	298	325	java/lang/Throwable
    //   302	318	325	java/lang/Throwable
    //   2	25	371	finally
    //   26	36	371	finally
  }
  
  public final void a(boolean paramBoolean)
  {
    c(paramBoolean);
    boolean bool = i();
    com.tencent.bugly.crashreport.common.strategy.a locala = com.tencent.bugly.crashreport.common.strategy.a.a();
    paramBoolean = bool;
    if (locala != null) {
      if ((bool) && (locala.c().f)) {
        paramBoolean = true;
      } else {
        paramBoolean = false;
      }
    }
    if (paramBoolean != h())
    {
      x.a("anr changed to %b", new Object[] { Boolean.valueOf(paramBoolean) });
      b(paramBoolean);
    }
  }
  
  public final boolean a()
  {
    return this.a.get() != 0;
  }
  
  public final boolean a(aa paramaa)
  {
    HashMap localHashMap = new HashMap();
    if (paramaa.e().equals(Looper.getMainLooper()))
    {
      this.m = a(this.c, 10000L);
      paramaa = this.m;
      if (paramaa == null)
      {
        x.c("anr handler onThreadBlock proc state is unvisiable!", new Object[0]);
        return false;
      }
      if (paramaa.pid != Process.myPid())
      {
        x.c("onThreadBlock not mind proc!", new Object[] { this.m.processName });
        return false;
      }
      try
      {
        paramaa = z.a(200000, false);
      }
      catch (Throwable paramaa)
      {
        for (;;)
        {
          x.b(paramaa);
          localHashMap.put("main", paramaa.getMessage());
          paramaa = localHashMap;
        }
      }
      x.c("onThreadBlock found visiable anr , start to process!", new Object[0]);
      a(this.c, "", this.m, System.currentTimeMillis(), paramaa);
      return true;
    }
    x.c("anr handler onThreadBlock only care main thread ,current thread is: %s", new Object[] { paramaa.d() });
    return true;
  }
  
  protected final void b()
  {
    long l1 = z.b();
    long l2 = c.g;
    Object localObject1 = new File(this.g);
    if ((((File)localObject1).exists()) && (((File)localObject1).isDirectory())) {}
    for (;;)
    {
      int n;
      try
      {
        localObject1 = ((File)localObject1).listFiles();
        if (localObject1 != null)
        {
          if (localObject1.length == 0) {
            return;
          }
          int i3 = localObject1.length;
          n = 0;
          i1 = 0;
          if (n < i3)
          {
            localObject2 = localObject1[n];
            str = localObject2.getName();
            boolean bool = str.startsWith("bugly_trace_");
            i2 = i1;
            if (!bool) {
              break label242;
            }
          }
        }
      }
      catch (Throwable localThrowable1)
      {
        Object localObject2;
        String str;
        long l3;
        StringBuilder localStringBuilder;
        x.a(localThrowable1);
      }
      try
      {
        i2 = str.indexOf(".txt");
        if (i2 <= 0) {
          continue;
        }
        l3 = Long.parseLong(str.substring(12, i2));
        if (l3 < l1 - l2) {
          continue;
        }
        i2 = i1;
      }
      catch (Throwable localThrowable2)
      {
        continue;
      }
      localStringBuilder = new StringBuilder("Trace file that has invalid format: ");
      localStringBuilder.append(str);
      x.c(localStringBuilder.toString(), new Object[0]);
      int i2 = i1;
      if (localObject2.delete())
      {
        i2 = i1 + 1;
        break label242;
        localObject1 = new StringBuilder("Number of overdue trace files that has deleted: ");
        ((StringBuilder)localObject1).append(i1);
        x.c(((StringBuilder)localObject1).toString(), new Object[0]);
        return;
        return;
      }
      label242:
      n += 1;
      int i1 = i2;
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
    ab localab = this.k;
    if ((localab != null) && (localab.isAlive())) {
      return false;
    }
    this.k = new ab();
    localab = this.k;
    StringBuilder localStringBuilder = new StringBuilder("Bugly-ThreadMonitor");
    int n = this.l;
    this.l = (n + 1);
    localStringBuilder.append(n);
    localab.setName(localStringBuilder.toString());
    this.k.a();
    this.k.a(this);
    return this.k.d();
  }
  
  public final boolean e()
  {
    ab localab = this.k;
    if (localab != null)
    {
      boolean bool = localab.c();
      this.k.b();
      this.k.b(this);
      this.k = null;
      return bool;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.bugly.crashreport.crash.anr.b
 * JD-Core Version:    0.7.0.1
 */
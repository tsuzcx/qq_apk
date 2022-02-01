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
    paramLong = 0L;
    if (10000L < 0L) {}
    for (;;)
    {
      int n;
      try
      {
        x.c("to find!", new Object[0]);
        paramContext = (ActivityManager)paramContext.getSystemService("activity");
        paramLong /= 500L;
        n = 0;
        x.c("waiting!", new Object[0]);
        Object localObject = paramContext.getProcessesInErrorState();
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          if (((Iterator)localObject).hasNext())
          {
            ActivityManager.ProcessErrorStateInfo localProcessErrorStateInfo = (ActivityManager.ProcessErrorStateInfo)((Iterator)localObject).next();
            if (localProcessErrorStateInfo.condition != 2) {
              continue;
            }
            x.c("found!", new Object[0]);
            return localProcessErrorStateInfo;
          }
        }
        z.b(500L);
        if (n < paramLong) {
          break label190;
        }
        x.c("end!", new Object[0]);
      }
      catch (Exception paramContext)
      {
        x.b(paramContext);
        continue;
      }
      catch (OutOfMemoryError paramContext)
      {
        this.m.pid = Process.myPid();
        this.m.shortMsg = ("bugly sdk waitForAnrProcessStateChanged encount error:" + paramContext.getMessage());
        return this.m;
      }
      return null;
      label190:
      n += 1;
      continue;
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
      Object localObject = this.c;
      if (!com.tencent.bugly.crashreport.common.info.b.t()) {
        localCrashDetailBean.w = z.a(this.c, c.e, c.h);
      }
      localCrashDetailBean.b = 3;
      localCrashDetailBean.e = this.d.g();
      localCrashDetailBean.f = this.d.m;
      localCrashDetailBean.g = this.d.v();
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
      if (n > 0) {}
      for (localObject = localCrashDetailBean.q.substring(0, n);; localObject = "GET_FAIL")
      {
        localCrashDetailBean.p = ((String)localObject);
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
        parama = this.c;
        if (!com.tencent.bugly.crashreport.common.info.b.t()) {
          this.h.d(localCrashDetailBean);
        }
        localCrashDetailBean.Q = this.d.G();
        localCrashDetailBean.R = this.d.H();
        localCrashDetailBean.S = this.d.A();
        localCrashDetailBean.T = this.d.F();
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
    label85:
    label100:
    String str1;
    String str2;
    if (paramProcessErrorStateInfo != null)
    {
      paramContext = paramProcessErrorStateInfo.processName;
      locala.a = paramContext;
      if (paramProcessErrorStateInfo == null) {
        break label365;
      }
      paramContext = paramProcessErrorStateInfo.shortMsg;
      locala.f = paramContext;
      if (paramProcessErrorStateInfo == null) {
        break label372;
      }
      paramContext = paramProcessErrorStateInfo.longMsg;
      locala.e = paramContext;
      locala.b = paramMap;
      paramContext = Looper.getMainLooper().getThread();
      if (paramMap != null)
      {
        paramProcessErrorStateInfo = paramMap.keySet().iterator();
        while (paramProcessErrorStateInfo.hasNext())
        {
          str1 = (String)paramProcessErrorStateInfo.next();
          if (str1.startsWith(paramContext.getName())) {
            locala.g = ((String)paramMap.get(str1));
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
      str1 = locala.f;
      str2 = locala.e;
      if (locala.b != null) {
        break label379;
      }
    }
    label365:
    label372:
    label379:
    for (int n = 0;; n = locala.b.size())
    {
      x.c("anr tm:%d\ntr:%s\nproc:%s\nmain stack:%s\nsMsg:%s\n lMsg:%s\n threads:%d", new Object[] { Long.valueOf(paramLong), paramContext, paramProcessErrorStateInfo, paramMap, str1, str2, Integer.valueOf(n) });
      if (this.f.c().i) {
        break label394;
      }
      x.d("ANR Report is closed! print local for helpful!", new Object[0]);
      com.tencent.bugly.crashreport.crash.b.a("ANR", z.a(), locala.a, "main", locala.g, null);
      return false;
      paramContext = "";
      break;
      paramContext = "";
      break label85;
      paramContext = "";
      break label100;
    }
    label394:
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
      com.tencent.bugly.crashreport.crash.b.a("ANR", z.a(), locala.a, "main", locala.g, paramContext);
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
    //   3: invokestatic 548	com/tencent/bugly/crashreport/crash/anr/TraceFileHelper:readTargetDumpInfo	(Ljava/lang/String;Ljava/lang/String;Z)Lcom/tencent/bugly/crashreport/crash/anr/TraceFileHelper$a;
    //   6: astore_3
    //   7: aload_3
    //   8: ifnull +22 -> 30
    //   11: aload_3
    //   12: getfield 552	com/tencent/bugly/crashreport/crash/anr/TraceFileHelper$a:d	Ljava/util/Map;
    //   15: ifnull +15 -> 30
    //   18: aload_3
    //   19: getfield 552	com/tencent/bugly/crashreport/crash/anr/TraceFileHelper$a:d	Ljava/util/Map;
    //   22: invokeinterface 496 1 0
    //   27: ifgt +20 -> 47
    //   30: ldc_w 554
    //   33: iconst_1
    //   34: anewarray 4	java/lang/Object
    //   37: dup
    //   38: iconst_0
    //   39: aload_2
    //   40: aastore
    //   41: invokestatic 506	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   44: pop
    //   45: iconst_0
    //   46: ireturn
    //   47: new 67	java/io/File
    //   50: dup
    //   51: aload_1
    //   52: invokespecial 515	java/io/File:<init>	(Ljava/lang/String;)V
    //   55: astore_2
    //   56: aload_2
    //   57: invokevirtual 518	java/io/File:exists	()Z
    //   60: ifne +26 -> 86
    //   63: aload_2
    //   64: invokevirtual 557	java/io/File:getParentFile	()Ljava/io/File;
    //   67: invokevirtual 518	java/io/File:exists	()Z
    //   70: ifne +11 -> 81
    //   73: aload_2
    //   74: invokevirtual 557	java/io/File:getParentFile	()Ljava/io/File;
    //   77: invokevirtual 560	java/io/File:mkdirs	()Z
    //   80: pop
    //   81: aload_2
    //   82: invokevirtual 563	java/io/File:createNewFile	()Z
    //   85: pop
    //   86: aload_2
    //   87: invokevirtual 518	java/io/File:exists	()Z
    //   90: ifeq +10 -> 100
    //   93: aload_2
    //   94: invokevirtual 566	java/io/File:canWrite	()Z
    //   97: ifne +85 -> 182
    //   100: ldc_w 568
    //   103: iconst_1
    //   104: anewarray 4	java/lang/Object
    //   107: dup
    //   108: iconst_0
    //   109: aload_1
    //   110: aastore
    //   111: invokestatic 506	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   114: pop
    //   115: iconst_0
    //   116: ireturn
    //   117: astore_0
    //   118: aload_0
    //   119: invokestatic 393	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   122: ifne +7 -> 129
    //   125: aload_0
    //   126: invokevirtual 569	java/lang/Exception:printStackTrace	()V
    //   129: ldc_w 571
    //   132: iconst_2
    //   133: anewarray 4	java/lang/Object
    //   136: dup
    //   137: iconst_0
    //   138: new 157	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 572	java/lang/StringBuilder:<init>	()V
    //   145: aload_0
    //   146: invokevirtual 576	java/lang/Object:getClass	()Ljava/lang/Class;
    //   149: invokevirtual 579	java/lang/Class:getName	()Ljava/lang/String;
    //   152: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: ldc_w 581
    //   158: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: aload_0
    //   162: invokevirtual 582	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   165: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: aastore
    //   172: dup
    //   173: iconst_1
    //   174: aload_1
    //   175: aastore
    //   176: invokestatic 506	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   179: pop
    //   180: iconst_0
    //   181: ireturn
    //   182: aconst_null
    //   183: astore_0
    //   184: new 584	java/io/BufferedWriter
    //   187: dup
    //   188: new 586	java/io/FileWriter
    //   191: dup
    //   192: aload_2
    //   193: iconst_0
    //   194: invokespecial 589	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   197: invokespecial 592	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   200: astore_1
    //   201: aload_3
    //   202: getfield 552	com/tencent/bugly/crashreport/crash/anr/TraceFileHelper$a:d	Ljava/util/Map;
    //   205: ldc_w 488
    //   208: invokeinterface 448 2 0
    //   213: checkcast 594	[Ljava/lang/String;
    //   216: astore 4
    //   218: aload 4
    //   220: ifnull +78 -> 298
    //   223: aload 4
    //   225: arraylength
    //   226: iconst_3
    //   227: if_icmplt +71 -> 298
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
    //   247: new 157	java/lang/StringBuilder
    //   250: dup
    //   251: ldc_w 596
    //   254: invokespecial 162	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   257: aload 4
    //   259: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: ldc_w 598
    //   265: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: aload_0
    //   269: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   272: ldc_w 282
    //   275: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: aload_2
    //   279: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: ldc_w 600
    //   285: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   291: invokevirtual 603	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   294: aload_1
    //   295: invokevirtual 606	java/io/BufferedWriter:flush	()V
    //   298: aload_3
    //   299: getfield 552	com/tencent/bugly/crashreport/crash/anr/TraceFileHelper$a:d	Ljava/util/Map;
    //   302: invokeinterface 609 1 0
    //   307: invokeinterface 435 1 0
    //   312: astore_0
    //   313: aload_0
    //   314: invokeinterface 129 1 0
    //   319: ifeq +239 -> 558
    //   322: aload_0
    //   323: invokeinterface 133 1 0
    //   328: checkcast 611	java/util/Map$Entry
    //   331: astore_2
    //   332: aload_2
    //   333: invokeinterface 614 1 0
    //   338: checkcast 284	java/lang/String
    //   341: ldc_w 488
    //   344: invokevirtual 618	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   347: ifne -34 -> 313
    //   350: aload_2
    //   351: invokeinterface 621 1 0
    //   356: ifnull -43 -> 313
    //   359: aload_2
    //   360: invokeinterface 621 1 0
    //   365: checkcast 594	[Ljava/lang/String;
    //   368: arraylength
    //   369: iconst_3
    //   370: if_icmplt -57 -> 313
    //   373: aload_2
    //   374: invokeinterface 621 1 0
    //   379: checkcast 594	[Ljava/lang/String;
    //   382: iconst_0
    //   383: aaload
    //   384: astore_3
    //   385: aload_2
    //   386: invokeinterface 621 1 0
    //   391: checkcast 594	[Ljava/lang/String;
    //   394: iconst_1
    //   395: aaload
    //   396: astore 4
    //   398: aload_2
    //   399: invokeinterface 621 1 0
    //   404: checkcast 594	[Ljava/lang/String;
    //   407: iconst_2
    //   408: aaload
    //   409: astore 5
    //   411: aload_1
    //   412: new 157	java/lang/StringBuilder
    //   415: dup
    //   416: ldc_w 623
    //   419: invokespecial 162	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   422: aload_2
    //   423: invokeinterface 614 1 0
    //   428: checkcast 284	java/lang/String
    //   431: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: ldc_w 625
    //   437: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: aload 5
    //   442: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: ldc_w 598
    //   448: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: aload_3
    //   452: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   455: ldc_w 282
    //   458: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   461: aload 4
    //   463: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   466: ldc_w 600
    //   469: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   472: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   475: invokevirtual 603	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   478: aload_1
    //   479: invokevirtual 606	java/io/BufferedWriter:flush	()V
    //   482: goto -169 -> 313
    //   485: astore_2
    //   486: aload_1
    //   487: astore_0
    //   488: aload_2
    //   489: astore_1
    //   490: aload_1
    //   491: invokestatic 393	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   494: ifne +7 -> 501
    //   497: aload_1
    //   498: invokevirtual 626	java/io/IOException:printStackTrace	()V
    //   501: ldc_w 628
    //   504: iconst_1
    //   505: anewarray 4	java/lang/Object
    //   508: dup
    //   509: iconst_0
    //   510: new 157	java/lang/StringBuilder
    //   513: dup
    //   514: invokespecial 572	java/lang/StringBuilder:<init>	()V
    //   517: aload_1
    //   518: invokevirtual 576	java/lang/Object:getClass	()Ljava/lang/Class;
    //   521: invokevirtual 579	java/lang/Class:getName	()Ljava/lang/String;
    //   524: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   527: ldc_w 581
    //   530: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   533: aload_1
    //   534: invokevirtual 629	java/io/IOException:getMessage	()Ljava/lang/String;
    //   537: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   540: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   543: aastore
    //   544: invokestatic 506	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   547: pop
    //   548: aload_0
    //   549: ifnull +7 -> 556
    //   552: aload_0
    //   553: invokevirtual 632	java/io/BufferedWriter:close	()V
    //   556: iconst_0
    //   557: ireturn
    //   558: aload_1
    //   559: invokevirtual 632	java/io/BufferedWriter:close	()V
    //   562: iconst_1
    //   563: ireturn
    //   564: astore_0
    //   565: aload_0
    //   566: invokestatic 393	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   569: ifne -7 -> 562
    //   572: aload_0
    //   573: invokevirtual 626	java/io/IOException:printStackTrace	()V
    //   576: goto -14 -> 562
    //   579: astore_0
    //   580: aload_0
    //   581: invokestatic 393	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   584: ifne -28 -> 556
    //   587: aload_0
    //   588: invokevirtual 626	java/io/IOException:printStackTrace	()V
    //   591: goto -35 -> 556
    //   594: astore_0
    //   595: aconst_null
    //   596: astore_1
    //   597: aload_1
    //   598: ifnull +7 -> 605
    //   601: aload_1
    //   602: invokevirtual 632	java/io/BufferedWriter:close	()V
    //   605: aload_0
    //   606: athrow
    //   607: astore_1
    //   608: aload_1
    //   609: invokestatic 393	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   612: ifne -7 -> 605
    //   615: aload_1
    //   616: invokevirtual 626	java/io/IOException:printStackTrace	()V
    //   619: goto -14 -> 605
    //   622: astore_0
    //   623: goto -26 -> 597
    //   626: astore_2
    //   627: aload_0
    //   628: astore_1
    //   629: aload_2
    //   630: astore_0
    //   631: goto -34 -> 597
    //   634: astore_1
    //   635: goto -145 -> 490
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	638	0	paramString1	String
    //   0	638	1	paramString2	String
    //   0	638	2	paramString3	String
    //   6	446	3	localObject1	Object
    //   216	246	4	localObject2	Object
    //   409	32	5	str	String
    // Exception table:
    //   from	to	target	type
    //   56	81	117	java/lang/Exception
    //   81	86	117	java/lang/Exception
    //   201	218	485	java/io/IOException
    //   223	230	485	java/io/IOException
    //   246	298	485	java/io/IOException
    //   298	313	485	java/io/IOException
    //   313	482	485	java/io/IOException
    //   558	562	564	java/io/IOException
    //   552	556	579	java/io/IOException
    //   184	201	594	finally
    //   601	605	607	java/io/IOException
    //   201	218	622	finally
    //   223	230	622	finally
    //   246	298	622	finally
    //   298	313	622	finally
    //   313	482	622	finally
    //   490	501	626	finally
    //   501	548	626	finally
    //   184	201	634	java/io/IOException
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
    //   3: invokespecial 646	com/tencent/bugly/crashreport/crash/anr/b:h	()Z
    //   6: ifeq +17 -> 23
    //   9: ldc_w 648
    //   12: iconst_0
    //   13: anewarray 4	java/lang/Object
    //   16: invokestatic 482	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   19: pop
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: aload_0
    //   24: new 650	com/tencent/bugly/crashreport/crash/anr/b$1
    //   27: dup
    //   28: aload_0
    //   29: ldc_w 652
    //   32: bipush 8
    //   34: invokespecial 655	com/tencent/bugly/crashreport/crash/anr/b$1:<init>	(Lcom/tencent/bugly/crashreport/crash/anr/b;Ljava/lang/String;I)V
    //   37: putfield 657	com/tencent/bugly/crashreport/crash/anr/b:i	Landroid/os/FileObserver;
    //   40: aload_0
    //   41: getfield 657	com/tencent/bugly/crashreport/crash/anr/b:i	Landroid/os/FileObserver;
    //   44: invokevirtual 662	android/os/FileObserver:startWatching	()V
    //   47: ldc_w 664
    //   50: iconst_0
    //   51: anewarray 4	java/lang/Object
    //   54: invokestatic 500	com/tencent/bugly/proguard/x:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   57: pop
    //   58: aload_0
    //   59: getfield 77	com/tencent/bugly/crashreport/crash/anr/b:e	Lcom/tencent/bugly/proguard/w;
    //   62: new 666	com/tencent/bugly/crashreport/crash/anr/b$2
    //   65: dup
    //   66: aload_0
    //   67: invokespecial 669	com/tencent/bugly/crashreport/crash/anr/b$2:<init>	(Lcom/tencent/bugly/crashreport/crash/anr/b;)V
    //   70: invokevirtual 674	com/tencent/bugly/proguard/w:a	(Ljava/lang/Runnable;)Z
    //   73: pop
    //   74: goto -54 -> 20
    //   77: astore_1
    //   78: aload_0
    //   79: aconst_null
    //   80: putfield 657	com/tencent/bugly/crashreport/crash/anr/b:i	Landroid/os/FileObserver;
    //   83: ldc_w 676
    //   86: iconst_0
    //   87: anewarray 4	java/lang/Object
    //   90: invokestatic 482	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   93: pop
    //   94: aload_1
    //   95: invokestatic 393	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   98: ifne -78 -> 20
    //   101: aload_1
    //   102: invokevirtual 396	java/lang/Throwable:printStackTrace	()V
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
    //   3: invokespecial 646	com/tencent/bugly/crashreport/crash/anr/b:h	()Z
    //   6: ifne +17 -> 23
    //   9: ldc_w 678
    //   12: iconst_0
    //   13: anewarray 4	java/lang/Object
    //   16: invokestatic 482	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   19: pop
    //   20: aload_0
    //   21: monitorexit
    //   22: return
    //   23: aload_0
    //   24: getfield 657	com/tencent/bugly/crashreport/crash/anr/b:i	Landroid/os/FileObserver;
    //   27: invokevirtual 681	android/os/FileObserver:stopWatching	()V
    //   30: aload_0
    //   31: aconst_null
    //   32: putfield 657	com/tencent/bugly/crashreport/crash/anr/b:i	Landroid/os/FileObserver;
    //   35: ldc_w 683
    //   38: iconst_0
    //   39: anewarray 4	java/lang/Object
    //   42: invokestatic 482	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   45: pop
    //   46: goto -26 -> 20
    //   49: astore_1
    //   50: ldc_w 685
    //   53: iconst_0
    //   54: anewarray 4	java/lang/Object
    //   57: invokestatic 482	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   60: pop
    //   61: aload_1
    //   62: invokestatic 393	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   65: ifne -45 -> 20
    //   68: aload_1
    //   69: invokevirtual 396	java/lang/Throwable:printStackTrace	()V
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
    //   3: getfield 657	com/tencent/bugly/crashreport/crash/anr/b:i	Landroid/os/FileObserver;
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
    //   3: getfield 44	com/tencent/bugly/crashreport/crash/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   6: invokevirtual 687	java/util/concurrent/atomic/AtomicInteger:get	()I
    //   9: ifeq +17 -> 26
    //   12: ldc_w 689
    //   15: iconst_0
    //   16: anewarray 4	java/lang/Object
    //   19: invokestatic 101	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
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
    //   36: ldc_w 691
    //   39: iconst_0
    //   40: anewarray 4	java/lang/Object
    //   43: invokestatic 101	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   46: pop
    //   47: aload_1
    //   48: iconst_0
    //   49: invokestatic 695	com/tencent/bugly/crashreport/crash/anr/TraceFileHelper:readFirstDumpInfo	(Ljava/lang/String;Z)Lcom/tencent/bugly/crashreport/crash/anr/TraceFileHelper$a;
    //   52: astore 6
    //   54: aload 6
    //   56: ifnull +347 -> 403
    //   59: aload 6
    //   61: getfield 696	com/tencent/bugly/crashreport/crash/anr/TraceFileHelper$a:c	J
    //   64: lstore_2
    //   65: lload_2
    //   66: lstore 4
    //   68: lload_2
    //   69: ldc2_w 45
    //   72: lcmp
    //   73: ifne +19 -> 92
    //   76: ldc_w 698
    //   79: iconst_0
    //   80: anewarray 4	java/lang/Object
    //   83: invokestatic 482	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   86: pop
    //   87: invokestatic 703	java/lang/System:currentTimeMillis	()J
    //   90: lstore 4
    //   92: lload 4
    //   94: aload_0
    //   95: getfield 48	com/tencent/bugly/crashreport/crash/anr/b:b	J
    //   98: lsub
    //   99: invokestatic 709	java/lang/Math:abs	(J)J
    //   102: ldc2_w 93
    //   105: lcmp
    //   106: ifge +37 -> 143
    //   109: ldc_w 711
    //   112: iconst_1
    //   113: anewarray 4	java/lang/Object
    //   116: dup
    //   117: iconst_0
    //   118: sipush 10000
    //   121: invokestatic 469	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   124: aastore
    //   125: invokestatic 482	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   128: pop
    //   129: aload_0
    //   130: getfield 44	com/tencent/bugly/crashreport/crash/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   133: iconst_0
    //   134: invokevirtual 521	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   137: return
    //   138: astore_1
    //   139: aload_0
    //   140: monitorexit
    //   141: aload_1
    //   142: athrow
    //   143: aload_0
    //   144: lload 4
    //   146: putfield 48	com/tencent/bugly/crashreport/crash/anr/b:b	J
    //   149: aload_0
    //   150: getfield 44	com/tencent/bugly/crashreport/crash/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   153: iconst_1
    //   154: invokevirtual 521	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   157: getstatic 713	com/tencent/bugly/crashreport/crash/c:f	I
    //   160: iconst_0
    //   161: invokestatic 716	com/tencent/bugly/proguard/z:a	(IZ)Ljava/util/Map;
    //   164: astore 6
    //   166: aload 6
    //   168: ifnull +13 -> 181
    //   171: aload 6
    //   173: invokeinterface 496 1 0
    //   178: ifgt +49 -> 227
    //   181: ldc_w 718
    //   184: iconst_0
    //   185: anewarray 4	java/lang/Object
    //   188: invokestatic 482	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   191: pop
    //   192: aload_0
    //   193: getfield 44	com/tencent/bugly/crashreport/crash/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   196: iconst_0
    //   197: invokevirtual 521	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   200: return
    //   201: astore_1
    //   202: aload_1
    //   203: invokestatic 393	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   206: pop
    //   207: ldc_w 720
    //   210: iconst_0
    //   211: anewarray 4	java/lang/Object
    //   214: invokestatic 506	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   217: pop
    //   218: aload_0
    //   219: getfield 44	com/tencent/bugly/crashreport/crash/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   222: iconst_0
    //   223: invokevirtual 521	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   226: return
    //   227: aload_0
    //   228: aload_0
    //   229: aload_0
    //   230: getfield 57	com/tencent/bugly/crashreport/crash/anr/b:c	Landroid/content/Context;
    //   233: ldc2_w 93
    //   236: invokespecial 722	com/tencent/bugly/crashreport/crash/anr/b:a	(Landroid/content/Context;J)Landroid/app/ActivityManager$ProcessErrorStateInfo;
    //   239: putfield 86	com/tencent/bugly/crashreport/crash/anr/b:m	Landroid/app/ActivityManager$ProcessErrorStateInfo;
    //   242: aload_0
    //   243: getfield 86	com/tencent/bugly/crashreport/crash/anr/b:m	Landroid/app/ActivityManager$ProcessErrorStateInfo;
    //   246: ifnonnull +23 -> 269
    //   249: ldc_w 724
    //   252: iconst_0
    //   253: anewarray 4	java/lang/Object
    //   256: invokestatic 101	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   259: pop
    //   260: aload_0
    //   261: getfield 44	com/tencent/bugly/crashreport/crash/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   264: iconst_0
    //   265: invokevirtual 521	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   268: return
    //   269: aload_0
    //   270: getfield 86	com/tencent/bugly/crashreport/crash/anr/b:m	Landroid/app/ActivityManager$ProcessErrorStateInfo;
    //   273: getfield 155	android/app/ActivityManager$ProcessErrorStateInfo:pid	I
    //   276: invokestatic 152	android/os/Process:myPid	()I
    //   279: if_icmpeq +33 -> 312
    //   282: ldc_w 726
    //   285: iconst_1
    //   286: anewarray 4	java/lang/Object
    //   289: dup
    //   290: iconst_0
    //   291: aload_0
    //   292: getfield 86	com/tencent/bugly/crashreport/crash/anr/b:m	Landroid/app/ActivityManager$ProcessErrorStateInfo;
    //   295: getfield 415	android/app/ActivityManager$ProcessErrorStateInfo:processName	Ljava/lang/String;
    //   298: aastore
    //   299: invokestatic 101	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   302: pop
    //   303: aload_0
    //   304: getfield 44	com/tencent/bugly/crashreport/crash/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   307: iconst_0
    //   308: invokevirtual 521	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   311: return
    //   312: ldc_w 728
    //   315: iconst_0
    //   316: anewarray 4	java/lang/Object
    //   319: invokestatic 500	com/tencent/bugly/proguard/x:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   322: pop
    //   323: aload_0
    //   324: aload_0
    //   325: getfield 57	com/tencent/bugly/crashreport/crash/anr/b:c	Landroid/content/Context;
    //   328: aload_1
    //   329: aload_0
    //   330: getfield 86	com/tencent/bugly/crashreport/crash/anr/b:m	Landroid/app/ActivityManager$ProcessErrorStateInfo;
    //   333: lload 4
    //   335: aload 6
    //   337: invokespecial 730	com/tencent/bugly/crashreport/crash/anr/b:a	(Landroid/content/Context;Ljava/lang/String;Landroid/app/ActivityManager$ProcessErrorStateInfo;JLjava/util/Map;)Z
    //   340: pop
    //   341: aload_0
    //   342: getfield 44	com/tencent/bugly/crashreport/crash/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   345: iconst_0
    //   346: invokevirtual 521	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   349: return
    //   350: astore_1
    //   351: aload_1
    //   352: invokestatic 393	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   355: ifne +7 -> 362
    //   358: aload_1
    //   359: invokevirtual 396	java/lang/Throwable:printStackTrace	()V
    //   362: ldc_w 732
    //   365: iconst_1
    //   366: anewarray 4	java/lang/Object
    //   369: dup
    //   370: iconst_0
    //   371: aload_1
    //   372: invokevirtual 576	java/lang/Object:getClass	()Ljava/lang/Class;
    //   375: invokevirtual 733	java/lang/Class:toString	()Ljava/lang/String;
    //   378: aastore
    //   379: invokestatic 506	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   382: pop
    //   383: aload_0
    //   384: getfield 44	com/tencent/bugly/crashreport/crash/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   387: iconst_0
    //   388: invokevirtual 521	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   391: return
    //   392: astore_1
    //   393: aload_0
    //   394: getfield 44	com/tencent/bugly/crashreport/crash/anr/b:a	Ljava/util/concurrent/atomic/AtomicInteger;
    //   397: iconst_0
    //   398: invokevirtual 521	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   401: aload_1
    //   402: athrow
    //   403: ldc2_w 45
    //   406: lstore_2
    //   407: goto -342 -> 65
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	410	0	this	b
    //   0	410	1	paramString	String
    //   64	343	2	l1	long
    //   66	268	4	l2	long
    //   52	284	6	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	25	138	finally
    //   26	36	138	finally
    //   157	166	201	java/lang/Throwable
    //   36	54	350	java/lang/Throwable
    //   59	65	350	java/lang/Throwable
    //   76	92	350	java/lang/Throwable
    //   92	129	350	java/lang/Throwable
    //   143	157	350	java/lang/Throwable
    //   171	181	350	java/lang/Throwable
    //   181	192	350	java/lang/Throwable
    //   202	218	350	java/lang/Throwable
    //   227	260	350	java/lang/Throwable
    //   269	303	350	java/lang/Throwable
    //   312	341	350	java/lang/Throwable
    //   36	54	392	finally
    //   59	65	392	finally
    //   76	92	392	finally
    //   92	129	392	finally
    //   143	157	392	finally
    //   157	166	392	finally
    //   171	181	392	finally
    //   181	192	392	finally
    //   202	218	392	finally
    //   227	260	392	finally
    //   269	303	392	finally
    //   312	341	392	finally
    //   351	362	392	finally
    //   362	383	392	finally
  }
  
  public final void a(boolean paramBoolean)
  {
    c(paramBoolean);
    boolean bool = i();
    com.tencent.bugly.crashreport.common.strategy.a locala = com.tencent.bugly.crashreport.common.strategy.a.a();
    paramBoolean = bool;
    if (locala != null) {
      if ((!bool) || (!locala.c().f)) {
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
  
  public final boolean a(aa paramaa)
  {
    HashMap localHashMap = new HashMap();
    if (paramaa.e().equals(Looper.getMainLooper())) {}
    for (int n = 1;; n = 0)
    {
      if (n != 0)
      {
        this.m = a(this.c, 10000L);
        if (this.m == null)
        {
          x.c("anr handler onThreadBlock proc state is unvisiable!", new Object[0]);
          return false;
        }
        if (this.m.pid != Process.myPid())
        {
          x.c("onThreadBlock not mind proc!", new Object[] { this.m.processName });
          return false;
        }
      }
      for (;;)
      {
        try
        {
          paramaa = z.a(200000, false);
          x.c("onThreadBlock found visiable anr , start to process!", new Object[0]);
          a(this.c, "", this.m, System.currentTimeMillis(), paramaa);
          return true;
        }
        catch (Throwable paramaa)
        {
          x.b(paramaa);
          localHashMap.put("main", paramaa.getMessage());
          paramaa = localHashMap;
          continue;
        }
        x.c("anr handler onThreadBlock only care main thread ,current thread is: %s", new Object[] { paramaa.d() });
      }
    }
  }
  
  protected final void b()
  {
    int i1 = 0;
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
          int i3 = "bugly_trace_".length();
          int i4 = localObject1.length;
          int n = 0;
          Object localObject2;
          String str;
          int i2;
          for (;;)
          {
            if (n >= i4) {
              break label204;
            }
            localObject2 = localObject1[n];
            str = localObject2.getName();
            boolean bool = str.startsWith("bugly_trace_");
            i2 = i1;
            if (bool) {}
            try
            {
              i2 = str.indexOf(".txt");
              if (i2 <= 0) {
                break;
              }
              long l3 = Long.parseLong(str.substring(i3, i2));
              if (l3 < l1 - l2) {
                break;
              }
              i2 = i1;
            }
            catch (Throwable localThrowable2)
            {
              for (;;)
              {
                x.c("Trace file that has invalid format: " + str, new Object[0]);
                i2 = i1;
                if (localObject2.delete()) {
                  i2 = i1 + 1;
                }
              }
            }
            n += 1;
            i1 = i2;
          }
          label204:
          x.c("Number of overdue trace files that has deleted: " + i1, new Object[0]);
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
    int n = this.l;
    this.l = (n + 1);
    localab.setName(n);
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
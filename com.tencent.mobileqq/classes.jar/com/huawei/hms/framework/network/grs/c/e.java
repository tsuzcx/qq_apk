package com.huawei.hms.framework.network.grs.c;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.b.b;
import com.huawei.hms.framework.network.grs.d.d.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import org.json.JSONArray;

public class e
  implements a
{
  private static final String a = "e";
  private GrsBaseInfo b;
  private Context c;
  private com.huawei.hms.framework.network.grs.a.a d;
  private f e;
  private ArrayList<Future<f>> f = new ArrayList();
  private ArrayList<f> g = new ArrayList();
  private JSONArray h = new JSONArray();
  private ArrayList<String> i = new ArrayList();
  private ArrayList<String> j = new ArrayList();
  private com.huawei.hms.framework.network.grs.c.b.d k;
  private com.huawei.hms.framework.network.grs.c.b.c l;
  private long m = 1L;
  
  public e(com.huawei.hms.framework.network.grs.c.b.c paramc, com.huawei.hms.framework.network.grs.a.a parama)
  {
    this.l = paramc;
    this.b = paramc.b();
    this.c = paramc.a();
    this.d = parama;
    b();
  }
  
  /* Error */
  private f a(ExecutorService paramExecutorService, ArrayList<String> paramArrayList, String paramString, com.huawei.hms.framework.network.grs.a.c paramc)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: iconst_0
    //   4: istore 6
    //   6: aload 9
    //   8: astore 10
    //   10: iload 6
    //   12: aload_2
    //   13: invokevirtual 92	java/util/ArrayList:size	()I
    //   16: if_icmpge +265 -> 281
    //   19: aload_2
    //   20: iload 6
    //   22: invokevirtual 96	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   25: checkcast 98	java/lang/String
    //   28: astore 10
    //   30: aload 10
    //   32: invokestatic 104	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   35: istore 8
    //   37: iconst_1
    //   38: istore 7
    //   40: iconst_1
    //   41: istore 5
    //   43: iload 8
    //   45: ifne +204 -> 249
    //   48: aload_1
    //   49: new 106	com/huawei/hms/framework/network/grs/c/b
    //   52: dup
    //   53: aload 10
    //   55: iload 6
    //   57: aload_0
    //   58: aload_0
    //   59: getfield 70	com/huawei/hms/framework/network/grs/c/e:c	Landroid/content/Context;
    //   62: aload_3
    //   63: aload_0
    //   64: getfield 65	com/huawei/hms/framework/network/grs/c/e:b	Lcom/huawei/hms/framework/network/grs/GrsBaseInfo;
    //   67: aload 4
    //   69: invokespecial 109	com/huawei/hms/framework/network/grs/c/b:<init>	(Ljava/lang/String;ILcom/huawei/hms/framework/network/grs/c/a;Landroid/content/Context;Ljava/lang/String;Lcom/huawei/hms/framework/network/grs/GrsBaseInfo;Lcom/huawei/hms/framework/network/grs/a/c;)V
    //   72: invokevirtual 112	com/huawei/hms/framework/network/grs/c/b:g	()Ljava/util/concurrent/Callable;
    //   75: invokeinterface 118 2 0
    //   80: astore 10
    //   82: aload_0
    //   83: getfield 43	com/huawei/hms/framework/network/grs/c/e:f	Ljava/util/ArrayList;
    //   86: aload 10
    //   88: invokevirtual 122	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   91: pop
    //   92: aload 10
    //   94: aload_0
    //   95: getfield 56	com/huawei/hms/framework/network/grs/c/e:m	J
    //   98: getstatic 128	java/util/concurrent/TimeUnit:SECONDS	Ljava/util/concurrent/TimeUnit;
    //   101: invokeinterface 133 4 0
    //   106: checkcast 135	com/huawei/hms/framework/network/grs/c/f
    //   109: astore 10
    //   111: aload 10
    //   113: ifnull +66 -> 179
    //   116: aload 10
    //   118: invokevirtual 138	com/huawei/hms/framework/network/grs/c/f:m	()Z
    //   121: ifeq +58 -> 179
    //   124: getstatic 140	com/huawei/hms/framework/network/grs/c/e:a	Ljava/lang/String;
    //   127: astore 9
    //   129: aload 9
    //   131: ldc 142
    //   133: invokestatic 147	com/huawei/hms/framework/common/Logger:i	(Ljava/lang/String;Ljava/lang/Object;)V
    //   136: goto +46 -> 182
    //   139: aload 10
    //   141: astore 9
    //   143: goto +46 -> 189
    //   146: astore 11
    //   148: aload 10
    //   150: astore 9
    //   152: aload 11
    //   154: astore 10
    //   156: goto +46 -> 202
    //   159: astore 11
    //   161: aload 10
    //   163: astore 9
    //   165: aload 11
    //   167: astore 10
    //   169: goto +52 -> 221
    //   172: aload 10
    //   174: astore 9
    //   176: goto +58 -> 234
    //   179: iconst_0
    //   180: istore 5
    //   182: aload 10
    //   184: astore 9
    //   186: goto +66 -> 252
    //   189: getstatic 140	com/huawei/hms/framework/network/grs/c/e:a	Ljava/lang/String;
    //   192: ldc 149
    //   194: invokestatic 152	com/huawei/hms/framework/common/Logger:w	(Ljava/lang/String;Ljava/lang/Object;)V
    //   197: goto +52 -> 249
    //   200: astore 10
    //   202: getstatic 140	com/huawei/hms/framework/network/grs/c/e:a	Ljava/lang/String;
    //   205: ldc 154
    //   207: aload 10
    //   209: invokestatic 157	com/huawei/hms/framework/common/Logger:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   212: iload 7
    //   214: istore 5
    //   216: goto +36 -> 252
    //   219: astore 10
    //   221: getstatic 140	com/huawei/hms/framework/network/grs/c/e:a	Ljava/lang/String;
    //   224: ldc 159
    //   226: aload 10
    //   228: invokestatic 157	com/huawei/hms/framework/common/Logger:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   231: goto +18 -> 249
    //   234: getstatic 140	com/huawei/hms/framework/network/grs/c/e:a	Ljava/lang/String;
    //   237: ldc 161
    //   239: invokestatic 147	com/huawei/hms/framework/common/Logger:i	(Ljava/lang/String;Ljava/lang/Object;)V
    //   242: iload 7
    //   244: istore 5
    //   246: goto +6 -> 252
    //   249: iconst_0
    //   250: istore 5
    //   252: iload 5
    //   254: ifeq +18 -> 272
    //   257: getstatic 140	com/huawei/hms/framework/network/grs/c/e:a	Ljava/lang/String;
    //   260: ldc 163
    //   262: invokestatic 166	com/huawei/hms/framework/common/Logger:v	(Ljava/lang/String;Ljava/lang/Object;)V
    //   265: aload 9
    //   267: astore 10
    //   269: goto +12 -> 281
    //   272: iload 6
    //   274: iconst_1
    //   275: iadd
    //   276: istore 6
    //   278: goto -272 -> 6
    //   281: aload_0
    //   282: aload 10
    //   284: invokespecial 169	com/huawei/hms/framework/network/grs/c/e:b	(Lcom/huawei/hms/framework/network/grs/c/f;)Lcom/huawei/hms/framework/network/grs/c/f;
    //   287: areturn
    //   288: astore 10
    //   290: goto -56 -> 234
    //   293: astore 10
    //   295: goto -106 -> 189
    //   298: astore 9
    //   300: goto -128 -> 172
    //   303: astore 9
    //   305: goto -166 -> 139
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	308	0	this	e
    //   0	308	1	paramExecutorService	ExecutorService
    //   0	308	2	paramArrayList	ArrayList<String>
    //   0	308	3	paramString	String
    //   0	308	4	paramc	com.huawei.hms.framework.network.grs.a.c
    //   41	212	5	n	int
    //   4	273	6	i1	int
    //   38	205	7	i2	int
    //   35	9	8	bool	boolean
    //   1	265	9	localObject1	Object
    //   298	1	9	localCancellationException1	java.util.concurrent.CancellationException
    //   303	1	9	localTimeoutException1	java.util.concurrent.TimeoutException
    //   8	175	10	localObject2	Object
    //   200	8	10	localInterruptedException1	java.lang.InterruptedException
    //   219	8	10	localExecutionException1	java.util.concurrent.ExecutionException
    //   267	16	10	localObject3	Object
    //   288	1	10	localCancellationException2	java.util.concurrent.CancellationException
    //   293	1	10	localTimeoutException2	java.util.concurrent.TimeoutException
    //   146	7	11	localInterruptedException2	java.lang.InterruptedException
    //   159	7	11	localExecutionException2	java.util.concurrent.ExecutionException
    // Exception table:
    //   from	to	target	type
    //   116	129	146	java/lang/InterruptedException
    //   129	136	146	java/lang/InterruptedException
    //   116	129	159	java/util/concurrent/ExecutionException
    //   129	136	159	java/util/concurrent/ExecutionException
    //   92	111	200	java/lang/InterruptedException
    //   92	111	219	java/util/concurrent/ExecutionException
    //   92	111	288	java/util/concurrent/CancellationException
    //   92	111	293	java/util/concurrent/TimeoutException
    //   116	129	298	java/util/concurrent/CancellationException
    //   129	136	298	java/util/concurrent/CancellationException
    //   116	129	303	java/util/concurrent/TimeoutException
    //   129	136	303	java/util/concurrent/TimeoutException
  }
  
  /* Error */
  private f b(f paramf)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 43	com/huawei/hms/framework/network/grs/c/e:f	Ljava/util/ArrayList;
    //   4: invokevirtual 92	java/util/ArrayList:size	()I
    //   7: istore_3
    //   8: iconst_0
    //   9: istore_2
    //   10: iload_2
    //   11: iload_3
    //   12: if_icmpge +159 -> 171
    //   15: aload_1
    //   16: ifnull +10 -> 26
    //   19: aload_1
    //   20: invokevirtual 138	com/huawei/hms/framework/network/grs/c/f:m	()Z
    //   23: ifne +148 -> 171
    //   26: aload_0
    //   27: getfield 43	com/huawei/hms/framework/network/grs/c/e:f	Ljava/util/ArrayList;
    //   30: iload_2
    //   31: invokevirtual 96	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   34: checkcast 130	java/util/concurrent/Future
    //   37: ldc2_w 172
    //   40: getstatic 176	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   43: invokeinterface 133 4 0
    //   48: checkcast 135	com/huawei/hms/framework/network/grs/c/f
    //   51: astore 4
    //   53: goto +108 -> 161
    //   56: getstatic 140	com/huawei/hms/framework/network/grs/c/e:a	Ljava/lang/String;
    //   59: ldc 178
    //   61: invokestatic 152	com/huawei/hms/framework/common/Logger:w	(Ljava/lang/String;Ljava/lang/Object;)V
    //   64: aload_1
    //   65: astore 4
    //   67: aload_0
    //   68: getfield 43	com/huawei/hms/framework/network/grs/c/e:f	Ljava/util/ArrayList;
    //   71: iload_2
    //   72: invokevirtual 96	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   75: checkcast 130	java/util/concurrent/Future
    //   78: invokeinterface 181 1 0
    //   83: ifne +78 -> 161
    //   86: aload_0
    //   87: getfield 43	com/huawei/hms/framework/network/grs/c/e:f	Ljava/util/ArrayList;
    //   90: iload_2
    //   91: invokevirtual 96	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   94: checkcast 130	java/util/concurrent/Future
    //   97: iconst_1
    //   98: invokeinterface 185 2 0
    //   103: pop
    //   104: aload_1
    //   105: astore 4
    //   107: goto +54 -> 161
    //   110: astore 4
    //   112: getstatic 140	com/huawei/hms/framework/network/grs/c/e:a	Ljava/lang/String;
    //   115: astore 5
    //   117: ldc 187
    //   119: astore 6
    //   121: goto +14 -> 135
    //   124: astore 4
    //   126: getstatic 140	com/huawei/hms/framework/network/grs/c/e:a	Ljava/lang/String;
    //   129: astore 5
    //   131: ldc 189
    //   133: astore 6
    //   135: aload 5
    //   137: aload 6
    //   139: aload 4
    //   141: invokestatic 157	com/huawei/hms/framework/common/Logger:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   144: aload_1
    //   145: astore 4
    //   147: goto +14 -> 161
    //   150: getstatic 140	com/huawei/hms/framework/network/grs/c/e:a	Ljava/lang/String;
    //   153: ldc 191
    //   155: invokestatic 147	com/huawei/hms/framework/common/Logger:i	(Ljava/lang/String;Ljava/lang/Object;)V
    //   158: aload_1
    //   159: astore 4
    //   161: iload_2
    //   162: iconst_1
    //   163: iadd
    //   164: istore_2
    //   165: aload 4
    //   167: astore_1
    //   168: goto -158 -> 10
    //   171: aload_1
    //   172: areturn
    //   173: astore 4
    //   175: goto -25 -> 150
    //   178: astore 4
    //   180: goto -124 -> 56
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	183	0	this	e
    //   0	183	1	paramf	f
    //   9	156	2	n	int
    //   7	6	3	i1	int
    //   51	55	4	localf1	f
    //   110	1	4	localInterruptedException	java.lang.InterruptedException
    //   124	16	4	localExecutionException	java.util.concurrent.ExecutionException
    //   145	21	4	localf2	f
    //   173	1	4	localCancellationException	java.util.concurrent.CancellationException
    //   178	1	4	localTimeoutException	java.util.concurrent.TimeoutException
    //   115	21	5	str1	String
    //   119	19	6	str2	String
    // Exception table:
    //   from	to	target	type
    //   26	53	110	java/lang/InterruptedException
    //   26	53	124	java/util/concurrent/ExecutionException
    //   26	53	173	java/util/concurrent/CancellationException
    //   26	53	178	java/util/concurrent/TimeoutException
  }
  
  private f b(ExecutorService paramExecutorService, String paramString, com.huawei.hms.framework.network.grs.a.c paramc)
  {
    long l1 = SystemClock.elapsedRealtime();
    f localf = a(paramExecutorService, this.j, paramString, paramc);
    int n;
    if (localf == null) {
      n = 0;
    } else {
      n = localf.b();
    }
    Logger.v(a, "use 2.0 interface return http's code is：{%s}", new Object[] { Integer.valueOf(n) });
    if ((n == 404) || (n == 401))
    {
      if ((TextUtils.isEmpty(c())) && (TextUtils.isEmpty(this.b.getAppName())))
      {
        Logger.i(a, "request grs server use 1.0 API must set appName,please check.");
        return null;
      }
      this.f.clear();
      Logger.i(a, "this env has not deploy new interface,so use old interface.");
      localf = a(paramExecutorService, this.i, paramString, paramc);
    }
    long l2 = SystemClock.elapsedRealtime();
    h.a(new ArrayList(this.g), l2 - l1, this.h, this.c);
    return localf;
  }
  
  private void b()
  {
    Object localObject2 = com.huawei.hms.framework.network.grs.c.a.a.a(this.c);
    if (localObject2 == null)
    {
      Logger.w(a, "g*s***_se****er_conf*** maybe has a big error");
      return;
    }
    a((com.huawei.hms.framework.network.grs.c.b.d)localObject2);
    Object localObject1 = ((com.huawei.hms.framework.network.grs.c.b.d)localObject2).a();
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      if (((List)localObject1).size() <= 10)
      {
        String str1 = ((com.huawei.hms.framework.network.grs.c.b.d)localObject2).c();
        localObject2 = ((com.huawei.hms.framework.network.grs.c.b.d)localObject2).b();
        if (((List)localObject1).size() > 0)
        {
          Iterator localIterator = ((List)localObject1).iterator();
          while (localIterator.hasNext())
          {
            String str2 = (String)localIterator.next();
            if (!str2.startsWith("https://"))
            {
              Logger.w(a, "grs server just support https scheme url,please check.");
            }
            else
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append(str2);
              Locale localLocale = Locale.ROOT;
              if (TextUtils.isEmpty(c())) {
                localObject1 = this.b.getAppName();
              } else {
                localObject1 = c();
              }
              localStringBuilder.append(String.format(localLocale, str1, new Object[] { localObject1 }));
              localObject1 = this.b.getGrsReqParamJoint(false, false, "1.0", this.c);
              if (!TextUtils.isEmpty((CharSequence)localObject1))
              {
                localStringBuilder.append("?");
                localStringBuilder.append((String)localObject1);
              }
              localObject1 = localStringBuilder.toString();
              this.i.add(localObject1);
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(str2);
              ((StringBuilder)localObject1).append((String)localObject2);
              str2 = this.b.getGrsReqParamJoint(false, false, c(), this.c);
              if (!TextUtils.isEmpty(str2))
              {
                ((StringBuilder)localObject1).append("?");
                ((StringBuilder)localObject1).append(str2);
              }
              this.j.add(((StringBuilder)localObject1).toString());
            }
          }
        }
        Logger.v(a, "request to GRS server url is{%s} and {%s}", new Object[] { this.i, this.j });
        return;
      }
      throw new IllegalArgumentException("grs_base_url's count is larger than MAX value 10");
    }
    Logger.v(a, "maybe grs_base_url config with [],please check.");
  }
  
  private String c()
  {
    Object localObject = b.a(this.c.getPackageName(), this.b);
    if (localObject != null) {
      localObject = ((b)localObject).a();
    } else {
      localObject = null;
    }
    if (localObject != null)
    {
      localObject = ((com.huawei.hms.framework.network.grs.local.model.a)localObject).b();
      Logger.v(a, "get appName from local assets is{%s}", new Object[] { localObject });
      return localObject;
    }
    return "";
  }
  
  public com.huawei.hms.framework.network.grs.c.b.d a()
  {
    return this.k;
  }
  
  /* Error */
  public f a(ExecutorService paramExecutorService, String paramString, com.huawei.hms.framework.network.grs.a.c paramc)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 52	com/huawei/hms/framework/network/grs/c/e:i	Ljava/util/ArrayList;
    //   4: ifnull +132 -> 136
    //   7: aload_0
    //   8: getfield 54	com/huawei/hms/framework/network/grs/c/e:j	Ljava/util/ArrayList;
    //   11: ifnonnull +5 -> 16
    //   14: aconst_null
    //   15: areturn
    //   16: aload_0
    //   17: invokevirtual 343	com/huawei/hms/framework/network/grs/c/e:a	()Lcom/huawei/hms/framework/network/grs/c/b/d;
    //   20: astore 5
    //   22: aload 5
    //   24: ifnull +122 -> 146
    //   27: aload 5
    //   29: invokevirtual 345	com/huawei/hms/framework/network/grs/c/b/d:d	()I
    //   32: istore 4
    //   34: goto +3 -> 37
    //   37: aload_1
    //   38: new 347	com/huawei/hms/framework/network/grs/c/d
    //   41: dup
    //   42: aload_0
    //   43: aload_1
    //   44: aload_2
    //   45: aload_3
    //   46: invokespecial 350	com/huawei/hms/framework/network/grs/c/d:<init>	(Lcom/huawei/hms/framework/network/grs/c/e;Ljava/util/concurrent/ExecutorService;Ljava/lang/String;Lcom/huawei/hms/framework/network/grs/a/c;)V
    //   49: invokeinterface 118 2 0
    //   54: iload 4
    //   56: i2l
    //   57: getstatic 128	java/util/concurrent/TimeUnit:SECONDS	Ljava/util/concurrent/TimeUnit;
    //   60: invokeinterface 133 4 0
    //   65: checkcast 135	com/huawei/hms/framework/network/grs/c/f
    //   68: astore_1
    //   69: aload_1
    //   70: areturn
    //   71: astore_1
    //   72: getstatic 140	com/huawei/hms/framework/network/grs/c/e:a	Ljava/lang/String;
    //   75: astore_2
    //   76: ldc_w 352
    //   79: astore_3
    //   80: goto +36 -> 116
    //   83: getstatic 140	com/huawei/hms/framework/network/grs/c/e:a	Ljava/lang/String;
    //   86: ldc_w 354
    //   89: invokestatic 152	com/huawei/hms/framework/common/Logger:w	(Ljava/lang/String;Ljava/lang/Object;)V
    //   92: goto +42 -> 134
    //   95: astore_1
    //   96: getstatic 140	com/huawei/hms/framework/network/grs/c/e:a	Ljava/lang/String;
    //   99: astore_2
    //   100: ldc_w 356
    //   103: astore_3
    //   104: goto +12 -> 116
    //   107: astore_1
    //   108: getstatic 140	com/huawei/hms/framework/network/grs/c/e:a	Ljava/lang/String;
    //   111: astore_2
    //   112: ldc_w 358
    //   115: astore_3
    //   116: aload_2
    //   117: aload_3
    //   118: aload_1
    //   119: invokestatic 157	com/huawei/hms/framework/common/Logger:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   122: goto +12 -> 134
    //   125: getstatic 140	com/huawei/hms/framework/network/grs/c/e:a	Ljava/lang/String;
    //   128: ldc_w 360
    //   131: invokestatic 147	com/huawei/hms/framework/common/Logger:i	(Ljava/lang/String;Ljava/lang/Object;)V
    //   134: aconst_null
    //   135: areturn
    //   136: aconst_null
    //   137: areturn
    //   138: astore_1
    //   139: goto -14 -> 125
    //   142: astore_1
    //   143: goto -60 -> 83
    //   146: bipush 10
    //   148: istore 4
    //   150: goto -113 -> 37
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	this	e
    //   0	153	1	paramExecutorService	ExecutorService
    //   0	153	2	paramString	String
    //   0	153	3	paramc	com.huawei.hms.framework.network.grs.a.c
    //   32	117	4	n	int
    //   20	8	5	locald	com.huawei.hms.framework.network.grs.c.b.d
    // Exception table:
    //   from	to	target	type
    //   16	22	71	java/lang/Exception
    //   27	34	71	java/lang/Exception
    //   37	69	71	java/lang/Exception
    //   16	22	95	java/lang/InterruptedException
    //   27	34	95	java/lang/InterruptedException
    //   37	69	95	java/lang/InterruptedException
    //   16	22	107	java/util/concurrent/ExecutionException
    //   27	34	107	java/util/concurrent/ExecutionException
    //   37	69	107	java/util/concurrent/ExecutionException
    //   16	22	138	java/util/concurrent/CancellationException
    //   27	34	138	java/util/concurrent/CancellationException
    //   37	69	138	java/util/concurrent/CancellationException
    //   16	22	142	java/util/concurrent/TimeoutException
    //   27	34	142	java/util/concurrent/TimeoutException
    //   37	69	142	java/util/concurrent/TimeoutException
  }
  
  public void a(com.huawei.hms.framework.network.grs.c.b.d paramd)
  {
    this.k = paramd;
  }
  
  public void a(f paramf)
  {
    try
    {
      this.g.add(paramf);
      f localf = this.e;
      if ((localf != null) && (localf.m()))
      {
        Logger.v(a, "grsResponseResult is ok");
        return;
      }
      boolean bool = paramf.l();
      int n = 0;
      if (bool)
      {
        Logger.i(a, "GRS server open 503 limiting strategy.");
        com.huawei.hms.framework.network.grs.d.d.a(this.b.getGrsParasKey(false, true, this.c), new d.a(paramf.j(), SystemClock.elapsedRealtime()));
        return;
      }
      if (!paramf.m())
      {
        Logger.v(a, "grsResponseResult has exception so need return");
        return;
      }
      this.e = paramf;
      this.d.a(this.b, this.e, this.c, this.l);
      while (n < this.f.size())
      {
        if ((!((String)this.i.get(n)).equals(paramf.k())) && (!((String)this.j.get(n)).equals(paramf.k())) && (!((Future)this.f.get(n)).isCancelled()))
        {
          Logger.i(a, "future cancel");
          ((Future)this.f.get(n)).cancel(true);
        }
        n += 1;
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramf;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.framework.network.grs.c.e
 * JD-Core Version:    0.7.0.1
 */
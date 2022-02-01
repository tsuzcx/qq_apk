package com.tencent.luggage.wxa.rt;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Environment;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.os.Process;
import android.util.Pair;
import com.tencent.luggage.wxa.ry.b;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public final class e
  implements Handler.Callback
{
  @SuppressLint({"StaticFieldLeak"})
  private static volatile Context a;
  private static volatile e.a b;
  private static volatile boolean c = true;
  private final Context d = a;
  private final Object e = new Object();
  private g f;
  private int g;
  private e.d h;
  private final g i;
  private final File j;
  private final HandlerThread k;
  private final e.b l;
  private final Handler m;
  private volatile long n;
  private volatile long o;
  private volatile boolean p;
  private volatile e.c q;
  private volatile boolean r;
  private volatile BroadcastReceiver s;
  
  private e()
  {
    Object localObject = this.d;
    if (localObject != null)
    {
      File localFile = ((Context)localObject).getFilesDir().getParentFile();
      localObject = localFile;
      if (localFile == null) {
        localObject = this.d.getCacheDir();
      }
      this.j = new File((File)localObject, ".vfs");
      this.k = new HandlerThread("VFS.Maintenance", 4);
      this.k.start();
      this.m = new Handler(this.k.getLooper(), this);
      this.l = new e.b(this, null);
      this.n = -1L;
      this.o = 9223372036854775807L;
      this.r = true;
      this.i = b(this.d);
      this.f = this.i;
      this.g = 0;
      this.h = new e.d(null, null, this.g, null);
      return;
    }
    throw new IllegalStateException("Call FileSystemManager.setContext(Context) before calling instance()");
  }
  
  public static e a()
  {
    return e.e.a;
  }
  
  public static void a(Context paramContext)
  {
    Context localContext = paramContext.getApplicationContext();
    if (localContext != null) {
      paramContext = localContext;
    }
    a = paramContext;
  }
  
  private void a(Bundle paramBundle)
  {
    ??? = paramBundle;
    if (paramBundle == null) {
      ??? = new Bundle();
    }
    if (((Bundle)???).getInt("pid") == Process.myPid())
    {
      b.e("VFS.FileSystemManager", "Ignore filesystem change broadcast from the same process.");
      return;
    }
    paramBundle = g.a((Bundle)???);
    Map localMap = paramBundle.a();
    synchronized (this.e)
    {
      this.f = paramBundle;
      this.g += 1;
      this.h = new e.d(null, null, this.g, null);
      paramBundle.f.a(localMap);
      Iterator localIterator = paramBundle.a.values().iterator();
      while (localIterator.hasNext()) {
        ((h)localIterator.next()).a(localMap);
      }
      localIterator = paramBundle.b.values().iterator();
      while (localIterator.hasNext()) {
        ((d)localIterator.next()).a(localMap);
      }
      ??? = new StringBuilder(2048);
      ((StringBuilder)???).append("[Schemes]\n");
      a(paramBundle.a, (StringBuilder)???);
      ((StringBuilder)???).append("[File systems]\n");
      a(paramBundle.b, (StringBuilder)???);
      ((StringBuilder)???).append("[Mount points]\n");
      a(paramBundle.c, (StringBuilder)???);
      ((StringBuilder)???).append("[Environment]\n");
      a(paramBundle.e, (StringBuilder)???);
      ((StringBuilder)???).append("[Root]\n  ");
      ((StringBuilder)???).append(paramBundle.f.toString());
      ((StringBuilder)???).append('\n');
      paramBundle = new StringBuilder();
      paramBundle.append("Loaded file system from bundle:\n");
      paramBundle.append(((StringBuilder)???).toString());
      b.c("VFS.FileSystemManager", paramBundle.toString());
      return;
    }
    for (;;)
    {
      throw paramBundle;
    }
  }
  
  private static <K, V> void a(Map<K, V> paramMap, StringBuilder paramStringBuilder)
  {
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      paramStringBuilder.append("  ");
      paramStringBuilder.append(localEntry.getKey());
      if (localEntry.getValue() == null)
      {
        paramStringBuilder.append(" (deleted)\n");
      }
      else
      {
        paramStringBuilder.append(" => ");
        paramStringBuilder.append(localEntry.getValue().toString());
        paramStringBuilder.append('\n');
      }
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    c = paramBoolean;
  }
  
  private static g b(Context paramContext)
  {
    HashMap localHashMap1 = new HashMap();
    localHashMap1.put(null, c.a());
    localHashMap1.put("", c.a());
    localHashMap1.put("file", c.a());
    localHashMap1.put("wcf", p.a());
    HashMap localHashMap2 = new HashMap();
    localHashMap2.put("data", paramContext.getCacheDir().getParent());
    localHashMap2.put("dataCache", paramContext.getCacheDir().getPath());
    paramContext = paramContext.getExternalCacheDir();
    if (paramContext != null)
    {
      localHashMap2.put("extData", paramContext.getParent());
      localHashMap2.put("extCache", paramContext.getPath());
    }
    paramContext = Environment.getExternalStorageDirectory();
    if (paramContext != null) {
      localHashMap2.put("storage", paramContext.getPath());
    }
    return new g().a(localHashMap1, Collections.emptyMap(), new TreeMap(), localHashMap2, null);
  }
  
  /* Error */
  private void b(CancellationSignal paramCancellationSignal)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 114	com/tencent/luggage/wxa/rt/e:o	J
    //   4: lstore_2
    //   5: new 63	java/io/File
    //   8: dup
    //   9: aload_0
    //   10: getfield 76	com/tencent/luggage/wxa/rt/e:j	Ljava/io/File;
    //   13: ldc_w 360
    //   16: invokespecial 74	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   19: astore 10
    //   21: invokestatic 366	java/lang/System:currentTimeMillis	()J
    //   24: lstore 4
    //   26: aload 10
    //   28: invokevirtual 369	java/io/File:lastModified	()J
    //   31: lstore 6
    //   33: lload 4
    //   35: lload 6
    //   37: lsub
    //   38: lload_2
    //   39: lcmp
    //   40: ifge +39 -> 79
    //   43: ldc 171
    //   45: ldc_w 371
    //   48: iconst_3
    //   49: anewarray 4	java/lang/Object
    //   52: dup
    //   53: iconst_0
    //   54: lload 4
    //   56: invokestatic 377	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   59: aastore
    //   60: dup
    //   61: iconst_1
    //   62: lload 6
    //   64: invokestatic 377	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   67: aastore
    //   68: dup
    //   69: iconst_2
    //   70: lload_2
    //   71: invokestatic 377	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   74: aastore
    //   75: invokestatic 380	com/tencent/luggage/wxa/ry/b:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   78: return
    //   79: aload_0
    //   80: getfield 382	com/tencent/luggage/wxa/rt/e:p	Z
    //   83: istore 9
    //   85: iload 9
    //   87: istore 8
    //   89: iload 9
    //   91: ifeq +25 -> 116
    //   94: aload_0
    //   95: getfield 55	com/tencent/luggage/wxa/rt/e:d	Landroid/content/Context;
    //   98: ldc_w 384
    //   101: invokevirtual 387	android/content/Context:checkCallingOrSelfPermission	(Ljava/lang/String;)I
    //   104: ifne +9 -> 113
    //   107: iconst_1
    //   108: istore 8
    //   110: goto +6 -> 116
    //   113: iconst_0
    //   114: istore 8
    //   116: aconst_null
    //   117: astore 10
    //   119: iload 8
    //   121: ifeq +25 -> 146
    //   124: aload_0
    //   125: getfield 55	com/tencent/luggage/wxa/rt/e:d	Landroid/content/Context;
    //   128: ldc_w 389
    //   131: invokevirtual 393	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   134: checkcast 395	android/os/PowerManager
    //   137: iconst_1
    //   138: ldc_w 397
    //   141: invokevirtual 401	android/os/PowerManager:newWakeLock	(ILjava/lang/String;)Landroid/os/PowerManager$WakeLock;
    //   144: astore 10
    //   146: aload_0
    //   147: getfield 403	com/tencent/luggage/wxa/rt/e:q	Lcom/tencent/luggage/wxa/rt/e$c;
    //   150: astore 11
    //   152: new 226	java/lang/StringBuilder
    //   155: dup
    //   156: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   159: astore 12
    //   161: aload 12
    //   163: ldc_w 405
    //   166: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: pop
    //   170: aload 12
    //   172: iload 8
    //   174: invokevirtual 408	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   177: pop
    //   178: ldc 171
    //   180: aload 12
    //   182: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: invokestatic 264	com/tencent/luggage/wxa/ry/b:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   188: aload 11
    //   190: ifnull +10 -> 200
    //   193: aload 11
    //   195: invokeinterface 412 1 0
    //   200: aload 10
    //   202: ifnull +11 -> 213
    //   205: aload 10
    //   207: ldc2_w 413
    //   210: invokevirtual 420	android/os/PowerManager$WakeLock:acquire	(J)V
    //   213: aload_0
    //   214: aload_1
    //   215: invokevirtual 422	com/tencent/luggage/wxa/rt/e:a	(Landroid/os/CancellationSignal;)V
    //   218: ldc 171
    //   220: ldc_w 424
    //   223: invokestatic 264	com/tencent/luggage/wxa/ry/b:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   226: aload 10
    //   228: ifnull +16 -> 244
    //   231: aload 10
    //   233: invokevirtual 427	android/os/PowerManager$WakeLock:isHeld	()Z
    //   236: ifeq +8 -> 244
    //   239: aload 10
    //   241: invokevirtual 430	android/os/PowerManager$WakeLock:release	()V
    //   244: aload 11
    //   246: ifnull +100 -> 346
    //   249: aload 11
    //   251: iconst_0
    //   252: iconst_0
    //   253: invokeinterface 433 3 0
    //   258: return
    //   259: astore_1
    //   260: goto +87 -> 347
    //   263: astore_1
    //   264: ldc 171
    //   266: aload_1
    //   267: ldc_w 435
    //   270: invokestatic 438	com/tencent/luggage/wxa/ry/b:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;)V
    //   273: aload 10
    //   275: ifnull +16 -> 291
    //   278: aload 10
    //   280: invokevirtual 427	android/os/PowerManager$WakeLock:isHeld	()Z
    //   283: ifeq +8 -> 291
    //   286: aload 10
    //   288: invokevirtual 430	android/os/PowerManager$WakeLock:release	()V
    //   291: aload 11
    //   293: ifnull +53 -> 346
    //   296: aload 11
    //   298: iconst_0
    //   299: iconst_1
    //   300: invokeinterface 433 3 0
    //   305: return
    //   306: ldc 171
    //   308: ldc_w 440
    //   311: invokestatic 264	com/tencent/luggage/wxa/ry/b:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   314: aload 10
    //   316: ifnull +16 -> 332
    //   319: aload 10
    //   321: invokevirtual 427	android/os/PowerManager$WakeLock:isHeld	()Z
    //   324: ifeq +8 -> 332
    //   327: aload 10
    //   329: invokevirtual 430	android/os/PowerManager$WakeLock:release	()V
    //   332: aload 11
    //   334: ifnull +12 -> 346
    //   337: aload 11
    //   339: iconst_1
    //   340: iconst_0
    //   341: invokeinterface 433 3 0
    //   346: return
    //   347: aload 10
    //   349: ifnull +16 -> 365
    //   352: aload 10
    //   354: invokevirtual 427	android/os/PowerManager$WakeLock:isHeld	()Z
    //   357: ifeq +8 -> 365
    //   360: aload 10
    //   362: invokevirtual 430	android/os/PowerManager$WakeLock:release	()V
    //   365: aload 11
    //   367: ifnull +12 -> 379
    //   370: aload 11
    //   372: iconst_0
    //   373: iconst_0
    //   374: invokeinterface 433 3 0
    //   379: aload_1
    //   380: athrow
    //   381: astore_1
    //   382: goto -76 -> 306
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	385	0	this	e
    //   0	385	1	paramCancellationSignal	CancellationSignal
    //   4	67	2	l1	long
    //   24	31	4	l2	long
    //   31	32	6	l3	long
    //   87	86	8	bool1	boolean
    //   83	7	9	bool2	boolean
    //   19	342	10	localObject	Object
    //   150	221	11	localc	e.c
    //   159	22	12	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   152	188	259	finally
    //   193	200	259	finally
    //   205	213	259	finally
    //   213	226	259	finally
    //   264	273	259	finally
    //   306	314	259	finally
    //   152	188	263	java/lang/Exception
    //   193	200	263	java/lang/Exception
    //   205	213	263	java/lang/Exception
    //   213	226	263	java/lang/Exception
    //   152	188	381	android/os/OperationCanceledException
    //   193	200	381	android/os/OperationCanceledException
    //   205	213	381	android/os/OperationCanceledException
    //   213	226	381	android/os/OperationCanceledException
  }
  
  /* Error */
  private void c()
  {
    // Byte code:
    //   0: getstatic 293	com/tencent/luggage/wxa/rt/e:c	Z
    //   3: istore_3
    //   4: aload_0
    //   5: getfield 76	com/tencent/luggage/wxa/rt/e:j	Ljava/io/File;
    //   8: invokevirtual 447	java/io/File:mkdir	()Z
    //   11: pop
    //   12: iload_3
    //   13: ifeq +369 -> 382
    //   16: invokestatic 453	android/os/Parcel:obtain	()Landroid/os/Parcel;
    //   19: astore 12
    //   21: aconst_null
    //   22: astore 9
    //   24: aconst_null
    //   25: astore 8
    //   27: aconst_null
    //   28: astore 11
    //   30: aconst_null
    //   31: astore 10
    //   33: aload 10
    //   35: astore 6
    //   37: new 63	java/io/File
    //   40: dup
    //   41: aload_0
    //   42: getfield 76	com/tencent/luggage/wxa/rt/e:j	Ljava/io/File;
    //   45: ldc_w 455
    //   48: invokespecial 74	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   51: astore 7
    //   53: aload 10
    //   55: astore 6
    //   57: aload 7
    //   59: invokevirtual 458	java/io/File:length	()J
    //   62: lstore 4
    //   64: lload 4
    //   66: ldc2_w 459
    //   69: lcmp
    //   70: ifgt +185 -> 255
    //   73: lload 4
    //   75: ldc2_w 461
    //   78: lcmp
    //   79: ifgt +6 -> 85
    //   82: goto +173 -> 255
    //   85: lload 4
    //   87: l2i
    //   88: iconst_4
    //   89: isub
    //   90: istore_2
    //   91: aload 10
    //   93: astore 6
    //   95: iload_2
    //   96: newarray byte
    //   98: astore 13
    //   100: aload 10
    //   102: astore 6
    //   104: new 464	java/io/DataInputStream
    //   107: dup
    //   108: new 466	java/io/FileInputStream
    //   111: dup
    //   112: aload 7
    //   114: invokespecial 469	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   117: invokespecial 472	java/io/DataInputStream:<init>	(Ljava/io/InputStream;)V
    //   120: astore 7
    //   122: aload 7
    //   124: invokevirtual 475	java/io/DataInputStream:readInt	()I
    //   127: istore_1
    //   128: iload_1
    //   129: iconst_2
    //   130: if_icmpne +82 -> 212
    //   133: iconst_0
    //   134: istore_1
    //   135: iload_1
    //   136: iload_2
    //   137: if_icmpge +22 -> 159
    //   140: iload_1
    //   141: aload 7
    //   143: aload 13
    //   145: iload_1
    //   146: aload 13
    //   148: arraylength
    //   149: iload_1
    //   150: isub
    //   151: invokevirtual 479	java/io/DataInputStream:read	([BII)I
    //   154: iadd
    //   155: istore_1
    //   156: goto -21 -> 135
    //   159: aload 7
    //   161: invokevirtual 482	java/io/DataInputStream:close	()V
    //   164: aload 10
    //   166: astore 6
    //   168: aload 12
    //   170: aload 13
    //   172: iconst_0
    //   173: iload_1
    //   174: invokevirtual 486	android/os/Parcel:unmarshall	([BII)V
    //   177: aload 10
    //   179: astore 6
    //   181: aload 12
    //   183: iconst_0
    //   184: invokevirtual 489	android/os/Parcel:setDataPosition	(I)V
    //   187: aload 10
    //   189: astore 6
    //   191: aload_0
    //   192: aload 12
    //   194: ldc 191
    //   196: invokevirtual 495	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   199: invokevirtual 499	android/os/Parcel:readBundle	(Ljava/lang/ClassLoader;)Landroid/os/Bundle;
    //   202: invokespecial 501	com/tencent/luggage/wxa/rt/e:a	(Landroid/os/Bundle;)V
    //   205: aload 11
    //   207: astore 7
    //   209: goto +147 -> 356
    //   212: new 442	com/tencent/luggage/wxa/rt/o$b
    //   215: dup
    //   216: ldc 2
    //   218: iload_1
    //   219: iconst_2
    //   220: invokespecial 504	com/tencent/luggage/wxa/rt/o$b:<init>	(Ljava/lang/Class;II)V
    //   223: athrow
    //   224: astore 8
    //   226: aload 7
    //   228: astore 6
    //   230: aload 8
    //   232: astore 7
    //   234: goto +135 -> 369
    //   237: astore 6
    //   239: aload 6
    //   241: astore 8
    //   243: goto +82 -> 325
    //   246: astore 6
    //   248: aload 6
    //   250: astore 8
    //   252: goto +90 -> 342
    //   255: aload 10
    //   257: astore 6
    //   259: new 226	java/lang/StringBuilder
    //   262: dup
    //   263: invokespecial 259	java/lang/StringBuilder:<init>	()V
    //   266: astore 7
    //   268: aload 10
    //   270: astore 6
    //   272: aload 7
    //   274: ldc_w 506
    //   277: invokevirtual 235	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: pop
    //   281: aload 10
    //   283: astore 6
    //   285: aload 7
    //   287: lload 4
    //   289: invokevirtual 509	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   292: pop
    //   293: aload 10
    //   295: astore 6
    //   297: ldc 171
    //   299: aload 7
    //   301: invokevirtual 262	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   304: invokestatic 511	com/tencent/luggage/wxa/ry/b:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   307: aload 11
    //   309: astore 7
    //   311: goto +45 -> 356
    //   314: astore 7
    //   316: goto +53 -> 369
    //   319: astore 8
    //   321: aload 9
    //   323: astore 7
    //   325: aload 7
    //   327: astore 6
    //   329: ldc 171
    //   331: aload 8
    //   333: ldc_w 513
    //   336: invokestatic 438	com/tencent/luggage/wxa/ry/b:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;)V
    //   339: goto +17 -> 356
    //   342: aload 7
    //   344: astore 6
    //   346: ldc 171
    //   348: aload 8
    //   350: invokevirtual 516	com/tencent/luggage/wxa/rt/o$b:getMessage	()Ljava/lang/String;
    //   353: invokestatic 264	com/tencent/luggage/wxa/ry/b:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   356: aload 7
    //   358: invokestatic 521	com/tencent/luggage/wxa/rt/o:a	(Ljava/io/Closeable;)V
    //   361: aload 12
    //   363: invokevirtual 524	android/os/Parcel:recycle	()V
    //   366: goto +16 -> 382
    //   369: aload 6
    //   371: invokestatic 521	com/tencent/luggage/wxa/rt/o:a	(Ljava/io/Closeable;)V
    //   374: aload 12
    //   376: invokevirtual 524	android/os/Parcel:recycle	()V
    //   379: aload 7
    //   381: athrow
    //   382: aload_0
    //   383: iload_3
    //   384: invokevirtual 526	com/tencent/luggage/wxa/rt/e:b	(Z)V
    //   387: return
    //   388: astore 6
    //   390: aload 8
    //   392: astore 7
    //   394: aload 6
    //   396: astore 8
    //   398: goto -56 -> 342
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	401	0	this	e
    //   127	92	1	i1	int
    //   90	48	2	i2	int
    //   3	381	3	bool	boolean
    //   62	226	4	l1	long
    //   35	194	6	localObject1	Object
    //   237	3	6	localThrowable1	Throwable
    //   246	3	6	localb1	o.b
    //   257	113	6	localObject2	Object
    //   388	7	6	localb2	o.b
    //   51	259	7	localObject3	Object
    //   314	1	7	localObject4	Object
    //   323	70	7	localObject5	Object
    //   25	1	8	localObject6	Object
    //   224	7	8	localObject7	Object
    //   241	10	8	localObject8	Object
    //   319	72	8	localThrowable2	Throwable
    //   396	1	8	localObject9	Object
    //   22	300	9	localObject10	Object
    //   31	263	10	localObject11	Object
    //   28	280	11	localObject12	Object
    //   19	356	12	localParcel	android.os.Parcel
    //   98	73	13	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   122	128	224	finally
    //   140	156	224	finally
    //   159	164	224	finally
    //   212	224	224	finally
    //   122	128	237	java/lang/Throwable
    //   140	156	237	java/lang/Throwable
    //   159	164	237	java/lang/Throwable
    //   212	224	237	java/lang/Throwable
    //   122	128	246	com/tencent/luggage/wxa/rt/o$b
    //   140	156	246	com/tencent/luggage/wxa/rt/o$b
    //   159	164	246	com/tencent/luggage/wxa/rt/o$b
    //   212	224	246	com/tencent/luggage/wxa/rt/o$b
    //   37	53	314	finally
    //   57	64	314	finally
    //   95	100	314	finally
    //   104	122	314	finally
    //   168	177	314	finally
    //   181	187	314	finally
    //   191	205	314	finally
    //   259	268	314	finally
    //   272	281	314	finally
    //   285	293	314	finally
    //   297	307	314	finally
    //   329	339	314	finally
    //   346	356	314	finally
    //   37	53	319	java/lang/Throwable
    //   57	64	319	java/lang/Throwable
    //   95	100	319	java/lang/Throwable
    //   104	122	319	java/lang/Throwable
    //   168	177	319	java/lang/Throwable
    //   181	187	319	java/lang/Throwable
    //   191	205	319	java/lang/Throwable
    //   259	268	319	java/lang/Throwable
    //   272	281	319	java/lang/Throwable
    //   285	293	319	java/lang/Throwable
    //   297	307	319	java/lang/Throwable
    //   37	53	388	com/tencent/luggage/wxa/rt/o$b
    //   57	64	388	com/tencent/luggage/wxa/rt/o$b
    //   95	100	388	com/tencent/luggage/wxa/rt/o$b
    //   104	122	388	com/tencent/luggage/wxa/rt/o$b
    //   168	177	388	com/tencent/luggage/wxa/rt/o$b
    //   181	187	388	com/tencent/luggage/wxa/rt/o$b
    //   191	205	388	com/tencent/luggage/wxa/rt/o$b
    //   259	268	388	com/tencent/luggage/wxa/rt/o$b
    //   272	281	388	com/tencent/luggage/wxa/rt/o$b
    //   285	293	388	com/tencent/luggage/wxa/rt/o$b
    //   297	307	388	com/tencent/luggage/wxa/rt/o$b
  }
  
  e.d a(Uri paramUri)
  {
    return a(paramUri, null);
  }
  
  e.d a(Uri paramUri, e.d paramd)
  {
    Object localObject = this.e;
    if (paramd != null) {}
    try
    {
      if (paramd.c == this.g) {
        return paramd;
      }
      g localg = this.f;
      int i1 = this.g;
      paramd = this.h;
      localObject = paramUri.getScheme();
      localObject = (h)localg.a.get(localObject);
      if (localObject == null) {
        return paramd;
      }
      paramUri = ((h)localObject).a(localg, paramUri);
      if (paramUri == null) {
        return paramd;
      }
      return new e.d((d)paramUri.first, (String)paramUri.second, i1, null);
    }
    finally {}
  }
  
  public void a(CancellationSignal paramCancellationSignal)
  {
    Object localObject1 = new File(this.j, "maintain.timestamp");
    synchronized (this.e)
    {
      Object localObject2 = this.f;
      ??? = ((g)localObject2).a.entrySet().iterator();
      Object localObject4;
      Object localObject5;
      while (((Iterator)???).hasNext())
      {
        localObject4 = (Map.Entry)((Iterator)???).next();
        localObject5 = (h)((Map.Entry)localObject4).getValue();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[Maintenance] ");
        localStringBuilder.append((String)((Map.Entry)localObject4).getKey());
        localStringBuilder.append(" => ");
        localStringBuilder.append(localObject5.toString());
        b.c("VFS.FileSystemManager", localStringBuilder.toString());
        ((h)localObject5).a(paramCancellationSignal);
      }
      localObject2 = ((g)localObject2).b.entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ??? = (Map.Entry)((Iterator)localObject2).next();
        localObject4 = (d)((Map.Entry)???).getValue();
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append("[Maintenance] ");
        ((StringBuilder)localObject5).append((String)((Map.Entry)???).getKey());
        ((StringBuilder)localObject5).append(" => ");
        ((StringBuilder)localObject5).append(localObject4.toString());
        b.c("VFS.FileSystemManager", ((StringBuilder)localObject5).toString());
        ((d)localObject4).a(paramCancellationSignal);
      }
      try
      {
        ((File)localObject1).createNewFile();
        ((File)localObject1).setLastModified(System.currentTimeMillis());
        return;
      }
      catch (IOException paramCancellationSignal)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Unable to update maintenance timestamp: ");
        ((StringBuilder)localObject1).append(paramCancellationSignal.getMessage());
        b.b("VFS.FileSystemManager", ((StringBuilder)localObject1).toString());
        return;
      }
    }
    for (;;)
    {
      throw paramCancellationSignal;
    }
  }
  
  Map<String, String> b()
  {
    return this.i.a();
  }
  
  public void b(boolean paramBoolean)
  {
    Object localObject = this.s;
    if ((localObject == null) && (paramBoolean))
    {
      localObject = new e.1(this);
      this.s = ((BroadcastReceiver)localObject);
      String str = this.d.getPackageName();
      Context localContext = this.d;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append(".REFRESH_VFS");
      localContext.registerReceiver((BroadcastReceiver)localObject, new IntentFilter(localStringBuilder.toString()), "com.tencent.mm.permission.MM_MESSAGE", null);
      b.c("VFS.FileSystemManager", "Broadcast receiving enabled.");
      return;
    }
    if ((localObject != null) && (!paramBoolean))
    {
      this.d.unregisterReceiver((BroadcastReceiver)localObject);
      this.s = null;
      b.c("VFS.FileSystemManager", "Broadcast receiving disabled.");
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    int i1 = paramMessage.what;
    if (i1 != 1)
    {
      if (i1 != 2) {
        return false;
      }
      b((CancellationSignal)paramMessage.obj);
      return true;
    }
    paramMessage = (Intent)paramMessage.obj;
    paramMessage.setExtrasClassLoader(d.class.getClassLoader());
    b.c("VFS.FileSystemManager", "Refresh file system from broadcast.");
    try
    {
      a(paramMessage.getExtras());
      return true;
    }
    catch (Throwable paramMessage)
    {
      b.a("VFS.FileSystemManager", paramMessage, "Failed to refresh file system from broadcast.");
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.rt.e
 * JD-Core Version:    0.7.0.1
 */
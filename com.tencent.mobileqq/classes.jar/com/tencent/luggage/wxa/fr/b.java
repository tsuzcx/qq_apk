package com.tencent.luggage.wxa.fr;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.util.Log;
import android.util.Pair;
import com.tencent.luggage.wxa.fq.s;
import com.tencent.luggage.wxa.hg.f;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.nativecrash.NativeCrash;
import com.tencent.nativecrash.NativeCrash.a;
import com.tencent.nativecrash.NativeCrash.c;
import java.io.BufferedReader;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.ObjectRef;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/luggage/wxaapi/internal/crash/WxaCrashHandler;", "Lcom/tencent/nativecrash/NativeCrash$CrashCallback;", "Lcom/tencent/nativecrash/NativeCrash$ANRCallback;", "Lcom/tencent/luggage/wxaapi/internal/crash/JvmCrashListener;", "()V", "TAG", "", "formatFileDescriptors", "", "fr", "Ljava/io/BufferedReader;", "sb", "Ljava/lang/StringBuilder;", "generateCrashLog", "Lcom/tencent/luggage/wxaapi/internal/crash/WxaCrashLogItem;", "status", "", "shortDumpFile", "fullDumpFile", "onANRDumped", "", "dumpFile", "onCrashDumped", "onJvmCrash", "thread", "Ljava/lang/Thread;", "exception", "", "setup", "uploadCrashLog", "path", "luggage-standalone-open-runtime-sdk_release"}, k=1, mv={1, 1, 16})
public final class b
  implements a, NativeCrash.a, NativeCrash.c
{
  public static final b a = new b();
  
  private final void a(BufferedReader paramBufferedReader, StringBuilder paramStringBuilder)
  {
    Object localObject2 = new Ref.ObjectRef();
    ArrayList localArrayList1 = new ArrayList();
    Object localObject1;
    for (;;)
    {
      localObject1 = paramBufferedReader.readLine();
      ((Ref.ObjectRef)localObject2).element = localObject1;
      if (localObject1 == null) {
        break label183;
      }
      localObject1 = (String)((Ref.ObjectRef)localObject2).element;
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      if (((CharSequence)localObject1).length() == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        break label183;
      }
      localObject1 = (String)((Ref.ObjectRef)localObject2).element;
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      i = StringsKt.indexOf$default((CharSequence)localObject1, " -> ", 0, false, 6, null);
      if (i <= 0) {
        break label183;
      }
      localObject1 = (String)((Ref.ObjectRef)localObject2).element;
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      if (localObject1 == null) {
        break;
      }
      localObject1 = ((String)localObject1).substring(i + 4);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "(this as java.lang.String).substring(startIndex)");
      localArrayList1.add(localObject1);
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    label183:
    if (localArrayList1.isEmpty()) {
      return;
    }
    CollectionsKt.sort((List)localArrayList1);
    ArrayList localArrayList2 = new ArrayList();
    paramBufferedReader = localArrayList1.get(0);
    Intrinsics.checkExpressionValueIsNotNull(paramBufferedReader, "pathList[0]");
    paramBufferedReader = (String)paramBufferedReader;
    int k = localArrayList1.size();
    int j = 1;
    int i = 1;
    while (j < k)
    {
      localObject1 = localArrayList1.get(j);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "pathList[i]");
      localObject1 = (String)localObject1;
      if ((Intrinsics.areEqual(localObject1, paramBufferedReader) ^ true))
      {
        localArrayList2.add(Pair.create(paramBufferedReader, Integer.valueOf(i)));
        paramBufferedReader = (BufferedReader)localObject1;
        i = 1;
      }
      else
      {
        i += 1;
      }
      j += 1;
    }
    localArrayList2.add(Pair.create(paramBufferedReader, Integer.valueOf(i)));
    CollectionsKt.sortWith((List)localArrayList2, (Comparator)b.a.a);
    paramStringBuilder.append("[File Descriptors]\n");
    if ((String)((Ref.ObjectRef)localObject2).element != null)
    {
      paramBufferedReader = (String)((Ref.ObjectRef)localObject2).element;
      if (paramBufferedReader == null) {
        Intrinsics.throwNpe();
      }
      if (StringsKt.startsWith$default(paramBufferedReader, "Total: ", false, 2, null))
      {
        paramStringBuilder.append((String)((Ref.ObjectRef)localObject2).element);
        paramStringBuilder.append('\n');
      }
    }
    paramBufferedReader = localArrayList2.iterator();
    while (paramBufferedReader.hasNext())
    {
      localObject1 = (Pair)paramBufferedReader.next();
      paramStringBuilder.append('(');
      localObject2 = ((Pair)localObject1).second;
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "c.second");
      paramStringBuilder.append(((Number)localObject2).intValue());
      paramStringBuilder.append(") ");
      paramStringBuilder.append((String)((Pair)localObject1).first);
      paramStringBuilder.append('\n');
    }
    paramStringBuilder.append('\n');
  }
  
  private final void a(String paramString)
  {
    Context localContext = r.a();
    long l = com.tencent.luggage.wxa.fv.e.a.a();
    Intent localIntent = new Intent(localContext, com.tencent.luggage.wxa.bj.c.class);
    localIntent.putExtra("KEY_CRASH_LOG_PATH", paramString);
    localIntent.putExtra("KEY_CRASH_UIN", String.valueOf(l));
    localIntent.putExtra("KEY_CRASH_PRODUCT_ID", 6601);
    localIntent.putExtra("KEY_CLIENT_VERSION", 553976065);
    localContext.startService(localIntent);
  }
  
  /* Error */
  private final c b(int paramInt, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: invokestatic 272	java/lang/System:currentTimeMillis	()J
    //   3: lstore 4
    //   5: new 172	java/lang/StringBuilder
    //   8: dup
    //   9: sipush 2048
    //   12: invokespecial 275	java/lang/StringBuilder:<init>	(I)V
    //   15: astore 7
    //   17: new 277	java/io/FileReader
    //   20: dup
    //   21: aload_2
    //   22: invokespecial 278	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   25: checkcast 280	java/io/Closeable
    //   28: astore 8
    //   30: aconst_null
    //   31: checkcast 265	java/lang/Throwable
    //   34: astore 6
    //   36: aload 6
    //   38: astore_2
    //   39: aload 8
    //   41: checkcast 277	java/io/FileReader
    //   44: astore 9
    //   46: aload 6
    //   48: astore_2
    //   49: sipush 2048
    //   52: invokestatic 286	java/nio/CharBuffer:allocate	(I)Ljava/nio/CharBuffer;
    //   55: astore 10
    //   57: aload 6
    //   59: astore_2
    //   60: aload 9
    //   62: aload 10
    //   64: invokevirtual 290	java/io/FileReader:read	(Ljava/nio/CharBuffer;)I
    //   67: ifle +38 -> 105
    //   70: aload 6
    //   72: astore_2
    //   73: aload 10
    //   75: invokevirtual 294	java/nio/CharBuffer:flip	()Ljava/nio/Buffer;
    //   78: pop
    //   79: aload 6
    //   81: astore_2
    //   82: aload 7
    //   84: aload 10
    //   86: checkcast 85	java/lang/CharSequence
    //   89: invokevirtual 297	java/lang/StringBuilder:append	(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: aload 6
    //   95: astore_2
    //   96: aload 10
    //   98: invokevirtual 300	java/nio/CharBuffer:clear	()Ljava/nio/Buffer;
    //   101: pop
    //   102: goto -45 -> 57
    //   105: aload 6
    //   107: astore_2
    //   108: aload 7
    //   110: bipush 10
    //   112: invokevirtual 185	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   115: pop
    //   116: aload 8
    //   118: aload 6
    //   120: invokestatic 306	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   123: ldc_w 308
    //   126: invokestatic 314	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   129: aload 7
    //   131: checkcast 85	java/lang/CharSequence
    //   134: invokevirtual 318	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   137: astore 6
    //   139: iload_1
    //   140: ifeq +28 -> 168
    //   143: aload 7
    //   145: ldc_w 320
    //   148: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: pop
    //   152: aload 7
    //   154: iload_1
    //   155: invokevirtual 211	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   158: pop
    //   159: aload 7
    //   161: ldc_w 322
    //   164: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: pop
    //   168: ldc_w 324
    //   171: ldc_w 326
    //   174: iconst_2
    //   175: anewarray 4	java/lang/Object
    //   178: dup
    //   179: iconst_0
    //   180: lload 4
    //   182: invokestatic 331	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   185: aastore
    //   186: dup
    //   187: iconst_1
    //   188: invokestatic 272	java/lang/System:currentTimeMillis	()J
    //   191: lload 4
    //   193: lsub
    //   194: invokestatic 331	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   197: aastore
    //   198: invokestatic 337	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   201: new 68	java/io/BufferedReader
    //   204: dup
    //   205: new 277	java/io/FileReader
    //   208: dup
    //   209: aload_3
    //   210: invokespecial 278	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   213: checkcast 339	java/io/Reader
    //   216: invokespecial 342	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   219: checkcast 280	java/io/Closeable
    //   222: astore 8
    //   224: aconst_null
    //   225: checkcast 265	java/lang/Throwable
    //   228: astore_3
    //   229: aload_3
    //   230: astore_2
    //   231: aload 8
    //   233: checkcast 68	java/io/BufferedReader
    //   236: astore 9
    //   238: aload_3
    //   239: astore_2
    //   240: new 62	kotlin/jvm/internal/Ref$ObjectRef
    //   243: dup
    //   244: invokespecial 63	kotlin/jvm/internal/Ref$ObjectRef:<init>	()V
    //   247: astore 10
    //   249: aload_3
    //   250: astore_2
    //   251: aload 9
    //   253: invokevirtual 72	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   256: astore 11
    //   258: aload_3
    //   259: astore_2
    //   260: aload 10
    //   262: aload 11
    //   264: putfield 76	kotlin/jvm/internal/Ref$ObjectRef:element	Ljava/lang/Object;
    //   267: aload 11
    //   269: ifnull +96 -> 365
    //   272: aload_3
    //   273: astore_2
    //   274: aload 10
    //   276: getfield 76	kotlin/jvm/internal/Ref$ObjectRef:element	Ljava/lang/Object;
    //   279: checkcast 78	java/lang/String
    //   282: astore 11
    //   284: aload 11
    //   286: ifnonnull +6 -> 292
    //   289: goto +47 -> 336
    //   292: aload_3
    //   293: astore_2
    //   294: aload 11
    //   296: invokevirtual 345	java/lang/String:hashCode	()I
    //   299: ldc_w 346
    //   302: if_icmpeq +6 -> 308
    //   305: goto +31 -> 336
    //   308: aload_3
    //   309: astore_2
    //   310: aload 11
    //   312: ldc_w 348
    //   315: invokevirtual 351	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   318: ifeq +18 -> 336
    //   321: aload_3
    //   322: astore_2
    //   323: getstatic 57	com/tencent/luggage/wxa/fr/b:a	Lcom/tencent/luggage/wxa/fr/b;
    //   326: aload 9
    //   328: aload 7
    //   330: invokespecial 353	com/tencent/luggage/wxa/fr/b:a	(Ljava/io/BufferedReader;Ljava/lang/StringBuilder;)V
    //   333: goto +196 -> 529
    //   336: aload_3
    //   337: astore_2
    //   338: aload 7
    //   340: aload 10
    //   342: getfield 76	kotlin/jvm/internal/Ref$ObjectRef:element	Ljava/lang/Object;
    //   345: checkcast 78	java/lang/String
    //   348: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: pop
    //   352: aload_3
    //   353: astore_2
    //   354: aload 7
    //   356: bipush 10
    //   358: invokevirtual 185	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   361: pop
    //   362: goto +167 -> 529
    //   365: aload_3
    //   366: astore_2
    //   367: getstatic 359	kotlin/Unit:INSTANCE	Lkotlin/Unit;
    //   370: astore 9
    //   372: aload 8
    //   374: aload_3
    //   375: invokestatic 306	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   378: goto +45 -> 423
    //   381: astore_3
    //   382: goto +8 -> 390
    //   385: astore_3
    //   386: aload_3
    //   387: astore_2
    //   388: aload_3
    //   389: athrow
    //   390: aload 8
    //   392: aload_2
    //   393: invokestatic 306	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   396: aload_3
    //   397: athrow
    //   398: astore_2
    //   399: aload 7
    //   401: ldc_w 361
    //   404: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: pop
    //   408: aload 7
    //   410: aload_2
    //   411: invokevirtual 364	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   414: pop
    //   415: aload 7
    //   417: bipush 10
    //   419: invokevirtual 185	java/lang/StringBuilder:append	(C)Ljava/lang/StringBuilder;
    //   422: pop
    //   423: getstatic 370	com/tencent/luggage/wxa/fr/d:c	Lcom/tencent/luggage/wxa/fr/d;
    //   426: astore_2
    //   427: aload 7
    //   429: invokevirtual 373	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   432: astore_3
    //   433: aload_3
    //   434: ldc_w 375
    //   437: invokestatic 107	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
    //   440: new 377	com/tencent/luggage/wxa/fr/c
    //   443: dup
    //   444: aload_2
    //   445: aload_3
    //   446: invokespecial 380	com/tencent/luggage/wxa/fr/c:<init>	(Lcom/tencent/luggage/wxa/fr/d;Ljava/lang/String;)V
    //   449: astore_2
    //   450: aload 6
    //   452: invokevirtual 385	java/util/regex/Matcher:find	()Z
    //   455: ifeq +16 -> 471
    //   458: aload_2
    //   459: aload 6
    //   461: iconst_1
    //   462: invokevirtual 388	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   465: invokestatic 394	com/tencent/luggage/wxa/qz/af:e	(Ljava/lang/String;)I
    //   468: invokevirtual 396	com/tencent/luggage/wxa/fr/c:a	(I)V
    //   471: ldc_w 324
    //   474: ldc_w 326
    //   477: iconst_2
    //   478: anewarray 4	java/lang/Object
    //   481: dup
    //   482: iconst_0
    //   483: lload 4
    //   485: invokestatic 331	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   488: aastore
    //   489: dup
    //   490: iconst_1
    //   491: invokestatic 272	java/lang/System:currentTimeMillis	()J
    //   494: lload 4
    //   496: lsub
    //   497: invokestatic 331	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   500: aastore
    //   501: invokestatic 337	com/tencent/luggage/wxa/qz/o:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   504: aload_2
    //   505: areturn
    //   506: astore_3
    //   507: goto +8 -> 515
    //   510: astore_3
    //   511: aload_3
    //   512: astore_2
    //   513: aload_3
    //   514: athrow
    //   515: aload 8
    //   517: aload_2
    //   518: invokestatic 306	kotlin/io/CloseableKt:closeFinally	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   521: goto +5 -> 526
    //   524: aload_3
    //   525: athrow
    //   526: goto -2 -> 524
    //   529: goto -280 -> 249
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	532	0	this	b
    //   0	532	1	paramInt	int
    //   0	532	2	paramString1	String
    //   0	532	3	paramString2	String
    //   3	492	4	l	long
    //   34	426	6	localObject1	Object
    //   15	413	7	localStringBuilder	StringBuilder
    //   28	488	8	localCloseable	java.io.Closeable
    //   44	327	9	localObject2	Object
    //   55	286	10	localObject3	Object
    //   256	55	11	str	String
    // Exception table:
    //   from	to	target	type
    //   231	238	381	finally
    //   240	249	381	finally
    //   251	258	381	finally
    //   260	267	381	finally
    //   274	284	381	finally
    //   294	305	381	finally
    //   310	321	381	finally
    //   323	333	381	finally
    //   338	352	381	finally
    //   354	362	381	finally
    //   367	372	381	finally
    //   388	390	381	finally
    //   231	238	385	java/lang/Throwable
    //   240	249	385	java/lang/Throwable
    //   251	258	385	java/lang/Throwable
    //   260	267	385	java/lang/Throwable
    //   274	284	385	java/lang/Throwable
    //   294	305	385	java/lang/Throwable
    //   310	321	385	java/lang/Throwable
    //   323	333	385	java/lang/Throwable
    //   338	352	385	java/lang/Throwable
    //   354	362	385	java/lang/Throwable
    //   367	372	385	java/lang/Throwable
    //   201	229	398	java/io/IOException
    //   372	378	398	java/io/IOException
    //   390	398	398	java/io/IOException
    //   39	46	506	finally
    //   49	57	506	finally
    //   60	70	506	finally
    //   73	79	506	finally
    //   82	93	506	finally
    //   96	102	506	finally
    //   108	116	506	finally
    //   513	515	506	finally
    //   39	46	510	java/lang/Throwable
    //   49	57	510	java/lang/Throwable
    //   60	70	510	java/lang/Throwable
    //   73	79	510	java/lang/Throwable
    //   82	93	510	java/lang/Throwable
    //   96	102	510	java/lang/Throwable
    //   108	116	510	java/lang/Throwable
  }
  
  public final void a()
  {
    File localFile = new File(s.c);
    String str = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).format(new Date());
    e.a.a((a)this);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append('_');
    localStringBuilder.append(System.currentTimeMillis());
    localFile = new File(localFile, localStringBuilder.toString());
    f.a("wechatcrash", NativeCrash.class.getClassLoader());
    NativeCrash.init(localFile.getAbsolutePath(), 1871, 2048, true);
    NativeCrash.resetCustomInfo();
    NativeCrash.customInfo("sdk_version: 1.5.1");
    NativeCrash.customInfo("is_released: true");
    NativeCrash.customInfo("rev: 897a5c67ab7684eb5b9d8eba155ed3fc26c6dded");
    NativeCrash.crashCallback((NativeCrash.c)this);
    NativeCrash.anrCallback((NativeCrash.a)this);
  }
  
  public void a(@NotNull Thread paramThread, @NotNull Throwable paramThrowable)
  {
    Intrinsics.checkParameterIsNotNull(paramThread, "thread");
    Intrinsics.checkParameterIsNotNull(paramThrowable, "exception");
    o.a("Luggage.WxaCrashHandler", paramThrowable, "thread [%s]", new Object[] { paramThread });
    paramThread = d.a;
    Object localObject = Log.getStackTraceString(paramThrowable);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "android.util.Log.getStackTraceString(exception)");
    paramThread = new c(paramThread, (String)localObject);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(s.c);
    ((StringBuilder)localObject).append(paramThread.a());
    ((StringBuilder)localObject).append(".txt");
    localObject = ((StringBuilder)localObject).toString();
    s.a(0, d.a.name(), paramThrowable.getMessage(), paramThread.b());
    s.a(d.a.name(), paramThread.b(), (String)localObject);
    a((String)localObject);
  }
  
  public boolean a(int paramInt, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "dumpFile");
    paramString = new StringBuilder("");
    Object localObject1 = Looper.getMainLooper();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "Looper.getMainLooper()");
    localObject1 = ((Looper)localObject1).getThread();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "Looper.getMainLooper().thread");
    localObject1 = ((Thread)localObject1).getStackTrace();
    int i = localObject1.length;
    paramInt = 0;
    while (paramInt < i)
    {
      Object localObject2 = localObject1[paramInt];
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localObject2);
      localStringBuilder.append('\n');
      paramString.append(localStringBuilder.toString());
      paramInt += 1;
    }
    localObject1 = d.b;
    paramString = paramString.toString();
    Intrinsics.checkExpressionValueIsNotNull(paramString, "stackTrace.toString()");
    paramString = new c((d)localObject1, paramString);
    s.a(0, d.b.name(), "", paramString.b());
    o.b("Luggage.WxaCrashHandler", "onANRDumped, [%s]", new Object[] { paramString.toString() });
    return false;
  }
  
  public boolean a(int paramInt, @NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "shortDumpFile");
    Intrinsics.checkParameterIsNotNull(paramString2, "fullDumpFile");
    o.d("Luggage.WxaCrashHandler", "onCrashDumped: ");
    paramString1 = b(paramInt, paramString1, paramString2);
    paramString2 = new StringBuilder();
    paramString2.append(s.c);
    paramString2.append(paramString1.a());
    paramString2.append(".txt");
    paramString2 = paramString2.toString();
    s.a(0, d.c.name(), "", paramString1.b());
    s.a(d.c.name(), paramString1.b(), paramString2);
    a(paramString2);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fr.b
 * JD-Core Version:    0.7.0.1
 */
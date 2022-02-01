package com.tencent.bugly.crashreport.crash.jni;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.crashreport.common.info.a;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class b
{
  private static List<File> a = new ArrayList();
  
  /* Error */
  public static CrashDetailBean a(Context paramContext, String paramString, NativeExceptionHandler paramNativeExceptionHandler)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +288 -> 289
    //   4: aload_1
    //   5: ifnull +284 -> 289
    //   8: aload_2
    //   9: ifnonnull +6 -> 15
    //   12: goto +277 -> 289
    //   15: new 22	java/io/File
    //   18: dup
    //   19: aload_1
    //   20: ldc 24
    //   22: invokespecial 27	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   25: astore_1
    //   26: aload_1
    //   27: invokevirtual 31	java/io/File:exists	()Z
    //   30: ifeq +257 -> 287
    //   33: aload_1
    //   34: invokevirtual 34	java/io/File:canRead	()Z
    //   37: ifne +5 -> 42
    //   40: aconst_null
    //   41: areturn
    //   42: new 36	java/io/BufferedInputStream
    //   45: dup
    //   46: new 38	java/io/FileInputStream
    //   49: dup
    //   50: aload_1
    //   51: invokespecial 41	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   54: invokespecial 44	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   57: astore_3
    //   58: aload_3
    //   59: astore_1
    //   60: aload_3
    //   61: invokestatic 47	com/tencent/bugly/crashreport/crash/jni/b:a	(Ljava/io/BufferedInputStream;)Ljava/lang/String;
    //   64: astore 4
    //   66: aload 4
    //   68: ifnull +132 -> 200
    //   71: aload_3
    //   72: astore_1
    //   73: aload 4
    //   75: ldc 49
    //   77: invokevirtual 55	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   80: ifne +6 -> 86
    //   83: goto +117 -> 200
    //   86: aload_3
    //   87: astore_1
    //   88: new 57	java/util/HashMap
    //   91: dup
    //   92: invokespecial 58	java/util/HashMap:<init>	()V
    //   95: astore 6
    //   97: goto +204 -> 301
    //   100: aload_3
    //   101: astore_1
    //   102: aload_3
    //   103: invokestatic 47	com/tencent/bugly/crashreport/crash/jni/b:a	(Ljava/io/BufferedInputStream;)Ljava/lang/String;
    //   106: astore 5
    //   108: aload 5
    //   110: ifnull +32 -> 142
    //   113: aload 4
    //   115: ifnonnull +10 -> 125
    //   118: aload 5
    //   120: astore 4
    //   122: goto -22 -> 100
    //   125: aload_3
    //   126: astore_1
    //   127: aload 6
    //   129: aload 4
    //   131: aload 5
    //   133: invokeinterface 64 3 0
    //   138: pop
    //   139: goto +162 -> 301
    //   142: aload 4
    //   144: ifnull +33 -> 177
    //   147: aload_3
    //   148: astore_1
    //   149: ldc 66
    //   151: iconst_1
    //   152: anewarray 4	java/lang/Object
    //   155: dup
    //   156: iconst_0
    //   157: aload 4
    //   159: aastore
    //   160: invokestatic 72	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   163: pop
    //   164: aload_3
    //   165: invokevirtual 75	java/io/BufferedInputStream:close	()V
    //   168: aconst_null
    //   169: areturn
    //   170: astore_0
    //   171: aload_0
    //   172: invokevirtual 78	java/io/IOException:printStackTrace	()V
    //   175: aconst_null
    //   176: areturn
    //   177: aload_3
    //   178: astore_1
    //   179: aload_0
    //   180: aload 6
    //   182: aload_2
    //   183: invokestatic 81	com/tencent/bugly/crashreport/crash/jni/b:a	(Landroid/content/Context;Ljava/util/Map;Lcom/tencent/bugly/crashreport/crash/jni/NativeExceptionHandler;)Lcom/tencent/bugly/crashreport/crash/CrashDetailBean;
    //   186: astore_0
    //   187: aload_3
    //   188: invokevirtual 75	java/io/BufferedInputStream:close	()V
    //   191: aload_0
    //   192: areturn
    //   193: astore_1
    //   194: aload_1
    //   195: invokevirtual 78	java/io/IOException:printStackTrace	()V
    //   198: aload_0
    //   199: areturn
    //   200: aload_3
    //   201: astore_1
    //   202: ldc 83
    //   204: iconst_1
    //   205: anewarray 4	java/lang/Object
    //   208: dup
    //   209: iconst_0
    //   210: aload 4
    //   212: aastore
    //   213: invokestatic 72	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   216: pop
    //   217: aload_3
    //   218: invokevirtual 75	java/io/BufferedInputStream:close	()V
    //   221: aconst_null
    //   222: areturn
    //   223: astore_0
    //   224: aload_0
    //   225: invokevirtual 78	java/io/IOException:printStackTrace	()V
    //   228: aconst_null
    //   229: areturn
    //   230: astore_2
    //   231: aload_3
    //   232: astore_0
    //   233: goto +12 -> 245
    //   236: astore_0
    //   237: aconst_null
    //   238: astore_1
    //   239: goto +30 -> 269
    //   242: astore_2
    //   243: aconst_null
    //   244: astore_0
    //   245: aload_0
    //   246: astore_1
    //   247: aload_2
    //   248: invokevirtual 78	java/io/IOException:printStackTrace	()V
    //   251: aload_0
    //   252: ifnull +14 -> 266
    //   255: aload_0
    //   256: invokevirtual 75	java/io/BufferedInputStream:close	()V
    //   259: aconst_null
    //   260: areturn
    //   261: astore_0
    //   262: aload_0
    //   263: invokevirtual 78	java/io/IOException:printStackTrace	()V
    //   266: aconst_null
    //   267: areturn
    //   268: astore_0
    //   269: aload_1
    //   270: ifnull +15 -> 285
    //   273: aload_1
    //   274: invokevirtual 75	java/io/BufferedInputStream:close	()V
    //   277: goto +8 -> 285
    //   280: astore_1
    //   281: aload_1
    //   282: invokevirtual 78	java/io/IOException:printStackTrace	()V
    //   285: aload_0
    //   286: athrow
    //   287: aconst_null
    //   288: areturn
    //   289: ldc 85
    //   291: iconst_0
    //   292: anewarray 4	java/lang/Object
    //   295: invokestatic 72	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   298: pop
    //   299: aconst_null
    //   300: areturn
    //   301: aconst_null
    //   302: astore 4
    //   304: goto -204 -> 100
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	307	0	paramContext	Context
    //   0	307	1	paramString	String
    //   0	307	2	paramNativeExceptionHandler	NativeExceptionHandler
    //   57	175	3	localBufferedInputStream	java.io.BufferedInputStream
    //   64	239	4	localObject	Object
    //   106	26	5	str	String
    //   95	86	6	localHashMap	HashMap
    // Exception table:
    //   from	to	target	type
    //   164	168	170	java/io/IOException
    //   187	191	193	java/io/IOException
    //   217	221	223	java/io/IOException
    //   60	66	230	java/io/IOException
    //   73	83	230	java/io/IOException
    //   88	97	230	java/io/IOException
    //   102	108	230	java/io/IOException
    //   127	139	230	java/io/IOException
    //   149	164	230	java/io/IOException
    //   179	187	230	java/io/IOException
    //   202	217	230	java/io/IOException
    //   42	58	236	finally
    //   42	58	242	java/io/IOException
    //   255	259	261	java/io/IOException
    //   60	66	268	finally
    //   73	83	268	finally
    //   88	97	268	finally
    //   102	108	268	finally
    //   127	139	268	finally
    //   149	164	268	finally
    //   179	187	268	finally
    //   202	217	268	finally
    //   247	251	268	finally
    //   273	277	280	java/io/IOException
  }
  
  private static CrashDetailBean a(Context paramContext, Map<String, String> paramMap, NativeExceptionHandler paramNativeExceptionHandler)
  {
    if (paramMap == null) {
      return null;
    }
    if (a.a(paramContext) == null)
    {
      x.e("abnormal com info not created", new Object[0]);
      return null;
    }
    paramContext = (String)paramMap.get("intStateStr");
    Map localMap;
    if ((paramContext != null) && (paramContext.trim().length() > 0))
    {
      localMap = d(paramContext);
      if (localMap == null)
      {
        x.e("parse intSateMap fail", new Object[] { Integer.valueOf(paramMap.size()) });
        return null;
      }
    }
    for (;;)
    {
      Object localObject8;
      int i;
      try
      {
        ((Integer)localMap.get("sino")).intValue();
        ((Integer)localMap.get("sud")).intValue();
        str3 = (String)paramMap.get("soVersion");
        if (TextUtils.isEmpty(str3))
        {
          x.e("error format at version", new Object[0]);
          return null;
        }
        str1 = (String)paramMap.get("errorAddr");
        localObject7 = "unknown";
        if (str1 == null) {
          str1 = "unknown";
        }
        localObject1 = (String)paramMap.get("codeMsg");
        paramContext = (Context)localObject1;
        if (localObject1 == null) {
          paramContext = "unknown";
        }
        str2 = (String)paramMap.get("tombPath");
        if (str2 != null) {
          break label1164;
        }
        str2 = "unknown";
        localObject2 = (String)paramMap.get("signalName");
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "unknown";
        }
        paramMap.get("errnoMsg");
        localObject3 = (String)paramMap.get("stack");
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = "unknown";
        }
        localObject4 = (String)paramMap.get("jstack");
        localObject3 = localObject2;
        if (localObject4 != null)
        {
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append((String)localObject2);
          ((StringBuilder)localObject3).append("java:\n");
          ((StringBuilder)localObject3).append((String)localObject4);
          localObject3 = ((StringBuilder)localObject3).toString();
        }
        localObject2 = (Integer)localMap.get("sico");
        if ((localObject2 == null) || (((Integer)localObject2).intValue() <= 0)) {
          break label1167;
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append("(");
        ((StringBuilder)localObject2).append(paramContext);
        ((StringBuilder)localObject2).append(")");
        localObject1 = ((StringBuilder)localObject2).toString();
        localObject2 = "KERNEL";
        paramContext = (String)paramMap.get("nativeLog");
        if ((paramContext == null) || (paramContext.isEmpty())) {
          break label1173;
        }
        localObject4 = z.a(null, paramContext, "BuglyNativeLog.txt");
        localObject5 = (String)paramMap.get("sendingProcess");
        paramContext = (Context)localObject5;
        if (localObject5 == null) {
          paramContext = "unknown";
        }
        localObject6 = (Integer)localMap.get("spd");
        localObject5 = paramContext;
        if (localObject6 != null)
        {
          localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append(paramContext);
          ((StringBuilder)localObject5).append("(");
          ((StringBuilder)localObject5).append(localObject6);
          ((StringBuilder)localObject5).append(")");
          localObject5 = ((StringBuilder)localObject5).toString();
        }
        localObject6 = (String)paramMap.get("threadName");
        paramContext = (Context)localObject6;
        if (localObject6 == null) {
          paramContext = "unknown";
        }
        localObject8 = (Integer)localMap.get("et");
        localObject6 = paramContext;
        if (localObject8 != null)
        {
          localObject6 = new StringBuilder();
          ((StringBuilder)localObject6).append(paramContext);
          ((StringBuilder)localObject6).append("(");
          ((StringBuilder)localObject6).append(localObject8);
          ((StringBuilder)localObject6).append(")");
          localObject6 = ((StringBuilder)localObject6).toString();
        }
        paramContext = (String)paramMap.get("processName");
        if (paramContext != null) {
          break label1179;
        }
        paramContext = (Context)localObject7;
        localObject8 = (Integer)localMap.get("ep");
        localObject7 = paramContext;
        if (localObject8 != null)
        {
          localObject7 = new StringBuilder();
          ((StringBuilder)localObject7).append(paramContext);
          ((StringBuilder)localObject7).append("(");
          ((StringBuilder)localObject7).append(localObject8);
          ((StringBuilder)localObject7).append(")");
          localObject7 = ((StringBuilder)localObject7).toString();
        }
        paramContext = (String)paramMap.get("key-value");
        if (paramContext == null) {
          break label1195;
        }
        localObject8 = new HashMap();
        paramContext = paramContext.split("\n");
        int j = paramContext.length;
        i = 0;
        if (i >= j) {
          break label1189;
        }
        String[] arrayOfString = paramContext[i].split("=");
        if (arrayOfString.length != 2) {
          break label1182;
        }
        ((Map)localObject8).put(arrayOfString[0], arrayOfString[1]);
      }
      catch (Throwable paramContext)
      {
        String str3;
        String str1;
        Object localObject7;
        Object localObject1;
        String str2;
        Object localObject3;
        Object localObject5;
        Object localObject6;
        long l;
        x.e("error format", new Object[0]);
        paramContext.printStackTrace();
        return null;
      }
      l = ((Integer)localMap.get("ets")).intValue();
      paramContext = paramNativeExceptionHandler.packageCrashDatas((String)localObject7, (String)localObject6, ((Integer)localMap.get("etms")).intValue() / 1000L + l * 1000L, (String)localObject1, str1, a((String)localObject3), (String)localObject2, (String)localObject5, str2, (String)paramMap.get("sysLogPath"), (String)paramMap.get("jniLogPath"), str3, (byte[])localObject4, paramContext, false, false);
      if (paramContext != null)
      {
        paramNativeExceptionHandler = (String)paramMap.get("userId");
        if (paramNativeExceptionHandler != null)
        {
          x.c("[Native record info] userId: %s", new Object[] { paramNativeExceptionHandler });
          paramContext.m = paramNativeExceptionHandler;
        }
        paramNativeExceptionHandler = (String)paramMap.get("sysLog");
        if (paramNativeExceptionHandler != null) {
          paramContext.w = paramNativeExceptionHandler;
        }
        paramNativeExceptionHandler = (String)paramMap.get("appVersion");
        if (paramNativeExceptionHandler != null)
        {
          x.c("[Native record info] appVersion: %s", new Object[] { paramNativeExceptionHandler });
          paramContext.f = paramNativeExceptionHandler;
        }
        paramNativeExceptionHandler = (String)paramMap.get("isAppForeground");
        if (paramNativeExceptionHandler != null)
        {
          x.c("[Native record info] isAppForeground: %s", new Object[] { paramNativeExceptionHandler });
          paramContext.N = paramNativeExceptionHandler.equalsIgnoreCase("true");
        }
        paramMap = (String)paramMap.get("launchTime");
        if (paramMap != null)
        {
          x.c("[Native record info] launchTime: %s", new Object[] { paramMap });
          try
          {
            paramContext.M = Long.parseLong(paramMap);
          }
          catch (NumberFormatException paramMap)
          {
            if (!x.a(paramMap)) {
              paramMap.printStackTrace();
            }
          }
        }
        paramContext.z = null;
        paramContext.k = true;
      }
      return paramContext;
      x.e("no intStateStr", new Object[0]);
      return null;
      label1164:
      continue;
      label1167:
      Object localObject2 = paramContext;
      continue;
      label1173:
      Object localObject4 = null;
      continue;
      label1179:
      continue;
      label1182:
      i += 1;
      continue;
      label1189:
      paramContext = (Context)localObject8;
      continue;
      label1195:
      paramContext = null;
    }
  }
  
  /* Error */
  private static String a(java.io.BufferedInputStream paramBufferedInputStream)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: new 306	java/io/ByteArrayOutputStream
    //   9: dup
    //   10: sipush 1024
    //   13: invokespecial 309	java/io/ByteArrayOutputStream:<init>	(I)V
    //   16: astore_3
    //   17: aload_3
    //   18: astore_2
    //   19: aload_0
    //   20: invokevirtual 312	java/io/BufferedInputStream:read	()I
    //   23: istore_1
    //   24: iload_1
    //   25: iconst_m1
    //   26: if_icmpeq +40 -> 66
    //   29: iload_1
    //   30: ifne +26 -> 56
    //   33: aload_3
    //   34: astore_2
    //   35: new 51	java/lang/String
    //   38: dup
    //   39: aload_3
    //   40: invokevirtual 316	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   43: ldc_w 318
    //   46: invokespecial 321	java/lang/String:<init>	([BLjava/lang/String;)V
    //   49: astore_0
    //   50: aload_3
    //   51: invokevirtual 322	java/io/ByteArrayOutputStream:close	()V
    //   54: aload_0
    //   55: areturn
    //   56: aload_3
    //   57: astore_2
    //   58: aload_3
    //   59: iload_1
    //   60: invokevirtual 325	java/io/ByteArrayOutputStream:write	(I)V
    //   63: goto -46 -> 17
    //   66: aload_3
    //   67: invokevirtual 322	java/io/ByteArrayOutputStream:close	()V
    //   70: aconst_null
    //   71: areturn
    //   72: astore_2
    //   73: aload_3
    //   74: astore_0
    //   75: aload_2
    //   76: astore_3
    //   77: goto +12 -> 89
    //   80: astore_0
    //   81: aconst_null
    //   82: astore_2
    //   83: goto +24 -> 107
    //   86: astore_3
    //   87: aconst_null
    //   88: astore_0
    //   89: aload_0
    //   90: astore_2
    //   91: aload_3
    //   92: invokestatic 289	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   95: pop
    //   96: aload_0
    //   97: ifnull +7 -> 104
    //   100: aload_0
    //   101: invokevirtual 322	java/io/ByteArrayOutputStream:close	()V
    //   104: aconst_null
    //   105: areturn
    //   106: astore_0
    //   107: aload_2
    //   108: ifnull +7 -> 115
    //   111: aload_2
    //   112: invokevirtual 322	java/io/ByteArrayOutputStream:close	()V
    //   115: goto +5 -> 120
    //   118: aload_0
    //   119: athrow
    //   120: goto -2 -> 118
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	paramBufferedInputStream	java.io.BufferedInputStream
    //   23	37	1	i	int
    //   18	40	2	localObject1	Object
    //   72	4	2	localThrowable1	Throwable
    //   82	30	2	localBufferedInputStream	java.io.BufferedInputStream
    //   16	61	3	localObject2	Object
    //   86	6	3	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   19	24	72	java/lang/Throwable
    //   35	50	72	java/lang/Throwable
    //   58	63	72	java/lang/Throwable
    //   6	17	80	finally
    //   6	17	86	java/lang/Throwable
    //   19	24	106	finally
    //   35	50	106	finally
    //   58	63	106	finally
    //   91	96	106	finally
  }
  
  protected static String a(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    String[] arrayOfString = paramString.split("\n");
    String str = paramString;
    if (arrayOfString != null)
    {
      if (arrayOfString.length == 0) {
        return paramString;
      }
      paramString = new StringBuilder();
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        str = arrayOfString[i];
        if (!str.contains("java.lang.Thread.getStackTrace("))
        {
          paramString.append(str);
          paramString.append("\n");
        }
        i += 1;
      }
      str = paramString.toString();
    }
    return str;
  }
  
  /* Error */
  public static String a(String paramString1, int paramInt, String paramString2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: aload_0
    //   7: ifnull +418 -> 425
    //   10: iload_1
    //   11: ifgt +5 -> 16
    //   14: aconst_null
    //   15: areturn
    //   16: new 22	java/io/File
    //   19: dup
    //   20: aload_0
    //   21: invokespecial 338	java/io/File:<init>	(Ljava/lang/String;)V
    //   24: astore 7
    //   26: aload 7
    //   28: invokevirtual 31	java/io/File:exists	()Z
    //   31: ifeq +394 -> 425
    //   34: aload 7
    //   36: invokevirtual 34	java/io/File:canRead	()Z
    //   39: ifne +5 -> 44
    //   42: aconst_null
    //   43: areturn
    //   44: ldc_w 340
    //   47: iconst_2
    //   48: anewarray 4	java/lang/Object
    //   51: dup
    //   52: iconst_0
    //   53: aload 7
    //   55: invokevirtual 343	java/io/File:length	()J
    //   58: invokestatic 346	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   61: aastore
    //   62: dup
    //   63: iconst_1
    //   64: aload 7
    //   66: invokevirtual 349	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   69: aastore
    //   70: invokestatic 351	com/tencent/bugly/proguard/x:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   73: pop
    //   74: getstatic 16	com/tencent/bugly/crashreport/crash/jni/b:a	Ljava/util/List;
    //   77: aload 7
    //   79: invokeinterface 356 2 0
    //   84: pop
    //   85: ldc_w 358
    //   88: iconst_0
    //   89: anewarray 4	java/lang/Object
    //   92: invokestatic 240	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   95: pop
    //   96: aload_2
    //   97: ifnonnull +17 -> 114
    //   100: new 22	java/io/File
    //   103: dup
    //   104: aload_0
    //   105: invokespecial 338	java/io/File:<init>	(Ljava/lang/String;)V
    //   108: iload_1
    //   109: iload_3
    //   110: invokestatic 361	com/tencent/bugly/proguard/z:a	(Ljava/io/File;IZ)Ljava/lang/String;
    //   113: areturn
    //   114: new 160	java/lang/StringBuilder
    //   117: dup
    //   118: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   121: astore 6
    //   123: aload 4
    //   125: astore_0
    //   126: new 363	java/io/BufferedReader
    //   129: dup
    //   130: new 365	java/io/InputStreamReader
    //   133: dup
    //   134: new 38	java/io/FileInputStream
    //   137: dup
    //   138: aload 7
    //   140: invokespecial 41	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   143: ldc_w 367
    //   146: invokespecial 370	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   149: invokespecial 373	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   152: astore 4
    //   154: aload 4
    //   156: invokevirtual 376	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   159: astore_0
    //   160: aload_0
    //   161: ifnull +110 -> 271
    //   164: new 160	java/lang/StringBuilder
    //   167: dup
    //   168: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   171: astore 5
    //   173: aload 5
    //   175: aload_2
    //   176: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: pop
    //   180: aload 5
    //   182: ldc_w 378
    //   185: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   188: pop
    //   189: aload 5
    //   191: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: invokestatic 384	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   197: aload_0
    //   198: invokevirtual 388	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   201: invokevirtual 393	java/util/regex/Matcher:find	()Z
    //   204: ifeq +18 -> 222
    //   207: aload 6
    //   209: aload_0
    //   210: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: pop
    //   214: aload 6
    //   216: ldc 208
    //   218: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: pop
    //   222: iload_1
    //   223: ifle -69 -> 154
    //   226: aload 6
    //   228: invokevirtual 394	java/lang/StringBuilder:length	()I
    //   231: iload_1
    //   232: if_icmple -78 -> 154
    //   235: iload_3
    //   236: ifeq +18 -> 254
    //   239: aload 6
    //   241: iload_1
    //   242: aload 6
    //   244: invokevirtual 394	java/lang/StringBuilder:length	()I
    //   247: invokevirtual 398	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   250: pop
    //   251: goto +20 -> 271
    //   254: aload 6
    //   256: iconst_0
    //   257: aload 6
    //   259: invokevirtual 394	java/lang/StringBuilder:length	()I
    //   262: iload_1
    //   263: isub
    //   264: invokevirtual 398	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   267: pop
    //   268: goto -114 -> 154
    //   271: aload 6
    //   273: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   276: astore_2
    //   277: aload_2
    //   278: astore_0
    //   279: aload 4
    //   281: invokevirtual 399	java/io/BufferedReader:close	()V
    //   284: aload_2
    //   285: areturn
    //   286: astore_2
    //   287: aload_2
    //   288: invokestatic 289	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   291: pop
    //   292: aload_0
    //   293: areturn
    //   294: astore_0
    //   295: goto +109 -> 404
    //   298: astore_0
    //   299: aload 4
    //   301: astore_2
    //   302: aload_0
    //   303: astore 4
    //   305: goto +17 -> 322
    //   308: astore_2
    //   309: aload_0
    //   310: astore 4
    //   312: aload_2
    //   313: astore_0
    //   314: goto +90 -> 404
    //   317: astore 4
    //   319: aload 5
    //   321: astore_2
    //   322: aload_2
    //   323: astore_0
    //   324: aload 4
    //   326: invokestatic 289	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   329: pop
    //   330: aload_2
    //   331: astore_0
    //   332: new 160	java/lang/StringBuilder
    //   335: dup
    //   336: ldc_w 401
    //   339: invokespecial 402	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   342: astore 5
    //   344: aload_2
    //   345: astore_0
    //   346: aload 5
    //   348: aload 4
    //   350: invokevirtual 403	java/lang/Throwable:toString	()Ljava/lang/String;
    //   353: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: pop
    //   357: aload_2
    //   358: astore_0
    //   359: aload 5
    //   361: ldc_w 405
    //   364: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: pop
    //   368: aload_2
    //   369: astore_0
    //   370: aload 6
    //   372: aload 5
    //   374: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   377: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: pop
    //   381: aload_2
    //   382: astore_0
    //   383: aload 6
    //   385: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   388: astore 4
    //   390: aload_2
    //   391: ifnull +10 -> 401
    //   394: aload 4
    //   396: astore_0
    //   397: aload_2
    //   398: invokevirtual 399	java/io/BufferedReader:close	()V
    //   401: aload 4
    //   403: areturn
    //   404: aload 4
    //   406: ifnull +17 -> 423
    //   409: aload 4
    //   411: invokevirtual 399	java/io/BufferedReader:close	()V
    //   414: goto +9 -> 423
    //   417: astore_2
    //   418: aload_2
    //   419: invokestatic 289	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   422: pop
    //   423: aload_0
    //   424: athrow
    //   425: aconst_null
    //   426: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	427	0	paramString1	String
    //   0	427	1	paramInt	int
    //   0	427	2	paramString2	String
    //   0	427	3	paramBoolean	boolean
    //   4	307	4	localObject	Object
    //   317	32	4	localThrowable	Throwable
    //   388	22	4	str	String
    //   1	372	5	localStringBuilder1	StringBuilder
    //   121	263	6	localStringBuilder2	StringBuilder
    //   24	115	7	localFile	File
    // Exception table:
    //   from	to	target	type
    //   279	284	286	java/lang/Exception
    //   397	401	286	java/lang/Exception
    //   154	160	294	finally
    //   164	222	294	finally
    //   226	235	294	finally
    //   239	251	294	finally
    //   254	268	294	finally
    //   271	277	294	finally
    //   154	160	298	java/lang/Throwable
    //   164	222	298	java/lang/Throwable
    //   226	235	298	java/lang/Throwable
    //   239	251	298	java/lang/Throwable
    //   254	268	298	java/lang/Throwable
    //   271	277	298	java/lang/Throwable
    //   126	154	308	finally
    //   324	330	308	finally
    //   332	344	308	finally
    //   346	357	308	finally
    //   359	368	308	finally
    //   370	381	308	finally
    //   383	390	308	finally
    //   126	154	317	java/lang/Throwable
    //   409	414	417	java/lang/Exception
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      String str = b(paramString1, paramString2);
      if ((str != null) && (!str.isEmpty()))
      {
        localStringBuilder.append("Register infos:\n");
        localStringBuilder.append(str);
      }
      paramString1 = c(paramString1, paramString2);
      if ((paramString1 != null) && (!paramString1.isEmpty()))
      {
        if (localStringBuilder.length() > 0) {
          localStringBuilder.append("\n");
        }
        localStringBuilder.append("System SO infos:\n");
        localStringBuilder.append(paramString1);
      }
      return localStringBuilder.toString();
    }
    return null;
  }
  
  public static void a(boolean paramBoolean, String paramString)
  {
    if (paramString != null)
    {
      a.add(new File(paramString, "rqd_record.eup"));
      a.add(new File(paramString, "reg_record.txt"));
      a.add(new File(paramString, "map_record.txt"));
      a.add(new File(paramString, "backup_record.txt"));
      if (paramBoolean) {
        c(paramString);
      }
    }
    paramString = a;
    if ((paramString != null) && (paramString.size() > 0))
    {
      paramString = a.iterator();
      while (paramString.hasNext())
      {
        File localFile = (File)paramString.next();
        if ((localFile.exists()) && (localFile.canWrite()))
        {
          localFile.delete();
          x.c("Delete record file %s", new Object[] { localFile.getAbsoluteFile() });
        }
      }
    }
  }
  
  public static String b(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    paramString = new File(paramString, "backup_record.txt");
    if (paramString.exists()) {
      return paramString.getAbsolutePath();
    }
    return null;
  }
  
  /* Error */
  private static String b(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc_w 418
    //   4: invokestatic 452	com/tencent/bugly/proguard/z:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/io/BufferedReader;
    //   7: astore_0
    //   8: aload_0
    //   9: ifnonnull +5 -> 14
    //   12: aconst_null
    //   13: areturn
    //   14: new 160	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   21: astore 5
    //   23: aload_0
    //   24: invokevirtual 376	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   27: astore 6
    //   29: aload 6
    //   31: ifnull +135 -> 166
    //   34: aload 6
    //   36: aload_1
    //   37: invokevirtual 455	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   40: ifne +197 -> 237
    //   43: goto +123 -> 166
    //   46: aload_0
    //   47: invokevirtual 376	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   50: astore_1
    //   51: aload_1
    //   52: ifnull +82 -> 134
    //   55: iload_3
    //   56: iconst_4
    //   57: irem
    //   58: ifne +27 -> 85
    //   61: iload_3
    //   62: ifle +11 -> 73
    //   65: aload 5
    //   67: ldc 208
    //   69: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: aload 5
    //   75: ldc_w 457
    //   78: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: goto +32 -> 114
    //   85: aload_1
    //   86: invokevirtual 110	java/lang/String:length	()I
    //   89: bipush 16
    //   91: if_icmple +6 -> 97
    //   94: bipush 28
    //   96: istore_2
    //   97: aload 5
    //   99: ldc_w 459
    //   102: iconst_0
    //   103: iload_2
    //   104: iload 4
    //   106: isub
    //   107: invokevirtual 463	java/lang/String:substring	(II)Ljava/lang/String;
    //   110: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: pop
    //   114: aload_1
    //   115: invokevirtual 110	java/lang/String:length	()I
    //   118: istore 4
    //   120: aload 5
    //   122: aload_1
    //   123: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: pop
    //   127: iload_3
    //   128: iconst_1
    //   129: iadd
    //   130: istore_3
    //   131: goto -85 -> 46
    //   134: aload 5
    //   136: ldc 208
    //   138: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: pop
    //   142: aload 5
    //   144: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   147: astore_1
    //   148: aload_0
    //   149: ifnull +15 -> 164
    //   152: aload_0
    //   153: invokevirtual 399	java/io/BufferedReader:close	()V
    //   156: aload_1
    //   157: areturn
    //   158: astore_0
    //   159: aload_0
    //   160: invokestatic 289	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   163: pop
    //   164: aload_1
    //   165: areturn
    //   166: aload_0
    //   167: ifnull +15 -> 182
    //   170: aload_0
    //   171: invokevirtual 399	java/io/BufferedReader:close	()V
    //   174: aconst_null
    //   175: areturn
    //   176: astore_0
    //   177: aload_0
    //   178: invokestatic 289	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   181: pop
    //   182: aconst_null
    //   183: areturn
    //   184: astore_1
    //   185: goto +27 -> 212
    //   188: astore_1
    //   189: aload_1
    //   190: invokestatic 289	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   193: pop
    //   194: aload_0
    //   195: ifnull +15 -> 210
    //   198: aload_0
    //   199: invokevirtual 399	java/io/BufferedReader:close	()V
    //   202: aconst_null
    //   203: areturn
    //   204: astore_0
    //   205: aload_0
    //   206: invokestatic 289	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   209: pop
    //   210: aconst_null
    //   211: areturn
    //   212: aload_0
    //   213: ifnull +16 -> 229
    //   216: aload_0
    //   217: invokevirtual 399	java/io/BufferedReader:close	()V
    //   220: goto +9 -> 229
    //   223: astore_0
    //   224: aload_0
    //   225: invokestatic 289	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   228: pop
    //   229: goto +5 -> 234
    //   232: aload_1
    //   233: athrow
    //   234: goto -2 -> 232
    //   237: iconst_0
    //   238: istore_3
    //   239: bipush 18
    //   241: istore_2
    //   242: iconst_0
    //   243: istore 4
    //   245: goto -199 -> 46
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	248	0	paramString1	String
    //   0	248	1	paramString2	String
    //   96	146	2	i	int
    //   55	184	3	j	int
    //   104	140	4	k	int
    //   21	122	5	localStringBuilder	StringBuilder
    //   27	8	6	str	String
    // Exception table:
    //   from	to	target	type
    //   152	156	158	java/lang/Exception
    //   170	174	176	java/lang/Exception
    //   14	29	184	finally
    //   34	43	184	finally
    //   46	51	184	finally
    //   65	73	184	finally
    //   73	82	184	finally
    //   85	94	184	finally
    //   97	114	184	finally
    //   114	127	184	finally
    //   134	148	184	finally
    //   189	194	184	finally
    //   14	29	188	java/lang/Throwable
    //   34	43	188	java/lang/Throwable
    //   46	51	188	java/lang/Throwable
    //   65	73	188	java/lang/Throwable
    //   73	82	188	java/lang/Throwable
    //   85	94	188	java/lang/Throwable
    //   97	114	188	java/lang/Throwable
    //   114	127	188	java/lang/Throwable
    //   134	148	188	java/lang/Throwable
    //   198	202	204	java/lang/Exception
    //   216	220	223	java/lang/Exception
  }
  
  /* Error */
  private static String c(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc_w 420
    //   4: invokestatic 452	com/tencent/bugly/proguard/z:a	(Ljava/lang/String;Ljava/lang/String;)Ljava/io/BufferedReader;
    //   7: astore_0
    //   8: aload_0
    //   9: ifnonnull +5 -> 14
    //   12: aconst_null
    //   13: areturn
    //   14: new 160	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 161	java/lang/StringBuilder:<init>	()V
    //   21: astore_2
    //   22: aload_0
    //   23: invokevirtual 376	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   26: astore_3
    //   27: aload_3
    //   28: ifnull +70 -> 98
    //   31: aload_3
    //   32: aload_1
    //   33: invokevirtual 455	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   36: ifne +6 -> 42
    //   39: goto +59 -> 98
    //   42: aload_0
    //   43: invokevirtual 376	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   46: astore_1
    //   47: aload_1
    //   48: ifnull +27 -> 75
    //   51: aload_2
    //   52: ldc_w 457
    //   55: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: aload_2
    //   60: aload_1
    //   61: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: aload_2
    //   66: ldc 208
    //   68: invokevirtual 165	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: goto -30 -> 42
    //   75: aload_2
    //   76: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: astore_1
    //   80: aload_0
    //   81: ifnull +15 -> 96
    //   84: aload_0
    //   85: invokevirtual 399	java/io/BufferedReader:close	()V
    //   88: aload_1
    //   89: areturn
    //   90: astore_0
    //   91: aload_0
    //   92: invokestatic 289	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   95: pop
    //   96: aload_1
    //   97: areturn
    //   98: aload_0
    //   99: ifnull +15 -> 114
    //   102: aload_0
    //   103: invokevirtual 399	java/io/BufferedReader:close	()V
    //   106: aconst_null
    //   107: areturn
    //   108: astore_0
    //   109: aload_0
    //   110: invokestatic 289	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   113: pop
    //   114: aconst_null
    //   115: areturn
    //   116: astore_1
    //   117: goto +27 -> 144
    //   120: astore_1
    //   121: aload_1
    //   122: invokestatic 289	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   125: pop
    //   126: aload_0
    //   127: ifnull +15 -> 142
    //   130: aload_0
    //   131: invokevirtual 399	java/io/BufferedReader:close	()V
    //   134: aconst_null
    //   135: areturn
    //   136: astore_0
    //   137: aload_0
    //   138: invokestatic 289	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   141: pop
    //   142: aconst_null
    //   143: areturn
    //   144: aload_0
    //   145: ifnull +16 -> 161
    //   148: aload_0
    //   149: invokevirtual 399	java/io/BufferedReader:close	()V
    //   152: goto +9 -> 161
    //   155: astore_0
    //   156: aload_0
    //   157: invokestatic 289	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   160: pop
    //   161: goto +5 -> 166
    //   164: aload_1
    //   165: athrow
    //   166: goto -2 -> 164
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	169	0	paramString1	String
    //   0	169	1	paramString2	String
    //   21	55	2	localStringBuilder	StringBuilder
    //   26	6	3	str	String
    // Exception table:
    //   from	to	target	type
    //   84	88	90	java/lang/Exception
    //   102	106	108	java/lang/Exception
    //   14	27	116	finally
    //   31	39	116	finally
    //   42	47	116	finally
    //   51	72	116	finally
    //   75	80	116	finally
    //   121	126	116	finally
    //   14	27	120	java/lang/Throwable
    //   31	39	120	java/lang/Throwable
    //   42	47	120	java/lang/Throwable
    //   51	72	120	java/lang/Throwable
    //   75	80	120	java/lang/Throwable
    //   130	134	136	java/lang/Exception
    //   148	152	155	java/lang/Exception
  }
  
  public static void c(String paramString)
  {
    if (paramString == null) {
      return;
    }
    try
    {
      paramString = new File(paramString);
      if ((paramString.canRead()) && (paramString.isDirectory()))
      {
        paramString = paramString.listFiles();
        if (paramString != null)
        {
          int j = paramString.length;
          int i = 0;
          while (i < j)
          {
            Object localObject = paramString[i];
            if ((localObject.canRead()) && (localObject.canWrite()) && (localObject.length() == 0L))
            {
              localObject.delete();
              x.c("Delete empty record file %s", new Object[] { localObject.getAbsoluteFile() });
            }
            i += 1;
          }
        }
      }
      return;
    }
    catch (Throwable paramString)
    {
      x.a(paramString);
    }
  }
  
  private static Map<String, Integer> d(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      HashMap localHashMap = new HashMap();
      String[] arrayOfString1 = paramString.split(",");
      int j = arrayOfString1.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString1[i];
        String[] arrayOfString2 = str.split(":");
        if (arrayOfString2.length != 2)
        {
          x.e("error format at %s", new Object[] { str });
          return null;
        }
        int k = Integer.parseInt(arrayOfString2[1]);
        localHashMap.put(arrayOfString2[0], Integer.valueOf(k));
        i += 1;
      }
      return localHashMap;
    }
    catch (Exception localException)
    {
      x.e("error format intStateStr %s", new Object[] { paramString });
      localException.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.bugly.crashreport.crash.jni.b
 * JD-Core Version:    0.7.0.1
 */
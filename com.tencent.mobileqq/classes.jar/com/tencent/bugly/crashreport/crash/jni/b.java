package com.tencent.bugly.crashreport.crash.jni;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.bugly.crashreport.common.info.a;
import com.tencent.bugly.crashreport.crash.CrashDetailBean;
import com.tencent.bugly.proguard.x;
import com.tencent.bugly.proguard.z;
import java.io.BufferedReader;
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
    //   1: ifnull +11 -> 12
    //   4: aload_1
    //   5: ifnull +7 -> 12
    //   8: aload_2
    //   9: ifnonnull +15 -> 24
    //   12: ldc 22
    //   14: iconst_0
    //   15: anewarray 4	java/lang/Object
    //   18: invokestatic 28	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   21: pop
    //   22: aconst_null
    //   23: areturn
    //   24: new 30	java/io/File
    //   27: dup
    //   28: aload_1
    //   29: ldc 32
    //   31: invokespecial 35	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   34: astore_1
    //   35: aload_1
    //   36: invokevirtual 39	java/io/File:exists	()Z
    //   39: ifeq -17 -> 22
    //   42: aload_1
    //   43: invokevirtual 42	java/io/File:canRead	()Z
    //   46: ifeq -24 -> 22
    //   49: new 44	java/io/BufferedInputStream
    //   52: dup
    //   53: new 46	java/io/FileInputStream
    //   56: dup
    //   57: aload_1
    //   58: invokespecial 49	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   61: invokespecial 52	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   64: astore 4
    //   66: aload 4
    //   68: astore_1
    //   69: aload 4
    //   71: invokestatic 55	com/tencent/bugly/crashreport/crash/jni/b:a	(Ljava/io/BufferedInputStream;)Ljava/lang/String;
    //   74: astore_3
    //   75: aload_3
    //   76: ifnull +15 -> 91
    //   79: aload 4
    //   81: astore_1
    //   82: aload_3
    //   83: ldc 57
    //   85: invokevirtual 63	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   88: ifne +34 -> 122
    //   91: aload 4
    //   93: astore_1
    //   94: ldc 65
    //   96: iconst_1
    //   97: anewarray 4	java/lang/Object
    //   100: dup
    //   101: iconst_0
    //   102: aload_3
    //   103: aastore
    //   104: invokestatic 28	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   107: pop
    //   108: aload 4
    //   110: invokevirtual 68	java/io/BufferedInputStream:close	()V
    //   113: aconst_null
    //   114: areturn
    //   115: astore_0
    //   116: aload_0
    //   117: invokevirtual 71	java/io/IOException:printStackTrace	()V
    //   120: aconst_null
    //   121: areturn
    //   122: aload 4
    //   124: astore_1
    //   125: new 73	java/util/HashMap
    //   128: dup
    //   129: invokespecial 74	java/util/HashMap:<init>	()V
    //   132: astore 6
    //   134: aconst_null
    //   135: astore_3
    //   136: aload 4
    //   138: astore_1
    //   139: aload 4
    //   141: invokestatic 55	com/tencent/bugly/crashreport/crash/jni/b:a	(Ljava/io/BufferedInputStream;)Ljava/lang/String;
    //   144: astore 5
    //   146: aload 5
    //   148: ifnull +32 -> 180
    //   151: aload_3
    //   152: ifnonnull +9 -> 161
    //   155: aload 5
    //   157: astore_3
    //   158: goto -22 -> 136
    //   161: aload 4
    //   163: astore_1
    //   164: aload 6
    //   166: aload_3
    //   167: aload 5
    //   169: invokeinterface 80 3 0
    //   174: pop
    //   175: aconst_null
    //   176: astore_3
    //   177: goto -41 -> 136
    //   180: aload_3
    //   181: ifnull +34 -> 215
    //   184: aload 4
    //   186: astore_1
    //   187: ldc 82
    //   189: iconst_1
    //   190: anewarray 4	java/lang/Object
    //   193: dup
    //   194: iconst_0
    //   195: aload_3
    //   196: aastore
    //   197: invokestatic 28	com/tencent/bugly/proguard/x:e	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   200: pop
    //   201: aload 4
    //   203: invokevirtual 68	java/io/BufferedInputStream:close	()V
    //   206: aconst_null
    //   207: areturn
    //   208: astore_0
    //   209: aload_0
    //   210: invokevirtual 71	java/io/IOException:printStackTrace	()V
    //   213: aconst_null
    //   214: areturn
    //   215: aload 4
    //   217: astore_1
    //   218: aload_0
    //   219: aload 6
    //   221: aload_2
    //   222: invokestatic 85	com/tencent/bugly/crashreport/crash/jni/b:a	(Landroid/content/Context;Ljava/util/Map;Lcom/tencent/bugly/crashreport/crash/jni/NativeExceptionHandler;)Lcom/tencent/bugly/crashreport/crash/CrashDetailBean;
    //   225: astore_0
    //   226: aload 4
    //   228: invokevirtual 68	java/io/BufferedInputStream:close	()V
    //   231: aload_0
    //   232: areturn
    //   233: astore_1
    //   234: aload_1
    //   235: invokevirtual 71	java/io/IOException:printStackTrace	()V
    //   238: aload_0
    //   239: areturn
    //   240: astore_2
    //   241: aconst_null
    //   242: astore_0
    //   243: aload_0
    //   244: astore_1
    //   245: aload_2
    //   246: invokevirtual 71	java/io/IOException:printStackTrace	()V
    //   249: aload_0
    //   250: ifnull -228 -> 22
    //   253: aload_0
    //   254: invokevirtual 68	java/io/BufferedInputStream:close	()V
    //   257: aconst_null
    //   258: areturn
    //   259: astore_0
    //   260: aload_0
    //   261: invokevirtual 71	java/io/IOException:printStackTrace	()V
    //   264: aconst_null
    //   265: areturn
    //   266: astore_0
    //   267: aconst_null
    //   268: astore_1
    //   269: aload_1
    //   270: ifnull +7 -> 277
    //   273: aload_1
    //   274: invokevirtual 68	java/io/BufferedInputStream:close	()V
    //   277: aload_0
    //   278: athrow
    //   279: astore_1
    //   280: aload_1
    //   281: invokevirtual 71	java/io/IOException:printStackTrace	()V
    //   284: goto -7 -> 277
    //   287: astore_0
    //   288: goto -19 -> 269
    //   291: astore_2
    //   292: aload 4
    //   294: astore_0
    //   295: goto -52 -> 243
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	298	0	paramContext	Context
    //   0	298	1	paramString	String
    //   0	298	2	paramNativeExceptionHandler	NativeExceptionHandler
    //   74	122	3	localObject	Object
    //   64	229	4	localBufferedInputStream	java.io.BufferedInputStream
    //   144	24	5	str	String
    //   132	88	6	localHashMap	HashMap
    // Exception table:
    //   from	to	target	type
    //   108	113	115	java/io/IOException
    //   201	206	208	java/io/IOException
    //   226	231	233	java/io/IOException
    //   49	66	240	java/io/IOException
    //   253	257	259	java/io/IOException
    //   49	66	266	finally
    //   273	277	279	java/io/IOException
    //   69	75	287	finally
    //   82	91	287	finally
    //   94	108	287	finally
    //   125	134	287	finally
    //   139	146	287	finally
    //   164	175	287	finally
    //   187	201	287	finally
    //   218	226	287	finally
    //   245	249	287	finally
    //   69	75	291	java/io/IOException
    //   82	91	291	java/io/IOException
    //   94	108	291	java/io/IOException
    //   125	134	291	java/io/IOException
    //   139	146	291	java/io/IOException
    //   164	175	291	java/io/IOException
    //   187	201	291	java/io/IOException
    //   218	226	291	java/io/IOException
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
    if ((paramContext == null) || (paramContext.trim().length() <= 0))
    {
      x.e("no intStateStr", new Object[0]);
      return null;
    }
    Map localMap = d(paramContext);
    if (localMap == null)
    {
      x.e("parse intSateMap fail", new Object[] { Integer.valueOf(paramMap.size()) });
      return null;
    }
    label1082:
    label1085:
    label1092:
    label1095:
    label1098:
    label1101:
    label1104:
    for (;;)
    {
      int i;
      try
      {
        ((Integer)localMap.get("sino")).intValue();
        ((Integer)localMap.get("sud")).intValue();
        String str3 = (String)paramMap.get("soVersion");
        if (TextUtils.isEmpty(str3))
        {
          x.e("error format at version", new Object[0]);
          return null;
        }
        String str1 = (String)paramMap.get("errorAddr");
        if (str1 != null) {
          break label1092;
        }
        str1 = "unknown";
        paramContext = (String)paramMap.get("codeMsg");
        if (paramContext != null) {
          break label1095;
        }
        paramContext = "unknown";
        String str2 = (String)paramMap.get("tombPath");
        if (str2 != null) {
          break label1098;
        }
        str2 = "unknown";
        Object localObject1 = (String)paramMap.get("signalName");
        if (localObject1 != null) {
          break label1101;
        }
        localObject1 = "unknown";
        paramMap.get("errnoMsg");
        Object localObject2 = (String)paramMap.get("stack");
        if (localObject2 != null) {
          break label1104;
        }
        localObject2 = "unknown";
        Object localObject4 = (String)paramMap.get("jstack");
        Object localObject3 = localObject2;
        if (localObject4 != null) {
          localObject3 = (String)localObject2 + "java:\n" + (String)localObject4;
        }
        Object localObject5 = (Integer)localMap.get("sico");
        localObject4 = localObject1;
        localObject2 = paramContext;
        if (localObject5 != null)
        {
          localObject4 = localObject1;
          localObject2 = paramContext;
          if (((Integer)localObject5).intValue() > 0)
          {
            localObject4 = (String)localObject1 + "(" + paramContext + ")";
            localObject2 = "KERNEL";
          }
        }
        localObject5 = (String)paramMap.get("nativeLog");
        paramContext = null;
        localObject1 = paramContext;
        if (localObject5 != null)
        {
          localObject1 = paramContext;
          if (!((String)localObject5).isEmpty()) {
            localObject1 = z.a(null, (String)localObject5, "BuglyNativeLog.txt");
          }
        }
        paramContext = (String)paramMap.get("sendingProcess");
        if (paramContext != null) {
          break label1082;
        }
        paramContext = "unknown";
        Object localObject6 = (Integer)localMap.get("spd");
        localObject5 = paramContext;
        if (localObject6 != null) {
          localObject5 = paramContext + "(" + localObject6 + ")";
        }
        paramContext = (String)paramMap.get("threadName");
        if (paramContext == null)
        {
          paramContext = "unknown";
          Object localObject7 = (Integer)localMap.get("et");
          localObject6 = paramContext;
          if (localObject7 != null) {
            localObject6 = paramContext + "(" + localObject7 + ")";
          }
          paramContext = (String)paramMap.get("processName");
          if (paramContext == null)
          {
            paramContext = "unknown";
            Object localObject8 = (Integer)localMap.get("ep");
            localObject7 = paramContext;
            if (localObject8 != null) {
              localObject7 = paramContext + "(" + localObject8 + ")";
            }
            paramContext = null;
            Object localObject9 = (String)paramMap.get("key-value");
            if (localObject9 != null)
            {
              localObject8 = new HashMap();
              localObject9 = ((String)localObject9).split("\n");
              int j = localObject9.length;
              i = 0;
              paramContext = (Context)localObject8;
              if (i < j)
              {
                paramContext = localObject9[i].split("=");
                if (paramContext.length != 2) {
                  break label1085;
                }
                ((Map)localObject8).put(paramContext[0], paramContext[1]);
                break label1085;
              }
            }
            long l = ((Integer)localMap.get("ets")).intValue();
            paramContext = paramNativeExceptionHandler.packageCrashDatas((String)localObject7, (String)localObject6, ((Integer)localMap.get("etms")).intValue() / 1000L + l * 1000L, (String)localObject4, str1, a((String)localObject3), (String)localObject2, (String)localObject5, str2, (String)paramMap.get("sysLogPath"), (String)paramMap.get("jniLogPath"), str3, (byte[])localObject1, paramContext, false, false);
            if (paramContext == null) {
              break;
            }
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
            if (paramMap != null) {
              x.c("[Native record info] launchTime: %s", new Object[] { paramMap });
            }
            try
            {
              paramContext.M = Long.parseLong(paramMap);
              paramContext.z = null;
              paramContext.k = true;
            }
            catch (NumberFormatException paramMap)
            {
              if (x.a(paramMap)) {
                continue;
              }
              paramMap.printStackTrace();
              continue;
            }
          }
          continue;
        }
      }
      catch (Throwable paramContext)
      {
        x.e("error format", new Object[0]);
        paramContext.printStackTrace();
        return null;
      }
      continue;
      continue;
      i += 1;
      continue;
      continue;
      continue;
      continue;
    }
    return paramContext;
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
    //   26: if_icmpeq +62 -> 88
    //   29: iload_1
    //   30: ifne +26 -> 56
    //   33: aload_3
    //   34: astore_2
    //   35: new 59	java/lang/String
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
    //   66: astore_2
    //   67: aload_3
    //   68: astore_0
    //   69: aload_2
    //   70: astore_3
    //   71: aload_0
    //   72: astore_2
    //   73: aload_3
    //   74: invokestatic 298	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   77: pop
    //   78: aload_0
    //   79: ifnull -75 -> 4
    //   82: aload_0
    //   83: invokevirtual 322	java/io/ByteArrayOutputStream:close	()V
    //   86: aconst_null
    //   87: areturn
    //   88: aload_3
    //   89: invokevirtual 322	java/io/ByteArrayOutputStream:close	()V
    //   92: aconst_null
    //   93: areturn
    //   94: astore_0
    //   95: aconst_null
    //   96: astore_2
    //   97: aload_2
    //   98: ifnull +7 -> 105
    //   101: aload_2
    //   102: invokevirtual 322	java/io/ByteArrayOutputStream:close	()V
    //   105: aload_0
    //   106: athrow
    //   107: astore_0
    //   108: goto -11 -> 97
    //   111: astore_3
    //   112: aconst_null
    //   113: astore_0
    //   114: goto -43 -> 71
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	paramBufferedInputStream	java.io.BufferedInputStream
    //   23	37	1	i	int
    //   18	40	2	localObject1	Object
    //   66	4	2	localThrowable1	Throwable
    //   72	30	2	localBufferedInputStream	java.io.BufferedInputStream
    //   16	73	3	localObject2	Object
    //   111	1	3	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   19	24	66	java/lang/Throwable
    //   35	50	66	java/lang/Throwable
    //   58	63	66	java/lang/Throwable
    //   6	17	94	finally
    //   19	24	107	finally
    //   35	50	107	finally
    //   58	63	107	finally
    //   73	78	107	finally
    //   6	17	111	java/lang/Throwable
  }
  
  protected static String a(String paramString)
  {
    String str;
    if (paramString == null) {
      str = "";
    }
    String[] arrayOfString;
    do
    {
      do
      {
        return str;
        arrayOfString = paramString.split("\n");
        str = paramString;
      } while (arrayOfString == null);
      str = paramString;
    } while (arrayOfString.length == 0);
    paramString = new StringBuilder();
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      str = arrayOfString[i];
      if (!str.contains("java.lang.Thread.getStackTrace(")) {
        paramString.append(str).append("\n");
      }
      i += 1;
    }
    return paramString.toString();
  }
  
  /* Error */
  public static String a(String paramString1, int paramInt, String paramString2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload 5
    //   5: astore 4
    //   7: aload_0
    //   8: ifnull +11 -> 19
    //   11: iload_1
    //   12: ifgt +10 -> 22
    //   15: aload 5
    //   17: astore 4
    //   19: aload 4
    //   21: areturn
    //   22: new 30	java/io/File
    //   25: dup
    //   26: aload_0
    //   27: invokespecial 338	java/io/File:<init>	(Ljava/lang/String;)V
    //   30: astore 6
    //   32: aload 5
    //   34: astore 4
    //   36: aload 6
    //   38: invokevirtual 39	java/io/File:exists	()Z
    //   41: ifeq -22 -> 19
    //   44: aload 5
    //   46: astore 4
    //   48: aload 6
    //   50: invokevirtual 42	java/io/File:canRead	()Z
    //   53: ifeq -34 -> 19
    //   56: ldc_w 340
    //   59: iconst_2
    //   60: anewarray 4	java/lang/Object
    //   63: dup
    //   64: iconst_0
    //   65: aload 6
    //   67: invokevirtual 343	java/io/File:length	()J
    //   70: invokestatic 346	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   73: aastore
    //   74: dup
    //   75: iconst_1
    //   76: aload 6
    //   78: invokevirtual 349	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   81: aastore
    //   82: invokestatic 351	com/tencent/bugly/proguard/x:a	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   85: pop
    //   86: getstatic 16	com/tencent/bugly/crashreport/crash/jni/b:a	Ljava/util/List;
    //   89: aload 6
    //   91: invokeinterface 356 2 0
    //   96: pop
    //   97: ldc_w 358
    //   100: iconst_0
    //   101: anewarray 4	java/lang/Object
    //   104: invokestatic 242	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   107: pop
    //   108: aload_2
    //   109: ifnonnull +17 -> 126
    //   112: new 30	java/io/File
    //   115: dup
    //   116: aload_0
    //   117: invokespecial 338	java/io/File:<init>	(Ljava/lang/String;)V
    //   120: iload_1
    //   121: iload_3
    //   122: invokestatic 361	com/tencent/bugly/proguard/z:a	(Ljava/io/File;IZ)Ljava/lang/String;
    //   125: areturn
    //   126: new 162	java/lang/StringBuilder
    //   129: dup
    //   130: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   133: astore 5
    //   135: new 363	java/io/BufferedReader
    //   138: dup
    //   139: new 365	java/io/InputStreamReader
    //   142: dup
    //   143: new 46	java/io/FileInputStream
    //   146: dup
    //   147: aload 6
    //   149: invokespecial 49	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   152: ldc_w 367
    //   155: invokespecial 370	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   158: invokespecial 373	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   161: astore 4
    //   163: aload 4
    //   165: astore_0
    //   166: aload 4
    //   168: invokevirtual 376	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   171: astore 6
    //   173: aload 6
    //   175: ifnull +91 -> 266
    //   178: aload 4
    //   180: astore_0
    //   181: new 162	java/lang/StringBuilder
    //   184: dup
    //   185: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   188: aload_2
    //   189: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: ldc_w 378
    //   195: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: invokestatic 384	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   204: aload 6
    //   206: invokevirtual 388	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   209: invokevirtual 393	java/util/regex/Matcher:find	()Z
    //   212: ifeq +19 -> 231
    //   215: aload 4
    //   217: astore_0
    //   218: aload 5
    //   220: aload 6
    //   222: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: ldc 210
    //   227: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: pop
    //   231: iload_1
    //   232: ifle -69 -> 163
    //   235: aload 4
    //   237: astore_0
    //   238: aload 5
    //   240: invokevirtual 394	java/lang/StringBuilder:length	()I
    //   243: iload_1
    //   244: if_icmple -81 -> 163
    //   247: iload_3
    //   248: ifeq +42 -> 290
    //   251: aload 4
    //   253: astore_0
    //   254: aload 5
    //   256: iload_1
    //   257: aload 5
    //   259: invokevirtual 394	java/lang/StringBuilder:length	()I
    //   262: invokevirtual 398	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   265: pop
    //   266: aload 4
    //   268: astore_0
    //   269: aload 5
    //   271: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   274: astore_2
    //   275: aload 4
    //   277: invokevirtual 399	java/io/BufferedReader:close	()V
    //   280: aload_2
    //   281: areturn
    //   282: astore_0
    //   283: aload_0
    //   284: invokestatic 298	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   287: pop
    //   288: aload_2
    //   289: areturn
    //   290: aload 4
    //   292: astore_0
    //   293: aload 5
    //   295: iconst_0
    //   296: aload 5
    //   298: invokevirtual 394	java/lang/StringBuilder:length	()I
    //   301: iload_1
    //   302: isub
    //   303: invokevirtual 398	java/lang/StringBuilder:delete	(II)Ljava/lang/StringBuilder;
    //   306: pop
    //   307: goto -144 -> 163
    //   310: astore_0
    //   311: aload 4
    //   313: astore_2
    //   314: aload_0
    //   315: astore 4
    //   317: aload_2
    //   318: astore_0
    //   319: aload 4
    //   321: invokestatic 298	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   324: pop
    //   325: aload_2
    //   326: astore_0
    //   327: aload 5
    //   329: new 162	java/lang/StringBuilder
    //   332: dup
    //   333: ldc_w 401
    //   336: invokespecial 402	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   339: aload 4
    //   341: invokevirtual 403	java/lang/Throwable:toString	()Ljava/lang/String;
    //   344: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   347: ldc_w 405
    //   350: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   356: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: invokevirtual 172	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   362: astore 4
    //   364: aload 4
    //   366: astore_0
    //   367: aload_0
    //   368: astore 4
    //   370: aload_2
    //   371: ifnull -352 -> 19
    //   374: aload_2
    //   375: invokevirtual 399	java/io/BufferedReader:close	()V
    //   378: aload_0
    //   379: areturn
    //   380: astore_2
    //   381: aload_2
    //   382: invokestatic 298	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   385: pop
    //   386: aload_0
    //   387: areturn
    //   388: astore_2
    //   389: aconst_null
    //   390: astore_0
    //   391: aload_0
    //   392: ifnull +7 -> 399
    //   395: aload_0
    //   396: invokevirtual 399	java/io/BufferedReader:close	()V
    //   399: aload_2
    //   400: athrow
    //   401: astore_0
    //   402: aload_0
    //   403: invokestatic 298	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   406: pop
    //   407: goto -8 -> 399
    //   410: astore_2
    //   411: goto -20 -> 391
    //   414: astore 4
    //   416: aconst_null
    //   417: astore_2
    //   418: goto -101 -> 317
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	421	0	paramString1	String
    //   0	421	1	paramInt	int
    //   0	421	2	paramString2	String
    //   0	421	3	paramBoolean	boolean
    //   5	364	4	localObject1	Object
    //   414	1	4	localThrowable	Throwable
    //   1	327	5	localStringBuilder	StringBuilder
    //   30	191	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   275	280	282	java/lang/Exception
    //   166	173	310	java/lang/Throwable
    //   181	215	310	java/lang/Throwable
    //   218	231	310	java/lang/Throwable
    //   238	247	310	java/lang/Throwable
    //   254	266	310	java/lang/Throwable
    //   269	275	310	java/lang/Throwable
    //   293	307	310	java/lang/Throwable
    //   374	378	380	java/lang/Exception
    //   135	163	388	finally
    //   395	399	401	java/lang/Exception
    //   166	173	410	finally
    //   181	215	410	finally
    //   218	231	410	finally
    //   238	247	410	finally
    //   254	266	410	finally
    //   269	275	410	finally
    //   293	307	410	finally
    //   319	325	410	finally
    //   327	364	410	finally
    //   135	163	414	java/lang/Throwable
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return null;
    }
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
    if ((a != null) && (a.size() > 0))
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
    if (paramString == null) {}
    do
    {
      return null;
      paramString = new File(paramString, "backup_record.txt");
    } while (!paramString.exists());
    return paramString.getAbsolutePath();
  }
  
  private static String b(String paramString1, String paramString2)
  {
    Object localObject = null;
    BufferedReader localBufferedReader = z.a(paramString1, "reg_record.txt");
    if (localBufferedReader == null) {
      paramString2 = localObject;
    }
    for (;;)
    {
      return paramString2;
      try
      {
        paramString1 = new StringBuilder();
        String str = localBufferedReader.readLine();
        if (str != null)
        {
          boolean bool = str.startsWith(paramString2);
          if (bool) {}
        }
        else
        {
          paramString2 = localObject;
          if (localBufferedReader == null) {
            continue;
          }
          try
          {
            localBufferedReader.close();
            return null;
          }
          catch (Exception paramString1)
          {
            x.a(paramString1);
            return null;
          }
        }
        int k = 0;
        int i = 18;
        int j = 0;
        paramString2 = localBufferedReader.readLine();
        if (paramString2 != null)
        {
          if (j % 4 == 0)
          {
            if (j > 0) {
              paramString1.append("\n");
            }
            paramString1.append("  ");
          }
          for (;;)
          {
            k = paramString2.length();
            paramString1.append(paramString2);
            j += 1;
            break;
            if (paramString2.length() > 16) {
              i = 28;
            }
            paramString1.append("                ".substring(0, i - k));
          }
        }
      }
      catch (Throwable paramString1)
      {
        x.a(paramString1);
        paramString2 = localObject;
        if (localBufferedReader != null)
        {
          try
          {
            localBufferedReader.close();
            return null;
          }
          catch (Exception paramString1)
          {
            x.a(paramString1);
            return null;
          }
          paramString1.append("\n");
          paramString1 = paramString1.toString();
          paramString2 = paramString1;
          if (localBufferedReader != null) {
            try
            {
              localBufferedReader.close();
              return paramString1;
            }
            catch (Exception paramString2)
            {
              x.a(paramString2);
              return paramString1;
            }
          }
        }
      }
      finally
      {
        if (localBufferedReader == null) {}
      }
    }
    try
    {
      localBufferedReader.close();
      throw paramString1;
    }
    catch (Exception paramString2)
    {
      for (;;)
      {
        x.a(paramString2);
      }
    }
  }
  
  private static String c(String paramString1, String paramString2)
  {
    Object localObject = null;
    BufferedReader localBufferedReader = z.a(paramString1, "map_record.txt");
    if (localBufferedReader == null) {
      paramString2 = localObject;
    }
    for (;;)
    {
      return paramString2;
      try
      {
        paramString1 = new StringBuilder();
        String str = localBufferedReader.readLine();
        if (str != null)
        {
          boolean bool = str.startsWith(paramString2);
          if (bool) {}
        }
        else
        {
          paramString2 = localObject;
          if (localBufferedReader == null) {
            continue;
          }
          try
          {
            localBufferedReader.close();
            return null;
          }
          catch (Exception paramString1)
          {
            x.a(paramString1);
            return null;
          }
        }
        for (;;)
        {
          paramString2 = localBufferedReader.readLine();
          if (paramString2 == null) {
            break;
          }
          paramString1.append("  ");
          paramString1.append(paramString2);
          paramString1.append("\n");
        }
      }
      catch (Throwable paramString1)
      {
        x.a(paramString1);
        paramString2 = localObject;
        if (localBufferedReader != null)
        {
          try
          {
            localBufferedReader.close();
            return null;
          }
          catch (Exception paramString1)
          {
            x.a(paramString1);
            return null;
          }
          paramString1 = paramString1.toString();
          paramString2 = paramString1;
          if (localBufferedReader != null) {
            try
            {
              localBufferedReader.close();
              return paramString1;
            }
            catch (Exception paramString2)
            {
              x.a(paramString2);
              return paramString1;
            }
          }
        }
      }
      finally
      {
        if (localBufferedReader == null) {}
      }
    }
    try
    {
      localBufferedReader.close();
      throw paramString1;
    }
    catch (Exception paramString2)
    {
      for (;;)
      {
        x.a(paramString2);
      }
    }
  }
  
  public static void c(String paramString)
  {
    int i = 0;
    if (paramString == null) {}
    for (;;)
    {
      return;
      try
      {
        paramString = new File(paramString);
        if ((!paramString.canRead()) || (!paramString.isDirectory())) {
          continue;
        }
        paramString = paramString.listFiles();
        if (paramString == null) {
          continue;
        }
        int j = paramString.length;
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
        return;
      }
      catch (Throwable paramString)
      {
        x.a(paramString);
      }
    }
  }
  
  private static Map<String, Integer> d(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    for (;;)
    {
      int i;
      String[] arrayOfString2;
      try
      {
        HashMap localHashMap = new HashMap();
        String[] arrayOfString1 = paramString.split(",");
        int j = arrayOfString1.length;
        i = 0;
        if (i >= j) {
          break;
        }
        String str = arrayOfString1[i];
        arrayOfString2 = str.split(":");
        if (arrayOfString2.length != 2)
        {
          x.e("error format at %s", new Object[] { str });
          return null;
        }
      }
      catch (Exception localException)
      {
        x.e("error format intStateStr %s", new Object[] { paramString });
        localException.printStackTrace();
        return null;
      }
      int k = Integer.parseInt(arrayOfString2[1]);
      localException.put(arrayOfString2[0], Integer.valueOf(k));
      i += 1;
    }
    return localException;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.bugly.crashreport.crash.jni.b
 * JD-Core Version:    0.7.0.1
 */
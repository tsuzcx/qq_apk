package com.tencent.luggage.wxa.qz;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Debug.MemoryInfo;
import android.os.Process;
import android.os.SystemClock;
import java.io.Closeable;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class af
{
  public static final long[] a = { 300L, 200L, 300L, 200L };
  private static final long[] b = { 300L, 50L, 300L, 50L };
  private static final TimeZone c = TimeZone.getTimeZone("GMT");
  private static final BigInteger d = BigInteger.ONE.shiftLeft(64);
  private static final char[] e = { 60, 62, 34, 39, 38, 13, 10, 32, 9 };
  private static final String[] f = { "&lt;", "&gt;", "&quot;", "&apos;", "&amp;", "&#x0D;", "&#x0A;", "&#x20;", "&#x09;" };
  
  public static float a(String paramString, float paramFloat)
  {
    if (paramString == null) {
      return paramFloat;
    }
    try
    {
      float f1 = Float.parseFloat(paramString);
      return f1;
    }
    catch (NumberFormatException paramString)
    {
      o.a("MicroMsg.Util", paramString, "", new Object[0]);
    }
    return paramFloat;
  }
  
  public static int a(Context paramContext)
  {
    if (paramContext == null)
    {
      o.d("MicroMsg.Util", "getSelfMemInMB context is null.");
      return -1;
    }
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getProcessMemoryInfo(new int[] { Process.myPid() });
    if ((paramContext != null) && (paramContext.length > 0)) {
      return paramContext[0].getTotalPss() / 1024;
    }
    return 0;
  }
  
  public static int a(Integer paramInteger, int paramInt)
  {
    if (paramInteger == null) {
      return paramInt;
    }
    return paramInteger.intValue();
  }
  
  public static int a(String paramString, int paramInt)
  {
    if (paramString != null) {
      try
      {
        if (paramString.length() <= 0) {
          return paramInt;
        }
        int i = Integer.decode(paramString).intValue();
        return i;
      }
      catch (NumberFormatException paramString)
      {
        o.a("MicroMsg.Util", paramString, "", new Object[0]);
      }
    }
    return paramInt;
  }
  
  public static long a()
  {
    return System.currentTimeMillis() / 1000L;
  }
  
  public static long a(String paramString, long paramLong)
  {
    if (paramString != null) {
      try
      {
        if (paramString.length() <= 0) {
          return paramLong;
        }
        long l = Long.decode(paramString).longValue();
        return l;
      }
      catch (NumberFormatException paramString)
      {
        o.a("MicroMsg.Util", paramString, "", new Object[0]);
      }
    }
    return paramLong;
  }
  
  public static ActivityManager.RunningTaskInfo a(Context paramContext, int paramInt)
  {
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1000).iterator();
    while (paramContext.hasNext())
    {
      ActivityManager.RunningTaskInfo localRunningTaskInfo = (ActivityManager.RunningTaskInfo)paramContext.next();
      if (localRunningTaskInfo.id == paramInt) {
        return localRunningTaskInfo;
      }
    }
    return null;
  }
  
  public static String a(long paramLong)
  {
    return a(paramLong, 10.0D);
  }
  
  public static String a(long paramLong, double paramDouble)
  {
    if (paramLong >> 30 > 0L) {
      return c(paramLong, paramDouble);
    }
    if (paramLong >> 20 > 0L) {
      return b(paramLong, paramDouble);
    }
    if (paramLong >> 9 > 0L)
    {
      double d1 = paramLong;
      Double.isNaN(d1);
      d1 = Math.round(d1 * paramDouble / 1024.0D);
      Double.isNaN(d1);
      paramDouble = d1 / paramDouble;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramDouble);
      localStringBuilder.append(" KB");
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(" B");
    return localStringBuilder.toString();
  }
  
  /* Error */
  public static String a(java.io.InputStream paramInputStream)
  {
    // Byte code:
    //   0: new 241	java/io/BufferedReader
    //   3: dup
    //   4: new 243	java/io/InputStreamReader
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 246	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   12: invokespecial 249	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   15: astore_2
    //   16: new 215	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   23: astore_1
    //   24: aload_2
    //   25: invokevirtual 252	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   28: astore_3
    //   29: aload_3
    //   30: ifnull +40 -> 70
    //   33: new 215	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   40: astore 4
    //   42: aload 4
    //   44: aload_3
    //   45: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: aload 4
    //   51: ldc 254
    //   53: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload_1
    //   58: aload 4
    //   60: invokevirtual 231	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: goto -43 -> 24
    //   70: aload_0
    //   71: invokevirtual 259	java/io/InputStream:close	()V
    //   74: goto +56 -> 130
    //   77: astore_0
    //   78: ldc 93
    //   80: aload_0
    //   81: ldc 95
    //   83: iconst_0
    //   84: anewarray 4	java/lang/Object
    //   87: invokestatic 100	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   90: goto +40 -> 130
    //   93: astore_1
    //   94: goto +41 -> 135
    //   97: astore_2
    //   98: ldc 93
    //   100: aload_2
    //   101: ldc 95
    //   103: iconst_0
    //   104: anewarray 4	java/lang/Object
    //   107: invokestatic 100	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   110: aload_0
    //   111: invokevirtual 259	java/io/InputStream:close	()V
    //   114: goto +16 -> 130
    //   117: astore_0
    //   118: ldc 93
    //   120: aload_0
    //   121: ldc 95
    //   123: iconst_0
    //   124: anewarray 4	java/lang/Object
    //   127: invokestatic 100	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   130: aload_1
    //   131: invokevirtual 231	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: areturn
    //   135: aload_0
    //   136: invokevirtual 259	java/io/InputStream:close	()V
    //   139: goto +16 -> 155
    //   142: astore_0
    //   143: ldc 93
    //   145: aload_0
    //   146: ldc 95
    //   148: iconst_0
    //   149: anewarray 4	java/lang/Object
    //   152: invokestatic 100	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   155: goto +5 -> 160
    //   158: aload_1
    //   159: athrow
    //   160: goto -2 -> 158
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	163	0	paramInputStream	java.io.InputStream
    //   23	35	1	localStringBuilder1	StringBuilder
    //   93	66	1	localObject	Object
    //   15	10	2	localBufferedReader	java.io.BufferedReader
    //   97	4	2	localIOException	IOException
    //   28	17	3	str	String
    //   40	19	4	localStringBuilder2	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   70	74	77	java/io/IOException
    //   24	29	93	finally
    //   33	67	93	finally
    //   98	110	93	finally
    //   24	29	97	java/io/IOException
    //   33	67	97	java/io/IOException
    //   110	114	117	java/io/IOException
    //   135	139	142	java/io/IOException
  }
  
  public static String a(Object paramObject)
  {
    if (paramObject != null) {
      return paramObject.toString();
    }
    return "null";
  }
  
  public static String a(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (paramString1 == null) {
      str = paramString2;
    }
    return str;
  }
  
  public static String a(Throwable paramThrowable)
  {
    return u.a(paramThrowable);
  }
  
  public static void a(Closeable paramCloseable)
  {
    if (paramCloseable != null) {
      try
      {
        paramCloseable.close();
        return;
      }
      catch (IOException paramCloseable)
      {
        o.a("MicroMsg.Util", paramCloseable, "qualityClose", new Object[0]);
      }
    }
  }
  
  public static boolean a(Context paramContext, Intent paramIntent)
  {
    paramContext = paramContext.getPackageManager().queryIntentActivities(paramIntent, 65536);
    return (paramContext != null) && (paramContext.size() > 0);
  }
  
  public static boolean a(CharSequence paramCharSequence)
  {
    return (paramCharSequence == null) || (paramCharSequence.length() <= 0);
  }
  
  public static boolean a(String paramString)
  {
    if (c(paramString)) {
      return false;
    }
    return Pattern.compile("[\\u4e00-\\u9fa5]+").matcher(paramString).find();
  }
  
  public static boolean a(String paramString, boolean paramBoolean)
  {
    if (paramString == null) {
      return paramBoolean;
    }
    try
    {
      boolean bool = Boolean.parseBoolean(paramString);
      return bool;
    }
    catch (NumberFormatException paramString)
    {
      o.a("MicroMsg.Util", paramString, "", new Object[0]);
    }
    return paramBoolean;
  }
  
  public static boolean a(List paramList)
  {
    return (paramList == null) || (paramList.size() == 0);
  }
  
  public static boolean a(byte[] paramArrayOfByte)
  {
    return (paramArrayOfByte == null) || (paramArrayOfByte.length <= 0);
  }
  
  public static boolean a(String... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      if (c(paramVarArgs[i])) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public static long b()
  {
    return SystemClock.elapsedRealtime();
  }
  
  public static long b(long paramLong)
  {
    return System.currentTimeMillis() / 1000L - paramLong;
  }
  
  public static String b(long paramLong, double paramDouble)
  {
    double d1 = paramLong;
    Double.isNaN(d1);
    d1 = Math.round(d1 * paramDouble / 1048576.0D);
    Double.isNaN(d1);
    paramDouble = d1 / paramDouble;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramDouble);
    localStringBuilder.append(" MB");
    return localStringBuilder.toString();
  }
  
  /* Error */
  public static String b(Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +294 -> 295
    //   4: iload_1
    //   5: ifgt +6 -> 11
    //   8: ldc 95
    //   10: areturn
    //   11: aload_0
    //   12: ldc 108
    //   14: invokevirtual 114	android/content/Context:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   17: checkcast 116	android/app/ActivityManager
    //   20: invokevirtual 340	android/app/ActivityManager:getRunningAppProcesses	()Ljava/util/List;
    //   23: invokeinterface 173 1 0
    //   28: astore_0
    //   29: aload_0
    //   30: invokeinterface 179 1 0
    //   35: ifeq +65 -> 100
    //   38: aload_0
    //   39: invokeinterface 183 1 0
    //   44: checkcast 342	android/app/ActivityManager$RunningAppProcessInfo
    //   47: astore 4
    //   49: aload 4
    //   51: getfield 345	android/app/ActivityManager$RunningAppProcessInfo:pid	I
    //   54: iload_1
    //   55: if_icmpne -26 -> 29
    //   58: aload 4
    //   60: getfield 349	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   63: ifnull -34 -> 29
    //   66: aload 4
    //   68: getfield 349	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   71: ldc 95
    //   73: invokevirtual 353	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   76: ifne -47 -> 29
    //   79: aload 4
    //   81: getfield 349	android/app/ActivityManager$RunningAppProcessInfo:processName	Ljava/lang/String;
    //   84: astore_0
    //   85: aload_0
    //   86: areturn
    //   87: astore_0
    //   88: ldc 93
    //   90: aload_0
    //   91: ldc 95
    //   93: iconst_0
    //   94: anewarray 4	java/lang/Object
    //   97: invokestatic 100	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   100: sipush 128
    //   103: newarray byte
    //   105: astore 5
    //   107: aconst_null
    //   108: astore 6
    //   110: aconst_null
    //   111: astore 4
    //   113: aload 4
    //   115: astore_0
    //   116: new 215	java/lang/StringBuilder
    //   119: dup
    //   120: invokespecial 218	java/lang/StringBuilder:<init>	()V
    //   123: astore 7
    //   125: aload 4
    //   127: astore_0
    //   128: aload 7
    //   130: ldc_w 355
    //   133: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: pop
    //   137: aload 4
    //   139: astore_0
    //   140: aload 7
    //   142: iload_1
    //   143: invokevirtual 358	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   146: pop
    //   147: aload 4
    //   149: astore_0
    //   150: aload 7
    //   152: ldc_w 360
    //   155: invokevirtual 222	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: pop
    //   159: aload 4
    //   161: astore_0
    //   162: new 362	java/io/BufferedInputStream
    //   165: dup
    //   166: new 364	java/io/FileInputStream
    //   169: dup
    //   170: aload 7
    //   172: invokevirtual 231	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   175: invokespecial 367	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   178: invokespecial 368	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   181: astore 4
    //   183: aload 4
    //   185: aload 5
    //   187: invokevirtual 372	java/io/InputStream:read	([B)I
    //   190: istore_3
    //   191: iload_3
    //   192: ifle +27 -> 219
    //   195: iconst_0
    //   196: istore_1
    //   197: goto +113 -> 310
    //   200: new 61	java/lang/String
    //   203: dup
    //   204: aload 5
    //   206: iconst_0
    //   207: iload_2
    //   208: invokespecial 375	java/lang/String:<init>	([BII)V
    //   211: astore_0
    //   212: aload 4
    //   214: invokevirtual 259	java/io/InputStream:close	()V
    //   217: aload_0
    //   218: areturn
    //   219: aload 4
    //   221: invokevirtual 259	java/io/InputStream:close	()V
    //   224: ldc 95
    //   226: areturn
    //   227: astore 5
    //   229: aload 4
    //   231: astore_0
    //   232: aload 5
    //   234: astore 4
    //   236: goto +48 -> 284
    //   239: astore 5
    //   241: goto +14 -> 255
    //   244: astore 4
    //   246: goto +38 -> 284
    //   249: astore 5
    //   251: aload 6
    //   253: astore 4
    //   255: aload 4
    //   257: astore_0
    //   258: ldc 93
    //   260: aload 5
    //   262: ldc 95
    //   264: iconst_0
    //   265: anewarray 4	java/lang/Object
    //   268: invokestatic 100	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   271: aload 4
    //   273: ifnull +8 -> 281
    //   276: aload 4
    //   278: invokevirtual 259	java/io/InputStream:close	()V
    //   281: ldc 95
    //   283: areturn
    //   284: aload_0
    //   285: ifnull +7 -> 292
    //   288: aload_0
    //   289: invokevirtual 259	java/io/InputStream:close	()V
    //   292: aload 4
    //   294: athrow
    //   295: ldc 95
    //   297: areturn
    //   298: astore 4
    //   300: aload_0
    //   301: areturn
    //   302: astore_0
    //   303: ldc 95
    //   305: areturn
    //   306: astore_0
    //   307: goto -15 -> 292
    //   310: iload_3
    //   311: istore_2
    //   312: iload_1
    //   313: iload_3
    //   314: if_icmpge -114 -> 200
    //   317: aload 5
    //   319: iload_1
    //   320: baload
    //   321: sipush 128
    //   324: if_icmpgt +20 -> 344
    //   327: aload 5
    //   329: iload_1
    //   330: baload
    //   331: ifgt +6 -> 337
    //   334: goto +10 -> 344
    //   337: iload_1
    //   338: iconst_1
    //   339: iadd
    //   340: istore_1
    //   341: goto -31 -> 310
    //   344: iload_1
    //   345: istore_2
    //   346: goto -146 -> 200
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	349	0	paramContext	Context
    //   0	349	1	paramInt	int
    //   207	139	2	i	int
    //   190	125	3	j	int
    //   47	188	4	localObject1	Object
    //   244	1	4	localObject2	Object
    //   253	40	4	localObject3	Object
    //   298	1	4	localException1	Exception
    //   105	100	5	arrayOfByte	byte[]
    //   227	6	5	localObject4	Object
    //   239	1	5	localException2	Exception
    //   249	79	5	localException3	Exception
    //   108	144	6	localObject5	Object
    //   123	48	7	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   11	29	87	java/lang/Exception
    //   29	85	87	java/lang/Exception
    //   183	191	227	finally
    //   200	212	227	finally
    //   183	191	239	java/lang/Exception
    //   200	212	239	java/lang/Exception
    //   116	125	244	finally
    //   128	137	244	finally
    //   140	147	244	finally
    //   150	159	244	finally
    //   162	183	244	finally
    //   258	271	244	finally
    //   116	125	249	java/lang/Exception
    //   128	137	249	java/lang/Exception
    //   140	147	249	java/lang/Exception
    //   150	159	249	java/lang/Exception
    //   162	183	249	java/lang/Exception
    //   212	217	298	java/lang/Exception
    //   219	224	302	java/lang/Exception
    //   276	281	302	java/lang/Exception
    //   288	292	306	java/lang/Exception
  }
  
  public static String b(String paramString)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  public static String b(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    if (paramArrayOfByte != null)
    {
      int i = 0;
      while (i < paramArrayOfByte.length)
      {
        localStringBuilder.append(String.format("%02x", new Object[] { Integer.valueOf(paramArrayOfByte[i] & 0xFF) }));
        i += 1;
      }
    }
    return localStringBuilder.toString();
  }
  
  public static boolean b(String paramString1, String paramString2)
  {
    if ((c(paramString1)) && (c(paramString2))) {
      return true;
    }
    if ((c(paramString1)) && (!c(paramString2))) {
      return false;
    }
    if ((!c(paramString1)) && (c(paramString2))) {
      return false;
    }
    return paramString1.equals(paramString2);
  }
  
  public static long c(long paramLong)
  {
    return SystemClock.elapsedRealtime() - paramLong;
  }
  
  public static u c()
  {
    return new u();
  }
  
  public static String c(long paramLong, double paramDouble)
  {
    double d1 = paramLong;
    Double.isNaN(d1);
    d1 = Math.round(d1 * paramDouble / 1073741824.0D);
    Double.isNaN(d1);
    paramDouble = d1 / paramDouble;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramDouble);
    localStringBuilder.append(" GB");
    return localStringBuilder.toString();
  }
  
  public static boolean c(String paramString)
  {
    return (paramString == null) || (paramString.length() <= 0);
  }
  
  public static long d()
  {
    return System.currentTimeMillis();
  }
  
  public static long d(long paramLong)
  {
    return System.currentTimeMillis() - paramLong;
  }
  
  public static byte[] d(String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0)) {
      try
      {
        byte[] arrayOfByte = new byte[paramString.length() / 2];
        int i = 0;
        while (i < arrayOfByte.length)
        {
          int j = i * 2;
          arrayOfByte[i] = ((byte)(Integer.parseInt(paramString.substring(j, j + 2), 16) & 0xFF));
          i += 1;
        }
        return arrayOfByte;
      }
      catch (NumberFormatException paramString)
      {
        o.a("MicroMsg.Util", paramString, "", new Object[0]);
        return new byte[0];
      }
    }
    return new byte[0];
  }
  
  public static int e(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (Exception localException)
    {
      label7:
      StringBuilder localStringBuilder;
      break label7;
    }
    if (paramString != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("parserInt error ");
      localStringBuilder.append(paramString);
      o.b("MicroMsg.Util", localStringBuilder.toString());
    }
    return 0;
  }
  
  public static long f(String paramString)
  {
    try
    {
      long l = Long.parseLong(paramString);
      return l;
    }
    catch (Exception localException)
    {
      label7:
      StringBuilder localStringBuilder;
      break label7;
    }
    if (paramString != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("parseLong error ");
      localStringBuilder.append(paramString);
      o.b("MicroMsg.Util", localStringBuilder.toString());
    }
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qz.af
 * JD-Core Version:    0.7.0.1
 */
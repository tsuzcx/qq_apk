package com.tencent.luggage.wxa.hd;

import android.os.Build.VERSION;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import java.io.File;
import java.util.Map;

public class b
{
  private static Map<String, String> a;
  
  public static String a()
  {
    if (a == null) {
      a = f();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(": ");
    localStringBuilder.append(a(a, "Features"));
    localStringBuilder.append(": ");
    localStringBuilder.append(a(a, "Processor"));
    localStringBuilder.append(": ");
    localStringBuilder.append(a(a, "CPU architecture"));
    localStringBuilder.append(": ");
    localStringBuilder.append(a(a, "Hardware"));
    localStringBuilder.append(": ");
    localStringBuilder.append(a(a, "Serial"));
    return localStringBuilder.toString();
  }
  
  private static String a(String paramString)
  {
    localObject = paramString;
    if (paramString != null)
    {
      String str = paramString;
      localObject = paramString;
      try
      {
        if (paramString.length() > 0) {
          for (;;)
          {
            str = paramString;
            localObject = paramString;
            if (a(paramString.charAt(0))) {
              break;
            }
            str = paramString;
            if (paramString.length() == 1) {
              return null;
            }
            str = paramString;
            paramString = paramString.substring(1);
          }
        }
        return localObject;
      }
      catch (Exception paramString)
      {
        o.a("CpuFeatures", paramString, "", new Object[0]);
        localObject = str;
      }
    }
  }
  
  private static String a(Map<String, String> paramMap, String paramString)
  {
    return (String)paramMap.get(paramString);
  }
  
  private static boolean a(char paramChar)
  {
    return (paramChar >= '0') && (paramChar <= '9');
  }
  
  public static boolean a(int paramInt)
  {
    return Build.VERSION.SDK_INT >= paramInt;
  }
  
  private static String b(String paramString)
  {
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      try
      {
        if (a(paramString.charAt(i))) {
          if (paramString.length() > j) {
            continue;
          }
        }
        i = j - 1;
        String str = paramString;
        if (paramString.length() > i + 1)
        {
          str = paramString;
          if (i > 0) {
            str = paramString.substring(0, i);
          }
        }
        return str;
      }
      catch (Exception localException)
      {
        o.a("CpuFeatures", localException, "", new Object[0]);
        return paramString;
      }
    }
  }
  
  public static boolean b()
  {
    if (a == null) {
      a = f();
    }
    Object localObject = a;
    if (localObject != null)
    {
      localObject = a((Map)localObject, "Features");
      if ((localObject != null) && (((String)localObject).contains("neon"))) {
        return true;
      }
      if ((localObject != null) && (((String)localObject).contains("asimd"))) {
        return true;
      }
    }
    return false;
  }
  
  public static boolean c()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    try
    {
      if (a(4))
      {
        boolean bool3 = b();
        bool1 = bool2;
        if (bool3) {
          bool1 = true;
        }
      }
      return bool1;
    }
    catch (IncompatibleClassChangeError localIncompatibleClassChangeError)
    {
      o.a("MicroMsg.Crash", localIncompatibleClassChangeError, "May cause dvmFindCatchBlock crash!", new Object[0]);
      throw ((IncompatibleClassChangeError)new IncompatibleClassChangeError("May cause dvmFindCatchBlock crash!").initCause(localIncompatibleClassChangeError));
    }
    catch (Throwable localThrowable) {}
    return false;
  }
  
  public static boolean d()
  {
    if (a == null) {
      a = f();
    }
    Object localObject = a;
    if (localObject != null)
    {
      localObject = a((Map)localObject, "CPU architecture");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("arch ");
      localStringBuilder.append((String)localObject);
      o.e("CpuFeatures", localStringBuilder.toString());
      if (localObject != null) {
        try
        {
          if (((String)localObject).length() > 0)
          {
            int i = af.a(b(a((String)localObject)), 0);
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("armarch ");
            ((StringBuilder)localObject).append(i);
            o.e("CpuFeatures", ((StringBuilder)localObject).toString());
            if (i >= 6) {
              return true;
            }
          }
        }
        catch (Exception localException)
        {
          o.a("CpuFeatures", localException, "", new Object[0]);
        }
      }
    }
    return false;
  }
  
  public static int e()
  {
    try
    {
      int i = new File("/sys/devices/system/cpu/").listFiles(new b.a()).length;
      return i;
    }
    catch (Exception localException)
    {
      label23:
      break label23;
    }
    return 1;
  }
  
  /* Error */
  public static java.util.HashMap<String, String> f()
  {
    // Byte code:
    //   0: new 158	java/util/HashMap
    //   3: dup
    //   4: invokespecial 159	java/util/HashMap:<init>	()V
    //   7: astore_3
    //   8: new 161	java/io/BufferedReader
    //   11: dup
    //   12: new 163	java/io/InputStreamReader
    //   15: dup
    //   16: new 165	java/io/FileInputStream
    //   19: dup
    //   20: ldc 167
    //   22: invokespecial 168	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   25: ldc 170
    //   27: invokespecial 173	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/lang/String;)V
    //   30: invokespecial 176	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   33: astore_0
    //   34: aload_0
    //   35: astore_1
    //   36: aload_0
    //   37: invokevirtual 179	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   40: astore_2
    //   41: aload_0
    //   42: astore_1
    //   43: aload_2
    //   44: ifnull +104 -> 148
    //   47: aload_0
    //   48: astore_1
    //   49: aload_2
    //   50: ldc 181
    //   52: iconst_2
    //   53: invokevirtual 185	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
    //   56: astore 4
    //   58: aload 4
    //   60: ifnull -26 -> 34
    //   63: aload_0
    //   64: astore_1
    //   65: aload 4
    //   67: arraylength
    //   68: iconst_2
    //   69: if_icmpge +6 -> 75
    //   72: goto -38 -> 34
    //   75: aload_0
    //   76: astore_1
    //   77: aload 4
    //   79: iconst_0
    //   80: aaload
    //   81: invokevirtual 188	java/lang/String:trim	()Ljava/lang/String;
    //   84: astore_2
    //   85: aload_0
    //   86: astore_1
    //   87: aload 4
    //   89: iconst_1
    //   90: aaload
    //   91: invokevirtual 188	java/lang/String:trim	()Ljava/lang/String;
    //   94: astore 4
    //   96: aload_0
    //   97: astore_1
    //   98: aload_3
    //   99: aload_2
    //   100: invokevirtual 189	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   103: ifnonnull -69 -> 34
    //   106: aload_0
    //   107: astore_1
    //   108: aload_3
    //   109: aload_2
    //   110: aload 4
    //   112: invokevirtual 193	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   115: pop
    //   116: goto -82 -> 34
    //   119: astore_2
    //   120: goto +12 -> 132
    //   123: astore_0
    //   124: aconst_null
    //   125: astore_1
    //   126: goto +29 -> 155
    //   129: astore_2
    //   130: aconst_null
    //   131: astore_0
    //   132: aload_0
    //   133: astore_1
    //   134: ldc 66
    //   136: aload_2
    //   137: ldc 195
    //   139: iconst_0
    //   140: anewarray 4	java/lang/Object
    //   143: invokestatic 73	com/tencent/luggage/wxa/qz/o:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   146: aload_0
    //   147: astore_1
    //   148: aload_1
    //   149: invokestatic 198	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   152: aload_3
    //   153: areturn
    //   154: astore_0
    //   155: aload_1
    //   156: invokestatic 198	com/tencent/luggage/wxa/qz/af:a	(Ljava/io/Closeable;)V
    //   159: goto +5 -> 164
    //   162: aload_0
    //   163: athrow
    //   164: goto -2 -> 162
    // Local variable table:
    //   start	length	slot	name	signature
    //   33	74	0	localBufferedReader	java.io.BufferedReader
    //   123	1	0	localObject1	Object
    //   131	16	0	localObject2	Object
    //   154	9	0	localObject3	Object
    //   35	121	1	localObject4	Object
    //   40	70	2	str	String
    //   119	1	2	localIOException1	java.io.IOException
    //   129	8	2	localIOException2	java.io.IOException
    //   7	146	3	localHashMap	java.util.HashMap
    //   56	55	4	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   36	41	119	java/io/IOException
    //   49	58	119	java/io/IOException
    //   65	72	119	java/io/IOException
    //   77	85	119	java/io/IOException
    //   87	96	119	java/io/IOException
    //   98	106	119	java/io/IOException
    //   108	116	119	java/io/IOException
    //   8	34	123	finally
    //   8	34	129	java/io/IOException
    //   36	41	154	finally
    //   49	58	154	finally
    //   65	72	154	finally
    //   77	85	154	finally
    //   87	96	154	finally
    //   98	106	154	finally
    //   108	116	154	finally
    //   134	146	154	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hd.b
 * JD-Core Version:    0.7.0.1
 */
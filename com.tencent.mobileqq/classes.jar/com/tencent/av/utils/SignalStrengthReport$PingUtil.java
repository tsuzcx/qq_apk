package com.tencent.av.utils;

import com.tencent.av.AVLog;
import java.net.URI;

public class SignalStrengthReport$PingUtil
{
  public static int a(String paramString)
  {
    return a(paramString, 1, 1000);
  }
  
  public static int a(String paramString, int paramInt1, int paramInt2)
  {
    paramString = a(paramString);
    if (paramString == null) {
      return -1;
    }
    paramString = b(a(paramInt1, paramInt2, paramString));
    if (paramString != null) {
      try
      {
        paramInt1 = Math.round(Float.valueOf(paramString.substring(paramString.indexOf("min/avg/max/mdev") + 19).split("/")[1]).floatValue());
        return paramInt1;
      }
      catch (Exception paramString)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getAvgRTT e:");
        localStringBuilder.append(paramString);
        AVLog.printColorLog("SignalStrengthReport", localStringBuilder.toString());
      }
    }
    return -1;
  }
  
  private static String a(int paramInt1, int paramInt2, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("/system/bin/ping -c ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" -w ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(" ");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  private static String a(String paramString)
  {
    try
    {
      paramString = URI.create(paramString).getHost();
      return paramString;
    }
    catch (Exception paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getDomain e:");
      localStringBuilder.append(paramString);
      AVLog.printColorLog("SignalStrengthReport", localStringBuilder.toString());
    }
    return null;
  }
  
  /* Error */
  private static String b(String paramString)
  {
    // Byte code:
    //   0: invokestatic 110	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   3: aload_0
    //   4: invokevirtual 114	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   7: astore_1
    //   8: aload_1
    //   9: astore_0
    //   10: aload_1
    //   11: invokevirtual 120	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   14: astore_2
    //   15: aload_1
    //   16: astore_0
    //   17: new 122	java/io/BufferedReader
    //   20: dup
    //   21: new 124	java/io/InputStreamReader
    //   24: dup
    //   25: aload_2
    //   26: invokespecial 127	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   29: invokespecial 130	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   32: astore_3
    //   33: aload_1
    //   34: astore_0
    //   35: new 60	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   42: astore 4
    //   44: aload_1
    //   45: astore_0
    //   46: aload_3
    //   47: invokevirtual 133	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   50: astore 5
    //   52: aload 5
    //   54: ifnull +26 -> 80
    //   57: aload_1
    //   58: astore_0
    //   59: aload 4
    //   61: aload 5
    //   63: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: aload_1
    //   68: astore_0
    //   69: aload 4
    //   71: ldc 135
    //   73: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: goto -33 -> 44
    //   80: aload_1
    //   81: astore_0
    //   82: aload_3
    //   83: invokevirtual 138	java/io/BufferedReader:close	()V
    //   86: aload_1
    //   87: astore_0
    //   88: aload_2
    //   89: invokevirtual 141	java/io/InputStream:close	()V
    //   92: aload_1
    //   93: astore_0
    //   94: aload 4
    //   96: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: astore_2
    //   100: aload_1
    //   101: ifnull +7 -> 108
    //   104: aload_1
    //   105: invokevirtual 144	java/lang/Process:destroy	()V
    //   108: aload_2
    //   109: areturn
    //   110: astore_2
    //   111: goto +12 -> 123
    //   114: astore_0
    //   115: aconst_null
    //   116: astore_1
    //   117: goto +59 -> 176
    //   120: astore_2
    //   121: aconst_null
    //   122: astore_1
    //   123: aload_1
    //   124: astore_0
    //   125: new 60	java/lang/StringBuilder
    //   128: dup
    //   129: invokespecial 61	java/lang/StringBuilder:<init>	()V
    //   132: astore_3
    //   133: aload_1
    //   134: astore_0
    //   135: aload_3
    //   136: ldc 146
    //   138: invokevirtual 67	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: pop
    //   142: aload_1
    //   143: astore_0
    //   144: aload_3
    //   145: aload_2
    //   146: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   149: pop
    //   150: aload_1
    //   151: astore_0
    //   152: ldc 72
    //   154: aload_3
    //   155: invokevirtual 76	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   158: invokestatic 82	com/tencent/av/AVLog:printColorLog	(Ljava/lang/String;Ljava/lang/String;)V
    //   161: aload_1
    //   162: ifnull +7 -> 169
    //   165: aload_1
    //   166: invokevirtual 144	java/lang/Process:destroy	()V
    //   169: aconst_null
    //   170: areturn
    //   171: astore_2
    //   172: aload_0
    //   173: astore_1
    //   174: aload_2
    //   175: astore_0
    //   176: aload_1
    //   177: ifnull +7 -> 184
    //   180: aload_1
    //   181: invokevirtual 144	java/lang/Process:destroy	()V
    //   184: goto +5 -> 189
    //   187: aload_0
    //   188: athrow
    //   189: goto -2 -> 187
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	192	0	paramString	String
    //   7	174	1	localObject1	Object
    //   14	95	2	localObject2	Object
    //   110	1	2	localThrowable1	java.lang.Throwable
    //   120	26	2	localThrowable2	java.lang.Throwable
    //   171	4	2	localObject3	Object
    //   32	123	3	localObject4	Object
    //   42	53	4	localStringBuilder	StringBuilder
    //   50	12	5	str	String
    // Exception table:
    //   from	to	target	type
    //   10	15	110	java/lang/Throwable
    //   17	33	110	java/lang/Throwable
    //   35	44	110	java/lang/Throwable
    //   46	52	110	java/lang/Throwable
    //   59	67	110	java/lang/Throwable
    //   69	77	110	java/lang/Throwable
    //   82	86	110	java/lang/Throwable
    //   88	92	110	java/lang/Throwable
    //   94	100	110	java/lang/Throwable
    //   0	8	114	finally
    //   0	8	120	java/lang/Throwable
    //   10	15	171	finally
    //   17	33	171	finally
    //   35	44	171	finally
    //   46	52	171	finally
    //   59	67	171	finally
    //   69	77	171	finally
    //   82	86	171	finally
    //   88	92	171	finally
    //   94	100	171	finally
    //   125	133	171	finally
    //   135	142	171	finally
    //   144	150	171	finally
    //   152	161	171	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.SignalStrengthReport.PingUtil
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.component.network.utils;

import android.text.TextUtils;
import java.lang.reflect.Method;

public class PropertyUtil
{
  private static final String CMD_GET_PROP = "getprop";
  public static final String PROPERTY_DNS_PRIMARY = "net.dns1";
  public static final String PROPERTY_DNS_SECNDARY = "net.dns2";
  private static Class sClassSystemProperties;
  private static Method sMethodGetString;
  
  static
  {
    try
    {
      sClassSystemProperties = Class.forName("android.os.SystemProperties");
      sMethodGetString = sClassSystemProperties.getDeclaredMethod("get", new Class[] { String.class, String.class });
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public static String get(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    String str1;
    do
    {
      return paramString2;
      String str2 = getWithReflect(paramString1, null);
      str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = getWithCmd(paramString1, null);
      }
    } while (TextUtils.isEmpty(str1));
    return str1;
  }
  
  /* Error */
  private static String getWithCmd(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: astore 4
    //   3: invokestatic 67	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   6: new 69	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   13: ldc 72
    //   15: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: aload_0
    //   19: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   25: invokevirtual 84	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   28: astore 5
    //   30: aconst_null
    //   31: astore 4
    //   33: new 86	java/io/BufferedReader
    //   36: dup
    //   37: new 88	java/io/InputStreamReader
    //   40: dup
    //   41: aload 5
    //   43: invokevirtual 94	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   46: invokespecial 97	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   49: invokespecial 100	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   52: astore_3
    //   53: new 69	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   60: astore_0
    //   61: aload_3
    //   62: invokevirtual 103	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   65: astore 4
    //   67: aload 4
    //   69: ifnull +36 -> 105
    //   72: aload_0
    //   73: aload 4
    //   75: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: goto -18 -> 61
    //   82: astore_0
    //   83: aload_1
    //   84: astore_0
    //   85: aload_3
    //   86: ifnull +86 -> 172
    //   89: aload_1
    //   90: astore 4
    //   92: aload_3
    //   93: invokevirtual 106	java/io/BufferedReader:close	()V
    //   96: aload_1
    //   97: astore_0
    //   98: aload 5
    //   100: invokevirtual 109	java/lang/Process:destroy	()V
    //   103: aload_0
    //   104: areturn
    //   105: aload_0
    //   106: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   109: astore_0
    //   110: aload_0
    //   111: invokestatic 53	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   114: istore_2
    //   115: iload_2
    //   116: ifne +5 -> 121
    //   119: aload_0
    //   120: astore_1
    //   121: aload_1
    //   122: astore_0
    //   123: aload_3
    //   124: ifnull +48 -> 172
    //   127: aload_1
    //   128: astore 4
    //   130: aload_3
    //   131: invokevirtual 106	java/io/BufferedReader:close	()V
    //   134: aload_1
    //   135: astore_0
    //   136: goto -38 -> 98
    //   139: aload_3
    //   140: ifnull +10 -> 150
    //   143: aload_1
    //   144: astore 4
    //   146: aload_3
    //   147: invokevirtual 106	java/io/BufferedReader:close	()V
    //   150: aload_1
    //   151: astore 4
    //   153: aload_0
    //   154: athrow
    //   155: astore_0
    //   156: aload 4
    //   158: areturn
    //   159: astore_1
    //   160: aload_0
    //   161: areturn
    //   162: astore_0
    //   163: goto -24 -> 139
    //   166: astore_0
    //   167: aconst_null
    //   168: astore_3
    //   169: goto -86 -> 83
    //   172: goto -74 -> 98
    //   175: astore_0
    //   176: aload 4
    //   178: astore_3
    //   179: goto -40 -> 139
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	paramString1	String
    //   0	182	1	paramString2	String
    //   114	2	2	bool	boolean
    //   52	127	3	localObject	Object
    //   1	176	4	str	String
    //   28	71	5	localProcess	java.lang.Process
    // Exception table:
    //   from	to	target	type
    //   53	61	82	java/io/IOException
    //   61	67	82	java/io/IOException
    //   72	79	82	java/io/IOException
    //   105	115	82	java/io/IOException
    //   3	30	155	java/lang/Throwable
    //   92	96	155	java/lang/Throwable
    //   130	134	155	java/lang/Throwable
    //   146	150	155	java/lang/Throwable
    //   153	155	155	java/lang/Throwable
    //   98	103	159	java/lang/Throwable
    //   53	61	162	finally
    //   61	67	162	finally
    //   72	79	162	finally
    //   105	115	162	finally
    //   33	53	166	java/io/IOException
    //   33	53	175	finally
  }
  
  private static String getWithReflect(String paramString1, String paramString2)
  {
    if ((sClassSystemProperties == null) || (sMethodGetString == null)) {
      return paramString2;
    }
    try
    {
      paramString1 = (String)sMethodGetString.invoke(sClassSystemProperties, new Object[] { paramString1, paramString2 });
      return paramString1;
    }
    catch (Throwable paramString1) {}
    return paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.utils.PropertyUtil
 * JD-Core Version:    0.7.0.1
 */
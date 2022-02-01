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
    if (TextUtils.isEmpty(paramString1)) {
      return paramString2;
    }
    String str = getWithReflect(paramString1, null);
    if (TextUtils.isEmpty(str)) {
      paramString1 = getWithCmd(paramString1, null);
    } else {
      paramString1 = str;
    }
    str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = paramString2;
    }
    return str;
  }
  
  /* Error */
  private static String getWithCmd(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_1
    //   1: astore_3
    //   2: invokestatic 67	java/lang/Runtime:getRuntime	()Ljava/lang/Runtime;
    //   5: astore 4
    //   7: aload_1
    //   8: astore_3
    //   9: new 69	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   16: astore 5
    //   18: aload_1
    //   19: astore_3
    //   20: aload 5
    //   22: ldc 72
    //   24: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: aload_1
    //   29: astore_3
    //   30: aload 5
    //   32: aload_0
    //   33: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: aload_1
    //   38: astore_3
    //   39: aload 4
    //   41: aload 5
    //   43: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokevirtual 84	java/lang/Runtime:exec	(Ljava/lang/String;)Ljava/lang/Process;
    //   49: astore 5
    //   51: new 86	java/io/BufferedReader
    //   54: dup
    //   55: new 88	java/io/InputStreamReader
    //   58: dup
    //   59: aload 5
    //   61: invokevirtual 94	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   64: invokespecial 97	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   67: invokespecial 100	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   70: astore_0
    //   71: new 69	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   78: astore_3
    //   79: aload_0
    //   80: invokevirtual 103	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   83: astore 4
    //   85: aload 4
    //   87: ifnull +13 -> 100
    //   90: aload_3
    //   91: aload 4
    //   93: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: pop
    //   97: goto -18 -> 79
    //   100: aload_3
    //   101: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: astore_3
    //   105: aload_3
    //   106: invokestatic 53	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   109: istore_2
    //   110: aload_0
    //   111: astore 4
    //   113: iload_2
    //   114: ifne +8 -> 122
    //   117: aload_3
    //   118: astore_1
    //   119: aload_0
    //   120: astore 4
    //   122: aload_1
    //   123: astore_3
    //   124: aload 4
    //   126: invokevirtual 106	java/io/BufferedReader:close	()V
    //   129: aload_1
    //   130: astore_0
    //   131: goto +18 -> 149
    //   134: aload_0
    //   135: ifnull +9 -> 144
    //   138: aload_1
    //   139: astore_3
    //   140: aload_0
    //   141: invokevirtual 106	java/io/BufferedReader:close	()V
    //   144: aload_1
    //   145: astore_3
    //   146: aload 4
    //   148: athrow
    //   149: aload_0
    //   150: astore_3
    //   151: aload 5
    //   153: invokevirtual 109	java/lang/Process:destroy	()V
    //   156: aload_0
    //   157: areturn
    //   158: astore_0
    //   159: aload_3
    //   160: areturn
    //   161: astore_0
    //   162: goto +24 -> 186
    //   165: astore_3
    //   166: goto +8 -> 174
    //   169: astore 4
    //   171: goto -37 -> 134
    //   174: aload_0
    //   175: astore_3
    //   176: goto +12 -> 188
    //   179: astore 4
    //   181: aconst_null
    //   182: astore_0
    //   183: goto -49 -> 134
    //   186: aconst_null
    //   187: astore_3
    //   188: aload_1
    //   189: astore_0
    //   190: aload_3
    //   191: ifnull -42 -> 149
    //   194: aload_3
    //   195: astore 4
    //   197: goto -75 -> 122
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	200	0	paramString1	String
    //   0	200	1	paramString2	String
    //   109	5	2	bool	boolean
    //   1	159	3	localObject1	Object
    //   165	1	3	localIOException	java.io.IOException
    //   175	20	3	str1	String
    //   5	142	4	localObject2	Object
    //   169	1	4	localObject3	Object
    //   179	1	4	localObject4	Object
    //   195	1	4	str2	String
    //   16	136	5	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	158	java/lang/Throwable
    //   9	18	158	java/lang/Throwable
    //   20	28	158	java/lang/Throwable
    //   30	37	158	java/lang/Throwable
    //   39	51	158	java/lang/Throwable
    //   124	129	158	java/lang/Throwable
    //   140	144	158	java/lang/Throwable
    //   146	149	158	java/lang/Throwable
    //   151	156	158	java/lang/Throwable
    //   51	71	161	java/io/IOException
    //   71	79	165	java/io/IOException
    //   79	85	165	java/io/IOException
    //   90	97	165	java/io/IOException
    //   100	110	165	java/io/IOException
    //   71	79	169	finally
    //   79	85	169	finally
    //   90	97	169	finally
    //   100	110	169	finally
    //   51	71	179	finally
  }
  
  private static String getWithReflect(String paramString1, String paramString2)
  {
    Class localClass = sClassSystemProperties;
    Method localMethod;
    if (localClass != null)
    {
      localMethod = sMethodGetString;
      if (localMethod == null) {
        return paramString2;
      }
    }
    try
    {
      paramString1 = (String)localMethod.invoke(localClass, new Object[] { paramString1, paramString2 });
      return paramString1;
    }
    catch (Throwable paramString1)
    {
      label41:
      break label41;
    }
    return paramString2;
    return paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.utils.PropertyUtil
 * JD-Core Version:    0.7.0.1
 */
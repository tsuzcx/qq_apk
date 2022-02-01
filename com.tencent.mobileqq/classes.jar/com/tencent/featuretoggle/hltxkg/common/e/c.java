package com.tencent.featuretoggle.hltxkg.common.e;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.featuretoggle.hltxkg.common.a;
import com.tencent.featuretoggle.hltxkg.common.a.i;
import java.net.InetAddress;
import java.net.URLEncoder;
import java.util.List;

public final class c
{
  private static String a = "";
  private static String b = "";
  
  public static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    return Math.min(Math.max(paramInt1, paramInt2), paramInt3);
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (((paramInt1 < paramInt2) || (paramInt1 > paramInt3)) && (paramInt4 >= paramInt2) && (paramInt4 <= paramInt3)) {
      return paramInt4;
    }
    return Math.min(Math.max(paramInt1, paramInt2), paramInt3);
  }
  
  public static String a()
  {
    return "UNKNOWN";
  }
  
  /* Error */
  public static String a(int paramInt)
  {
    // Byte code:
    //   0: new 33	java/lang/StringBuilder
    //   3: dup
    //   4: ldc 35
    //   6: invokespecial 39	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   9: astore_1
    //   10: aload_1
    //   11: iload_0
    //   12: invokevirtual 43	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   15: pop
    //   16: aload_1
    //   17: ldc 45
    //   19: invokevirtual 48	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: pop
    //   23: aload_1
    //   24: invokevirtual 51	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: astore_2
    //   28: aconst_null
    //   29: astore_1
    //   30: new 53	java/io/BufferedReader
    //   33: dup
    //   34: new 55	java/io/FileReader
    //   37: dup
    //   38: aload_2
    //   39: invokespecial 56	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   42: invokespecial 59	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   45: astore_2
    //   46: aload_2
    //   47: astore_1
    //   48: aload_2
    //   49: invokevirtual 62	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   52: astore 4
    //   54: aload 4
    //   56: astore_3
    //   57: aload_2
    //   58: astore_1
    //   59: aload 4
    //   61: invokestatic 68	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   64: ifne +11 -> 75
    //   67: aload_2
    //   68: astore_1
    //   69: aload 4
    //   71: invokevirtual 73	java/lang/String:trim	()Ljava/lang/String;
    //   74: astore_3
    //   75: aload_2
    //   76: invokevirtual 76	java/io/BufferedReader:close	()V
    //   79: aload_3
    //   80: areturn
    //   81: astore_3
    //   82: goto +14 -> 96
    //   85: astore_3
    //   86: aload_1
    //   87: astore_2
    //   88: aload_3
    //   89: astore_1
    //   90: goto +27 -> 117
    //   93: astore_3
    //   94: aconst_null
    //   95: astore_2
    //   96: aload_2
    //   97: astore_1
    //   98: aload_3
    //   99: invokevirtual 79	java/lang/Exception:printStackTrace	()V
    //   102: aload_2
    //   103: ifnull +7 -> 110
    //   106: aload_2
    //   107: invokevirtual 76	java/io/BufferedReader:close	()V
    //   110: aconst_null
    //   111: areturn
    //   112: astore_3
    //   113: aload_1
    //   114: astore_2
    //   115: aload_3
    //   116: astore_1
    //   117: aload_2
    //   118: ifnull +7 -> 125
    //   121: aload_2
    //   122: invokevirtual 76	java/io/BufferedReader:close	()V
    //   125: aload_1
    //   126: athrow
    //   127: astore_1
    //   128: aload_3
    //   129: areturn
    //   130: astore_1
    //   131: aconst_null
    //   132: areturn
    //   133: astore_2
    //   134: goto -9 -> 125
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	137	0	paramInt	int
    //   9	117	1	localObject1	Object
    //   127	1	1	localIOException1	java.io.IOException
    //   130	1	1	localIOException2	java.io.IOException
    //   27	95	2	localObject2	Object
    //   133	1	2	localIOException3	java.io.IOException
    //   56	24	3	str1	String
    //   81	1	3	localException1	java.lang.Exception
    //   85	4	3	localObject3	Object
    //   93	6	3	localException2	java.lang.Exception
    //   112	17	3	str2	String
    //   52	18	4	str3	String
    // Exception table:
    //   from	to	target	type
    //   48	54	81	java/lang/Exception
    //   59	67	81	java/lang/Exception
    //   69	75	81	java/lang/Exception
    //   30	46	85	finally
    //   30	46	93	java/lang/Exception
    //   48	54	112	finally
    //   59	67	112	finally
    //   69	75	112	finally
    //   98	102	112	finally
    //   75	79	127	java/io/IOException
    //   106	110	130	java/io/IOException
    //   121	125	133	java/io/IOException
  }
  
  public static String a(Context paramContext, int paramInt)
  {
    paramContext = paramContext.getSystemService("activity");
    if (paramContext != null) {
      try
      {
        paramContext = (ActivityManager)paramContext;
      }
      catch (Throwable paramContext)
      {
        paramContext.printStackTrace();
      }
    } else {
      paramContext = null;
    }
    if (paramContext == null) {
      return null;
    }
    paramContext = paramContext.getRunningAppProcesses();
    if ((paramContext != null) && (paramContext.size() > 0))
    {
      int j = paramContext.size();
      int i = 0;
      while (i < j)
      {
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.get(i);
        if ((localRunningAppProcessInfo != null) && (localRunningAppProcessInfo.pid == paramInt)) {
          return localRunningAppProcessInfo.processName;
        }
        i += 1;
      }
    }
    return null;
  }
  
  public static String a(Throwable paramThrowable)
  {
    paramThrowable = Log.getStackTraceString(paramThrowable);
    if (!TextUtils.isEmpty(paramThrowable))
    {
      paramThrowable = paramThrowable.split("\n");
      if (paramThrowable.length >= 2)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramThrowable[0]);
        localStringBuilder.append(paramThrowable[1]);
        return localStringBuilder.toString();
      }
      if (paramThrowable.length == 1) {
        return paramThrowable[0];
      }
    }
    return "";
  }
  
  public static boolean a(String paramString)
  {
    if (paramString == null) {
      return true;
    }
    return paramString.trim().length() == 0;
  }
  
  public static boolean a(byte[] paramArrayOfByte)
  {
    return (paramArrayOfByte == null) || (paramArrayOfByte.length <= 0);
  }
  
  public static String b()
  {
    return "UNKNOWN";
  }
  
  public static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    try
    {
      paramString = URLEncoder.encode(paramString, "UTF-8");
      return paramString;
    }
    catch (Throwable paramString) {}
    return "";
  }
  
  public static String b(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return "null";
    }
    int i = paramArrayOfByte.length;
    if (paramArrayOfByte == null) {
      return "null";
    }
    int j = Math.min(i, paramArrayOfByte.length);
    Object localObject = new StringBuilder("size:");
    ((StringBuilder)localObject).append(j);
    ((StringBuilder)localObject).append(",content:");
    localObject = new StringBuffer(((StringBuilder)localObject).toString());
    i = 0;
    while (i < j)
    {
      ((StringBuffer)localObject).append(Integer.toHexString(paramArrayOfByte[i] >> 4 & 0xF));
      ((StringBuffer)localObject).append(Integer.toHexString(paramArrayOfByte[i] & 0xF));
      i += 1;
    }
    return ((StringBuffer)localObject).toString();
  }
  
  public static String c()
  {
    try
    {
      Object localObject = new StringBuilder("");
      ((StringBuilder)localObject).append("UNKNOWN");
      ((StringBuilder)localObject).append(f());
      ((StringBuilder)localObject).append(System.currentTimeMillis());
      ((StringBuilder)localObject).append((int)(Math.random() * 2147483647.0D));
      localObject = b.a(((StringBuilder)localObject).toString());
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(System.currentTimeMillis());
      return localStringBuilder.toString();
    }
  }
  
  public static String c(String paramString)
  {
    try
    {
      paramString = InetAddress.getByName(paramString).getHostAddress();
      return paramString;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  public static String d()
  {
    try
    {
      String str = b;
      i = 1;
      if (str != null) {
        if (str.trim().length() != 0) {
          break label55;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        continue;
        label55:
        int i = 0;
      }
    }
    if (i != 0) {
      b = Settings.Secure.getString(a.a().getContentResolver(), "android_id");
    }
    return b;
    return "";
  }
  
  public static boolean d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (paramString.contains(":"))
    {
      if ((paramString.charAt(0) == '[') && (paramString.charAt(paramString.length() - 1) == ']')) {
        return i.c(paramString.substring(1, paramString.length() - 1));
      }
      return i.c(paramString);
    }
    paramString = paramString.split("\\.");
    if (paramString.length != 4) {
      return false;
    }
    int j = paramString.length;
    int i = 0;
    for (;;)
    {
      String str;
      if (i < j) {
        str = paramString[i];
      }
      try
      {
        int k = Integer.parseInt(str);
        if (k >= 0)
        {
          if (k > 255) {
            return false;
          }
          i += 1;
        }
        else
        {
          return false;
        }
      }
      catch (NumberFormatException paramString) {}
    }
    return true;
    return false;
  }
  
  public static String e()
  {
    try
    {
      Object localObject = new StringBuilder("35");
      ((StringBuilder)localObject).append(Build.BOARD.length() % 10);
      ((StringBuilder)localObject).append(Build.BRAND.length() % 10);
      ((StringBuilder)localObject).append(Build.CPU_ABI.length() % 10);
      ((StringBuilder)localObject).append(Build.DEVICE.length() % 10);
      ((StringBuilder)localObject).append(Build.DISPLAY.length() % 10);
      ((StringBuilder)localObject).append(Build.HOST.length() % 10);
      ((StringBuilder)localObject).append(Build.ID.length() % 10);
      ((StringBuilder)localObject).append(Build.MANUFACTURER.length() % 10);
      ((StringBuilder)localObject).append(Build.MODEL.length() % 10);
      ((StringBuilder)localObject).append(Build.PRODUCT.length() % 10);
      ((StringBuilder)localObject).append(Build.TAGS.length() % 10);
      ((StringBuilder)localObject).append(Build.TYPE.length() % 10);
      ((StringBuilder)localObject).append(Build.USER.length() % 10);
      localObject = ((StringBuilder)localObject).toString();
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      label199:
      break label199;
    }
    return "";
  }
  
  private static String f()
  {
    String str = a;
    int i = 1;
    if ((str != null) && (str.trim().length() != 0)) {
      i = 0;
    }
    if (i != 0) {}
    try
    {
      str = ((WifiManager)a.a().getApplicationContext().getSystemService("wifi")).getConnectionInfo().getMacAddress();
    }
    catch (Throwable localThrowable1)
    {
      label57:
      break label57;
    }
    str = "";
    if ((TextUtils.isEmpty(str)) || (a.h)) {}
    try
    {
      StringBuilder localStringBuilder = new StringBuilder("M_");
      localStringBuilder.append(b.a(str));
      a = localStringBuilder.toString();
    }
    catch (Throwable localThrowable2)
    {
      label103:
      break label103;
    }
    break label110;
    a = str;
    label110:
    if (TextUtils.isEmpty(a)) {
      a = "UNKNOWN";
    }
    return a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.featuretoggle.hltxkg.common.e.c
 * JD-Core Version:    0.7.0.1
 */
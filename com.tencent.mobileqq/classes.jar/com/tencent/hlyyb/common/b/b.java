package com.tencent.hlyyb.common.b;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Process;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

public final class b
{
  private static String a = "";
  private static String b = "";
  private static String c = "";
  private static String d = "";
  
  public static int a()
  {
    return (int)(Math.random() * 2147483647.0D);
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    return Math.min(Math.max(paramInt1, 1), 5);
  }
  
  /* Error */
  private static String a(int paramInt)
  {
    // Byte code:
    //   0: new 46	java/lang/StringBuilder
    //   3: dup
    //   4: ldc 48
    //   6: invokespecial 52	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   9: iload_0
    //   10: invokevirtual 56	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   13: ldc 58
    //   15: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   21: astore_1
    //   22: new 67	java/io/BufferedReader
    //   25: dup
    //   26: new 69	java/io/FileReader
    //   29: dup
    //   30: aload_1
    //   31: invokespecial 70	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   34: invokespecial 73	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   37: astore_2
    //   38: aload_2
    //   39: astore_1
    //   40: aload_2
    //   41: invokevirtual 76	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   44: astore 4
    //   46: aload 4
    //   48: astore_3
    //   49: aload_2
    //   50: astore_1
    //   51: aload 4
    //   53: invokestatic 82	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   56: ifne +11 -> 67
    //   59: aload_2
    //   60: astore_1
    //   61: aload 4
    //   63: invokevirtual 87	java/lang/String:trim	()Ljava/lang/String;
    //   66: astore_3
    //   67: aload_2
    //   68: invokevirtual 90	java/io/BufferedReader:close	()V
    //   71: aload_3
    //   72: areturn
    //   73: astore_3
    //   74: aconst_null
    //   75: astore_2
    //   76: aload_2
    //   77: astore_1
    //   78: aload_3
    //   79: invokevirtual 93	java/lang/Exception:printStackTrace	()V
    //   82: aload_2
    //   83: ifnull +7 -> 90
    //   86: aload_2
    //   87: invokevirtual 90	java/io/BufferedReader:close	()V
    //   90: aconst_null
    //   91: areturn
    //   92: astore_2
    //   93: aconst_null
    //   94: astore_1
    //   95: aload_1
    //   96: ifnull +7 -> 103
    //   99: aload_1
    //   100: invokevirtual 90	java/io/BufferedReader:close	()V
    //   103: aload_2
    //   104: athrow
    //   105: astore_1
    //   106: aload_3
    //   107: areturn
    //   108: astore_1
    //   109: goto -19 -> 90
    //   112: astore_1
    //   113: goto -10 -> 103
    //   116: astore_2
    //   117: goto -22 -> 95
    //   120: astore_3
    //   121: goto -45 -> 76
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	124	0	paramInt	int
    //   21	79	1	localObject1	Object
    //   105	1	1	localIOException1	java.io.IOException
    //   108	1	1	localIOException2	java.io.IOException
    //   112	1	1	localIOException3	java.io.IOException
    //   37	50	2	localBufferedReader	java.io.BufferedReader
    //   92	12	2	localObject2	Object
    //   116	1	2	localObject3	Object
    //   48	24	3	str1	String
    //   73	34	3	localException1	Exception
    //   120	1	3	localException2	Exception
    //   44	18	4	str2	String
    // Exception table:
    //   from	to	target	type
    //   22	38	73	java/lang/Exception
    //   22	38	92	finally
    //   67	71	105	java/io/IOException
    //   86	90	108	java/io/IOException
    //   99	103	112	java/io/IOException
    //   40	46	116	finally
    //   51	59	116	finally
    //   61	67	116	finally
    //   78	82	116	finally
    //   40	46	120	java/lang/Exception
    //   51	59	120	java/lang/Exception
    //   61	67	120	java/lang/Exception
  }
  
  public static String a(Context paramContext)
  {
    if (!TextUtils.isEmpty(d)) {
      return d;
    }
    String str3 = paramContext.getPackageName();
    String str2 = a(Process.myPid());
    String str1;
    if (!TextUtils.isEmpty(str2))
    {
      str1 = str2;
      if (str2.startsWith(str3)) {}
    }
    else
    {
      str1 = a(paramContext, Process.myPid());
    }
    d = str1;
    return str1;
  }
  
  private static String a(Context paramContext, int paramInt)
  {
    paramContext = paramContext.getSystemService("activity");
    if (paramContext != null) {}
    for (;;)
    {
      try
      {
        paramContext = (ActivityManager)paramContext;
        if (paramContext != null) {
          break;
        }
        return null;
      }
      catch (Throwable paramContext)
      {
        paramContext.printStackTrace();
      }
      paramContext = null;
    }
    paramContext = paramContext.getRunningAppProcesses();
    int i;
    ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo;
    if ((paramContext != null) && (paramContext.size() > 0))
    {
      int j = paramContext.size();
      i = 0;
      if (i < j)
      {
        localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)paramContext.get(i);
        if ((localRunningAppProcessInfo == null) || (localRunningAppProcessInfo.pid != paramInt)) {}
      }
    }
    for (paramContext = localRunningAppProcessInfo.processName;; paramContext = null)
    {
      return paramContext;
      i += 1;
      break;
    }
  }
  
  public static String a(String paramString1, String paramString2)
  {
    try
    {
      URL localURL = new URL(paramString1);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localURL.getProtocol()).append("://");
      localStringBuilder.append(paramString2);
      if (localURL.getPort() != -1) {
        localStringBuilder.append(":" + localURL.getPort());
      }
      localStringBuilder.append(localURL.getPath());
      if (!TextUtils.isEmpty(localURL.getQuery())) {
        localStringBuilder.append("?" + localURL.getQuery());
      }
      if (!TextUtils.isEmpty(localURL.getRef())) {
        localStringBuilder.append("#" + localURL.getRef());
      }
      paramString2 = localStringBuilder.toString();
      return paramString2;
    }
    catch (MalformedURLException paramString2)
    {
      paramString2.printStackTrace();
    }
    return paramString1;
  }
  
  public static String a(String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    String str = paramString;
    if (paramBoolean) {
      str = paramString;
    }
    try
    {
      if (paramString.length() > 30) {
        str = paramString.substring(0, 30);
      }
      paramString = URLEncoder.encode(str);
      return paramString;
    }
    catch (Throwable paramString) {}
    return "";
  }
  
  public static boolean a(String paramString)
  {
    if (paramString == null) {}
    while (paramString.trim().length() == 0) {
      return true;
    }
    return false;
  }
  
  public static boolean a(byte[] paramArrayOfByte)
  {
    return (paramArrayOfByte == null) || (paramArrayOfByte.length <= 0);
  }
  
  public static String b()
  {
    int i = 1;
    for (;;)
    {
      try
      {
        localObject = a;
        if (localObject != null) {
          continue;
        }
        if (i != 0)
        {
          localObject = (TelephonyManager)com.tencent.hlyyb.common.a.a().getSystemService("phone");
          if (localObject != null)
          {
            String str = ((TelephonyManager)localObject).getDeviceId();
            localObject = str;
            if (str == null) {
              localObject = "NOIMEI";
            }
            a = (String)localObject;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        Object localObject;
        int j;
        continue;
      }
      return a;
      j = ((String)localObject).trim().length();
      if (j != 0) {
        i = 0;
      }
    }
  }
  
  public static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    try
    {
      paramString = URLEncoder.encode(paramString);
      return paramString;
    }
    catch (Throwable paramString) {}
    return "";
  }
  
  public static String c()
  {
    int i = 1;
    for (;;)
    {
      try
      {
        localObject = c;
        if (localObject != null) {
          continue;
        }
        if (i != 0)
        {
          localObject = (WifiManager)com.tencent.hlyyb.common.a.a().getSystemService("wifi");
          if (localObject != null)
          {
            localObject = ((WifiManager)localObject).getConnectionInfo();
            if (localObject != null)
            {
              String str = ((WifiInfo)localObject).getMacAddress();
              localObject = str;
              if (str == null) {
                localObject = "NOMAC";
              }
              c = (String)localObject;
            }
          }
        }
      }
      catch (Throwable localThrowable)
      {
        Object localObject;
        int j;
        continue;
      }
      return c;
      j = ((String)localObject).trim().length();
      if (j != 0) {
        i = 0;
      }
    }
  }
  
  public static String d()
  {
    Context localContext = com.tencent.hlyyb.common.a.a();
    if (localContext == null) {
      return null;
    }
    return localContext.getPackageName();
  }
  
  public static String e()
  {
    Context localContext = com.tencent.hlyyb.common.a.a();
    if (localContext == null) {
      return null;
    }
    Object localObject = com.tencent.hlyyb.common.a.a();
    if (localObject == null) {}
    for (localObject = null;; localObject = ((Context)localObject).getPackageName()) {
      try
      {
        localObject = localContext.getPackageManager().getPackageInfo((String)localObject, 0).versionName;
        return localObject;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return null;
  }
  
  public static int f()
  {
    Context localContext = com.tencent.hlyyb.common.a.a();
    if (localContext == null) {
      return 0;
    }
    Object localObject = com.tencent.hlyyb.common.a.a();
    if (localObject == null) {}
    for (localObject = null;; localObject = ((Context)localObject).getPackageName()) {
      try
      {
        int i = localContext.getPackageManager().getPackageInfo((String)localObject, 0).versionCode;
        return i;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    return 0;
  }
  
  public static String g()
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    localStringBuilder.append(b());
    localStringBuilder.append(c());
    localStringBuilder.append(System.currentTimeMillis());
    localStringBuilder.append(h());
    localStringBuilder.append((int)(Math.random() * 2147483647.0D));
    return a.a(localStringBuilder.toString());
  }
  
  private static String h()
  {
    int i = 1;
    for (;;)
    {
      try
      {
        localObject = b;
        if (localObject != null) {
          continue;
        }
        if (i != 0)
        {
          localObject = (TelephonyManager)com.tencent.hlyyb.common.a.a().getSystemService("phone");
          if (localObject != null)
          {
            String str = ((TelephonyManager)localObject).getSubscriberId();
            localObject = str;
            if (str == null) {
              localObject = "NOIMSI";
            }
            b = (String)localObject;
          }
        }
      }
      catch (Throwable localThrowable)
      {
        Object localObject;
        int j;
        continue;
      }
      return b;
      j = ((String)localObject).trim().length();
      if (j != 0) {
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hlyyb.common.b.b
 * JD-Core Version:    0.7.0.1
 */
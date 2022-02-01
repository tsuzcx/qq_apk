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
    //   0: new 38	java/lang/StringBuilder
    //   3: dup
    //   4: ldc 40
    //   6: invokespecial 44	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   9: astore_1
    //   10: aload_1
    //   11: iload_0
    //   12: invokevirtual 48	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   15: pop
    //   16: aload_1
    //   17: ldc 50
    //   19: invokevirtual 53	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: pop
    //   23: aload_1
    //   24: invokevirtual 57	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: astore_2
    //   28: aconst_null
    //   29: astore_1
    //   30: new 59	java/io/BufferedReader
    //   33: dup
    //   34: new 61	java/io/FileReader
    //   37: dup
    //   38: aload_2
    //   39: invokespecial 62	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   42: invokespecial 65	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   45: astore_2
    //   46: aload_2
    //   47: astore_1
    //   48: aload_2
    //   49: invokevirtual 68	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   52: astore 4
    //   54: aload 4
    //   56: astore_3
    //   57: aload_2
    //   58: astore_1
    //   59: aload 4
    //   61: invokestatic 74	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   64: ifne +11 -> 75
    //   67: aload_2
    //   68: astore_1
    //   69: aload 4
    //   71: invokevirtual 79	java/lang/String:trim	()Ljava/lang/String;
    //   74: astore_3
    //   75: aload_2
    //   76: invokevirtual 82	java/io/BufferedReader:close	()V
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
    //   99: invokevirtual 85	java/lang/Exception:printStackTrace	()V
    //   102: aload_2
    //   103: ifnull +7 -> 110
    //   106: aload_2
    //   107: invokevirtual 82	java/io/BufferedReader:close	()V
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
    //   122: invokevirtual 82	java/io/BufferedReader:close	()V
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
    //   81	1	3	localException1	Exception
    //   85	4	3	localObject3	Object
    //   93	6	3	localException2	Exception
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
  
  public static String a(String paramString1, String paramString2)
  {
    try
    {
      URL localURL = new URL(paramString1);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localURL.getProtocol());
      localStringBuilder.append("://");
      localStringBuilder.append(paramString2);
      if (localURL.getPort() != -1)
      {
        paramString2 = new StringBuilder(":");
        paramString2.append(localURL.getPort());
        localStringBuilder.append(paramString2.toString());
      }
      localStringBuilder.append(localURL.getPath());
      if (!TextUtils.isEmpty(localURL.getQuery()))
      {
        paramString2 = new StringBuilder("?");
        paramString2.append(localURL.getQuery());
        localStringBuilder.append(paramString2.toString());
      }
      if (!TextUtils.isEmpty(localURL.getRef()))
      {
        paramString2 = new StringBuilder("#");
        paramString2.append(localURL.getRef());
        localStringBuilder.append(paramString2.toString());
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
    try
    {
      localObject = a;
      i = 1;
      if (localObject != null) {
        if (((String)localObject).trim().length() != 0) {
          break label72;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Object localObject;
        String str;
        continue;
        label72:
        int i = 0;
      }
    }
    if (i != 0)
    {
      localObject = (TelephonyManager)com.tencent.hlyyb.common.a.a().getSystemService("phone");
      if (localObject != null)
      {
        str = ((TelephonyManager)localObject).getDeviceId();
        localObject = str;
        if (str == null) {
          localObject = "NOIMEI";
        }
        a = (String)localObject;
      }
    }
    return a;
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
    try
    {
      localObject = c;
      i = 1;
      if (localObject != null) {
        if (((String)localObject).trim().length() != 0) {
          break label81;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Object localObject;
        String str;
        continue;
        label81:
        int i = 0;
      }
    }
    if (i != 0)
    {
      localObject = (WifiManager)com.tencent.hlyyb.common.a.a().getSystemService("wifi");
      if (localObject != null)
      {
        localObject = ((WifiManager)localObject).getConnectionInfo();
        if (localObject != null)
        {
          str = ((WifiInfo)localObject).getMacAddress();
          localObject = str;
          if (str == null) {
            localObject = "NOMAC";
          }
          c = (String)localObject;
        }
      }
    }
    return c;
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
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((Context)localObject).getPackageName();
    }
    try
    {
      localObject = localContext.getPackageManager().getPackageInfo((String)localObject, 0).versionName;
      return localObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
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
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((Context)localObject).getPackageName();
    }
    try
    {
      int i = localContext.getPackageManager().getPackageInfo((String)localObject, 0).versionCode;
      return i;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
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
    try
    {
      localObject = b;
      i = 1;
      if (localObject != null) {
        if (((String)localObject).trim().length() != 0) {
          break label73;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Object localObject;
        String str;
        continue;
        label73:
        int i = 0;
      }
    }
    if (i != 0)
    {
      localObject = (TelephonyManager)com.tencent.hlyyb.common.a.a().getSystemService("phone");
      if (localObject != null)
      {
        str = ((TelephonyManager)localObject).getSubscriberId();
        localObject = str;
        if (str == null) {
          localObject = "NOIMSI";
        }
        b = (String)localObject;
      }
    }
    return b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hlyyb.common.b.b
 * JD-Core Version:    0.7.0.1
 */
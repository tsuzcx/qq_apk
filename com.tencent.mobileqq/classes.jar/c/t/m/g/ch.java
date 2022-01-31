package c.t.m.g;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import java.net.InetAddress;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public final class ch
{
  private static String a = "";
  private static String b = "";
  private static String c = "";
  private static String d = "";
  
  public static int a(int paramInt1, int paramInt2)
  {
    return Math.min(Math.max(paramInt1, 0), paramInt2);
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
          localObject = (TelephonyManager)l.a().getSystemService("phone");
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
  
  /* Error */
  public static String a(int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: new 71	java/lang/StringBuilder
    //   6: dup
    //   7: ldc 73
    //   9: invokespecial 77	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   12: iload_0
    //   13: invokevirtual 81	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   16: ldc 83
    //   18: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   24: astore_1
    //   25: new 91	java/io/BufferedReader
    //   28: dup
    //   29: new 93	java/io/FileReader
    //   32: dup
    //   33: aload_1
    //   34: invokespecial 94	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   37: invokespecial 97	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   40: astore_2
    //   41: aload_2
    //   42: astore_1
    //   43: aload_2
    //   44: invokevirtual 100	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   47: astore_3
    //   48: aload_2
    //   49: astore_1
    //   50: aload_3
    //   51: invokestatic 106	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   54: ifne +71 -> 125
    //   57: aload_2
    //   58: astore_1
    //   59: aload_3
    //   60: invokevirtual 60	java/lang/String:trim	()Ljava/lang/String;
    //   63: astore_3
    //   64: aload_3
    //   65: astore_1
    //   66: aload_2
    //   67: invokevirtual 109	java/io/BufferedReader:close	()V
    //   70: aload_1
    //   71: areturn
    //   72: astore_3
    //   73: aconst_null
    //   74: astore_2
    //   75: aload_2
    //   76: astore_1
    //   77: aload_3
    //   78: invokevirtual 112	java/lang/Exception:printStackTrace	()V
    //   81: aload 4
    //   83: astore_1
    //   84: aload_2
    //   85: ifnull -15 -> 70
    //   88: aload_2
    //   89: invokevirtual 109	java/io/BufferedReader:close	()V
    //   92: aconst_null
    //   93: areturn
    //   94: astore_1
    //   95: aconst_null
    //   96: areturn
    //   97: astore_2
    //   98: aconst_null
    //   99: astore_1
    //   100: aload_1
    //   101: ifnull +7 -> 108
    //   104: aload_1
    //   105: invokevirtual 109	java/io/BufferedReader:close	()V
    //   108: aload_2
    //   109: athrow
    //   110: astore_2
    //   111: aload_1
    //   112: areturn
    //   113: astore_1
    //   114: goto -6 -> 108
    //   117: astore_2
    //   118: goto -18 -> 100
    //   121: astore_3
    //   122: goto -47 -> 75
    //   125: aload_3
    //   126: astore_1
    //   127: goto -61 -> 66
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	130	0	paramInt	int
    //   24	60	1	localObject1	Object
    //   94	1	1	localIOException1	java.io.IOException
    //   99	13	1	str1	String
    //   113	1	1	localIOException2	java.io.IOException
    //   126	1	1	localObject2	Object
    //   40	49	2	localBufferedReader	java.io.BufferedReader
    //   97	12	2	localObject3	Object
    //   110	1	2	localIOException3	java.io.IOException
    //   117	1	2	localObject4	Object
    //   47	18	3	str2	String
    //   72	6	3	localException1	Exception
    //   121	5	3	localException2	Exception
    //   1	81	4	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   25	41	72	java/lang/Exception
    //   88	92	94	java/io/IOException
    //   25	41	97	finally
    //   66	70	110	java/io/IOException
    //   104	108	113	java/io/IOException
    //   43	48	117	finally
    //   50	57	117	finally
    //   59	64	117	finally
    //   77	81	117	finally
    //   43	48	121	java/lang/Exception
    //   50	57	121	java/lang/Exception
    //   59	64	121	java/lang/Exception
  }
  
  public static String a(long paramLong, String paramString)
  {
    try
    {
      paramString = new SimpleDateFormat(paramString);
      Calendar localCalendar = Calendar.getInstance();
      localCalendar.setTimeInMillis(paramLong);
      paramString = paramString.format(localCalendar.getTime());
      return paramString;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
    return "";
  }
  
  public static String a(Context paramContext, int paramInt)
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
  
  public static String a(Throwable paramThrowable)
  {
    paramThrowable = Log.getStackTraceString(paramThrowable);
    if (!TextUtils.isEmpty(paramThrowable))
    {
      paramThrowable = paramThrowable.split("\n");
      if (paramThrowable.length >= 2) {
        return paramThrowable[0] + paramThrowable[1];
      }
      if (paramThrowable.length == 1) {
        return paramThrowable[0];
      }
      return "";
    }
    return "";
  }
  
  private static String a(InetAddress paramInetAddress)
  {
    for (;;)
    {
      int i;
      try
      {
        paramInetAddress = paramInetAddress.getAddress();
        StringBuilder localStringBuilder1 = new StringBuilder();
        i = 0;
        if (i < paramInetAddress.length)
        {
          StringBuilder localStringBuilder2 = new StringBuilder(".");
          if (paramInetAddress[i] < 0)
          {
            j = paramInetAddress[i] + 256;
            localStringBuilder1.append(j);
            i += 1;
          }
        }
        else
        {
          paramInetAddress = localStringBuilder1.substring(1);
          return paramInetAddress;
        }
      }
      catch (Throwable paramInetAddress)
      {
        return "";
      }
      int j = paramInetAddress[i];
    }
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
        localObject = b;
        if (localObject != null) {
          continue;
        }
        if (i != 0)
        {
          localObject = (TelephonyManager)l.a().getSystemService("phone");
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
    StringBuffer localStringBuffer = new StringBuffer("size:" + j + ",content:");
    i = 0;
    while (i < j)
    {
      localStringBuffer.append(Integer.toHexString(paramArrayOfByte[i] >> 4 & 0xF));
      localStringBuffer.append(Integer.toHexString(paramArrayOfByte[i] & 0xF));
      i += 1;
    }
    return localStringBuffer.toString();
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
          localObject = (WifiManager)l.a().getSystemService("wifi");
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
  
  public static String c(String paramString)
  {
    try
    {
      paramString = a(InetAddress.getByName(paramString));
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
    StringBuilder localStringBuilder = new StringBuilder("");
    localStringBuilder.append(a());
    localStringBuilder.append(c());
    localStringBuilder.append(System.currentTimeMillis());
    localStringBuilder.append(b());
    localStringBuilder.append((int)(Math.random() * 2147483647.0D));
    return cg.a(localStringBuilder.toString());
  }
  
  public static boolean d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      paramString = paramString.split("\\.");
      int i;
      String str;
      if (paramString.length == 4)
      {
        int j = paramString.length;
        i = 0;
        if (i < j) {
          str = paramString[i];
        }
      }
      try
      {
        int k = Integer.parseInt(str);
        if ((k >= 0) && (k <= 255)) {
          i += 1;
        }
      }
      catch (NumberFormatException paramString) {}
    }
    return true;
    return false;
  }
  
  public static String e()
  {
    int i = 1;
    try
    {
      String str = d;
      if (str == null) {}
      for (;;)
      {
        if (i != 0) {
          d = Settings.Secure.getString(l.a().getContentResolver(), "android_id");
        }
        return d;
        int j = str.trim().length();
        if (j != 0) {
          i = 0;
        }
      }
      return "";
    }
    catch (Throwable localThrowable) {}
  }
  
  public static String f()
  {
    try
    {
      String str = "35" + Build.BOARD.length() % 10 + Build.BRAND.length() % 10 + Build.CPU_ABI.length() % 10 + Build.DEVICE.length() % 10 + Build.DISPLAY.length() % 10 + Build.HOST.length() % 10 + Build.ID.length() % 10 + Build.MANUFACTURER.length() % 10 + Build.MODEL.length() % 10 + Build.PRODUCT.length() % 10 + Build.TAGS.length() % 10 + Build.TYPE.length() % 10 + Build.USER.length() % 10;
      return str;
    }
    catch (Throwable localThrowable) {}
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.ch
 * JD-Core Version:    0.7.0.1
 */
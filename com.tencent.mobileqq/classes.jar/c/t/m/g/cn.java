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
import com.tencent.mobileqq.qmethodmonitor.monitor.NetworkMonitor;
import com.tencent.mobileqq.qmethodmonitor.monitor.PhoneInfoMonitor;
import java.net.InetAddress;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public final class cn
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
      localObject = (TelephonyManager)m.a().getSystemService("phone");
      if (localObject != null)
      {
        str = PhoneInfoMonitor.getDeviceId((TelephonyManager)localObject);
        localObject = str;
        if (str == null) {
          localObject = "NOIMEI";
        }
        a = (String)localObject;
      }
    }
    return a;
  }
  
  /* Error */
  public static String a(int paramInt)
  {
    // Byte code:
    //   0: new 68	java/lang/StringBuilder
    //   3: dup
    //   4: ldc 70
    //   6: invokespecial 74	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   9: astore_1
    //   10: aload_1
    //   11: iload_0
    //   12: invokevirtual 78	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   15: pop
    //   16: aload_1
    //   17: ldc 80
    //   19: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: pop
    //   23: aload_1
    //   24: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   27: astore_2
    //   28: aconst_null
    //   29: astore_1
    //   30: new 88	java/io/BufferedReader
    //   33: dup
    //   34: new 90	java/io/FileReader
    //   37: dup
    //   38: aload_2
    //   39: invokespecial 91	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   42: invokespecial 94	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   45: astore_2
    //   46: aload_2
    //   47: astore_1
    //   48: aload_2
    //   49: invokevirtual 97	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   52: astore 4
    //   54: aload 4
    //   56: astore_3
    //   57: aload_2
    //   58: astore_1
    //   59: aload 4
    //   61: invokestatic 103	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   64: ifne +11 -> 75
    //   67: aload_2
    //   68: astore_1
    //   69: aload 4
    //   71: invokevirtual 34	java/lang/String:trim	()Ljava/lang/String;
    //   74: astore_3
    //   75: aload_2
    //   76: invokevirtual 106	java/io/BufferedReader:close	()V
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
    //   99: invokevirtual 109	java/lang/Exception:printStackTrace	()V
    //   102: aload_2
    //   103: ifnull +7 -> 110
    //   106: aload_2
    //   107: invokevirtual 106	java/io/BufferedReader:close	()V
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
    //   122: invokevirtual 106	java/io/BufferedReader:close	()V
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
  
  private static String a(InetAddress paramInetAddress)
  {
    for (;;)
    {
      try
      {
        paramInetAddress = paramInetAddress.getAddress();
        localStringBuilder1 = new StringBuilder();
        i = 0;
        if (i >= paramInetAddress.length) {
          continue;
        }
        localStringBuilder2 = new StringBuilder(".");
        if (paramInetAddress[i] >= 0) {
          continue;
        }
        j = paramInetAddress[i] + 256;
      }
      catch (Throwable paramInetAddress)
      {
        StringBuilder localStringBuilder1;
        int i;
        StringBuilder localStringBuilder2;
        continue;
        int j = paramInetAddress[i];
        continue;
      }
      localStringBuilder2.append(j);
      localStringBuilder1.append(localStringBuilder2.toString());
      i += 1;
    }
    paramInetAddress = localStringBuilder1.substring(1);
    return paramInetAddress;
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
      localObject = b;
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
      localObject = (TelephonyManager)m.a().getSystemService("phone");
      if (localObject != null)
      {
        str = PhoneInfoMonitor.getSubscriberId((TelephonyManager)localObject);
        localObject = str;
        if (str == null) {
          localObject = "NOIMSI";
        }
        b = (String)localObject;
      }
    }
    return b;
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
      localObject = c;
      i = 1;
      if (localObject != null) {
        if (((String)localObject).trim().length() != 0) {
          break label84;
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
        label84:
        int i = 0;
      }
    }
    if (i != 0)
    {
      localObject = (WifiManager)m.a().getApplicationContext().getSystemService("wifi");
      if (localObject != null)
      {
        localObject = NetworkMonitor.getConnectionInfo((WifiManager)localObject);
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
    try
    {
      Object localObject = new StringBuilder("");
      ((StringBuilder)localObject).append(a());
      ((StringBuilder)localObject).append(c());
      ((StringBuilder)localObject).append(System.currentTimeMillis());
      ((StringBuilder)localObject).append(b());
      ((StringBuilder)localObject).append((int)(Math.random() * 2147483647.0D));
      localObject = cm.a(((StringBuilder)localObject).toString());
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return "";
  }
  
  public static boolean d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
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
      String str = d;
      i = 1;
      if (str != null) {
        if (str.trim().length() != 0) {
          break label56;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        continue;
        label56:
        int i = 0;
      }
    }
    if (i != 0) {
      d = Settings.Secure.getString(m.a().getContentResolver(), "android_id");
    }
    return d;
    return "";
  }
  
  public static String f()
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
      label200:
      break label200;
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.cn
 * JD-Core Version:    0.7.0.1
 */
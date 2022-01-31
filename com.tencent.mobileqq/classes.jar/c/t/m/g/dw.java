package c.t.m.g;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.Locale;

public final class dw
{
  private static String a = "0123456789ABCDEF";
  private static String b = "0123456789ABCDEF";
  private static String c = "0123456789ABCDEF";
  
  public static String a()
  {
    return a(do.a());
  }
  
  @Deprecated
  @SuppressLint({"MissingPermission"})
  private static String a(Context paramContext)
  {
    if ((TextUtils.isEmpty(a)) || ("0123456789ABCDEF".equals(a))) {}
    for (;;)
    {
      try
      {
        paramContext = (TelephonyManager)paramContext.getSystemService("phone");
        boolean bool = do.a;
        if (Build.VERSION.SDK_INT < 26) {
          continue;
        }
        paramContext = paramContext.getImei();
        a = du.a(paramContext, du.a).toUpperCase(Locale.ENGLISH);
      }
      catch (Throwable paramContext)
      {
        continue;
      }
      return a(a);
      paramContext = paramContext.getDeviceId();
    }
  }
  
  private static String a(String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "0123456789ABCDEF";
    }
    return str;
  }
  
  public static String b()
  {
    return b(do.a());
  }
  
  @Deprecated
  @SuppressLint({"MissingPermission"})
  private static String b(Context paramContext)
  {
    if (TextUtils.isEmpty(b))
    {
      boolean bool = do.a;
      if (!"0123456789ABCDEF".equals(b)) {}
    }
    try
    {
      b = du.a(((TelephonyManager)paramContext.getSystemService("phone")).getSubscriberId(), du.b);
      label45:
      return a(b);
    }
    catch (Throwable paramContext)
    {
      break label45;
    }
  }
  
  @SuppressLint({"MissingPermission"})
  public static String c()
  {
    try
    {
      boolean bool = do.a;
      if (Build.VERSION.SDK_INT >= 26) {
        return Build.getSerial();
      }
      String str = Build.SERIAL;
      return str;
    }
    catch (Throwable localThrowable) {}
    return "0123456789ABCDEF";
  }
  
  public static String d()
  {
    if ((TextUtils.isEmpty(c)) || ("0123456789ABCDEF".equals(c))) {
      try
      {
        Enumeration localEnumeration = NetworkInterface.getNetworkInterfaces();
        while (localEnumeration.hasMoreElements())
        {
          Object localObject = (NetworkInterface)localEnumeration.nextElement();
          if ((localObject != null) && (((NetworkInterface)localObject).getName().equalsIgnoreCase("wlan0")))
          {
            localObject = ((NetworkInterface)localObject).getHardwareAddress();
            if ((localObject != null) && (localObject.length != 0))
            {
              StringBuilder localStringBuilder = new StringBuilder();
              int j = localObject.length;
              int i = 0;
              while (i < j)
              {
                localStringBuilder.append(String.format("%02X:", new Object[] { Byte.valueOf(localObject[i]) }));
                i += 1;
              }
              if (localStringBuilder.length() > 0) {
                localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
              }
              c = localStringBuilder.toString();
            }
          }
        }
        return a(c);
      }
      catch (Throwable localThrowable) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     c.t.m.g.dw
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.luggage.wxa.qz;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;

public class x
{
  private static PhoneStateListener a;
  private static int b = 10000;
  private static int c = b;
  private static int d = -1;
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 2) || (paramInt == 5) || (paramInt == 7) || (paramInt == 3);
  }
  
  public static boolean a(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null) {
      return false;
    }
    paramContext = paramContext.getActiveNetworkInfo();
    try
    {
      boolean bool = paramContext.isConnected();
      return bool;
    }
    catch (Exception paramContext) {}
    return false;
  }
  
  public static String b(Context paramContext)
  {
    try
    {
      paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (paramContext == null) {
        return "NON_NETWORK";
      }
      paramContext = paramContext.getActiveNetworkInfo();
      if (paramContext == null) {
        return "NON_NETWORK";
      }
      if (paramContext.getType() == 1) {
        return "WIFI";
      }
      o.e("MicroMsg.NetStatusUtil", "activeNetInfo extra=%s, type=%d", new Object[] { paramContext.getExtraInfo(), Integer.valueOf(paramContext.getType()) });
      if (paramContext.getExtraInfo() != null) {
        return paramContext.getExtraInfo();
      }
      return "MOBILE";
    }
    catch (Exception paramContext)
    {
      o.a("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
    }
    return "NON_NETWORK";
  }
  
  public static boolean b(int paramInt)
  {
    return paramInt == 0;
  }
  
  public static String c(Context paramContext)
  {
    if (f(paramContext)) {
      return "2G";
    }
    if (i(paramContext)) {
      return "3G";
    }
    if (g(paramContext)) {
      return "4G";
    }
    if (h(paramContext)) {
      return "5G";
    }
    if (j(paramContext)) {
      return "WIFI";
    }
    return b(paramContext);
  }
  
  public static int d(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null) {
      return -1;
    }
    paramContext = paramContext.getActiveNetworkInfo();
    if (paramContext == null) {
      return -1;
    }
    if (paramContext.getType() == 1) {
      return 0;
    }
    o.e("MicroMsg.NetStatusUtil", "activeNetInfo extra=%s, type=%d", new Object[] { paramContext.getExtraInfo(), Integer.valueOf(paramContext.getType()) });
    if (paramContext.getExtraInfo() != null)
    {
      if (paramContext.getExtraInfo().equalsIgnoreCase("uninet")) {
        return 1;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("uniwap")) {
        return 2;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("3gwap")) {
        return 3;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("3gnet")) {
        return 4;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("cmwap")) {
        return 5;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("cmnet")) {
        return 6;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("ctwap")) {
        return 7;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("ctnet")) {
        return 8;
      }
      if (paramContext.getExtraInfo().equalsIgnoreCase("LTE")) {
        return 10;
      }
    }
    return 9;
  }
  
  public static int e(Context paramContext)
  {
    paramContext = (TelephonyManager)paramContext.getSystemService("phone");
    if (paramContext == null) {
      return 0;
    }
    paramContext = paramContext.getSimOperator();
    StringBuilder localStringBuilder;
    if (paramContext != null)
    {
      if (paramContext.length() < 5) {
        return 0;
      }
      localStringBuilder = new StringBuilder();
    }
    for (;;)
    {
      try
      {
        j = paramContext.length();
        i = j;
        if (j <= 6) {
          break label129;
        }
        i = 6;
      }
      catch (Exception paramContext)
      {
        int i;
        o.a("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
      }
      if (j < i) {
        if (!Character.isDigit(paramContext.charAt(j)))
        {
          if (localStringBuilder.length() <= 0) {
            break label134;
          }
        }
        else
        {
          localStringBuilder.append(paramContext.charAt(j));
          break label134;
        }
      }
      i = Integer.valueOf(localStringBuilder.toString()).intValue();
      return i;
      return 0;
      label129:
      int j = 0;
      continue;
      label134:
      j += 1;
    }
  }
  
  public static boolean f(Context paramContext)
  {
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext == null) {
        return false;
      }
      if (paramContext.getType() == 1) {
        return false;
      }
      o.e("MicroMsg.NetStatusUtil", "is2G subtype %d", new Object[] { Integer.valueOf(paramContext.getSubtype()) });
      if ((paramContext.getSubtype() != 2) && (paramContext.getSubtype() != 1))
      {
        int i = paramContext.getSubtype();
        if (i != 4) {}
      }
      else
      {
        return true;
      }
    }
    catch (Exception paramContext)
    {
      o.a("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
    }
    return false;
  }
  
  public static boolean g(Context paramContext)
  {
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext == null) {
        return false;
      }
      if (paramContext.getType() == 1) {
        return false;
      }
      o.e("MicroMsg.NetStatusUtil", "is4G subtype %d", new Object[] { Integer.valueOf(paramContext.getSubtype()) });
      if (paramContext.getSubtype() >= 13)
      {
        int i = paramContext.getSubtype();
        if (i < 20) {
          return true;
        }
      }
    }
    catch (Exception paramContext)
    {
      o.a("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
    }
    return false;
  }
  
  public static boolean h(Context paramContext)
  {
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext == null) {
        return false;
      }
      if (paramContext.getType() == 1) {
        return false;
      }
      o.e("MicroMsg.NetStatusUtil", "is5G subtype %d", new Object[] { Integer.valueOf(paramContext.getSubtype()) });
      int i = paramContext.getSubtype();
      if (i >= 20) {
        return true;
      }
    }
    catch (Exception paramContext)
    {
      o.a("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
    }
    return false;
  }
  
  public static boolean i(Context paramContext)
  {
    try
    {
      paramContext = ((ConnectivityManager)paramContext.getSystemService("connectivity")).getActiveNetworkInfo();
      if (paramContext == null) {
        return false;
      }
      if (paramContext.getType() == 1) {
        return false;
      }
      o.e("MicroMsg.NetStatusUtil", "is3G subtype %d", new Object[] { Integer.valueOf(paramContext.getSubtype()) });
      if (paramContext.getSubtype() >= 5)
      {
        int i = paramContext.getSubtype();
        if (i < 13) {
          return true;
        }
      }
    }
    catch (Exception paramContext)
    {
      o.a("MicroMsg.NetStatusUtil", paramContext, "", new Object[0]);
    }
    return false;
  }
  
  public static boolean j(Context paramContext)
  {
    return b(d(paramContext));
  }
  
  public static boolean k(Context paramContext)
  {
    paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
    if (paramContext == null) {
      return false;
    }
    paramContext = paramContext.getActiveNetworkInfo();
    if (paramContext == null) {
      return false;
    }
    return paramContext.getState() == NetworkInfo.State.CONNECTED;
  }
  
  public static boolean l(Context paramContext)
  {
    int i = d(paramContext);
    if ((i != 0) && (i != 10))
    {
      o.e("MicroMsg.NetStatusUtil", "[cpan] is mobile network");
      return false;
    }
    o.e("MicroMsg.NetStatusUtil", "[cpan] is wifi or 4g network");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qz.x
 * JD-Core Version:    0.7.0.1
 */
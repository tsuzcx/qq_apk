package com.tencent.map.sdk.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.map.tools.net.NetUtil;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class fz
{
  private static String A;
  private static String B;
  private static int C = 0;
  private static String D = null;
  public static final File a = new File(Environment.getExternalStorageDirectory(), "Tencent");
  public static final File b = new File(a, "MapSDK");
  public static final File c = new File(b, "Caches");
  public static String d;
  public static String e = "undefined";
  public static float f = 1.0F;
  public static int g = 2;
  public static int h = 0;
  public static int i = 0;
  public static int j = 0;
  public static boolean k = false;
  public static Bitmap l = null;
  public static final int m = Color.argb(200, 0, 163, 255);
  public static String n = "tencentmap/mapsdk_vector/mark_location_big.png";
  public static int o = 2;
  public static int p = 4000000;
  public static int q = 53500000;
  public static int r = 73670000;
  public static int s = 135100000;
  public static int t = 0;
  public static int u = 160;
  public static float v = 0.0F;
  private static String w = null;
  private static String x = null;
  private static String y = null;
  private static String z = null;
  
  static
  {
    A = null;
    B = null;
    d = null;
  }
  
  public static double a(double paramDouble1, double paramDouble2)
  {
    return 6.698324247899813D * paramDouble1 / Math.cos(0.0174532925199433D * paramDouble2);
  }
  
  public static int a(String paramString1, String paramString2)
  {
    if (nl.a(paramString2)) {
      return 1;
    }
    if (nl.a(paramString1)) {
      return -1;
    }
    String[] arrayOfString1 = paramString1.split("\\.");
    String[] arrayOfString2 = paramString2.split("\\.");
    int i2 = arrayOfString1.length;
    int i1 = i2;
    if (i2 > arrayOfString2.length) {
      i1 = arrayOfString2.length;
    }
    i2 = 0;
    while (i2 < i1)
    {
      paramString2 = arrayOfString2[i2];
      String str = arrayOfString1[i2];
      paramString1 = paramString2;
      if (TextUtils.isEmpty(paramString2)) {
        paramString1 = "0";
      }
      paramString2 = str;
      if (TextUtils.isEmpty(str)) {
        paramString2 = "0";
      }
      if (Integer.valueOf(paramString1).intValue() < Integer.valueOf(paramString2).intValue()) {
        return 1;
      }
      if (Integer.valueOf(paramString1).intValue() > Integer.valueOf(paramString2).intValue()) {
        return -1;
      }
      i2 += 1;
    }
    if (arrayOfString1.length > arrayOfString2.length) {
      return 1;
    }
    if (arrayOfString1.length == arrayOfString2.length) {
      return 0;
    }
    return -1;
  }
  
  public static GeoPoint a(LatLng paramLatLng)
  {
    if (paramLatLng == null) {
      return null;
    }
    return new GeoPoint((int)(paramLatLng.latitude * 1000000.0D), (int)(paramLatLng.longitude * 1000000.0D));
  }
  
  public static LatLng a(GeoPoint paramGeoPoint)
  {
    if (paramGeoPoint == null) {
      return null;
    }
    return new LatLng(paramGeoPoint.getLatitudeE6() / 1000000.0D, paramGeoPoint.getLongitudeE6() / 1000000.0D);
  }
  
  public static String a()
  {
    if (A == null) {
      return "";
    }
    return A;
  }
  
  public static String a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(256);
    if (!TextUtils.isEmpty(A))
    {
      localStringBuilder.append("&deviceid=");
      localStringBuilder.append(A);
    }
    if (!TextUtils.isEmpty(d))
    {
      localStringBuilder.append("&appid=");
      localStringBuilder.append(d);
    }
    if (!TextUtils.isEmpty("4.2.8"))
    {
      localStringBuilder.append("&sdkver=");
      localStringBuilder.append("4.2.8");
    }
    if (!TextUtils.isEmpty(paramString))
    {
      localStringBuilder.append("&ui=");
      localStringBuilder.append(paramString);
    }
    if (!TextUtils.isEmpty(e)) {
      localStringBuilder.append("&appsuid=");
    }
    try
    {
      localStringBuilder.append(URLEncoder.encode(e, "UTF-8"));
      localStringBuilder.append("&api_key=" + pz.a);
      return localStringBuilder.toString();
    }
    catch (UnsupportedEncodingException paramString)
    {
      for (;;)
      {
        localStringBuilder.append(c(e));
      }
    }
  }
  
  public static List<GeoPoint> a(List<LatLng> paramList)
  {
    int i1 = 0;
    if ((paramList == null) || (paramList.isEmpty())) {
      return new ArrayList(0);
    }
    int i2 = paramList.size();
    ArrayList localArrayList = new ArrayList(i2);
    while (i1 < i2)
    {
      Object localObject = (LatLng)paramList.get(i1);
      if (localObject != null)
      {
        localObject = a((LatLng)localObject);
        if (localObject != null) {
          localArrayList.add(localObject);
        }
      }
      i1 += 1;
    }
    return localArrayList;
  }
  
  public static void a(Context paramContext)
  {
    om.a = c;
    if (D == null) {}
    try
    {
      String str = Build.MODEL;
      D = str;
      str = b(str);
      D = str;
      D = URLEncoder.encode(str, "utf-8");
      label39:
      if (C == 0) {
        C = Build.VERSION.SDK_INT;
      }
      if (d == null) {}
      try
      {
        str = paramContext.getPackageName();
        d = str;
        str = b(str);
        d = str;
        d = URLEncoder.encode(str, "utf-8");
        label85:
        if (x == null) {}
        try
        {
          str = pz.g(paramContext);
          x = str;
          str = b(str);
          x = str;
          x = URLEncoder.encode(str, "utf-8");
          label119:
          if (y == null) {}
          try
          {
            str = pz.d(paramContext);
            y = str;
            str = b(str);
            y = str;
            y = URLEncoder.encode(str, "utf-8");
            label153:
            if (z == null) {}
            try
            {
              str = pz.h(paramContext);
              z = str;
              str = b(str);
              z = str;
              z = URLEncoder.encode(str, "utf-8");
              label187:
              if (A == null) {}
              try
              {
                str = pz.f(paramContext);
                A = str;
                str = b(str);
                A = str;
                A = URLEncoder.encode(str, "utf-8");
                label221:
                if (B == null) {}
                try
                {
                  str = NetUtil.getNetTypeStr(paramContext);
                  B = str;
                  str = b(str);
                  B = str;
                  B = URLEncoder.encode(str, "utf-8");
                  label255:
                  if (w == null) {}
                  try
                  {
                    str = pz.e(paramContext);
                    w = str;
                    str = c(str);
                    w = str;
                    w = URLEncoder.encode(str, "utf-8");
                    label289:
                    if (pz.a == null) {}
                    try
                    {
                      str = pz.a(paramContext, "TencentMapSDK");
                      pz.a = str;
                      pz.a = URLEncoder.encode(str, "utf-8");
                      label317:
                      if (f == 1.0F) {
                        f = 320.0F / paramContext.getResources().getDisplayMetrics().densityDpi;
                      }
                      v = paramContext.getResources().getDisplayMetrics().density;
                      k = gf.a(paramContext).c("worldMapEnabled");
                      return;
                    }
                    catch (Exception localException1)
                    {
                      break label317;
                    }
                  }
                  catch (Exception localException2)
                  {
                    break label289;
                  }
                }
                catch (Exception localException3)
                {
                  break label255;
                }
              }
              catch (Exception localException4)
              {
                break label221;
              }
            }
            catch (Exception localException5)
            {
              break label187;
            }
          }
          catch (Exception localException6)
          {
            break label153;
          }
        }
        catch (Exception localException7)
        {
          break label119;
        }
      }
      catch (Exception localException8)
      {
        break label85;
      }
    }
    catch (Exception localException9)
    {
      break label39;
    }
  }
  
  public static String b()
  {
    if (B == null) {
      return "";
    }
    return B;
  }
  
  private static String b(String paramString)
  {
    if (paramString == null) {
      return "";
    }
    return paramString.replace("&", "").replace("#", "").replace("?", "");
  }
  
  public static void b(Context paramContext)
  {
    if (paramContext == null) {
      return;
    }
    DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
    t = localDisplayMetrics.widthPixels * localDisplayMetrics.heightPixels;
    if (Build.VERSION.SDK_INT < 24) {
      paramContext = null;
    }
    try
    {
      Field localField = localDisplayMetrics.getClass().getField("densityDpi");
      paramContext = localField;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      break label48;
    }
    catch (SecurityException localSecurityException)
    {
      label48:
      break label48;
    }
    if (paramContext != null) {
      try
      {
        u = paramContext.getInt(localDisplayMetrics);
        i();
        return;
      }
      catch (IllegalArgumentException paramContext)
      {
        paramContext.printStackTrace();
        return;
      }
      catch (IllegalAccessException paramContext)
      {
        paramContext.printStackTrace();
        return;
      }
    }
    j();
    return;
    u = localDisplayMetrics.densityDpi;
    i();
  }
  
  public static String c()
  {
    if (D == null) {
      return "";
    }
    return D;
  }
  
  private static String c(String paramString)
  {
    return Pattern.compile("[^a-zA-Z0-9]").matcher(paramString).replaceAll("").trim();
  }
  
  public static int d()
  {
    if (C == 0) {
      return 0;
    }
    return C;
  }
  
  public static String e()
  {
    if (y == null) {
      return "";
    }
    return y;
  }
  
  public static String f()
  {
    if (z == null) {
      return "";
    }
    return z;
  }
  
  public static String g()
  {
    if (d == null) {
      return "";
    }
    return d;
  }
  
  public static void h()
  {
    r = 73670000;
    s = 135100000;
    q = 53500000;
    p = 4000000;
  }
  
  private static void i()
  {
    if (u <= 120)
    {
      o = 1;
      return;
    }
    if (u <= 160)
    {
      o = 2;
      return;
    }
    if (u <= 240)
    {
      o = 3;
      return;
    }
    j();
  }
  
  private static void j()
  {
    if (t > 153600)
    {
      o = 3;
      return;
    }
    if (t < 153600)
    {
      o = 1;
      return;
    }
    o = 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.fz
 * JD-Core Version:    0.7.0.1
 */
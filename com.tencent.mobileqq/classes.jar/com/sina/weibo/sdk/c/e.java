package com.sina.weibo.sdk.c;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.sina.weibo.sdk.a.a;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;

public final class e
{
  private static char[] aq = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=".toCharArray();
  private static byte[] ar = new byte[256];
  
  static
  {
    int i = 0;
    while (i < 256)
    {
      ar[i] = -1;
      i += 1;
    }
    i = 65;
    while (i <= 90)
    {
      ar[i] = ((byte)(i - 65));
      i += 1;
    }
    i = 97;
    while (i <= 122)
    {
      ar[i] = ((byte)(i + 26 - 97));
      i += 1;
    }
    i = 48;
    while (i <= 57)
    {
      ar[i] = ((byte)(i + 52 - 48));
      i += 1;
    }
    byte[] arrayOfByte = ar;
    arrayOfByte[43] = 62;
    arrayOfByte[47] = 63;
  }
  
  public static int a(int paramInt, Context paramContext)
  {
    float f = paramContext.getResources().getDisplayMetrics().density;
    return (int)(paramInt * f + 0.5F);
  }
  
  public static byte[] b(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[(paramArrayOfByte.length + 2) / 3 * 4];
    int j = 0;
    int i = 0;
    while (j < paramArrayOfByte.length)
    {
      int m = (paramArrayOfByte[j] & 0xFF) << 8;
      int k = j + 1;
      int i1 = paramArrayOfByte.length;
      int n = 1;
      if (k < i1)
      {
        m |= paramArrayOfByte[k] & 0xFF;
        k = 1;
      }
      else
      {
        k = 0;
      }
      m <<= 8;
      i1 = j + 2;
      if (i1 < paramArrayOfByte.length) {
        m |= paramArrayOfByte[i1] & 0xFF;
      } else {
        n = 0;
      }
      char[] arrayOfChar = aq;
      i1 = 64;
      if (n != 0) {
        n = m & 0x3F;
      } else {
        n = 64;
      }
      arrayOfByte[(i + 3)] = ((byte)arrayOfChar[n]);
      n = m >> 6;
      arrayOfChar = aq;
      m = i1;
      if (k != 0) {
        m = n & 0x3F;
      }
      arrayOfByte[(i + 2)] = ((byte)arrayOfChar[m]);
      k = n >> 6;
      arrayOfChar = aq;
      arrayOfByte[(i + 1)] = ((byte)arrayOfChar[(k & 0x3F)]);
      arrayOfByte[(i + 0)] = ((byte)arrayOfChar[(k >> 6 & 0x3F)]);
      j += 3;
      i += 4;
    }
    return arrayOfByte;
  }
  
  public static String e(Context paramContext, String paramString)
  {
    try
    {
      paramContext = paramContext.getPackageManager().getPackageInfo(paramString, 64);
      if (paramContext != null)
      {
        paramContext = paramContext.signatures;
        if ((paramContext != null) && (paramContext.length > 0))
        {
          paramContext = d.a(paramContext[0].toByteArray());
          return paramContext;
        }
      }
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext.printStackTrace();
    }
    return null;
  }
  
  public static Bundle f(String paramString)
  {
    try
    {
      paramString = h(new URL(paramString).getQuery());
      return paramString;
    }
    catch (MalformedURLException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static String f(Context paramContext, String paramString)
  {
    Object localObject1 = a.b();
    if (TextUtils.isEmpty(((a)localObject1).c))
    {
      ((a)localObject1).b(paramContext, paramString);
      localObject1 = "";
    }
    else
    {
      localObject1 = ((a)localObject1).c;
    }
    Object localObject2 = localObject1;
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      localObject2 = a.b().c(paramContext, paramString);
    }
    return localObject2;
  }
  
  public static Bundle g(String paramString)
  {
    try
    {
      paramString = h(new URI(paramString).getQuery());
      return paramString;
    }
    catch (URISyntaxException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  private static Bundle h(String paramString)
  {
    Bundle localBundle = new Bundle();
    if (paramString != null)
    {
      paramString = paramString.split("&");
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        String[] arrayOfString = paramString[i].split("=");
        try
        {
          int k = arrayOfString.length;
          if (k == 2) {
            localBundle.putString(URLDecoder.decode(arrayOfString[0], "UTF-8"), URLDecoder.decode(arrayOfString[1], "UTF-8"));
          } else if (arrayOfString.length == 1) {
            localBundle.putString(URLDecoder.decode(arrayOfString[0], "UTF-8"), "");
          }
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          localUnsupportedEncodingException.printStackTrace();
        }
        i += 1;
      }
    }
    return localBundle;
  }
  
  public static String r()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Build.MANUFACTURER);
    localStringBuilder.append("-");
    localStringBuilder.append(Build.MODEL);
    localStringBuilder.append("_");
    localStringBuilder.append(Build.VERSION.RELEASE);
    localStringBuilder.append("_");
    localStringBuilder.append("weibosdk");
    localStringBuilder.append("_");
    localStringBuilder.append("0041005000");
    localStringBuilder.append("_android");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.sina.weibo.sdk.c.e
 * JD-Core Version:    0.7.0.1
 */
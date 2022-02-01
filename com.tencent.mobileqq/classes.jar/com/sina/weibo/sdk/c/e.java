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
    ar[43] = 62;
    ar[47] = 63;
  }
  
  public static int a(int paramInt, Context paramContext)
  {
    return (int)(paramContext.getResources().getDisplayMetrics().density * paramInt + 0.5F);
  }
  
  public static byte[] b(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[(paramArrayOfByte.length + 2) / 3 * 4];
    int i = 0;
    int j = 0;
    int m;
    if (j < paramArrayOfByte.length)
    {
      m = (paramArrayOfByte[j] & 0xFF) << 8;
      if (j + 1 >= paramArrayOfByte.length) {
        break label224;
      }
      m |= paramArrayOfByte[(j + 1)] & 0xFF;
    }
    label209:
    label224:
    for (int k = 1;; k = 0)
    {
      m <<= 8;
      if (j + 2 < paramArrayOfByte.length) {
        m |= paramArrayOfByte[(j + 2)] & 0xFF;
      }
      for (int n = 1;; n = 0)
      {
        char[] arrayOfChar = aq;
        if (n != 0)
        {
          n = m & 0x3F;
          label107:
          arrayOfByte[(i + 3)] = ((byte)arrayOfChar[n]);
          m >>= 6;
          arrayOfChar = aq;
          if (k == 0) {
            break label209;
          }
        }
        for (k = m & 0x3F;; k = 64)
        {
          arrayOfByte[(i + 2)] = ((byte)arrayOfChar[k]);
          k = m >> 6;
          arrayOfByte[(i + 1)] = ((byte)aq[(k & 0x3F)]);
          arrayOfByte[(i + 0)] = ((byte)aq[(k >> 6 & 0x3F)]);
          j += 3;
          i += 4;
          break;
          n = 64;
          break label107;
        }
        return arrayOfByte;
      }
    }
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
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext.printStackTrace();
      return null;
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        paramContext.printStackTrace();
      }
    }
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
    if (TextUtils.isEmpty(((a)localObject1).c)) {
      ((a)localObject1).b(paramContext, paramString);
    }
    for (localObject1 = "";; localObject1 = ((a)localObject1).c)
    {
      Object localObject2 = localObject1;
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = a.b().c(paramContext, paramString);
      }
      return localObject2;
    }
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
    int j;
    int i;
    if (paramString != null)
    {
      paramString = paramString.split("&");
      j = paramString.length;
      i = 0;
    }
    for (;;)
    {
      if (i < j)
      {
        String[] arrayOfString = paramString[i].split("=");
        try
        {
          if (arrayOfString.length == 2) {
            localBundle.putString(URLDecoder.decode(arrayOfString[0], "UTF-8"), URLDecoder.decode(arrayOfString[1], "UTF-8"));
          } else if (arrayOfString.length == 1) {
            localBundle.putString(URLDecoder.decode(arrayOfString[0], "UTF-8"), "");
          }
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          localUnsupportedEncodingException.printStackTrace();
        }
      }
      else
      {
        return localBundle;
      }
      i += 1;
    }
  }
  
  public static String r()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Build.MANUFACTURER).append("-").append(Build.MODEL);
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
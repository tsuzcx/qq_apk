package com.huawei.agconnect.config.a;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class f
  implements b
{
  private final Context a;
  private final String b;
  
  f(Context paramContext, String paramString)
  {
    this.a = paramContext;
    this.b = paramString;
  }
  
  private static String a(String paramString)
  {
    try
    {
      paramString = "agc_" + c.a(a(paramString.getBytes("UTF-8")));
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      return "";
    }
    catch (NoSuchAlgorithmException paramString) {}
    return "";
  }
  
  private static byte[] a(byte[] paramArrayOfByte)
  {
    return MessageDigest.getInstance("SHA-256").digest(paramArrayOfByte);
  }
  
  public String a(String paramString1, String paramString2)
  {
    paramString1 = a(paramString1);
    if (TextUtils.isEmpty(paramString1)) {}
    int i;
    do
    {
      return paramString2;
      i = this.a.getResources().getIdentifier(paramString1, "string", this.b);
    } while (i == 0);
    try
    {
      paramString1 = this.a.getResources().getString(i);
      return paramString1;
    }
    catch (Resources.NotFoundException paramString1) {}
    return paramString2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.agconnect.config.a.f
 * JD-Core Version:    0.7.0.1
 */
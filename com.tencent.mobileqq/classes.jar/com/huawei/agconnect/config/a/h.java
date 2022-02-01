package com.huawei.agconnect.config.a;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

class h
  implements d
{
  private final Context a;
  private final String b;
  
  h(Context paramContext, String paramString)
  {
    this.a = paramContext;
    this.b = paramString;
  }
  
  private static String a(String paramString)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("agc_");
      localStringBuilder.append(e.a(a(paramString.getBytes("UTF-8"))));
      paramString = localStringBuilder.toString();
      return paramString;
    }
    catch (UnsupportedEncodingException|NoSuchAlgorithmException paramString) {}
    return "";
  }
  
  private static byte[] a(byte[] paramArrayOfByte)
  {
    return MessageDigest.getInstance("SHA-256").digest(paramArrayOfByte);
  }
  
  public String getString(String paramString1, String paramString2)
  {
    paramString1 = a(paramString1);
    if (TextUtils.isEmpty(paramString1)) {
      return paramString2;
    }
    int i = this.a.getResources().getIdentifier(paramString1, "string", this.b);
    if (i == 0) {
      return paramString2;
    }
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
 * Qualified Name:     com.huawei.agconnect.config.a.h
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.gathererga.ad.internal;

import android.text.TextUtils;

public final class AdMacAddressMD5Digest
{
  public static String a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = AdMessageDigestUtil.a(paramString.replaceAll(":", "").toUpperCase(), "UTF-8");
      if (!TextUtils.isEmpty(paramString)) {}
    }
    else
    {
      return null;
    }
    return paramString.toLowerCase();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gathererga.ad.internal.AdMacAddressMD5Digest
 * JD-Core Version:    0.7.0.1
 */
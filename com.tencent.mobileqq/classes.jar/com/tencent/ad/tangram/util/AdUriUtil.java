package com.tencent.ad.tangram.util;

import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Build;
import android.os.Build.VERSION;
import android.support.annotation.Keep;
import android.text.TextUtils;
import com.tencent.ad.tangram.log.AdLog;

@Keep
public final class AdUriUtil
{
  private static final String TAG = "AdUriUtil";
  
  public static String getQueryParameter(Uri paramUri, String paramString)
  {
    if (paramUri != null)
    {
      if (TextUtils.isEmpty(paramString)) {
        return null;
      }
      try
      {
        paramUri = paramUri.getQueryParameter(paramString);
        return paramUri;
      }
      catch (Throwable paramUri)
      {
        AdLog.e("AdUriUtil", "getQueryParameter", paramUri);
      }
    }
    return null;
  }
  
  public static Uri parse(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = Uri.parse(paramString);
      return paramString;
    }
    catch (Throwable paramString)
    {
      AdLog.e("AdUriUtil", "parse", paramString);
    }
    return null;
  }
  
  public static String replaceHttpsWithHttpForVivoY67OnAndroidM(String paramString)
  {
    if (TextUtils.isEmpty(Build.MODEL)) {
      return paramString;
    }
    if (!Build.MODEL.toLowerCase().contains("vivo")) {
      return paramString;
    }
    if (!Build.MODEL.toLowerCase().contains("y67")) {
      return paramString;
    }
    if (Build.VERSION.SDK_INT != 23) {
      return paramString;
    }
    return replaceSchemaOfUrl(paramString, "https", "http");
  }
  
  private static String replaceSchemaOfUrl(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return paramString1;
    }
    if (TextUtils.isEmpty(paramString2)) {
      return paramString1;
    }
    if (TextUtils.isEmpty(paramString3)) {
      return paramString1;
    }
    Uri localUri = parse(paramString1);
    if (localUri == null) {
      return paramString1;
    }
    if (!paramString2.equalsIgnoreCase(localUri.getScheme())) {
      return paramString1;
    }
    paramString2 = localUri.buildUpon();
    if (paramString2 == null) {
      return paramString1;
    }
    paramString2 = paramString2.scheme(paramString3);
    if (paramString2 == null) {
      return paramString1;
    }
    return paramString2.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.util.AdUriUtil
 * JD-Core Version:    0.7.0.1
 */
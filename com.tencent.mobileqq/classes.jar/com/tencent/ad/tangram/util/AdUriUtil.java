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
    if ((paramUri == null) || (TextUtils.isEmpty(paramString))) {
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
    if (TextUtils.isEmpty(Build.MODEL)) {}
    while ((!Build.MODEL.toLowerCase().contains("vivo")) || (!Build.MODEL.toLowerCase().contains("y67")) || (Build.VERSION.SDK_INT != 23)) {
      return paramString;
    }
    return replaceSchemaOfUrl(paramString, "https", "http");
  }
  
  private static String replaceSchemaOfUrl(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1)) {}
    do
    {
      do
      {
        Uri localUri;
        do
        {
          do
          {
            return paramString1;
          } while ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)));
          localUri = parse(paramString1);
        } while ((localUri == null) || (!paramString2.equalsIgnoreCase(localUri.getScheme())));
        paramString2 = localUri.buildUpon();
      } while (paramString2 == null);
      paramString2 = paramString2.scheme(paramString3);
    } while (paramString2 == null);
    return paramString2.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.util.AdUriUtil
 * JD-Core Version:    0.7.0.1
 */
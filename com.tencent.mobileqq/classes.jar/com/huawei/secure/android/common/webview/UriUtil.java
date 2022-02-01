package com.huawei.secure.android.common.webview;

import android.annotation.TargetApi;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.URLUtil;
import com.huawei.secure.android.common.util.LogsUtil;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

public class UriUtil
{
  private static final String TAG = "UriUtil";
  
  private static String e(String paramString)
  {
    String str;
    if (TextUtils.isEmpty(paramString))
    {
      LogsUtil.i("UriUtil", "whiteListUrl is null");
      str = null;
    }
    do
    {
      return str;
      str = paramString;
    } while (!URLUtil.isNetworkUrl(paramString));
    return getHostByURI(paramString);
  }
  
  @TargetApi(9)
  public static String getHostByURI(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      LogsUtil.i("UriUtil", "url is null");
      return paramString;
    }
    try
    {
      if (!URLUtil.isNetworkUrl(paramString))
      {
        LogsUtil.e("UriUtil", "url don't starts with http or https");
        return null;
      }
      if ((paramString.contains("{")) || (paramString.contains("}")) || (paramString.contains("[")) || (paramString.contains("]"))) {
        return new URL(paramString.replaceAll("[\\\\#]", "/")).getHost();
      }
      paramString = new URI(paramString).getHost();
      return paramString;
    }
    catch (URISyntaxException paramString)
    {
      LogsUtil.e("UriUtil", "getHostByURI error : " + paramString.getMessage());
      return null;
    }
    catch (MalformedURLException paramString)
    {
      for (;;)
      {
        LogsUtil.e("UriUtil", "getHostByURI error  MalformedURLException : " + paramString.getMessage());
      }
    }
  }
  
  public static boolean isUrlHostAndPathInWhitelist(String paramString, String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {
      LogsUtil.e("UriUtil", "whitelist is null");
    }
    for (;;)
    {
      return false;
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if (isUrlHostAndPathMatchWhitelist(paramString, paramArrayOfString[i])) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public static boolean isUrlHostAndPathMatchWhitelist(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    List localList;
    do
    {
      do
      {
        return false;
        if ((paramString1.contains("..")) || (paramString1.contains("@")))
        {
          Log.e("UriUtil", "url contains unsafe char");
          return false;
        }
        if ((paramString2.equals(paramString1)) || (paramString1.startsWith(paramString2 + "?")) || (paramString1.startsWith(paramString2 + "#"))) {
          return true;
        }
      } while (!paramString2.endsWith("/"));
      localList = Uri.parse(paramString2).getPathSegments();
    } while (Uri.parse(paramString1).getPathSegments().size() - localList.size() != 1);
    return paramString1.startsWith(paramString2);
  }
  
  public static boolean isUrlHostInWhitelist(String paramString, String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {
      LogsUtil.e("UriUtil", "whitelist is null");
    }
    for (;;)
    {
      return false;
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if (isUrlHostMatchWhitelist(paramString, paramArrayOfString[i])) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  public static boolean isUrlHostMatchWhitelist(String paramString1, String paramString2)
  {
    paramString1 = getHostByURI(paramString1);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      LogsUtil.e("UriUtil", "url or whitelist is null");
    }
    for (;;)
    {
      return false;
      paramString2 = e(paramString2);
      if (TextUtils.isEmpty(paramString2))
      {
        Log.e("UriUtil", "whitelist host is null");
        return false;
      }
      if (paramString2.equals(paramString1)) {
        return true;
      }
      if (paramString1.endsWith(paramString2)) {
        try
        {
          paramString1 = paramString1.substring(0, paramString1.length() - paramString2.length());
          if (paramString1.endsWith("."))
          {
            boolean bool = paramString1.matches("^[A-Za-z0-9.-]+$");
            return bool;
          }
        }
        catch (IndexOutOfBoundsException paramString1)
        {
          LogsUtil.e("UriUtil", "IndexOutOfBoundsException" + paramString1.getMessage());
          return false;
        }
        catch (Exception paramString1)
        {
          LogsUtil.e("UriUtil", "Exception : " + paramString1.getMessage());
        }
      }
    }
    return false;
  }
  
  public static boolean isUrlHostSameWhitelist(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      Log.e("UriUtil", "isUrlHostSameWhitelist: url or host is null");
      return false;
    }
    return TextUtils.equals(getHostByURI(paramString1), e(paramString2));
  }
  
  public static boolean isUrlHostSameWhitelist(String paramString, String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {
      LogsUtil.e("UriUtil", "whitelist is null");
    }
    for (;;)
    {
      return false;
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if (isUrlHostSameWhitelist(paramString, paramArrayOfString[i])) {
          return true;
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.secure.android.common.webview.UriUtil
 * JD-Core Version:    0.7.0.1
 */
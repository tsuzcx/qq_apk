package com.huawei.secure.android.common.webview;

import android.annotation.TargetApi;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.URLUtil;
import com.huawei.secure.android.common.util.LogsUtil;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class UriUtil
{
  private static final String TAG = "UriUtil";
  
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
        return "";
      }
      paramString = new URL(paramString.replaceAll("[\\\\#]", "/")).getHost();
      return paramString;
    }
    catch (MalformedURLException paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getHostByURI error  MalformedURLException : ");
      localStringBuilder.append(paramString.getMessage());
      LogsUtil.e("UriUtil", localStringBuilder.toString());
    }
    return "";
  }
  
  private static String i(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      LogsUtil.i("UriUtil", "whiteListUrl is null");
      return null;
    }
    if (!URLUtil.isNetworkUrl(paramString)) {
      return paramString;
    }
    return getHostByURI(paramString);
  }
  
  public static boolean isUrlHostAndPathInWhitelist(String paramString, String[] paramArrayOfString)
  {
    if ((paramArrayOfString != null) && (paramArrayOfString.length != 0))
    {
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if (isUrlHostAndPathMatchWhitelist(paramString, paramArrayOfString[i])) {
          return true;
        }
        i += 1;
      }
      return false;
    }
    LogsUtil.e("UriUtil", "whitelist is null");
    return false;
  }
  
  public static boolean isUrlHostAndPathMatchWhitelist(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return false;
      }
      if ((!paramString1.contains("..")) && (!paramString1.contains("@")))
      {
        if (!paramString2.equals(paramString1))
        {
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramString2);
          ((StringBuilder)localObject).append("?");
          if (!paramString1.startsWith(((StringBuilder)localObject).toString()))
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(paramString2);
            ((StringBuilder)localObject).append("#");
            if (paramString1.startsWith(((StringBuilder)localObject).toString())) {
              return true;
            }
            if (!paramString2.endsWith("/")) {
              return false;
            }
            localObject = Uri.parse(paramString2).getPathSegments();
            if (Uri.parse(paramString1).getPathSegments().size() - ((List)localObject).size() != 1) {
              return false;
            }
            return paramString1.startsWith(paramString2);
          }
        }
        return true;
      }
      Log.e("UriUtil", "url contains unsafe char");
    }
    return false;
  }
  
  public static boolean isUrlHostInWhitelist(String paramString, String[] paramArrayOfString)
  {
    if ((paramArrayOfString != null) && (paramArrayOfString.length != 0))
    {
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if (isUrlHostMatchWhitelist(paramString, paramArrayOfString[i])) {
          return true;
        }
        i += 1;
      }
      return false;
    }
    LogsUtil.e("UriUtil", "whitelist is null");
    return false;
  }
  
  public static boolean isUrlHostMatchWhitelist(String paramString1, String paramString2)
  {
    paramString1 = getHostByURI(paramString1);
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      paramString2 = i(paramString2);
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
          if (!paramString1.endsWith(".")) {
            return false;
          }
          boolean bool = paramString1.matches("^[A-Za-z0-9.-]+$");
          return bool;
        }
        catch (Exception paramString1)
        {
          paramString2 = new StringBuilder();
          paramString2.append("Exception : ");
          paramString2.append(paramString1.getMessage());
          LogsUtil.e("UriUtil", paramString2.toString());
          return false;
        }
        catch (IndexOutOfBoundsException paramString1)
        {
          paramString2 = new StringBuilder();
          paramString2.append("IndexOutOfBoundsException");
          paramString2.append(paramString1.getMessage());
          LogsUtil.e("UriUtil", paramString2.toString());
        }
      }
      return false;
    }
    LogsUtil.e("UriUtil", "url or whitelist is null");
    return false;
  }
  
  public static boolean isUrlHostSameWhitelist(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      return TextUtils.equals(getHostByURI(paramString1), i(paramString2));
    }
    Log.e("UriUtil", "isUrlHostSameWhitelist: url or host is null");
    return false;
  }
  
  public static boolean isUrlHostSameWhitelist(String paramString, String[] paramArrayOfString)
  {
    if ((paramArrayOfString != null) && (paramArrayOfString.length != 0))
    {
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if (isUrlHostSameWhitelist(paramString, paramArrayOfString[i])) {
          return true;
        }
        i += 1;
      }
      return false;
    }
    LogsUtil.e("UriUtil", "whitelist is null");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.secure.android.common.webview.UriUtil
 * JD-Core Version:    0.7.0.1
 */
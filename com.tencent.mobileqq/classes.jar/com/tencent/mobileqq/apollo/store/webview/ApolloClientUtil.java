package com.tencent.mobileqq.apollo.store.webview;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CookieManager;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApolloClientUtil
{
  private static final char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  
  public static String a()
  {
    File localFile = new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/webview/");
    localFile.mkdirs();
    return new File(localFile, "apolloWebviewConfig.txt").getAbsolutePath();
  }
  
  public static String a(File paramFile)
  {
    try
    {
      paramFile = FileUtils.readFileToString(paramFile);
      return paramFile;
    }
    catch (OutOfMemoryError paramFile)
    {
      QLog.e("[cmshow]apollo_client_ApolloClientUtil", 1, "readFileSafety ", paramFile);
    }
    catch (IOException paramFile)
    {
      QLog.e("[cmshow]apollo_client_ApolloClientUtil", 1, "readFileSafety ", paramFile);
    }
    return "";
  }
  
  public static String a(String paramString)
  {
    paramString = Uri.parse(paramString).getPath();
    if (paramString.contains(".css")) {
      return "text/css";
    }
    if (paramString.contains(".js")) {
      return "application/x-javascript";
    }
    if ((!paramString.contains(".jpg")) && (!paramString.contains(".gif")) && (!paramString.contains(".png")) && (!paramString.contains(".jpeg"))) {
      return "text/html";
    }
    return "image/*";
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      StringBuilder localStringBuilder = new StringBuilder(paramString1);
      int j = localStringBuilder.lastIndexOf("/");
      int i = j;
      if (j < 0) {
        i = 0;
      }
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("&");
      ((StringBuilder)localObject1).append(paramString2);
      ((StringBuilder)localObject1).append("=");
      localObject1 = ((StringBuilder)localObject1).toString();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("?");
      ((StringBuilder)localObject2).append(paramString2);
      ((StringBuilder)localObject2).append("=");
      localObject2 = ((StringBuilder)localObject2).toString();
      int m = ((String)localObject1).length();
      try
      {
        for (;;)
        {
          int k = localStringBuilder.indexOf((String)localObject1, i);
          j = k;
          if (-1 == k) {
            j = localStringBuilder.indexOf((String)localObject2, i);
          }
          if (j <= 0) {
            break;
          }
          k = localStringBuilder.indexOf("&", j + m);
          if (k > 0) {
            localStringBuilder.replace(j + 1, k + 1, "");
          } else {
            localStringBuilder.replace(j, localStringBuilder.length(), "");
          }
        }
        if (-1 != localStringBuilder.indexOf("?"))
        {
          localStringBuilder.append("&");
          localStringBuilder.append(paramString2);
          localStringBuilder.append("=");
          localStringBuilder.append(paramString3);
        }
        else
        {
          localStringBuilder.append("?");
          localStringBuilder.append(paramString2);
          localStringBuilder.append("=");
          localStringBuilder.append(paramString3);
        }
        return localStringBuilder.toString();
      }
      catch (Throwable paramString2)
      {
        paramString3 = new StringBuilder();
        paramString3.append("addSonicUrlParam error:");
        paramString3.append(paramString2.getMessage());
        QLog.e("[cmshow]apollo_client_ApolloClientUtil", 2, paramString3.toString());
      }
    }
    return paramString1;
  }
  
  private static String a(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 2);
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfByte[i];
      localStringBuilder.append(a[((k & 0xF0) >>> 4)]);
      localStringBuilder.append(a[(k & 0xF)]);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static boolean a(String paramString, List<String> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      try
      {
        String[] arrayOfString = new String[paramList.size()];
        paramList.toArray(arrayOfString);
        paramList = new HashMap(1);
        paramList.put(paramString, arrayOfString);
        CookieManager.getInstance().setCookies(paramList);
        return true;
      }
      catch (Throwable paramString)
      {
        paramList = new StringBuilder();
        paramList.append("setCookies error:");
        paramList.append(paramString.getMessage());
        QLog.e("[cmshow]apollo_client_ApolloClientUtil", 1, paramList.toString());
      }
    }
    return false;
  }
  
  public static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    try
    {
      MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
      localMessageDigest.update(paramString.getBytes(), 0, paramString.getBytes().length);
      paramString = a(localMessageDigest.digest());
      return paramString;
    }
    catch (Exception paramString) {}
    return "";
  }
  
  public static InputStream c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = new BufferedInputStream(new ByteArrayInputStream(paramString.getBytes("utf-8")));
      return paramString;
    }
    catch (Throwable paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("toInputStream error:");
      localStringBuilder.append(paramString.getMessage());
      QLog.e("[cmshow]apollo_client_ApolloClientUtil", 2, localStringBuilder.toString());
    }
    return null;
  }
  
  public static String d(String paramString)
  {
    return SwiftBrowserCookieMonster.d(paramString);
  }
  
  public static String e(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    Object localObject1 = new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/");
    if (!((File)localObject1).exists()) {
      ((File)localObject1).mkdirs();
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/");
    ((StringBuilder)localObject1).append("webview/");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new File((String)localObject1);
    if (!((File)localObject2).exists()) {
      ((File)localObject2).mkdirs();
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append("/");
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = new File((String)localObject1);
    if (!((File)localObject2).exists()) {
      ((File)localObject2).mkdirs();
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append(".txt");
    return ((StringBuilder)localObject2).toString();
  }
  
  public static String f(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    int i = paramString.indexOf("?");
    String str = paramString;
    if (i != -1) {
      str = paramString.substring(0, i);
    }
    try
    {
      paramString = MessageDigest.getInstance("MD5");
      paramString.update(str.getBytes(), 0, str.getBytes().length);
      paramString = a(paramString.digest());
      return paramString;
    }
    catch (Exception paramString)
    {
      QLog.e("[cmshow]apollo_client_ApolloClientUtil", 1, paramString.getMessage());
    }
    return String.valueOf(str.hashCode());
  }
  
  public static String g(String paramString)
  {
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        return "";
      }
      localObject = Uri.parse(paramString).getHost();
      int i = paramString.indexOf((String)localObject);
      if (i >= 0)
      {
        paramString = paramString.substring(0, i + ((String)localObject).length());
        return paramString;
      }
    }
    catch (Throwable paramString)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getOrigin error:");
      ((StringBuilder)localObject).append(paramString.getMessage());
      QLog.e("[cmshow]apollo_client_ApolloClientUtil", 2, ((StringBuilder)localObject).toString());
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.webview.ApolloClientUtil
 * JD-Core Version:    0.7.0.1
 */
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
  
  public static InputStream a(String paramString)
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
  
  /* Error */
  public static boolean a(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: new 83	java/io/File
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 88	java/io/File:<init>	(Ljava/lang/String;)V
    //   8: astore_0
    //   9: aload_0
    //   10: invokevirtual 194	java/io/File:exists	()Z
    //   13: istore_2
    //   14: iconst_0
    //   15: istore_3
    //   16: iload_2
    //   17: ifne +29 -> 46
    //   20: aload_0
    //   21: invokevirtual 197	java/io/File:createNewFile	()Z
    //   24: pop
    //   25: goto +21 -> 46
    //   28: astore 4
    //   30: ldc 72
    //   32: iconst_1
    //   33: aload 4
    //   35: invokevirtual 198	java/io/IOException:getMessage	()Ljava/lang/String;
    //   38: invokestatic 81	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   41: iconst_0
    //   42: istore_2
    //   43: goto +5 -> 48
    //   46: iconst_1
    //   47: istore_2
    //   48: new 200	java/io/FileOutputStream
    //   51: dup
    //   52: aload_0
    //   53: iconst_0
    //   54: invokespecial 203	java/io/FileOutputStream:<init>	(Ljava/io/File;Z)V
    //   57: astore_0
    //   58: goto +18 -> 76
    //   61: astore_0
    //   62: ldc 72
    //   64: iconst_1
    //   65: aload_0
    //   66: invokevirtual 204	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   69: invokestatic 81	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   72: aconst_null
    //   73: astore_0
    //   74: iconst_0
    //   75: istore_2
    //   76: aload_0
    //   77: ifnull +69 -> 146
    //   80: aload_0
    //   81: aload_1
    //   82: invokevirtual 207	java/lang/String:getBytes	()[B
    //   85: invokevirtual 210	java/io/FileOutputStream:write	([B)V
    //   88: aload_0
    //   89: invokevirtual 213	java/io/FileOutputStream:flush	()V
    //   92: goto +54 -> 146
    //   95: astore_1
    //   96: goto +26 -> 122
    //   99: astore_1
    //   100: ldc 72
    //   102: iconst_1
    //   103: aload_1
    //   104: invokevirtual 198	java/io/IOException:getMessage	()Ljava/lang/String;
    //   107: invokestatic 81	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   110: iload_3
    //   111: istore_2
    //   112: aload_0
    //   113: ifnull +57 -> 170
    //   116: aload_0
    //   117: invokevirtual 216	java/io/FileOutputStream:close	()V
    //   120: iconst_0
    //   121: ireturn
    //   122: aload_0
    //   123: ifnull +21 -> 144
    //   126: aload_0
    //   127: invokevirtual 216	java/io/FileOutputStream:close	()V
    //   130: goto +14 -> 144
    //   133: astore_0
    //   134: ldc 72
    //   136: iconst_1
    //   137: aload_0
    //   138: invokevirtual 198	java/io/IOException:getMessage	()Ljava/lang/String;
    //   141: invokestatic 81	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   144: aload_1
    //   145: athrow
    //   146: aload_0
    //   147: ifnull +23 -> 170
    //   150: aload_0
    //   151: invokevirtual 216	java/io/FileOutputStream:close	()V
    //   154: goto +16 -> 170
    //   157: astore_0
    //   158: ldc 72
    //   160: iconst_1
    //   161: aload_0
    //   162: invokevirtual 198	java/io/IOException:getMessage	()Ljava/lang/String;
    //   165: invokestatic 81	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   168: iconst_0
    //   169: ireturn
    //   170: iload_2
    //   171: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	172	0	paramString1	String
    //   0	172	1	paramString2	String
    //   13	158	2	bool1	boolean
    //   15	96	3	bool2	boolean
    //   28	6	4	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   20	25	28	java/io/IOException
    //   48	58	61	java/io/FileNotFoundException
    //   80	92	95	finally
    //   100	110	95	finally
    //   80	92	99	java/io/IOException
    //   126	130	133	java/io/IOException
    //   116	120	157	java/io/IOException
    //   150	154	157	java/io/IOException
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
  
  public static String c(String paramString)
  {
    return SwiftBrowserCookieMonster.c(paramString);
  }
  
  public static String d(String paramString)
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
  
  public static String e(String paramString)
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
  
  public static String f(String paramString)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.webview.ApolloClientUtil
 * JD-Core Version:    0.7.0.1
 */
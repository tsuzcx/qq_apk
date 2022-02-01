import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserCookieMonster;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.CookieManager;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class amey
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
      QLog.e("apollo_client_ApolloClientUtil", 2, "toInputStream error:" + paramString.getMessage());
    }
    return null;
  }
  
  public static String a()
  {
    File localFile = new File(amip.a + "/webview/");
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
    catch (IOException paramFile)
    {
      QLog.e("apollo_client_ApolloClientUtil", 1, "readFileSafety ", paramFile);
      return "";
    }
    catch (OutOfMemoryError paramFile)
    {
      label17:
      break label17;
    }
  }
  
  public static String a(String paramString)
  {
    String str1 = "text/html";
    String str2 = Uri.parse(paramString).getPath();
    if (str2.contains(".css")) {
      paramString = "text/css";
    }
    do
    {
      return paramString;
      if (str2.contains(".js")) {
        return "application/x-javascript";
      }
      if ((str2.contains(".jpg")) || (str2.contains(".gif")) || (str2.contains(".png"))) {
        break;
      }
      paramString = str1;
    } while (!str2.contains(".jpeg"));
    return "image/*";
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    StringBuilder localStringBuilder;
    int j;
    int i;
    String str1;
    String str2;
    int m;
    if (!TextUtils.isEmpty(paramString1))
    {
      localStringBuilder = new StringBuilder(paramString1);
      j = localStringBuilder.lastIndexOf("/");
      i = j;
      if (j < 0) {
        i = 0;
      }
      str1 = "&" + paramString2 + "=";
      str2 = "?" + paramString2 + "=";
      m = str1.length();
    }
    for (;;)
    {
      try
      {
        int k = localStringBuilder.indexOf(str1, i);
        j = k;
        if (-1 == k) {
          j = localStringBuilder.indexOf(str2, i);
        }
        if (j <= 0) {
          break;
        }
        k = localStringBuilder.indexOf("&", j + m);
        if (k > 0)
        {
          localStringBuilder.replace(j + 1, k + 1, "");
          continue;
          return paramString1;
        }
      }
      catch (Throwable paramString2)
      {
        QLog.e("apollo_client_ApolloClientUtil", 2, "addSonicUrlParam error:" + paramString2.getMessage());
      }
      localStringBuilder.replace(j, localStringBuilder.length(), "");
    }
    if (-1 != localStringBuilder.indexOf("?")) {
      localStringBuilder.append("&").append(paramString2).append("=").append(paramString3);
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append("?").append(paramString2).append("=").append(paramString3);
    }
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
  
  public static boolean a(String paramString1, String paramString2)
  {
    boolean bool2 = false;
    paramString1 = new File(paramString1);
    if (!paramString1.exists()) {}
    for (;;)
    {
      try
      {
        paramString1.createNewFile();
        bool1 = true;
        try
        {
          paramString1.close();
          throw paramString2;
        }
        catch (IOException paramString1)
        {
          for (;;)
          {
            QLog.e("apollo_client_ApolloClientUtil", 1, paramString1.getMessage());
          }
        }
      }
      catch (IOException localIOException)
      {
        try
        {
          paramString1 = new FileOutputStream(paramString1, false);
          if (paramString1 != null) {}
          for (;;)
          {
            try
            {
              paramString1.write(paramString2.getBytes());
              paramString1.flush();
            }
            catch (IOException paramString2)
            {
              QLog.e("apollo_client_ApolloClientUtil", 1, paramString2.getMessage());
              bool1 = bool2;
              if (paramString1 == null) {
                continue;
              }
              try
              {
                paramString1.close();
                return false;
              }
              catch (IOException paramString1)
              {
                QLog.e("apollo_client_ApolloClientUtil", 1, paramString1.getMessage());
                return false;
              }
            }
            finally
            {
              if (paramString1 == null) {
                break label155;
              }
            }
            try
            {
              paramString1.close();
              return bool1;
            }
            catch (IOException paramString1)
            {
              QLog.e("apollo_client_ApolloClientUtil", 1, paramString1.getMessage());
              return false;
            }
          }
          localIOException = localIOException;
          QLog.e("apollo_client_ApolloClientUtil", 1, localIOException.getMessage());
          bool1 = false;
          continue;
        }
        catch (FileNotFoundException paramString1)
        {
          QLog.e("apollo_client_ApolloClientUtil", 1, paramString1.getMessage());
          bool1 = false;
          paramString1 = null;
          continue;
        }
      }
      label155:
      boolean bool1 = true;
    }
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
        QLog.e("apollo_client_ApolloClientUtil", 1, "setCookies error:" + paramString.getMessage());
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
    String str = amip.a + "/";
    File localFile = new File(str);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    str = str + "webview/";
    localFile = new File(str);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    str = str + paramString + "/";
    localFile = new File(str);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return str + paramString + ".txt";
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
      QLog.e("apollo_client_ApolloClientUtil", 1, paramString.getMessage());
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
      String str = Uri.parse(paramString).getHost();
      int i = paramString.indexOf(str);
      if (i >= 0)
      {
        paramString = paramString.substring(0, str.length() + i);
        return paramString;
      }
    }
    catch (Throwable paramString)
    {
      QLog.e("apollo_client_ApolloClientUtil", 2, "getOrigin error:" + paramString.getMessage());
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amey
 * JD-Core Version:    0.7.0.1
 */
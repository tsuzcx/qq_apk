package com.huawei.hms.hatool;

import android.annotation.TargetApi;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.huawei.secure.android.common.encrypt.hash.SHA;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Locale;

public class t0
{
  public static final String[] a = { "e2f856b9f9a4fd4cb2795aeaf83268e4bff189aaec05d691ffde76e075b82648", "173cf86fe9894a0f70dadd09d4fd88c380836099d4939f8c3754361bdc16a32b", "b368b110e3b565fe97c91f786e11bc48754cc8e4e6f21d8a94a68ac6ad67aaaf", "db48223fd9e143f7e133c57f5d08a4e38549ce3ebd921fe3b4003c26e5e35bed", "4bdecdf772491e35c4e8b48f88aee22bae1311984f2e1da4dfad0b78ee7f5163", "3081a0adab3018d57165e6dd24074bdbac640f6dbe21a9e24d3474a87ebf38b8", "db53fcdc9ab71e9bdd4eab257fe1aba7989ad2b24fbe3a85dfef72ea1dd6bae2", "d80f18e8081b624cc64985f87f70118f1702985d2e10dbc985ee7be334fd3c7d", "5fed96c85bd58c58aadbd465c172a4c9a794d8eb2f86cbc7bcee6caf4c7a2c5f", "07ff9b7aeeff969173c45b285fe0fecdbaae244576ff7a2796a36f1c0c11adb4", "92974c6802419e4d18b5ec536cbfa167b8e8eff09ec4c8510a5b95750b1e0c82", "403f14ad2f0e5eb3c4f3a0bcd5c1592cc4492662ad53191c92905255d4990656", "4230baa077b401374d0fc012375047e79ea0790d58d095ef18d97d95470c738d" };
  
  @TargetApi(9)
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      y.c("hmsSdk", "url is null");
      return paramString;
    }
    try
    {
      if ((URLUtil.isNetworkUrl(paramString)) && (!paramString.toLowerCase(Locale.US).startsWith("http:"))) {
        return new URI(paramString).getHost();
      }
      y.b("hmsSdk", "url don't starts with https");
      return null;
    }
    catch (URISyntaxException paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getHostByURI error : ");
      localStringBuilder.append(paramString.getMessage());
      y.b("hmsSdk", localStringBuilder.toString());
    }
    return null;
  }
  
  public static String a(String paramString, int paramInt)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramInt > 0))
    {
      paramString = paramString.split("\\.");
      if (paramString.length < paramInt) {
        return "";
      }
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append(paramString[(paramString.length - paramInt)]);
      int i = 1;
      while (i < paramInt)
      {
        localStringBuffer.append(".");
        localStringBuffer.append(paramString[(paramString.length - paramInt + i)]);
        i += 1;
      }
      return localStringBuffer.toString();
    }
    y.c("hmsSdk", "url is null");
    return paramString;
  }
  
  public static boolean a(String paramString1, String paramString2, int paramInt)
  {
    paramString1 = a(paramString1);
    String str;
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      str = a(paramString1, paramInt);
      if (!TextUtils.isEmpty(str)) {}
    }
    for (paramString1 = "get urlLastNStr is null";; paramString1 = "url or whitelistHash is null")
    {
      for (;;)
      {
        y.b("hmsSdk", paramString1);
        return false;
        if (paramString2.equals(SHA.sha256Encrypt(paramString1))) {
          return true;
        }
        if (paramString2.equals(SHA.sha256Encrypt(str))) {
          try
          {
            paramString1 = paramString1.substring(0, paramString1.length() - str.length());
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
            paramString1 = paramString1.getMessage();
            paramString2.append(paramString1);
            paramString1 = paramString2.toString();
          }
          catch (IndexOutOfBoundsException paramString1)
          {
            for (;;)
            {
              paramString2 = new StringBuilder();
              paramString2.append("IndexOutOfBoundsException");
              paramString1 = paramString1.getMessage();
            }
          }
        }
      }
      return false;
    }
  }
  
  public static boolean b(String paramString)
  {
    if (i1.a.booleanValue()) {
      return true;
    }
    String[] arrayOfString = a;
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (a(paramString, arrayOfString[i], 2)) {
        return true;
      }
      i += 1;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.hatool.t0
 * JD-Core Version:    0.7.0.1
 */
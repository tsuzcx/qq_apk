package com.huawei.hms.stats;

import android.annotation.TargetApi;
import android.text.TextUtils;
import android.webkit.URLUtil;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Locale;

public class bc
{
  private static final String[] a = { "e2f856b9f9a4fd4cb2795aeaf83268e4bff189aaec05d691ffde76e075b82648", "173cf86fe9894a0f70dadd09d4fd88c380836099d4939f8c3754361bdc16a32b", "b368b110e3b565fe97c91f786e11bc48754cc8e4e6f21d8a94a68ac6ad67aaaf", "db48223fd9e143f7e133c57f5d08a4e38549ce3ebd921fe3b4003c26e5e35bed", "4bdecdf772491e35c4e8b48f88aee22bae1311984f2e1da4dfad0b78ee7f5163", "3081a0adab3018d57165e6dd24074bdbac640f6dbe21a9e24d3474a87ebf38b8", "db53fcdc9ab71e9bdd4eab257fe1aba7989ad2b24fbe3a85dfef72ea1dd6bae2", "d80f18e8081b624cc64985f87f70118f1702985d2e10dbc985ee7be334fd3c7d", "5fed96c85bd58c58aadbd465c172a4c9a794d8eb2f86cbc7bcee6caf4c7a2c5f", "07ff9b7aeeff969173c45b285fe0fecdbaae244576ff7a2796a36f1c0c11adb4", "92974c6802419e4d18b5ec536cbfa167b8e8eff09ec4c8510a5b95750b1e0c82", "403f14ad2f0e5eb3c4f3a0bcd5c1592cc4492662ad53191c92905255d4990656", "4230baa077b401374d0fc012375047e79ea0790d58d095ef18d97d95470c738d" };
  
  private static String a(String paramString, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramInt <= 0))
    {
      af.b("UriUtil", "url is null");
      return paramString;
    }
    String[] arrayOfString = paramString.split("\\.");
    if (arrayOfString.length < paramInt) {
      return "";
    }
    paramString = new StringBuffer();
    paramString.append(arrayOfString[(arrayOfString.length - paramInt)]);
    int i = 1;
    while (i < paramInt)
    {
      paramString = paramString.append(".").append(arrayOfString[(arrayOfString.length - paramInt + i)]);
      i += 1;
    }
    return paramString.toString();
  }
  
  public static boolean a(String paramString)
  {
    if (br.a.booleanValue()) {
      return true;
    }
    String[] arrayOfString = a;
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      if (i >= j) {
        break label43;
      }
      if (a(paramString, arrayOfString[i], 2)) {
        break;
      }
      i += 1;
    }
    label43:
    return false;
  }
  
  public static boolean a(String paramString1, String paramString2, int paramInt)
  {
    paramString1 = b(paramString1);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      af.d("UriUtil", "url or whitelistHash is null");
    }
    for (;;)
    {
      return false;
      String str = a(paramString1, paramInt);
      if (TextUtils.isEmpty(str))
      {
        af.d("UriUtil", "get urlLastNStr is null");
        return false;
      }
      if (paramString2.equals(e.a().a(paramString1))) {
        return true;
      }
      if (paramString2.equals(e.a().a(str))) {
        try
        {
          paramString1 = paramString1.substring(0, paramString1.length() - str.length());
          if (paramString1.endsWith("."))
          {
            boolean bool = paramString1.matches("^[A-Za-z0-9.-]+$");
            return bool;
          }
        }
        catch (IndexOutOfBoundsException paramString1)
        {
          af.d("UriUtil", "IndexOutOfBoundsException" + paramString1.getMessage());
          return false;
        }
        catch (Exception paramString1)
        {
          af.d("UriUtil", "Exception : " + paramString1.getMessage());
        }
      }
    }
    return false;
  }
  
  @TargetApi(9)
  public static String b(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      af.b("UriUtil", "url is null");
      return paramString;
    }
    try
    {
      if ((!URLUtil.isNetworkUrl(paramString)) || (paramString.toLowerCase(Locale.US).startsWith("http:")))
      {
        af.d("UriUtil", "url don't starts with https");
        return null;
      }
      paramString = new URI(paramString).getHost();
      return paramString;
    }
    catch (URISyntaxException paramString)
    {
      af.d("UriUtil", "getHostByURI error : " + paramString.getMessage());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.stats.bc
 * JD-Core Version:    0.7.0.1
 */
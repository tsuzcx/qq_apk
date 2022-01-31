package com.tencent.biz.webviewplugin;

import android.util.Base64;
import com.tencent.qphone.base.util.QLog;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONException;
import org.json.JSONObject;

public class NewReportPlugin
{
  private static final String a = NewReportPlugin.class.getName();
  
  public static String a(String paramString)
  {
    try
    {
      paramString = new JSONObject(paramString).getString("key");
      return paramString;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
    return "abcdabcdabcdabcd";
  }
  
  public static String a(String paramString1, String paramString2)
  {
    try
    {
      if (paramString2.equals("abcdabcdabcdabcd")) {}
      for (paramString2 = paramString2.getBytes("UTF-8");; paramString2 = Base64.decode(paramString2.getBytes("UTF-8"), 0))
      {
        Cipher localCipher = Cipher.getInstance("AES/ECB/NoPadding");
        localCipher.init(2, new SecretKeySpec(paramString1.getBytes(), "AES"));
        return new String(localCipher.doFinal(paramString2));
      }
      return null;
    }
    catch (Exception paramString1)
    {
      QLog.e("", 1, "decrypt Key has something wrong : " + paramString1.toString());
      paramString1.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.NewReportPlugin
 * JD-Core Version:    0.7.0.1
 */
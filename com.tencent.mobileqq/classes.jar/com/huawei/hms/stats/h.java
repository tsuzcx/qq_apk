package com.huawei.hms.stats;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class h
  implements i
{
  public String a(String paramString1, String paramString2)
  {
    af.b("HmacSHA256Crypt", "No HMAC_SHA256 decryption method");
    return "";
  }
  
  public String a(String paramString, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0))
    {
      af.c("HmacSHA256Crypt", "encrypt: content is empty or null");
      return "";
    }
    paramString = new SecretKeySpec(paramString.getBytes(Charset.forName("UTF-8")), "HmacSHA256");
    try
    {
      Mac localMac = Mac.getInstance(paramString.getAlgorithm());
      localMac.init(paramString);
      paramString = g.a(localMac.doFinal(paramArrayOfByte));
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      af.c("HmacSHA256Crypt", "When digest2byte executed Exception has happened!From Algorithm error !");
      return "";
    }
    catch (InvalidKeyException paramString)
    {
      for (;;)
      {
        af.c("HmacSHA256Crypt", "Exception has happened when digest2byte,From Invalid key!");
      }
    }
  }
  
  public String b(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      af.c("HmacSHA256Crypt", "key or content is empty");
      return "";
    }
    try
    {
      paramString1 = a(paramString1, paramString2.getBytes("UTF-8"));
      return paramString1;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      af.b("HmacSHA256Crypt", "Unsupported encoding exception,utf-8");
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.stats.h
 * JD-Core Version:    0.7.0.1
 */
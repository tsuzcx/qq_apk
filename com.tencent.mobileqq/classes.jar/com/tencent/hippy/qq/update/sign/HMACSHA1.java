package com.tencent.hippy.qq.update.sign;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class HMACSHA1
{
  private static final String HMAC_SHA1 = "HmacSHA1";
  
  public static byte[] getSignature(String paramString1, String paramString2)
  {
    Mac localMac = Mac.getInstance("HmacSHA1");
    localMac.init(new SecretKeySpec(paramString2.getBytes(), localMac.getAlgorithm()));
    return localMac.doFinal(paramString1.getBytes());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.update.sign.HMACSHA1
 * JD-Core Version:    0.7.0.1
 */
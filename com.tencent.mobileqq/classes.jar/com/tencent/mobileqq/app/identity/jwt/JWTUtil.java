package com.tencent.mobileqq.app.identity.jwt;

import com.tencent.qphone.base.util.QLog;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

public class JWTUtil
{
  public static String a(String paramString1, String paramString2)
  {
    paramString2 = a(paramString2);
    if (paramString2 == null) {
      return null;
    }
    return new JwtConsumer(new SimpleKeyResolver(paramString2)).a(paramString1);
  }
  
  private static PublicKey a(String paramString)
  {
    try
    {
      paramString = new X509EncodedKeySpec(Base64.a(paramString.replaceAll("\\-*BEGIN.*KEY\\-*", "").replaceAll("\\-*END.*KEY\\-*", "")));
      paramString = KeyFactory.getInstance("RSA").generatePublic(paramString);
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      QLog.e("JWTUtil", 1, new Object[] { "getPublicKey NoSuchAlgorithmException : ", paramString.getMessage() });
      return null;
    }
    catch (InvalidKeySpecException paramString)
    {
      for (;;)
      {
        QLog.e("JWTUtil", 1, new Object[] { "getPublicKey InvalidKeySpecException : ", paramString.getMessage() });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.identity.jwt.JWTUtil
 * JD-Core Version:    0.7.0.1
 */
package com.heytap.mcssdk.f;

import android.util.Base64;
import java.nio.charset.Charset;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public abstract class b
{
  public static String a(String paramString1, String paramString2)
  {
    Cipher localCipher = Cipher.getInstance("DES");
    localCipher.init(2, a(paramString2));
    return new String(localCipher.doFinal(Base64.decode(paramString1, 0)), Charset.defaultCharset()).trim();
  }
  
  private static Key a(String paramString)
  {
    paramString = new DESKeySpec(Base64.decode(paramString, 0));
    return SecretKeyFactory.getInstance("DES").generateSecret(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.heytap.mcssdk.f.b
 * JD-Core Version:    0.7.0.1
 */
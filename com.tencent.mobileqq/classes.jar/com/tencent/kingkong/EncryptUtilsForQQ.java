package com.tencent.kingkong;

import android.util.Base64;
import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

public class EncryptUtilsForQQ
{
  public static String a = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQD3ywzb5M1Acw/gPd4869if4PlW\rhH8ekZvuoW3JYzxzeI1Rb5ENlEErZFUFvQrdTtapycinwjtQUHpgJBkAYxe8fI8k\ralWhJxQAOJZxIVPiZcPzGl4kaPkGHonKhT1md+FwoFGfosNbccQ4RcvUT/iSuqPh\rFd9e4fbNnLf9pPf5LQIDAQAB";
  
  public static String a(String paramString)
  {
    Object localObject = Base64.decode(a, 0);
    localObject = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec((byte[])localObject));
    Cipher localCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
    localCipher.init(1, (Key)localObject);
    return Base64.encodeToString(localCipher.doFinal(paramString.getBytes()), 2);
  }
  
  public static String a(String paramString, int paramInt)
  {
    int j = paramString.length();
    int i = 0;
    while (i < paramInt - j % paramInt)
    {
      paramString = paramString + " ";
      i += 1;
    }
    return paramString;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    paramString1 = new DESKeySpec(paramString1.getBytes());
    paramString1 = SecretKeyFactory.getInstance("DES").generateSecret(paramString1);
    Cipher localCipher = Cipher.getInstance("DES/CBC/NoPadding");
    localCipher.init(1, paramString1, new IvParameterSpec("12345678".getBytes()));
    return Base64.encodeToString(localCipher.doFinal(a(paramString2, localCipher.getBlockSize()).getBytes()), 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.kingkong.EncryptUtilsForQQ
 * JD-Core Version:    0.7.0.1
 */
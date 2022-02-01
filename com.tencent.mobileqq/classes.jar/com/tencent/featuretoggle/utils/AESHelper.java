package com.tencent.featuretoggle.utils;

import android.util.Base64;
import com.tencent.featuretoggle.SpManager;
import com.tencent.featuretoggle.ToggleSetting;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AESHelper
{
  private static final String a = new String(Base64.decode("QUVTL0NCQy9QS0NTN1BhZGRpbmc=", 2));
  private static final byte[] b = Base64.decode("AAAAAAAAAAAAAAAAAAAAAA==", 2);
  
  public static String a(String paramString)
  {
    try
    {
      paramString = Base64.encodeToString(a(c(ToggleSetting.k()), paramString.getBytes("UTF-8")), 2);
      return paramString;
    }
    catch (Throwable paramString)
    {
      if (!LogUtils.a(paramString)) {
        paramString.printStackTrace();
      }
    }
    return null;
  }
  
  private static byte[] a(SecretKeySpec paramSecretKeySpec, byte[] paramArrayOfByte)
  {
    Cipher localCipher = Cipher.getInstance(a);
    localCipher.init(1, paramSecretKeySpec, new IvParameterSpec(b));
    return localCipher.doFinal(paramArrayOfByte);
  }
  
  public static String b(String paramString)
  {
    try
    {
      paramString = new String(b(c(ToggleSetting.k()), Base64.decode(paramString, 2)), "UTF-8");
      return paramString;
    }
    catch (Throwable paramString)
    {
      if (!LogUtils.a(paramString)) {
        paramString.printStackTrace();
      }
    }
    return null;
  }
  
  private static byte[] b(SecretKeySpec paramSecretKeySpec, byte[] paramArrayOfByte)
  {
    Cipher localCipher = Cipher.getInstance(a);
    localCipher.init(2, paramSecretKeySpec, new IvParameterSpec(b));
    return localCipher.doFinal(paramArrayOfByte);
  }
  
  private static SecretKeySpec c(String paramString)
  {
    String str = SpManager.a().b();
    if (str != null) {
      return new SecretKeySpec(Base64.decode(str, 2), "AES");
    }
    return d(paramString);
  }
  
  private static SecretKeySpec d(String paramString)
  {
    Object localObject = MessageDigest.getInstance("SHA-256");
    paramString = paramString.getBytes("UTF-8");
    ((MessageDigest)localObject).update(paramString, 0, paramString.length);
    paramString = ((MessageDigest)localObject).digest();
    localObject = Base64.encodeToString(paramString, 2);
    SpManager.a().a((String)localObject);
    return new SecretKeySpec(paramString, "AES");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.featuretoggle.utils.AESHelper
 * JD-Core Version:    0.7.0.1
 */
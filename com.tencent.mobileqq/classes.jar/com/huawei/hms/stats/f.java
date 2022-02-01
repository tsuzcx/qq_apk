package com.huawei.hms.stats;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class f
{
  static String a(String paramString)
  {
    try
    {
      paramString = g.a(MessageDigest.getInstance("SHA-256").digest(paramString.getBytes("UTF-8")));
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      af.c("EncryptUtil", "sha256Digest(): UnsupportedEncodingException: Exception when writing the log file.");
      return "";
    }
    catch (NoSuchAlgorithmException paramString)
    {
      for (;;)
      {
        af.c("EncryptUtil", "sha256Digest(): NoSuch Algorithm Exception");
      }
    }
  }
  
  static String a(char[] paramArrayOfChar, byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfChar = new PBEKeySpec(paramArrayOfChar, paramArrayOfByte, 10000, 128);
      paramArrayOfChar = g.a(SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1").generateSecret(paramArrayOfChar).getEncoded());
      return paramArrayOfChar;
    }
    catch (InvalidKeySpecException paramArrayOfChar)
    {
      af.d("EncryptUtil", "getAuthToken() encryptPBKDF2 Invalid key specification !");
      return null;
    }
    catch (NoSuchAlgorithmException paramArrayOfChar)
    {
      for (;;)
      {
        af.d("EncryptUtil", "getAuthToken() encryptPBKDF2 No such algorithm!");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.hms.stats.f
 * JD-Core Version:    0.7.0.1
 */
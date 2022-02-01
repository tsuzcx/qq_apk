package com.huawei.secure.android.common.encrypt.hash;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import com.huawei.secure.android.common.encrypt.utils.b;
import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public abstract class PBKDF2
{
  private static final int A = 1000;
  private static final String TAG = "PBKDF2";
  private static final String i = "";
  private static final String u = "PBKDF2WithHmacSHA1";
  private static final String v = "PBKDF2WithHmacSHA256";
  private static final int w = 8;
  private static final int x = 16;
  private static final int y = 32;
  private static final int z = 10000;
  
  private static byte[] a(char[] paramArrayOfChar, byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    try
    {
      paramArrayOfByte = new PBEKeySpec(paramArrayOfChar, paramArrayOfByte, paramInt1, paramInt2);
      if (paramBoolean) {
        paramArrayOfChar = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
      } else {
        paramArrayOfChar = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
      }
      paramArrayOfChar = paramArrayOfChar.generateSecret(paramArrayOfByte).getEncoded();
      return paramArrayOfChar;
    }
    catch (InvalidKeySpecException paramArrayOfChar) {}catch (NoSuchAlgorithmException paramArrayOfChar) {}
    paramArrayOfByte = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pbkdf exception : ");
    localStringBuilder.append(paramArrayOfChar.getMessage());
    b.f(paramArrayOfByte, localStringBuilder.toString());
    return new byte[0];
  }
  
  private static boolean b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramArrayOfByte1 != null)
    {
      if (paramArrayOfByte2 == null) {
        return false;
      }
      int k = paramArrayOfByte1.length ^ paramArrayOfByte2.length;
      int j = 0;
      while ((j < paramArrayOfByte1.length) && (j < paramArrayOfByte2.length))
      {
        k |= paramArrayOfByte1[j] ^ paramArrayOfByte2[j];
        j += 1;
      }
      bool1 = bool2;
      if (k == 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static byte[] pbkdf2(char[] paramArrayOfChar, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return a(paramArrayOfChar, paramArrayOfByte, paramInt1, paramInt2, false);
  }
  
  @Deprecated
  public static String pbkdf2Encrypt(String paramString)
  {
    return pbkdf2Encrypt(paramString, 10000);
  }
  
  @Deprecated
  public static String pbkdf2Encrypt(String paramString, int paramInt)
  {
    return pbkdf2Encrypt(paramString, EncryptUtil.generateSecureRandom(8), paramInt, 32);
  }
  
  @Deprecated
  public static String pbkdf2Encrypt(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString))
    {
      b.f(TAG, "pwd is null.");
      return "";
    }
    if (paramInt1 < 1000)
    {
      b.f(TAG, "iterations times is not enough.");
      return "";
    }
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length >= 8))
    {
      if (paramInt2 < 32)
      {
        b.f(TAG, "cipherLen length is not enough");
        return "";
      }
      paramString = pbkdf2(paramString.toCharArray(), paramArrayOfByte, paramInt1, paramInt2 * 8);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HexUtil.byteArray2HexStr(paramArrayOfByte));
      localStringBuilder.append(HexUtil.byteArray2HexStr(paramString));
      return localStringBuilder.toString();
    }
    b.f(TAG, "salt parameter is null or length is not enough");
    return "";
  }
  
  public static String pbkdf2EncryptNew(String paramString)
  {
    return pbkdf2EncryptNew(paramString, 10000);
  }
  
  public static String pbkdf2EncryptNew(String paramString, int paramInt)
  {
    return pbkdf2EncryptNew(paramString, EncryptUtil.generateSecureRandom(16), paramInt, 32);
  }
  
  public static String pbkdf2EncryptNew(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(paramString))
    {
      b.f(TAG, "pwd is null.");
      return "";
    }
    if (paramInt1 < 1000)
    {
      b.f(TAG, "iterations times is not enough.");
      return "";
    }
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length >= 16))
    {
      if (paramInt2 < 32)
      {
        b.f(TAG, "cipherLen length is not enough");
        return "";
      }
      if (Build.VERSION.SDK_INT < 26)
      {
        b.d(TAG, "sha 1");
        paramString = pbkdf2(paramString.toCharArray(), paramArrayOfByte, paramInt1, paramInt2 * 8);
      }
      else
      {
        b.d(TAG, "sha 256");
        paramString = pbkdf2SHA256(paramString.toCharArray(), paramArrayOfByte, paramInt1, paramInt2 * 8);
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(HexUtil.byteArray2HexStr(paramArrayOfByte));
      localStringBuilder.append(HexUtil.byteArray2HexStr(paramString));
      return localStringBuilder.toString();
    }
    b.f(TAG, "salt parameter is null or length is not enough");
    return "";
  }
  
  public static byte[] pbkdf2SHA256(char[] paramArrayOfChar, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (Build.VERSION.SDK_INT < 26)
    {
      b.f(TAG, "system version not high than 26");
      return new byte[0];
    }
    return a(paramArrayOfChar, paramArrayOfByte, paramInt1, paramInt2, true);
  }
  
  @Deprecated
  public static boolean validatePassword(String paramString1, String paramString2)
  {
    return validatePassword(paramString1, paramString2, 10000);
  }
  
  @Deprecated
  public static boolean validatePassword(String paramString1, String paramString2, int paramInt)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      if (paramString2.length() < 16) {
        return false;
      }
      String str = paramString2.substring(0, 16);
      paramString2 = paramString2.substring(16);
      return b(pbkdf2(paramString1.toCharArray(), HexUtil.hexStr2ByteArray(str), paramInt, 256), HexUtil.hexStr2ByteArray(paramString2));
    }
    return false;
  }
  
  public static boolean validatePasswordNew(String paramString1, String paramString2)
  {
    return validatePasswordNew(paramString1, paramString2, 10000);
  }
  
  public static boolean validatePasswordNew(String paramString1, String paramString2, int paramInt)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      if (paramString2.length() < 32) {
        return false;
      }
      String str = paramString2.substring(0, 32);
      paramString2 = paramString2.substring(32);
      if (Build.VERSION.SDK_INT < 26) {
        paramString1 = pbkdf2(paramString1.toCharArray(), HexUtil.hexStr2ByteArray(str), paramInt, 256);
      } else {
        paramString1 = pbkdf2SHA256(paramString1.toCharArray(), HexUtil.hexStr2ByteArray(str), paramInt, 256);
      }
      return b(paramString1, HexUtil.hexStr2ByteArray(paramString2));
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.secure.android.common.encrypt.hash.PBKDF2
 * JD-Core Version:    0.7.0.1
 */
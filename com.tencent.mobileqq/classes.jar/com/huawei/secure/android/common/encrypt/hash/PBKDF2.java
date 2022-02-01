package com.huawei.secure.android.common.encrypt.hash;

import android.os.Build.VERSION;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import com.huawei.secure.android.common.encrypt.utils.b;

public abstract class PBKDF2
{
  private static final int A = 1000;
  private static final String TAG = PBKDF2.class.getSimpleName();
  private static final String i = "";
  private static final String u = "PBKDF2WithHmacSHA1";
  private static final String v = "PBKDF2WithHmacSHA256";
  private static final int w = 8;
  private static final int x = 16;
  private static final int y = 32;
  private static final int z = 10000;
  
  /* Error */
  private static byte[] a(char[] paramArrayOfChar, byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    // Byte code:
    //   0: new 48	javax/crypto/spec/PBEKeySpec
    //   3: dup
    //   4: aload_0
    //   5: aload_1
    //   6: iload_2
    //   7: iload_3
    //   8: invokespecial 51	javax/crypto/spec/PBEKeySpec:<init>	([C[BII)V
    //   11: astore_1
    //   12: iload 4
    //   14: ifeq +20 -> 34
    //   17: ldc 18
    //   19: invokestatic 57	javax/crypto/SecretKeyFactory:getInstance	(Ljava/lang/String;)Ljavax/crypto/SecretKeyFactory;
    //   22: astore_0
    //   23: aload_0
    //   24: aload_1
    //   25: invokevirtual 61	javax/crypto/SecretKeyFactory:generateSecret	(Ljava/security/spec/KeySpec;)Ljavax/crypto/SecretKey;
    //   28: invokeinterface 67 1 0
    //   33: areturn
    //   34: ldc 15
    //   36: invokestatic 57	javax/crypto/SecretKeyFactory:getInstance	(Ljava/lang/String;)Ljavax/crypto/SecretKeyFactory;
    //   39: astore_0
    //   40: goto -17 -> 23
    //   43: astore_0
    //   44: getstatic 36	com/huawei/secure/android/common/encrypt/hash/PBKDF2:TAG	Ljava/lang/String;
    //   47: new 69	java/lang/StringBuilder
    //   50: dup
    //   51: invokespecial 70	java/lang/StringBuilder:<init>	()V
    //   54: ldc 72
    //   56: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: aload_0
    //   60: invokevirtual 81	java/security/GeneralSecurityException:getMessage	()Ljava/lang/String;
    //   63: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: invokevirtual 84	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokestatic 90	com/huawei/secure/android/common/encrypt/utils/b:f	(Ljava/lang/String;Ljava/lang/String;)V
    //   72: iconst_0
    //   73: newarray byte
    //   75: areturn
    //   76: astore_0
    //   77: goto -33 -> 44
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	paramArrayOfChar	char[]
    //   0	80	1	paramArrayOfByte	byte[]
    //   0	80	2	paramInt1	int
    //   0	80	3	paramInt2	int
    //   0	80	4	paramBoolean	boolean
    // Exception table:
    //   from	to	target	type
    //   0	12	43	java/security/NoSuchAlgorithmException
    //   17	23	43	java/security/NoSuchAlgorithmException
    //   23	34	43	java/security/NoSuchAlgorithmException
    //   34	40	43	java/security/NoSuchAlgorithmException
    //   0	12	76	java/security/spec/InvalidKeySpecException
    //   17	23	76	java/security/spec/InvalidKeySpecException
    //   23	34	76	java/security/spec/InvalidKeySpecException
    //   34	40	76	java/security/spec/InvalidKeySpecException
  }
  
  private static boolean b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte2 == null)) {}
    int k;
    do
    {
      return false;
      k = paramArrayOfByte1.length ^ paramArrayOfByte2.length;
      int j = 0;
      while ((j < paramArrayOfByte1.length) && (j < paramArrayOfByte2.length))
      {
        k |= paramArrayOfByte1[j] ^ paramArrayOfByte2[j];
        j += 1;
      }
    } while (k != 0);
    return true;
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
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 8))
    {
      b.f(TAG, "salt parameter is null or length is not enough");
      return "";
    }
    if (paramInt2 < 32)
    {
      b.f(TAG, "cipherLen length is not enough");
      return "";
    }
    paramString = pbkdf2(paramString.toCharArray(), paramArrayOfByte, paramInt1, paramInt2 * 8);
    return HexUtil.byteArray2HexStr(paramArrayOfByte) + HexUtil.byteArray2HexStr(paramString);
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
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 16))
    {
      b.f(TAG, "salt parameter is null or length is not enough");
      return "";
    }
    if (paramInt2 < 32)
    {
      b.f(TAG, "cipherLen length is not enough");
      return "";
    }
    if (Build.VERSION.SDK_INT < 26) {
      b.d(TAG, "sha 1");
    }
    for (paramString = pbkdf2(paramString.toCharArray(), paramArrayOfByte, paramInt1, paramInt2 * 8);; paramString = pbkdf2SHA256(paramString.toCharArray(), paramArrayOfByte, paramInt1, paramInt2 * 8))
    {
      return HexUtil.byteArray2HexStr(paramArrayOfByte) + HexUtil.byteArray2HexStr(paramString);
      b.d(TAG, "sha 256");
    }
  }
  
  @RequiresApi(api=26)
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
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (paramString2.length() < 16)) {
      return false;
    }
    String str = paramString2.substring(0, 16);
    paramString2 = paramString2.substring(16);
    return b(pbkdf2(paramString1.toCharArray(), HexUtil.hexStr2ByteArray(str), paramInt, 256), HexUtil.hexStr2ByteArray(paramString2));
  }
  
  public static boolean validatePasswordNew(String paramString1, String paramString2)
  {
    return validatePasswordNew(paramString1, paramString2, 10000);
  }
  
  public static boolean validatePasswordNew(String paramString1, String paramString2, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (paramString2.length() < 32)) {
      return false;
    }
    String str = paramString2.substring(0, 32);
    paramString2 = paramString2.substring(32);
    if (Build.VERSION.SDK_INT < 26) {}
    for (paramString1 = pbkdf2(paramString1.toCharArray(), HexUtil.hexStr2ByteArray(str), paramInt, 256);; paramString1 = pbkdf2SHA256(paramString1.toCharArray(), HexUtil.hexStr2ByteArray(str), paramInt, 256)) {
      return b(paramString1, HexUtil.hexStr2ByteArray(paramString2));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.secure.android.common.encrypt.hash.PBKDF2
 * JD-Core Version:    0.7.0.1
 */
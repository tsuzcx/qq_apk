package com.huawei.secure.android.common.encrypt.aes;

import android.os.Build.VERSION;
import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import com.huawei.secure.android.common.encrypt.utils.b;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class AesGcm
{
  private static final String TAG = "AesGcm";
  private static final String f = "security:";
  private static final String h = "AES";
  private static final String i = "";
  private static final String l = "AES/GCM/NoPadding";
  private static final int m = 16;
  private static final int n = 12;
  private static final int o = 2;
  
  private static String a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.length() >= 24)) {
      return paramString.substring(0, 24);
    }
    b.f(TAG, "IV is invalid.");
    return "";
  }
  
  private static byte[] a(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramArrayOfByte1 != null) && (paramArrayOfByte1.length >= 16) && (paramArrayOfByte2 != null) && (paramArrayOfByte2.length >= 12) && (isBuildVersionHigherThan19())) {
      try
      {
        paramString = encrypt(paramString.getBytes("UTF-8"), paramArrayOfByte1, paramArrayOfByte2);
        return paramString;
      }
      catch (UnsupportedEncodingException paramString)
      {
        paramArrayOfByte1 = TAG;
        paramArrayOfByte2 = new StringBuilder();
        paramArrayOfByte2.append("GCM encrypt data error");
        paramArrayOfByte2.append(paramString.getMessage());
        b.f(paramArrayOfByte1, paramArrayOfByte2.toString());
        return new byte[0];
      }
    }
    b.f(TAG, "gcm encrypt param is not right");
    return new byte[0];
  }
  
  private static byte[] a(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[12];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, 12);
    return arrayOfByte;
  }
  
  private static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte = new byte[paramArrayOfByte1.length + paramArrayOfByte2.length];
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 0, paramArrayOfByte1.length);
    System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, paramArrayOfByte1.length, paramArrayOfByte2.length);
    return arrayOfByte;
  }
  
  private static String b(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.length() >= 24)) {
      return paramString.substring(24);
    }
    return "";
  }
  
  private static byte[] b(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[paramArrayOfByte.length - 12];
    System.arraycopy(paramArrayOfByte, 12, arrayOfByte, 0, paramArrayOfByte.length - 12);
    return arrayOfByte;
  }
  
  private static int d(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte[12] == 58) {
      return 12;
    }
    return -1;
  }
  
  public static String decrypt(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      if (!isBuildVersionHigherThan19()) {
        return "";
      }
      paramString2 = HexUtil.hexStr2ByteArray(paramString2);
      if (paramString2.length < 16)
      {
        b.f(TAG, "key length is not right");
        return "";
      }
      return decrypt(paramString1, paramString2);
    }
    return "";
  }
  
  public static String decrypt(String paramString1, String paramString2, String paramString3)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)) && (isBuildVersionHigherThan19()))
    {
      paramString2 = HexUtil.hexStr2ByteArray(paramString2);
      paramString3 = HexUtil.hexStr2ByteArray(paramString3);
      if ((paramString2.length >= 16) && (paramString3.length >= 12)) {
        return decrypt(paramString1, paramString2, paramString3);
      }
      b.f(TAG, "key length or iv length is not right");
      return "";
    }
    b.f(TAG, "gcm decrypt param is not right");
    return "";
  }
  
  public static String decrypt(String paramString, byte[] paramArrayOfByte)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramArrayOfByte != null) && (paramArrayOfByte.length >= 16))
    {
      if (!isBuildVersionHigherThan19()) {
        return "";
      }
      try
      {
        paramArrayOfByte = new SecretKeySpec(paramArrayOfByte, "AES");
        localObject = Cipher.getInstance("AES/GCM/NoPadding");
        String str = a(paramString);
        paramString = b(paramString);
        if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramString)))
        {
          ((Cipher)localObject).init(2, paramArrayOfByte, getGcmAlgorithmParams(HexUtil.hexStr2ByteArray(str)));
          return new String(((Cipher)localObject).doFinal(HexUtil.hexStr2ByteArray(paramString)), "UTF-8");
        }
        b.f(TAG, "ivParameter or encrypedWord is null");
        return "";
      }
      catch (UnsupportedEncodingException paramString) {}catch (GeneralSecurityException paramString) {}
      paramArrayOfByte = TAG;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("GCM decrypt data exception: ");
      ((StringBuilder)localObject).append(paramString.getMessage());
      b.f(paramArrayOfByte, ((StringBuilder)localObject).toString());
    }
    return "";
  }
  
  public static String decrypt(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramArrayOfByte1 != null) && (paramArrayOfByte1.length >= 16) && (paramArrayOfByte2 != null) && (paramArrayOfByte2.length >= 12))
    {
      if (!isBuildVersionHigherThan19()) {
        return "";
      }
      try
      {
        paramString = new String(decrypt(HexUtil.hexStr2ByteArray(paramString), paramArrayOfByte1, paramArrayOfByte2), "UTF-8");
        return paramString;
      }
      catch (UnsupportedEncodingException paramString)
      {
        paramArrayOfByte1 = TAG;
        paramArrayOfByte2 = new StringBuilder();
        paramArrayOfByte2.append("GCM decrypt data exception: ");
        paramArrayOfByte2.append(paramString.getMessage());
        b.f(paramArrayOfByte1, paramArrayOfByte2.toString());
      }
    }
    return "";
  }
  
  public static byte[] decrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte = a(paramArrayOfByte1);
    return decrypt(b(paramArrayOfByte1), paramArrayOfByte2, arrayOfByte);
  }
  
  public static byte[] decrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    if ((paramArrayOfByte1 != null) && (paramArrayOfByte1.length != 0) && (paramArrayOfByte2 != null) && (paramArrayOfByte2.length >= 16) && (isBuildVersionHigherThan19())) {
      try
      {
        paramArrayOfByte2 = new SecretKeySpec(paramArrayOfByte2, "AES");
        Cipher localCipher = Cipher.getInstance("AES/GCM/NoPadding");
        localCipher.init(2, paramArrayOfByte2, getGcmAlgorithmParams(paramArrayOfByte3));
        paramArrayOfByte1 = localCipher.doFinal(paramArrayOfByte1);
        return paramArrayOfByte1;
      }
      catch (GeneralSecurityException paramArrayOfByte1)
      {
        paramArrayOfByte2 = TAG;
        paramArrayOfByte3 = new StringBuilder();
        paramArrayOfByte3.append("GCM decrypt data exception: ");
        paramArrayOfByte3.append(paramArrayOfByte1.getMessage());
        b.f(paramArrayOfByte2, paramArrayOfByte3.toString());
        return new byte[0];
      }
    }
    return new byte[0];
  }
  
  public static String decryptWithCryptHead(String paramString, byte[] paramArrayOfByte)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramArrayOfByte != null))
    {
      if (paramArrayOfByte.length < 16) {
        return "";
      }
      paramString = AesCbc.c(paramString);
      if ("".equals(paramString)) {
        return "";
      }
      int j = paramString.indexOf(':');
      if (j >= 0)
      {
        byte[] arrayOfByte = HexUtil.hexStr2ByteArray(paramString.substring(0, j));
        return decrypt(HexUtil.byteArray2HexStr(HexUtil.hexStr2ByteArray(paramString.substring(j + 1))), paramArrayOfByte, arrayOfByte);
      }
      b.f(TAG, " gcm cipherText data missing colon");
    }
    return "";
  }
  
  public static String decryptWithCryptHead(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    try
    {
      paramArrayOfByte1 = new String(decryptWithCryptHeadReturnByte(paramArrayOfByte1, paramArrayOfByte2), "UTF-8");
      return paramArrayOfByte1;
    }
    catch (UnsupportedEncodingException paramArrayOfByte1)
    {
      label17:
      break label17;
    }
    b.f(TAG, "UnsupportedEncodingException");
    return "";
  }
  
  public static byte[] decryptWithCryptHeadReturnByte(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if ((paramArrayOfByte1 != null) && (paramArrayOfByte2 != null) && (paramArrayOfByte2.length >= 16))
    {
      paramArrayOfByte1 = AesCbc.c(paramArrayOfByte1);
      if (paramArrayOfByte1.length == 0) {
        return new byte[0];
      }
      int j = d(paramArrayOfByte1);
      if (j >= 0)
      {
        byte[] arrayOfByte1 = Arrays.copyOf(paramArrayOfByte1, j);
        int k = paramArrayOfByte1.length - arrayOfByte1.length - 1;
        byte[] arrayOfByte2 = new byte[k];
        System.arraycopy(paramArrayOfByte1, j + 1, arrayOfByte2, 0, k);
        return decrypt(arrayOfByte2, paramArrayOfByte2, arrayOfByte1);
      }
      b.f(TAG, " gcm cipherText data missing colon");
      return new byte[0];
    }
    return new byte[0];
  }
  
  public static String encrypt(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      if (!isBuildVersionHigherThan19()) {
        return "";
      }
      paramString2 = HexUtil.hexStr2ByteArray(paramString2);
      if (paramString2.length < 16)
      {
        b.f(TAG, "key length is not right");
        return "";
      }
      return encrypt(paramString1, paramString2);
    }
    return "";
  }
  
  public static String encrypt(String paramString1, String paramString2, String paramString3)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)) && (isBuildVersionHigherThan19()))
    {
      paramString2 = HexUtil.hexStr2ByteArray(paramString2);
      byte[] arrayOfByte = HexUtil.hexStr2ByteArray(paramString3);
      if ((paramString2.length >= 16) && (paramString3.length() >= 12)) {
        return encrypt(paramString1, paramString2, arrayOfByte);
      }
      b.f(TAG, "key length or iv length is not right");
      return "";
    }
    b.f(TAG, "gcm encrypt parameter is not right");
    return "";
  }
  
  public static String encrypt(String paramString, byte[] paramArrayOfByte)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramArrayOfByte != null) && (paramArrayOfByte.length >= 16))
    {
      if (!isBuildVersionHigherThan19()) {
        return "";
      }
      Object localObject = EncryptUtil.generateSecureRandom(12);
      paramArrayOfByte = a(paramString, paramArrayOfByte, (byte[])localObject);
      if (paramArrayOfByte != null)
      {
        if (paramArrayOfByte.length == 0) {
          return "";
        }
        paramString = HexUtil.byteArray2HexStr((byte[])localObject);
        paramArrayOfByte = HexUtil.byteArray2HexStr(paramArrayOfByte);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(paramArrayOfByte);
        return ((StringBuilder)localObject).toString();
      }
    }
    return "";
  }
  
  public static String encrypt(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramArrayOfByte1 != null) && (paramArrayOfByte1.length >= 16) && (paramArrayOfByte2 != null) && (paramArrayOfByte2.length >= 12) && (isBuildVersionHigherThan19())) {
      return HexUtil.byteArray2HexStr(a(paramString, paramArrayOfByte1, paramArrayOfByte2));
    }
    b.f(TAG, "gcm encrypt param is not right");
    return "";
  }
  
  public static byte[] encrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte = EncryptUtil.generateSecureRandom(12);
    return a(arrayOfByte, encrypt(paramArrayOfByte1, paramArrayOfByte2, arrayOfByte));
  }
  
  public static byte[] encrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    if ((paramArrayOfByte1 != null) && (paramArrayOfByte1.length != 0) && (paramArrayOfByte2 != null) && (paramArrayOfByte2.length >= 16) && (paramArrayOfByte3 != null) && (paramArrayOfByte3.length >= 12) && (isBuildVersionHigherThan19())) {
      try
      {
        paramArrayOfByte2 = new SecretKeySpec(paramArrayOfByte2, "AES");
        Cipher localCipher = Cipher.getInstance("AES/GCM/NoPadding");
        localCipher.init(1, paramArrayOfByte2, getGcmAlgorithmParams(paramArrayOfByte3));
        paramArrayOfByte1 = localCipher.doFinal(paramArrayOfByte1);
        return paramArrayOfByte1;
      }
      catch (GeneralSecurityException paramArrayOfByte1)
      {
        paramArrayOfByte2 = TAG;
        paramArrayOfByte3 = new StringBuilder();
        paramArrayOfByte3.append("GCM encrypt data error");
        paramArrayOfByte3.append(paramArrayOfByte1.getMessage());
        b.f(paramArrayOfByte2, paramArrayOfByte3.toString());
        return new byte[0];
      }
    }
    b.f(TAG, "gcm encrypt param is not right");
    return new byte[0];
  }
  
  public static AlgorithmParameterSpec getGcmAlgorithmParams(byte[] paramArrayOfByte)
  {
    if (Build.VERSION.SDK_INT < 21) {
      return new IvParameterSpec(paramArrayOfByte);
    }
    return new GCMParameterSpec(128, paramArrayOfByte);
  }
  
  public static boolean isBuildVersionHigherThan19()
  {
    return Build.VERSION.SDK_INT >= 19;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.secure.android.common.encrypt.aes.AesGcm
 * JD-Core Version:    0.7.0.1
 */
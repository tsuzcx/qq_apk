package com.huawei.secure.android.common.encrypt.aes;

import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import com.huawei.secure.android.common.encrypt.utils.b;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class AesCbc
{
  private static final String TAG = AesCbc.class.getSimpleName();
  private static final String f = "security:";
  private static final String g = "AES/CBC/PKCS5Padding";
  private static final String h = "AES";
  private static final String i = "";
  private static final int j = 16;
  private static final int k = 16;
  
  private static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString.substring(6, 12));
      localStringBuilder.append(paramString.substring(16, 26));
      localStringBuilder.append(paramString.substring(32, 48));
      paramString = localStringBuilder.toString();
      return paramString;
    }
    catch (Exception paramString)
    {
      b.f(TAG, "getIv exception : " + paramString.getMessage());
    }
    return "";
  }
  
  private static String a(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return "";
    }
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString2.substring(0, 6));
      localStringBuilder.append(paramString1.substring(0, 6));
      localStringBuilder.append(paramString2.substring(6, 10));
      localStringBuilder.append(paramString1.substring(6, 16));
      localStringBuilder.append(paramString2.substring(10, 16));
      localStringBuilder.append(paramString1.substring(16));
      localStringBuilder.append(paramString2.substring(16));
      paramString1 = localStringBuilder.toString();
      return paramString1;
    }
    catch (Exception paramString1)
    {
      b.f(TAG, "mix exception: " + paramString1.getMessage());
    }
    return "";
  }
  
  private static byte[] a(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (TextUtils.isEmpty(paramString))
    {
      b.f(TAG, "cbc encrypt param is not right");
      return new byte[0];
    }
    try
    {
      paramString = encrypt(paramString.getBytes("UTF-8"), paramArrayOfByte1, paramArrayOfByte2);
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      b.f(TAG, " cbc encrypt data error" + paramString.getMessage());
    }
    return new byte[0];
  }
  
  private static byte[] a(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[16];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, 16);
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
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString.substring(0, 6));
      localStringBuilder.append(paramString.substring(12, 16));
      localStringBuilder.append(paramString.substring(26, 32));
      localStringBuilder.append(paramString.substring(48));
      paramString = localStringBuilder.toString();
      return paramString;
    }
    catch (Exception paramString)
    {
      b.f(TAG, "get encryptword exception : " + paramString.getMessage());
    }
    return "";
  }
  
  private static byte[] b(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[paramArrayOfByte.length - 16];
    System.arraycopy(paramArrayOfByte, 16, arrayOfByte, 0, paramArrayOfByte.length - 16);
    return arrayOfByte;
  }
  
  static String c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    if (paramString.indexOf("security:") == -1) {
      return "";
    }
    return paramString.substring("security:".length());
  }
  
  static byte[] c(byte[] paramArrayOfByte)
  {
    try
    {
      String str = new String(paramArrayOfByte, "UTF-8");
      if (!str.startsWith("security:")) {
        return new byte[0];
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      Object localObject;
      for (;;)
      {
        b.f(TAG, "stripCryptHead: exception : " + localUnsupportedEncodingException.getMessage());
        localObject = "";
      }
      if (paramArrayOfByte.length > "security:".length())
      {
        localObject = new byte[paramArrayOfByte.length - "security:".length()];
        System.arraycopy(paramArrayOfByte, "security:".length(), localObject, 0, localObject.length);
        return localObject;
      }
    }
    return new byte[0];
  }
  
  private static int d(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte[16] == 58) {
      return 16;
    }
    return -1;
  }
  
  public static String decrypt(String paramString1, String paramString2)
  {
    b.d(TAG, "a c de begin");
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      b.f(TAG, "content or key is null");
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
  
  public static String decrypt(String paramString1, String paramString2, String paramString3)
  {
    b.d(TAG, "a c de begin 3");
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)))
    {
      b.f(TAG, "cbc decrypt param is not right");
      return "";
    }
    paramString2 = HexUtil.hexStr2ByteArray(paramString2);
    paramString3 = HexUtil.hexStr2ByteArray(paramString3);
    if ((paramString2.length < 16) || (paramString3.length < 16))
    {
      b.f(TAG, "key length or ivParameter is not right");
      return "";
    }
    return decrypt(paramString1, paramString2, paramString3);
  }
  
  public static String decrypt(String paramString, byte[] paramArrayOfByte)
  {
    b.d(TAG, "a c de begin 2");
    if ((TextUtils.isEmpty(paramString)) || (paramArrayOfByte == null) || (paramArrayOfByte.length < 16)) {
      return "";
    }
    String str = a(paramString);
    paramString = b(paramString);
    if ((TextUtils.isEmpty(str)) || (TextUtils.isEmpty(paramString)))
    {
      b.f(TAG, "ivParameter or encrypedWord is null");
      return "";
    }
    return decrypt(paramString, paramArrayOfByte, HexUtil.hexStr2ByteArray(str));
  }
  
  public static String decrypt(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    b.d(TAG, "a c de begin 4");
    if ((TextUtils.isEmpty(paramString)) || (paramArrayOfByte1 == null) || (paramArrayOfByte1.length < 16) || (paramArrayOfByte2 == null) || (paramArrayOfByte2.length < 16))
    {
      b.f(TAG, "cbc decrypt param is not right");
      return "";
    }
    try
    {
      paramString = new String(decrypt(HexUtil.hexStr2ByteArray(paramString), paramArrayOfByte1, paramArrayOfByte2), "UTF-8");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      b.f(TAG, " cbc decrypt data error" + paramString.getMessage());
    }
    return "";
  }
  
  public static byte[] decrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    b.d(TAG, "a c de begin 6");
    byte[] arrayOfByte = a(paramArrayOfByte1);
    return decrypt(b(paramArrayOfByte1), paramArrayOfByte2, arrayOfByte);
  }
  
  public static byte[] decrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    b.d(TAG, "a c de begin 5");
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte1.length == 0) || (paramArrayOfByte2 == null) || (paramArrayOfByte2.length < 16) || (paramArrayOfByte3 == null) || (paramArrayOfByte3.length < 16))
    {
      b.f(TAG, "cbc decrypt param is not right");
      return new byte[0];
    }
    paramArrayOfByte2 = new SecretKeySpec(paramArrayOfByte2, "AES");
    try
    {
      Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      localCipher.init(2, paramArrayOfByte2, new IvParameterSpec(paramArrayOfByte3));
      paramArrayOfByte1 = localCipher.doFinal(paramArrayOfByte1);
      return paramArrayOfByte1;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte1)
    {
      b.f(TAG, "NoSuchAlgorithmException: " + paramArrayOfByte1.getMessage());
      return new byte[0];
    }
    catch (NoSuchPaddingException paramArrayOfByte1)
    {
      for (;;)
      {
        b.f(TAG, "NoSuchPaddingException: " + paramArrayOfByte1.getMessage());
      }
    }
    catch (InvalidKeyException paramArrayOfByte1)
    {
      for (;;)
      {
        b.f(TAG, "InvalidKeyException: " + paramArrayOfByte1.getMessage());
      }
    }
    catch (InvalidAlgorithmParameterException paramArrayOfByte1)
    {
      for (;;)
      {
        b.f(TAG, "InvalidAlgorithmParameterException: " + paramArrayOfByte1.getMessage());
      }
    }
    catch (IllegalBlockSizeException paramArrayOfByte1)
    {
      for (;;)
      {
        b.f(TAG, "IllegalBlockSizeException: " + paramArrayOfByte1.getMessage());
      }
    }
    catch (BadPaddingException paramArrayOfByte1)
    {
      for (;;)
      {
        b.f(TAG, "BadPaddingException: " + paramArrayOfByte1.getMessage());
      }
    }
  }
  
  public static String decryptWithCryptHead(String paramString, byte[] paramArrayOfByte)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramArrayOfByte == null) || (paramArrayOfByte.length < 16)) {
      return "";
    }
    paramString = c(paramString);
    if ("".equals(paramString)) {
      return "";
    }
    int m = paramString.indexOf(':');
    if (m >= 0)
    {
      byte[] arrayOfByte = HexUtil.hexStr2ByteArray(paramString.substring(0, m));
      return decrypt(HexUtil.byteArray2HexStr(HexUtil.hexStr2ByteArray(paramString.substring(m + 1))), paramArrayOfByte, arrayOfByte);
    }
    b.f(TAG, " cbc cipherText data missing colon");
    return "";
  }
  
  public static String decryptWithCryptHead(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte2 == null) || (paramArrayOfByte2.length < 16)) {
      return "";
    }
    paramArrayOfByte1 = c(paramArrayOfByte1);
    if (paramArrayOfByte1.length == 0) {
      return "";
    }
    int m = d(paramArrayOfByte1);
    if (m >= 0)
    {
      byte[] arrayOfByte1 = Arrays.copyOf(paramArrayOfByte1, m);
      int n = paramArrayOfByte1.length - arrayOfByte1.length - ":".length();
      byte[] arrayOfByte2 = new byte[n];
      System.arraycopy(paramArrayOfByte1, m + 1, arrayOfByte2, 0, n);
      return decrypt(HexUtil.byteArray2HexStr(arrayOfByte2), paramArrayOfByte2, arrayOfByte1);
    }
    b.f(TAG, " cbc cipherText data missing colon");
    return "";
  }
  
  public static String encrypt(String paramString1, String paramString2)
  {
    b.d(TAG, "a c en begin");
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      b.f(TAG, "cbc encrypt param is not right");
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
  
  public static String encrypt(String paramString1, String paramString2, String paramString3)
  {
    b.d(TAG, "a c en begin 3");
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)))
    {
      b.f(TAG, "cbc encrypt param is not right");
      return "";
    }
    paramString2 = HexUtil.hexStr2ByteArray(paramString2);
    paramString3 = HexUtil.hexStr2ByteArray(paramString3);
    if ((paramString2.length < 16) || (paramString3.length < 16))
    {
      b.f(TAG, "key length or ivParameter length is not right");
      return "";
    }
    return encrypt(paramString1, paramString2, paramString3);
  }
  
  public static String encrypt(String paramString, byte[] paramArrayOfByte)
  {
    b.d(TAG, "a c en begin 2");
    if ((TextUtils.isEmpty(paramString)) || (paramArrayOfByte == null) || (paramArrayOfByte.length < 16))
    {
      b.f(TAG, "cbc encrypt param is not right");
      return "";
    }
    byte[] arrayOfByte = EncryptUtil.generateSecureRandom(16);
    paramString = a(paramString, paramArrayOfByte, arrayOfByte);
    if ((paramString == null) || (paramString.length == 0)) {
      return "";
    }
    return a(HexUtil.byteArray2HexStr(arrayOfByte), HexUtil.byteArray2HexStr(paramString));
  }
  
  public static String encrypt(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    b.d(TAG, "a c en begin 4");
    if ((TextUtils.isEmpty(paramString)) || (paramArrayOfByte1 == null) || (paramArrayOfByte1.length < 16) || (paramArrayOfByte2 == null) || (paramArrayOfByte2.length < 16))
    {
      b.f(TAG, "cbc encrypt param is not right");
      return "";
    }
    return HexUtil.byteArray2HexStr(a(paramString, paramArrayOfByte1, paramArrayOfByte2));
  }
  
  public static byte[] encrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    b.d(TAG, "a c en begin 6");
    byte[] arrayOfByte = EncryptUtil.generateSecureRandom(16);
    return a(arrayOfByte, encrypt(paramArrayOfByte1, paramArrayOfByte2, arrayOfByte));
  }
  
  public static byte[] encrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    b.d(TAG, "a c en begin 5");
    if ((paramArrayOfByte1 == null) || (paramArrayOfByte1.length == 0) || (paramArrayOfByte2 == null) || (paramArrayOfByte2.length < 16) || (paramArrayOfByte3 == null) || (paramArrayOfByte3.length < 16))
    {
      b.f(TAG, "cbc encrypt param is not right");
      return new byte[0];
    }
    paramArrayOfByte2 = new SecretKeySpec(paramArrayOfByte2, "AES");
    try
    {
      Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      localCipher.init(1, paramArrayOfByte2, new IvParameterSpec(paramArrayOfByte3));
      paramArrayOfByte1 = localCipher.doFinal(paramArrayOfByte1);
      return paramArrayOfByte1;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte1)
    {
      b.f(TAG, "NoSuchAlgorithmException: " + paramArrayOfByte1.getMessage());
      return new byte[0];
    }
    catch (NoSuchPaddingException paramArrayOfByte1)
    {
      for (;;)
      {
        b.f(TAG, "NoSuchPaddingException: " + paramArrayOfByte1.getMessage());
      }
    }
    catch (InvalidKeyException paramArrayOfByte1)
    {
      for (;;)
      {
        b.f(TAG, "InvalidKeyException: " + paramArrayOfByte1.getMessage());
      }
    }
    catch (InvalidAlgorithmParameterException paramArrayOfByte1)
    {
      for (;;)
      {
        b.f(TAG, "InvalidAlgorithmParameterException: " + paramArrayOfByte1.getMessage());
      }
    }
    catch (IllegalBlockSizeException paramArrayOfByte1)
    {
      for (;;)
      {
        b.f(TAG, "IllegalBlockSizeException: " + paramArrayOfByte1.getMessage());
      }
    }
    catch (BadPaddingException paramArrayOfByte1)
    {
      for (;;)
      {
        b.f(TAG, "BadPaddingException: " + paramArrayOfByte1.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.secure.android.common.encrypt.aes.AesCbc
 * JD-Core Version:    0.7.0.1
 */
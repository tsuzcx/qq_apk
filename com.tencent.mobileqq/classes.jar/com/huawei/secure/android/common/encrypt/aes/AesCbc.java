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
  private static final String TAG = "AesCbc";
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
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString.substring(6, 12));
      ((StringBuilder)localObject).append(paramString.substring(16, 26));
      ((StringBuilder)localObject).append(paramString.substring(32, 48));
      paramString = ((StringBuilder)localObject).toString();
      return paramString;
    }
    catch (Exception paramString)
    {
      Object localObject = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getIv exception : ");
      localStringBuilder.append(paramString.getMessage());
      b.f((String)localObject, localStringBuilder.toString());
    }
    return "";
  }
  
  private static String a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (TextUtils.isEmpty(paramString2)) {
        return "";
      }
      try
      {
        localStringBuilder = new StringBuilder();
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
        paramString2 = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("mix exception: ");
        localStringBuilder.append(paramString1.getMessage());
        b.f(paramString2, localStringBuilder.toString());
      }
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
      paramArrayOfByte1 = TAG;
      paramArrayOfByte2 = new StringBuilder();
      paramArrayOfByte2.append(" cbc encrypt data error");
      paramArrayOfByte2.append(paramString.getMessage());
      b.f(paramArrayOfByte1, paramArrayOfByte2.toString());
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
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString.substring(0, 6));
      ((StringBuilder)localObject).append(paramString.substring(12, 16));
      ((StringBuilder)localObject).append(paramString.substring(26, 32));
      ((StringBuilder)localObject).append(paramString.substring(48));
      paramString = ((StringBuilder)localObject).toString();
      return paramString;
    }
    catch (Exception paramString)
    {
      Object localObject = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("get encryptword exception : ");
      localStringBuilder.append(paramString.getMessage());
      b.f((String)localObject, localStringBuilder.toString());
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
    return paramString.substring(9);
  }
  
  static byte[] c(byte[] paramArrayOfByte)
  {
    Object localObject;
    try
    {
      String str1 = new String(paramArrayOfByte, "UTF-8");
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      String str2 = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("stripCryptHead: exception : ");
      localStringBuilder.append(localUnsupportedEncodingException.getMessage());
      b.f(str2, localStringBuilder.toString());
      localObject = "";
    }
    if (!((String)localObject).startsWith("security:")) {
      return new byte[0];
    }
    if (paramArrayOfByte.length > 9)
    {
      localObject = new byte[paramArrayOfByte.length - 9];
      System.arraycopy(paramArrayOfByte, 9, localObject, 0, localObject.length);
      return localObject;
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
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      paramString2 = HexUtil.hexStr2ByteArray(paramString2);
      if (paramString2.length < 16)
      {
        b.f(TAG, "key length is not right");
        return "";
      }
      return decrypt(paramString1, paramString2);
    }
    b.f(TAG, "content or key is null");
    return "";
  }
  
  public static String decrypt(String paramString1, String paramString2, String paramString3)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)))
    {
      paramString2 = HexUtil.hexStr2ByteArray(paramString2);
      paramString3 = HexUtil.hexStr2ByteArray(paramString3);
      if ((paramString2.length >= 16) && (paramString3.length >= 16)) {
        return decrypt(paramString1, paramString2, paramString3);
      }
      b.f(TAG, "key length or ivParameter is not right");
      return "";
    }
    b.f(TAG, "cbc decrypt param is not right");
    return "";
  }
  
  public static String decrypt(String paramString, byte[] paramArrayOfByte)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramArrayOfByte != null))
    {
      if (paramArrayOfByte.length < 16) {
        return "";
      }
      String str = a(paramString);
      paramString = b(paramString);
      if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(paramString))) {
        return decrypt(paramString, paramArrayOfByte, HexUtil.hexStr2ByteArray(str));
      }
      b.f(TAG, "ivParameter or encrypedWord is null");
    }
    return "";
  }
  
  public static String decrypt(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramArrayOfByte1 != null) && (paramArrayOfByte1.length >= 16) && (paramArrayOfByte2 != null) && (paramArrayOfByte2.length >= 16)) {
      try
      {
        paramString = new String(decrypt(HexUtil.hexStr2ByteArray(paramString), paramArrayOfByte1, paramArrayOfByte2), "UTF-8");
        return paramString;
      }
      catch (UnsupportedEncodingException paramString)
      {
        paramArrayOfByte1 = TAG;
        paramArrayOfByte2 = new StringBuilder();
        paramArrayOfByte2.append(" cbc decrypt data error");
        paramArrayOfByte2.append(paramString.getMessage());
        b.f(paramArrayOfByte1, paramArrayOfByte2.toString());
        return "";
      }
    }
    b.f(TAG, "cbc decrypt param is not right");
    return "";
  }
  
  public static byte[] decrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte = a(paramArrayOfByte1);
    return decrypt(b(paramArrayOfByte1), paramArrayOfByte2, arrayOfByte);
  }
  
  public static byte[] decrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    if ((paramArrayOfByte1 != null) && (paramArrayOfByte1.length != 0) && (paramArrayOfByte2 != null) && (paramArrayOfByte2.length >= 16) && (paramArrayOfByte3 != null) && (paramArrayOfByte3.length >= 16))
    {
      paramArrayOfByte2 = new SecretKeySpec(paramArrayOfByte2, "AES");
      try
      {
        Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        localCipher.init(2, paramArrayOfByte2, new IvParameterSpec(paramArrayOfByte3));
        paramArrayOfByte1 = localCipher.doFinal(paramArrayOfByte1);
        return paramArrayOfByte1;
      }
      catch (BadPaddingException paramArrayOfByte1)
      {
        paramArrayOfByte2 = TAG;
        paramArrayOfByte3 = new StringBuilder();
        paramArrayOfByte3.append("BadPaddingException: ");
        paramArrayOfByte3.append(paramArrayOfByte1.getMessage());
        b.f(paramArrayOfByte2, paramArrayOfByte3.toString());
      }
      catch (IllegalBlockSizeException paramArrayOfByte1)
      {
        paramArrayOfByte2 = TAG;
        paramArrayOfByte3 = new StringBuilder();
        paramArrayOfByte3.append("IllegalBlockSizeException: ");
        paramArrayOfByte3.append(paramArrayOfByte1.getMessage());
        b.f(paramArrayOfByte2, paramArrayOfByte3.toString());
      }
      catch (InvalidAlgorithmParameterException paramArrayOfByte1)
      {
        paramArrayOfByte2 = TAG;
        paramArrayOfByte3 = new StringBuilder();
        paramArrayOfByte3.append("InvalidAlgorithmParameterException: ");
        paramArrayOfByte3.append(paramArrayOfByte1.getMessage());
        b.f(paramArrayOfByte2, paramArrayOfByte3.toString());
      }
      catch (InvalidKeyException paramArrayOfByte1)
      {
        paramArrayOfByte2 = TAG;
        paramArrayOfByte3 = new StringBuilder();
        paramArrayOfByte3.append("InvalidKeyException: ");
        paramArrayOfByte3.append(paramArrayOfByte1.getMessage());
        b.f(paramArrayOfByte2, paramArrayOfByte3.toString());
      }
      catch (NoSuchPaddingException paramArrayOfByte1)
      {
        paramArrayOfByte2 = TAG;
        paramArrayOfByte3 = new StringBuilder();
        paramArrayOfByte3.append("NoSuchPaddingException: ");
        paramArrayOfByte3.append(paramArrayOfByte1.getMessage());
        b.f(paramArrayOfByte2, paramArrayOfByte3.toString());
      }
      catch (NoSuchAlgorithmException paramArrayOfByte1)
      {
        paramArrayOfByte2 = TAG;
        paramArrayOfByte3 = new StringBuilder();
        paramArrayOfByte3.append("NoSuchAlgorithmException: ");
        paramArrayOfByte3.append(paramArrayOfByte1.getMessage());
        b.f(paramArrayOfByte2, paramArrayOfByte3.toString());
      }
      return new byte[0];
    }
    b.f(TAG, "cbc decrypt param is not right");
    return new byte[0];
  }
  
  public static String decryptWithCryptHead(String paramString, byte[] paramArrayOfByte)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramArrayOfByte != null))
    {
      if (paramArrayOfByte.length < 16) {
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
    b.f(TAG, "decryptWithCryptHead UnsupportedEncodingException ");
    return "";
  }
  
  public static byte[] decryptWithCryptHeadReturnByte(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if ((paramArrayOfByte1 != null) && (paramArrayOfByte2 != null) && (paramArrayOfByte2.length >= 16))
    {
      paramArrayOfByte1 = c(paramArrayOfByte1);
      if (paramArrayOfByte1.length == 0) {
        return new byte[0];
      }
      int m = d(paramArrayOfByte1);
      if (m >= 0)
      {
        byte[] arrayOfByte1 = Arrays.copyOf(paramArrayOfByte1, m);
        int n = paramArrayOfByte1.length - arrayOfByte1.length - 1;
        byte[] arrayOfByte2 = new byte[n];
        System.arraycopy(paramArrayOfByte1, m + 1, arrayOfByte2, 0, n);
        return decrypt(arrayOfByte2, paramArrayOfByte2, arrayOfByte1);
      }
      b.f(TAG, " cbc cipherText data missing colon");
      return new byte[0];
    }
    return new byte[0];
  }
  
  public static String encrypt(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      paramString2 = HexUtil.hexStr2ByteArray(paramString2);
      if (paramString2.length < 16)
      {
        b.f(TAG, "key length is not right");
        return "";
      }
      return encrypt(paramString1, paramString2);
    }
    b.f(TAG, "cbc encrypt param is not right");
    return "";
  }
  
  public static String encrypt(String paramString1, String paramString2, String paramString3)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)))
    {
      paramString2 = HexUtil.hexStr2ByteArray(paramString2);
      paramString3 = HexUtil.hexStr2ByteArray(paramString3);
      if ((paramString2.length >= 16) && (paramString3.length >= 16)) {
        return encrypt(paramString1, paramString2, paramString3);
      }
      b.f(TAG, "key length or ivParameter length is not right");
      return "";
    }
    b.f(TAG, "cbc encrypt param is not right");
    return "";
  }
  
  public static String encrypt(String paramString, byte[] paramArrayOfByte)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramArrayOfByte != null) && (paramArrayOfByte.length >= 16))
    {
      byte[] arrayOfByte = EncryptUtil.generateSecureRandom(16);
      paramString = a(paramString, paramArrayOfByte, arrayOfByte);
      if (paramString != null)
      {
        if (paramString.length == 0) {
          return "";
        }
        return a(HexUtil.byteArray2HexStr(arrayOfByte), HexUtil.byteArray2HexStr(paramString));
      }
      return "";
    }
    b.f(TAG, "cbc encrypt param is not right");
    return "";
  }
  
  public static String encrypt(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramArrayOfByte1 != null) && (paramArrayOfByte1.length >= 16) && (paramArrayOfByte2 != null) && (paramArrayOfByte2.length >= 16)) {
      return HexUtil.byteArray2HexStr(a(paramString, paramArrayOfByte1, paramArrayOfByte2));
    }
    b.f(TAG, "cbc encrypt param is not right");
    return "";
  }
  
  public static byte[] encrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte = EncryptUtil.generateSecureRandom(16);
    return a(arrayOfByte, encrypt(paramArrayOfByte1, paramArrayOfByte2, arrayOfByte));
  }
  
  public static byte[] encrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    if ((paramArrayOfByte1 != null) && (paramArrayOfByte1.length != 0) && (paramArrayOfByte2 != null) && (paramArrayOfByte2.length >= 16) && (paramArrayOfByte3 != null) && (paramArrayOfByte3.length >= 16))
    {
      paramArrayOfByte2 = new SecretKeySpec(paramArrayOfByte2, "AES");
      try
      {
        Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        localCipher.init(1, paramArrayOfByte2, new IvParameterSpec(paramArrayOfByte3));
        paramArrayOfByte1 = localCipher.doFinal(paramArrayOfByte1);
        return paramArrayOfByte1;
      }
      catch (BadPaddingException paramArrayOfByte1)
      {
        paramArrayOfByte2 = TAG;
        paramArrayOfByte3 = new StringBuilder();
        paramArrayOfByte3.append("BadPaddingException: ");
        paramArrayOfByte3.append(paramArrayOfByte1.getMessage());
        b.f(paramArrayOfByte2, paramArrayOfByte3.toString());
      }
      catch (IllegalBlockSizeException paramArrayOfByte1)
      {
        paramArrayOfByte2 = TAG;
        paramArrayOfByte3 = new StringBuilder();
        paramArrayOfByte3.append("IllegalBlockSizeException: ");
        paramArrayOfByte3.append(paramArrayOfByte1.getMessage());
        b.f(paramArrayOfByte2, paramArrayOfByte3.toString());
      }
      catch (InvalidAlgorithmParameterException paramArrayOfByte1)
      {
        paramArrayOfByte2 = TAG;
        paramArrayOfByte3 = new StringBuilder();
        paramArrayOfByte3.append("InvalidAlgorithmParameterException: ");
        paramArrayOfByte3.append(paramArrayOfByte1.getMessage());
        b.f(paramArrayOfByte2, paramArrayOfByte3.toString());
      }
      catch (InvalidKeyException paramArrayOfByte1)
      {
        paramArrayOfByte2 = TAG;
        paramArrayOfByte3 = new StringBuilder();
        paramArrayOfByte3.append("InvalidKeyException: ");
        paramArrayOfByte3.append(paramArrayOfByte1.getMessage());
        b.f(paramArrayOfByte2, paramArrayOfByte3.toString());
      }
      catch (NoSuchPaddingException paramArrayOfByte1)
      {
        paramArrayOfByte2 = TAG;
        paramArrayOfByte3 = new StringBuilder();
        paramArrayOfByte3.append("NoSuchPaddingException: ");
        paramArrayOfByte3.append(paramArrayOfByte1.getMessage());
        b.f(paramArrayOfByte2, paramArrayOfByte3.toString());
      }
      catch (NoSuchAlgorithmException paramArrayOfByte1)
      {
        paramArrayOfByte2 = TAG;
        paramArrayOfByte3 = new StringBuilder();
        paramArrayOfByte3.append("NoSuchAlgorithmException: ");
        paramArrayOfByte3.append(paramArrayOfByte1.getMessage());
        b.f(paramArrayOfByte2, paramArrayOfByte3.toString());
      }
      return new byte[0];
    }
    b.f(TAG, "cbc encrypt param is not right");
    return new byte[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.secure.android.common.encrypt.aes.AesCbc
 * JD-Core Version:    0.7.0.1
 */
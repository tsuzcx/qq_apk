package com.huawei.secure.android.common.encrypt.aes;

import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import com.huawei.secure.android.common.encrypt.utils.b;
import java.security.GeneralSecurityException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class CipherUtil
{
  private static final String TAG = "CipherUtil";
  private static final String g = "AES/CBC/PKCS5Padding";
  private static final String h = "AES";
  private static final String i = "";
  private static final int k = 16;
  private static final String l = "AES/GCM/NoPadding";
  private static final int m = 16;
  private static final int n = 12;
  
  private static int a(Cipher paramCipher, byte[] paramArrayOfByte)
  {
    if ((paramCipher != null) && (paramArrayOfByte != null)) {
      return paramCipher.getOutputSize(paramArrayOfByte.length);
    }
    return -1;
  }
  
  private static Cipher a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    return a(paramArrayOfByte1, paramArrayOfByte2, paramInt, "AES/GCM/NoPadding");
  }
  
  private static Cipher a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt, String paramString)
  {
    if ((paramArrayOfByte1 != null) && (paramArrayOfByte1.length >= 16) && (paramArrayOfByte2 != null) && (paramArrayOfByte2.length >= 12) && (AesGcm.isBuildVersionHigherThan19())) {
      try
      {
        SecretKeySpec localSecretKeySpec = new SecretKeySpec(paramArrayOfByte1, "AES");
        Cipher localCipher = Cipher.getInstance(paramString);
        if ("AES/GCM/NoPadding".equals(paramString)) {
          paramArrayOfByte1 = AesGcm.getGcmAlgorithmParams(paramArrayOfByte2);
        } else {
          paramArrayOfByte1 = new IvParameterSpec(paramArrayOfByte2);
        }
        localCipher.init(paramInt, localSecretKeySpec, paramArrayOfByte1);
        return localCipher;
      }
      catch (GeneralSecurityException paramArrayOfByte1)
      {
        paramArrayOfByte2 = new StringBuilder();
        paramArrayOfByte2.append("GCM encrypt data error");
        paramArrayOfByte2.append(paramArrayOfByte1.getMessage());
        b.f("CipherUtil", paramArrayOfByte2.toString());
        return null;
      }
    }
    b.f("CipherUtil", "gcm encrypt param is not right");
    return null;
  }
  
  private static Cipher b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    return a(paramArrayOfByte1, paramArrayOfByte2, paramInt, "AES/CBC/PKCS5Padding");
  }
  
  public static Cipher getAesCbcDecryptCipher(byte[] paramArrayOfByte, Cipher paramCipher)
  {
    return getAesCbcDecryptCipher(paramArrayOfByte, paramCipher.getIV());
  }
  
  public static Cipher getAesCbcDecryptCipher(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return b(paramArrayOfByte1, paramArrayOfByte2, 2);
  }
  
  public static Cipher getAesCbcEncryptCipher(byte[] paramArrayOfByte)
  {
    return getAesCbcEncryptCipher(paramArrayOfByte, EncryptUtil.generateSecureRandom(16));
  }
  
  public static Cipher getAesCbcEncryptCipher(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return b(paramArrayOfByte1, paramArrayOfByte2, 1);
  }
  
  public static int getAesCbcEncryptContentLen(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return getAesCbcEncryptContentLen(paramArrayOfByte1, paramArrayOfByte2, EncryptUtil.generateSecureRandom(16));
  }
  
  public static int getAesCbcEncryptContentLen(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    return a(getAesCbcEncryptCipher(paramArrayOfByte2, paramArrayOfByte3), paramArrayOfByte1);
  }
  
  public static Cipher getAesGcmDecryptCipher(byte[] paramArrayOfByte, Cipher paramCipher)
  {
    return getAesGcmDecryptCipher(paramArrayOfByte, paramCipher.getIV());
  }
  
  public static Cipher getAesGcmDecryptCipher(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return a(paramArrayOfByte1, paramArrayOfByte2, 2);
  }
  
  public static Cipher getAesGcmEncryptCipher(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = EncryptUtil.generateSecureRandom(12);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getEncryptCipher: iv is : ");
    localStringBuilder.append(HexUtil.byteArray2HexStr(arrayOfByte));
    b.c("CipherUtil", localStringBuilder.toString());
    return getAesGcmEncryptCipher(paramArrayOfByte, arrayOfByte);
  }
  
  public static Cipher getAesGcmEncryptCipher(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return a(paramArrayOfByte1, paramArrayOfByte2, 1);
  }
  
  public static int getAesGcmEncryptContentLen(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return getAesGcmEncryptContentLen(paramArrayOfByte1, paramArrayOfByte2, EncryptUtil.generateSecureRandom(12));
  }
  
  public static int getAesGcmEncryptContentLen(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    return a(getAesGcmEncryptCipher(paramArrayOfByte2, paramArrayOfByte3), paramArrayOfByte1);
  }
  
  public static int getContent(Cipher paramCipher, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if ((paramCipher != null) && (paramArrayOfByte1 != null)) {}
    try
    {
      int j = paramCipher.doFinal(paramArrayOfByte1, 0, paramArrayOfByte1.length, paramArrayOfByte2);
      return j;
    }
    catch (BadPaddingException paramCipher)
    {
      break label41;
    }
    catch (IllegalBlockSizeException paramCipher)
    {
      break label32;
    }
    catch (ShortBufferException paramCipher)
    {
      label23:
      break label23;
    }
    b.f("CipherUtil", "getContent: ShortBufferException");
    return -1;
    label32:
    b.f("CipherUtil", "getContent: IllegalBlockSizeException");
    return -1;
    label41:
    b.f("CipherUtil", "getContent: BadPaddingException");
    return -1;
    b.f("CipherUtil", "getEncryptCOntent: cipher is null or content is null");
    return -1;
  }
  
  public static byte[] getContent(Cipher paramCipher, byte[] paramArrayOfByte)
  {
    if ((paramCipher != null) && (paramArrayOfByte != null)) {}
    try
    {
      paramCipher = paramCipher.doFinal(paramArrayOfByte, 0, paramArrayOfByte.length);
      return paramCipher;
    }
    catch (BadPaddingException paramCipher)
    {
      break label32;
    }
    catch (IllegalBlockSizeException paramCipher)
    {
      label22:
      break label22;
    }
    b.f("CipherUtil", "getContent: IllegalBlockSizeException");
    break label39;
    label32:
    b.f("CipherUtil", "getContent: BadPaddingException");
    label39:
    return new byte[0];
    b.f("CipherUtil", "getEncryptCOntent: cipher is null or content is null");
    return new byte[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.secure.android.common.encrypt.aes.CipherUtil
 * JD-Core Version:    0.7.0.1
 */
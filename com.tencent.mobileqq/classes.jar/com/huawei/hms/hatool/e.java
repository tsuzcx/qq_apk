package com.huawei.hms.hatool;

import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class e
{
  public static String a(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = a(paramString1, paramString2.getBytes("UTF-8"));
      return paramString1;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      label13:
      break label13;
    }
    y.c("hmsSdk", "Unsupported encoding exception,utf-8");
    return "";
  }
  
  public static String a(String paramString, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0)) {}
    try
    {
      paramString = HexUtil.byteArray2HexStr(a(paramArrayOfByte, a(HexUtil.hexStr2ByteArray(paramString))));
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      break label35;
    }
    catch (InvalidKeySpecException paramString)
    {
      label29:
      break label29;
    }
    paramString = "encrypt(): Invalid key specification";
    break label38;
    label35:
    paramString = "encrypt(): getInstance - No such algorithm,transformation";
    label38:
    y.f("hmsSdk", paramString);
    return "";
    y.f("hmsSdk", "encrypt: content is empty or null");
    return "";
  }
  
  public static PublicKey a(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new X509EncodedKeySpec(paramArrayOfByte);
    return KeyFactory.getInstance("RSA").generatePublic(paramArrayOfByte);
  }
  
  public static byte[] a(byte[] paramArrayOfByte, PublicKey paramPublicKey)
  {
    if (paramPublicKey != null) {}
    try
    {
      Cipher localCipher = Cipher.getInstance("RSA/ECB/OAEPWITHSHA-1ANDMGF1PADDING");
      localCipher.init(1, paramPublicKey);
      return localCipher.doFinal(paramArrayOfByte);
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      break label62;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte)
    {
      break label56;
    }
    catch (InvalidKeyException paramArrayOfByte)
    {
      break label50;
    }
    catch (NoSuchPaddingException paramArrayOfByte)
    {
      break label44;
    }
    catch (BadPaddingException paramArrayOfByte)
    {
      break label38;
    }
    catch (IllegalBlockSizeException paramArrayOfByte)
    {
      break label32;
    }
    throw new UnsupportedEncodingException("The loaded public key is null");
    label32:
    paramArrayOfByte = "rsaEncrypt(): doFinal - The provided block is not filled with";
    break label65;
    label38:
    paramArrayOfByte = "rsaEncrypt():False filling parameters!";
    break label65;
    label44:
    paramArrayOfByte = "rsaEncrypt():  No such filling parameters ";
    break label65;
    label50:
    paramArrayOfByte = "rsaEncrypt(): init - Invalid key!";
    break label65;
    label56:
    paramArrayOfByte = "rsaEncrypt(): getInstance - No such algorithm,transformation";
    break label65;
    label62:
    paramArrayOfByte = "rsaEncrypt(): getBytes - Unsupported coding format!";
    label65:
    y.f("hmsSdk", paramArrayOfByte);
    return new byte[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.hatool.e
 * JD-Core Version:    0.7.0.1
 */
package com.huawei.secure.android.common.encrypt.hash;

import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import com.huawei.secure.android.common.encrypt.utils.b;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public abstract class HMACSHA256
{
  private static final String TAG = HMACSHA256.class.getSimpleName();
  private static final String i = "";
  private static final String s = "HmacSHA256";
  private static final int t = 32;
  
  public static String hmacSHA256Encrypt(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return "";
    }
    return hmacSHA256Encrypt(paramString1, HexUtil.hexStr2ByteArray(paramString2));
  }
  
  public static String hmacSHA256Encrypt(String paramString, byte[] paramArrayOfByte)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramArrayOfByte == null)) {
      return "";
    }
    if (paramArrayOfByte.length < 32)
    {
      b.f(TAG, "hmac key length is not right");
      return "";
    }
    try
    {
      paramArrayOfByte = new SecretKeySpec(paramArrayOfByte, "HmacSHA256");
      Mac localMac = Mac.getInstance(paramArrayOfByte.getAlgorithm());
      localMac.init(paramArrayOfByte);
      paramString = HexUtil.byteArray2HexStr(localMac.doFinal(paramString.getBytes("UTF-8")));
      return paramString;
    }
    catch (NoSuchAlgorithmException paramString)
    {
      b.f(TAG, "hmacsha256 encrypt exception" + paramString.getMessage());
      return "";
    }
    catch (InvalidKeyException paramString)
    {
      break label73;
    }
    catch (UnsupportedEncodingException paramString)
    {
      label73:
      break label73;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.secure.android.common.encrypt.hash.HMACSHA256
 * JD-Core Version:    0.7.0.1
 */
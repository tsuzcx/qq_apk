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
  private static final String TAG = "HMACSHA256";
  private static final String i = "";
  private static final String s = "HmacSHA256";
  private static final int t = 32;
  
  public static String hmacSHA256Encrypt(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      return hmacSHA256Encrypt(paramString1, HexUtil.hexStr2ByteArray(paramString2));
    }
    return "";
  }
  
  public static String hmacSHA256Encrypt(String paramString, byte[] paramArrayOfByte)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramArrayOfByte == null) {
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
        localObject = Mac.getInstance(paramArrayOfByte.getAlgorithm());
        ((Mac)localObject).init(paramArrayOfByte);
        paramString = HexUtil.byteArray2HexStr(((Mac)localObject).doFinal(paramString.getBytes("UTF-8")));
        return paramString;
      }
      catch (NoSuchAlgorithmException paramString) {}catch (InvalidKeyException paramString) {}catch (UnsupportedEncodingException paramString) {}
      paramArrayOfByte = TAG;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("hmacsha256 encrypt exception");
      ((StringBuilder)localObject).append(paramString.getMessage());
      b.f(paramArrayOfByte, ((StringBuilder)localObject).toString());
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.huawei.secure.android.common.encrypt.hash.HMACSHA256
 * JD-Core Version:    0.7.0.1
 */
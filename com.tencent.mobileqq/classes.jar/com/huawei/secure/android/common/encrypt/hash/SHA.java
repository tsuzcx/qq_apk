package com.huawei.secure.android.common.encrypt.hash;

import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import com.huawei.secure.android.common.encrypt.utils.b;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class SHA
{
  private static final String B = "SHA-256";
  private static final String TAG = SHA.class.getSimpleName();
  private static final String i = "";
  private static final String[] r = { "SHA-256", "SHA-384", "SHA-512" };
  
  private static boolean d(String paramString)
  {
    boolean bool2 = false;
    String[] arrayOfString = r;
    int k = arrayOfString.length;
    int j = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (j < k)
      {
        if (arrayOfString[j].equals(paramString)) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      j += 1;
    }
  }
  
  public static String sha256Encrypt(String paramString)
  {
    return shaEncrypt(paramString, "SHA-256");
  }
  
  public static String shaEncrypt(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      b.f(TAG, "content or algorithm is null.");
      return "";
    }
    if (!d(paramString2))
    {
      b.f(TAG, "algorithm is not safe or legal");
      return "";
    }
    try
    {
      paramString2 = MessageDigest.getInstance(paramString2);
      paramString2.update(paramString1.getBytes("UTF-8"));
      paramString1 = HexUtil.byteArray2HexStr(paramString2.digest());
      return paramString1;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      b.f(TAG, "Error in generate SHA UnsupportedEncodingException");
      return "";
    }
    catch (NoSuchAlgorithmException paramString1)
    {
      for (;;)
      {
        b.f(TAG, "Error in generate SHA NoSuchAlgorithmException");
      }
    }
  }
  
  public static boolean validateSHA(String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3))) {
      return false;
    }
    return paramString2.equals(shaEncrypt(paramString1, paramString3));
  }
  
  public static boolean validateSHA256(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return false;
    }
    return paramString2.equals(sha256Encrypt(paramString1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.secure.android.common.encrypt.hash.SHA
 * JD-Core Version:    0.7.0.1
 */
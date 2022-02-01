package c.t.m.sapp.c;

import android.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class m
{
  public static final byte[] a = { 84, 101, 110, 99, 101, 110, 116, 76, 111, 99, 97, 116, 105, 111, 110, 49 };
  public static final byte[] b = new byte[0];
  
  public static String a(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2, 2);
  }
  
  public static String a(String paramString1, String paramString2, int paramInt)
  {
    if ((paramInt != 1) && (paramInt != 2)) {
      throw new IllegalArgumentException("wrong mode.");
    }
    if (paramString1 != null)
    {
      if (paramString1.length() == 0) {
        return "";
      }
      if (paramInt != 1) {}
    }
    for (;;)
    {
      try
      {
        paramString1 = paramString1.getBytes();
        if (paramInt == 2)
        {
          paramString1 = Base64.decode(paramString1.getBytes(), 2);
          if (paramString1 != null)
          {
            if (paramString1.length == 0) {
              return "";
            }
            paramString1 = a(paramString1, paramString2, paramInt);
            if (paramInt == 1) {
              return Base64.encodeToString(paramString1, 2);
            }
            if (paramInt == 2)
            {
              paramString1 = new String(paramString1);
              return paramString1;
            }
            return null;
          }
          return "";
        }
      }
      catch (Throwable paramString1)
      {
        return "";
      }
      paramString1 = null;
    }
  }
  
  public static Cipher a(String paramString, int paramInt)
  {
    paramString = new SecretKeySpec(paramString.getBytes("UTF-8"), "AES");
    Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    localCipher.init(paramInt, paramString, new IvParameterSpec(a));
    return localCipher;
  }
  
  public static byte[] a(byte[] paramArrayOfByte, String paramString)
  {
    return a(paramArrayOfByte, paramString, 2);
  }
  
  public static byte[] a(byte[] paramArrayOfByte, String paramString, int paramInt)
  {
    if ((paramInt != 1) && (paramInt != 2)) {
      throw new IllegalArgumentException("wrong mode.");
    }
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0)) {}
    try
    {
      paramString = a(paramString, paramInt);
      if (paramString == null) {
        return b;
      }
      paramArrayOfByte = paramString.doFinal(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      label57:
      break label57;
    }
    return b;
    return b;
  }
  
  public static String b(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2, 1);
  }
  
  public static byte[] b(byte[] paramArrayOfByte, String paramString)
  {
    return a(paramArrayOfByte, paramString, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.sapp.c.m
 * JD-Core Version:    0.7.0.1
 */
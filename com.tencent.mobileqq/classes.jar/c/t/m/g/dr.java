package c.t.m.g;

import android.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class dr
{
  private static final byte[] a = { 84, 101, 110, 99, 101, 110, 116, 76, 111, 99, 97, 116, 105, 111, 110, 49 };
  
  public static String a(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2, 1);
  }
  
  private static String a(String paramString1, String paramString2, int paramInt)
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
            paramString1 = a(paramString1, paramString1.length, paramString2, paramInt);
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
  
  private static byte[] a(byte[] paramArrayOfByte, int paramInt1, String paramString, int paramInt2)
  {
    if ((paramInt2 != 1) && (paramInt2 != 2)) {
      throw new IllegalArgumentException("wrong mode.");
    }
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0) && (paramInt1 != 0)) {}
    try
    {
      paramString = new SecretKeySpec(paramString.getBytes("UTF-8"), "AES");
      Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      localCipher.init(paramInt2, paramString, new IvParameterSpec(a));
      if (localCipher == null) {
        return do.a;
      }
      paramArrayOfByte = localCipher.doFinal(paramArrayOfByte, 0, paramInt1);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte)
    {
      label99:
      break label99;
    }
    return do.a;
    return do.a;
  }
  
  public static byte[] a(byte[] paramArrayOfByte, String paramString)
  {
    return a(paramArrayOfByte, paramArrayOfByte.length, paramString, 1);
  }
  
  public static String b(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.dr
 * JD-Core Version:    0.7.0.1
 */
package c.t.m.g;

import android.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public final class cv
{
  private static final byte[] a = { 84, 101, 110, 99, 101, 110, 116, 76, 111, 99, 97, 116, 105, 111, 110, 49 };
  private static final byte[] b = new byte[0];
  
  public static String a(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2, 1);
  }
  
  private static String a(String paramString1, String paramString2, int paramInt)
  {
    Object localObject = null;
    if ((paramInt != 1) && (paramInt != 2)) {
      throw new IllegalArgumentException("wrong mode.");
    }
    if ((paramString1 == null) || (paramString1.length() == 0))
    {
      paramString1 = "";
      return paramString1;
    }
    if (paramInt == 1) {}
    for (;;)
    {
      try
      {
        paramString1 = paramString1.getBytes();
        if (paramString1 == null) {
          break label122;
        }
        if (paramString1.length == 0)
        {
          break label122;
          if (paramInt == 2) {
            paramString1 = Base64.decode(paramString1.getBytes(), 2);
          }
        }
        else
        {
          paramString2 = a(paramString1, paramString2, paramInt);
          if (paramInt == 1) {
            return Base64.encodeToString(paramString2, 2);
          }
          paramString1 = localObject;
          if (paramInt != 2) {
            break;
          }
          paramString1 = new String(paramString2);
          return paramString1;
        }
      }
      catch (Throwable paramString1)
      {
        return "";
      }
      paramString1 = null;
    }
    label122:
    return "";
  }
  
  private static byte[] a(byte[] paramArrayOfByte, String paramString, int paramInt)
  {
    if ((paramInt != 1) && (paramInt != 2)) {
      throw new IllegalArgumentException("wrong mode.");
    }
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return b;
    }
    try
    {
      paramString = new SecretKeySpec(paramString.getBytes("UTF-8"), "AES");
      Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      localCipher.init(paramInt, paramString, new IvParameterSpec(a));
      if (localCipher == null) {
        return b;
      }
      paramArrayOfByte = localCipher.doFinal(paramArrayOfByte);
      return paramArrayOfByte;
    }
    catch (Throwable paramArrayOfByte) {}
    return b;
  }
  
  public static String b(String paramString1, String paramString2)
  {
    return a(paramString1, paramString2, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.cv
 * JD-Core Version:    0.7.0.1
 */
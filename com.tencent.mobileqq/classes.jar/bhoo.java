import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class bhoo
{
  public static String a(String paramString1, String paramString2)
  {
    Object localObject = null;
    try
    {
      paramString2 = a(paramString1.getBytes("UTF-8"), paramString2.getBytes("UTF-8"));
      paramString1 = localObject;
      if (paramString2 != null) {
        paramString1 = bdbi.encodeToString(paramString2, 2);
      }
      return paramString1;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      paramString1.printStackTrace();
    }
    return null;
  }
  
  private static byte[] a(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[24];
    if (arrayOfByte.length > paramArrayOfByte.length)
    {
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte.length);
      return arrayOfByte;
    }
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, arrayOfByte.length);
    return arrayOfByte;
  }
  
  public static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    try
    {
      paramArrayOfByte2 = new SecretKeySpec(a(paramArrayOfByte2), "DESede");
      Cipher localCipher = Cipher.getInstance("DESede");
      localCipher.init(1, paramArrayOfByte2);
      paramArrayOfByte1 = localCipher.doFinal(paramArrayOfByte1);
      return paramArrayOfByte1;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte1)
    {
      paramArrayOfByte1.printStackTrace();
      return null;
    }
    catch (NoSuchPaddingException paramArrayOfByte1)
    {
      for (;;)
      {
        paramArrayOfByte1.printStackTrace();
      }
    }
    catch (Exception paramArrayOfByte1)
    {
      for (;;)
      {
        paramArrayOfByte1.printStackTrace();
      }
    }
  }
  
  public static String b(String paramString1, String paramString2)
  {
    try
    {
      paramString2 = paramString2.getBytes("UTF-8");
      paramString1 = b(bdbi.decode(paramString1, 0), paramString2);
      if (paramString1 != null)
      {
        paramString1 = new String(paramString1, "UTF-8");
        return paramString1;
      }
      return null;
    }
    catch (UnsupportedEncodingException paramString1)
    {
      paramString1.printStackTrace();
      return null;
    }
    catch (IllegalArgumentException paramString1)
    {
      for (;;)
      {
        paramString1.printStackTrace();
      }
    }
  }
  
  public static byte[] b(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    try
    {
      paramArrayOfByte2 = new SecretKeySpec(a(paramArrayOfByte2), "DESede");
      Cipher localCipher = Cipher.getInstance("DESede");
      localCipher.init(2, paramArrayOfByte2);
      paramArrayOfByte1 = localCipher.doFinal(paramArrayOfByte1);
      return paramArrayOfByte1;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte1)
    {
      paramArrayOfByte1.printStackTrace();
      return null;
    }
    catch (NoSuchPaddingException paramArrayOfByte1)
    {
      for (;;)
      {
        paramArrayOfByte1.printStackTrace();
      }
    }
    catch (Exception paramArrayOfByte1)
    {
      for (;;)
      {
        paramArrayOfByte1.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhoo
 * JD-Core Version:    0.7.0.1
 */
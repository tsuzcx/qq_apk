import android.util.Base64;
import com.tencent.mobileqq.haoliyou.orion.XorCipherException;

public class asrb
{
  static final String a = 'W' + 't' + 'R' + 'x' + 'K' + 'b' + 'L' + 'k';
  
  public static String a(String paramString)
  {
    return a(paramString, a);
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      throw new XorCipherException("null input");
    }
    try
    {
      paramString1 = new String(Base64.encode(a(paramString1.getBytes(), paramString2.getBytes()), 0));
      return paramString1;
    }
    catch (Throwable paramString1)
    {
      throw new XorCipherException(paramString1);
    }
  }
  
  private static byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte = new byte[paramArrayOfByte1.length];
    int i = 0;
    while (i < paramArrayOfByte1.length)
    {
      arrayOfByte[i] = ((byte)(paramArrayOfByte1[i] ^ paramArrayOfByte2[(i % paramArrayOfByte2.length)]));
      i += 1;
    }
    return arrayOfByte;
  }
  
  public static String b(String paramString)
  {
    return b(paramString, a);
  }
  
  public static String b(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      throw new XorCipherException("null input");
    }
    try
    {
      paramString1 = new String(a(Base64.decode(paramString1, 0), paramString2.getBytes()));
      return paramString1;
    }
    catch (Throwable paramString1)
    {
      throw new XorCipherException(paramString1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asrb
 * JD-Core Version:    0.7.0.1
 */
package c.t.m.g;

import android.util.Base64;

public final class cw
{
  private static final byte[] a = new byte[0];
  
  private static byte[] a(int paramInt)
  {
    byte[] arrayOfByte = new byte[2];
    int j = 0;
    int i = paramInt;
    paramInt = j;
    while (paramInt < 2)
    {
      arrayOfByte[paramInt] = Integer.valueOf(i & 0xFF).byteValue();
      i >>= 8;
      paramInt += 1;
    }
    return arrayOfByte;
  }
  
  public static byte[] a(String paramString)
  {
    try
    {
      paramString = a(paramString.getBytes("UTF-8"), 4);
      return paramString;
    }
    catch (Throwable paramString)
    {
      co.b(paramString.toString());
    }
    return a;
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte = co.a(paramArrayOfByte);
    paramArrayOfByte = arrayOfByte;
    if (paramInt != 1)
    {
      paramArrayOfByte = arrayOfByte;
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          break label49;
        }
        paramArrayOfByte = dr.a(arrayOfByte, "0PEq^X$sjtWqEqa2$dg4TG2PT^4dFEep");
      }
    }
    if (co.b(paramArrayOfByte))
    {
      co.b("encrypt failed");
      paramArrayOfByte = a;
      label49:
      do
      {
        return paramArrayOfByte;
        if (paramInt != 4) {
          break label87;
        }
        paramArrayOfByte = dr.a(arrayOfByte, "0PEq^X$sjtWqEqa2$dg4TG2PT^4dFEep");
        if (co.b(paramArrayOfByte)) {
          break;
        }
        arrayOfByte = Base64.encode(paramArrayOfByte, 2);
        paramArrayOfByte = arrayOfByte;
      } while (!co.b(arrayOfByte));
      return a;
      label87:
      return a;
    }
    arrayOfByte = new byte[paramArrayOfByte.length + 2];
    System.arraycopy(a(paramArrayOfByte.length), 0, arrayOfByte, 0, 2);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 2, paramArrayOfByte.length);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     c.t.m.g.cw
 * JD-Core Version:    0.7.0.1
 */
public class bkin
{
  public static final byte[] a;
  private static final char[] a;
  public static final byte[] b;
  public static final byte[] c;
  public static final byte[] d;
  
  static
  {
    jdField_a_of_type_ArrayOfByte = b("00A40400");
    b = b("6A82");
    c = b("9000");
    d = b("0000");
    jdField_a_of_type_ArrayOfChar = "0123456789ABCDEF".toCharArray();
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    char[] arrayOfChar = new char[paramArrayOfByte.length * 2];
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      int j = paramArrayOfByte[i] & 0xFF;
      arrayOfChar[(i * 2)] = jdField_a_of_type_ArrayOfChar[(j >>> 4)];
      arrayOfChar[(i * 2 + 1)] = jdField_a_of_type_ArrayOfChar[(j & 0xF)];
      i += 1;
    }
    return new String(arrayOfChar);
  }
  
  public static byte[] a(String paramString)
  {
    byte[] arrayOfByte = b(String.format("%02X", new Object[] { Integer.valueOf(paramString.length() / 2) }));
    paramString = b(paramString);
    return a(jdField_a_of_type_ArrayOfByte, new byte[][] { arrayOfByte, paramString });
  }
  
  private static byte[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt1 > paramInt2) {
      throw new IllegalArgumentException();
    }
    int i = paramArrayOfByte.length;
    if ((paramInt1 < 0) || (paramInt1 > i)) {
      throw new ArrayIndexOutOfBoundsException();
    }
    paramInt2 -= paramInt1;
    i = Math.min(paramInt2, i - paramInt1);
    byte[] arrayOfByte = new byte[paramInt2];
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, i);
    return arrayOfByte;
  }
  
  public static byte[] a(byte[] paramArrayOfByte, byte[]... paramVarArgs)
  {
    int j = paramArrayOfByte.length;
    int k = paramVarArgs.length;
    int i = 0;
    while (i < k)
    {
      j += paramVarArgs[i].length;
      i += 1;
    }
    byte[] arrayOfByte = a(paramArrayOfByte, 0, j);
    j = paramArrayOfByte.length;
    k = paramVarArgs.length;
    i = 0;
    while (i < k)
    {
      paramArrayOfByte = paramVarArgs[i];
      System.arraycopy(paramArrayOfByte, 0, arrayOfByte, j, paramArrayOfByte.length);
      j += paramArrayOfByte.length;
      i += 1;
    }
    return arrayOfByte;
  }
  
  public static byte[] b(String paramString)
  {
    int j = paramString.length();
    byte[] arrayOfByte = new byte[j / 2];
    int i = 0;
    while (i < j)
    {
      arrayOfByte[(i / 2)] = ((byte)((Character.digit(paramString.charAt(i), 16) << 4) + Character.digit(paramString.charAt(i + 1), 16)));
      i += 2;
    }
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkin
 * JD-Core Version:    0.7.0.1
 */
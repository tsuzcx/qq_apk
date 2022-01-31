public class bdyq
{
  public static final byte[] a;
  private static final char[] a;
  
  static
  {
    jdField_a_of_type_ArrayOfChar = new char[] { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
    jdField_a_of_type_ArrayOfByte = new byte[0];
  }
  
  public static String a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return null;
    }
    arrayOfChar = new char[paramArrayOfByte.length * 2];
    int i = 0;
    try
    {
      while (i < paramArrayOfByte.length)
      {
        int j = paramArrayOfByte[i];
        arrayOfChar[(i * 2 + 1)] = jdField_a_of_type_ArrayOfChar[(j & 0xF)];
        j = (byte)(j >>> 4);
        arrayOfChar[(i * 2 + 0)] = jdField_a_of_type_ArrayOfChar[(j & 0xF)];
        i += 1;
      }
      return new String(arrayOfChar);
    }
    catch (Exception paramArrayOfByte)
    {
      bdnw.a("HexUtil", " === bytes2HexStr error === " + paramArrayOfByte.toString());
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdyq
 * JD-Core Version:    0.7.0.1
 */
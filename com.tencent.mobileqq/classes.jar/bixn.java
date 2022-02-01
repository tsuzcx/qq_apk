import java.io.UnsupportedEncodingException;

public class bixn
{
  static
  {
    if (!bixn.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      jdField_a_of_type_Boolean = bool;
      return;
    }
  }
  
  public static String a(byte[] paramArrayOfByte, int paramInt)
  {
    try
    {
      paramArrayOfByte = new String(b(paramArrayOfByte, paramInt), "US-ASCII");
      return paramArrayOfByte;
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      throw new AssertionError(paramArrayOfByte);
    }
  }
  
  public static byte[] a(String paramString, int paramInt)
  {
    return a(paramString.getBytes(), paramInt);
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    return a(paramArrayOfByte, 0, paramArrayOfByte.length, paramInt);
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    bixp localbixp = new bixp(paramInt3, new byte[paramInt2 * 3 / 4]);
    if (!localbixp.a(paramArrayOfByte, paramInt1, paramInt2, true)) {
      throw new IllegalArgumentException("bad base-64");
    }
    if (localbixp.jdField_a_of_type_Int == localbixp.jdField_a_of_type_ArrayOfByte.length) {
      return localbixp.jdField_a_of_type_ArrayOfByte;
    }
    paramArrayOfByte = new byte[localbixp.jdField_a_of_type_Int];
    System.arraycopy(localbixp.jdField_a_of_type_ArrayOfByte, 0, paramArrayOfByte, 0, localbixp.jdField_a_of_type_Int);
    return paramArrayOfByte;
  }
  
  public static byte[] b(byte[] paramArrayOfByte, int paramInt)
  {
    return b(paramArrayOfByte, 0, paramArrayOfByte.length, paramInt);
  }
  
  public static byte[] b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    bixq localbixq = new bixq(paramInt3, null);
    int i = paramInt2 / 3 * 4;
    int j;
    if (localbixq.jdField_a_of_type_Boolean)
    {
      paramInt3 = i;
      if (paramInt2 % 3 > 0) {
        paramInt3 = i + 4;
      }
      i = paramInt3;
      if (localbixq.b)
      {
        i = paramInt3;
        if (paramInt2 > 0)
        {
          j = (paramInt2 - 1) / 57;
          if (!localbixq.c) {
            break label186;
          }
        }
      }
    }
    label186:
    for (i = 2;; i = 1)
    {
      i = paramInt3 + i * (j + 1);
      localbixq.jdField_a_of_type_ArrayOfByte = new byte[i];
      localbixq.a(paramArrayOfByte, paramInt1, paramInt2, true);
      if ((jdField_a_of_type_Boolean) || (localbixq.jdField_a_of_type_Int == i)) {
        break label192;
      }
      throw new AssertionError();
      paramInt3 = i;
      switch (paramInt2 % 3)
      {
      case 0: 
      default: 
        paramInt3 = i;
        break;
      case 1: 
        paramInt3 = i + 2;
        break;
      case 2: 
        paramInt3 = i + 3;
        break;
      }
    }
    label192:
    return localbixq.jdField_a_of_type_ArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bixn
 * JD-Core Version:    0.7.0.1
 */
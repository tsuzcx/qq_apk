public class bgyj
{
  public static bgyj a;
  private static byte[] jdField_a_of_type_ArrayOfByte = new byte[256];
  private static char[] jdField_a_of_type_ArrayOfChar = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
  
  protected bgyj()
  {
    a();
  }
  
  public static bgyj a()
  {
    if (jdField_a_of_type_Bgyj == null) {}
    try
    {
      jdField_a_of_type_Bgyj = new bgyj();
      return jdField_a_of_type_Bgyj;
    }
    finally {}
  }
  
  public String a(String paramString)
  {
    return a(paramString.getBytes()).toString();
  }
  
  public StringBuffer a(byte[] paramArrayOfByte)
  {
    int k = 0;
    StringBuffer localStringBuffer = new StringBuffer(paramArrayOfByte.length * 2);
    int i = 0;
    int j = 0;
    char c;
    while (k < paramArrayOfByte.length)
    {
      i = i << 8 | paramArrayOfByte[k] & 0xFF;
      j += 8;
      if (j > 5)
      {
        Object localObject = jdField_a_of_type_ArrayOfChar;
        j -= 6;
        c = localObject[(i >> j)];
        if (c == 'i') {
          localObject = "ia";
        }
        for (;;)
        {
          localStringBuffer.append(localObject);
          i &= (1 << j) - 1;
          break;
          if (c == '+') {
            localObject = "ib";
          } else if (c == '/') {
            localObject = "ic";
          } else {
            localObject = Character.valueOf(c);
          }
        }
      }
      k += 1;
    }
    if (j > 0)
    {
      c = jdField_a_of_type_ArrayOfChar[(i << 6 - j)];
      if (c != 'i') {
        break label185;
      }
      paramArrayOfByte = "ia";
    }
    for (;;)
    {
      localStringBuffer.append(paramArrayOfByte);
      return localStringBuffer;
      label185:
      if (c == '+') {
        paramArrayOfByte = "ib";
      } else if (c == '/') {
        paramArrayOfByte = "ic";
      } else {
        paramArrayOfByte = Character.valueOf(c);
      }
    }
  }
  
  protected void a()
  {
    int i = 0;
    while (i < jdField_a_of_type_ArrayOfChar.length)
    {
      jdField_a_of_type_ArrayOfByte[jdField_a_of_type_ArrayOfChar[i]] = ((byte)i);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgyj
 * JD-Core Version:    0.7.0.1
 */
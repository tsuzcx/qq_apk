public class bhvf
{
  private static String a = "3g.qq.com";
  
  public static int a(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    if (paramInt1 < 128)
    {
      paramArrayOfByte[(0 + paramInt2)] = ((byte)paramInt1);
      return 1;
    }
    if (paramInt1 < 2048)
    {
      paramArrayOfByte[(paramInt2 + 0)] = ((byte)(paramInt1 >> 6 & 0x1F | 0xC0));
      paramArrayOfByte[(paramInt2 + 1)] = ((byte)(paramInt1 & 0x3F | 0x80));
      return 2;
    }
    if (paramInt1 < 65536)
    {
      paramArrayOfByte[(paramInt2 + 0)] = ((byte)(paramInt1 >> 12 & 0xF | 0xE0));
      paramArrayOfByte[(paramInt2 + 1)] = ((byte)(paramInt1 >> 6 & 0x3F | 0x80));
      paramArrayOfByte[(paramInt2 + 2)] = ((byte)(paramInt1 & 0x3F | 0x80));
      return 3;
    }
    if (paramInt1 < 2097152)
    {
      paramArrayOfByte[(paramInt2 + 0)] = ((byte)(paramInt1 >> 18 & 0x7 | 0xF0));
      paramArrayOfByte[(paramInt2 + 1)] = ((byte)(paramInt1 >> 12 & 0x3F | 0x80));
      paramArrayOfByte[(paramInt2 + 2)] = ((byte)(paramInt1 >> 6 & 0x3F | 0x80));
      paramArrayOfByte[(paramInt2 + 3)] = ((byte)(paramInt1 & 0x3F | 0x80));
      return 4;
    }
    return 0;
  }
  
  public static String a(String paramString, boolean paramBoolean)
  {
    paramString = paramString.toCharArray();
    byte[] arrayOfByte = new byte[paramString.length * 4];
    int j = 0;
    int k = 0;
    if (j < paramString.length)
    {
      int m;
      int i;
      if ((paramString[j] == '%') && (j + 2 < paramString.length))
      {
        m = 1;
        int n = 0;
        if (m < 3)
        {
          if ((paramString[(j + m)] <= '9') && (paramString[(j + m)] >= '0')) {
            i = n * 16 + (paramString[(j + m)] - '0');
          }
          for (;;)
          {
            m += 1;
            n = i;
            break;
            if ((paramString[(j + m)] <= 'F') && (paramString[(j + m)] >= 'A'))
            {
              i = n * 16 + (paramString[(j + m)] - 'A' + 10);
            }
            else
            {
              i = n;
              if (paramString[(j + m)] <= 'f')
              {
                i = n;
                if (paramString[(j + m)] >= 'a') {
                  i = n * 16 + (paramString[(j + m)] - 'a' + 10);
                }
              }
            }
          }
        }
        arrayOfByte[k] = ((byte)n);
        j += 2;
        i = k + 1;
      }
      for (;;)
      {
        j += 1;
        k = i;
        break;
        if (paramBoolean)
        {
          i = k + a(paramString[j], arrayOfByte, k);
        }
        else
        {
          m = k + 1;
          arrayOfByte[k] = ((byte)(paramString[j] >> '\b'));
          i = m + 1;
          arrayOfByte[m] = ((byte)paramString[j]);
        }
      }
    }
    if (paramBoolean) {}
    try
    {
      paramString = bhvd.b(arrayOfByte, 0, k);
      return paramString;
    }
    catch (Exception paramString) {}
    return new String(arrayOfByte, 0, k);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhvf
 * JD-Core Version:    0.7.0.1
 */
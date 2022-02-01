package com.android.dx.util;

public final class HexParser
{
  public static byte[] parse(String paramString)
  {
    int i1 = paramString.length();
    byte[] arrayOfByte = new byte[i1 / 2];
    int i = 0;
    int m;
    for (int j = 0; j < i1; j = m + 1)
    {
      int k = paramString.indexOf('\n', j);
      m = k;
      if (k < 0) {
        m = i1;
      }
      k = paramString.indexOf('#', j);
      String str1;
      String str2;
      label118:
      int n;
      label133:
      char c;
      if ((k >= 0) && (k < m))
      {
        str1 = paramString.substring(j, k);
        j = str1.indexOf(':');
        str2 = str1;
        if (j != -1)
        {
          k = str1.indexOf('"');
          if ((k == -1) || (k >= j)) {
            break label181;
          }
          str2 = str1;
        }
        int i3 = str2.length();
        n = 0;
        j = 0;
        k = -1;
        if (n >= i3) {
          break label392;
        }
        c = str2.charAt(n);
        if (j == 0) {
          break label255;
        }
        if (c != '"') {
          break label242;
        }
        j = 0;
      }
      for (;;)
      {
        n += 1;
        break label133;
        str1 = paramString.substring(j, m);
        break;
        label181:
        String str3 = str1.substring(0, j).trim();
        str2 = str1.substring(j + 1);
        if (Integer.parseInt(str3, 16) == i) {
          break label118;
        }
        throw new RuntimeException("bogus offset marker: " + str3);
        label242:
        arrayOfByte[i] = ((byte)c);
        i += 1;
        continue;
        label255:
        if (c > ' ') {
          if (c == '"')
          {
            if (k != -1) {
              throw new RuntimeException("spare digit around offset " + Hex.u4(i));
            }
            j = 1;
          }
          else
          {
            int i2 = Character.digit(c, 16);
            if (i2 == -1) {
              throw new RuntimeException("bogus digit character: \"" + c + "\"");
            }
            if (k == -1)
            {
              k = i2;
            }
            else
            {
              arrayOfByte[i] = ((byte)(k << 4 | i2));
              i += 1;
              k = -1;
            }
          }
        }
      }
      label392:
      if (k != -1) {
        throw new RuntimeException("spare digit around offset " + Hex.u4(i));
      }
      if (j != 0) {
        throw new RuntimeException("unterminated quote around offset " + Hex.u4(i));
      }
    }
    if (i < arrayOfByte.length)
    {
      paramString = new byte[i];
      System.arraycopy(arrayOfByte, 0, paramString, 0, i);
      return paramString;
    }
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.dx.util.HexParser
 * JD-Core Version:    0.7.0.1
 */
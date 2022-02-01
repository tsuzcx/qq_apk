package com.tencent.mm.plugin.appbrand.jsapi.nfc.hce;

public class c
{
  public static String a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int i = 0;
      while (i < paramArrayOfByte.length)
      {
        int n = paramArrayOfByte[i];
        int m = n & 0xF;
        int k = 48;
        int j;
        if (m < 10) {
          j = 48;
        } else {
          j = 55;
        }
        n = (n & 0xF0) >> 4;
        if (n >= 10) {
          k = 55;
        }
        localStringBuilder.append(n + k);
        localStringBuilder.append(m + j);
        i += 1;
      }
      return localStringBuilder.toString();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.nfc.hce.c
 * JD-Core Version:    0.7.0.1
 */
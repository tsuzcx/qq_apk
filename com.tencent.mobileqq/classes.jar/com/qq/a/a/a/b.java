package com.qq.a.a.a;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;

class b
{
  ArrayList<Byte> a = new ArrayList();
  
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    try
    {
      String[] arrayOfString = new String[4];
      arrayOfString[0] = paramString1;
      arrayOfString[1] = paramString2;
      arrayOfString[2] = paramString3;
      arrayOfString[3] = paramString4;
      paramString1 = new StringBuffer();
      Arrays.sort(arrayOfString);
      int i = 0;
      while (i < 4)
      {
        paramString1.append(arrayOfString[i]);
        i += 1;
      }
      paramString1 = paramString1.toString();
      paramString2 = MessageDigest.getInstance("SHA-1");
      paramString2.update(paramString1.getBytes());
      paramString1 = paramString2.digest();
      paramString2 = new StringBuffer(paramString1.length * 2 + paramString1.length / 2);
      i = 0;
      while (i < paramString1.length)
      {
        paramString3 = Integer.toHexString(paramString1[i] & 0xFF);
        if (paramString3.length() < 2) {
          paramString2.append(0);
        }
        paramString2.append(paramString3);
        i += 1;
      }
      paramString1 = paramString2.toString();
      return paramString1;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      paramString1 = new a(-40003);
    }
    for (;;)
    {
      throw paramString1;
    }
  }
  
  public final b a(byte[] paramArrayOfByte)
  {
    int j = paramArrayOfByte.length;
    int i = 0;
    while (i < j)
    {
      byte b = paramArrayOfByte[i];
      this.a.add(Byte.valueOf(b));
      i += 1;
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qq.a.a.a.b
 * JD-Core Version:    0.7.0.1
 */
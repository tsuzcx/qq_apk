package com.tencent.luggage.wxa.qu;

import java.io.UnsupportedEncodingException;

public final class b
{
  private byte[] a;
  
  private b() {}
  
  public b(byte[] paramArrayOfByte)
  {
    this(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.a = new byte[paramInt2];
    System.arraycopy(paramArrayOfByte, paramInt1, this.a, 0, paramInt2);
  }
  
  public static b a(String paramString)
  {
    try
    {
      paramString = a(paramString, "UTF-8");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new RuntimeException("UTF-8 not supported?", paramString);
    }
  }
  
  public static b a(String paramString1, String paramString2)
  {
    b localb = new b();
    localb.a = paramString1.getBytes(paramString2);
    return localb;
  }
  
  public static b a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      paramArrayOfByte = new byte[0];
    }
    return new b(paramArrayOfByte);
  }
  
  public static b a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return new b(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public int a()
  {
    return this.a.length;
  }
  
  public String b(String paramString)
  {
    return new String(this.a, paramString);
  }
  
  public byte[] b()
  {
    byte[] arrayOfByte1 = this.a;
    int i = arrayOfByte1.length;
    byte[] arrayOfByte2 = new byte[i];
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, i);
    return arrayOfByte2;
  }
  
  public byte[] c()
  {
    return this.a;
  }
  
  public String d()
  {
    int i = 0;
    try
    {
      for (;;)
      {
        if ((i >= this.a.length) || (this.a[i] == 0))
        {
          localObject = new String(this.a, 0, i, "UTF-8");
          return localObject;
        }
        i += 1;
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      Object localObject;
      label48:
      break label48;
    }
    localObject = new RuntimeException("UTF-8 not supported?");
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qu.b
 * JD-Core Version:    0.7.0.1
 */
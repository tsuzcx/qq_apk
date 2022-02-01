package com.tencent.luggage.wxa.qu;

import com.tencent.luggage.wxa.sy.b;

public class a
{
  protected static b p = ;
  
  public static int a(com.tencent.luggage.wxa.sx.a parama)
  {
    return parama.a();
  }
  
  protected int a(int paramInt, Object... paramVarArgs)
  {
    throw new Error("Cannot use this method");
  }
  
  public a a(byte[] paramArrayOfByte)
  {
    a(2, new Object[] { paramArrayOfByte });
    return this;
  }
  
  public void a(com.tencent.luggage.wxa.tc.a parama)
  {
    a(0, new Object[] { parama });
  }
  
  public boolean a(com.tencent.luggage.wxa.sx.a parama, a parama1, int paramInt)
  {
    return a(3, new Object[] { parama, parama1, Integer.valueOf(paramInt) }) == 0;
  }
  
  public byte[] b()
  {
    c();
    byte[] arrayOfByte = new byte[d()];
    com.tencent.luggage.wxa.tc.a locala = new com.tencent.luggage.wxa.tc.a(arrayOfByte);
    a(locala);
    locala.a();
    return arrayOfByte;
  }
  
  protected a c()
  {
    return this;
  }
  
  public int d()
  {
    try
    {
      int i = a(1, new Object[0]);
      return i;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qu.a
 * JD-Core Version:    0.7.0.1
 */
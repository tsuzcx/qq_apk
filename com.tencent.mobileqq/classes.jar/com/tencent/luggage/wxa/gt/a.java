package com.tencent.luggage.wxa.gt;

import com.tencent.luggage.wxa.gw.b;

public class a
{
  public static boolean a(int paramInt)
  {
    if (paramInt <= 0)
    {
      b.a("MicroMsg.Mix.AudioMixConfig", "sampleRate is illegal! %d", new Object[] { Integer.valueOf(paramInt) });
      return false;
    }
    return paramInt == 44100;
  }
  
  public static boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (!a(paramInt1)) {
      return false;
    }
    if (!b(paramInt2)) {
      return false;
    }
    return c(paramInt3);
  }
  
  public static boolean b(int paramInt)
  {
    if (paramInt <= 0)
    {
      b.a("MicroMsg.Mix.AudioMixConfig", "channels is illegal, %d", new Object[] { Integer.valueOf(paramInt) });
      return false;
    }
    return paramInt == 2;
  }
  
  public static boolean c(int paramInt)
  {
    boolean bool = false;
    if (paramInt <= 0) {
      b.a("MicroMsg.Mix.AudioMixConfig", "encode is illegal, %d", new Object[] { Integer.valueOf(paramInt) });
    }
    if (paramInt == 2) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean d(int paramInt)
  {
    return (paramInt == 1) || (paramInt == 2) || (paramInt == 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gt.a
 * JD-Core Version:    0.7.0.1
 */
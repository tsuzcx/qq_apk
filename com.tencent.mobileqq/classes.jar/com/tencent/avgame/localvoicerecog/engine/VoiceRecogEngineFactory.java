package com.tencent.avgame.localvoicerecog.engine;

import com.tencent.avgame.localvoicerecog.IVoiceRecogEngineType;

public class VoiceRecogEngineFactory
  implements IVoiceRecogEngineType
{
  private static int a = 2;
  private static boolean b = false;
  
  public static int a()
  {
    return a;
  }
  
  public static void a(int paramInt)
  {
    a = paramInt;
  }
  
  public static void a(boolean paramBoolean)
  {
    b = paramBoolean;
  }
  
  public static IVoiceRecogEngine b()
  {
    int i = a;
    if (i == 2) {
      return WXVoiceRecogEngine.a();
    }
    if (i == 3) {
      return AILabVoiceRecogEngine.a();
    }
    return WXVoiceRecogEngine.a();
  }
  
  public static boolean c()
  {
    return b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.localvoicerecog.engine.VoiceRecogEngineFactory
 * JD-Core Version:    0.7.0.1
 */
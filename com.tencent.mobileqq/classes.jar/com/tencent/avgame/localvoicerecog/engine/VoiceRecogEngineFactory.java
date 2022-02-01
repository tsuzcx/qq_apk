package com.tencent.avgame.localvoicerecog.engine;

import com.tencent.avgame.localvoicerecog.IVoiceRecogEngineType;

public class VoiceRecogEngineFactory
  implements IVoiceRecogEngineType
{
  private static int jdField_a_of_type_Int = 2;
  private static boolean jdField_a_of_type_Boolean = false;
  
  public static int a()
  {
    return jdField_a_of_type_Int;
  }
  
  public static IVoiceRecogEngine a()
  {
    int i = jdField_a_of_type_Int;
    if (i == 2) {
      return WXVoiceRecogEngine.a();
    }
    if (i == 3) {
      return AILabVoiceRecogEngine.a();
    }
    return WXVoiceRecogEngine.a();
  }
  
  public static void a(int paramInt)
  {
    jdField_a_of_type_Int = paramInt;
  }
  
  public static void a(boolean paramBoolean)
  {
    jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public static boolean a()
  {
    return jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.localvoicerecog.engine.VoiceRecogEngineFactory
 * JD-Core Version:    0.7.0.1
 */
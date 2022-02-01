package com.tencent.avgame.localvoicerecog.engine;

public class VoiceRecogEngineFactory
{
  private static VoiceRecogEngineFactory.VoiceRecogEngineType jdField_a_of_type_ComTencentAvgameLocalvoicerecogEngineVoiceRecogEngineFactory$VoiceRecogEngineType = VoiceRecogEngineFactory.VoiceRecogEngineType.WX_ENGINE_TYPE;
  private static boolean jdField_a_of_type_Boolean = false;
  
  public static IVoiceRecogEngine a()
  {
    if (jdField_a_of_type_ComTencentAvgameLocalvoicerecogEngineVoiceRecogEngineFactory$VoiceRecogEngineType == VoiceRecogEngineFactory.VoiceRecogEngineType.WX_ENGINE_TYPE) {
      return WXVoiceRecogEngine.a();
    }
    if (jdField_a_of_type_ComTencentAvgameLocalvoicerecogEngineVoiceRecogEngineFactory$VoiceRecogEngineType == VoiceRecogEngineFactory.VoiceRecogEngineType.AILAB_ENGINE_TYPE) {
      return AILabVoiceRecogEngine.a();
    }
    return WXVoiceRecogEngine.a();
  }
  
  public static VoiceRecogEngineFactory.VoiceRecogEngineType a()
  {
    return jdField_a_of_type_ComTencentAvgameLocalvoicerecogEngineVoiceRecogEngineFactory$VoiceRecogEngineType;
  }
  
  public static void a(VoiceRecogEngineFactory.VoiceRecogEngineType paramVoiceRecogEngineType)
  {
    jdField_a_of_type_ComTencentAvgameLocalvoicerecogEngineVoiceRecogEngineFactory$VoiceRecogEngineType = paramVoiceRecogEngineType;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.localvoicerecog.engine.VoiceRecogEngineFactory
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.avgame.localvoicerecog.api.impl;

import com.tencent.avgame.localvoicerecog.api.IVoiceRecogEngineFactory;
import com.tencent.avgame.localvoicerecog.engine.VoiceRecogEngineFactory;

public class VoiceRecogEngineFactoryImpl
  implements IVoiceRecogEngineFactory
{
  public int getVoiceRecogEngineType()
  {
    return VoiceRecogEngineFactory.a();
  }
  
  public boolean isEnableAINS()
  {
    return VoiceRecogEngineFactory.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.localvoicerecog.api.impl.VoiceRecogEngineFactoryImpl
 * JD-Core Version:    0.7.0.1
 */
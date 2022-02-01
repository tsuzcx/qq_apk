package com.tencent.avgame.localvoicerecog.api.impl;

import com.tencent.avgame.localvoicerecog.api.IAILabVoiceRecogEngine;
import com.tencent.avgame.localvoicerecog.engine.AILabVoiceRecogEngine;

public class AILabVoiceRecogEngineImpl
  implements IAILabVoiceRecogEngine
{
  public static final String TAG = "AILabVoiceRecogEngineImpl";
  
  public float getCurSceneWordScore()
  {
    return AILabVoiceRecogEngine.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.localvoicerecog.api.impl.AILabVoiceRecogEngineImpl
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.avcore.engine.common;

public abstract interface IAVEngineCommon
{
  public abstract void enableLocalSpeechRecognizeModel(boolean paramBoolean);
  
  public abstract int registerAudioDataCallback(int paramInt, boolean paramBoolean);
  
  public abstract int setAudioDataFormat(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract int unregisterAudioDataCallback(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avcore.engine.common.IAVEngineCommon
 * JD-Core Version:    0.7.0.1
 */
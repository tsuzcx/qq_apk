package com.tencent.aelight.camera.ae.camera.core;

import com.tencent.aelight.camera.ae.camera.filter.AEFilterProcessTex;

public class AEFilterManagerHolder
{
  private static AEFilterProcessTex instance;
  
  public static AEFilterProcessTex getAEFilterManager()
  {
    return instance;
  }
  
  public static void setFilterProcess(AEFilterProcessTex paramAEFilterProcessTex)
  {
    instance = paramAEFilterProcessTex;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.core.AEFilterManagerHolder
 * JD-Core Version:    0.7.0.1
 */
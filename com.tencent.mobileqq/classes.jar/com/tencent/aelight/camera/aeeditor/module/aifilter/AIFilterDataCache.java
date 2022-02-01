package com.tencent.aelight.camera.aeeditor.module.aifilter;

import java.util.HashMap;

public class AIFilterDataCache
{
  private HashMap<String, AIFilterResult> a = new HashMap();
  
  public AIFilterResult a(String paramString)
  {
    return (AIFilterResult)this.a.get(paramString);
  }
  
  public void a(String paramString, AIFilterResult paramAIFilterResult)
  {
    this.a.put(paramString, paramAIFilterResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.aifilter.AIFilterDataCache
 * JD-Core Version:    0.7.0.1
 */
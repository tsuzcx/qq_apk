package com.tencent.aekit.plugin.core;

import java.util.HashMap;

public abstract interface IAIDataClassifier
{
  public abstract int classifyData2Type(AIAttr paramAIAttr);
  
  public abstract HashMap<String, Integer> getClassifierTypeMap();
  
  public abstract String getModuleName();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.aekit.plugin.core.IAIDataClassifier
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.auto.engine.lib;

import java.util.HashMap;

public abstract interface IASEngineDelegate
{
  public abstract boolean enter(String paramString1, String paramString2, HashMap<String, String> paramHashMap, HashMap<String, byte[]> paramHashMap1);
  
  public abstract String getPluginVerSion(String paramString);
  
  public abstract boolean isOnThirdTab(String paramString);
  
  public abstract boolean setForceNative(String paramString, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.auto.engine.lib.IASEngineDelegate
 * JD-Core Version:    0.7.0.1
 */
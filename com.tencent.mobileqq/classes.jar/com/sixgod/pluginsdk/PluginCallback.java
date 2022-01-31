package com.sixgod.pluginsdk;

import java.io.Serializable;

public abstract interface PluginCallback
  extends Serializable
{
  public abstract void callAppCreateFailed(String paramString1, String paramString2, int paramInt, String paramString3);
  
  public abstract void callAppCreateSucc(String paramString1, String paramString2);
  
  public abstract void loadPluginFailed(String paramString1, String paramString2, int paramInt, String paramString3);
  
  public abstract void loadPluginSucc(String paramString1, String paramString2, String paramString3);
  
  public abstract void startMainActivityFailed(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4);
  
  public abstract void startMainActivitySucc(String paramString1, String paramString2, String paramString3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.sixgod.pluginsdk.PluginCallback
 * JD-Core Version:    0.7.0.1
 */
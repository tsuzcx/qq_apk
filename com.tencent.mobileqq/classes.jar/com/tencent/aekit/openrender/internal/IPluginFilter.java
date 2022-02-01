package com.tencent.aekit.openrender.internal;

public abstract interface IPluginFilter
  extends AEFilterI
{
  public static final String AI_ATTRIBUTE_DATA = "AI_ATTRIBUTE_DATA";
  
  public abstract void apply();
  
  public abstract void clear();
  
  public abstract void reset();
  
  public abstract void updateParams(String paramString, Object paramObject);
  
  public abstract void updateVideoSize(int paramInt1, int paramInt2, double paramDouble);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aekit.openrender.internal.IPluginFilter
 * JD-Core Version:    0.7.0.1
 */
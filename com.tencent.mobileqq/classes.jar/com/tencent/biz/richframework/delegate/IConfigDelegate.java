package com.tencent.biz.richframework.delegate;

public abstract interface IConfigDelegate
{
  public abstract Boolean getConfigValue(String paramString1, String paramString2, Boolean paramBoolean);
  
  public abstract Float getConfigValue(String paramString1, String paramString2, Float paramFloat);
  
  public abstract Integer getConfigValue(String paramString1, String paramString2, Integer paramInteger);
  
  public abstract Long getConfigValue(String paramString1, String paramString2, Long paramLong);
  
  public abstract String getConfigValue(String paramString1, String paramString2);
  
  public abstract String getConfigValue(String paramString1, String paramString2, String paramString3);
  
  public abstract void updateOneConfig(String paramString1, String paramString2, String paramString3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.delegate.IConfigDelegate
 * JD-Core Version:    0.7.0.1
 */
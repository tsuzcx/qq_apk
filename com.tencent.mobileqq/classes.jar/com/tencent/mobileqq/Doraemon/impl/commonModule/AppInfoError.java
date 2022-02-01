package com.tencent.mobileqq.Doraemon.impl.commonModule;

public class AppInfoError
  extends Error
{
  public int type;
  
  public AppInfoError(int paramInt, String paramString)
  {
    super(paramString);
    this.type = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.impl.commonModule.AppInfoError
 * JD-Core Version:    0.7.0.1
 */
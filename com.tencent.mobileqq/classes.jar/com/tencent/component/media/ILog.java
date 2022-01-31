package com.tencent.component.media;

public abstract interface ILog
{
  public static final boolean isDebug = false;
  
  public abstract void d(String paramString, Object... paramVarArgs);
  
  public abstract void e(String paramString, Object... paramVarArgs);
  
  public abstract void i(String paramString, Object... paramVarArgs);
  
  public abstract void w(String paramString, Object... paramVarArgs);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.component.media.ILog
 * JD-Core Version:    0.7.0.1
 */
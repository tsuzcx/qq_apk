package com.tencent.biz.qcircleshadow.lib.delegate;

public abstract interface ILogDelegate
{
  public abstract void d(String paramString1, int paramInt, String paramString2);
  
  public abstract void d(String paramString, int paramInt, Object... paramVarArgs);
  
  public abstract void e(String paramString1, int paramInt, String paramString2);
  
  public abstract void e(String paramString1, int paramInt, String paramString2, Throwable paramThrowable);
  
  public abstract void e(String paramString, int paramInt, Object... paramVarArgs);
  
  public abstract int getCLRValue();
  
  public abstract int getDEVValue();
  
  public abstract int getUSRValue();
  
  public abstract void i(String paramString1, int paramInt, String paramString2);
  
  public abstract boolean isColorLevel();
  
  public abstract boolean isDevelopLevel();
  
  public abstract void w(String paramString1, int paramInt, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qcircleshadow.lib.delegate.ILogDelegate
 * JD-Core Version:    0.7.0.1
 */
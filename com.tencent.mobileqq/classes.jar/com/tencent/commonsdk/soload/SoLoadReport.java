package com.tencent.commonsdk.soload;

public abstract interface SoLoadReport
{
  public abstract void report(int paramInt, String paramString, long paramLong);
  
  public abstract void reportThrowable(Throwable paramThrowable, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.commonsdk.soload.SoLoadReport
 * JD-Core Version:    0.7.0.1
 */
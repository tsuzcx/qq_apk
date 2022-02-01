package com.tencent.biz.richframework.delegate;

public abstract interface IThreadManagerDelegate
{
  public abstract void execute(Runnable paramRunnable, int paramInt);
  
  public abstract int getDBType();
  
  public abstract int getFileType();
  
  public abstract int getNetWorkType();
  
  public abstract int getNormalType();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.richframework.delegate.IThreadManagerDelegate
 * JD-Core Version:    0.7.0.1
 */
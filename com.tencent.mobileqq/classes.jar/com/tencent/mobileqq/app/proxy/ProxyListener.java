package com.tencent.mobileqq.app.proxy;

public abstract interface ProxyListener
{
  public abstract void onDeleteFinish(String paramString, int paramInt);
  
  public abstract void onInsertFinish(String paramString);
  
  public abstract void onUpdateFinish(String paramString, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.ProxyListener
 * JD-Core Version:    0.7.0.1
 */
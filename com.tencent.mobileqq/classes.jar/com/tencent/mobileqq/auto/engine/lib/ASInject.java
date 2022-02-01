package com.tencent.mobileqq.auto.engine.lib;

public class ASInject
{
  private static ASInject sInstance;
  private IASEngineDelegate mASEngineDelegate;
  private IBackEventListener mBackEventListener;
  private IToastDelegate mToastDelegate;
  
  public static ASInject g()
  {
    try
    {
      if (sInstance == null) {
        sInstance = new ASInject();
      }
      ASInject localASInject = sInstance;
      return localASInject;
    }
    finally {}
  }
  
  public IASEngineDelegate getAsEngineDelegate()
  {
    return this.mASEngineDelegate;
  }
  
  public IBackEventListener getOnBackEventListener()
  {
    return this.mBackEventListener;
  }
  
  public IToastDelegate getToastDelegate()
  {
    return this.mToastDelegate;
  }
  
  public void setAsEngineDelegate(IASEngineDelegate paramIASEngineDelegate)
  {
    this.mASEngineDelegate = paramIASEngineDelegate;
  }
  
  public ASInject setBackEventListener(IBackEventListener paramIBackEventListener)
  {
    this.mBackEventListener = paramIBackEventListener;
    return this;
  }
  
  public ASInject setToastDelegate(IToastDelegate paramIToastDelegate)
  {
    if (this.mToastDelegate != null) {
      return this;
    }
    this.mToastDelegate = paramIToastDelegate;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.auto.engine.lib.ASInject
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.apollo.aioChannel;

public abstract interface IRenderRunner
{
  public abstract void exeJsOnEngine(String paramString);
  
  public abstract long getRenderThreadId();
  
  public abstract long getRuntimeState();
  
  public abstract boolean isJsRuntime();
  
  public abstract void runRenderTask(Runnable paramRunnable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aioChannel.IRenderRunner
 * JD-Core Version:    0.7.0.1
 */
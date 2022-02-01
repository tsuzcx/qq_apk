package com.tencent.mobileqq.apollo.render;

public abstract interface IRenderRunner
{
  public abstract long getLuaState();
  
  public abstract long getRenderThreadId();
  
  public abstract boolean isJsRuntime();
  
  public abstract void runRenderTask(IApolloRunnableTask paramIApolloRunnableTask);
  
  public abstract void runRenderTask(String paramString, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.render.IRenderRunner
 * JD-Core Version:    0.7.0.1
 */
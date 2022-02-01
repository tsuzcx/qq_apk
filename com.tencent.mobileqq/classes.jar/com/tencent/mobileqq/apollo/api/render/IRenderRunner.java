package com.tencent.mobileqq.apollo.api.render;

import com.tencent.mobileqq.apollo.IApolloRunnableTask;

public abstract interface IRenderRunner
{
  public abstract void exeJsOnEngine(String paramString);
  
  public abstract long getRenderThreadId();
  
  public abstract long getRuntimeState();
  
  public abstract boolean isJsRuntime();
  
  public abstract void runRenderTask(IApolloRunnableTask paramIApolloRunnableTask);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.render.IRenderRunner
 * JD-Core Version:    0.7.0.1
 */
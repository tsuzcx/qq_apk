package com.tencent.mobileqq.apollo;

import com.tencent.mobileqq.apollo.api.render.IRenderRunner;

public abstract interface IApolloRenderView
  extends IRenderRunner
{
  public abstract void bulkApolloBarrages(String paramString1, String paramString2, boolean paramBoolean);
  
  public abstract int getInitHeight();
  
  public abstract long getLuaState();
  
  public abstract int getRenderHeight();
  
  public abstract ApolloRenderInterfaceImpl getRenderImpl();
  
  public abstract int getRenderWidth();
  
  public abstract ApolloRenderDriver getWorker();
  
  public abstract void removeAllApolloBarrages(boolean paramBoolean);
  
  public abstract void setBubbleType(int paramInt);
  
  public abstract void setVisibility(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.IApolloRenderView
 * JD-Core Version:    0.7.0.1
 */
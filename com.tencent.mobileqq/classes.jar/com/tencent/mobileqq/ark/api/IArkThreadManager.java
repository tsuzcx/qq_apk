package com.tencent.mobileqq.ark.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IArkThreadManager
  extends QRouteApi
{
  public abstract void postToAppThread(String paramString, Runnable paramRunnable);
  
  public abstract void postToAppThreadDelay(String paramString, Runnable paramRunnable, int paramInt);
  
  public abstract void postToLogicThread(Runnable paramRunnable);
  
  public abstract void postToLogicThreadDelay(Runnable paramRunnable, int paramInt);
  
  public abstract void postToMainThread(Runnable paramRunnable);
  
  public abstract void postToMainThreadDelay(Runnable paramRunnable, int paramInt);
  
  public abstract void sendToAppThread(String paramString, Runnable paramRunnable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.IArkThreadManager
 * JD-Core Version:    0.7.0.1
 */
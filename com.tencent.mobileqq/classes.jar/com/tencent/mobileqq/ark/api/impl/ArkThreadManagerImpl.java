package com.tencent.mobileqq.ark.api.impl;

import com.tencent.ark.ArkDispatchTask;
import com.tencent.mobileqq.ark.api.IArkThreadManager;
import com.tencent.mobileqq.ark.base.ArkLogicThread;

public class ArkThreadManagerImpl
  implements IArkThreadManager
{
  public void postToAppThread(String paramString, Runnable paramRunnable)
  {
    ArkLogicThread.a().post(paramString, paramRunnable);
  }
  
  public void postToAppThreadDelay(String paramString, Runnable paramRunnable, int paramInt)
  {
    ArkLogicThread.a().postDelayed(paramString, paramRunnable, paramInt);
  }
  
  public void postToLogicThread(Runnable paramRunnable)
  {
    ArkLogicThread.a(paramRunnable);
  }
  
  public void postToLogicThreadDelay(Runnable paramRunnable, int paramInt)
  {
    ArkLogicThread.a(paramRunnable, paramInt);
  }
  
  public void postToMainThread(Runnable paramRunnable)
  {
    ArkLogicThread.a().postToMainThread(paramRunnable);
  }
  
  public void postToMainThreadDelay(Runnable paramRunnable, int paramInt)
  {
    ArkLogicThread.a().postToMainThreadDelayed(paramRunnable, paramInt);
  }
  
  public void sendToAppThread(String paramString, Runnable paramRunnable)
  {
    ArkLogicThread.a().send(paramString, paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.impl.ArkThreadManagerImpl
 * JD-Core Version:    0.7.0.1
 */
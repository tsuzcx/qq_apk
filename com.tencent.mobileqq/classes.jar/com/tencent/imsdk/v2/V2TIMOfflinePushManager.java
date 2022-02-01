package com.tencent.imsdk.v2;

public abstract class V2TIMOfflinePushManager
{
  static V2TIMOfflinePushManager getInstance()
  {
    return V2TIMOfflinePushManagerImpl.getInstance();
  }
  
  public abstract void doBackground(int paramInt, V2TIMCallback paramV2TIMCallback);
  
  public abstract void doForeground(V2TIMCallback paramV2TIMCallback);
  
  public abstract void setOfflinePushConfig(V2TIMOfflinePushConfig paramV2TIMOfflinePushConfig, V2TIMCallback paramV2TIMCallback);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMOfflinePushManager
 * JD-Core Version:    0.7.0.1
 */
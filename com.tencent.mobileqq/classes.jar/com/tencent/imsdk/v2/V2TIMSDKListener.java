package com.tencent.imsdk.v2;

public abstract class V2TIMSDKListener
{
  public void onConnectFailed(int paramInt, String paramString) {}
  
  public void onConnectSuccess() {}
  
  public void onConnecting() {}
  
  public void onKickedOffline() {}
  
  public void onSelfInfoUpdated(V2TIMUserFullInfo paramV2TIMUserFullInfo) {}
  
  public void onUserSigExpired() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMSDKListener
 * JD-Core Version:    0.7.0.1
 */
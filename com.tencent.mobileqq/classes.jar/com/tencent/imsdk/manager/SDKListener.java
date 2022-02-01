package com.tencent.imsdk.manager;

import com.tencent.imsdk.relationship.UserInfo;

public abstract interface SDKListener
{
  public abstract void onConnectFailed(int paramInt, String paramString);
  
  public abstract void onConnectSuccess();
  
  public abstract void onConnecting();
  
  public abstract void onKickedOffline();
  
  public abstract void onLog(int paramInt, String paramString);
  
  public abstract void onSelfInfoUpdated(UserInfo paramUserInfo);
  
  public abstract void onUserSigExpired();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.manager.SDKListener
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.imsdk.v2;

import com.tencent.imsdk.common.IMContext;
import com.tencent.imsdk.manager.SDKListener;
import com.tencent.imsdk.relationship.UserInfo;

class V2TIMManagerImpl$1
  implements SDKListener
{
  V2TIMManagerImpl$1(V2TIMManagerImpl paramV2TIMManagerImpl, V2TIMSDKListener paramV2TIMSDKListener, V2TIMLogListener paramV2TIMLogListener) {}
  
  public void onConnectFailed(int paramInt, String paramString)
  {
    IMContext.getInstance().runOnMainThread(new V2TIMManagerImpl.1.3(this, paramInt, paramString));
  }
  
  public void onConnectSuccess()
  {
    IMContext.getInstance().runOnMainThread(new V2TIMManagerImpl.1.2(this));
  }
  
  public void onConnecting()
  {
    IMContext.getInstance().runOnMainThread(new V2TIMManagerImpl.1.1(this));
  }
  
  public void onKickedOffline()
  {
    IMContext.getInstance().runOnMainThread(new V2TIMManagerImpl.1.4(this));
  }
  
  public void onLog(int paramInt, String paramString)
  {
    IMContext.getInstance().runOnMainThread(new V2TIMManagerImpl.1.7(this, paramInt, paramString));
  }
  
  public void onSelfInfoUpdated(UserInfo paramUserInfo)
  {
    IMContext.getInstance().runOnMainThread(new V2TIMManagerImpl.1.6(this, paramUserInfo));
  }
  
  public void onUserSigExpired()
  {
    IMContext.getInstance().runOnMainThread(new V2TIMManagerImpl.1.5(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMManagerImpl.1
 * JD-Core Version:    0.7.0.1
 */
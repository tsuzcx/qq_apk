package com.tencent.imsdk.v2;

import com.tencent.imsdk.offlinePush.OfflinePushToken;

public class V2TIMOfflinePushConfig
{
  private OfflinePushToken offlinePushToken = new OfflinePushToken();
  
  public V2TIMOfflinePushConfig(long paramLong, String paramString)
  {
    this.offlinePushToken.setBusinessID((int)paramLong);
    this.offlinePushToken.setDeviceToken(paramString);
  }
  
  OfflinePushToken getOfflinePushToken()
  {
    return this.offlinePushToken;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMOfflinePushConfig
 * JD-Core Version:    0.7.0.1
 */
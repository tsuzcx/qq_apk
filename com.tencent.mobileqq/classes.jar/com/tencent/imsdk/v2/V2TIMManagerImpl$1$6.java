package com.tencent.imsdk.v2;

import com.tencent.imsdk.relationship.UserInfo;

class V2TIMManagerImpl$1$6
  implements Runnable
{
  V2TIMManagerImpl$1$6(V2TIMManagerImpl.1 param1, UserInfo paramUserInfo) {}
  
  public void run()
  {
    if (this.this$1.val$listener != null)
    {
      V2TIMUserFullInfo localV2TIMUserFullInfo = new V2TIMUserFullInfo();
      localV2TIMUserFullInfo.setUserInfo(this.val$info);
      this.this$1.val$listener.onSelfInfoUpdated(localV2TIMUserFullInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMManagerImpl.1.6
 * JD-Core Version:    0.7.0.1
 */
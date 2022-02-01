package com.tencent.liteav.trtc.impl;

import java.lang.ref.WeakReference;

class TRTCCloudImpl$136
  implements Runnable
{
  TRTCCloudImpl$136(TRTCCloudImpl paramTRTCCloudImpl, WeakReference paramWeakReference, long paramLong, String paramString, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (this.this$0.mRoomState == 0)
    {
      this.this$0.apiLog("ignore onAVMemberChange when out room");
      return;
    }
    if ((TRTCCloudImpl)this.val$weakSelf.get() == null) {
      return;
    }
    Object localObject = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onAVMemberChange ");
    localStringBuilder.append(this.val$tinyID);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.val$userID);
    localStringBuilder.append(", old state:");
    localStringBuilder.append(this.val$oldState);
    localStringBuilder.append(", new state:");
    localStringBuilder.append(this.val$streamState);
    ((TRTCCloudImpl)localObject).apiLog(localStringBuilder.toString());
    localObject = this.this$0.mRoomInfo.getUser(this.val$userID);
    if (localObject != null)
    {
      int i = this.val$streamState;
      ((TRTCRoomInfo.UserInfo)localObject).streamState = i;
      this.this$0.checkUserState(this.val$userID, this.val$tinyID, i, this.val$oldState);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.136
 * JD-Core Version:    0.7.0.1
 */
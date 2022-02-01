package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.audio.TXCAudioEngine;
import com.tencent.liteav.audio.a;
import java.lang.ref.WeakReference;

class TRTCCloudImpl$151
  implements Runnable
{
  TRTCCloudImpl$151(TRTCCloudImpl paramTRTCCloudImpl, WeakReference paramWeakReference, String paramString, long paramLong, int paramInt) {}
  
  public void run()
  {
    if (this.this$0.mRoomState == 0)
    {
      this.this$0.apiLog("ignore onAVMemberExit when out room.");
      return;
    }
    if ((TRTCCloudImpl)this.val$weakSelf.get() == null) {
      return;
    }
    Object localObject = this.this$0.mRoomInfo.getUser(this.val$userID);
    if (localObject != null)
    {
      this.this$0.stopRemoteRender((TRTCRoomInfo.UserInfo)localObject);
      this.this$0.mRoomInfo.removeRenderInfo(((TRTCRoomInfo.UserInfo)localObject).userID);
    }
    else
    {
      localObject = this.this$0;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("user ");
      localStringBuilder.append(this.val$userID);
      localStringBuilder.append(" exit room when user is not in room ");
      localStringBuilder.append(this.val$tinyID);
      ((TRTCCloudImpl)localObject).apiLog(localStringBuilder.toString());
    }
    a.a().a(String.valueOf(this.val$tinyID), this.this$0.hashCode());
    TXCAudioEngine.getInstance().setSetAudioEngineRemoteStreamDataListener(String.valueOf(this.val$tinyID), null);
    TXCAudioEngine.getInstance().setRemoteAudioStreamEventListener(String.valueOf(this.val$tinyID), null);
    this.this$0.runOnListenerThread(new TRTCCloudImpl.151.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.151
 * JD-Core Version:    0.7.0.1
 */
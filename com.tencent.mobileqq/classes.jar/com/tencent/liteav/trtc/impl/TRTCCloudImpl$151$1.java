package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.basic.module.Monitor;
import com.tencent.trtc.TRTCCloudListener;

class TRTCCloudImpl$151$1
  implements Runnable
{
  TRTCCloudImpl$151$1(TRTCCloudImpl.151 param151) {}
  
  public void run()
  {
    Object localObject = this.this$1.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onAVMemberExit ");
    localStringBuilder.append(this.this$1.val$tinyID);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.this$1.val$userID);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.this$1.val$videoState);
    ((TRTCCloudImpl)localObject).apiLog(localStringBuilder.toString());
    localObject = this.this$1.this$0.mTRTCListener;
    if (localObject != null)
    {
      if ((TRTCRoomInfo.hasAudio(this.this$1.val$videoState)) && (!TRTCRoomInfo.isMuteAudio(this.this$1.val$videoState)))
      {
        ((TRTCCloudListener)localObject).onUserAudioAvailable(this.this$1.val$userID, false);
        TRTCCloudImpl.access$9700(this.this$1.this$0, this.this$1.this$0.mRoomInfo.getUserId(), 0, String.format("[%s]audio Available[%b]", new Object[] { this.this$1.val$userID, Boolean.valueOf(false) }));
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(String.format("onUserAudioAvailable userID:%s, bAvailable:%b", new Object[] { this.this$1.val$userID, Boolean.valueOf(false) }));
        localStringBuilder.append(" self:");
        localStringBuilder.append(this.this$1.this$0.hashCode());
        Monitor.a(2, localStringBuilder.toString(), "", 0);
      }
      if (((TRTCRoomInfo.hasMainVideo(this.this$1.val$videoState)) || (TRTCRoomInfo.hasSmallVideo(this.this$1.val$videoState))) && (!TRTCRoomInfo.isMuteMainVideo(this.this$1.val$videoState)))
      {
        ((TRTCCloudListener)localObject).onUserVideoAvailable(this.this$1.val$userID, false);
        TRTCCloudImpl.access$9700(this.this$1.this$0, this.this$1.this$0.mRoomInfo.getUserId(), 0, String.format("[%s]video Available[%b]", new Object[] { this.this$1.val$userID, Boolean.valueOf(false) }));
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(String.format("onUserVideoAvailable userID:%s, bAvailable:%b", new Object[] { this.this$1.val$userID, Boolean.valueOf(false) }));
        localStringBuilder.append(" self:");
        localStringBuilder.append(this.this$1.this$0.hashCode());
        Monitor.a(2, localStringBuilder.toString(), "", 0);
      }
      if ((TRTCRoomInfo.hasSubVideo(this.this$1.val$videoState)) && (!TRTCRoomInfo.isMuteSubVideo(this.this$1.val$videoState)))
      {
        ((TRTCCloudListener)localObject).onUserSubStreamAvailable(this.this$1.val$userID, false);
        TRTCCloudImpl.access$9700(this.this$1.this$0, this.this$1.this$0.mRoomInfo.getUserId(), 0, String.format("[%s]subVideo Available[%b]", new Object[] { this.this$1.val$userID, Boolean.valueOf(false) }));
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(String.format("onUserSubStreamAvailable userID:%s, bAvailable:%b", new Object[] { this.this$1.val$userID, Boolean.valueOf(false) }));
        localStringBuilder.append(" self:");
        localStringBuilder.append(this.this$1.this$0.hashCode());
        Monitor.a(2, localStringBuilder.toString(), "", 0);
      }
      ((TRTCCloudListener)localObject).onUserExit(this.this$1.val$userID, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.151.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.TXCRenderAndDec;
import com.tencent.liteav.d;
import com.tencent.liteav.renderer.e;
import com.tencent.trtc.TRTCCloudListener.TRTCSnapshotListener;

class TRTCCloudImpl$27
  implements Runnable
{
  TRTCCloudImpl$27(TRTCCloudImpl paramTRTCCloudImpl, String paramString, TRTCCloudListener.TRTCSnapshotListener paramTRTCSnapshotListener, int paramInt) {}
  
  public void run()
  {
    if (this.val$userId == null)
    {
      this.this$0.apiLog("snapshotLocalView");
      this.this$0.mCaptureAndEnc.a(new TRTCCloudImpl.27.1(this));
      return;
    }
    TRTCRoomInfo.UserInfo localUserInfo = this.this$0.mRoomInfo.getUser(this.val$userId);
    StringBuilder localStringBuilder = null;
    Object localObject;
    if (this.val$streamType == 2)
    {
      localObject = localStringBuilder;
      if (localUserInfo != null)
      {
        localObject = localStringBuilder;
        if (localUserInfo.mainRender != null)
        {
          localObject = localStringBuilder;
          if (localUserInfo.mainRender.render != null)
          {
            localObject = this.this$0;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("snapshotRemoteSubStreamView->userId: ");
            localStringBuilder.append(this.val$userId);
            ((TRTCCloudImpl)localObject).apiLog(localStringBuilder.toString());
            localObject = localUserInfo.subRender.render.getVideoRender();
          }
        }
      }
    }
    else
    {
      localObject = localStringBuilder;
      if (localUserInfo != null)
      {
        localObject = localStringBuilder;
        if (localUserInfo.mainRender != null)
        {
          localObject = localStringBuilder;
          if (localUserInfo.mainRender.render != null)
          {
            localObject = this.this$0;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("snapshotRemoteView->userId: ");
            localStringBuilder.append(this.val$userId);
            ((TRTCCloudImpl)localObject).apiLog(localStringBuilder.toString());
            localObject = localUserInfo.mainRender.render.getVideoRender();
          }
        }
      }
    }
    if (localObject != null)
    {
      ((e)localObject).a(new TRTCCloudImpl.27.2(this));
      return;
    }
    this.this$0.runOnListenerThread(new TRTCCloudImpl.27.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.27
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.liteav.trtc.impl;

import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.trtc.TRTCCloud.TRTCViewMargin;

class TRTCCloudImpl$106
  implements Runnable
{
  TRTCCloudImpl$106(TRTCCloudImpl paramTRTCCloudImpl, String paramString, TRTCCloud.TRTCViewMargin paramTRTCViewMargin) {}
  
  public void run()
  {
    this.this$0.apiLog("setDebugViewMargin");
    TXCloudVideoView localTXCloudVideoView = this.this$0.mRoomInfo.localView;
    if ((localTXCloudVideoView != null) && (this.val$userId.equalsIgnoreCase(localTXCloudVideoView.getUserId()))) {
      this.this$0.runOnMainThread(new TRTCCloudImpl.106.1(this, localTXCloudVideoView));
    }
    Object localObject = this.this$0.mRoomInfo.getUser(this.val$userId);
    if (localObject != null)
    {
      ((TRTCRoomInfo.UserInfo)localObject).debugMargin = this.val$margin;
      localTXCloudVideoView = ((TRTCRoomInfo.UserInfo)localObject).mainRender.view;
      localObject = ((TRTCRoomInfo.UserInfo)localObject).subRender.view;
      if ((localTXCloudVideoView != null) || (localObject != null)) {
        this.this$0.runOnMainThread(new TRTCCloudImpl.106.2(this, localTXCloudVideoView, (TXCloudVideoView)localObject));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.106
 * JD-Core Version:    0.7.0.1
 */
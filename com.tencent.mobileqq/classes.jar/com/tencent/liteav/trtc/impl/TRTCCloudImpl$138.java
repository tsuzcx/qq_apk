package com.tencent.liteav.trtc.impl;

import com.tencent.trtc.TRTCCloudListener;
import java.lang.ref.WeakReference;

class TRTCCloudImpl$138
  implements Runnable
{
  TRTCCloudImpl$138(TRTCCloudImpl paramTRTCCloudImpl, WeakReference paramWeakReference, String paramString, int paramInt) {}
  
  public void run()
  {
    if ((TRTCCloudImpl)this.val$weakSelf.get() == null) {
      return;
    }
    TRTCCloudListener localTRTCCloudListener = this.this$0.mTRTCListener;
    if (localTRTCCloudListener != null) {
      localTRTCCloudListener.onRemoteUserLeaveRoom(this.val$userID, this.val$exitReason);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.138
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.liteav.trtc.impl;

import com.tencent.trtc.TRTCCloudListener;
import java.lang.ref.WeakReference;

class TRTCCloudImpl$137
  implements Runnable
{
  TRTCCloudImpl$137(TRTCCloudImpl paramTRTCCloudImpl, WeakReference paramWeakReference, String paramString) {}
  
  public void run()
  {
    if ((TRTCCloudImpl)this.val$weakSelf.get() == null) {
      return;
    }
    TRTCCloudListener localTRTCCloudListener = this.this$0.mTRTCListener;
    if (localTRTCCloudListener != null) {
      localTRTCCloudListener.onRemoteUserEnterRoom(this.val$userID);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.137
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.liteav.trtc.impl;

import com.tencent.trtc.TRTCCloudListener.TRTCSnapshotListener;

class TRTCCloudImpl$27$3
  implements Runnable
{
  TRTCCloudImpl$27$3(TRTCCloudImpl.27 param27) {}
  
  public void run()
  {
    if (this.this$1.val$listener != null) {
      this.this$1.val$listener.onSnapshotComplete(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.27.3
 * JD-Core Version:    0.7.0.1
 */
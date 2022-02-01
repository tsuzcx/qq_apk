package com.tencent.liteav.trtc.impl;

import com.tencent.trtc.TRTCCloudListener.TRTCSnapshotListener;

class TRTCCloudImpl$23$3
  implements Runnable
{
  TRTCCloudImpl$23$3(TRTCCloudImpl.23 param23) {}
  
  public void run()
  {
    if (this.this$1.val$listener != null) {
      this.this$1.val$listener.onSnapshotComplete(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.23.3
 * JD-Core Version:    0.7.0.1
 */
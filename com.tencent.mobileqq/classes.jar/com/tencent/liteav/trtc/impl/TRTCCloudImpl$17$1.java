package com.tencent.liteav.trtc.impl;

import com.tencent.trtc.TRTCCloudListener;

class TRTCCloudImpl$17$1
  implements Runnable
{
  TRTCCloudImpl$17$1(TRTCCloudImpl.17 param17) {}
  
  public void run()
  {
    if (this.this$1.this$0.mTRTCListener != null) {
      this.this$1.this$0.mTRTCListener.onSwitchRoom(-3301, "Invalid room id");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.17.1
 * JD-Core Version:    0.7.0.1
 */
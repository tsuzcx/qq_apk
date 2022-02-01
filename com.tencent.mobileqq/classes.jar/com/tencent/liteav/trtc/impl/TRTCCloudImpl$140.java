package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.d;
import com.tencent.liteav.g;

class TRTCCloudImpl$140
  implements Runnable
{
  TRTCCloudImpl$140(TRTCCloudImpl paramTRTCCloudImpl, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8) {}
  
  public void run()
  {
    d locald = this.this$0.mCaptureAndEnc;
    int j = this.val$streamType;
    int k = this.val$width;
    int m = this.val$height;
    int n = this.val$fps;
    int i1 = this.val$bitrate;
    int i2 = this.val$totalBitrate;
    int i3 = this.val$rpsNearestMode;
    int i4 = this.val$enableHevcEnc;
    int i = 0;
    boolean bool;
    if (i4 == 1) {
      bool = true;
    } else {
      bool = false;
    }
    locald.a(j, k, m, n, i1, i2, i3, bool);
    if (this.val$streamType == 2)
    {
      if (this.val$width <= this.val$height) {
        i = 1;
      }
      if ((this.this$0.mConfig.l != i) && (this.val$width != this.val$height))
      {
        this.this$0.mConfig.l = i;
        TRTCCloudImpl.access$2100(this.this$0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.140
 * JD-Core Version:    0.7.0.1
 */
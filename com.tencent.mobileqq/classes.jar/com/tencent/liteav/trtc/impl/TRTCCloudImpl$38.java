package com.tencent.liteav.trtc.impl;

import com.tencent.liteav.d;
import com.tencent.liteav.g;
import com.tencent.liteav.g.a;
import com.tencent.trtc.TRTCCloudDef.TRTCVideoEncParam;

class TRTCCloudImpl$38
  implements Runnable
{
  TRTCCloudImpl$38(TRTCCloudImpl paramTRTCCloudImpl, TRTCCloudDef.TRTCVideoEncParam paramTRTCVideoEncParam) {}
  
  public void run()
  {
    synchronized (TRTCCloudImpl.access$4500(this.this$0))
    {
      if (this.this$0.mSubStreamCaptureAndEnc == null) {
        this.this$0.mSubStreamCaptureAndEnc = TRTCCloudImpl.access$4600(this.this$0, 7);
      }
      ??? = TRTCCloudImpl.access$3800(this.this$0, this.val$param.videoResolution, this.val$param.videoResolutionMode);
      g localg = this.this$0.mSubStreamCaptureAndEnc.c();
      if (this.val$param.videoResolutionMode == 1)
      {
        localg.m = 1;
        localg.a = ((g.a)???).a;
        localg.b = ((g.a)???).b;
      }
      else
      {
        localg.m = 0;
        localg.a = ((g.a)???).b;
        localg.b = ((g.a)???).a;
      }
      if (this.val$param.videoFps > 0) {
        if (this.val$param.videoFps > 30)
        {
          this.this$0.apiLog("setSubStreamEncoderParam fps > 30, limit fps to 30");
          localg.i = 30;
        }
        else
        {
          localg.i = this.val$param.videoFps;
        }
      }
      if (this.val$param.videoBitrate > 0) {
        localg.c = this.val$param.videoBitrate;
      }
      if (this.val$param.minVideoBitrate >= 0) {
        localg.e = this.val$param.minVideoBitrate;
      }
      TRTCCloudImpl.access$4700(this.this$0, 7, localg.a, localg.b, localg.i, localg.c, localg.q, localg.e, true);
      if ((TRTCCloudImpl.access$500(this.this$0) == 2) && (localg.a * localg.b >= 518400)) {
        localg.k = 1;
      }
      this.this$0.mSubStreamCaptureAndEnc.e(localg.i);
      this.this$0.mSubStreamCaptureAndEnc.a(localg);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.trtc.impl.TRTCCloudImpl.38
 * JD-Core Version:    0.7.0.1
 */
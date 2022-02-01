package com.tencent.live2.impl;

import com.tencent.live2.V2TXLiveDef.V2TXLiveVideoResolution;
import com.tencent.live2.V2TXLiveDef.V2TXLiveVideoResolutionMode;
import com.tencent.live2.V2TXLivePusher;

class V2TXLivePusherImpl$18
  implements Runnable
{
  V2TXLivePusherImpl$18(V2TXLivePusherImpl paramV2TXLivePusherImpl, V2TXLiveDef.V2TXLiveVideoResolution paramV2TXLiveVideoResolution, V2TXLiveDef.V2TXLiveVideoResolutionMode paramV2TXLiveVideoResolutionMode) {}
  
  public void run()
  {
    V2TXLivePusherImpl.access$000(this.this$0).setVideoQuality(this.val$resolution, this.val$mode);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.live2.impl.V2TXLivePusherImpl.18
 * JD-Core Version:    0.7.0.1
 */
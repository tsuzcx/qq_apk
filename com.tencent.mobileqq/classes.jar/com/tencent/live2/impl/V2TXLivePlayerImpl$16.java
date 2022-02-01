package com.tencent.live2.impl;

import com.tencent.live2.V2TXLivePlayer;

class V2TXLivePlayerImpl$16
  implements Runnable
{
  V2TXLivePlayerImpl$16(V2TXLivePlayerImpl paramV2TXLivePlayerImpl, int paramInt) {}
  
  public void run()
  {
    V2TXLivePlayerImpl.access$1602(this.this$0, this.val$intervalMs);
    if (V2TXLivePlayerImpl.access$100(this.this$0) != null) {
      V2TXLivePlayerImpl.access$100(this.this$0).enableVolumeEvaluation(this.val$intervalMs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.live2.impl.V2TXLivePlayerImpl.16
 * JD-Core Version:    0.7.0.1
 */
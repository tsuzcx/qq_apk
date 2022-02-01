package com.tencent.live2.impl;

import com.tencent.live2.V2TXLivePlayer;

class V2TXLivePlayerImpl$15
  implements Runnable
{
  V2TXLivePlayerImpl$15(V2TXLivePlayerImpl paramV2TXLivePlayerImpl, float paramFloat1, float paramFloat2) {}
  
  public void run()
  {
    V2TXLivePlayerImpl.access$1402(this.this$0, this.val$maxTime);
    V2TXLivePlayerImpl.access$1502(this.this$0, this.val$minTime);
    if (V2TXLivePlayerImpl.access$100(this.this$0) != null) {
      V2TXLivePlayerImpl.access$100(this.this$0).setCacheParams(this.val$minTime, this.val$maxTime);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.live2.impl.V2TXLivePlayerImpl.15
 * JD-Core Version:    0.7.0.1
 */
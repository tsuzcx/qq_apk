package com.tencent.live2.impl;

import com.tencent.live2.V2TXLiveDef.V2TXLiveFillMode;
import com.tencent.live2.V2TXLivePlayer;

class V2TXLivePlayerImpl$7
  implements Runnable
{
  V2TXLivePlayerImpl$7(V2TXLivePlayerImpl paramV2TXLivePlayerImpl, V2TXLiveDef.V2TXLiveFillMode paramV2TXLiveFillMode) {}
  
  public void run()
  {
    V2TXLivePlayerImpl.access$702(this.this$0, this.val$mode);
    if (V2TXLivePlayerImpl.access$100(this.this$0) != null) {
      V2TXLivePlayerImpl.access$100(this.this$0).setRenderFillMode(this.val$mode);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.live2.impl.V2TXLivePlayerImpl.7
 * JD-Core Version:    0.7.0.1
 */
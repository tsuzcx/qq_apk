package com.tencent.live2.impl;

import com.tencent.live2.V2TXLiveDef.V2TXLiveRotation;
import com.tencent.live2.V2TXLivePlayer;

class V2TXLivePlayerImpl$6
  implements Runnable
{
  V2TXLivePlayerImpl$6(V2TXLivePlayerImpl paramV2TXLivePlayerImpl, V2TXLiveDef.V2TXLiveRotation paramV2TXLiveRotation) {}
  
  public void run()
  {
    V2TXLivePlayerImpl.access$602(this.this$0, this.val$rotation);
    if (V2TXLivePlayerImpl.access$100(this.this$0) != null) {
      V2TXLivePlayerImpl.access$100(this.this$0).setRenderRotation(this.val$rotation);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.live2.impl.V2TXLivePlayerImpl.6
 * JD-Core Version:    0.7.0.1
 */
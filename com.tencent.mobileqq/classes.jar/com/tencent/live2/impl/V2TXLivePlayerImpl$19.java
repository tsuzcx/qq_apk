package com.tencent.live2.impl;

import com.tencent.live2.V2TXLivePlayer;

class V2TXLivePlayerImpl$19
  implements Runnable
{
  V2TXLivePlayerImpl$19(V2TXLivePlayerImpl paramV2TXLivePlayerImpl, boolean paramBoolean) {}
  
  public void run()
  {
    V2TXLivePlayerImpl.access$2002(this.this$0, this.val$enable);
    if (V2TXLivePlayerImpl.access$100(this.this$0) != null) {
      V2TXLivePlayerImpl.access$100(this.this$0).showDebugView(this.val$enable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.live2.impl.V2TXLivePlayerImpl.19
 * JD-Core Version:    0.7.0.1
 */
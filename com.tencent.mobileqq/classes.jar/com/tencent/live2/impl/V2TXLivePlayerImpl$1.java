package com.tencent.live2.impl;

import com.tencent.live2.V2TXLivePlayer;
import com.tencent.live2.V2TXLivePlayerObserver;

class V2TXLivePlayerImpl$1
  implements Runnable
{
  V2TXLivePlayerImpl$1(V2TXLivePlayerImpl paramV2TXLivePlayerImpl, V2TXLivePlayerObserver paramV2TXLivePlayerObserver) {}
  
  public void run()
  {
    V2TXLivePlayerImpl.access$002(this.this$0, this.val$observer);
    if (V2TXLivePlayerImpl.access$100(this.this$0) != null) {
      V2TXLivePlayerImpl.access$100(this.this$0).setObserver(this.val$observer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.live2.impl.V2TXLivePlayerImpl.1
 * JD-Core Version:    0.7.0.1
 */
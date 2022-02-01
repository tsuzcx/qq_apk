package com.tencent.live2.impl;

import com.tencent.live2.V2TXLivePlayer;

class V2TXLivePlayerImpl$10
  implements Runnable
{
  V2TXLivePlayerImpl$10(V2TXLivePlayerImpl paramV2TXLivePlayerImpl) {}
  
  public void run()
  {
    V2TXLivePlayerImpl.access$1102(this.this$0, true);
    if (V2TXLivePlayerImpl.access$100(this.this$0) != null) {
      V2TXLivePlayerImpl.access$100(this.this$0).pauseAudio();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.live2.impl.V2TXLivePlayerImpl.10
 * JD-Core Version:    0.7.0.1
 */
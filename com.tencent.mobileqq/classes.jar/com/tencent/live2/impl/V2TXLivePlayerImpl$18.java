package com.tencent.live2.impl;

import com.tencent.live2.V2TXLiveDef.V2TXLiveBufferType;
import com.tencent.live2.V2TXLiveDef.V2TXLivePixelFormat;
import com.tencent.live2.V2TXLivePlayer;

class V2TXLivePlayerImpl$18
  implements Runnable
{
  V2TXLivePlayerImpl$18(V2TXLivePlayerImpl paramV2TXLivePlayerImpl, boolean paramBoolean, V2TXLiveDef.V2TXLivePixelFormat paramV2TXLivePixelFormat, V2TXLiveDef.V2TXLiveBufferType paramV2TXLiveBufferType) {}
  
  public void run()
  {
    V2TXLivePlayerImpl.access$1702(this.this$0, this.val$enable);
    V2TXLivePlayerImpl.access$1802(this.this$0, this.val$pixelFormat);
    V2TXLivePlayerImpl.access$1902(this.this$0, this.val$bufferType);
    if (V2TXLivePlayerImpl.access$100(this.this$0) != null) {
      V2TXLivePlayerImpl.access$100(this.this$0).enableCustomRendering(this.val$enable, this.val$pixelFormat, this.val$bufferType);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.live2.impl.V2TXLivePlayerImpl.18
 * JD-Core Version:    0.7.0.1
 */
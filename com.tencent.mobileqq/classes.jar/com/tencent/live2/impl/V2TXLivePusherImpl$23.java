package com.tencent.live2.impl;

import com.tencent.live2.V2TXLiveDef.V2TXLiveBufferType;
import com.tencent.live2.V2TXLiveDef.V2TXLivePixelFormat;
import com.tencent.live2.V2TXLivePusher;

class V2TXLivePusherImpl$23
  implements Runnable
{
  V2TXLivePusherImpl$23(V2TXLivePusherImpl paramV2TXLivePusherImpl, boolean paramBoolean, V2TXLiveDef.V2TXLivePixelFormat paramV2TXLivePixelFormat, V2TXLiveDef.V2TXLiveBufferType paramV2TXLiveBufferType) {}
  
  public void run()
  {
    V2TXLivePusherImpl.access$000(this.this$0).enableCustomVideoProcess(this.val$enable, this.val$format, this.val$type);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.live2.impl.V2TXLivePusherImpl.23
 * JD-Core Version:    0.7.0.1
 */
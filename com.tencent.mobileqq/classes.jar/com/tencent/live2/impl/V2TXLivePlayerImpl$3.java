package com.tencent.live2.impl;

import com.tencent.live2.V2TXLivePlayer;
import com.tencent.rtmp.ui.TXCloudVideoView;

class V2TXLivePlayerImpl$3
  implements Runnable
{
  V2TXLivePlayerImpl$3(V2TXLivePlayerImpl paramV2TXLivePlayerImpl, TXCloudVideoView paramTXCloudVideoView) {}
  
  public void run()
  {
    V2TXLivePlayerImpl.access$502(this.this$0, this.val$view);
    if (V2TXLivePlayerImpl.access$100(this.this$0) != null) {
      V2TXLivePlayerImpl.access$100(this.this$0).setRenderView(this.val$view);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.live2.impl.V2TXLivePlayerImpl.3
 * JD-Core Version:    0.7.0.1
 */
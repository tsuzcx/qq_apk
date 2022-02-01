package com.tencent.live2.impl;

import android.view.TextureView;
import com.tencent.live2.V2TXLivePlayer;

class V2TXLivePlayerImpl$4
  implements Runnable
{
  V2TXLivePlayerImpl$4(V2TXLivePlayerImpl paramV2TXLivePlayerImpl, TextureView paramTextureView) {}
  
  public void run()
  {
    V2TXLivePlayerImpl.access$502(this.this$0, this.val$view);
    if (V2TXLivePlayerImpl.access$100(this.this$0) != null) {
      V2TXLivePlayerImpl.access$100(this.this$0).setRenderView(this.val$view);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.live2.impl.V2TXLivePlayerImpl.4
 * JD-Core Version:    0.7.0.1
 */
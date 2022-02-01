package com.tencent.live2.impl;

import com.tencent.live2.V2TXLiveDef.V2TXLiveMode;
import com.tencent.live2.V2TXLivePlayer;
import com.tencent.live2.a.a;
import com.tencent.live2.b.d;

class V2TXLivePlayerImpl$8
  implements Runnable
{
  V2TXLivePlayerImpl$8(V2TXLivePlayerImpl paramV2TXLivePlayerImpl, V2TXLiveDef.V2TXLiveMode paramV2TXLiveMode, String paramString) {}
  
  public void run()
  {
    if ((V2TXLivePlayerImpl.access$100(this.this$0) != null) && (V2TXLivePlayerImpl.access$100(this.this$0).isPlaying() == 1)) {
      V2TXLivePlayerImpl.access$100(this.this$0).stopPlay();
    }
    V2TXLivePlayerImpl localV2TXLivePlayerImpl;
    if (this.val$mode == V2TXLiveDef.V2TXLiveMode.TXLiveMode_RTC)
    {
      localV2TXLivePlayerImpl = this.this$0;
      V2TXLivePlayerImpl.access$102(localV2TXLivePlayerImpl, new d(localV2TXLivePlayerImpl, V2TXLivePlayerImpl.access$800(localV2TXLivePlayerImpl)));
    }
    else
    {
      localV2TXLivePlayerImpl = this.this$0;
      V2TXLivePlayerImpl.access$102(localV2TXLivePlayerImpl, new a(localV2TXLivePlayerImpl, V2TXLivePlayerImpl.access$800(localV2TXLivePlayerImpl)));
    }
    V2TXLivePlayerImpl.access$900(this.this$0);
    V2TXLivePlayerImpl.access$100(this.this$0).startPlay(this.val$url);
    V2TXLivePlayerImpl.access$1002(this.this$0, a.b.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.live2.impl.V2TXLivePlayerImpl.8
 * JD-Core Version:    0.7.0.1
 */
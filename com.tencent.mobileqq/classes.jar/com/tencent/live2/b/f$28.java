package com.tencent.live2.b;

import android.os.Bundle;
import com.tencent.live2.V2TXLiveDef.V2TXLivePlayStatus;
import com.tencent.live2.V2TXLiveDef.V2TXLiveStatusChangeReason;
import com.tencent.live2.V2TXLivePlayerObserver;

class f$28
  implements Runnable
{
  f$28(f paramf, f.b paramb, V2TXLiveDef.V2TXLivePlayStatus paramV2TXLivePlayStatus, V2TXLiveDef.V2TXLiveStatusChangeReason paramV2TXLiveStatusChangeReason) {}
  
  public void run()
  {
    if ((this.a.f != null) && (this.a.g != null)) {
      this.a.f.onAudioPlayStatusUpdate(this.a.g, this.b, this.c, new Bundle());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.live2.b.f.28
 * JD-Core Version:    0.7.0.1
 */
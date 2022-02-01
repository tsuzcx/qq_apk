package com.tencent.live2.b;

import android.os.Bundle;
import com.tencent.live2.V2TXLiveDef.V2TXLivePushStatus;
import com.tencent.live2.V2TXLivePusherObserver;

class f$12
  implements Runnable
{
  f$12(f paramf, V2TXLivePusherObserver paramV2TXLivePusherObserver) {}
  
  public void run()
  {
    this.a.onPushStatusUpdate(V2TXLiveDef.V2TXLivePushStatus.V2TXLivePushStatusDisconnected, "disconnect server", new Bundle());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.live2.b.f.12
 * JD-Core Version:    0.7.0.1
 */
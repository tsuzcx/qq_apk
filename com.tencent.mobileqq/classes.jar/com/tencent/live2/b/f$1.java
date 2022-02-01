package com.tencent.live2.b;

import android.os.Bundle;
import com.tencent.live2.V2TXLiveDef.V2TXLivePushStatus;
import com.tencent.live2.V2TXLivePusherObserver;

class f$1
  implements Runnable
{
  f$1(f paramf, V2TXLivePusherObserver paramV2TXLivePusherObserver) {}
  
  public void run()
  {
    this.a.onPushStatusUpdate(V2TXLiveDef.V2TXLivePushStatus.V2TXLivePushStatusConnecting, "connecting to the server.", new Bundle());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.live2.b.f.1
 * JD-Core Version:    0.7.0.1
 */
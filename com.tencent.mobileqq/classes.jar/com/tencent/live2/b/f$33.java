package com.tencent.live2.b;

import android.os.Bundle;
import com.tencent.live2.V2TXLiveDef.V2TXLivePushStatus;
import com.tencent.live2.V2TXLivePusherObserver;
import com.tencent.live2.impl.a.b;

class f$33
  implements Runnable
{
  f$33(f paramf, V2TXLivePusherObserver paramV2TXLivePusherObserver, Bundle paramBundle, long paramLong) {}
  
  public void run()
  {
    this.a.onPushStatusUpdate(V2TXLiveDef.V2TXLivePushStatus.V2TXLivePushStatusConnectSuccess, "connected to the server successfully.", this.b);
    V2TXLivePusherObserver localV2TXLivePusherObserver = this.a;
    if ((localV2TXLivePusherObserver instanceof b)) {
      ((b)localV2TXLivePusherObserver).onEnterRoom(this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.live2.b.f.33
 * JD-Core Version:    0.7.0.1
 */
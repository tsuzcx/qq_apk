package com.tencent.live2.b;

import android.os.Bundle;
import com.tencent.live2.V2TXLivePlayerObserver;

class d$1
  implements Runnable
{
  d$1(d paramd) {}
  
  public void run()
  {
    V2TXLivePlayerObserver localV2TXLivePlayerObserver = d.a(this.a);
    if (localV2TXLivePlayerObserver != null) {
      localV2TXLivePlayerObserver.onError(d.b(this.a), -3, "start play fail. duplicate streamId, please ensure that no other player or pusher is using this streamId now.", new Bundle());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.live2.b.d.1
 * JD-Core Version:    0.7.0.1
 */
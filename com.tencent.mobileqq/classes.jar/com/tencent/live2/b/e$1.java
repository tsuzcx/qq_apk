package com.tencent.live2.b;

import android.os.Bundle;
import com.tencent.live2.V2TXLivePusherObserver;

class e$1
  implements Runnable
{
  e$1(e parame) {}
  
  public void run()
  {
    V2TXLivePusherObserver localV2TXLivePusherObserver = e.a(this.a);
    if (localV2TXLivePusherObserver != null) {
      localV2TXLivePusherObserver.onError(-3, "start push fail. duplicate streamId, please ensure that no other player or pusher is using this streamId now.", new Bundle());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.live2.b.e.1
 * JD-Core Version:    0.7.0.1
 */
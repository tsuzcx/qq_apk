package com.tencent.live2.b;

import com.tencent.live2.V2TXLivePusherObserver;
import com.tencent.live2.impl.a.b;

class f$11
  implements Runnable
{
  f$11(f paramf, f.c paramc, String paramString, int paramInt) {}
  
  public void run()
  {
    V2TXLivePusherObserver localV2TXLivePusherObserver = f.b(this.d);
    if ((localV2TXLivePusherObserver != null) && ((localV2TXLivePusherObserver instanceof b)))
    {
      if (this.a.c) {
        ((b)localV2TXLivePusherObserver).onUserVideoAvailable(this.b, 0, false);
      }
      if (this.a.b) {
        ((b)localV2TXLivePusherObserver).onUserAudioAvailable(this.b, false);
      }
      if (this.a.f) {
        ((b)localV2TXLivePusherObserver).onUserVideoAvailable(this.b, 2, false);
      }
      ((b)localV2TXLivePusherObserver).onRemoteUserExit(this.b, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.live2.b.f.11
 * JD-Core Version:    0.7.0.1
 */
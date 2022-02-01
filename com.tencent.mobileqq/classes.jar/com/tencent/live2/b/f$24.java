package com.tencent.live2.b;

import com.tencent.live2.V2TXLivePusherObserver;

class f$24
  implements Runnable
{
  f$24(f paramf) {}
  
  public void run()
  {
    f.a(this.a, "onMicDidReady");
    V2TXLivePusherObserver localV2TXLivePusherObserver = f.b(this.a);
    if (localV2TXLivePusherObserver != null) {
      localV2TXLivePusherObserver.onCaptureFirstAudioFrame();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.live2.b.f.24
 * JD-Core Version:    0.7.0.1
 */
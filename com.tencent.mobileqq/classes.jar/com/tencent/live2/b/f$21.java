package com.tencent.live2.b;

import com.tencent.live2.V2TXLivePusherObserver;

class f$21
  implements Runnable
{
  f$21(f paramf) {}
  
  public void run()
  {
    f.a(this.a, "onCameraDidReady");
    V2TXLivePusherObserver localV2TXLivePusherObserver = f.b(this.a);
    if (localV2TXLivePusherObserver != null) {
      localV2TXLivePusherObserver.onCaptureFirstVideoFrame();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.live2.b.f.21
 * JD-Core Version:    0.7.0.1
 */
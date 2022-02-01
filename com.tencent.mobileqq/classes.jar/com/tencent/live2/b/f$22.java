package com.tencent.live2.b;

import com.tencent.live2.V2TXLivePusherObserver;

class f$22
  implements Runnable
{
  f$22(f paramf) {}
  
  public void run()
  {
    f.a(this.a, "onScreenCaptureStarted");
    V2TXLivePusherObserver localV2TXLivePusherObserver = f.b(this.a);
    if (localV2TXLivePusherObserver != null) {
      localV2TXLivePusherObserver.onCaptureFirstVideoFrame();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.live2.b.f.22
 * JD-Core Version:    0.7.0.1
 */
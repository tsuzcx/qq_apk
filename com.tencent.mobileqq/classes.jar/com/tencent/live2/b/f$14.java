package com.tencent.live2.b;

import com.tencent.live2.V2TXLivePusherObserver;
import com.tencent.live2.impl.a.b;

class f$14
  implements Runnable
{
  f$14(f paramf, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    V2TXLivePusherObserver localV2TXLivePusherObserver = f.b(this.c);
    if ((localV2TXLivePusherObserver != null) && ((localV2TXLivePusherObserver instanceof b))) {
      ((b)localV2TXLivePusherObserver).onUserAudioAvailable(this.a, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.live2.b.f.14
 * JD-Core Version:    0.7.0.1
 */
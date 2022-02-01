package com.tencent.live2.b;

import com.tencent.live2.V2TXLivePusherObserver;
import com.tencent.live2.impl.a.b;

class f$10
  implements Runnable
{
  f$10(f paramf, String paramString) {}
  
  public void run()
  {
    V2TXLivePusherObserver localV2TXLivePusherObserver = f.b(this.b);
    if ((localV2TXLivePusherObserver != null) && ((localV2TXLivePusherObserver instanceof b))) {
      ((b)localV2TXLivePusherObserver).onRemoteUserEnter(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.live2.b.f.10
 * JD-Core Version:    0.7.0.1
 */
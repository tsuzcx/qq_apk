package com.tencent.live2.b;

import com.tencent.live2.V2TXLivePusherObserver;
import com.tencent.live2.impl.a.b;

class f$15
  implements Runnable
{
  f$15(f paramf, String paramString, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    V2TXLivePusherObserver localV2TXLivePusherObserver = f.b(this.d);
    if ((localV2TXLivePusherObserver != null) && ((localV2TXLivePusherObserver instanceof b))) {
      ((b)localV2TXLivePusherObserver).onUserVideoAvailable(this.a, this.b, this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.live2.b.f.15
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.live2.b;

import android.os.Bundle;
import com.tencent.live2.V2TXLivePlayerObserver;

class d$2
  implements Runnable
{
  d$2(d paramd, String paramString) {}
  
  public void run()
  {
    V2TXLivePlayerObserver localV2TXLivePlayerObserver = d.a(this.b);
    if (localV2TXLivePlayerObserver != null) {
      localV2TXLivePlayerObserver.onError(d.b(this.b), -3, this.a, new Bundle());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.live2.b.d.2
 * JD-Core Version:    0.7.0.1
 */
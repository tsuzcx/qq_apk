package com.tencent.live2.b;

import android.os.Bundle;
import com.tencent.live2.V2TXLivePlayer;
import com.tencent.live2.V2TXLivePlayerObserver;

class d$3
  implements Runnable
{
  d$3(d paramd, int paramInt) {}
  
  public void run()
  {
    V2TXLivePlayerObserver localV2TXLivePlayerObserver = d.a(this.b);
    if (localV2TXLivePlayerObserver != null)
    {
      V2TXLivePlayer localV2TXLivePlayer = d.b(this.b);
      int i = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("start play fail. [errorCode:");
      localStringBuilder.append(this.a);
      localStringBuilder.append("]");
      localV2TXLivePlayerObserver.onError(localV2TXLivePlayer, i, localStringBuilder.toString(), new Bundle());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.live2.b.d.3
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.live2.b;

import android.os.Bundle;
import com.tencent.live2.V2TXLivePusherObserver;

class e$2
  implements Runnable
{
  e$2(e parame, int paramInt) {}
  
  public void run()
  {
    V2TXLivePusherObserver localV2TXLivePusherObserver = e.a(this.b);
    if (localV2TXLivePusherObserver != null)
    {
      int i = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("start push fail. [errorCode:");
      localStringBuilder.append(this.a);
      localStringBuilder.append("]");
      localV2TXLivePusherObserver.onError(i, localStringBuilder.toString(), new Bundle());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.live2.b.e.2
 * JD-Core Version:    0.7.0.1
 */
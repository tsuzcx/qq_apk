package com.tencent.live2.b;

import android.os.Bundle;
import com.tencent.live2.V2TXLivePusherObserver;

class f$6
  implements Runnable
{
  f$6(f paramf, V2TXLivePusherObserver paramV2TXLivePusherObserver, int paramInt, String paramString, Bundle paramBundle) {}
  
  public void run()
  {
    V2TXLivePusherObserver localV2TXLivePusherObserver = this.a;
    if (localV2TXLivePusherObserver != null)
    {
      int i = this.b;
      String str = this.c;
      Bundle localBundle2 = this.d;
      Bundle localBundle1 = localBundle2;
      if (localBundle2 == null) {
        localBundle1 = new Bundle();
      }
      localV2TXLivePusherObserver.onWarning(i, str, localBundle1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.live2.b.f.6
 * JD-Core Version:    0.7.0.1
 */
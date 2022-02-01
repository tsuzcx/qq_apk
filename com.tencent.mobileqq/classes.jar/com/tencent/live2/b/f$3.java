package com.tencent.live2.b;

import android.os.Bundle;
import com.tencent.live2.V2TXLiveDef.V2TXLivePushStatus;
import com.tencent.live2.V2TXLivePusherObserver;

class f$3
  implements Runnable
{
  f$3(f paramf, V2TXLivePusherObserver paramV2TXLivePusherObserver, String paramString, Bundle paramBundle) {}
  
  public void run()
  {
    V2TXLivePusherObserver localV2TXLivePusherObserver = this.a;
    V2TXLiveDef.V2TXLivePushStatus localV2TXLivePushStatus = V2TXLiveDef.V2TXLivePushStatus.V2TXLivePushStatusDisconnected;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("disconnect server reason:");
    localStringBuilder.append(this.b);
    localV2TXLivePusherObserver.onPushStatusUpdate(localV2TXLivePushStatus, localStringBuilder.toString(), this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.live2.b.f.3
 * JD-Core Version:    0.7.0.1
 */
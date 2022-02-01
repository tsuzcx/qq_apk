package com.tencent.live2.b;

import android.os.Bundle;
import com.tencent.live2.V2TXLiveDef.V2TXLivePlayStatus;
import com.tencent.live2.V2TXLiveDef.V2TXLivePushStatus;
import com.tencent.live2.V2TXLiveDef.V2TXLiveStatusChangeReason;
import com.tencent.live2.V2TXLivePusherObserver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class f$20
  implements Runnable
{
  f$20(f paramf) {}
  
  public void run()
  {
    f.a(this.a, false);
    f.a(this.a, "onConnectionRecovery");
    Object localObject = f.b(this.a);
    if (localObject != null) {
      ((V2TXLivePusherObserver)localObject).onPushStatusUpdate(V2TXLiveDef.V2TXLivePushStatus.V2TXLivePushStatusConnectSuccess, "connect server success.", new Bundle());
    }
    localObject = new ArrayList();
    ((List)localObject).addAll(f.c(this.a).values());
    ((List)localObject).addAll(f.d(this.a).values());
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      f.b localb = (f.b)((Iterator)localObject).next();
      if ((localb != null) && (localb.a != null))
      {
        f.a(this.a, localb.a.b(), V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusPlaying, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonBufferingEnd);
        f.a(this.a, localb.a.b(), localb.a.c(), V2TXLiveDef.V2TXLivePlayStatus.V2TXLivePlayStatusPlaying, V2TXLiveDef.V2TXLiveStatusChangeReason.V2TXLiveStatusChangeReasonBufferingEnd);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.live2.b.f.20
 * JD-Core Version:    0.7.0.1
 */
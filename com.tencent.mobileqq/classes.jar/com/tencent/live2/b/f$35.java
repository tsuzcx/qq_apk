package com.tencent.live2.b;

import android.os.Bundle;
import com.tencent.live2.V2TXLiveDef.V2TXLivePushStatus;
import com.tencent.live2.V2TXLivePlayerObserver;
import com.tencent.live2.V2TXLivePusherObserver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class f$35
  implements Runnable
{
  f$35(f paramf, long paramLong, V2TXLivePusherObserver paramV2TXLivePusherObserver, String paramString, int paramInt) {}
  
  public void run()
  {
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putInt("code", (int)this.a);
    Object localObject2 = this.b;
    if (localObject2 != null) {
      ((V2TXLivePusherObserver)localObject2).onPushStatusUpdate(V2TXLiveDef.V2TXLivePushStatus.V2TXLivePushStatusDisconnected, this.c, (Bundle)localObject1);
    }
    localObject2 = new ArrayList();
    ((List)localObject2).addAll(f.c(this.e).values());
    ((List)localObject2).addAll(f.d(this.e).values());
    localObject2 = ((List)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      f.b localb = (f.b)((Iterator)localObject2).next();
      if ((localb != null) && (localb.g != null) && (localb.f != null)) {
        localb.f.onError(localb.g, this.d, this.c, (Bundle)localObject1);
      }
    }
    localObject1 = f.e(this.e);
    if (localObject1 != null) {
      ((f.a)localObject1).a(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.live2.b.f.35
 * JD-Core Version:    0.7.0.1
 */
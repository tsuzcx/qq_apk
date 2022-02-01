package com.tencent.ad.tangram.net;

import android.content.Context;
import java.lang.ref.WeakReference;

class AdIPV4$3
  implements Runnable
{
  AdIPV4$3(AdIPV4 paramAdIPV4, WeakReference paramWeakReference) {}
  
  public void run()
  {
    AdIPV4.access$302(this.this$0, System.currentTimeMillis());
    AdIPV4 localAdIPV4 = this.this$0;
    AdIPV4.a locala = AdIPV4.access$200(localAdIPV4);
    Object localObject = this.val$appContext;
    if (localObject != null) {
      localObject = (Context)((WeakReference)localObject).get();
    } else {
      localObject = null;
    }
    AdIPV4.access$002(localAdIPV4, locala.getCacheByIPC((Context)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.net.AdIPV4.3
 * JD-Core Version:    0.7.0.1
 */
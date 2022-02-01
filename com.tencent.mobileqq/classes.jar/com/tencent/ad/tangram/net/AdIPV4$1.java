package com.tencent.ad.tangram.net;

import android.content.Context;
import android.text.TextUtils;
import java.lang.ref.WeakReference;

class AdIPV4$1
  implements Runnable
{
  AdIPV4$1(AdIPV4 paramAdIPV4, WeakReference paramWeakReference) {}
  
  public void run()
  {
    AdIPV4.access$002(this.this$0, new AdIPV4.Address());
    AdIPV4.Address localAddress = AdIPV4.access$000(this.this$0);
    Object localObject = this.val$weakContext;
    if (localObject != null) {
      localObject = (Context)((WeakReference)localObject).get();
    } else {
      localObject = null;
    }
    localAddress.ip = AdIPV4.access$100((Context)localObject);
    if (!TextUtils.isEmpty(AdIPV4.access$000(this.this$0).ip)) {
      AdIPV4.access$000(this.this$0).timeMillis = System.currentTimeMillis();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.net.AdIPV4.1
 * JD-Core Version:    0.7.0.1
 */
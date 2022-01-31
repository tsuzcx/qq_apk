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
    AdIPV4.access$002(this.this$0, new AdIPV4.a());
    AdIPV4.a locala = AdIPV4.access$000(this.this$0);
    if (this.val$weakContext != null) {}
    for (Context localContext = (Context)this.val$weakContext.get();; localContext = null)
    {
      locala.ip = AdIPV4.access$100(localContext);
      if (!TextUtils.isEmpty(AdIPV4.access$000(this.this$0).ip)) {
        AdIPV4.access$000(this.this$0).timeMillis = System.currentTimeMillis();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.net.AdIPV4.1
 * JD-Core Version:    0.7.0.1
 */
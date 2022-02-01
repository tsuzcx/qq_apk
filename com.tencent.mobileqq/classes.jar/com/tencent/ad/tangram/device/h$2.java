package com.tencent.ad.tangram.device;

import android.content.Context;
import com.tencent.ad.tangram.log.AdLog;
import java.lang.ref.WeakReference;

class h$2
  implements Runnable
{
  h$2(h paramh, WeakReference paramWeakReference) {}
  
  public void run()
  {
    boolean bool = h.access$300(this.this$0, (Context)this.val$appContext.get(), h.access$100(this.this$0));
    if (h.access$100(this.this$0) != null) {}
    for (String str = h.access$100(this.this$0).toString();; str = null)
    {
      AdLog.i("AdDeviceInfoCache", String.format("flush %b %s", new Object[] { Boolean.valueOf(bool), str }));
      h.access$200(this.this$0, 2);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.device.h.2
 * JD-Core Version:    0.7.0.1
 */
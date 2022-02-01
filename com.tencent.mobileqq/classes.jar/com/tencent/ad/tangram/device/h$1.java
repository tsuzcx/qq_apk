package com.tencent.ad.tangram.device;

import android.content.Context;
import com.tencent.ad.tangram.log.AdLog;
import java.lang.ref.WeakReference;

class h$1
  implements Runnable
{
  h$1(h paramh, WeakReference paramWeakReference) {}
  
  public void run()
  {
    h.a locala = h.access$000((Context)this.val$appContext.get());
    if (locala != null) {}
    for (String str = locala.toString();; str = null)
    {
      AdLog.i("AdDeviceInfoCache", String.format("init %s", new Object[] { str }));
      h.access$100(this.this$0).fill(locala);
      h.access$200(this.this$0, 2);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.device.h.1
 * JD-Core Version:    0.7.0.1
 */
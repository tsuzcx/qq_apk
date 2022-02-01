package com.tencent.ad.tangram.loader;

import com.tencent.ad.tangram.log.AdLog;
import java.lang.ref.WeakReference;

class AdLoader$1$1
  implements Runnable
{
  AdLoader$1$1(AdLoader.1 param1) {}
  
  public void run()
  {
    if ((this.this$0.val$listener != null) && (this.this$0.val$listener.get() != null))
    {
      AdLog.i("AdLoader", "load notify");
      ((AdLoader.Listener)this.this$0.val$listener.get()).onResponse(this.this$0.val$session);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.loader.AdLoader.1.1
 * JD-Core Version:    0.7.0.1
 */
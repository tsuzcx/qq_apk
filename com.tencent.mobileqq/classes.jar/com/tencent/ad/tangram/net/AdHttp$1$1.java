package com.tencent.ad.tangram.net;

import java.lang.ref.WeakReference;

class AdHttp$1$1
  implements Runnable
{
  AdHttp$1$1(AdHttp.1 param1) {}
  
  public void run()
  {
    if ((this.this$0.val$listener != null) && (this.this$0.val$listener.get() != null)) {
      ((AdHttp.a)this.this$0.val$listener.get()).onResponse(this.this$0.val$params);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.net.AdHttp.1.1
 * JD-Core Version:    0.7.0.1
 */
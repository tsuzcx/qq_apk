package com.tencent.ad.tangram.net;

import android.content.Context;
import java.lang.ref.WeakReference;

class a$3
  implements Runnable
{
  a$3(a parama, WeakReference paramWeakReference) {}
  
  public void run()
  {
    a.access$302(this.this$0, System.currentTimeMillis());
    a locala = this.this$0;
    a.b localb = a.access$200(this.this$0);
    if (this.val$appContext != null) {}
    for (Context localContext = (Context)this.val$appContext.get();; localContext = null)
    {
      a.access$002(locala, localb.getCacheByIPC(localContext));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.net.a.3
 * JD-Core Version:    0.7.0.1
 */
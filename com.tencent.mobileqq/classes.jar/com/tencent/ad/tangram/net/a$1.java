package com.tencent.ad.tangram.net;

import android.content.Context;
import android.text.TextUtils;
import java.lang.ref.WeakReference;

class a$1
  implements Runnable
{
  a$1(a parama, WeakReference paramWeakReference) {}
  
  public void run()
  {
    a.access$002(this.this$0, new a.a());
    a.a locala = a.access$000(this.this$0);
    if (this.val$weakContext != null) {}
    for (Context localContext = (Context)this.val$weakContext.get();; localContext = null)
    {
      locala.ip = a.access$100(localContext);
      if (!TextUtils.isEmpty(a.access$000(this.this$0).ip)) {
        a.access$000(this.this$0).timeMillis = System.currentTimeMillis();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.net.a.1
 * JD-Core Version:    0.7.0.1
 */
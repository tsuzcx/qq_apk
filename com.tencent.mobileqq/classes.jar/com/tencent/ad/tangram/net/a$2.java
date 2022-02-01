package com.tencent.ad.tangram.net;

import android.content.Context;
import java.lang.ref.WeakReference;

class a$2
  implements Runnable
{
  a$2(a parama, WeakReference paramWeakReference) {}
  
  public void run()
  {
    a locala = this.this$0;
    a.b localb = a.access$200(locala);
    Object localObject = this.val$appContext;
    if (localObject != null) {
      localObject = (Context)((WeakReference)localObject).get();
    } else {
      localObject = null;
    }
    a.access$002(locala, localb.getCacheByIPC((Context)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.net.a.2
 * JD-Core Version:    0.7.0.1
 */
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
    Object localObject = this.val$weakContext;
    if (localObject != null) {
      localObject = (Context)((WeakReference)localObject).get();
    } else {
      localObject = null;
    }
    locala.ip = a.access$100((Context)localObject);
    if (!TextUtils.isEmpty(a.access$000(this.this$0).ip)) {
      a.access$000(this.this$0).timeMillis = System.currentTimeMillis();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.net.a.1
 * JD-Core Version:    0.7.0.1
 */
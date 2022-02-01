package com.tencent.ad.tangram.views.form.framework;

import com.tencent.ad.tangram.views.form.AdFormError;
import java.lang.ref.WeakReference;

class b$1$1
  implements Runnable
{
  b$1$1(b.1 param1, AdFormError paramAdFormError) {}
  
  public void run()
  {
    if ((this.this$0.val$listener != null) && (this.this$0.val$listener.get() != null)) {
      ((a)this.this$0.val$listener.get()).afterCommit(this.val$error);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.form.framework.b.1.1
 * JD-Core Version:    0.7.0.1
 */
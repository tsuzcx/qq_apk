package com.tencent.ad.tangram.views.button;

import java.lang.ref.WeakReference;

class a$5
  implements Runnable
{
  a$5(a parama) {}
  
  public void run()
  {
    if ((a.access$300(this.this$0) != null) && (a.access$300(this.this$0).get() != null)) {
      ((IAdButtonView.a)a.access$300(this.this$0).get()).onViewCreated(new WeakReference(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.button.a.5
 * JD-Core Version:    0.7.0.1
 */
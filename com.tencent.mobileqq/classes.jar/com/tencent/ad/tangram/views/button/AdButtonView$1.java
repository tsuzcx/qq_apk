package com.tencent.ad.tangram.views.button;

import java.lang.ref.WeakReference;

class AdButtonView$1
  implements Runnable
{
  AdButtonView$1(AdButtonView paramAdButtonView) {}
  
  public void run()
  {
    if ((AdButtonView.access$000(this.this$0) != null) && (AdButtonView.access$000(this.this$0).get() != null)) {
      ((IAdButtonView.a)AdButtonView.access$000(this.this$0).get()).onViewCreated(new WeakReference(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.button.AdButtonView.1
 * JD-Core Version:    0.7.0.1
 */
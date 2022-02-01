package com.tencent.ad.tangram.views.form.framework;

import android.view.ViewTreeObserver;

class h$1$1
  implements Runnable
{
  h$1$1(h.1 param1) {}
  
  public void run()
  {
    if ((h.access$000(this.this$1.this$0) != null) && (this.this$1.this$0.getViewTreeObserver() != null))
    {
      this.this$1.this$0.getViewTreeObserver().removeOnGlobalLayoutListener(h.access$000(this.this$1.this$0));
      h.access$002(this.this$1.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.form.framework.h.1.1
 * JD-Core Version:    0.7.0.1
 */
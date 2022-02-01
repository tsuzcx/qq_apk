package com.tencent.ad.tangram.canvas.views.form.framework;

import android.view.ViewTreeObserver;

class c$1$1
  implements Runnable
{
  c$1$1(c.1 param1) {}
  
  public void run()
  {
    if ((c.access$000(this.this$1.this$0) != null) && (this.this$1.this$0.getViewTreeObserver() != null))
    {
      this.this$1.this$0.getViewTreeObserver().removeOnGlobalLayoutListener(c.access$000(this.this$1.this$0));
      c.access$002(this.this$1.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.form.framework.c.1.1
 * JD-Core Version:    0.7.0.1
 */
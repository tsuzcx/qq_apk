package com.tencent.ad.tangram.canvas.views.canvas.components.form;

import android.view.View;
import android.view.View.OnFocusChangeListener;

class b$2
  implements Runnable
{
  b$2(b paramb) {}
  
  public void run()
  {
    b.access$000(this.this$0).requestFocus();
    if (b.access$000(this.this$0).getOnFocusChangeListener() != null) {
      b.access$000(this.this$0).getOnFocusChangeListener().onFocusChange(b.access$000(this.this$0), true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.canvas.components.form.b.2
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.ad.tangram.canvas.views.canvas.components.form;

import android.view.View;
import com.tencent.ad.tangram.canvas.views.canvas.framework.AdCanvasViewListener;
import java.lang.ref.WeakReference;

class b$1
  implements Runnable
{
  b$1(b paramb, int paramInt, View paramView) {}
  
  public void run()
  {
    int[] arrayOfInt = new int[2];
    b.access$000(this.this$0).getLocationOnScreen(arrayOfInt);
    if (arrayOfInt[1] == b.access$100(this.this$0))
    {
      ((AdCanvasViewListener)b.access$200(this.this$0).get()).setPageViewTopMargin(this.val$topMargin);
      return;
    }
    b.access$300(this.this$0, this.val$mChildOfContent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.canvas.components.form.b.1
 * JD-Core Version:    0.7.0.1
 */
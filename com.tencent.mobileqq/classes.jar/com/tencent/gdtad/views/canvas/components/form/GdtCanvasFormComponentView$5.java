package com.tencent.gdtad.views.canvas.components.form;

import com.tencent.mobileqq.activity.aio.item.ArkAppView;
import java.lang.ref.WeakReference;
import zag;

class GdtCanvasFormComponentView$5
  implements Runnable
{
  GdtCanvasFormComponentView$5(GdtCanvasFormComponentView paramGdtCanvasFormComponentView, int paramInt) {}
  
  public void run()
  {
    int[] arrayOfInt = new int[2];
    GdtCanvasFormComponentView.a(this.this$0).getLocationOnScreen(arrayOfInt);
    if (arrayOfInt[1] == GdtCanvasFormComponentView.a(this.this$0))
    {
      ((zag)GdtCanvasFormComponentView.d(this.this$0).get()).setPageViewTopMargin(this.a);
      return;
    }
    GdtCanvasFormComponentView.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.components.form.GdtCanvasFormComponentView.5
 * JD-Core Version:    0.7.0.1
 */
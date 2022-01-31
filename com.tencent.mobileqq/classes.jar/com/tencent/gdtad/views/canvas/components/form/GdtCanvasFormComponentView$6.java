package com.tencent.gdtad.views.canvas.components.form;

import android.view.View.OnFocusChangeListener;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;

class GdtCanvasFormComponentView$6
  implements Runnable
{
  GdtCanvasFormComponentView$6(GdtCanvasFormComponentView paramGdtCanvasFormComponentView) {}
  
  public void run()
  {
    GdtCanvasFormComponentView.a(this.this$0).requestFocus();
    if (GdtCanvasFormComponentView.a(this.this$0).getOnFocusChangeListener() != null) {
      GdtCanvasFormComponentView.a(this.this$0).getOnFocusChangeListener().onFocusChange(GdtCanvasFormComponentView.a(this.this$0), true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.components.form.GdtCanvasFormComponentView.6
 * JD-Core Version:    0.7.0.1
 */
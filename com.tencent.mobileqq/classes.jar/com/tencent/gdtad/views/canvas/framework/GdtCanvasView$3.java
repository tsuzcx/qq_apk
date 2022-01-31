package com.tencent.gdtad.views.canvas.framework;

import android.widget.PopupWindow;

class GdtCanvasView$3
  implements Runnable
{
  GdtCanvasView$3(GdtCanvasView paramGdtCanvasView) {}
  
  public void run()
  {
    if ((GdtCanvasView.a(this.this$0) != null) && (GdtCanvasView.a(this.this$0).isShowing())) {
      GdtCanvasView.a(this.this$0).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.framework.GdtCanvasView.3
 * JD-Core Version:    0.7.0.1
 */
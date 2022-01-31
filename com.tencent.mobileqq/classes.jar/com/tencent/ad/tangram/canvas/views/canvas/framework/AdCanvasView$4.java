package com.tencent.ad.tangram.canvas.views.canvas.framework;

import android.widget.PopupWindow;

class AdCanvasView$4
  implements Runnable
{
  AdCanvasView$4(AdCanvasView paramAdCanvasView) {}
  
  public void run()
  {
    if ((AdCanvasView.access$100(this.this$0) != null) && (AdCanvasView.access$100(this.this$0).isShowing())) {
      AdCanvasView.access$100(this.this$0).dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.canvas.framework.AdCanvasView.4
 * JD-Core Version:    0.7.0.1
 */
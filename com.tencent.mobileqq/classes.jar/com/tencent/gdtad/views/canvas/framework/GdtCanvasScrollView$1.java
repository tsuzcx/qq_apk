package com.tencent.gdtad.views.canvas.framework;

class GdtCanvasScrollView$1
  implements Runnable
{
  GdtCanvasScrollView$1(GdtCanvasScrollView paramGdtCanvasScrollView) {}
  
  public void run()
  {
    if (GdtCanvasScrollView.a(this.this$0) != this.this$0.getScrollY())
    {
      GdtCanvasScrollView.a(this.this$0, this.this$0.getScrollY());
      this.this$0.postDelayed(GdtCanvasScrollView.a(this.this$0), 100L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.framework.GdtCanvasScrollView.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.gdtad.views.canvas.components.picture;

import android.text.TextUtils;
import yob;

class GdtCanvasPictureComponentView$2
  implements Runnable
{
  GdtCanvasPictureComponentView$2(GdtCanvasPictureComponentView paramGdtCanvasPictureComponentView, GdtCanvasPictureComponentData paramGdtCanvasPictureComponentData) {}
  
  public void run()
  {
    if (!TextUtils.isEmpty(this.a.actionUrl)) {
      yob.a(this.this$0.getContext(), this.a.actionUrl);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.views.canvas.components.picture.GdtCanvasPictureComponentView.2
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz.qqcircle.bizparts.danmaku.text;

import android.graphics.Typeface;
import android.view.View;

class TextCellLayout$4$1
  implements Runnable
{
  TextCellLayout$4$1(TextCellLayout.4 param4, Typeface paramTypeface) {}
  
  public void run()
  {
    TextCellLayout.a(this.b.b, this.a);
    View localView = TextCellLayout.a(this.b.b).getAttachedView();
    if (localView != null)
    {
      this.b.b.i();
      localView.requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.text.TextCellLayout.4.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz.qqcircle.bizparts.danmaku.text;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.view.View;

class TextCellLayout$2
  implements Drawable.Callback
{
  TextCellLayout$2(TextCellLayout paramTextCellLayout) {}
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    this.a.n();
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    if (TextCellLayout.a(this.a) != null)
    {
      View localView = TextCellLayout.a(this.a).getAttachedView();
      if (localView != null) {
        localView.scheduleDrawable(paramDrawable, paramRunnable, paramLong);
      }
    }
  }
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    if (TextCellLayout.a(this.a) != null)
    {
      View localView = TextCellLayout.a(this.a).getAttachedView();
      if (localView != null) {
        localView.unscheduleDrawable(paramDrawable, paramRunnable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.text.TextCellLayout.2
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.ui.base;

import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class MMClearEditText$3
  implements View.OnTouchListener
{
  MMClearEditText$3(MMClearEditText paramMMClearEditText) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = this.a;
    if (paramView.getCompoundDrawables()[2] == null) {
      return false;
    }
    if (paramMotionEvent.getAction() != 1) {
      return false;
    }
    if (paramMotionEvent.getX() > paramView.getWidth() - paramView.getPaddingRight() - this.a.c.getIntrinsicWidth())
    {
      paramView.setText("");
      MMClearEditText.c(this.a);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.MMClearEditText.3
 * JD-Core Version:    0.7.0.1
 */
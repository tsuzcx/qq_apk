package com.tencent.mm.ui.widget.textview;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.ui.f;

class SelectableTextHelper$7
  implements View.OnTouchListener
{
  SelectableTextHelper$7(SelectableTextHelper paramSelectableTextHelper) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    f.b("SelectableTextHelper", "event pointer count: %d.", new Object[] { Integer.valueOf(paramMotionEvent.getPointerCount()) });
    if (SelectableTextHelper.m(this.a) != null) {
      SelectableTextHelper.m(this.a).onTouch(paramView, paramMotionEvent);
    }
    SelectableTextHelper.b(this.a, (int)paramMotionEvent.getX());
    SelectableTextHelper.c(this.a, (int)paramMotionEvent.getY());
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.textview.SelectableTextHelper.7
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.ui.widget.textview;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.ui.f;

class SelectableTextHelper$8
  implements View.OnTouchListener
{
  SelectableTextHelper$8(SelectableTextHelper paramSelectableTextHelper) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    f.b("SelectableTextHelper", "interceptor onTouch.", new Object[0]);
    int i = (int)paramMotionEvent.getX();
    int j = (int)paramMotionEvent.getY();
    if ((paramMotionEvent.getAction() == 0) && ((i < 0) || (i >= SelectableTextHelper.n(this.a).getWidth()) || (j < 0) || (j >= SelectableTextHelper.n(this.a).getHeight())))
    {
      f.b("SelectableTextHelper", "interceptor onTouch, down, outside.", new Object[0]);
      SelectableTextHelper.f(this.a).postDelayed(SelectableTextHelper.j(this.a), 100L);
      return true;
    }
    if (paramMotionEvent.getAction() == 4)
    {
      f.b("SelectableTextHelper", "interceptor onTouch, outside.", new Object[0]);
      SelectableTextHelper.f(this.a).postDelayed(SelectableTextHelper.j(this.a), 100L);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.textview.SelectableTextHelper.8
 * JD-Core Version:    0.7.0.1
 */
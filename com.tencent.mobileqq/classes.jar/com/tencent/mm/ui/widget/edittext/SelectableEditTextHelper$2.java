package com.tencent.mm.ui.widget.edittext;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.TextView;
import com.tencent.mm.ui.f;

class SelectableEditTextHelper$2
  implements View.OnTouchListener
{
  SelectableEditTextHelper$2(SelectableEditTextHelper paramSelectableEditTextHelper) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool;
    if (SelectableEditTextHelper.g(this.a) != null) {
      bool = SelectableEditTextHelper.g(this.a).onTouch(paramView, paramMotionEvent);
    } else {
      bool = false;
    }
    if (SelectableEditTextHelper.b(this.a))
    {
      SelectableEditTextHelper.a(this.a, (int)paramMotionEvent.getX());
      SelectableEditTextHelper.b(this.a, (int)paramMotionEvent.getY());
      int i = paramMotionEvent.getAction();
      if (i != 0)
      {
        if (i != 1)
        {
          if ((i == 2) && (SelectableEditTextHelper.j(this.a) != SelectableEditTextHelper.k(this.a).getScrollY()))
          {
            SelectableEditTextHelper.b(this.a, true);
            if ((!SelectableEditTextHelper.l(this.a)) && (!SelectableEditTextHelper.m(this.a)))
            {
              SelectableEditTextHelper.c(this.a, true);
              paramView = this.a;
              SelectableEditTextHelper.a(paramView, SelectableEditTextHelper.n(paramView));
              paramView = this.a;
              SelectableEditTextHelper.a(paramView, SelectableEditTextHelper.o(paramView));
              paramView = this.a;
              SelectableEditTextHelper.a(paramView, SelectableEditTextHelper.p(paramView));
            }
          }
        }
        else if (SelectableEditTextHelper.c(this.a))
        {
          SelectableEditTextHelper.b(this.a, false);
          if (SelectableEditTextHelper.l(this.a))
          {
            SelectableEditTextHelper.c(this.a, false);
            SelectableEditTextHelper.q(this.a).run();
          }
          return true;
        }
      }
      else
      {
        SelectableEditTextHelper.a(this.a, false);
        if (SelectableEditTextHelper.h(this.a))
        {
          f.c("SelectableEditTextHelper", "tryGetMenus", new Object[0]);
          SelectableEditTextHelper.i(this.a);
        }
      }
      paramView = this.a;
      SelectableEditTextHelper.c(paramView, SelectableEditTextHelper.k(paramView).getScrollY());
      return false;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.edittext.SelectableEditTextHelper.2
 * JD-Core Version:    0.7.0.1
 */
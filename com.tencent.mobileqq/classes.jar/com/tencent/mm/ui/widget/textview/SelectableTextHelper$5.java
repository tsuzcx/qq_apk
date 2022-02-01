package com.tencent.mm.ui.widget.textview;

import android.view.View;
import android.view.ViewTreeObserver.OnScrollChangedListener;
import com.tencent.mm.ui.f;

class SelectableTextHelper$5
  implements ViewTreeObserver.OnScrollChangedListener
{
  SelectableTextHelper$5(SelectableTextHelper paramSelectableTextHelper) {}
  
  public void onScrollChanged()
  {
    if (SelectableTextHelper.d(this.a) != null)
    {
      SelectableTextHelper.f(this.a).removeCallbacks(SelectableTextHelper.j(this.a));
      SelectableTextHelper.f(this.a).getLocationInWindow(SelectableTextHelper.k(this.a));
      f.b("SelectableTextHelper", "onScrollChanged, old-y: %d, y: %d.", new Object[] { Integer.valueOf(SelectableTextHelper.l(this.a)[1]), Integer.valueOf(SelectableTextHelper.k(this.a)[1]) });
      if (SelectableTextHelper.b(this.a)) {
        if ((!SelectableTextHelper.c(this.a)) && (!SelectableTextHelper.g(this.a)))
        {
          if (SelectableTextHelper.l(this.a)[1] != SelectableTextHelper.k(this.a)[1])
          {
            SelectableTextHelper.b(this.a, true);
            SelectableTextHelper.a(this.a, false);
            f.b("SelectableTextHelper", "judge result, inScrolling.", new Object[0]);
          }
          else
          {
            SelectableTextHelper.c(this.a, true);
            f.b("SelectableTextHelper", "need delay judge.", new Object[0]);
          }
        }
        else if (SelectableTextHelper.g(this.a))
        {
          SelectableTextHelper.c(this.a, false);
          SelectableTextHelper.a(this.a, false);
          if (SelectableTextHelper.l(this.a)[1] != SelectableTextHelper.k(this.a)[1])
          {
            SelectableTextHelper.b(this.a, true);
            f.b("SelectableTextHelper", "judge result(delay), inScrolling.", new Object[0]);
          }
          else
          {
            SelectableTextHelper.b(this.a, false);
            f.b("SelectableTextHelper", "judge result, click outside.", new Object[0]);
          }
        }
      }
      SelectableTextHelper.l(this.a)[1] = SelectableTextHelper.k(this.a)[1];
    }
    if ((!SelectableTextHelper.i(this.a)) && ((!this.a.menuIsHide()) || (!this.a.cursorIsHide())))
    {
      SelectableTextHelper.d(this.a, true);
      this.a.hideSelectView();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.textview.SelectableTextHelper.5
 * JD-Core Version:    0.7.0.1
 */
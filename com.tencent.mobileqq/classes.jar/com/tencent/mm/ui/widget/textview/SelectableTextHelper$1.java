package com.tencent.mm.ui.widget.textview;

import com.tencent.mm.ui.f;

class SelectableTextHelper$1
  implements Runnable
{
  SelectableTextHelper$1(SelectableTextHelper paramSelectableTextHelper) {}
  
  public void run()
  {
    if (SelectableTextHelper.a(this.a))
    {
      f.b("SelectableTextHelper", "isReInit, return.", new Object[0]);
      return;
    }
    f.b("SelectableTextHelper", "in mShowSelectViewRunnable. opener: %s, inScrolling: %s.", new Object[] { Boolean.valueOf(SelectableTextHelper.b(this.a)), Boolean.valueOf(SelectableTextHelper.c(this.a)) });
    if (SelectableTextHelper.d(this.a) != null)
    {
      if (!SelectableTextHelper.b(this.a))
      {
        SelectableTextHelper.a(this.a, true);
        if (SelectableTextHelper.c(this.a))
        {
          f.b("SelectableTextHelper", "menu is hide: %s, cursor is hide: %s.", new Object[] { Boolean.valueOf(this.a.menuIsHide()), Boolean.valueOf(this.a.cursorIsHide()) });
          if (!this.a.menuIsHide()) {
            this.a.showOperateMenu();
          }
          if (!this.a.cursorIsHide())
          {
            this.a.showCursorHandle();
            SelectableTextHelper localSelectableTextHelper = this.a;
            localSelectableTextHelper.selectText(SelectableTextHelper.e(localSelectableTextHelper).a, SelectableTextHelper.e(this.a).b);
          }
          if ((SelectableTextHelper.d(this.a) != null) && (this.a.menuIsHide()) && (!this.a.cursorIsHide())) {
            SelectableTextHelper.d(this.a).open(SelectableTextHelper.f(this.a));
          }
        }
        SelectableTextHelper.b(this.a, false);
        return;
      }
      if (SelectableTextHelper.g(this.a))
      {
        SelectableTextHelper.c(this.a, false);
        f.b("SelectableTextHelper", "judge result(delay), click outside.", new Object[0]);
        if (SelectableTextHelper.h(this.a) != null) {
          SelectableTextHelper.h(this.a).touchOutside();
        }
      }
      else
      {
        f.b("SelectableTextHelper", "Oh, bypass the judge logic! Don't worry, that's reasonable.", new Object[0]);
      }
    }
    else
    {
      if (!this.a.menuIsHide()) {
        this.a.showOperateMenu();
      }
      if (!this.a.cursorIsHide()) {
        this.a.showCursorHandle();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.textview.SelectableTextHelper.1
 * JD-Core Version:    0.7.0.1
 */
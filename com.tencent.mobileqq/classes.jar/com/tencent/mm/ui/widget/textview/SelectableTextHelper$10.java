package com.tencent.mm.ui.widget.textview;

import android.text.SpannableString;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mm.ui.f;

class SelectableTextHelper$10
  implements View.OnLongClickListener
{
  SelectableTextHelper$10(SelectableTextHelper paramSelectableTextHelper) {}
  
  public boolean onLongClick(View paramView)
  {
    f.b("SelectableTextHelper", "onLongClick.", new Object[0]);
    SelectableTextHelper.e(this.a, false);
    if (SelectableTextHelper.d(this.a) != null)
    {
      SelectableTextHelper.a(this.a, true);
      SelectableTextHelper.b(this.a, false);
      SelectableTextHelper.c(this.a, false);
      Object localObject = TextLayoutUtil.getText(SelectableTextHelper.f(this.a));
      if ((localObject instanceof SpannableString)) {
        SelectableTextHelper.a(this.a, (SpannableString)localObject);
      }
      this.a.hideSelectView();
      if ((SelectableTextHelper.p(this.a) > 0) && (SelectableTextHelper.p(this.a) < TextLayoutUtil.getText(SelectableTextHelper.f(this.a)).length()))
      {
        paramView = this.a;
        SelectableTextHelper.a(paramView, 0, SelectableTextHelper.p(paramView));
        this.a.setMenuHide(false);
        this.a.setCursorHide(false);
        this.a.showOperateMenu();
        this.a.showCursorHandle();
        return true;
      }
      localObject = this.a;
      SelectableTextHelper.a((SelectableTextHelper)localObject, 0, TextLayoutUtil.getText(SelectableTextHelper.f((SelectableTextHelper)localObject)).length());
      this.a.setMenuHide(true);
      this.a.setCursorHide(false);
      this.a.showCursorHandle();
      SelectableTextHelper.d(this.a).onLongClick(paramView);
      return true;
    }
    SelectableTextHelper.a(this.a, false);
    paramView = this.a;
    SelectableTextHelper.b(paramView, SelectableTextHelper.q(paramView), SelectableTextHelper.r(this.a));
    this.a.hideSelectView();
    this.a.setMenuHide(false);
    this.a.setCursorHide(false);
    this.a.showOperateMenu();
    this.a.showCursorHandle();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.textview.SelectableTextHelper.10
 * JD-Core Version:    0.7.0.1
 */
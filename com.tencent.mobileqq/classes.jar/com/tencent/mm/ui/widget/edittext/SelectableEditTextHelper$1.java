package com.tencent.mm.ui.widget.edittext;

import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.mm.ui.f;

class SelectableEditTextHelper$1
  implements View.OnLongClickListener
{
  SelectableEditTextHelper$1(SelectableEditTextHelper paramSelectableEditTextHelper) {}
  
  public boolean onLongClick(View paramView)
  {
    boolean bool;
    if (SelectableEditTextHelper.a(this.a) != null) {
      bool = SelectableEditTextHelper.a(this.a).onLongClick(paramView);
    } else {
      bool = false;
    }
    if (SelectableEditTextHelper.b(this.a))
    {
      paramView = new StringBuilder();
      paramView.append("onLongClick:");
      paramView.append(SelectableEditTextHelper.c(this.a));
      f.c("SelectableEditTextHelper", paramView.toString(), new Object[0]);
      SelectableEditTextHelper.d(this.a);
      if (SelectableEditTextHelper.c(this.a)) {
        return false;
      }
      paramView = this.a;
      SelectableEditTextHelper.a(paramView, SelectableEditTextHelper.e(paramView), SelectableEditTextHelper.f(this.a));
      bool = true;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.edittext.SelectableEditTextHelper.1
 * JD-Core Version:    0.7.0.1
 */
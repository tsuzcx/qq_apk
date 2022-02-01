package com.tencent.mm.ui.widget.edittext;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import com.tencent.mm.ui.f;

class SelectableEditTextHelper$4
  implements View.OnFocusChangeListener
{
  SelectableEditTextHelper$4(SelectableEditTextHelper paramSelectableEditTextHelper) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (SelectableEditTextHelper.b(this.a))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onFocusChange:");
      localStringBuilder.append(paramBoolean);
      f.b("SelectableEditTextHelper", localStringBuilder.toString(), new Object[0]);
      if (!paramBoolean) {
        this.a.a(false);
      }
    }
    if (SelectableEditTextHelper.s(this.a) != null) {
      SelectableEditTextHelper.s(this.a).onFocusChange(paramView, paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.edittext.SelectableEditTextHelper.4
 * JD-Core Version:    0.7.0.1
 */
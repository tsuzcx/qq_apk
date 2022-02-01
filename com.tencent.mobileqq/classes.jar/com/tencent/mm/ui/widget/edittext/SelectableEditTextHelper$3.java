package com.tencent.mm.ui.widget.edittext;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.f;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SelectableEditTextHelper$3
  implements View.OnClickListener
{
  SelectableEditTextHelper$3(SelectableEditTextHelper paramSelectableEditTextHelper) {}
  
  public void onClick(View paramView)
  {
    if (SelectableEditTextHelper.b(this.a))
    {
      f.c("SelectableEditTextHelper", "onClick", new Object[0]);
      this.a.a(true);
    }
    if (SelectableEditTextHelper.r(this.a) != null) {
      SelectableEditTextHelper.r(this.a).onClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.edittext.SelectableEditTextHelper.3
 * JD-Core Version:    0.7.0.1
 */
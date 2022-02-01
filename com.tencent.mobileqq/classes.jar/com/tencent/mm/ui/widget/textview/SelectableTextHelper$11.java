package com.tencent.mm.ui.widget.textview;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ui.f;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SelectableTextHelper$11
  implements View.OnClickListener
{
  SelectableTextHelper$11(SelectableTextHelper paramSelectableTextHelper) {}
  
  public void onClick(View paramView)
  {
    f.b("SelectableTextHelper", "onClick", new Object[0]);
    if (SelectableTextHelper.s(this.a) != null) {
      SelectableTextHelper.s(this.a).onClick(paramView);
    }
    this.a.setMenuHide(true);
    this.a.setCursorHide(true);
    this.a.hideSelectView();
    this.a.resetSelectionInfo();
    if (SelectableTextHelper.d(this.a) != null) {
      SelectableTextHelper.d(this.a).dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.textview.SelectableTextHelper.11
 * JD-Core Version:    0.7.0.1
 */
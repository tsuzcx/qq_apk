package com.tencent.mm.ui.widget.edittext;

import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class SelectableEditTextHelper$MyRecycleViewAdapter$1
  implements View.OnClickListener
{
  SelectableEditTextHelper$MyRecycleViewAdapter$1(SelectableEditTextHelper.MyRecycleViewAdapter paramMyRecycleViewAdapter) {}
  
  public void onClick(View paramView)
  {
    if ((paramView != null) || ((paramView.getTag() instanceof SelectableEditTextHelper.MenuItem)))
    {
      SelectableEditTextHelper.MenuItem localMenuItem = (SelectableEditTextHelper.MenuItem)paramView.getTag();
      String str;
      if (!TextUtils.isEmpty(SelectableEditTextHelper.MyRecycleViewAdapter.a(this.a).mSelectionContent)) {
        str = SelectableEditTextHelper.MyRecycleViewAdapter.a(this.a).mSelectionContent;
      } else {
        str = "";
      }
      SelectableEditTextHelper.MyRecycleViewAdapter.b(this.a).onMenuItemClicked(paramView, localMenuItem, str);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.edittext.SelectableEditTextHelper.MyRecycleViewAdapter.1
 * JD-Core Version:    0.7.0.1
 */
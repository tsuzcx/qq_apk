package com.tencent.mm.ui.widget.textview;

import android.view.View;
import android.widget.PopupWindow.OnDismissListener;

class SelectableTextHelper$9
  implements PopupWindow.OnDismissListener
{
  SelectableTextHelper$9(SelectableTextHelper paramSelectableTextHelper) {}
  
  public void onDismiss()
  {
    SelectableTextHelper.f(this.a).setOnTouchListener(SelectableTextHelper.o(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.textview.SelectableTextHelper.9
 * JD-Core Version:    0.7.0.1
 */
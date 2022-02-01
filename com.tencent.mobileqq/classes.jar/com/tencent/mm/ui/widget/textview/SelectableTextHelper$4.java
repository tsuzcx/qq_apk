package com.tencent.mm.ui.widget.textview;

import android.view.ViewTreeObserver.OnPreDrawListener;

class SelectableTextHelper$4
  implements ViewTreeObserver.OnPreDrawListener
{
  SelectableTextHelper$4(SelectableTextHelper paramSelectableTextHelper) {}
  
  public boolean onPreDraw()
  {
    if (SelectableTextHelper.i(this.a))
    {
      SelectableTextHelper.d(this.a, false);
      SelectableTextHelper.a(this.a, 100);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.textview.SelectableTextHelper.4
 * JD-Core Version:    0.7.0.1
 */
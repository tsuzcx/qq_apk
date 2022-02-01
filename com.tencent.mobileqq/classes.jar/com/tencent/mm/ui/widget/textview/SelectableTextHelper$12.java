package com.tencent.mm.ui.widget.textview;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.mm.ui.f;

class SelectableTextHelper$12
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  SelectableTextHelper$12(SelectableTextHelper paramSelectableTextHelper) {}
  
  public void onGlobalLayout()
  {
    SelectableTextHelper.f(this.a).getViewTreeObserver().removeOnGlobalLayoutListener(this);
    if (SelectableTextHelper.d(this.a) != null)
    {
      SelectableTextHelper.f(this.a).getLocationInWindow(SelectableTextHelper.l(this.a));
      f.b("SelectableTextHelper", "init: loc-x: %d, loc-y: %d.", new Object[] { Integer.valueOf(SelectableTextHelper.l(this.a)[0]), Integer.valueOf(SelectableTextHelper.l(this.a)[1]) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.textview.SelectableTextHelper.12
 * JD-Core Version:    0.7.0.1
 */
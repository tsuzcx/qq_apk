package com.tencent.mm.ui.widget.edittext;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.mm.ui.f;

class SelectableEditTextHelper$6
  implements View.OnAttachStateChangeListener
{
  SelectableEditTextHelper$6(SelectableEditTextHelper paramSelectableEditTextHelper) {}
  
  public void onViewAttachedToWindow(View paramView) {}
  
  public void onViewDetachedFromWindow(View paramView)
  {
    f.b("SelectableEditTextHelper", "onViewDetachedFromWindow:", new Object[0]);
    this.a.destroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.edittext.SelectableEditTextHelper.6
 * JD-Core Version:    0.7.0.1
 */
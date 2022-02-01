package com.tencent.mm.ui.widget.textview;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import com.tencent.mm.ui.f;

class SelectableTextHelper$3
  implements View.OnAttachStateChangeListener
{
  SelectableTextHelper$3(SelectableTextHelper paramSelectableTextHelper) {}
  
  public void onViewAttachedToWindow(View paramView)
  {
    f.b("SelectableTextHelper", "onViewAttachedToWindow", new Object[0]);
  }
  
  public void onViewDetachedFromWindow(View paramView)
  {
    f.b("SelectableTextHelper", "onViewDetachedFromWindow", new Object[0]);
    this.a.destroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.textview.SelectableTextHelper.3
 * JD-Core Version:    0.7.0.1
 */
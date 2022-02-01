package com.tencent.mm.plugin.appbrand.widget.actionbar;

import android.view.View;
import android.view.View.OnLongClickListener;

class b$4
  implements View.OnLongClickListener
{
  b$4(b paramb, View.OnLongClickListener paramOnLongClickListener) {}
  
  public boolean onLongClick(View paramView)
  {
    View.OnLongClickListener localOnLongClickListener = this.a;
    if (localOnLongClickListener != null) {
      return localOnLongClickListener.onLongClick(paramView);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.actionbar.b.4
 * JD-Core Version:    0.7.0.1
 */
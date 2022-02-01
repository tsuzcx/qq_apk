package com.tencent.mm.ui.widget.textview;

import com.tencent.mm.ui.f;

class SelectableTextHelper$2
  implements Runnable
{
  SelectableTextHelper$2(SelectableTextHelper paramSelectableTextHelper) {}
  
  public void run()
  {
    f.b("SelectableTextHelper", "dismiss all runnable.", new Object[0]);
    if (SelectableTextHelper.h(this.a) != null) {
      SelectableTextHelper.h(this.a).touchOutside();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.textview.SelectableTextHelper.2
 * JD-Core Version:    0.7.0.1
 */
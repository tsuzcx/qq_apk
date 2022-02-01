package com.tencent.mm.ui.widget.edittext;

import android.os.Build.VERSION;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.TextView;
import com.tencent.mm.ui.f;

class SelectableEditTextHelper$8
  implements ViewTreeObserver.OnPreDrawListener
{
  private boolean b;
  
  SelectableEditTextHelper$8(SelectableEditTextHelper paramSelectableEditTextHelper) {}
  
  private boolean a()
  {
    if (!SelectableEditTextHelper.w(this.a)) {
      return true;
    }
    if (Build.VERSION.SDK_INT < 29) {
      return true;
    }
    if (!SelectableEditTextHelper.k(this.a).isFocused()) {
      return true;
    }
    if (this.b) {
      return true;
    }
    int i = SelectableEditTextHelper.k(this.a).getSelectionStart();
    if (i != SelectableEditTextHelper.k(this.a).getSelectionEnd()) {
      return true;
    }
    TextPatternUtil.EmailInfo localEmailInfo = TextPatternUtil.findEmailAtPos(SelectableEditTextHelper.k(this.a).getText().toString(), i);
    if ((!this.b) && (localEmailInfo != null))
    {
      f.c("SelectableEditTextHelper", "predraw hit", new Object[0]);
      this.b = true;
      SelectableEditTextHelper.a(this.a, true);
    }
    return true;
  }
  
  public boolean onPreDraw()
  {
    return a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.edittext.SelectableEditTextHelper.8
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.ui.widget.edittext;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;

class SelectableEditTextHelper$5
  implements TextWatcher
{
  SelectableEditTextHelper$5(SelectableEditTextHelper paramSelectableEditTextHelper) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!SelectableEditTextHelper.m(this.a))
    {
      SelectableEditTextHelper.t(this.a);
      SelectableEditTextHelper.u(this.a);
    }
    SelectableEditTextHelper.k(this.a).setCursorVisible(true);
    paramCharSequence = this.a;
    SelectableEditTextHelper.d(paramCharSequence, SelectableEditTextHelper.k(paramCharSequence).getSelectionStart());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.edittext.SelectableEditTextHelper.5
 * JD-Core Version:    0.7.0.1
 */
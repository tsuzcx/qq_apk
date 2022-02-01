package com.tencent.mm.ui.widget;

import android.text.Editable;
import android.text.TextWatcher;

public abstract class MMTextWatcherAdapter
  implements TextWatcher
{
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.MMTextWatcherAdapter
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity.qwallet.fragment.busylogic;

import android.widget.EditText;
import cooperation.qwallet.QwUtils;

public class NumWatcher
  extends BaseWatcher
{
  public NumWatcher(EditText paramEditText)
  {
    super(paramEditText);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt1 = 1;
    paramCharSequence = paramCharSequence.toString();
    if (paramCharSequence.startsWith("0"))
    {
      paramInt2 = QwUtils.a(paramCharSequence, 1);
      if (paramInt2 != 0) {
        break label53;
      }
    }
    for (;;)
    {
      paramCharSequence = String.valueOf(paramInt1);
      this.a.setText(paramCharSequence);
      this.a.setSelection(paramCharSequence.length());
      return;
      label53:
      paramInt1 = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.fragment.busylogic.NumWatcher
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity;

import android.text.InputFilter;
import android.text.Spanned;

class EditInfoActivity$10
  implements InputFilter
{
  EditInfoActivity$10(EditInfoActivity paramEditInfoActivity) {}
  
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    if (paramCharSequence.toString().contains("\n")) {
      return paramCharSequence.toString().replace("\n", "");
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EditInfoActivity.10
 * JD-Core Version:    0.7.0.1
 */
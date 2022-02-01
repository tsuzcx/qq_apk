package com.google.android.material.timepicker;

import android.text.InputFilter;
import android.text.Spanned;

class MaxInputValidator
  implements InputFilter
{
  private int a;
  
  public MaxInputValidator(int paramInt)
  {
    this.a = paramInt;
  }
  
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    try
    {
      paramSpanned = new StringBuilder(paramSpanned);
      paramSpanned.replace(paramInt3, paramInt4, paramCharSequence.subSequence(paramInt1, paramInt2).toString());
      paramInt1 = Integer.parseInt(paramSpanned.toString());
      paramInt2 = this.a;
      if (paramInt1 <= paramInt2) {
        return null;
      }
    }
    catch (NumberFormatException paramCharSequence)
    {
      label55:
      break label55;
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.timepicker.MaxInputValidator
 * JD-Core Version:    0.7.0.1
 */
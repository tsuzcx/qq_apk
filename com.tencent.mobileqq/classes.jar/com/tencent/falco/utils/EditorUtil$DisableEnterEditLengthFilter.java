package com.tencent.falco.utils;

import android.text.Spanned;

public class EditorUtil$DisableEnterEditLengthFilter
  extends EditorUtil.EditLengthFilter
{
  public EditorUtil$DisableEnterEditLengthFilter(int paramInt)
  {
    super(paramInt);
  }
  
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    if (paramCharSequence.toString().contentEquals("\n")) {
      return "";
    }
    return super.filter(paramCharSequence, paramInt1, paramInt2, paramSpanned, paramInt3, paramInt4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.falco.utils.EditorUtil.DisableEnterEditLengthFilter
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.falco.utils;

import android.text.InputFilter;
import android.text.Spanned;

public class EditorUtil$EditLengthFilter
  implements InputFilter
{
  protected int mMaxLength;
  
  public EditorUtil$EditLengthFilter(int paramInt)
  {
    this.mMaxLength = paramInt;
  }
  
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    paramInt3 = this.mMaxLength - (EditorUtil.getLength(paramSpanned.subSequence(0, paramInt3)) + EditorUtil.getLength(paramSpanned.subSequence(paramInt4, paramSpanned.length())));
    if (paramInt3 <= 0) {
      return "";
    }
    if (paramInt3 >= EditorUtil.getLength(paramCharSequence.subSequence(paramInt1, paramInt2))) {
      return null;
    }
    return EditorUtil.clip(paramCharSequence, paramInt1, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.falco.utils.EditorUtil.EditLengthFilter
 * JD-Core Version:    0.7.0.1
 */
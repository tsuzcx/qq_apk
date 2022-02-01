package com.tencent.falco.utils;

import android.text.Spanned;

public class EditorUtil$DisableEnterEditLengthFilterChEn
  extends EditorUtil.EditLengthFilter
{
  public EditorUtil$DisableEnterEditLengthFilterChEn(int paramInt)
  {
    super(paramInt);
  }
  
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    if (paramCharSequence.toString().contentEquals("\n")) {
      return "";
    }
    paramInt3 = this.mMaxLength - (EditorUtil.getLengthChEn(paramSpanned.subSequence(0, paramInt3)) + EditorUtil.getLengthChEn(paramSpanned.subSequence(paramInt4, paramSpanned.length())));
    if (paramInt3 <= 0) {
      return "";
    }
    if (paramInt3 >= EditorUtil.getLengthChEn(paramCharSequence.subSequence(paramInt1, paramInt2))) {
      return null;
    }
    return EditorUtil.clip(paramCharSequence, paramInt1, paramInt3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.falco.utils.EditorUtil.DisableEnterEditLengthFilterChEn
 * JD-Core Version:    0.7.0.1
 */
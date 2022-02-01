package com.tencent.aelight.camera.aioeditor.activity.richmedia.view;

import android.text.InputFilter;
import android.text.Spanned;
import com.tencent.mobileqq.activity.richmedia.view.ExtendEditText.LengthConvertor;
import com.tencent.mobileqq.activity.richmedia.view.ExtendEditText.LimitListener;

class ExtendEditText$LengthFilter
  implements InputFilter
{
  private int b;
  
  public ExtendEditText$LengthFilter(ExtendEditText paramExtendEditText, int paramInt)
  {
    this.b = paramInt;
  }
  
  private void a()
  {
    if (ExtendEditText.b(this.a) != null) {
      ExtendEditText.b(this.a).a(this.b);
    }
  }
  
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    ExtendEditText.LengthConvertor localLengthConvertor = ExtendEditText.a(this.a);
    if (localLengthConvertor == null)
    {
      paramInt3 = paramSpanned.length() - (paramInt4 - paramInt3);
    }
    else
    {
      paramInt3 = localLengthConvertor.a(paramSpanned, 0, paramInt3);
      paramInt3 = localLengthConvertor.a(paramSpanned, paramInt4, paramSpanned.length()) + paramInt3;
    }
    if (localLengthConvertor == null) {
      paramInt2 -= paramInt1;
    } else {
      paramInt2 = localLengthConvertor.a(paramCharSequence, paramInt1, paramInt2);
    }
    paramInt3 = this.b - paramInt3;
    if (paramInt3 <= 0)
    {
      a();
      return "";
    }
    if (paramInt3 >= paramInt2) {
      return null;
    }
    a();
    paramInt2 = paramInt3;
    if (localLengthConvertor != null)
    {
      paramInt3 = localLengthConvertor.b(paramCharSequence, paramInt1, paramInt3 + paramInt1);
      paramInt2 = paramInt3;
      if (paramInt3 <= 0) {
        return "";
      }
    }
    paramInt3 = paramInt2 + paramInt1;
    paramInt2 = paramInt3;
    if (Character.isHighSurrogate(paramCharSequence.charAt(paramInt3 - 1)))
    {
      paramInt3 -= 1;
      paramInt2 = paramInt3;
      if (paramInt3 == paramInt1) {
        return "";
      }
    }
    return paramCharSequence.subSequence(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.activity.richmedia.view.ExtendEditText.LengthFilter
 * JD-Core Version:    0.7.0.1
 */
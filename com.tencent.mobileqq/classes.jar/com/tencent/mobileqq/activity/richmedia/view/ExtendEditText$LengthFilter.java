package com.tencent.mobileqq.activity.richmedia.view;

import android.text.InputFilter;
import android.text.Spanned;

class ExtendEditText$LengthFilter
  implements InputFilter
{
  private int jdField_a_of_type_Int;
  
  public ExtendEditText$LengthFilter(ExtendEditText paramExtendEditText, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private void a()
  {
    if (ExtendEditText.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText) != null) {
      ExtendEditText.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText).a(this.jdField_a_of_type_Int);
    }
  }
  
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    ExtendEditText.LengthConvertor localLengthConvertor = ExtendEditText.a(this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewExtendEditText);
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
    paramInt3 = this.jdField_a_of_type_Int - paramInt3;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.view.ExtendEditText.LengthFilter
 * JD-Core Version:    0.7.0.1
 */
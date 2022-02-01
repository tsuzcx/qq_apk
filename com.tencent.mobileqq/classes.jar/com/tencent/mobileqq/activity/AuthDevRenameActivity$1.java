package com.tencent.mobileqq.activity;

import android.text.InputFilter;
import android.text.Spanned;

class AuthDevRenameActivity$1
  implements InputFilter
{
  private int jdField_a_of_type_Int = 32;
  
  AuthDevRenameActivity$1(AuthDevRenameActivity paramAuthDevRenameActivity) {}
  
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    int n = 0;
    int k = paramInt1;
    int j = 0;
    for (;;)
    {
      i = 1;
      if (k >= paramInt2) {
        break;
      }
      m = paramCharSequence.charAt(k);
      if (m >= 128) {
        if (m < 2048) {
          i = 2;
        } else {
          i = 3;
        }
      }
      j += i;
      k += 1;
    }
    int i1 = paramSpanned.length();
    int m = 0;
    k = n;
    while (k < i1)
    {
      if ((k >= paramInt3) && (k < paramInt4)) {
        break label164;
      }
      i = paramSpanned.charAt(k);
      if (i < 128) {
        i = 1;
      } else if (i < 2048) {
        i = 2;
      } else {
        i = 3;
      }
      m += i;
      label164:
      k += 1;
    }
    int i = this.jdField_a_of_type_Int - m;
    if (i <= 0) {
      return "";
    }
    if (i >= j) {
      return null;
    }
    paramInt4 = paramInt1;
    while (paramInt4 < paramInt2)
    {
      paramInt3 = paramCharSequence.charAt(paramInt4);
      if (paramInt3 < 128) {
        paramInt3 = 1;
      } else if (paramInt3 < 2048) {
        paramInt3 = 2;
      } else {
        paramInt3 = 3;
      }
      i -= paramInt3;
      if (i < 0) {
        return paramCharSequence.subSequence(paramInt1, paramInt4);
      }
      paramInt4 += 1;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AuthDevRenameActivity.1
 * JD-Core Version:    0.7.0.1
 */
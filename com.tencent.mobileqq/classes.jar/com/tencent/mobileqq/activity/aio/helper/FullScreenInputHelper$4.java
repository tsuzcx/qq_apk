package com.tencent.mobileqq.activity.aio.helper;

import android.text.InputFilter;
import android.text.Spanned;

class FullScreenInputHelper$4
  implements InputFilter
{
  FullScreenInputHelper$4(FullScreenInputHelper paramFullScreenInputHelper) {}
  
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    paramInt3 = 4500 - (paramSpanned.length() - (paramInt4 - paramInt3));
    if (paramInt3 <= 0)
    {
      FullScreenInputHelper.a(this.a);
      return "";
    }
    if (paramInt3 >= paramInt2 - paramInt1) {
      return null;
    }
    paramInt3 += paramInt1;
    paramInt2 = paramInt3;
    if (Character.isHighSurrogate(paramCharSequence.charAt(paramInt3 - 1)))
    {
      paramInt3 -= 1;
      paramInt2 = paramInt3;
      if (paramInt3 == paramInt1)
      {
        FullScreenInputHelper.a(this.a);
        return "";
      }
    }
    FullScreenInputHelper.a(this.a);
    return paramCharSequence.subSequence(paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.FullScreenInputHelper.4
 * JD-Core Version:    0.7.0.1
 */
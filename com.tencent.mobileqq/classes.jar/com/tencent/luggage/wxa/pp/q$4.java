package com.tencent.luggage.wxa.pp;

import android.text.InputFilter;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;

class q$4
  implements InputFilter
{
  q$4(q paramq) {}
  
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    if ((!TextUtils.isEmpty(paramCharSequence)) && (q.a(this.a) != null))
    {
      if ((paramCharSequence instanceof Spannable)) {
        paramCharSequence = (Spannable)paramCharSequence;
      } else {
        paramCharSequence = new SpannableStringBuilder(paramCharSequence);
      }
      paramCharSequence.setSpan(q.a(this.a), 0, paramCharSequence.length(), 18);
      return paramCharSequence;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pp.q.4
 * JD-Core Version:    0.7.0.1
 */
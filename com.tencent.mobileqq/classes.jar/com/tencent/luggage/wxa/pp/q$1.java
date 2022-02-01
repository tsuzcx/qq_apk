package com.tencent.luggage.wxa.pp;

import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.TextUtils;

class q$1
  extends Spannable.Factory
{
  q$1(q paramq) {}
  
  public Spannable newSpannable(CharSequence paramCharSequence)
  {
    paramCharSequence = super.newSpannable(paramCharSequence);
    if ((q.a(this.a) != null) && (!TextUtils.isEmpty(paramCharSequence))) {
      paramCharSequence.setSpan(q.a(this.a), 0, paramCharSequence.length(), 18);
    }
    return paramCharSequence;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pp.q.1
 * JD-Core Version:    0.7.0.1
 */
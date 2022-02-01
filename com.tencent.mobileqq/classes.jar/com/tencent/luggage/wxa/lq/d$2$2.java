package com.tencent.luggage.wxa.lq;

import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.TextUtils;
import com.tencent.luggage.wxa.pz.a;

class d$2$2
  extends Spannable.Factory
{
  d$2$2(d.2 param2, int paramInt) {}
  
  public Spannable newSpannable(CharSequence paramCharSequence)
  {
    paramCharSequence = super.newSpannable(paramCharSequence);
    if (!TextUtils.isEmpty(paramCharSequence)) {
      paramCharSequence.setSpan(new a(this.a, 17), 0, paramCharSequence.length(), 18);
    }
    return paramCharSequence;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lq.d.2.2
 * JD-Core Version:    0.7.0.1
 */
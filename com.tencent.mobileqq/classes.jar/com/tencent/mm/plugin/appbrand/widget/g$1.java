package com.tencent.mm.plugin.appbrand.widget;

import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.TextUtils;

class g$1
  extends Spannable.Factory
{
  g$1(g paramg) {}
  
  public Spannable newSpannable(CharSequence paramCharSequence)
  {
    paramCharSequence = super.newSpannable(paramCharSequence);
    if ((g.a(this.a) != null) && (!TextUtils.isEmpty(paramCharSequence))) {
      paramCharSequence.setSpan(g.a(this.a), 0, paramCharSequence.length(), 18);
    }
    return paramCharSequence;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.g.1
 * JD-Core Version:    0.7.0.1
 */
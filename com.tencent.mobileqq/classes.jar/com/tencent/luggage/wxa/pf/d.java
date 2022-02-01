package com.tencent.luggage.wxa.pf;

import android.text.Html;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.URLSpan;

public class d
{
  public static CharSequence a(CharSequence paramCharSequence, d.a parama, boolean paramBoolean)
  {
    if ((paramCharSequence instanceof Spannable))
    {
      int j = paramCharSequence.length();
      Spannable localSpannable = (Spannable)paramCharSequence;
      int i = 0;
      URLSpan[] arrayOfURLSpan = (URLSpan[])localSpannable.getSpans(0, j, URLSpan.class);
      paramCharSequence = new SpannableStringBuilder(paramCharSequence);
      j = arrayOfURLSpan.length;
      while (i < j)
      {
        URLSpan localURLSpan = arrayOfURLSpan[i];
        paramCharSequence.removeSpan(localURLSpan);
        paramCharSequence.setSpan(new a(localURLSpan.getURL(), parama, paramBoolean), localSpannable.getSpanStart(localURLSpan), localSpannable.getSpanEnd(localURLSpan), 34);
        i += 1;
      }
      return paramCharSequence;
    }
    return paramCharSequence;
  }
  
  public static CharSequence a(String paramString, boolean paramBoolean, d.a parama)
  {
    return a(Html.fromHtml(paramString, new b(), new c(parama, paramBoolean)), parama, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pf.d
 * JD-Core Version:    0.7.0.1
 */
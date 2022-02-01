package com.tencent.luggage.wxa.kb;

import android.text.TextPaint;
import android.text.style.URLSpan;

public class i
  extends URLSpan
{
  public i(String paramString)
  {
    super(paramString);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kb.i
 * JD-Core Version:    0.7.0.1
 */
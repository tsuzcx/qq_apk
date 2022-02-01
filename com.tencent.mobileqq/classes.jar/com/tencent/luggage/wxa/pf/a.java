package com.tencent.luggage.wxa.pf;

import android.text.TextPaint;
import android.text.style.URLSpan;
import android.view.View;
import androidx.annotation.NonNull;

public class a
  extends URLSpan
{
  private String a;
  private d.a b;
  private boolean c;
  
  public a(String paramString, d.a parama, boolean paramBoolean)
  {
    super(paramString);
    this.a = paramString;
    this.b = parama;
    this.c = paramBoolean;
  }
  
  public void onClick(View paramView)
  {
    paramView = this.b;
    if (paramView == null) {
      return;
    }
    paramView.a(this.a);
  }
  
  public void updateDrawState(@NonNull TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setUnderlineText(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pf.a
 * JD-Core Version:    0.7.0.1
 */
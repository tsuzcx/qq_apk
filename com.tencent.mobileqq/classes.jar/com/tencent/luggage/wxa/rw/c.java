package com.tencent.luggage.wxa.rw;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.neattextview.textview.layout.d;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class c
  extends b<ClickableSpan>
{
  private boolean b;
  
  public c(int paramInt1, int paramInt2, ClickableSpan paramClickableSpan)
  {
    super(paramInt1, paramInt2, paramClickableSpan);
  }
  
  public void a(Canvas paramCanvas, TextPaint paramTextPaint, List<d> paramList)
  {
    a(paramList);
    if (this.b)
    {
      int i = paramTextPaint.getColor();
      int j = paramTextPaint.bgColor;
      boolean bool = paramTextPaint.isUnderlineText();
      ((ClickableSpan)a()).updateDrawState(paramTextPaint);
      paramTextPaint.setColor(paramTextPaint.bgColor);
      paramList = this.a.iterator();
      while (paramList.hasNext()) {
        paramCanvas.drawRect((RectF)paramList.next(), paramTextPaint);
      }
      paramTextPaint.setColor(i);
      paramTextPaint.setUnderlineText(bool);
      paramTextPaint.bgColor = j;
      this.b = false;
    }
  }
  
  public void a(View paramView)
  {
    if (a() != null) {
      ((ClickableSpan)a()).onClick(paramView);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.rw.c
 * JD-Core Version:    0.7.0.1
 */
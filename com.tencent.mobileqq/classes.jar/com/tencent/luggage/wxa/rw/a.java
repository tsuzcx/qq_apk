package com.tencent.luggage.wxa.rw;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.text.TextPaint;
import android.text.style.BackgroundColorSpan;
import android.text.style.CharacterStyle;
import com.tencent.neattextview.textview.layout.d;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class a
  extends b<BackgroundColorSpan>
{
  public a(int paramInt1, int paramInt2, CharacterStyle paramCharacterStyle)
  {
    super(paramInt1, paramInt2, paramCharacterStyle);
  }
  
  public void a(Canvas paramCanvas, TextPaint paramTextPaint, List<d> paramList)
  {
    a(paramList);
    int i = paramTextPaint.getColor();
    paramTextPaint.setColor(((BackgroundColorSpan)a()).getBackgroundColor());
    paramList = this.a.iterator();
    while (paramList.hasNext()) {
      paramCanvas.drawRect((RectF)paramList.next(), paramTextPaint);
    }
    paramTextPaint.setColor(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.rw.a
 * JD-Core Version:    0.7.0.1
 */
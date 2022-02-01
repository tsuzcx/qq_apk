package com.tencent.mm.ui.base;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.style.LineBackgroundSpan;
import android.view.View;
import com.tencent.mm.ui.widget.textview.TextLayoutUtil;

public class b
  implements LineBackgroundSpan
{
  private View a;
  private final int b;
  private int c;
  private int d;
  private Rect e;
  
  public b(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = paramView;
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramInt3;
    this.e = new Rect();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.c = paramInt1;
    this.d = paramInt2;
  }
  
  public void drawBackground(Canvas paramCanvas, Paint paramPaint, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, CharSequence paramCharSequence, int paramInt6, int paramInt7, int paramInt8)
  {
    if (this.d < paramInt6) {
      return;
    }
    if (this.c > paramInt7) {
      return;
    }
    int i = paramPaint.getColor();
    int k = TextLayoutUtil.getLineForOffset(this.a, this.c);
    int j = TextLayoutUtil.getLineForOffset(this.a, this.d);
    paramInt7 = paramInt1;
    paramInt5 = paramInt2;
    if (k <= paramInt8)
    {
      paramInt7 = paramInt1;
      paramInt5 = paramInt2;
      if (paramInt8 <= j)
      {
        float f;
        if (k == paramInt8) {
          f = TextLayoutUtil.getPrimaryHorizontal(this.a, this.c);
        } else {
          f = TextLayoutUtil.getLineLeft(this.a, paramInt8);
        }
        paramInt7 = (int)f;
        if (j == paramInt8) {
          paramInt5 = (int)TextLayoutUtil.getPrimaryHorizontal(this.a, this.d);
        } else {
          paramInt5 = (int)TextLayoutUtil.getLineWidth(this.a, paramInt8) + paramInt7;
        }
      }
    }
    paramInt1 = (int)(paramInt4 + paramPaint.descent());
    paramCharSequence = this.e;
    paramCharSequence.left = paramInt7;
    if (this.c == paramInt6) {
      paramCharSequence.left -= 4;
    }
    paramCharSequence = this.e;
    paramCharSequence.right = paramInt5;
    if (this.d == paramInt5) {
      paramCharSequence.right += 4;
    }
    paramCharSequence = this.e;
    paramCharSequence.top = paramInt3;
    paramCharSequence.bottom = paramInt1;
    paramPaint.setColor(this.b);
    paramCanvas.drawRect(this.e, paramPaint);
    paramPaint.setColor(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.base.b
 * JD-Core Version:    0.7.0.1
 */
package androidx.cardview.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

class CardViewBaseImpl$1
  implements RoundRectDrawableWithShadow.RoundRectHelper
{
  CardViewBaseImpl$1(CardViewBaseImpl paramCardViewBaseImpl) {}
  
  public void drawRoundRect(Canvas paramCanvas, RectF paramRectF, float paramFloat, Paint paramPaint)
  {
    float f1 = 2.0F * paramFloat;
    float f2 = paramRectF.width() - f1 - 1.0F;
    float f3 = paramRectF.height();
    if (paramFloat >= 1.0F)
    {
      float f4 = paramFloat + 0.5F;
      RectF localRectF = this.this$0.mCornerRect;
      float f5 = -f4;
      localRectF.set(f5, f5, f4, f4);
      int i = paramCanvas.save();
      paramCanvas.translate(paramRectF.left + f4, paramRectF.top + f4);
      paramCanvas.drawArc(this.this$0.mCornerRect, 180.0F, 90.0F, true, paramPaint);
      paramCanvas.translate(f2, 0.0F);
      paramCanvas.rotate(90.0F);
      paramCanvas.drawArc(this.this$0.mCornerRect, 180.0F, 90.0F, true, paramPaint);
      paramCanvas.translate(f3 - f1 - 1.0F, 0.0F);
      paramCanvas.rotate(90.0F);
      paramCanvas.drawArc(this.this$0.mCornerRect, 180.0F, 90.0F, true, paramPaint);
      paramCanvas.translate(f2, 0.0F);
      paramCanvas.rotate(90.0F);
      paramCanvas.drawArc(this.this$0.mCornerRect, 180.0F, 90.0F, true, paramPaint);
      paramCanvas.restoreToCount(i);
      paramCanvas.drawRect(paramRectF.left + f4 - 1.0F, paramRectF.top, paramRectF.right - f4 + 1.0F, paramRectF.top + f4, paramPaint);
      paramCanvas.drawRect(paramRectF.left + f4 - 1.0F, paramRectF.bottom - f4, paramRectF.right - f4 + 1.0F, paramRectF.bottom, paramPaint);
    }
    paramCanvas.drawRect(paramRectF.left, paramRectF.top + paramFloat, paramRectF.right, paramRectF.bottom - paramFloat, paramPaint);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.cardview.widget.CardViewBaseImpl.1
 * JD-Core Version:    0.7.0.1
 */
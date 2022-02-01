import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.text.TextPaint;
import android.text.style.ReplacementSpan;

public class baet
  extends ReplacementSpan
{
  private float a;
  private float b = -1.0F;
  
  public baet(float paramFloat1, float paramFloat2)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
  }
  
  private TextPaint a(Paint paramPaint)
  {
    paramPaint = new TextPaint(paramPaint);
    paramPaint.setTextSize(this.a);
    return paramPaint;
  }
  
  public void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    paramCharSequence = paramCharSequence.subSequence(paramInt1, paramInt2);
    paramPaint = a(paramPaint);
    Paint.FontMetricsInt localFontMetricsInt = paramPaint.getFontMetricsInt();
    paramInt1 = localFontMetricsInt.top;
    float f = (localFontMetricsInt.bottom + (paramInt1 + paramInt4 + paramInt4)) / 2 - (paramInt5 + paramInt3) / 2;
    if (this.b != 0.0F) {
      f = this.b;
    }
    paramCanvas.drawText(paramCharSequence.toString(), paramFloat, paramInt4 - f, paramPaint);
  }
  
  public int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    paramCharSequence = paramCharSequence.subSequence(paramInt1, paramInt2);
    return (int)a(paramPaint).measureText(paramCharSequence.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baet
 * JD-Core Version:    0.7.0.1
 */
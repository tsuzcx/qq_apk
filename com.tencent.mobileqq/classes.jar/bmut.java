import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.style.ReplacementSpan;

public class bmut
  extends ReplacementSpan
{
  private final float a;
  private final float b;
  
  public bmut(float paramFloat1, float paramFloat2)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
  }
  
  public void draw(@NonNull Canvas paramCanvas, CharSequence paramCharSequence, @IntRange(from=0L) int paramInt1, @IntRange(from=0L) int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, @NonNull Paint paramPaint)
  {
    if (paramCharSequence != null)
    {
      paramPaint.setTextSize(this.a);
      paramCanvas.drawText(paramCharSequence, paramInt1, paramInt2, paramFloat, paramInt4, paramPaint);
    }
  }
  
  public int getSize(@NonNull Paint paramPaint, CharSequence paramCharSequence, @IntRange(from=0L) int paramInt1, @IntRange(from=0L) int paramInt2, @Nullable Paint.FontMetricsInt paramFontMetricsInt)
  {
    if (paramCharSequence == null) {
      return 0;
    }
    paramPaint.setTextSize(this.a);
    if (paramFontMetricsInt != null)
    {
      Paint.FontMetricsInt localFontMetricsInt = paramPaint.getFontMetricsInt();
      paramFontMetricsInt.top = ((int)(localFontMetricsInt.top * this.b));
      paramFontMetricsInt.ascent = ((int)(localFontMetricsInt.ascent * this.b));
      paramFontMetricsInt.descent = localFontMetricsInt.descent;
      paramFontMetricsInt.bottom = localFontMetricsInt.bottom;
      paramFontMetricsInt.leading = localFontMetricsInt.leading;
    }
    return Math.round(paramPaint.measureText(paramCharSequence, paramInt1, paramInt2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmut
 * JD-Core Version:    0.7.0.1
 */
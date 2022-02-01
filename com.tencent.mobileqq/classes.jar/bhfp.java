import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;

public class bhfp
  extends ImageSpan
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  
  public bhfp(Drawable paramDrawable, int paramInt)
  {
    super(paramDrawable, paramInt);
  }
  
  public bhfp a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
    return this;
  }
  
  public void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    paramCharSequence = getDrawable();
    paramCanvas.save();
    paramInt2 = paramInt5 - paramCharSequence.getBounds().bottom;
    paramInt1 = paramInt2;
    if (this.mVerticalAlignment == 1) {
      paramInt1 = paramInt2 - paramPaint.getFontMetricsInt().descent;
    }
    if ((this.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_Float != 0.0F)) {
      this.jdField_a_of_type_Int = ((int)((paramInt5 - paramInt3) * this.jdField_a_of_type_Float));
    }
    paramCanvas.translate(paramFloat, paramInt1 + this.jdField_a_of_type_Int);
    paramCharSequence.draw(paramCanvas);
    paramCanvas.restore();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhfp
 * JD-Core Version:    0.7.0.1
 */
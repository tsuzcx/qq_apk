import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

public class avdg
  extends bbkk
{
  public float a;
  private int jdField_a_of_type_Int;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private String jdField_a_of_type_JavaLangString;
  public boolean a;
  private float[] jdField_a_of_type_ArrayOfFloat;
  public float b;
  private int b;
  private int c;
  
  public avdg(Drawable paramDrawable1, int paramInt1, String paramString, int paramInt2, Drawable paramDrawable2, float paramFloat)
  {
    super(paramDrawable1, paramInt1);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_a_of_type_ArrayOfFloat = new float[this.jdField_a_of_type_JavaLangString.length()];
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable2;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(paramFloat);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(paramInt2);
  }
  
  public int a()
  {
    getSize(this.jdField_a_of_type_AndroidGraphicsPaint, this.jdField_a_of_type_JavaLangString, 0, this.jdField_a_of_type_JavaLangString.length(), this.jdField_a_of_type_AndroidGraphicsPaint.getFontMetricsInt());
    return this.b;
  }
  
  public int b()
  {
    Rect localRect = getDrawable().getBounds();
    Paint.FontMetricsInt localFontMetricsInt = this.jdField_a_of_type_AndroidGraphicsPaint.getFontMetricsInt();
    int i = localRect.bottom;
    int j = -localFontMetricsInt.top;
    this.c = Math.max(i, localFontMetricsInt.bottom + j);
    return this.c;
  }
  
  public void draw(Canvas paramCanvas, CharSequence paramCharSequence, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, int paramInt5, Paint paramPaint)
  {
    if (this.jdField_a_of_type_Boolean) {}
    for (int i = this.jdField_a_of_type_AndroidGraphicsPaint.getFontMetricsInt().top + paramInt4;; i = paramInt4)
    {
      if ((this.b > 0) && (this.c > 0))
      {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(0, i, this.b, this.c + i);
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      }
      super.draw(paramCanvas, paramCharSequence, paramInt1, paramInt2, paramFloat, paramInt3, paramInt4, paramInt5, paramPaint);
      float f = getDrawable().getBounds().right;
      paramInt1 = this.jdField_a_of_type_AndroidGraphicsPaint.getFontMetricsInt().ascent;
      if (this.jdField_a_of_type_Boolean) {}
      for (;;)
      {
        paramCanvas.drawText(this.jdField_a_of_type_JavaLangString, paramFloat + f, paramInt4, this.jdField_a_of_type_AndroidGraphicsPaint);
        return;
        paramInt4 -= paramInt1;
      }
    }
  }
  
  public int getSize(Paint paramPaint, CharSequence paramCharSequence, int paramInt1, int paramInt2, Paint.FontMetricsInt paramFontMetricsInt)
  {
    paramCharSequence = getDrawable().getBounds();
    this.jdField_a_of_type_AndroidGraphicsPaint.getTextWidths(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ArrayOfFloat);
    paramInt1 = paramCharSequence.right;
    paramFontMetricsInt = this.jdField_a_of_type_ArrayOfFloat;
    int i = paramFontMetricsInt.length;
    paramInt2 = 0;
    while (paramInt2 < i)
    {
      float f = paramFontMetricsInt[paramInt2];
      paramInt1 = (int)(paramInt1 + f);
      paramInt2 += 1;
    }
    this.b = paramInt1;
    paramPaint = paramPaint.getFontMetricsInt();
    paramInt2 = paramCharSequence.bottom;
    i = -paramPaint.top;
    this.c = Math.max(paramInt2, paramPaint.bottom + i);
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avdg
 * JD-Core Version:    0.7.0.1
 */
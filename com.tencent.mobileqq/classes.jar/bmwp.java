import android.graphics.Canvas;
import android.graphics.RectF;
import android.text.TextPaint;

public class bmwp
  extends bmuz
{
  protected float a;
  protected String a;
  
  public bmwp(int paramInt1, int paramInt2, TextPaint paramTextPaint, String paramString, RectF paramRectF, float paramFloat)
  {
    super(paramInt1, paramInt2, paramTextPaint, paramRectF);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void a(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    if (paramCanvas == null) {
      return;
    }
    String str = this.jdField_a_of_type_JavaLangString;
    int i = this.jdField_a_of_type_JavaLangString.length();
    float f1 = paramInt1;
    float f2 = this.jdField_a_of_type_AndroidGraphicsRectF.left;
    float f3 = paramInt2;
    float f4 = this.jdField_a_of_type_Float;
    paramCanvas.drawText(str, 0, i, f2 + f1, this.jdField_a_of_type_AndroidGraphicsRectF.top + (f3 + f4), this.jdField_a_of_type_AndroidTextTextPaint);
  }
  
  public void a(Canvas paramCanvas, bmux parambmux, int paramInt1, int paramInt2)
  {
    parambmux.a(paramCanvas, this.jdField_a_of_type_AndroidGraphicsRectF, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmwp
 * JD-Core Version:    0.7.0.1
 */
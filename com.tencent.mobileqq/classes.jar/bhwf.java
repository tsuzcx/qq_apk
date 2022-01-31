import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import com.tencent.widget.RangeButtonView;

public class bhwf
{
  public float a;
  Point jdField_a_of_type_AndroidGraphicsPoint;
  String jdField_a_of_type_JavaLangString;
  
  public bhwf(String paramString, float paramFloat)
  {
    this(paramString, paramFloat, null);
  }
  
  public bhwf(String paramString, float paramFloat, Point paramPoint)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Float = paramFloat;
    this.jdField_a_of_type_AndroidGraphicsPoint = paramPoint;
  }
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public int a()
  {
    return (int)RangeButtonView.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Float);
  }
  
  public void a(Canvas paramCanvas, Paint paramPaint, bhwc parambhwc)
  {
    if (this.jdField_a_of_type_AndroidGraphicsPoint == null) {
      return;
    }
    paramPaint.setTextSize(this.jdField_a_of_type_Float);
    int i = paramPaint.getColor();
    paramPaint.setColor(parambhwc.a);
    paramCanvas.drawText(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidGraphicsPoint.x, this.jdField_a_of_type_AndroidGraphicsPoint.y, paramPaint);
    paramPaint.setColor(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhwf
 * JD-Core Version:    0.7.0.1
 */
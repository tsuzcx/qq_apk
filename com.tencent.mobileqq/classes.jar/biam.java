import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import com.tencent.widget.RangeButtonView;

public class biam
{
  public float a;
  Point jdField_a_of_type_AndroidGraphicsPoint;
  String jdField_a_of_type_JavaLangString;
  
  public biam(String paramString, float paramFloat)
  {
    this(paramString, paramFloat, null);
  }
  
  public biam(String paramString, float paramFloat, Point paramPoint)
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
  
  public void a(Canvas paramCanvas, Paint paramPaint, biaj parambiaj)
  {
    if (this.jdField_a_of_type_AndroidGraphicsPoint == null) {
      return;
    }
    paramPaint.setTextSize(this.jdField_a_of_type_Float);
    int i = paramPaint.getColor();
    paramPaint.setColor(parambiaj.a);
    paramCanvas.drawText(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_AndroidGraphicsPoint.x, this.jdField_a_of_type_AndroidGraphicsPoint.y, paramPaint);
    paramPaint.setColor(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     biam
 * JD-Core Version:    0.7.0.1
 */
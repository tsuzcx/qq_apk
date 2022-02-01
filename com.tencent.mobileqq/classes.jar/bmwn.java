import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import java.util.ArrayList;

public class bmwn
  extends bmux
{
  private final int a;
  
  public bmwn(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(paramInt1);
    this.jdField_a_of_type_Int = paramInt2;
  }
  
  public void a(Canvas paramCanvas, RectF paramRectF, int paramInt1, int paramInt2)
  {
    if ((paramCanvas == null) || (paramRectF == null)) {
      return;
    }
    float f1 = paramRectF.left;
    float f2 = this.jdField_a_of_type_Int;
    float f3 = paramInt1;
    float f4 = paramRectF.top;
    float f5 = this.jdField_a_of_type_Int;
    float f6 = paramInt2;
    float f7 = paramRectF.right;
    float f8 = this.jdField_a_of_type_Int;
    float f9 = paramInt1;
    float f10 = paramRectF.bottom;
    float f11 = this.jdField_a_of_type_Int;
    paramCanvas.drawRect(f3 + (f1 - f2), f6 + (f4 - f5), f9 + (f7 + f8), paramInt2 + (f10 + f11), this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  public void a(Canvas paramCanvas, ArrayList<bmwp> paramArrayList, int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmwn
 * JD-Core Version:    0.7.0.1
 */
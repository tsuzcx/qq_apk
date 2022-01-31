import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

public class bkod
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = 0;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private float b;
  private float c = 1.0F;
  
  public void a() {}
  
  public void a(int paramInt, float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Float = paramFloat1;
    this.b = paramFloat2;
    if (this.jdField_a_of_type_AndroidGraphicsPaint == null)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
      this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    }
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_Int);
  }
  
  public void a(Canvas paramCanvas, int paramInt)
  {
    if (paramCanvas == null) {
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(paramInt);
    float f1 = this.jdField_a_of_type_AndroidGraphicsRectF.width() - this.jdField_a_of_type_Float - this.b;
    float f2 = this.c * f1;
    paramCanvas.save();
    RectF localRectF = new RectF(this.jdField_a_of_type_AndroidGraphicsRectF.left + this.jdField_a_of_type_Float, this.jdField_a_of_type_AndroidGraphicsRectF.top, f1 + (this.jdField_a_of_type_AndroidGraphicsRectF.left + this.jdField_a_of_type_Float), this.jdField_a_of_type_AndroidGraphicsRectF.top + f2);
    paramCanvas.clipRect(localRectF.left, localRectF.top, localRectF.right, localRectF.top + f2 / 2.0F);
    paramCanvas.drawOval(localRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.restore();
    paramCanvas.save();
    localRectF.top = (this.jdField_a_of_type_AndroidGraphicsRectF.bottom - f2);
    localRectF.bottom = this.jdField_a_of_type_AndroidGraphicsRectF.bottom;
    paramCanvas.clipRect(localRectF.left, localRectF.top + f2 / 2.0F, localRectF.right, localRectF.bottom);
    paramCanvas.drawOval(localRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.restore();
    localRectF.top = Math.round(this.jdField_a_of_type_AndroidGraphicsRectF.top + f2 / 2.0F);
    localRectF.bottom = Math.round(this.jdField_a_of_type_AndroidGraphicsRectF.bottom - f2 / 2.0F);
    paramCanvas.drawRect(localRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  public void a(RectF paramRectF)
  {
    this.jdField_a_of_type_AndroidGraphicsRectF.set(paramRectF);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkod
 * JD-Core Version:    0.7.0.1
 */
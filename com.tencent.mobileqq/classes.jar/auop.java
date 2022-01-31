import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;

public class auop
{
  public float a;
  public int a;
  public long a;
  public Bitmap a;
  public boolean a;
  public float b;
  public int b;
  public long b;
  public float c;
  public float d = 1.0F;
  
  public auop()
  {
    this.jdField_a_of_type_Int = 255;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public void a(Canvas paramCanvas, Paint paramPaint, Matrix paramMatrix)
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
      return;
    }
    int i = (int)(this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth() * this.d);
    int j = (int)(this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight() * this.d);
    Matrix localMatrix = paramMatrix;
    if (paramMatrix == null) {
      localMatrix = new Matrix();
    }
    paramPaint.setAlpha(this.jdField_a_of_type_Int);
    localMatrix.reset();
    localMatrix.setScale(this.d, this.d);
    localMatrix.postRotate(this.c, i / 2, j / 2);
    localMatrix.postTranslate(this.jdField_a_of_type_Float, this.jdField_b_of_type_Float);
    paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, localMatrix, paramPaint);
  }
  
  public String toString()
  {
    return " mDx = " + this.jdField_a_of_type_Float + " mDy = " + this.jdField_b_of_type_Float + " mScale = " + this.d + " mRotation = " + this.c + " mDuration = " + this.jdField_b_of_type_Long + " mAlpha = " + this.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     auop
 * JD-Core Version:    0.7.0.1
 */
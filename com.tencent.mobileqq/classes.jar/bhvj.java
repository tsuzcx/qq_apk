import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.tencent.qphone.base.util.QLog;

public class bhvj
  extends Drawable
{
  private int jdField_a_of_type_Int;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private int jdField_b_of_type_Int;
  Rect jdField_b_of_type_AndroidGraphicsRect = new Rect();
  private int c;
  private int d;
  private int e;
  private int f;
  
  public bhvj(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramBitmap.getWidth();
    this.jdField_b_of_type_Int = paramBitmap.getHeight();
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    this.c = paramInt1;
    this.d = paramInt2;
    if (this.c <= 0) {
      this.c = 1080;
    }
    if (this.d <= 0) {
      this.d = 1920;
    }
    this.f = (this.d * this.jdField_a_of_type_Int / this.c);
    if (this.jdField_b_of_type_Int > this.f) {
      this.e = (this.jdField_b_of_type_Int - this.f);
    }
    if (QLog.isColorLevel())
    {
      QLog.i("UserGuideWeiShiActivity", 2, "displayWidth" + paramInt1 + " displayHeight " + paramInt2);
      QLog.i("UserGuideWeiShiActivity", 2, "mWidth" + this.jdField_a_of_type_Int + " mHeight " + this.jdField_b_of_type_Int);
      QLog.i("UserGuideWeiShiActivity", 2, "mNewBitmMapHeight" + this.f + " mTop " + this.e);
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    this.jdField_a_of_type_AndroidGraphicsRect.set(0, this.e, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
    this.jdField_b_of_type_AndroidGraphicsRect.set(0, 0, this.jdField_a_of_type_Int, this.f);
    paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_b_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  public int getIntrinsicHeight()
  {
    return this.f;
  }
  
  public int getIntrinsicWidth()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void setAlpha(int paramInt)
  {
    if (paramInt != this.jdField_a_of_type_AndroidGraphicsPaint.getAlpha())
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(paramInt);
      super.invalidateSelf();
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColorFilter(paramColorFilter);
    super.invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bhvj
 * JD-Core Version:    0.7.0.1
 */
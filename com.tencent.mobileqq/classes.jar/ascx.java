import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.util.DisplayMetrics;

public class ascx
  extends BitmapDrawable
{
  private float jdField_a_of_type_Float = 1920.0F;
  private int jdField_a_of_type_Int;
  private final Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private int b;
  private int c;
  
  public ascx(Resources paramResources, Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramResources, paramBitmap);
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.jdField_a_of_type_Float = (12.0F * (paramResources.getDisplayMetrics().densityDpi / 160.0F));
    super.setGravity(17);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.c >>> 24 != 0)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.c);
      paramCanvas.drawRoundRect(new RectF(getBounds()), this.jdField_a_of_type_Float, this.jdField_a_of_type_Float, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    super.draw(paramCanvas);
  }
  
  public int getIntrinsicHeight()
  {
    if (this.b > 0) {
      return this.b;
    }
    return super.getIntrinsicHeight();
  }
  
  public int getIntrinsicWidth()
  {
    if (this.jdField_a_of_type_Int > 0) {
      return this.jdField_a_of_type_Int;
    }
    return super.getIntrinsicWidth();
  }
  
  public void setAlpha(int paramInt)
  {
    if (paramInt != this.jdField_a_of_type_AndroidGraphicsPaint.getAlpha()) {
      this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(paramInt);
    }
    super.setAlpha(paramInt);
  }
  
  public void setTargetDensity(int paramInt)
  {
    this.jdField_a_of_type_Float = (12.0F * (paramInt / 160.0F));
    super.setTargetDensity(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ascx
 * JD-Core Version:    0.7.0.1
 */
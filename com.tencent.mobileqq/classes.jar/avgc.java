import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class avgc
  extends Drawable
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private int jdField_b_of_type_Int;
  private Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  private Rect jdField_b_of_type_AndroidGraphicsRect = new Rect();
  private Rect c = new Rect();
  private Rect d = new Rect();
  
  public avgc(@NonNull Resources paramResources)
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(paramResources, 2130840250);
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null) {
      this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight());
    }
    this.jdField_b_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(paramResources, 2130840251);
    if (this.jdField_b_of_type_AndroidGraphicsBitmap != null) {
      this.jdField_b_of_type_AndroidGraphicsRect.set(0, 0, this.jdField_b_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_b_of_type_AndroidGraphicsBitmap.getHeight());
    }
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (this.jdField_b_of_type_AndroidGraphicsBitmap != null))
    {
      this.jdField_a_of_type_Float += 2.5F;
      paramCanvas.save();
      paramCanvas.rotate(this.jdField_a_of_type_Float, this.jdField_b_of_type_Int >> 1, this.jdField_a_of_type_Int >> 1);
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsRect, this.c, null);
      paramCanvas.restore();
      paramCanvas.rotate(-this.jdField_a_of_type_Float, this.jdField_b_of_type_Int >> 1, this.jdField_a_of_type_Int >> 1);
      paramCanvas.drawBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap, this.jdField_b_of_type_AndroidGraphicsRect, this.d, null);
      paramCanvas = getCallback();
      if (paramCanvas != null) {
        paramCanvas.invalidateDrawable(this);
      }
    }
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    this.jdField_b_of_type_Int = paramRect.width();
    this.jdField_a_of_type_Int = paramRect.height();
    this.c.set(0, 0, this.jdField_b_of_type_Int, this.jdField_a_of_type_Int);
    this.d.set(this.jdField_b_of_type_Int >> 2, this.jdField_a_of_type_Int >> 2, this.jdField_b_of_type_Int * 3 / 4, this.jdField_a_of_type_Int * 3 / 4);
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(@Nullable ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avgc
 * JD-Core Version:    0.7.0.1
 */
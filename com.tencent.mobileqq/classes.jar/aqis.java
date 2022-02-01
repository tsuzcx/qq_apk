import android.annotation.TargetApi;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.tencent.qphone.base.util.QLog;

public class aqis
  extends Drawable
{
  private static Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  int jdField_a_of_type_Int = 119;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint(7);
  private final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 160;
  private int c;
  private int d;
  
  public aqis(Bitmap paramBitmap, Resources paramResources)
  {
    this.jdField_b_of_type_Int = paramResources.getDisplayMetrics().densityDpi;
    a(paramBitmap);
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      this.c = this.jdField_a_of_type_AndroidGraphicsBitmap.getScaledWidth(this.jdField_b_of_type_Int);
      this.d = this.jdField_a_of_type_AndroidGraphicsBitmap.getScaledHeight(this.jdField_b_of_type_Int);
    }
  }
  
  public Bitmap a()
  {
    return this.jdField_a_of_type_AndroidGraphicsBitmap;
  }
  
  public void a(Bitmap paramBitmap)
  {
    if (paramBitmap != this.jdField_a_of_type_AndroidGraphicsBitmap)
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
      a();
      invalidateSelf();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  @TargetApi(21)
  public void draw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      copyBounds(this.jdField_a_of_type_AndroidGraphicsRect);
      if ((!this.jdField_a_of_type_Boolean) || (jdField_b_of_type_AndroidGraphicsBitmap != null)) {}
    }
    try
    {
      jdField_b_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(this.jdField_a_of_type_AndroidGraphicsRect.width(), this.jdField_a_of_type_AndroidGraphicsRect.height(), Bitmap.Config.ARGB_4444);
      Canvas localCanvas = new Canvas(jdField_b_of_type_AndroidGraphicsBitmap);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
      localCanvas.drawOval(new RectF(0.0F, 0.0F, this.jdField_a_of_type_AndroidGraphicsRect.width(), this.jdField_a_of_type_AndroidGraphicsRect.height()), this.jdField_a_of_type_AndroidGraphicsPaint);
      if (Build.VERSION.SDK_INT >= 21)
      {
        int i = paramCanvas.saveLayer(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight(), null);
        paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, null, this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
        if ((this.jdField_a_of_type_Boolean) && (jdField_b_of_type_AndroidGraphicsBitmap != null))
        {
          this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
          paramCanvas.drawBitmap(jdField_b_of_type_AndroidGraphicsBitmap, null, this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
          this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(null);
        }
        paramCanvas.restoreToCount(i);
        return;
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("VideoDrawable", 2, localOutOfMemoryError.getMessage(), localOutOfMemoryError);
        }
      }
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, null, this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  public int getIntrinsicHeight()
  {
    return this.d;
  }
  
  public int getIntrinsicWidth()
  {
    return this.c;
  }
  
  public int getOpacity()
  {
    return -2;
  }
  
  public void setAlpha(int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColorFilter(paramColorFilter);
  }
  
  public void setDither(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setDither(paramBoolean);
  }
  
  public void setFilterBitmap(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setFilterBitmap(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqis
 * JD-Core Version:    0.7.0.1
 */
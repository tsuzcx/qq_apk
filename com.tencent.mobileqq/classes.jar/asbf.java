import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.qphone.base.util.QLog;

public class asbf
  extends BitmapDrawable
{
  public int a;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private final Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint(2);
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  
  public asbf(Resources paramResources, Bitmap paramBitmap)
  {
    super(paramResources, paramBitmap);
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
  }
  
  protected Rect a(Rect paramRect)
  {
    if (getBitmap() == null) {
      return this.jdField_a_of_type_AndroidGraphicsRect;
    }
    int i = getBitmap().getHeight();
    int k = getBitmap().getWidth();
    if (paramRect == null) {
      return new Rect(0, 0, k, i);
    }
    QLog.d("chatbg", 1, "dstRect = " + paramRect);
    QLog.d("chatbg", 1, "img width = " + k + " img height = " + i);
    if (this.jdField_a_of_type_Int < paramRect.height()) {
      this.jdField_a_of_type_Int = paramRect.height();
    }
    int j;
    if (this.jdField_a_of_type_Int / paramRect.width() >= i / k)
    {
      j = paramRect.width() * i / this.jdField_a_of_type_Int;
      k = (int)((k - j) * 0.5D);
      if (this.jdField_a_of_type_Int > paramRect.height()) {
        i = getBitmap().getHeight() * paramRect.height() / this.jdField_a_of_type_Int;
      }
    }
    for (paramRect = new Rect(k, 0, j + k, i);; paramRect = new Rect(0, i, k, j + i))
    {
      QLog.d("chatbg", 1, " result = " + paramRect + " chatWindowHeight " + this.jdField_a_of_type_Int);
      return paramRect;
      j = paramRect.height() * k / paramRect.width();
      i = (int)((i - this.jdField_a_of_type_Int * k / paramRect.width()) * 0.5D);
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()))
    {
      Rect localRect = getBounds();
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsRect, localRect, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  public int getOpacity()
  {
    return 0;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    this.jdField_a_of_type_AndroidGraphicsRect = a(getBounds());
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asbf
 * JD-Core Version:    0.7.0.1
 */
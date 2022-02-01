import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;

public class bjtj
{
  public int a;
  public Bitmap a;
  public int b;
  
  public bjtj(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    a(paramInt1, paramInt2);
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
      return 0;
    }
    return this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int i = this.jdField_a_of_type_AndroidGraphicsBitmap.getWidth();
    int j = this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
    this.jdField_a_of_type_Int = (paramInt1 - i / 2);
    this.b = (paramInt2 - j / 2);
  }
  
  public void a(Canvas paramCanvas, Paint paramPaint)
  {
    paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_Int, this.b, paramPaint);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjtj
 * JD-Core Version:    0.7.0.1
 */
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Rect;

public class amjv
{
  private int jdField_a_of_type_Int;
  private Bitmap.Config jdField_a_of_type_AndroidGraphicsBitmap$Config;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private int b;
  private int c;
  
  private amjv(Bitmap paramBitmap, int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect(0, 0, 0, 0);
    if (paramBitmap != null)
    {
      this.b = paramBitmap.getScaledWidth(paramInt);
      this.c = paramBitmap.getScaledHeight(paramInt);
      this.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_AndroidGraphicsBitmap$Config = paramBitmap.getConfig();
      return;
    }
    this.jdField_a_of_type_Int = 4;
  }
  
  private void a(Rect paramRect)
  {
    this.jdField_a_of_type_AndroidGraphicsRect.set(paramRect);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amjv
 * JD-Core Version:    0.7.0.1
 */
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

public abstract class aqmk
{
  public int c;
  public Rect c;
  public boolean d;
  
  public aqmk()
  {
    this.jdField_c_of_type_Int = 2;
  }
  
  public static int a(Rect paramRect, Drawable paramDrawable)
  {
    float f1 = paramRect.width();
    float f2 = paramRect.height();
    float f3 = paramDrawable.getIntrinsicWidth();
    float f4 = paramDrawable.getIntrinsicHeight();
    if ((f1 <= 0.0F) || (f2 <= 0.0F) || (f3 <= 0.0F) || (f4 <= 0.0F)) {
      return 0;
    }
    f1 = f1 * f4 / (f2 * f3);
    return 0;
  }
  
  public abstract int a();
  
  public Rect a()
  {
    return this.jdField_c_of_type_AndroidGraphicsRect;
  }
  
  public abstract Drawable a();
  
  public boolean a(boolean paramBoolean)
  {
    return true;
  }
  
  public int b()
  {
    return 0;
  }
  
  public Rect b()
  {
    return null;
  }
  
  public int c()
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqmk
 * JD-Core Version:    0.7.0.1
 */
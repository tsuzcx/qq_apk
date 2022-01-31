import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;

class bdxi
  implements Drawable.Callback
{
  bdxi(bdxh parambdxh, bdxf parambdxf) {}
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_Bdxf != null) {
      this.jdField_a_of_type_Bdxf.a(paramDrawable);
    }
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong) {}
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdxi
 * JD-Core Version:    0.7.0.1
 */
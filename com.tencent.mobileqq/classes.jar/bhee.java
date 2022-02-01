import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;

class bhee
  implements Drawable.Callback
{
  bhee(bhed parambhed, bheb parambheb) {}
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_Bheb != null) {
      this.jdField_a_of_type_Bheb.a(paramDrawable);
    }
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong) {}
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhee
 * JD-Core Version:    0.7.0.1
 */
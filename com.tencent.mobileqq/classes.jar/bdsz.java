import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;

class bdsz
  implements Drawable.Callback
{
  bdsz(bdsy parambdsy, bdsw parambdsw) {}
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_Bdsw != null) {
      this.jdField_a_of_type_Bdsw.a(paramDrawable);
    }
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong) {}
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdsz
 * JD-Core Version:    0.7.0.1
 */
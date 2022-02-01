import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;

class bgla
  implements Drawable.Callback
{
  bgla(bgkz parambgkz, bgkx parambgkx) {}
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_Bgkx != null) {
      this.jdField_a_of_type_Bgkx.a(paramDrawable);
    }
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong) {}
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgla
 * JD-Core Version:    0.7.0.1
 */
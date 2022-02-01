import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;

class biep
  implements Drawable.Callback
{
  biep(bieo parambieo, biem parambiem) {}
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_Biem != null) {
      this.jdField_a_of_type_Biem.a(paramDrawable);
    }
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong) {}
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biep
 * JD-Core Version:    0.7.0.1
 */
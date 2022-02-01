import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;

class bhvk
  implements Drawable.Callback
{
  bhvk(bhvj parambhvj, bhvh parambhvh) {}
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    if (this.jdField_a_of_type_Bhvh != null) {
      this.jdField_a_of_type_Bhvh.a(paramDrawable);
    }
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong) {}
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhvk
 * JD-Core Version:    0.7.0.1
 */
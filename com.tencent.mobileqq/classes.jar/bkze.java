import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.view.View;

class bkze
  extends View
{
  private View jdField_a_of_type_AndroidViewView;
  
  public bkze(bkzd parambkzd, Context paramContext, View paramView, Drawable paramDrawable)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidViewView = paramView;
    setBackgroundDrawable(paramDrawable);
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidViewView.invalidate();
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    long l = SystemClock.uptimeMillis();
    this.jdField_a_of_type_AndroidViewView.postDelayed(paramRunnable, paramLong - l);
  }
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    this.jdField_a_of_type_AndroidViewView.removeCallbacks(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkze
 * JD-Core Version:    0.7.0.1
 */
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import com.tencent.mobileqq.loverzone.LoveZoneTabRedDotView;

public class asav
  implements Drawable.Callback
{
  public asav(LoveZoneTabRedDotView paramLoveZoneTabRedDotView) {}
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    this.a.invalidate();
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    this.a.scheduleDrawable(paramDrawable, paramRunnable, paramLong);
  }
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    this.a.unscheduleDrawable(paramDrawable, paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asav
 * JD-Core Version:    0.7.0.1
 */
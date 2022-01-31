import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import com.tencent.mobileqq.loverzone.LoveZoneTabRedDotView;

public class atrx
  implements Drawable.Callback
{
  public atrx(LoveZoneTabRedDotView paramLoveZoneTabRedDotView) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atrx
 * JD-Core Version:    0.7.0.1
 */
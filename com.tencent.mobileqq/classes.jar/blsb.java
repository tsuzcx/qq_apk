import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;

public final class blsb
{
  private final blsc a;
  
  public blsb(Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener)
  {
    this(paramContext, paramOnGestureListener, null);
  }
  
  public blsb(Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener, Handler paramHandler)
  {
    if (Build.VERSION.SDK_INT > 17)
    {
      this.a = new blsf(paramContext, paramOnGestureListener, paramHandler);
      return;
    }
    this.a = new blsd(paramContext, paramOnGestureListener, paramHandler);
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    return this.a.a(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blsb
 * JD-Core Version:    0.7.0.1
 */
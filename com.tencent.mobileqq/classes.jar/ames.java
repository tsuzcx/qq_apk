import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;

public class ames
  implements amep
{
  private final GestureDetector a;
  
  public ames(Context paramContext, GestureDetector.OnGestureListener paramOnGestureListener, Handler paramHandler)
  {
    this.a = new GestureDetector(paramContext, paramOnGestureListener, paramHandler);
  }
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    return this.a.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ames
 * JD-Core Version:    0.7.0.1
 */
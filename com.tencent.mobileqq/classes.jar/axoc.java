import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mobileqq.multicard.MultiCardRootLayout;
import java.lang.ref.WeakReference;

public class axoc
  extends GestureDetector.SimpleOnGestureListener
{
  public axoc(MultiCardRootLayout paramMultiCardRootLayout) {}
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    if ((MultiCardRootLayout.a(this.a)) && (MultiCardRootLayout.a(this.a) != null))
    {
      axof localaxof = (axof)MultiCardRootLayout.a(this.a).get();
      if (localaxof != null) {
        localaxof.a(this.a);
      }
    }
    return super.onSingleTapConfirmed(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axoc
 * JD-Core Version:    0.7.0.1
 */
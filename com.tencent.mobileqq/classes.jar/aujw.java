import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mobileqq.multicard.MultiCardRootLayout;
import java.lang.ref.WeakReference;

public class aujw
  extends GestureDetector.SimpleOnGestureListener
{
  public aujw(MultiCardRootLayout paramMultiCardRootLayout) {}
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    if ((MultiCardRootLayout.a(this.a)) && (MultiCardRootLayout.a(this.a) != null))
    {
      aujz localaujz = (aujz)MultiCardRootLayout.a(this.a).get();
      if (localaujz != null) {
        localaujz.a(this.a);
      }
    }
    return super.onSingleTapConfirmed(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aujw
 * JD-Core Version:    0.7.0.1
 */
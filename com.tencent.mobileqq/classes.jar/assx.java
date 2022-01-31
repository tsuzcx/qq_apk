import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mobileqq.multicard.MultiCardRootLayout;
import java.lang.ref.WeakReference;

public class assx
  extends GestureDetector.SimpleOnGestureListener
{
  public assx(MultiCardRootLayout paramMultiCardRootLayout) {}
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    if ((MultiCardRootLayout.a(this.a)) && (MultiCardRootLayout.a(this.a) != null))
    {
      asta localasta = (asta)MultiCardRootLayout.a(this.a).get();
      if (localasta != null) {
        localasta.a(this.a);
      }
    }
    return super.onSingleTapConfirmed(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     assx
 * JD-Core Version:    0.7.0.1
 */
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mobileqq.multicard.MultiCardRootLayout;
import java.lang.ref.WeakReference;

public class assz
  extends GestureDetector.SimpleOnGestureListener
{
  public assz(MultiCardRootLayout paramMultiCardRootLayout) {}
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    if ((MultiCardRootLayout.a(this.a)) && (MultiCardRootLayout.a(this.a) != null))
    {
      astc localastc = (astc)MultiCardRootLayout.a(this.a).get();
      if (localastc != null) {
        localastc.a(this.a);
      }
    }
    return super.onSingleTapConfirmed(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     assz
 * JD-Core Version:    0.7.0.1
 */
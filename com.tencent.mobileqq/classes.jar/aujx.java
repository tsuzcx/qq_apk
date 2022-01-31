import android.view.GestureDetector;
import android.view.MotionEvent;
import com.tencent.mobileqq.multicard.MultiCardRootLayout;
import java.lang.ref.WeakReference;

public class aujx
  implements bhsx
{
  public aujx(MultiCardRootLayout paramMultiCardRootLayout) {}
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (MultiCardRootLayout.a(this.a) != null)
    {
      aujz localaujz = (aujz)MultiCardRootLayout.a(this.a).get();
      if ((localaujz != null) && (localaujz.a(i))) {
        return true;
      }
    }
    if (MultiCardRootLayout.a(this.a) != null) {
      MultiCardRootLayout.a(this.a).onTouchEvent(paramMotionEvent);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aujx
 * JD-Core Version:    0.7.0.1
 */
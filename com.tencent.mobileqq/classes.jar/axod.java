import android.view.GestureDetector;
import android.view.MotionEvent;
import com.tencent.mobileqq.multicard.MultiCardRootLayout;
import java.lang.ref.WeakReference;

public class axod
  implements bllt
{
  public axod(MultiCardRootLayout paramMultiCardRootLayout) {}
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (MultiCardRootLayout.a(this.a) != null)
    {
      axof localaxof = (axof)MultiCardRootLayout.a(this.a).get();
      if ((localaxof != null) && (localaxof.a(i))) {
        return true;
      }
    }
    if (MultiCardRootLayout.a(this.a) != null) {
      MultiCardRootLayout.a(this.a).onTouchEvent(paramMotionEvent);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axod
 * JD-Core Version:    0.7.0.1
 */
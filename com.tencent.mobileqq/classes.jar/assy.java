import android.view.GestureDetector;
import android.view.MotionEvent;
import com.tencent.mobileqq.multicard.MultiCardRootLayout;
import java.lang.ref.WeakReference;

public class assy
  implements bfrj
{
  public assy(MultiCardRootLayout paramMultiCardRootLayout) {}
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (MultiCardRootLayout.a(this.a) != null)
    {
      asta localasta = (asta)MultiCardRootLayout.a(this.a).get();
      if ((localasta != null) && (localasta.a(i))) {
        return true;
      }
    }
    if (MultiCardRootLayout.a(this.a) != null) {
      MultiCardRootLayout.a(this.a).onTouchEvent(paramMotionEvent);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     assy
 * JD-Core Version:    0.7.0.1
 */
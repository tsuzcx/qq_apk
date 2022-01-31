import android.view.GestureDetector;
import android.view.MotionEvent;
import com.tencent.mobileqq.multicard.MultiCardRootLayout;
import java.lang.ref.WeakReference;

public class asta
  implements bfsa
{
  public asta(MultiCardRootLayout paramMultiCardRootLayout) {}
  
  public boolean a(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getActionMasked();
    if (MultiCardRootLayout.a(this.a) != null)
    {
      astc localastc = (astc)MultiCardRootLayout.a(this.a).get();
      if ((localastc != null) && (localastc.a(i))) {
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
 * Qualified Name:     asta
 * JD-Core Version:    0.7.0.1
 */
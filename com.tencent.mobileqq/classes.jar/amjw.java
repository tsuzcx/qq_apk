import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenRelativeLayout;

public class amjw
  implements ViewTreeObserver.OnPreDrawListener
{
  public amjw(ColorNoteSmallScreenRelativeLayout paramColorNoteSmallScreenRelativeLayout) {}
  
  public boolean onPreDraw()
  {
    this.a.getViewTreeObserver().removeOnPreDrawListener(this);
    ColorNoteSmallScreenRelativeLayout.a(this.a);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     amjw
 * JD-Core Version:    0.7.0.1
 */
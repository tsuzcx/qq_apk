import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.hiboom.RichTextPanel;

public class avsc
  extends RelativeLayout
{
  public avsc(RichTextPanel paramRichTextPanel, Context paramContext)
  {
    super(paramContext);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 0) && (getParent() != null)) {
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avsc
 * JD-Core Version:    0.7.0.1
 */
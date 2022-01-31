import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.multicard.MultiCardCustomLayout;

public class asrp
  extends GestureDetector.SimpleOnGestureListener
{
  public asrp(MultiCardCustomLayout paramMultiCardCustomLayout) {}
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    if (MultiCardCustomLayout.a(this.a) != null) {
      MultiCardCustomLayout.a(this.a).onLongClick(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     asrp
 * JD-Core Version:    0.7.0.1
 */
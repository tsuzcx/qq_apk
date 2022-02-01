import android.view.GestureDetector.OnDoubleTapListener;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.mobileqq.widget.TabDragAnimationView;

public class bhjn
  extends GestureDetector.SimpleOnGestureListener
{
  public bhjn(TabDragAnimationView paramTabDragAnimationView) {}
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    if (TabDragAnimationView.a(this.a) != null) {
      return TabDragAnimationView.a(this.a).onDoubleTap(paramMotionEvent);
    }
    return super.onDoubleTap(paramMotionEvent);
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    super.onLongPress(paramMotionEvent);
    if (TabDragAnimationView.a(this.a) != null) {
      TabDragAnimationView.a(this.a).onLongClick(this.a);
    }
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    if (TabDragAnimationView.a(this.a) != null) {
      TabDragAnimationView.a(this.a).onSingleTapConfirmed(paramMotionEvent);
    }
    ViewParent localViewParent = this.a.getParent();
    if (localViewParent != null) {
      ((ViewGroup)localViewParent).performClick();
    }
    return super.onSingleTapConfirmed(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhjn
 * JD-Core Version:    0.7.0.1
 */
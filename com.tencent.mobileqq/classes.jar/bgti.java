import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.qqmini.sdk.core.widget.media.VideoGestureRelativeLayout;

public class bgti
  implements View.OnTouchListener
{
  public bgti(VideoGestureRelativeLayout paramVideoGestureRelativeLayout) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 1) && (VideoGestureRelativeLayout.a(this.a)))
    {
      if (VideoGestureRelativeLayout.a(this.a) != null) {
        VideoGestureRelativeLayout.a(this.a).d(paramMotionEvent);
      }
      VideoGestureRelativeLayout.a(this.a, false);
    }
    return VideoGestureRelativeLayout.a(this.a).onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgti
 * JD-Core Version:    0.7.0.1
 */
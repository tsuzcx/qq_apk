import android.util.Log;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.qqmini.sdk.core.widget.media.VideoGestureRelativeLayout;

public class beoj
  extends GestureDetector.SimpleOnGestureListener
{
  private VideoGestureRelativeLayout b;
  
  public beoj(VideoGestureRelativeLayout paramVideoGestureRelativeLayout1, VideoGestureRelativeLayout paramVideoGestureRelativeLayout2)
  {
    this.b = paramVideoGestureRelativeLayout2;
  }
  
  public boolean onContextClick(MotionEvent paramMotionEvent)
  {
    Log.d("gesturetest", "onContextClick: ");
    return true;
  }
  
  public boolean onDoubleTap(MotionEvent paramMotionEvent)
  {
    Log.d("gesturetest", "onDoubleTap: ");
    if (VideoGestureRelativeLayout.a(this.a) != null) {
      VideoGestureRelativeLayout.a(this.a).b(paramMotionEvent);
    }
    return super.onDoubleTap(paramMotionEvent);
  }
  
  public boolean onDoubleTapEvent(MotionEvent paramMotionEvent)
  {
    Log.d("gesturetest", "onDoubleTapEvent: ");
    return super.onDoubleTapEvent(paramMotionEvent);
  }
  
  public boolean onDown(MotionEvent paramMotionEvent)
  {
    Log.d("gesturetest", "onDown: ");
    VideoGestureRelativeLayout.a(this.a, false);
    VideoGestureRelativeLayout.a(this.a, 0);
    if (VideoGestureRelativeLayout.a(this.a) != null) {
      VideoGestureRelativeLayout.a(this.a).c(paramMotionEvent);
    }
    return true;
  }
  
  public boolean onFling(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    Log.d("gesturetest", "onFling: ");
    return super.onFling(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
  }
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    Log.d("gesturetest", "onLongPress: ");
    super.onLongPress(paramMotionEvent);
  }
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    Log.d("gesturetest", "onScroll: e1:" + paramMotionEvent1.getX() + "," + paramMotionEvent1.getY());
    Log.d("gesturetest", "onScroll: e2:" + paramMotionEvent2.getX() + "," + paramMotionEvent2.getY());
    Log.d("gesturetest", "onScroll: X:" + paramFloat1 + "  Y:" + paramFloat2);
    switch (VideoGestureRelativeLayout.a(this.a))
    {
    default: 
      return true;
    case 0: 
      Log.d("gesturetest", "NONE: ");
      if (Math.abs(paramFloat1) - Math.abs(paramFloat2) > VideoGestureRelativeLayout.b(this.a))
      {
        VideoGestureRelativeLayout.a(this.a, 3);
        return true;
      }
      if (paramMotionEvent1.getX() < this.a.getWidth() / 2)
      {
        VideoGestureRelativeLayout.a(this.a, 2);
        return true;
      }
      VideoGestureRelativeLayout.a(this.a, 1);
      return true;
    case 1: 
      if (VideoGestureRelativeLayout.a(this.a) != null) {
        VideoGestureRelativeLayout.a(this.a).b(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
      }
      Log.d("gesturetest", "VOLUME: ");
      return true;
    case 2: 
      if (VideoGestureRelativeLayout.a(this.a) != null) {
        VideoGestureRelativeLayout.a(this.a).a(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
      }
      Log.d("gesturetest", "BRIGHTNESS: ");
      return true;
    }
    if (VideoGestureRelativeLayout.a(this.a) != null) {
      VideoGestureRelativeLayout.a(this.a).c(paramMotionEvent1, paramMotionEvent2, paramFloat1, paramFloat2);
    }
    VideoGestureRelativeLayout.a(this.a, true);
    Log.d("gesturetest", "FF_REW: ");
    return true;
  }
  
  public void onShowPress(MotionEvent paramMotionEvent)
  {
    Log.d("gesturetest", "onShowPress: ");
    super.onShowPress(paramMotionEvent);
  }
  
  public boolean onSingleTapConfirmed(MotionEvent paramMotionEvent)
  {
    Log.d("gesturetest", "onSingleTapConfirmed: ");
    if (VideoGestureRelativeLayout.a(this.a) != null) {
      VideoGestureRelativeLayout.a(this.a).a(paramMotionEvent);
    }
    return super.onSingleTapConfirmed(paramMotionEvent);
  }
  
  public boolean onSingleTapUp(MotionEvent paramMotionEvent)
  {
    Log.d("gesturetest", "onSingleTapUp: ");
    return super.onSingleTapUp(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     beoj
 * JD-Core Version:    0.7.0.1
 */
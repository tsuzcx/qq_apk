import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import com.tencent.ttpic.openapi.filter.GLGestureListener;
import com.tencent.ttpic.openapi.filter.GLGestureProxy;

public class axkv
  implements GLGestureListener
{
  private ViewPager a;
  
  public axkv(ViewPager paramViewPager)
  {
    this.a = paramViewPager;
  }
  
  public void a(ViewPager paramViewPager)
  {
    this.a = paramViewPager;
  }
  
  public int onGetPriority()
  {
    return 1002;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent, boolean paramBoolean)
  {
    int i = paramMotionEvent.getPointerCount();
    paramMotionEvent.getAction();
    if ((i == 1) && (!paramBoolean) && (this.a != null) && (this.a.isShown())) {}
    try
    {
      this.a.onTouchEvent(paramMotionEvent);
      if ((i != 2) || (!paramBoolean) || (this.a == null) || (!this.a.isShown())) {}
    }
    catch (Exception localException)
    {
      try
      {
        if (GLGestureProxy.getInstance().checkSecendFinger(paramMotionEvent))
        {
          paramMotionEvent = GLGestureProxy.getInstance().getSecendFingerMotionEvent(paramMotionEvent);
          this.a.onTouchEvent(paramMotionEvent);
          paramMotionEvent.recycle();
        }
        return false;
        localException = localException;
        localException.printStackTrace();
      }
      catch (Exception paramMotionEvent)
      {
        for (;;)
        {
          paramMotionEvent.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axkv
 * JD-Core Version:    0.7.0.1
 */
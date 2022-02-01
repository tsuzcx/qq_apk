import android.app.Activity;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;

public class azas
  extends FlingGestureHandler
{
  boolean a = true;
  
  public azas(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
    if (!b()) {
      a();
    }
    this.mTopLayout.setInterceptTouchFlag(paramBoolean);
  }
  
  public void flingLToR()
  {
    if (this.a) {
      super.flingLToR();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azas
 * JD-Core Version:    0.7.0.1
 */
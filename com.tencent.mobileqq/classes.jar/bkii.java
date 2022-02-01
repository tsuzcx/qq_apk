import android.app.Activity;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;

public class bkii
  extends FlingGestureHandler
{
  boolean a = true;
  
  public bkii(Activity paramActivity)
  {
    super(paramActivity);
  }
  
  public void flingLToR()
  {
    if (this.a) {
      super.flingLToR();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkii
 * JD-Core Version:    0.7.0.1
 */
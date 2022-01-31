import android.app.Activity;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;

public class bilm
  extends FlingGestureHandler
{
  boolean a = true;
  
  public bilm(Activity paramActivity)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bilm
 * JD-Core Version:    0.7.0.1
 */
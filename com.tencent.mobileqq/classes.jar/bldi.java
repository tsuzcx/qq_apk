import android.app.Activity;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;

public class bldi
  extends FlingGestureHandler
{
  boolean a = true;
  
  public bldi(Activity paramActivity)
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
 * Qualified Name:     bldi
 * JD-Core Version:    0.7.0.1
 */
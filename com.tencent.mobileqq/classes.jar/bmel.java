import android.app.Activity;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;

public class bmel
  extends FlingGestureHandler
{
  boolean a = true;
  
  public bmel(Activity paramActivity)
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
 * Qualified Name:     bmel
 * JD-Core Version:    0.7.0.1
 */
import android.app.Activity;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;

public class bgjx
  extends FlingGestureHandler
{
  boolean a = true;
  
  public bgjx(Activity paramActivity)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgjx
 * JD-Core Version:    0.7.0.1
 */
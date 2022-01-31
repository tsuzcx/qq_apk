import android.app.Activity;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;

public class bfcg
  extends FlingGestureHandler
{
  boolean a = true;
  
  public bfcg(Activity paramActivity)
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
 * Qualified Name:     bfcg
 * JD-Core Version:    0.7.0.1
 */
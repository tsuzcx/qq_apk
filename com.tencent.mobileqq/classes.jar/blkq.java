import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

public class blkq
  extends GestureDetector.SimpleOnGestureListener
{
  protected blkq(bljy parambljy) {}
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    if ((!bljy.a(this.a)) && (System.currentTimeMillis() - bljy.a(this.a) > 5000L))
    {
      this.a.a.a(196614, new Object[0]);
      bljy.a(this.a, System.currentTimeMillis());
      this.a.c(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blkq
 * JD-Core Version:    0.7.0.1
 */
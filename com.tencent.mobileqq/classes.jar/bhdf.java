import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;

class bhdf
  extends GestureDetector.SimpleOnGestureListener
{
  private bhdf(bhcw parambhcw) {}
  
  public void onLongPress(MotionEvent paramMotionEvent)
  {
    if ((bhcw.a(this.a) != wsh.c) && (System.currentTimeMillis() - bhcw.a(this.a) > 5000L))
    {
      bhcw.a(this.a).a(196614, new Object[0]);
      bhcw.a(this.a, System.currentTimeMillis());
      this.a.d(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhdf
 * JD-Core Version:    0.7.0.1
 */
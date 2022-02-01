import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.tencent.mobileqq.widget.PagingScrollView;

public class bhfw
  extends GestureDetector.SimpleOnGestureListener
{
  public bhfw(PagingScrollView paramPagingScrollView) {}
  
  public boolean onScroll(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2, float paramFloat1, float paramFloat2)
  {
    if (PagingScrollView.access$000(this.a))
    {
      PagingScrollView.access$002(this.a, false);
      paramFloat1 = Math.abs(paramFloat1);
      paramFloat2 = Math.abs(paramFloat2);
      if (paramFloat2 > paramFloat1)
      {
        if (paramFloat1 >= 0.01F) {
          break label62;
        }
        PagingScrollView.access$002(this.a, true);
      }
    }
    for (;;)
    {
      return PagingScrollView.access$000(this.a);
      label62:
      if (paramFloat2 / paramFloat1 > 1.73205F) {
        PagingScrollView.access$002(this.a, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhfw
 * JD-Core Version:    0.7.0.1
 */
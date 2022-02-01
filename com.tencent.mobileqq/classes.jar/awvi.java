import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class awvi
  implements View.OnTouchListener
{
  awvi(awur paramawur) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 0) || (paramMotionEvent.getAction() == 2)) {
      this.a.a.findViewById(2131364832).setAlpha(0.5F);
    }
    for (;;)
    {
      return false;
      this.a.a.findViewById(2131364832).setAlpha(1.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awvi
 * JD-Core Version:    0.7.0.1
 */
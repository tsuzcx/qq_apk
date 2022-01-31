import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class avdp
  implements View.OnTouchListener
{
  avdp(avcw paramavcw) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if ((paramMotionEvent.getAction() == 0) || (paramMotionEvent.getAction() == 2)) {
      this.a.a.findViewById(2131376512).setAlpha(0.5F);
    }
    for (;;)
    {
      return false;
      this.a.a.findViewById(2131376512).setAlpha(1.0F);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     avdp
 * JD-Core Version:    0.7.0.1
 */
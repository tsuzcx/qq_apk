import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class bjzv
  implements View.OnTouchListener
{
  bjzv(bjzu parambjzu) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1) {
      bjzu.a(this.a);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjzv
 * JD-Core Version:    0.7.0.1
 */
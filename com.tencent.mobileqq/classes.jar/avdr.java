import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.richstatus.SignatureHistoryFragment;

public class avdr
  implements View.OnTouchListener
{
  public avdr(SignatureHistoryFragment paramSignatureHistoryFragment) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      if (paramMotionEvent.getY() < paramView.findViewById(2131312524).getHeight() + aciy.a(30.0F, paramView.getResources())) {
        SignatureHistoryFragment.a(this.a, true);
      }
    }
    else {
      return false;
    }
    SignatureHistoryFragment.a(this.a, false);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avdr
 * JD-Core Version:    0.7.0.1
 */
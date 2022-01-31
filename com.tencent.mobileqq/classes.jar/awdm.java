import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.richstatus.SignatureHistoryFragment;

public class awdm
  implements View.OnTouchListener
{
  public awdm(SignatureHistoryFragment paramSignatureHistoryFragment) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      if (paramMotionEvent.getY() < paramView.findViewById(2131378352).getHeight() + actj.a(30.0F, paramView.getResources())) {
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
 * Qualified Name:     awdm
 * JD-Core Version:    0.7.0.1
 */
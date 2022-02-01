import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.richstatus.SignatureHistoryFragment;

public class bbuj
  implements View.OnTouchListener
{
  public bbuj(SignatureHistoryFragment paramSignatureHistoryFragment) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      if (paramMotionEvent.getY() < paramView.findViewById(2131380163).getHeight() + AIOUtils.dp2px(30.0F, paramView.getResources())) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbuj
 * JD-Core Version:    0.7.0.1
 */
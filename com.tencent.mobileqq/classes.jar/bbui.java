import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.richstatus.SignatureHistoryFragment;

public class bbui
  implements View.OnTouchListener
{
  public bbui(SignatureHistoryFragment paramSignatureHistoryFragment) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    return SignatureHistoryFragment.a(this.a, paramView, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbui
 * JD-Core Version:    0.7.0.1
 */
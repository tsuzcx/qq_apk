import android.widget.EditText;
import android.widget.PopupWindow.OnDismissListener;
import com.tencent.mobileqq.forward.ForwardFileOption;

public class auqu
  implements PopupWindow.OnDismissListener
{
  public auqu(ForwardFileOption paramForwardFileOption) {}
  
  public void onDismiss()
  {
    if (!this.a.l) {
      ForwardFileOption.a(this.a, -8);
    }
    if (ForwardFileOption.a(this.a) != null)
    {
      ForwardFileOption.a(this.a).setFocusable(true);
      ForwardFileOption.a(this.a).setFocusableInTouchMode(true);
      ForwardFileOption.a(this.a).requestFocus();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auqu
 * JD-Core Version:    0.7.0.1
 */
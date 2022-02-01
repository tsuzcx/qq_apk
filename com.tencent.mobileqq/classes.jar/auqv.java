import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mobileqq.forward.ForwardFileOption;

public class auqv
  implements TextView.OnEditorActionListener
{
  public auqv(ForwardFileOption paramForwardFileOption) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    return (paramInt == 4) || (paramInt == 6) || ((paramKeyEvent != null) && (66 == paramKeyEvent.getKeyCode()) && (paramKeyEvent.getAction() == 0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auqv
 * JD-Core Version:    0.7.0.1
 */
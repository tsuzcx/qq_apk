import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mobileqq.richstatus.SignTextEditFragment;

public class awcp
  implements TextView.OnEditorActionListener
{
  public awcp(SignTextEditFragment paramSignTextEditFragment) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramKeyEvent != null) && (paramKeyEvent.getKeyCode() == 66)) {
      bfni.b(paramTextView);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awcp
 * JD-Core Version:    0.7.0.1
 */
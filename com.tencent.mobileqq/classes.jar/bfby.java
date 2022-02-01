import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mobileqq.troop.activity.TroopNickRuleFragment;

public class bfby
  implements TextView.OnEditorActionListener
{
  public bfby(TroopNickRuleFragment paramTroopNickRuleFragment) {}
  
  public boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 6) || (paramInt == 2))
    {
      this.a.a(-1.0F, -1.0F);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfby
 * JD-Core Version:    0.7.0.1
 */
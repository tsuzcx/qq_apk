import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.troop.activity.TroopNickRuleFragment;

public class bdun
  implements View.OnTouchListener
{
  public bdun(TroopNickRuleFragment paramTroopNickRuleFragment) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    this.a.a(paramMotionEvent.getX(), paramMotionEvent.getY());
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdun
 * JD-Core Version:    0.7.0.1
 */
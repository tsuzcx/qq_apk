import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.troop.activity.TroopNickRuleFragment;

public class bfbq
  implements View.OnTouchListener
{
  public bfbq(TroopNickRuleFragment paramTroopNickRuleFragment) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    this.a.a(paramMotionEvent.getX(), paramMotionEvent.getY());
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfbq
 * JD-Core Version:    0.7.0.1
 */
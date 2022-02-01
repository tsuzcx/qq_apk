import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.activity.TroopNickRuleFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bfbv
  implements View.OnClickListener
{
  public bfbv(TroopNickRuleFragment paramTroopNickRuleFragment) {}
  
  public void onClick(View paramView)
  {
    TroopNickRuleFragment.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfbv
 * JD-Core Version:    0.7.0.1
 */
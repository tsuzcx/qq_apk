import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.createNewTroop.NewTroopCreateActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bfeg
  implements View.OnClickListener
{
  public bfeg(NewTroopCreateActivity paramNewTroopCreateActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfeg
 * JD-Core Version:    0.7.0.1
 */
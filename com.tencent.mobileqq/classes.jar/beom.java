import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.createNewTroop.NewTroopCreateActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class beom
  implements View.OnClickListener
{
  public beom(NewTroopCreateActivity paramNewTroopCreateActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beom
 * JD-Core Version:    0.7.0.1
 */
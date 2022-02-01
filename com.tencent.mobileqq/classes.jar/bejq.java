import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity.16;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bejq
  implements View.OnClickListener
{
  public bejq(TroopBarPublishActivity.16 param16) {}
  
  public void onClick(View paramView)
  {
    this.a.this$0.t();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bejq
 * JD-Core Version:    0.7.0.1
 */
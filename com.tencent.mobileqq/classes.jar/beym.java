import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class beym
  implements View.OnClickListener
{
  public beym(TroopBarPublishActivity paramTroopBarPublishActivity) {}
  
  public void onClick(View paramView)
  {
    QQToast.a(this.a.a, anvx.a(2131714587), 0).a();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beym
 * JD-Core Version:    0.7.0.1
 */
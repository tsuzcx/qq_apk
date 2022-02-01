import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.activity.TroopBarPublishActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bfis
  implements View.OnClickListener
{
  public bfis(TroopBarPublishActivity paramTroopBarPublishActivity) {}
  
  public void onClick(View paramView)
  {
    QQToast.a(this.a.a, anzj.a(2131714008), 0).a();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfis
 * JD-Core Version:    0.7.0.1
 */
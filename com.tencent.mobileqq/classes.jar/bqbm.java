import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.activity.TroopBarPublishUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bqbm
  implements View.OnClickListener
{
  bqbm(bqbl parambqbl) {}
  
  public void onClick(View paramView)
  {
    if (bqbl.a(this.a) == -1) {
      bqbl.a(this.a, "Clk_add_topic");
    }
    TroopBarPublishUtils.a((Activity)this.a.a(), 1001, bqbl.a(this.a));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqbm
 * JD-Core Version:    0.7.0.1
 */
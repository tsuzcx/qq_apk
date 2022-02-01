import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.troop_homework.outer.TroopHWRecordBaseActivity;

public class bkyq
  implements View.OnClickListener
{
  public bkyq(TroopHWRecordBaseActivity paramTroopHWRecordBaseActivity) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (!this.a.a)
      {
        this.a.setResult(0);
        this.a.finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkyq
 * JD-Core Version:    0.7.0.1
 */
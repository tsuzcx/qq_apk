import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.GroupManagerActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bfna
  implements View.OnClickListener
{
  bfna(bfmz parambfmz) {}
  
  public void onClick(View paramView)
  {
    GroupManagerActivity.a((Activity)bfmz.a(this.a));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfna
 * JD-Core Version:    0.7.0.1
 */
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.GroupManagerActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bfdn
  implements View.OnClickListener
{
  bfdn(bfdm parambfdm) {}
  
  public void onClick(View paramView)
  {
    GroupManagerActivity.a((Activity)bfdm.a(this.a));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfdn
 * JD-Core Version:    0.7.0.1
 */
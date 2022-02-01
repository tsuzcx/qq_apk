import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.GroupManagerActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bent
  implements View.OnClickListener
{
  bent(bens parambens) {}
  
  public void onClick(View paramView)
  {
    GroupManagerActivity.a((Activity)bens.a(this.a));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bent
 * JD-Core Version:    0.7.0.1
 */
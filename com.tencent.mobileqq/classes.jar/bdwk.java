import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.GroupManagerActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bdwk
  implements View.OnClickListener
{
  bdwk(bdwj parambdwj) {}
  
  public void onClick(View paramView)
  {
    GroupManagerActivity.a((Activity)bdwj.a(this.a));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdwk
 * JD-Core Version:    0.7.0.1
 */
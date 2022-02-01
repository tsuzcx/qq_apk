import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.GroupManagerActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class amfb
  implements View.OnClickListener
{
  amfb(amez paramamez) {}
  
  public void onClick(View paramView)
  {
    GroupManagerActivity.a((Activity)amez.a(this.a));
    bdll.b(amez.a(this.a), "CliOper", "", "", "category", "Edit_category", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amfb
 * JD-Core Version:    0.7.0.1
 */
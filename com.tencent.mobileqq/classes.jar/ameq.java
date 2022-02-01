import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ameq
  implements View.OnClickListener
{
  public ameq(SelectMemberActivity paramSelectMemberActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ameq
 * JD-Core Version:    0.7.0.1
 */
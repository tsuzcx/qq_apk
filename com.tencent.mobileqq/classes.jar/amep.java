import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity.2.1;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class amep
  implements View.OnClickListener
{
  public amep(SelectMemberActivity paramSelectMemberActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.onBackEvent();
    if (AppSetting.c) {
      this.a.c.post(new SelectMemberActivity.2.1(this));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amep
 * JD-Core Version:    0.7.0.1
 */
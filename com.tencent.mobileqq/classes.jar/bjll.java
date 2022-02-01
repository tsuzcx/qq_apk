import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.open.agent.BindGroupFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bjll
  implements View.OnClickListener
{
  public bjll(BindGroupFragment paramBindGroupFragment) {}
  
  public void onClick(View paramView)
  {
    BindGroupFragment.a(this.a, anzj.a(2131700036));
    ((aoip)BindGroupFragment.a(this.a).a(20)).a(Integer.valueOf(BindGroupFragment.a(this.a)).intValue(), Integer.valueOf(BindGroupFragment.b(this.a)).intValue());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjll
 * JD-Core Version:    0.7.0.1
 */
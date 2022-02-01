import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.open.agent.BindGroupFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bjbw
  implements View.OnClickListener
{
  public bjbw(BindGroupFragment paramBindGroupFragment) {}
  
  public void onClick(View paramView)
  {
    BindGroupFragment.a(this.a, anvx.a(2131700622));
    ((aoep)BindGroupFragment.a(this.a).getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).a(Integer.valueOf(BindGroupFragment.a(this.a)).intValue(), Integer.valueOf(BindGroupFragment.b(this.a)).intValue());
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjbw
 * JD-Core Version:    0.7.0.1
 */
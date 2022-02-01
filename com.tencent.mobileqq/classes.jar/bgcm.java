import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bgcm
  implements View.OnClickListener
{
  bgcm(bgch parambgch) {}
  
  public void onClick(View paramView)
  {
    if ((paramView == null) || (bgch.a(this.a) == null) || (bgch.a(this.a).app == null) || (bgch.a(this.a) == null)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((paramView.getTag() instanceof bgba))
      {
        bgch.a(this.a).a(paramView);
        bgch.a(this.a).b(paramView, 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgcm
 * JD-Core Version:    0.7.0.1
 */
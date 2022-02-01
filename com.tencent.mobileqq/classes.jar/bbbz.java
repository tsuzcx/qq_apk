import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.relationx.icebreaking.AIOIceBreakView;
import com.tencent.mobileqq.relationx.icebreaking.AIOIceBreakView.1.1;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bbbz
  implements View.OnClickListener
{
  public bbbz(AIOIceBreakView paramAIOIceBreakView) {}
  
  public void onClick(View paramView)
  {
    AIOIceBreakView.a(this.a).u(24);
    paramView.postDelayed(new AIOIceBreakView.1.1(this), 500L);
    if (adak.a(AIOIceBreakView.a(this.a).a.a) != 1044) {
      if (AIOIceBreakView.a(this.a).a.a != 0) {
        break label136;
      }
    }
    label136:
    for (int i = 1;; i = 2)
    {
      bdll.b(AIOIceBreakView.a(this.a), "CliOper", "", "", "0X800A4CC", "0X800A4CC", i, 0, "", "", "", "");
      bdll.b(AIOIceBreakView.a(this.a), "CliOper", "", "", "0X800A4CD", "0X800A4CD", i, 0, "", "", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbbz
 * JD-Core Version:    0.7.0.1
 */
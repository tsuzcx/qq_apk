import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.mobileqq.ark.ArkAiAppPanel.4.1;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class apmj
  implements View.OnClickListener
{
  apmj(apmg paramapmg) {}
  
  public void onClick(View paramView)
  {
    if ((apmg.a(this.a) == null) || (apmg.a(this.a).size() <= 0) || (apmg.a(this.a) >= apmg.a(this.a).size()) || (apmg.a(this.a).get(apmg.a(this.a)) == null)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      String str = ((agpp)apmg.a(this.a).get(apmg.a(this.a))).getAppName();
      ArkAppCenter.a().post(str, new ArkAiAppPanel.4.1(this, str));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apmj
 * JD-Core Version:    0.7.0.1
 */
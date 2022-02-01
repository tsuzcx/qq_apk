import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.mobileqq.ark.ArkAiAppPanel.4.1;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class apwq
  implements View.OnClickListener
{
  apwq(apwn paramapwn) {}
  
  public void onClick(View paramView)
  {
    if ((apwn.a(this.a) == null) || (apwn.a(this.a).size() <= 0) || (apwn.a(this.a) >= apwn.a(this.a).size()) || (apwn.a(this.a).get(apwn.a(this.a)) == null)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      String str = ((agnw)apwn.a(this.a).get(apwn.a(this.a))).getAppName();
      ArkAppCenter.a().post(str, new ArkAiAppPanel.4.1(this, str));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apwq
 * JD-Core Version:    0.7.0.1
 */
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.mobileqq.ark.ArkAiAppPanel.4.1;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class aotm
  implements View.OnClickListener
{
  aotm(aotj paramaotj) {}
  
  public void onClick(View paramView)
  {
    if ((aotj.a(this.a) == null) || (aotj.a(this.a).size() <= 0) || (aotj.a(this.a) >= aotj.a(this.a).size()) || (aotj.a(this.a).get(aotj.a(this.a)) == null)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      String str = ((afvh)aotj.a(this.a).get(aotj.a(this.a))).getAppName();
      ArkAppCenter.a().post(str, new ArkAiAppPanel.4.1(this, str));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aotm
 * JD-Core Version:    0.7.0.1
 */
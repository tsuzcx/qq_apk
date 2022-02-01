import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.mobileqq.ark.ArkAiAppPanel.4.1;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class apzz
  implements View.OnClickListener
{
  apzz(apzw paramapzw) {}
  
  public void onClick(View paramView)
  {
    if ((apzw.a(this.a) == null) || (apzw.a(this.a).size() <= 0) || (apzw.a(this.a) >= apzw.a(this.a).size()) || (apzw.a(this.a).get(apzw.a(this.a)) == null)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      String str = ((agyv)apzw.a(this.a).get(apzw.a(this.a))).getAppName();
      ArkAppCenter.a().post(str, new ArkAiAppPanel.4.1(this, str));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apzz
 * JD-Core Version:    0.7.0.1
 */
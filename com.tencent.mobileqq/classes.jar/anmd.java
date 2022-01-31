import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.mobileqq.ark.ArkAiAppPanel.4.1;
import com.tencent.mobileqq.ark.ArkAppCenter;
import java.util.ArrayList;

public class anmd
  implements View.OnClickListener
{
  anmd(anma paramanma) {}
  
  public void onClick(View paramView)
  {
    if ((anma.a(this.a) == null) || (anma.a(this.a).size() <= 0) || (anma.a(this.a) >= anma.a(this.a).size()) || (anma.a(this.a).get(anma.a(this.a)) == null)) {
      return;
    }
    paramView = ((afih)anma.a(this.a).get(anma.a(this.a))).getAppName();
    ArkAppCenter.a().post(paramView, new ArkAiAppPanel.4.1(this, paramView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anmd
 * JD-Core Version:    0.7.0.1
 */
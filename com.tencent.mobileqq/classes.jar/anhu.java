import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.mobileqq.ark.ArkAiAppPanel.4.1;
import com.tencent.mobileqq.ark.ArkAppCenter;
import java.util.ArrayList;

public class anhu
  implements View.OnClickListener
{
  anhu(anhr paramanhr) {}
  
  public void onClick(View paramView)
  {
    if ((anhr.a(this.a) == null) || (anhr.a(this.a).size() <= 0) || (anhr.a(this.a) >= anhr.a(this.a).size()) || (anhr.a(this.a).get(anhr.a(this.a)) == null)) {
      return;
    }
    paramView = ((afds)anhr.a(this.a).get(anhr.a(this.a))).getAppName();
    ArkAppCenter.a().post(paramView, new ArkAiAppPanel.4.1(this, paramView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anhu
 * JD-Core Version:    0.7.0.1
 */
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.open.appstore.component.CommonTitleBar;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bjsr
  implements View.OnClickListener
{
  public bjsr(CommonTitleBar paramCommonTitleBar) {}
  
  public void onClick(View paramView)
  {
    if (CommonTitleBar.a(this.a) != null) {
      CommonTitleBar.a(this.a).a();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjsr
 * JD-Core Version:    0.7.0.1
 */
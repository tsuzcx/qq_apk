import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.open.agent.OpenAuthorityAccountView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bjdj
  implements View.OnClickListener
{
  public bjdj(OpenAuthorityAccountView paramOpenAuthorityAccountView) {}
  
  public void onClick(View paramView)
  {
    if (OpenAuthorityAccountView.a(this.a) != null) {
      OpenAuthorityAccountView.a(this.a).b();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjdj
 * JD-Core Version:    0.7.0.1
 */
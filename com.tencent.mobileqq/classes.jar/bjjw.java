import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.open.agent.AuthorityAccountView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bjjw
  implements View.OnClickListener
{
  public bjjw(AuthorityAccountView paramAuthorityAccountView) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject != null) && ((localObject instanceof String))) {
      this.a.b((String)localObject);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjjw
 * JD-Core Version:    0.7.0.1
 */
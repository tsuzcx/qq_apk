import android.view.View;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.open.agent.AuthorityControlFragment;
import com.tencent.widget.ListView;

public class bjbc
  implements bldp
{
  public bjbc(AuthorityControlFragment paramAuthorityControlFragment) {}
  
  public void onNotCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    if (paramInt == 0) {
      AuthorityControlFragment.a(this.a).c(0L);
    }
  }
  
  public void onViewCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    if (paramInt == 0) {
      AuthorityControlFragment.a(this.a).b(0L);
    }
  }
  
  public boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    if (paramInt == 0)
    {
      AuthorityControlFragment.a(this.a).a(0L);
      AuthorityControlFragment.a(this.a, (bjpj)AuthorityControlFragment.a(this.a).getBusinessHandler(BusinessHandlerFactory.OPEN_AGENT_HANDLER));
      AuthorityControlFragment.a(this.a).a();
      AuthorityControlFragment.a(this.a).notifyDataSetChanged();
    }
    return true;
  }
  
  public void onViewNotCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    if (paramInt == 0) {
      AuthorityControlFragment.a(this.a).c(0L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjbc
 * JD-Core Version:    0.7.0.1
 */
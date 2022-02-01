import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.open.agent.AuthorityControlFragment;
import com.tencent.widget.ListView;

public class bhqf
  implements bjsd
{
  public bhqf(AuthorityControlFragment paramAuthorityControlFragment) {}
  
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
      AuthorityControlFragment.a(this.a, (bieh)AuthorityControlFragment.a(this.a).getBusinessHandler(151));
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
 * Qualified Name:     bhqf
 * JD-Core Version:    0.7.0.1
 */
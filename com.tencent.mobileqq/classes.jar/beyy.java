import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.troop.activity.TroopBarPublishLocationSelectActivity;
import com.tencent.mobileqq.troop.activity.TroopBarPublishLocationSelectActivity.2.1;
import com.tencent.mobileqq.troop.activity.TroopBarPublishLocationSelectActivity.2.2;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.widget.ListView;

public class beyy
  implements bldp
{
  public beyy(TroopBarPublishLocationSelectActivity paramTroopBarPublishLocationSelectActivity) {}
  
  public void onNotCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    paramView = (PullRefreshHeader)paramView;
    if (this.a.jdField_a_of_type_Long == 0L) {}
    for (long l = System.currentTimeMillis();; l = this.a.jdField_a_of_type_Long)
    {
      paramView.c(l);
      return;
    }
  }
  
  public void onViewCompleteVisable(int paramInt, View paramView, ListView paramListView)
  {
    paramView = (PullRefreshHeader)paramView;
    if (this.a.jdField_a_of_type_Long == 0L) {}
    for (long l = System.currentTimeMillis();; l = this.a.jdField_a_of_type_Long)
    {
      paramView.b(l);
      return;
    }
  }
  
  public boolean onViewCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView)
  {
    paramListView = (PullRefreshHeader)paramView;
    long l;
    if (this.a.jdField_a_of_type_Long == 0L)
    {
      l = System.currentTimeMillis();
      paramListView.a(l);
      if (!NetworkUtil.isNetworkAvailable(this.a.getActivity())) {
        break label97;
      }
      this.a.a(0, true);
      this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(new TroopBarPublishLocationSelectActivity.2.1(this), 300L);
    }
    for (;;)
    {
      ((ajje)paramView.getTag()).a = true;
      return true;
      l = this.a.jdField_a_of_type_Long;
      break;
      label97:
      this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(new TroopBarPublishLocationSelectActivity.2.2(this), 300L);
    }
  }
  
  public void onViewNotCompleteVisableAndReleased(int paramInt, View paramView, ListView paramListView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beyy
 * JD-Core Version:    0.7.0.1
 */
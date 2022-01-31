import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.troop.activity.TroopBarPublishLocationSelectActivity;
import com.tencent.mobileqq.troop.activity.TroopBarPublishLocationSelectActivity.2.1;
import com.tencent.mobileqq.troop.activity.TroopBarPublishLocationSelectActivity.2.2;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.widget.ListView;

public class bbfj
  implements bhuy
{
  public bbfj(TroopBarPublishLocationSelectActivity paramTroopBarPublishLocationSelectActivity) {}
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    paramView = (PullRefreshHeader)paramView;
    if (this.a.jdField_a_of_type_Long == 0L) {}
    for (long l = System.currentTimeMillis();; l = this.a.jdField_a_of_type_Long)
    {
      paramView.c(l);
      return;
    }
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    paramListView = (PullRefreshHeader)paramView;
    long l;
    if (this.a.jdField_a_of_type_Long == 0L)
    {
      l = System.currentTimeMillis();
      paramListView.a(l);
      if (!bdee.g(this.a.getActivity())) {
        break label97;
      }
      this.a.a(0, true);
      this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(new TroopBarPublishLocationSelectActivity.2.1(this), 300L);
    }
    for (;;)
    {
      ((acmr)paramView.getTag()).a = true;
      return true;
      l = this.a.jdField_a_of_type_Long;
      break;
      label97:
      this.a.jdField_a_of_type_AndroidOsHandler.postDelayed(new TroopBarPublishLocationSelectActivity.2.2(this), 300L);
    }
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    paramView = (PullRefreshHeader)paramView;
    if (this.a.jdField_a_of_type_Long == 0L) {}
    for (long l = System.currentTimeMillis();; l = this.a.jdField_a_of_type_Long)
    {
      paramView.b(l);
      return;
    }
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbfj
 * JD-Core Version:    0.7.0.1
 */
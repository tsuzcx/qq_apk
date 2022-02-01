import SummaryCard.CondFitUser;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.conditionsearch.SearchResultActivity;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import java.util.List;

public class aqua
  implements ansf
{
  public aqua(SearchResultActivity paramSearchResultActivity) {}
  
  public void a(boolean paramBoolean1, List<CondFitUser> paramList, boolean paramBoolean2, int paramInt)
  {
    int i = 1;
    if (paramInt == 3) {
      if (!paramBoolean1)
      {
        this.a.b = 3;
        this.a.jdField_a_of_type_Aqub.notifyDataSetChanged();
      }
    }
    while (paramInt != 2)
    {
      return;
      if ((paramList != null) && (!paramList.isEmpty())) {
        this.a.jdField_a_of_type_JavaUtilList.addAll(paramList);
      }
      paramList = this.a;
      if (paramBoolean2) {}
      for (paramInt = i;; paramInt = 0)
      {
        paramList.b = paramInt;
        break;
      }
    }
    if (paramBoolean1)
    {
      bhbr.a(true);
      if ((paramList != null) && (!paramList.isEmpty()))
      {
        this.a.jdField_a_of_type_JavaUtilList.clear();
        this.a.jdField_a_of_type_JavaUtilList.addAll(paramList);
      }
      this.a.jdField_a_of_type_Aqub.notifyDataSetChanged();
      bhbr.a(false);
      SearchResultActivity.a(this.a).a(0);
      paramList = Message.obtain();
      paramList.what = 5;
      SearchResultActivity.a(this.a).sendMessageDelayed(paramList, 1000L);
      return;
    }
    SearchResultActivity.a(this.a).a(1);
    paramList = Message.obtain();
    paramList.what = 4;
    SearchResultActivity.a(this.a).sendMessageDelayed(paramList, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqua
 * JD-Core Version:    0.7.0.1
 */
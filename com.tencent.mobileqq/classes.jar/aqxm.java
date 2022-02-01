import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.tencent.mobileqq.conditionsearch.SearchResultActivity;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.widget.ListView;

public class aqxm
  implements blnt
{
  public aqxm(SearchResultActivity paramSearchResultActivity) {}
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    SearchResultActivity.a(this.a).c(SearchResultActivity.a(this.a));
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    SearchResultActivity.a(this.a).a(SearchResultActivity.a(this.a));
    if (bhnv.d(this.a)) {
      SearchResultActivity.c(this.a);
    }
    for (;;)
    {
      SearchResultActivity.a(this.a, System.currentTimeMillis());
      return true;
      SearchResultActivity.a(this.a).a(1);
      paramView = Message.obtain();
      paramView.what = 3;
      SearchResultActivity.a(this.a).sendMessageDelayed(paramView, 1000L);
    }
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    SearchResultActivity.a(this.a).b(SearchResultActivity.a(this.a));
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqxm
 * JD-Core Version:    0.7.0.1
 */
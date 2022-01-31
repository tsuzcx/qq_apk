import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.SearchHistory;
import com.tencent.mobileqq.search.HistorySearchEntryModel.2.1;
import java.util.List;

public class aycx
  implements View.OnClickListener
{
  aycx(aycv paramaycv) {}
  
  public void onClick(View paramView)
  {
    long l = ((Long)paramView.getTag(-1)).longValue();
    int i = aycv.a(this.a, this.a.a, l);
    if (i == -1) {}
    do
    {
      return;
      paramView = (SearchHistory)((aydi)this.a.a.get(i)).a();
    } while (paramView == null);
    ayrd.a("home_page", "del_history", new String[] { "" + i });
    ThreadManager.postImmediately(new HistorySearchEntryModel.2.1(this, paramView, l), null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aycx
 * JD-Core Version:    0.7.0.1
 */
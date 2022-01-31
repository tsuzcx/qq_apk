import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.SearchHistory;
import com.tencent.mobileqq.search.HistorySearchEntryModel.2.1;
import java.util.List;

public class awht
  implements View.OnClickListener
{
  awht(awhr paramawhr) {}
  
  public void onClick(View paramView)
  {
    long l = ((Long)paramView.getTag(-1)).longValue();
    int i = awhr.a(this.a, this.a.a, l);
    if (i == -1) {}
    do
    {
      return;
      paramView = (SearchHistory)((awii)this.a.a.get(i)).a();
    } while (paramView == null);
    awwa.a("home_page", "del_history", new String[] { "" + i });
    ThreadManager.postImmediately(new HistorySearchEntryModel.2.1(this, paramView, l), null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awht
 * JD-Core Version:    0.7.0.1
 */
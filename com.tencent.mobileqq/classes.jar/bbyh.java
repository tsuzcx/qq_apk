import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.SearchHistory;
import com.tencent.mobileqq.search.HistorySearchEntryModel.2.1;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class bbyh
  implements View.OnClickListener
{
  bbyh(bbyf parambbyf) {}
  
  public void onClick(View paramView)
  {
    long l = ((Long)paramView.getTag(-1)).longValue();
    int i = bbyf.a(this.a, this.a.a, l);
    if (i == -1) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      SearchHistory localSearchHistory = (SearchHistory)((bbzf)this.a.a.get(i)).a();
      if (localSearchHistory != null)
      {
        bcni.a("home_page", "del_history", new String[] { "" + i });
        ThreadManager.postImmediately(new HistorySearchEntryModel.2.1(this, localSearchHistory, l), null, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbyh
 * JD-Core Version:    0.7.0.1
 */
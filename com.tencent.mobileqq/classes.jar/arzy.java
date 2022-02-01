import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class arzy
  implements View.OnClickListener
{
  public arzy(QfileBaseRecentFileTabView paramQfileBaseRecentFileTabView) {}
  
  public void onClick(View paramView)
  {
    this.a.c.setVisibility(8);
    aqkl.a().a("");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arzy
 * JD-Core Version:    0.7.0.1
 */
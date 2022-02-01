import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentPicFileTabView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class asau
  implements View.OnClickListener
{
  public asau(QfileRecentPicFileTabView paramQfileRecentPicFileTabView) {}
  
  public void onClick(View paramView)
  {
    QfileRecentPicFileTabView.a(this.a, paramView, false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asau
 * JD-Core Version:    0.7.0.1
 */
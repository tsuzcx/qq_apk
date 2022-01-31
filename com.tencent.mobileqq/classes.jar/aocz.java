import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentPicFileTabView;

public class aocz
  implements View.OnClickListener
{
  public aocz(QfileRecentPicFileTabView paramQfileRecentPicFileTabView) {}
  
  public void onClick(View paramView)
  {
    QfileRecentPicFileTabView.a(this.a, paramView, true);
    paramView.sendAccessibilityEvent(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aocz
 * JD-Core Version:    0.7.0.1
 */
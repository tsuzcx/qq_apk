import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileCloudFileTabView;

public class aqot
  implements View.OnClickListener
{
  public aqot(QfileCloudFileTabView paramQfileCloudFileTabView) {}
  
  public void onClick(View paramView)
  {
    QfileCloudFileTabView.a(this.a, paramView, true);
    paramView.sendAccessibilityEvent(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqot
 * JD-Core Version:    0.7.0.1
 */
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileCloudFileTabView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class arxg
  implements View.OnClickListener
{
  public arxg(QfileCloudFileTabView paramQfileCloudFileTabView) {}
  
  public void onClick(View paramView)
  {
    QfileCloudFileTabView.a(this.a, paramView, true);
    paramView.sendAccessibilityEvent(8);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arxg
 * JD-Core Version:    0.7.0.1
 */
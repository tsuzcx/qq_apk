import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileCloudFileTabView;

public class aorh
  implements View.OnClickListener
{
  public aorh(QfileCloudFileTabView paramQfileCloudFileTabView) {}
  
  public void onClick(View paramView)
  {
    QfileCloudFileTabView.a(this.a, paramView, true);
    paramView.sendAccessibilityEvent(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aorh
 * JD-Core Version:    0.7.0.1
 */
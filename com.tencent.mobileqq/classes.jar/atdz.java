import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFilePicTabView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class atdz
  implements View.OnClickListener
{
  public atdz(QfileLocalFilePicTabView paramQfileLocalFilePicTabView) {}
  
  public void onClick(View paramView)
  {
    QfileLocalFilePicTabView.a(this.a, paramView, true);
    paramView.sendAccessibilityEvent(8);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atdz
 * JD-Core Version:    0.7.0.1
 */
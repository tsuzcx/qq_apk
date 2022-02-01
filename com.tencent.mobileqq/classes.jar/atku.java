import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.cloudfile.QfileCloudFileTabView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class atku
  implements View.OnClickListener
{
  atku(atkt paramatkt) {}
  
  public void onClick(View paramView)
  {
    QfileCloudFileTabView.a(this.a.a, false);
    this.a.a.h();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atku
 * JD-Core Version:    0.7.0.1
 */
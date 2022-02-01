import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileBaseLocalFileTabView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class atmu
  implements View.OnClickListener
{
  public atmu(QfileBaseLocalFileTabView paramQfileBaseLocalFileTabView) {}
  
  public void onClick(View paramView)
  {
    this.a.h();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atmu
 * JD-Core Version:    0.7.0.1
 */
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFilePicTabView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class atdy
  implements View.OnClickListener
{
  public atdy(QfileLocalFilePicTabView paramQfileLocalFilePicTabView) {}
  
  public void onClick(View paramView)
  {
    QfileLocalFilePicTabView.a(this.a, paramView, false);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atdy
 * JD-Core Version:    0.7.0.1
 */
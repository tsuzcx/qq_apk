import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QzoneVerticalVideoDownloadActivity;

public class blus
  implements View.OnClickListener
{
  public blus(QzoneVerticalVideoDownloadActivity paramQzoneVerticalVideoDownloadActivity) {}
  
  public void onClick(View paramView)
  {
    if (!QzoneVerticalVideoDownloadActivity.access$200(this.a))
    {
      QzoneVerticalVideoDownloadActivity.access$300(this.a, false, false);
      QzoneVerticalVideoDownloadActivity.access$400(this.a);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blus
 * JD-Core Version:    0.7.0.1
 */
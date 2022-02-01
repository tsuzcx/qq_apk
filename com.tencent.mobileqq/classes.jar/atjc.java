import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class atjc
  implements View.OnClickListener
{
  public atjc(UniformDownloadActivity paramUniformDownloadActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.finish();
    this.a.overridePendingTransition(0, 0);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atjc
 * JD-Core Version:    0.7.0.1
 */
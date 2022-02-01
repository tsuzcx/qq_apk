import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.open.filedownload.ApkFileDownloadFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bjyq
  implements View.OnClickListener
{
  public bjyq(ApkFileDownloadFragment paramApkFileDownloadFragment) {}
  
  public void onClick(View paramView)
  {
    ApkFileDownloadFragment.a(this.a, true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjyq
 * JD-Core Version:    0.7.0.1
 */
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.open.filedownload.ApkFileDownloadFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bidy
  implements View.OnClickListener
{
  public bidy(ApkFileDownloadFragment paramApkFileDownloadFragment) {}
  
  public void onClick(View paramView)
  {
    ApkFileDownloadFragment.a(this.a, true);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bidy
 * JD-Core Version:    0.7.0.1
 */
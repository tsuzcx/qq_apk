import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.open.filedownload.ApkFileDownloadFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bidv
  implements View.OnClickListener
{
  public bidv(ApkFileDownloadFragment paramApkFileDownloadFragment) {}
  
  public void onClick(View paramView)
  {
    bhzd.b(bhzf.a().a("200").k(ApkFileDownloadFragment.a(this.a).b).j("1").l("0").m(ApkFileDownloadFragment.a(this.a).a).a(ApkFileDownloadFragment.a(this.a).h).b(ApkFileDownloadFragment.a(this.a).f).g(ApkFileDownloadFragment.a(this.a).e));
    ApkFileDownloadFragment.a(this.a).finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bidv
 * JD-Core Version:    0.7.0.1
 */
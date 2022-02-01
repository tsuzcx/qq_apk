import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.bigbrother.RockDownloader.RockDownloadListener;
import com.tencent.mobileqq.bigbrother.RockDownloader.RockDownloaderTask;
import com.tencent.mobileqq.data.RockDownloadInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import java.util.ArrayList;
import javax.annotation.Nonnull;

public class apdf
{
  @android.support.annotation.Nullable
  public static ArrayList<RockDownloadInfo> a(@NonNull RockDownloadInfo paramRockDownloadInfo)
  {
    RockDownloaderTask localRockDownloaderTask = new RockDownloaderTask();
    localRockDownloaderTask.setDownloadInfo(paramRockDownloadInfo);
    localRockDownloaderTask.setTaskCheckLevel(1);
    localRockDownloaderTask.setRuntime(BaseApplicationImpl.getApplication().getRuntime());
    return apda.a(localRockDownloaderTask);
  }
  
  public static void a(@Nonnull RockDownloadInfo paramRockDownloadInfo, @javax.annotation.Nullable apcz paramapcz)
  {
    RockDownloaderTask localRockDownloaderTask = new RockDownloaderTask();
    localRockDownloaderTask.setDownloadInfo(paramRockDownloadInfo);
    localRockDownloaderTask.setTaskCheckLevel(1);
    localRockDownloaderTask.setRuntime(BaseApplicationImpl.getApplication().getRuntime());
    localRockDownloaderTask.setQueryAPKListener(paramapcz);
    apda.b(localRockDownloaderTask);
  }
  
  public static void a(@Nonnull RockDownloadInfo paramRockDownloadInfo, @javax.annotation.Nullable RockDownloadListener paramRockDownloadListener)
  {
    if (!NetworkUtil.isWifiEnabled(BaseApplicationImpl.context))
    {
      if (paramRockDownloadListener != null)
      {
        paramRockDownloadListener.onDownloadFail(paramRockDownloadInfo, amtj.a(2131712605), 10009);
        paramRockDownloadListener.onDownloadFinish(paramRockDownloadInfo);
      }
      return;
    }
    RockDownloaderTask localRockDownloaderTask = new RockDownloaderTask();
    localRockDownloaderTask.setDownloadInfo(paramRockDownloadInfo);
    localRockDownloaderTask.setTaskCheckLevel(1);
    localRockDownloaderTask.setRuntime(BaseApplicationImpl.getApplication().getRuntime());
    localRockDownloaderTask.setRockDownloadListener(paramRockDownloadListener);
    apda.a(localRockDownloaderTask);
  }
  
  public static boolean a(@Nonnull RockDownloadInfo paramRockDownloadInfo)
  {
    RockDownloaderTask localRockDownloaderTask = new RockDownloaderTask();
    localRockDownloaderTask.setDownloadInfo(paramRockDownloadInfo);
    localRockDownloaderTask.setTaskCheckLevel(1);
    localRockDownloaderTask.setRuntime(BaseApplicationImpl.getApplication().getRuntime());
    return apda.b(localRockDownloaderTask);
  }
  
  public static boolean b(@Nonnull RockDownloadInfo paramRockDownloadInfo)
  {
    RockDownloaderTask localRockDownloaderTask = new RockDownloaderTask();
    localRockDownloaderTask.setDownloadInfo(paramRockDownloadInfo);
    localRockDownloaderTask.setTaskCheckLevel(1);
    localRockDownloaderTask.setRuntime(BaseApplicationImpl.getApplication().getRuntime());
    return apda.a(localRockDownloaderTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apdf
 * JD-Core Version:    0.7.0.1
 */
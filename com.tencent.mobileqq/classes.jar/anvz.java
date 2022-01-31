import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.bigbrother.RockDownloader.RockDownloadListener;
import com.tencent.mobileqq.bigbrother.RockDownloader.RockDownloaderTask;
import com.tencent.mobileqq.data.RockDownloadInfo;
import java.util.ArrayList;
import javax.annotation.Nonnull;

public class anvz
{
  @android.support.annotation.Nullable
  public static ArrayList<RockDownloadInfo> a(@NonNull RockDownloadInfo paramRockDownloadInfo)
  {
    RockDownloaderTask localRockDownloaderTask = new RockDownloaderTask();
    localRockDownloaderTask.setDownloadInfo(paramRockDownloadInfo);
    localRockDownloaderTask.setTaskCheckLevel(1);
    localRockDownloaderTask.setRuntime(BaseApplicationImpl.getApplication().getRuntime());
    return anvu.a(localRockDownloaderTask);
  }
  
  public static void a(@Nonnull RockDownloadInfo paramRockDownloadInfo, @javax.annotation.Nullable anvt paramanvt)
  {
    RockDownloaderTask localRockDownloaderTask = new RockDownloaderTask();
    localRockDownloaderTask.setDownloadInfo(paramRockDownloadInfo);
    localRockDownloaderTask.setTaskCheckLevel(1);
    localRockDownloaderTask.setRuntime(BaseApplicationImpl.getApplication().getRuntime());
    localRockDownloaderTask.setQueryAPKListener(paramanvt);
    anvu.b(localRockDownloaderTask);
  }
  
  public static void a(@Nonnull RockDownloadInfo paramRockDownloadInfo, @javax.annotation.Nullable RockDownloadListener paramRockDownloadListener)
  {
    if (!bdin.a(BaseApplicationImpl.context))
    {
      if (paramRockDownloadListener != null)
      {
        paramRockDownloadListener.onDownloadFail(paramRockDownloadInfo, alud.a(2131713885), 10009);
        paramRockDownloadListener.onDownloadFinish(paramRockDownloadInfo);
      }
      return;
    }
    RockDownloaderTask localRockDownloaderTask = new RockDownloaderTask();
    localRockDownloaderTask.setDownloadInfo(paramRockDownloadInfo);
    localRockDownloaderTask.setTaskCheckLevel(1);
    localRockDownloaderTask.setRuntime(BaseApplicationImpl.getApplication().getRuntime());
    localRockDownloaderTask.setRockDownloadListener(paramRockDownloadListener);
    anvu.a(localRockDownloaderTask);
  }
  
  public static boolean a(@Nonnull RockDownloadInfo paramRockDownloadInfo)
  {
    RockDownloaderTask localRockDownloaderTask = new RockDownloaderTask();
    localRockDownloaderTask.setDownloadInfo(paramRockDownloadInfo);
    localRockDownloaderTask.setTaskCheckLevel(1);
    localRockDownloaderTask.setRuntime(BaseApplicationImpl.getApplication().getRuntime());
    return anvu.b(localRockDownloaderTask);
  }
  
  public static boolean b(@Nonnull RockDownloadInfo paramRockDownloadInfo)
  {
    RockDownloaderTask localRockDownloaderTask = new RockDownloaderTask();
    localRockDownloaderTask.setDownloadInfo(paramRockDownloadInfo);
    localRockDownloaderTask.setTaskCheckLevel(1);
    localRockDownloaderTask.setRuntime(BaseApplicationImpl.getApplication().getRuntime());
    return anvu.a(localRockDownloaderTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anvz
 * JD-Core Version:    0.7.0.1
 */
import com.tencent.hlyyb.downloader.Downloader;
import com.tencent.hlyyb.downloader.DownloaderTask;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class aqnq
  implements aqno
{
  aqnq(aqnp paramaqnp) {}
  
  public void a(DownloaderTask paramDownloaderTask)
  {
    QLog.e("DownloadManager_Now_for_qq", 4, "onTaskCompleted----DOWNLOAD_SUCCESS, filePath = " + paramDownloaderTask.getSavePath() + "url = " + paramDownloaderTask.getUrl());
    if (aqnp.a(this.a) != null) {
      aqnp.a(this.a).deleteTask(paramDownloaderTask, false);
    }
    if ((aqnp.a(this.a) != null) && (aqnp.a(this.a).containsKey(paramDownloaderTask.getUrl())) && (aqnp.a(this.a).get(paramDownloaderTask.getUrl()) != null)) {
      ((aqnn)aqnp.a(this.a).get(paramDownloaderTask.getUrl())).a();
    }
    if (this.a.a.containsKey(paramDownloaderTask.getUrl())) {
      this.a.a.remove(paramDownloaderTask.getUrl());
    }
    if (this.a.a.size() > 0)
    {
      QLog.e("DownloadManager_Now_for_qq", 4, "从列表中获取下一个待下载任务----url: " + paramDownloaderTask.getUrl() + " path = " + paramDownloaderTask.getSaveDir());
      paramDownloaderTask = this.a.a.entrySet().iterator();
      while (paramDownloaderTask.hasNext())
      {
        aqnr localaqnr = (aqnr)((Map.Entry)paramDownloaderTask.next()).getValue();
        if (localaqnr != null) {
          this.a.b(localaqnr);
        }
      }
    }
  }
  
  public void b(DownloaderTask paramDownloaderTask)
  {
    QLog.e("DownloadManager_Now_for_qq", 4, "onTaskDetected----url: " + paramDownloaderTask.getUrl() + " path = " + paramDownloaderTask.getSaveDir());
  }
  
  public void c(DownloaderTask paramDownloaderTask)
  {
    QLog.e("DownloadManager_Now_for_qq", 4, "onTaskFailed----DOWNLOAD_FAILED");
    if (aqnp.a(this.a) != null) {
      aqnp.a(this.a).deleteTask(paramDownloaderTask, false);
    }
    if ((aqnp.a(this.a) != null) && (aqnp.a(this.a).containsKey(paramDownloaderTask.getUrl())) && (aqnp.a(this.a).get(paramDownloaderTask.getUrl()) != null)) {
      ((aqnn)aqnp.a(this.a).get(paramDownloaderTask.getUrl())).a(paramDownloaderTask.getFailCode(), paramDownloaderTask.getFailCode(), "failed");
    }
  }
  
  public void d(DownloaderTask paramDownloaderTask)
  {
    QLog.e("DownloadManager_Now_for_qq", 4, "onTaskPending----url: " + paramDownloaderTask.getUrl() + " path = " + paramDownloaderTask.getSaveDir());
  }
  
  public void e(DownloaderTask paramDownloaderTask)
  {
    QLog.e("DownloadManager_Now_for_qq", 4, "onTaskStarted----url: " + paramDownloaderTask.getUrl() + " path = " + paramDownloaderTask.getSaveDir());
  }
  
  public void f(DownloaderTask paramDownloaderTask)
  {
    QLog.e("DownloadManager_Now_for_qq", 4, "onTaskReceived----percent: " + paramDownloaderTask.getPercentage() + "url = " + paramDownloaderTask.getUrl());
    if ((aqnp.a(this.a) != null) && (aqnp.a(this.a).containsKey(paramDownloaderTask.getUrl())) && (aqnp.a(this.a).get(paramDownloaderTask.getUrl()) != null)) {
      ((aqnn)aqnp.a(this.a).get(paramDownloaderTask.getUrl())).a(paramDownloaderTask.getReceivedLength(), paramDownloaderTask.getTotalLength(), paramDownloaderTask.getPercentage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     aqnq
 * JD-Core Version:    0.7.0.1
 */
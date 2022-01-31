import com.tencent.hlyyb.downloader.Downloader;
import com.tencent.hlyyb.downloader.DownloaderTask;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class arhx
  implements arhv
{
  arhx(arhw paramarhw) {}
  
  public void a(DownloaderTask paramDownloaderTask)
  {
    QLog.d("DownloadManager_Now_for_qq", 1, String.format("onTaskCompleted url=%s filePath=%s", new Object[] { paramDownloaderTask.getUrl(), paramDownloaderTask.getSavePath() }));
    if (arhw.a(this.a) != null) {
      arhw.a(this.a).deleteTask(paramDownloaderTask, false);
    }
    if ((arhw.a(this.a) != null) && (arhw.a(this.a).containsKey(paramDownloaderTask.getUrl())) && (arhw.a(this.a).get(paramDownloaderTask.getUrl()) != null)) {
      ((arhu)arhw.a(this.a).get(paramDownloaderTask.getUrl())).a();
    }
    arhw.a(this.a, paramDownloaderTask.getUrl());
  }
  
  public void b(DownloaderTask paramDownloaderTask)
  {
    QLog.d("DownloadManager_Now_for_qq", 1, String.format("onTaskDetected url=%s filePath=%s", new Object[] { paramDownloaderTask.getUrl(), paramDownloaderTask.getSaveDir() }));
  }
  
  public void c(DownloaderTask paramDownloaderTask)
  {
    QLog.e("DownloadManager_Now_for_qq", 1, String.format("onTaskFailed url=%s failCode=%s failInfo=%s", new Object[] { paramDownloaderTask.getUrl(), Integer.valueOf(paramDownloaderTask.getFailCode()), paramDownloaderTask.getFailInfo() }));
    if (arhw.a(this.a) != null) {
      arhw.a(this.a).deleteTask(paramDownloaderTask, false);
    }
    if ((arhw.a(this.a) != null) && (arhw.a(this.a).containsKey(paramDownloaderTask.getUrl())) && (arhw.a(this.a).get(paramDownloaderTask.getUrl()) != null)) {
      ((arhu)arhw.a(this.a).get(paramDownloaderTask.getUrl())).a(paramDownloaderTask.getFailCode(), paramDownloaderTask.getFailCode(), "failed");
    }
    arhw.a(this.a, paramDownloaderTask.getUrl());
  }
  
  public void d(DownloaderTask paramDownloaderTask)
  {
    QLog.d("DownloadManager_Now_for_qq", 1, String.format("onTaskPending url=%s filePath=%s", new Object[] { paramDownloaderTask.getUrl(), paramDownloaderTask.getSaveDir() }));
  }
  
  public void e(DownloaderTask paramDownloaderTask)
  {
    QLog.d("DownloadManager_Now_for_qq", 1, String.format("onTaskStarted url=%s filePath=%s", new Object[] { paramDownloaderTask.getUrl(), paramDownloaderTask.getSaveDir() }));
  }
  
  public void f(DownloaderTask paramDownloaderTask)
  {
    QLog.d("DownloadManager_Now_for_qq", 1, String.format("onTaskReceived url=%s percent=%s", new Object[] { paramDownloaderTask.getUrl(), Integer.valueOf(paramDownloaderTask.getPercentage()) }));
    if ((arhw.a(this.a) != null) && (arhw.a(this.a).containsKey(paramDownloaderTask.getUrl())) && (arhw.a(this.a).get(paramDownloaderTask.getUrl()) != null)) {
      ((arhu)arhw.a(this.a).get(paramDownloaderTask.getUrl())).a(paramDownloaderTask.getReceivedLength(), paramDownloaderTask.getTotalLength(), paramDownloaderTask.getPercentage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     arhx
 * JD-Core Version:    0.7.0.1
 */
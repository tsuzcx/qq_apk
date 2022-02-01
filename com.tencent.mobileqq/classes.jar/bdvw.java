import com.tencent.hlyyb.downloader.Downloader;
import com.tencent.hlyyb.downloader.DownloaderTask;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class bdvw
  implements bdvu
{
  bdvw(bdvv parambdvv) {}
  
  public void a(DownloaderTask paramDownloaderTask)
  {
    QLog.d("DownloadManager_Now_for_qq", 1, String.format("onTaskCompleted url=%s filePath=%s", new Object[] { paramDownloaderTask.getUrl(), paramDownloaderTask.getSavePath() }));
    if (bdvv.a(this.a) != null) {
      bdvv.a(this.a).deleteTask(paramDownloaderTask, false);
    }
    if ((bdvv.a(this.a) != null) && (bdvv.a(this.a).containsKey(paramDownloaderTask.getUrl())) && (bdvv.a(this.a).get(paramDownloaderTask.getUrl()) != null)) {
      ((bdvt)bdvv.a(this.a).get(paramDownloaderTask.getUrl())).a();
    }
    bdvv.a(this.a, paramDownloaderTask.getUrl());
  }
  
  public void b(DownloaderTask paramDownloaderTask)
  {
    QLog.d("DownloadManager_Now_for_qq", 1, String.format("onTaskDetected url=%s filePath=%s", new Object[] { paramDownloaderTask.getUrl(), paramDownloaderTask.getSaveDir() }));
  }
  
  public void c(DownloaderTask paramDownloaderTask)
  {
    QLog.e("DownloadManager_Now_for_qq", 1, String.format("onTaskFailed url=%s failCode=%s failInfo=%s", new Object[] { paramDownloaderTask.getUrl(), Integer.valueOf(paramDownloaderTask.getFailCode()), paramDownloaderTask.getFailInfo() }));
    if (bdvv.a(this.a) != null) {
      bdvv.a(this.a).deleteTask(paramDownloaderTask, false);
    }
    if ((bdvv.a(this.a) != null) && (bdvv.a(this.a).containsKey(paramDownloaderTask.getUrl())) && (bdvv.a(this.a).get(paramDownloaderTask.getUrl()) != null)) {
      ((bdvt)bdvv.a(this.a).get(paramDownloaderTask.getUrl())).a(paramDownloaderTask.getFailCode(), paramDownloaderTask.getFailCode(), "failed");
    }
    bdvv.a(this.a, paramDownloaderTask.getUrl());
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
    if ((bdvv.a(this.a) != null) && (bdvv.a(this.a).containsKey(paramDownloaderTask.getUrl())) && (bdvv.a(this.a).get(paramDownloaderTask.getUrl()) != null)) {
      ((bdvt)bdvv.a(this.a).get(paramDownloaderTask.getUrl())).a(paramDownloaderTask.getReceivedLength(), paramDownloaderTask.getTotalLength(), paramDownloaderTask.getPercentage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdvw
 * JD-Core Version:    0.7.0.1
 */
import com.tencent.hlyyb.downloader.DownloaderTask;
import com.tencent.hlyyb.downloader.DownloaderTaskListener;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.intervideo.now.DownloadEngine.DownloadTaskListenerBridge.1;
import mqq.os.MqqHandler;

public class asyh
  implements DownloaderTaskListener
{
  private asyj a;
  
  public asyh(asyj paramasyj)
  {
    this.a = paramasyj;
  }
  
  public void a()
  {
    this.a = null;
  }
  
  public void onTaskCompletedMainloop(DownloaderTask paramDownloaderTask)
  {
    if (this.a != null) {
      this.a.a(paramDownloaderTask);
    }
  }
  
  public void onTaskCompletedSubloop(DownloaderTask paramDownloaderTask) {}
  
  public void onTaskDetectedMainloop(DownloaderTask paramDownloaderTask)
  {
    if (this.a != null) {
      this.a.b(paramDownloaderTask);
    }
  }
  
  public void onTaskDetectedSubloop(DownloaderTask paramDownloaderTask) {}
  
  public void onTaskFailedMainloop(DownloaderTask paramDownloaderTask)
  {
    ThreadManager.getSubThreadHandler().post(new DownloadTaskListenerBridge.1(this, paramDownloaderTask));
  }
  
  public void onTaskFailedSubloop(DownloaderTask paramDownloaderTask) {}
  
  public void onTaskPausedMainloop(DownloaderTask paramDownloaderTask) {}
  
  public void onTaskPausedSubloop(DownloaderTask paramDownloaderTask) {}
  
  public void onTaskPendingMainloop(DownloaderTask paramDownloaderTask)
  {
    if (this.a != null) {
      this.a.d(paramDownloaderTask);
    }
  }
  
  public void onTaskReceivedMainloop(DownloaderTask paramDownloaderTask)
  {
    if (this.a != null) {
      this.a.f(paramDownloaderTask);
    }
  }
  
  public void onTaskReceivedSubloop(DownloaderTask paramDownloaderTask) {}
  
  public void onTaskStartedMainloop(DownloaderTask paramDownloaderTask)
  {
    if (this.a != null) {
      this.a.e(paramDownloaderTask);
    }
  }
  
  public void onTaskStartedSubloop(DownloaderTask paramDownloaderTask) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asyh
 * JD-Core Version:    0.7.0.1
 */
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.teamwork.TeamWorkForceShare;
import com.tencent.mobileqq.teamwork.TeamWorkForceShare.ImageRequestTask;
import com.tencent.qphone.base.util.QLog;

public class ayff
  implements URLDrawableHandler
{
  public ayff(TeamWorkForceShare.ImageRequestTask paramImageRequestTask) {}
  
  public void doCancel() {}
  
  public boolean isCancelled()
  {
    return false;
  }
  
  public void onFileDownloadFailed(int paramInt)
  {
    QLog.d(TeamWorkForceShare.a(), 1, "download failed, code = " + paramInt + ", url = " + TeamWorkForceShare.ImageRequestTask.a(this.a));
    TeamWorkForceShare.ImageRequestTask.a(this.a, true);
  }
  
  public void onFileDownloadStarted()
  {
    QLog.d(TeamWorkForceShare.a(), 1, "start download, url = " + TeamWorkForceShare.ImageRequestTask.a(this.a));
  }
  
  public void onFileDownloadSucceed(long paramLong)
  {
    QLog.d(TeamWorkForceShare.a(), 1, "download success, size = " + paramLong + ", url = " + TeamWorkForceShare.ImageRequestTask.a(this.a));
    TeamWorkForceShare.ImageRequestTask.a(this.a, true);
  }
  
  public void publishProgress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     ayff
 * JD-Core Version:    0.7.0.1
 */
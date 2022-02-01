import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.qphone.base.util.QLog;

class bjoa
  implements URLDrawable.DownloadListener
{
  bjoa(bjnw parambjnw) {}
  
  public void onFileDownloadFailed(int paramInt)
  {
    QLog.i("ActionSheet", 1, "onFileDownloadFailed " + paramInt);
  }
  
  public void onFileDownloadStarted()
  {
    QLog.i("ActionSheet", 1, "onFileDownloadStarted");
  }
  
  public void onFileDownloadSucceed(long paramLong)
  {
    QLog.i("ActionSheet", 1, "onFileDownloadSucceed " + paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjoa
 * JD-Core Version:    0.7.0.1
 */
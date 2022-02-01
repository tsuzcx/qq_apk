import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.qphone.base.util.QLog;

class bliv
  implements URLDrawable.DownloadListener
{
  bliv(blir paramblir) {}
  
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
 * Qualified Name:     bliv
 * JD-Core Version:    0.7.0.1
 */
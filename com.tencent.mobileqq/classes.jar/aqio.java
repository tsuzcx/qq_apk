import android.os.Bundle;
import com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity;
import com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity.11.1;
import com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity.11.2;
import com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity.11.3;
import com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity.11.4;
import com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity.11.5;
import com.tencent.mobileqq.filemanager.activity.UniformDownloadActivity.11.6;
import com.tencent.qphone.base.util.QLog;

public class aqio
  implements arpo
{
  public aqio(UniformDownloadActivity paramUniformDownloadActivity) {}
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(UniformDownloadActivity.a, 2, "UniformDownloader onDownloadStart progress = " + paramInt);
    }
    this.a.runOnUiThread(new UniformDownloadActivity.11.2(this));
  }
  
  public void a(int paramInt, String paramString, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(UniformDownloadActivity.a, 2, "UniformDownloader onDownloadFailed errCode = " + paramInt);
    }
    this.a.runOnUiThread(new UniformDownloadActivity.11.6(this));
  }
  
  public void a(String paramString, long paramLong, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(UniformDownloadActivity.a, 2, "UniformDownloader onDownloadSucess ");
    }
    this.a.runOnUiThread(new UniformDownloadActivity.11.1(this));
    azmj.b(null, "dc00898", "", "", "0X8008FFA", "0X8008FFA", 1, 0, "", "", "", "");
  }
  
  public void b(int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(UniformDownloadActivity.a, 2, "UniformDownloader onDownloadProgress progress = " + paramInt);
    }
    this.a.runOnUiThread(new UniformDownloadActivity.11.4(this, paramInt));
  }
  
  public void c(int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(UniformDownloadActivity.a, 2, "UniformDownloader onDownloadPause progress = " + paramInt);
    }
    this.a.runOnUiThread(new UniformDownloadActivity.11.5(this));
  }
  
  public void d(int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d(UniformDownloadActivity.a, 2, "UniformDownloader onDownloadResume progress = " + paramInt);
    }
    this.a.runOnUiThread(new UniformDownloadActivity.11.3(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqio
 * JD-Core Version:    0.7.0.1
 */
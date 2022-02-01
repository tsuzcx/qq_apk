import android.os.Handler;
import com.tencent.image.URLDrawable.DownloadListener;
import com.tencent.mobileqq.nearby.widget.NearbyActivityDialog.2.1;
import com.tencent.mobileqq.nearby.widget.NearbyActivityDialog.2.2;
import com.tencent.qphone.base.util.QLog;

public class aynl
  implements URLDrawable.DownloadListener
{
  aynl(aynk paramaynk) {}
  
  public void onFileDownloadFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyActivityDialog", 2, "loadImage, onFileDownloadFailed");
    }
    this.a.a.post(new NearbyActivityDialog.2.2(this));
  }
  
  public void onFileDownloadStarted()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyActivityDialog", 2, "loadImage, onFileDownloadStarted");
    }
  }
  
  public void onFileDownloadSucceed(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NearbyActivityDialog", 2, "loadImage, onFileDownloadSucceed");
    }
    this.a.a.post(new NearbyActivityDialog.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aynl
 * JD-Core Version:    0.7.0.1
 */